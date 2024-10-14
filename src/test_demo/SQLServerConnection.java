package test_demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author ad
 */
    public class SQLServerConnection {
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=test;encrypt=true;trustServerCertificate=true;";
    private static final String USER = "sa";  
    private static final String PASSWORD = "hai123@";

        public static Connection getConnection() throws SQLException {  
            try {  
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); // Đăng ký driver  
            } catch (ClassNotFoundException e) {  
                e.printStackTrace();  
                throw new SQLException("Driver not found");  
            }  
            return DriverManager.getConnection(URL, USER, PASSWORD);  
        }

        private String hashPassword(String password) {
            try {
                MessageDigest digest = MessageDigest.getInstance("SHA-256");
                byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
                StringBuilder hexString = new StringBuilder();
                for (byte b : hash) {
                    String hex = Integer.toHexString(0xff & b);
                    if (hex.length() == 1) hexString.append('0');
                    hexString.append(hex);
                }
                return hexString.toString();
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }
        
        public boolean registerUser(String username, String fullname, String password, String phoneNumber) {
            String query = "INSERT INTO Users (Username, FullName, PasswordHash, PhoneNumber) VALUES (?, ?, ?, ?)";
            try (Connection conn = getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(query)) {

                pstmt.setString(1, username);
                pstmt.setString(2, fullname);
                pstmt.setString(3, hashPassword(password)); // Mã hóa mật khẩu
                pstmt.setString(4, phoneNumber); // Lưu số điện thoại
                pstmt.executeUpdate();
                return true; // Trả về true nếu đăng ký thành công

            } catch (SQLException e) {
                e.printStackTrace();
                return false; // Trả về false nếu có lỗi
            }
        }

        public boolean authenticateUser(String username, String password) throws SQLException {
            String query = "SELECT PasswordHash FROM Users WHERE Username = ?";
            try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
                preparedStatement.setString(1, username);  // Kiểm tra tên người dùng
                ResultSet resultSet = preparedStatement.executeQuery();

                // Kiểm tra nếu tài khoản không tồn tại
                if (!resultSet.next()) {
                    return false;  // Tài khoản không tồn tại
                }

                // Lấy mật khẩu băm từ cơ sở dữ liệu
                String storedPasswordHash = resultSet.getString("PasswordHash");

                // Băm mật khẩu người dùng nhập và so sánh với mật khẩu đã lưu
                String hashedInputPassword = hashPassword(password);

                // So sánh mật khẩu đã băm
                return storedPasswordHash.equals(hashedInputPassword);
            }
        }



            // Save connection details into the ports table
        public void saveConnection(String ip, String port) throws SQLException {
            String query = "INSERT INTO ports (ip, port) VALUES (?, ?)";

            try (Connection conn = getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(query)) {

                pstmt.setString(1, ip);
                pstmt.setInt(2, Integer.parseInt(port)); // Convert port string to int
                pstmt.executeUpdate();
            } catch (SQLException e) {
                // Handle the case where the IP and port already exist
                if (e.getErrorCode() == 2627) { // SQL Server error code for unique constraint violation
                    String updateQuery = "UPDATE ports SET port = ? WHERE ip = ?";
                    try (Connection conn = getConnection();
                         PreparedStatement pstmt = conn.prepareStatement(updateQuery)) {

                        pstmt.setInt(1, Integer.parseInt(port)); // Update the port
                        pstmt.setString(2, ip); // Where clause
                        pstmt.executeUpdate();
                    }
                } else {
                    throw e; // Rethrow the exception if it's not a unique constraint violation
                }
            }
        }
    
        public ResultSet getConnections() throws SQLException {
            String query = "SELECT * FROM ports ORDER BY id DESC OFFSET 0 ROWS FETCH NEXT 5 ROWS ONLY";
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            return pstmt.executeQuery();
    }
}
