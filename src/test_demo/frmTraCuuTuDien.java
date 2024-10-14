package test_demo;

import java.awt.Font;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.SwingWorker;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

public class frmTraCuuTuDien extends javax.swing.JFrame {
    private ArrayList<String> wordList;
    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;    


    public frmTraCuuTuDien(Socket socket) {   
        initComponents();
        this.socket = socket;  // Nhận socket từ Login hoặc MainMenu
        try {
            reader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            writer = new PrintWriter(this.socket.getOutputStream(), true);
            // Further initialization
        } catch (IOException e) {
            e.printStackTrace();
            // Handle exception
        }
        
        tAreaTuDich.setLineWrap(true); 
        tAreaTuDich.setWrapStyleWord(true);
        tAreaTuDichVN.setLineWrap(true);
        tAreaTuDichVN.setWrapStyleWord(true);

        StyledDocument docNgonNgu = new DefaultStyledDocument();  
        StyledDocument docTuDich = new DefaultStyledDocument();  
        StyledDocument docTuDichVN = new DefaultStyledDocument();
        tAreaTuDich.setDocument(docTuDich);  
        tAreaTuDichVN.setDocument(docTuDichVN);
    
        Style style = StyleContext.getDefaultStyleContext().getStyle(StyleContext.DEFAULT_STYLE);  
        style.addAttribute(StyleConstants.LineSpacing, 10.0f);
    
        tAreaTuDich.setFont(new Font("Monospaced", Font.PLAIN, 14));
        tAreaTuDichVN.setFont(new Font("Monospaced", Font.PLAIN, 14));
        setupTextArea();
    }

    private void setupTextArea() {
        tAreaTuDich.setLineWrap(true);
        tAreaTuDich.setWrapStyleWord(true);
        tAreaTuDichVN.setLineWrap(true);
        tAreaTuDichVN.setWrapStyleWord(true);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tAreaTuDich = new javax.swing.JTextArea();
        txtTimKiem = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tAreaTuDichVN = new javax.swing.JTextArea();
        btnDich = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setText("TỪ ĐIỂN");

        jLabel2.setText("Tìm :");

        tAreaTuDich.setColumns(20);
        tAreaTuDich.setRows(5);
        jScrollPane2.setViewportView(tAreaTuDich);

        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("Thoát");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tAreaTuDichVN.setColumns(20);
        tAreaTuDichVN.setRows(5);
        jScrollPane3.setViewportView(tAreaTuDichVN);

        btnDich.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDich.setText("Dịch");
        btnDich.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDichActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDich))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton1))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(btnDich)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
private String lookupWordFromServer(String word) {
    String meaning = null;
    StringBuilder result = new StringBuilder();  // Using StringBuilder to gather entire response

    try {
        // Use the same socket from the constructor
        writer.println("LOOKUP_WORD");  // Send command to server
        writer.println(word);           // Send word to server

        // Gather all the results from server in one go
        String response;
        while ((response = reader.readLine()) != null && !response.isEmpty()) {
            result.append(response).append("\n");  // Append all data
        }

        meaning = result.toString();  // Convert StringBuilder to String
    } catch (IOException e) {
        e.printStackTrace();
        meaning = "Có lỗi xảy ra khi kết nối tới server.";
    }

    return meaning;
}



        
    private void txtTimKiemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
           final String word = txtTimKiem.getText().trim();
           if (!word.isEmpty()) {
               // Hiển thị thông báo đang xử lý yêu cầu tra cứu từ trên client
               String initialMessage = "Đang gửi yêu cầu tra cứu từ '" + word + "' tới server...";
               tAreaTuDich.setText(initialMessage + "\n");  // Hiển thị trên giao diện
               System.out.println(initialMessage);  // In ra console

               // Tạo SwingWorker để gửi yêu cầu lên server và nhận kết quả
               new SwingWorker<String, Void>() {
                   @Override
                   protected String doInBackground() throws Exception {
                       return lookupWordFromServer(word);  // Gửi yêu cầu tới server
                   }

                   @Override
                   protected void done() {
                       try {
                           // Nhận kết quả trả về từ server và hiển thị lên giao diện
                           String meaning = get();
                           if (meaning != null && !meaning.isEmpty()) {
                               // Sau khi nhận được kết quả, xóa thông báo và hiển thị kết quả tra cứu
                               tAreaTuDich.setText(""); // Xóa thông báo
                               String resultMessage = "Kết quả tra cứu từ: " + word + "\n" + meaning;
                               tAreaTuDich.append(resultMessage);  // Hiển thị kết quả trên giao diện
                               System.out.println(resultMessage);  // In ra console
                           } else {
                               tAreaTuDich.setText("");  // Xóa thông báo
                               String notFoundMessage = "Không tìm thấy nghĩa của từ '" + word + "'.";
                               tAreaTuDich.append(notFoundMessage);  // Hiển thị trên giao diện
                               System.out.println(notFoundMessage);  // In ra console
                           }
                       } catch (Exception e) {
                           tAreaTuDich.setText("");  // Xóa thông báo
                           String errorMessage = "Có lỗi xảy ra: " + e.getMessage();
                           tAreaTuDich.append(errorMessage);  // Hiển thị trên giao diện
                           System.out.println(errorMessage);  // In ra console
                       }
                   }
               }.execute();
           } else {
               String emptyMessage = "Vui lòng nhập từ cần tra cứu.";
               tAreaTuDich.setText(emptyMessage);  // Hiển thị trên giao diện
               System.out.println(emptyMessage);  // In ra console
           }
       }
    }//GEN-LAST:event_txtTimKiemKeyPressed

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased

    }//GEN-LAST:event_txtTimKiemKeyReleased

    private boolean isWordInLanguage(String word, String language) {
        if (language.equals("vi")) {
            return word.matches("[\\u0102\\u00C1\\u00C0\\u00C3\\u0103\\u00E1\\u00E0\\u00E3\\u00E2\\u00EA\\u00E9\\u00EA]+"); 
        } else {
            return word.matches("[a-zA-Z]+");
        }
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();  // Đóng form đăng nhập        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnDichActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDichActionPerformed
        String textToTranslate = tAreaTuDich.getText();
        textToTranslate = textToTranslate.replaceAll("[\n\r\t]", " ");        
        if (!textToTranslate.isEmpty()) {
            try {
                // Dùng socket đã được truyền vào từ Login/MainMenu  
                if (socket == null || socket.isClosed()) {
                    tAreaTuDichVN.setText("Không thể kết nối tới server.");
                    return;
                }

                // Gửi yêu cầu dịch văn bản
                writer.println("TRANSLATE");
                writer.println(textToTranslate);
                writer.println("en");
                writer.println("vi");

                // Nhận kết quả dịch từ server
                String translatedText = reader.readLine();
                tAreaTuDichVN.setText(translatedText);

            } catch (IOException e) {
                e.printStackTrace();
                tAreaTuDichVN.setText("Có lỗi xảy ra khi kết nối tới server.");
            }
        } else {
            tAreaTuDichVN.setText("Vui lòng nhập văn bản cần dịch.");
        }
    }//GEN-LAST:event_btnDichActionPerformed
  
    public static void main(String args[]) {
        try {
            // Mở kết nối tới server trước khi khởi tạo frmTraCuuTuDien
            Socket socket = new Socket("localhost", 8000);  // Ví dụ kết nối tới localhost với port 8000

            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new frmTraCuuTuDien(socket).setVisible(true);  // Truyền socket vào constructor
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDich;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea tAreaTuDich;
    private javax.swing.JTextArea tAreaTuDichVN;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
