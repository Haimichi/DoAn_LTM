/**    
package test_demo;

    import java.io.*;
    import java.net.*;
    import java.sql.SQLException;
    import java.util.HashMap;
    import java.util.Map;
    import java.util.logging.Level;
    import java.util.logging.Logger;
    import javax.net.ssl.HttpsURLConnection;
    import org.json.JSONArray;
    import org.json.JSONObject;

    public class TCPServer {
        private static Map<String, String> users = new HashMap<>();

        public static void main(String[] args) {
            int port = 8000;
            try (ServerSocket serverSocket = new ServerSocket(port)) {
                System.out.println("Server is listening on port " + port);

                    while (true) {
                        try {
                            Socket socket = serverSocket.accept();  // Chờ client kết nối
                            System.out.println("A new client is connected: " + socket.getInetAddress());                        
                            new ClientHandler(socket).start();
                        } catch (IOException e) {
                            System.err.println("Accept failed: " + e.getMessage());
                        }
                    }
                } catch (IOException e) {
                    System.err.println("Could not listen on port: " + port);
                    e.printStackTrace();
                }
            }

        private static class ClientHandler extends Thread {
            private Socket socket;

            public ClientHandler(Socket socket) {
                this.socket = socket;
            }

            @Override
            public void run() {
                String clientIp = socket.getInetAddress().getHostAddress();  // Lấy địa chỉ IP của client
                SQLServerConnection dbConnection = new SQLServerConnection();  // Giả sử lớp này đã được cấu hình đúng

                try (
                    BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)
                ) {
                    // Chỉ gửi thông báo xin chào khi kết nối thành công
                    System.out.println("Client connected from IP: " + clientIp);

                    String command;
                    while ((command = reader.readLine()) != null) {
                        System.out.println("Command from client: " + command);

                        if (command.equals("LOGIN")) {
                            String username = reader.readLine();  // Nhận tên người dùng
                            String password = reader.readLine();  // Nhận mật khẩu từ client

                            // Kiểm tra tài khoản và mật khẩu từ cơ sở dữ liệu
                            try {
                                boolean isAuthenticated = dbConnection.authenticateUser(username, password);

                                if (isAuthenticated) {
                                    writer.println("Đăng nhập thành công");
                                    System.out.println("Tài khoản: " + username + " từ IP: " + clientIp + " đã đăng nhập.");
                                } else {
                                    writer.println("Tài khoản không tồn tại hoặc mật khẩu không đúng.");
                                }

                            } catch (SQLException e) {
                                writer.println("Lỗi cơ sở dữ liệu. Vui lòng thử lại sau.");
                                System.err.println("Lỗi khi kiểm tra tài khoản trong cơ sở dữ liệu: " + e.getMessage());
                            }
                        } else if (command.equals("TRANSLATE")) {
                            String textToTranslate = reader.readLine();
                            String fromLanguage = reader.readLine();
                            String toLanguage = reader.readLine();
                            String translatedText = callTranslationAPI(textToTranslate, fromLanguage, toLanguage);
                            writer.println(translatedText);
                            System.out.println("Đã xử lý yêu cầu dịch văn bản: " + textToTranslate);
                        } else if (command.equals("LOOKUP_WORD")) {
                            String word = reader.readLine();
                            String wordDefinition = lookupWordFromAPI(word);
                            writer.println(wordDefinition);
                            System.out.println("Đã xử lý yêu cầu tra cứu từ: " + word);
                        }
                    }

                } catch (SocketException e) {
                    System.out.println("Client với IP: " + clientIp + " đã ngắt kết nối.");
                } catch (IOException e) {
                    System.err.println("I/O error occurred: " + e.getMessage());
                } finally {
                    try {
                        if (socket != null && !socket.isClosed()) {
                            socket.close();
                            System.out.println("Connection closed for client at IP: " + clientIp);
                        }
                    } catch (IOException e) {
                        System.err.println("Error closing socket: " + e.getMessage());
                    }
                }
            }
                    // Gọi API tra cứu từ điển
        private String lookupWordFromAPI(String word) {
                    StringBuilder result = new StringBuilder();
                    try {
                        // Create URL for the Dictionary API request
                        String urlStr = "https://api.dictionaryapi.dev/api/v2/entries/en/" + word;
                        URL url = new URL(urlStr);
                        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                        conn.setRequestMethod("GET");
                        conn.connect();

                        int responseCode = conn.getResponseCode();
                        if (responseCode == 200) {
                            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                            String inputLine;
                            StringBuilder content = new StringBuilder();
                            while ((inputLine = in.readLine()) != null) {
                                content.append(inputLine);
                            }
                            in.close();

                            // Print the JSON response for debugging
                            System.out.println("JSON Response: " + content.toString());

                            // Parse the JSON data
                            JSONArray jsonArray = new JSONArray(content.toString());

                            // Check if there are results
                            if (jsonArray.length() > 0) {
                                JSONObject entry = jsonArray.getJSONObject(0);

                                // Get word
                                if (entry.has("word")) {
                                    result.append("Word: ").append(entry.getString("word")).append("\n");
                                }

                                // Get phonetics
                                if (entry.has("phonetics")) {
                                    result.append("Phonetics:\n");
                                    JSONArray phonetics = entry.getJSONArray("phonetics");
                                    for (int i = 0; i < phonetics.length(); i++) {
                                        JSONObject phonetic = phonetics.getJSONObject(i);
                                    }
                                }

                                // Get meanings
                                if (entry.has("meanings")) {
                                    result.append("Meanings:\n");
                                    JSONArray meanings = entry.getJSONArray("meanings");
                                    for (int i = 0; i < meanings.length(); i++) {
                                        JSONObject meaning = meanings.getJSONObject(i);
                                        result.append("  Part of Speech: ").append(meaning.getString("partOfSpeech")).append("\n");

                                        // Get definitions
                                        JSONArray definitions = meaning.getJSONArray("definitions");
                                        for (int j = 0; j < definitions.length(); j++) {
                                            JSONObject definition = definitions.getJSONObject(j);
                                            result.append("    Definition: ").append(definition.getString("definition")).append("\n");

                                            // Get example if available
                                            if (definition.has("example")) {
                                                result.append("    Example: ").append(definition.getString("example")).append("\n");
                                            }

                                            // Get synonyms if available
                                            if (definition.has("synonyms")) {
                                                JSONArray synonyms = definition.getJSONArray("synonyms");
                                                if (synonyms.length() > 0) {
                                                    result.append("    Synonyms: ");
                                                    for (int k = 0; k < synonyms.length(); k++) {
                                                        result.append(synonyms.getString(k)).append(", ");
                                                    }
                                                    result.setLength(result.length() - 2); // Remove the last comma
                                                    result.append("\n");
                                                }
                                            }
                                        }
                                    }
                                }
                            } else {
                                result.append("No definitions found.");
                            }
                        } else {
                            result.append("Unable to find the word.");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        result.append("An error occurred while looking up the word.");
                    }
                    return result.toString();
                }

            private String callTranslationAPI(String textToTranslate, String fromLanguage, String toLanguage) {
                String apiUrl = "https://api-b2b.backenster.com/b1/api/v3/translate";
                String apiKey = "Bearer a_6Moelpp5PLZKX9hGeKubnwyZgEOn8ybO7Sg161f5tBpcTitQlz5JPQ5Sqh6gJFCl5HdTdHHXCGhjQKKE";

                try {
                    // Khởi tạo URL và kết nối HTTPS
                    URL url = new URL(apiUrl);
                    HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
                    conn.setRequestMethod("POST");
                    conn.setRequestProperty("Accept", "application/json");
                    conn.setRequestProperty("Authorization", apiKey);
                    conn.setRequestProperty("Content-Type", "application/json");
                    conn.setDoOutput(true);

                    // Tạo nội dung JSON cho yêu cầu
                    JSONObject jsonInput = new JSONObject();
                    jsonInput.put("from", fromLanguage);
                    jsonInput.put("to", toLanguage);
                    jsonInput.put("data", textToTranslate);
                    jsonInput.put("platform", "api");

                    String jsonInputString = jsonInput.toString();

                    // Gửi yêu cầu POST tới API
                    try (OutputStream os = conn.getOutputStream()) {
                        byte[] input = jsonInputString.getBytes("utf-8");
                        os.write(input, 0, input.length);
                    }

                    // Nhận mã phản hồi từ server
                    int responseCode = conn.getResponseCode();

                    BufferedReader in;
                    if (responseCode >= 200 && responseCode < 300) {
                        // Thành công: nhận phản hồi từ server
                        in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    } else {
                        // Lỗi: nhận thông báo lỗi từ server
                        in = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
                    }

                    String inputLine;
                    StringBuilder response = new StringBuilder();
                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    in.close();

                    // Kiểm tra phản hồi thành công và trả về kết quả
                    if (responseCode >= 200 && responseCode < 300) {
                        JSONObject jsonResponse = new JSONObject(response.toString());
                        if (jsonResponse.has("result")) {
                            return jsonResponse.getString("result");
                        } else {
                            return "Lỗi: Phản hồi không chứa kết quả dịch.";
                        }
                    } else {
                        return "Lỗi: " + responseCode + " - " + response.toString();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    return "Exception: " + e.getMessage();
                }
            }

        }
    }
    * */

package test_demo;

import java.io.*;
import java.net.*;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONArray;
import org.json.JSONObject;

public class TCPServer {
    private static Map<String, String> users = new HashMap<>();
    
    public static void main(String[] args) {
        int port = 8000;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

                while (true) {
                    try {
                        Socket socket = serverSocket.accept();  // Chờ client kết nối
                        System.out.println("A new client is connected: " + socket.getInetAddress());                        
                        new ClientHandler(socket).start();
                    } catch (IOException e) {
                        System.err.println("Accept failed: " + e.getMessage());
                    }
                }
            } catch (IOException e) {
                System.err.println("Could not listen on port: " + port);
                e.printStackTrace();
            }
        }
    
    private static class ClientHandler extends Thread {
        private Socket socket;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
                String username = "";  // Lưu username sau khi đăng nhập            
            String clientIp = socket.getInetAddress().getHostAddress();  // Lấy địa chỉ IP của client
            SQLServerConnection dbConnection = new SQLServerConnection();  // Giả sử lớp này đã được cấu hình đúng

            try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)
            ) {
                // Chỉ gửi thông báo xin chào khi kết nối thành công
                System.out.println("Client connected from IP: " + clientIp);

                String command;

                while ((command = reader.readLine()) != null) {
                    if (command.equals("LOGIN")) {
                        username = reader.readLine();  // Nhận tên người dùng
                        String password = reader.readLine();  // Nhận mật khẩu từ client

                        // Kiểm tra tài khoản và mật khẩu từ cơ sở dữ liệu
                        try {
                            boolean isAuthenticated = dbConnection.authenticateUser(username, password);

                            if (isAuthenticated) {
                                writer.println("Đăng nhập thành công");
                                System.out.println("Tài khoản: " + username + " từ IP: " + clientIp + " đã đăng nhập.");
                            } else {
                                writer.println("Tài khoản không tồn tại hoặc mật khẩu không đúng.");
                            }

                        } catch (SQLException e) {
                            writer.println("Lỗi cơ sở dữ liệu. Vui lòng thử lại sau.");
                            System.err.println("Lỗi khi kiểm tra tài khoản trong cơ sở dữ liệu: " + e.getMessage());
                        }
                    }

                    // Nếu nhận được lệnh TRANSLATE từ client
                    if (command.equals("TRANSLATE")) {
                        System.out.println("[Translate] - Client " + username + " : đã gửi yêu cầu dịch văn bản.");

                        // Nhận thông tin dịch từ client
                        String textToTranslate = reader.readLine();
                        String fromLanguage = reader.readLine();
                        String toLanguage = reader.readLine();

                        // Xử lý dịch văn bản
                        String translatedText = callTranslationAPI(textToTranslate, fromLanguage, toLanguage);
                        writer.println(translatedText);  // Gửi kết quả dịch lại cho client
                    }

                    // Nếu nhận được lệnh LOOKUP_WORD từ client
                    if (command.equals("LOOKUP_WORD")) {
                        System.out.println("[Lookup Word] - Client " + username + " : đã gửi yêu cầu tra cứu từ.");

                        // Nhận từ cần tra cứu từ client
                        String word = reader.readLine();

                        // Xử lý tra cứu từ
                        String wordDefinition = lookupWordFromAPI(word);
                        writer.println(wordDefinition);  // Gửi kết quả tra cứu lại cho client
                    }
                }

            } catch (SocketException e) {
                System.out.println("Client " + username + " với IP: " + clientIp + " đã ngắt kết nối.");
            } catch (IOException e) {
                System.err.println("I/O error occurred: " + e.getMessage());
            } finally {
                try {
                    if (socket != null && !socket.isClosed()) {
                        socket.close();
                        System.out.println("Connection closed for client at IP: " + clientIp);
                    }
                } catch (IOException e) {
                    System.err.println("Error closing socket: " + e.getMessage());
                }
            }
        }

        // Gọi API tra cứu từ điển
        private String lookupWordFromAPI(String word) {
            StringBuilder result = new StringBuilder();
            try {
                // Create URL for the Dictionary API request
                String urlStr = "https://api.dictionaryapi.dev/api/v2/entries/en/" + word;
                URL url = new URL(urlStr);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.connect();

                int responseCode = conn.getResponseCode();
                if (responseCode == 200) {
                    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    String inputLine;
                    StringBuilder content = new StringBuilder();
                    while ((inputLine = in.readLine()) != null) {
                        content.append(inputLine);
                    }
                    in.close();

                    // Parse the JSON data
                    JSONArray jsonArray = new JSONArray(content.toString());
                    if (jsonArray.length() > 0) {
                        JSONObject entry = jsonArray.getJSONObject(0);

                        // Get word
                        if (entry.has("word")) {
                            result.append("Word: ").append(entry.getString("word")).append("\n");
                        }

                        // Get meanings
                        if (entry.has("meanings")) {
                            result.append("Meanings:\n");
                            JSONArray meanings = entry.getJSONArray("meanings");
                            for (int i = 0; i < meanings.length(); i++) {
                                JSONObject meaning = meanings.getJSONObject(i);
                                result.append("  Part of Speech: ").append(meaning.getString("partOfSpeech")).append("\n");

                                // Get definitions
                                JSONArray definitions = meaning.getJSONArray("definitions");
                                for (int j = 0; j < definitions.length(); j++) {
                                    JSONObject definition = definitions.getJSONObject(j);
                                    result.append("    Definition: ").append(definition.getString("definition")).append("\n");
                                }
                            }
                        }
                    } else {
                        result.append("No definitions found.");
                    }
                } else {
                    result.append("Unable to find the word.");
                }
            } catch (Exception e) {
                e.printStackTrace();
                result.append("An error occurred while looking up the word.");
            }
            return result.toString();
        }

        // Gọi API dịch văn bản
        private String callTranslationAPI(String textToTranslate, String fromLanguage, String toLanguage) {
            String apiUrl = "https://api-b2b.backenster.com/b1/api/v3/translate";
            String apiKey = "Bearer a_6Moelpp5PLZKX9hGeKubnwyZgEOn8ybO7Sg161f5tBpcTitQlz5JPQ5Sqh6gJFCl5HdTdHHXCGhjQKKE";

            try {
                URL url = new URL(apiUrl);
                HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Accept", "application/json");
                conn.setRequestProperty("Authorization", apiKey);
                conn.setRequestProperty("Content-Type", "application/json");
                conn.setDoOutput(true);

                JSONObject jsonInput = new JSONObject();
                jsonInput.put("from", fromLanguage);
                jsonInput.put("to", toLanguage);
                jsonInput.put("data", textToTranslate);
                jsonInput.put("platform", "api");

                String jsonInputString = jsonInput.toString();
                try (OutputStream os = conn.getOutputStream()) {
                    byte[] input = jsonInputString.getBytes("utf-8");
                    os.write(input, 0, input.length);
                }

                int responseCode = conn.getResponseCode();

                BufferedReader in;
                if (responseCode >= 200 && responseCode < 300) {
                    in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                } else {
                    in = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
                }

                String inputLine;
                StringBuilder response = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                if (responseCode >= 200 && responseCode < 300) {
                    JSONObject jsonResponse = new JSONObject(response.toString());
                    return jsonResponse.getString("result");
                } else {
                    return "Lỗi: " + responseCode + " - " + response.toString();
                }
            } catch (Exception e) {
                e.printStackTrace();
                return "Exception: " + e.getMessage();
            }
        }
    }
}

