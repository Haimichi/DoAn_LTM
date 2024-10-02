package test_demo;

import java.io.*;
import java.net.*;
import java.util.HashMap;

/**
 *
 * @author ad
 */
public class TCPServer {
    private static HashMap<String, String> users;

    public static void main(String[] args) {
        // Initialize users
        users = new HashMap<>();
        users.put("admin", "password"); // Example user
        users.put("user1", "1234");     // Another example user
        
        int port = 8000; // Update to match the user's input

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            while (true) {
                try {
                    Socket socket = serverSocket.accept();
                    System.out.println("Client is connected: " + socket.getInetAddress());
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

        public void run() {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {

                // Send greeting to client
                writer.println("xin chào");

                // Receive username and password
                String username = reader.readLine();
                String password = reader.readLine();

                // Check login credentials
                if (users.containsKey(username) && users.get(username).equals(password)) {
                    writer.println("success");
                } else {
                    writer.println("failure");
                }

            } catch (SocketException e) {
                System.err.println("Client disconnected unexpectedly: " + e.getMessage());
            } catch (IOException e) {
                System.err.println("I/O error occurred: " + e.getMessage());
            } finally {
                try {
                    if (socket != null && !socket.isClosed()) {
                        socket.close(); // Close socket when done
                        System.out.println("Connection closed for client.");
                    }
                } catch (IOException e) {
                    System.err.println("Error closing socket: " + e.getMessage());
                }
            }
        }
    }
}
