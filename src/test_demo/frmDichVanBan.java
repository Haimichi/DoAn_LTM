package test_demo;

import java.awt.Font;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

/**
 *
 * @author ad
 */
public class frmDichVanBan extends javax.swing.JFrame {
    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;

    public frmDichVanBan(Socket socket) {
        initComponents();
        this.socket = socket; // Gán socket được truyền từ Login hoặc MainMenu

        try {
            reader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            writer = new PrintWriter(this.socket.getOutputStream(), true);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Không thể sử dụng kết nối socket hiện có: " + e.getMessage());
        }

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
        style.addAttribute(StyleConstants.LineSpacing, 10.0f); // Điều chỉnh khoảng cách dòng  
    
        // Thiết lập font cho JTextPane  
        txtAreaBanDich.setFont(new Font("Monospaced", Font.PLAIN, 14)); // Kích thước font  
        txtAreaVanBan.setFont(new Font("Monospaced", Font.PLAIN, 14)); // Kích thước font
    }

    private void connectToServer() {
        try {
            socket = new Socket("localhost", 8000); // Connect to the TCP server
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);

            String greeting = reader.readLine();
            System.out.println("Server says: " + greeting);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Unable to connect to server: " + e.getMessage());
        }
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

        cmbNgonNguNhap.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tiếng Việt", "Tiếng Anh", "Tiếng Tây Ban Nha", "Tiếng Pháp", "Tiếng Ý", "Tiếng Nhật", "Tiếng Đức" }));

        cmbNgonNguMuonDich.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tiếng Anh", "Tiếng Tây Ban Nha", "Tiếng Pháp", "Tiếng Ý", "Tiếng Nhật", "Tiếng Đức", "Tiếng Việt" }));

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
    new SwingWorker<String, Void>() {
        @Override
        protected String doInBackground() throws Exception {
            if (socket == null || socket.isClosed()) {
                connectToServer();  // Kết nối lại nếu socket đã đóng
            }

            String textToTranslate = txtAreaVanBan.getText().trim(); // Lấy văn bản cần dịch

            if (textToTranslate.isEmpty()) {
                return "Vui lòng nhập văn bản cần dịch.";
            }

            String fromLanguage = getSelectedLanguage(cmbNgonNguNhap.getSelectedItem().toString());
            String toLanguage = getSelectedLanguage(cmbNgonNguMuonDich.getSelectedItem().toString());

            // Gửi yêu cầu dịch tới server
            writer.println("TRANSLATE");
            writer.println(textToTranslate);
            writer.println(fromLanguage);
            writer.println(toLanguage);
            writer.flush();  // Đảm bảo dữ liệu được gửi đi

            // Hiển thị thông báo yêu cầu đã gửi từ client
            System.out.println("Đã gửi yêu cầu dịch văn bản: \"" + textToTranslate + "\" từ " + fromLanguage + " sang " + toLanguage);

            // Nhận phản hồi từ server và trả về kết quả
            StringBuilder translationResult = new StringBuilder();
            String responseMessage;

            // Nhận dữ liệu từ server và gom kết quả
            while ((responseMessage = reader.readLine()) != null && !responseMessage.isEmpty()) {
                translationResult.append(responseMessage).append("\n");
                txtAreaBanDich.setText(responseMessage);
                //System.out.println("Nhận được phản hồi từ server: " + responseMessage);  // Debug log để kiểm tra kết quả trên console
            }

            if (translationResult.length() > 0) {
                return translationResult.toString();  // Trả về kết quả dịch
            } else {
                return "Không nhận được kết quả dịch từ server.";
            }
        }

        @Override
        protected void done() {
            try {
                // Lấy kết quả từ server và hiển thị vào txtAreaBanDich
                String result = get();
                txtAreaBanDich.setText(result);  // Hiển thị kết quả trong txtAreaBanDich
            } catch (Exception e) {
                txtAreaBanDich.setText("Có lỗi xảy ra: " + e.getMessage());
            }
        }
    }.execute();
    }//GEN-LAST:event_btnDichActionPerformed

    private String getSelectedLanguage(String language) {
        switch (language) {
            case "Tiếng Anh":
                return "en";
            case "Tiếng Tây Ban Nha":
                return "es";
            case "Tiếng Pháp":
                return "fr";
            case "Tiếng Ý":
                return "it";
            case "Tiếng Đức":
                return "de"; // Tiếng Trung giản thể
            case "Tiếng Nhật":
                return "ja";
            case "Tiếng Việt":
                return "vi";
            default:
                return "en"; // Mặc định là tiếng Anh
        }
    }
    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnThoatActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws IOException {
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
        Socket socket = new Socket("localhost", 8000); // Kết nối tới server hoặc nhận từ form Login

        // Sau đó gọi EventQueue
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // Truyền socket vào frmDichVanBan
                new frmDichVanBan(socket).setVisible(true);
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