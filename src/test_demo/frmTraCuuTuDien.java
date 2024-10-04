package test_demo;

import java.awt.Font;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author ad
 */
public class frmTraCuuTuDien extends javax.swing.JFrame {

    /**
     * Creates new form frmTraCuuTuDien
     */
    public frmTraCuuTuDien() {
        initComponents();
        // Thiết lập cho tAreaNgonNgu  
        tAreaNgonNgu.setLineWrap(true); // Bật tự động xuống dòng  
        tAreaNgonNgu.setWrapStyleWord(true); // Xuống dòng tại từ  

        // Thiết lập cho tAreaTuDich  
        tAreaTuDich.setLineWrap(true); // Bật tự động xuống dòng  
        tAreaTuDich.setWrapStyleWord(true); // Xuống dòng tại từ

        // Thiết lập khoảng cách dòng
        StyledDocument docNgonNgu = new DefaultStyledDocument();  
        StyledDocument docTuDich = new DefaultStyledDocument();  
        tAreaNgonNgu.setDocument(docNgonNgu);  
        tAreaTuDich.setDocument(docTuDich);  
    
        Style style = StyleContext.getDefaultStyleContext().getStyle(StyleContext.DEFAULT_STYLE);  
        style.addAttribute(StyleConstants.LineSpacing, 10.0f); // Điều chỉnh khoảng cách dòng (10.0f là ví dụ)  
    
        // Thiết lập font cho JTextPane  
        tAreaNgonNgu.setFont(new Font("Monospaced", Font.PLAIN, 14)); // Kích thước font  
        tAreaTuDich.setFont(new Font("Monospaced", Font.PLAIN, 14)); // Kích thước font
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cmbNgonNgu = new javax.swing.JComboBox<>();
        cmbTuDich = new javax.swing.JComboBox<>();
        txtTimKiem = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tAreaNgonNgu = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        tAreaTuDich = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("TỪ ĐIỂN ĐA NGÔN NGỮ");

        cmbNgonNgu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "en", "es", "fr ", "de", "vi" }));

        cmbTuDich.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "vi", "en", "es", "fr ", "de" }));

        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyPressed(evt);
            }
        });

        jLabel2.setText("Tìm kiếm :");

        tAreaNgonNgu.setColumns(20);
        tAreaNgonNgu.setRows(5);
        jScrollPane1.setViewportView(tAreaNgonNgu);

        tAreaTuDich.setColumns(20);
        tAreaTuDich.setRows(5);
        jScrollPane2.setViewportView(tAreaTuDich);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(206, 206, 206)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbNgonNgu, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtTimKiem)
                            .addComponent(cmbTuDich, 0, 130, Short.MAX_VALUE))))
                .addGap(45, 45, 45))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbNgonNgu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbTuDich, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTimKiemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String word = txtTimKiem.getText();
            String detectedLanguage = detectLanguage(word);

            if (detectedLanguage == null) {
                tAreaNgonNgu.setText("Không tìm thấy ngôn ngữ.");
                tAreaTuDich.setText("");
            } else {
                cmbNgonNgu.setSelectedItem(detectedLanguage);
                String wordMeaning = lookupWord(word, detectedLanguage);
                tAreaNgonNgu.setText(word);
                tAreaTuDich.setText(wordMeaning);
            }
        }
    }//GEN-LAST:event_txtTimKiemKeyPressed

        private String detectLanguage(String word) {
        // Kiểm tra từ thuộc ngôn ngữ nào
        for (String lang : new String[]{"en", "es", "fr", "de", "vi"}) {
            if (isWordInLanguage(word, lang)) {
                return lang;
            }
        }
        return null; // Không tìm thấy ngôn ngữ
    }
    
    private boolean isWordInLanguage(String word, String language) {
        if (language.equals("vi")) {
            return word.matches("[\\u0102\\u00C1\\u00C0\\u00C3\\u0103\\u00E1\\u00E0\\u00E3\\u00E2\\u00EA\\u00E9\\u00EA]+"); // kiểm tra nếu từ chỉ chứa chữ cái tiếng Việt
        } else {
            // Các ngôn ngữ khác
            return word.matches("[a-zA-Z]+"); // chỉ cho phép chữ cái tiếng Anh
        }
    }
    
    private String lookupWord(String word, String language) {  
        try {  
            String urlStr = "https://api.dictionaryapi.dev/api/v2/entries/"  
                    + language + "/" + word.toLowerCase();  
            URL url = new URL(urlStr);  
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();  
            conn.setRequestMethod("GET");  
            conn.connect();  

            int responseCode = conn.getResponseCode();  
            if (responseCode != 200) {  
                return "Không tìm thấy nghĩa của từ.";  
            }  

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));  
            String inputLine;  
            StringBuilder content = new StringBuilder();  
            while ((inputLine = in.readLine()) != null) {  
                content.append(inputLine);  
            }  
            in.close();  

            // Đọc và xử lý JSON để lấy nghĩa và các thông tin khác  
            JSONArray jsonArray = new JSONArray(content.toString());  
            StringBuilder meanings = new StringBuilder();  

            // Duyệt qua các kết quả trả về từ API  
            for (int i = 0; i < jsonArray.length(); i++) {  
                JSONObject wordObject = jsonArray.getJSONObject(i);  
                meanings.append("Từ: ").append(wordObject.getString("word")).append("\n");  

                // Xử lý các nghĩa  
                JSONArray meaningsArray = wordObject.getJSONArray("meanings");  
                for (int j = 0; j < meaningsArray.length(); j++) {  
                    JSONObject meaningObject = meaningsArray.getJSONObject(j);  
                    meanings.append("Loại từ: ").append(meaningObject.getString("partOfSpeech")).append("\n");  
                    JSONArray definitionsArray = meaningObject.getJSONArray("definitions");  
                    for (int k = 0; k < definitionsArray.length(); k++) {  
                        JSONObject definitionObject = definitionsArray.getJSONObject(k);  
                        meanings.append("Định nghĩa: ").append(definitionObject.getString("definition")).append("\n");  
                        if (definitionObject.has("example")) {  
                            meanings.append("Ví dụ: ").append(definitionObject.getString("example")).append("\n");  
                        }  
                    }  
                    meanings.append("\n");  
                }  
            }  

            return meanings.toString(); // Trả về toàn bộ nghĩa và thông tin khác  
        } catch (Exception e) {  
            e.printStackTrace();  
            return "Có lỗi xảy ra khi tra cứu từ.";  
        }  
    }  

    
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
            java.util.logging.Logger.getLogger(frmTraCuuTuDien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmTraCuuTuDien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmTraCuuTuDien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmTraCuuTuDien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            frmTraCuuTuDien frame = new frmTraCuuTuDien();
            frame.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbNgonNgu;
    private javax.swing.JComboBox<String> cmbTuDich;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea tAreaNgonNgu;
    private javax.swing.JTextArea tAreaTuDich;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
