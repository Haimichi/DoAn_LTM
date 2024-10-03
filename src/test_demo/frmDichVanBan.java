
package test_demo;


import java.awt.Font;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Arrays;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;
import org.json.JSONObject;

/**
 *
 * @author ad
 */
public class frmDichVanBan extends javax.swing.JFrame {

    /**
     * Creates new form frmDichVanBan
     */
    public frmDichVanBan() {
        initComponents();
                // Thiết lập cho tAreaNgonNgu  
        txtAreaVanBan.setLineWrap(true); // Bật tự động xuống dòng  
        txtAreaBanDich.setWrapStyleWord(true); // Xuống dòng tại từ
        
        txtAreaBanDich.setLineWrap(true); // Bật tự động xuống dòng  
        txtAreaBanDich.setWrapStyleWord(true); // Xuống dòng tại từ

        // Thiết lập cho tAreaTuDich  
        txtAreaVanBan.setLineWrap(true); // Bật tự động xuống dòng  
        txtAreaVanBan.setWrapStyleWord(true); // Xuống dòng tại từ

        // Thiết lập khoảng cách dòng
        StyledDocument docNgonNgu = new DefaultStyledDocument();  
        StyledDocument docTuDich = new DefaultStyledDocument();  
        txtAreaBanDich.setDocument(docNgonNgu);  
        txtAreaVanBan.setDocument(docTuDich);  
    
        Style style = StyleContext.getDefaultStyleContext().getStyle(StyleContext.DEFAULT_STYLE);  
        style.addAttribute(StyleConstants.LineSpacing, 10.0f); // Điều chỉnh khoảng cách dòng (10.0f là ví dụ)  
    
        // Thiết lập font cho JTextPane  
        txtAreaBanDich.setFont(new Font("Monospaced", Font.PLAIN, 14)); // Kích thước font  
        txtAreaVanBan.setFont(new Font("Monospaced", Font.PLAIN, 14)); // Kích thước font
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaVanBan = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAreaBanDich = new javax.swing.JTextArea();
        btnDich = new javax.swing.JButton();
        cmbNgonNguNhap = new javax.swing.JComboBox<>();
        cmbNgonNguMuonDich = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnThoat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("DỊCH VĂN BẢN");

        txtAreaVanBan.setColumns(20);
        txtAreaVanBan.setRows(5);
        jScrollPane1.setViewportView(txtAreaVanBan);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Nhập văn bản : ");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Bản dịch :");

        txtAreaBanDich.setColumns(20);
        txtAreaBanDich.setRows(5);
        jScrollPane3.setViewportView(txtAreaBanDich);

        btnDich.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDich.setText("Dịch");
        btnDich.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDichActionPerformed(evt);
            }
        });

        cmbNgonNguNhap.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tiếng Việt", "Tiếng Anh", "Tiếng Tây Ban Nha", "Tiếng Pháp", "Tiếng Ý", "Tiếng Nhật", "Tiếng Trung Phồn Thể", "Tiếng Trung Giản Thể " }));

        cmbNgonNguMuonDich.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tiếng Anh", "Tiếng Tây Ban Nha", "Tiếng Pháp", "Tiếng Ý", "Tiếng Nhật", "Tiếng Việt", "Tiếng Trung Phồn Thể", "Tiếng Trung Giản Thể " }));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Chọn ngôn ngữ :");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Chọn ngôn ngữ :");

        btnThoat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(268, 268, 268)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 705, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbNgonNguMuonDich, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbNgonNguNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnDich)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnThoat)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbNgonNguNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbNgonNguMuonDich, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDich)
                    .addComponent(btnThoat))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDichActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDichActionPerformed
        try {
        String textToTranslate = txtAreaVanBan.getText(); // Văn bản cần dịch
        
        // Lấy ngôn ngữ từ JComboBox
        String fromLanguage = "";
        String toLanguage = "";
        
        switch (cmbNgonNguNhap.getSelectedItem().toString()) {
            case "Tiếng Anh":
                fromLanguage = "en";
                break;
            case "Tiếng Tây Ban Nha":
                fromLanguage = "es";
                break;
            case "Tiếng Pháp":
                fromLanguage = "fr";
                break;
            case "Tiếng Ý":
                fromLanguage = "it";
                break;
            case "Tiếng Trung Giản Thể":
                fromLanguage = "zh-Hans_CN"; // Giản thể
                break;
            case "Tiếng Nhật":
                fromLanguage = "ja";
                break;
            case "Tiếng Việt":
                fromLanguage = "vi";
                break;
        }
        switch (cmbNgonNguMuonDich.getSelectedItem().toString()) {
            case "Tiếng Việt":
                toLanguage = "vi";
                break;
            case "Tiếng Tây Ban Nha":
                toLanguage = "es";
                break;
            case "Tiếng Pháp":
                toLanguage = "fr";
                break;
            case "Tiếng Ý":
                toLanguage = "it";
                break;
            case "Tiếng Trung Giản Thể":
                toLanguage = "zh-Hans_CN"; // Giản thể
                break;
            case "Tiếng Nhật":
                toLanguage = "ja";
                break;
            case "Tiếng Anh":
                toLanguage = "en";
                break;
        }


        // Tạo URL để gọi API
        String apiUrl = "https://api-b2b.backenster.com/b1/api/v3/translate";

        // Tạo đối tượng URL
        URL url = new URL(apiUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Accept", "application/json");
        conn.setRequestProperty("Authorization", "Bearer a_6Moelpp5PLZKX9hGeKubnwyZgEOn8ybO7Sg161f5tBpcTitQlz5JPQ5Sqh6gJFCl5HdTdHHXCGhjQKKE");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setDoOutput(true);

        // Tạo JSON để gửi
        String jsonInputString = "{\"text\": \"" + textToTranslate + "\", \"to\": \"" + toLanguage + "\", \"from\": \"" + fromLanguage + "\"}";

        // Gửi dữ liệu đến API
        try (OutputStream os = conn.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        // Kiểm tra mã phản hồi
        int responseCode = conn.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Phân tích phản hồi JSON
            JSONObject jsonResponse = new JSONObject(response.toString());
            String translatedText = jsonResponse.getString("result");

            // Hiển thị bản dịch
            txtAreaBanDich.setText(translatedText);
        } else {
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
            String errorMessage = "";
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                errorMessage += inputLine;
            }
            in.close();
            txtAreaBanDich.setText("Error: " + responseCode + "\n" + errorMessage);
        }
    } catch (IOException e) {
        e.printStackTrace();
        txtAreaBanDich.setText("Exception: " + e.getMessage());
    }
    
    }//GEN-LAST:event_btnDichActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnThoatActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmDichVanBan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmDichVanBan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmDichVanBan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmDichVanBan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmDichVanBan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDich;
    private javax.swing.JButton btnThoat;
    private javax.swing.JComboBox<String> cmbNgonNguMuonDich;
    private javax.swing.JComboBox<String> cmbNgonNguNhap;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea txtAreaBanDich;
    private javax.swing.JTextArea txtAreaVanBan;
    // End of variables declaration//GEN-END:variables
}
