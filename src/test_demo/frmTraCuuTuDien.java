package test_demo;

import java.awt.Font;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
<<<<<<< HEAD
=======
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
>>>>>>> c9ca5f631033a007af671961b0ce07ec1602358d
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;

/**
 *
 * @author ad
 */
public class frmTraCuuTuDien extends javax.swing.JFrame {
    private ArrayList<String> wordList; // Danh sách các từ
    
    /**
     * Creates new form frmTraCuuTuDien
     */
    public frmTraCuuTuDien() {
        initComponents();
<<<<<<< HEAD
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
=======
        setupTextArea();
        loadAllWords(); // Tải tất cả từ khi khởi động
    }
        private void setupTextArea() {
        tAreaNgonNgu.setLineWrap(true);
        tAreaNgonNgu.setWrapStyleWord(true);
        tAreaTuDich.setLineWrap(true);
        tAreaTuDich.setWrapStyleWord(true);

        StyledDocument docNgonNgu = new DefaultStyledDocument();
        StyledDocument docTuDich = new DefaultStyledDocument();
        tAreaNgonNgu.setDocument(docNgonNgu);
        tAreaTuDich.setDocument(docTuDich);

        Style style = StyleContext.getDefaultStyleContext().getStyle(StyleContext.DEFAULT_STYLE);
        style.addAttribute(StyleConstants.LineSpacing, 10.0f);

        tAreaNgonNgu.setFont(new Font("Monospaced", Font.PLAIN, 14));
        tAreaTuDich.setFont(new Font("Monospaced", Font.PLAIN, 14));
>>>>>>> c9ca5f631033a007af671961b0ce07ec1602358d
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tAreaNgonNgu = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        tAreaTuDich = new javax.swing.JTextArea();
        txtTimKiem = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btnSort = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setText("TỪ ĐIỂN");

        jLabel2.setText("Tìm :");

        tAreaNgonNgu.setColumns(20);
        tAreaNgonNgu.setRows(5);
        jScrollPane1.setViewportView(tAreaNgonNgu);

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

        btnSort.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSort.setText("Lọc");
        btnSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSortActionPerformed(evt);
            }
        });

        jLabel3.setText("Danh sách từ vựng :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSort)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTimKiem)))))
                .addGap(45, 45, 45))
            .addGroup(layout.createSequentialGroup()
                .addGap(250, 250, 250)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(btnSort))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTimKiemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyPressed
    // Khi phím Enter được nhấn
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        String word = txtTimKiem.getText().trim(); // Khai báo và lấy giá trị từ txtTimKiem
        if (!word.isEmpty()) {
            // Gọi hàm lookupWord để tra cứu từ và lấy nghĩa
            String wordMeaning = lookupWord(word); 
            // Hiển thị nghĩa của từ trong tAreaTuDich
            tAreaTuDich.setText(wordMeaning);
            // Hiển thị từ đã nhập trong tAreaNgonNgu
            tAreaNgonNgu.setText(word); // Cập nhật nội dung tAreaNgonNgu
        } else {
            tAreaTuDich.setText("Vui lòng nhập từ cần tra cứu.");
        }
    } 
    // Khi trường tìm kiếm rỗng, hiển thị lại danh sách từ
    if (txtTimKiem.getText().trim().isEmpty()) {
        loadAllWords(); // Gọi lại phương thức tải danh sách từ
    }
    }//GEN-LAST:event_txtTimKiemKeyPressed

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
                // Kiểm tra xem phím nhấn có phải là phím Enter không
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            // Kiểm tra xem txtTimKiem có rỗng không
            if (txtTimKiem.getText().isEmpty()) {
                // Nếu rỗng, tải lại danh sách từ ngẫu nhiên
                loadAllWords(); // Gọi phương thức tải danh sách từ ngẫu nhiên
            }
        }
    }//GEN-LAST:event_txtTimKiemKeyReleased

    
<<<<<<< HEAD
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
=======
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSortActionPerformed
        // TODO add your handling code here:
        loadAllWords();
    }//GEN-LAST:event_btnSortActionPerformed

    private void loadAllWords() {
        wordList = new ArrayList<>(); // Khởi tạo danh sách từ
        Map<Character, List<String>> wordsByFirstLetter = new HashMap<>();

        try {
            // Gửi yêu cầu đến Random Word API
            String urlStr = "https://random-word-api.herokuapp.com/word?number=50"; // Lấy 50 từ ngẫu nhiên
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

                // Xử lý phản hồi JSON
                JSONArray wordsArray = new JSONArray(content.toString());
                for (int i = 0; i < wordsArray.length(); i++) {
                    String word = wordsArray.getString(i);
                    char firstLetter = word.charAt(0);

                    // Nhóm từ theo chữ cái đầu
                    wordsByFirstLetter.putIfAbsent(firstLetter, new ArrayList<>());
                    wordsByFirstLetter.get(firstLetter).add(word);
                }

                // Tạo danh sách để lưu từ ngẫu nhiên theo từng chữ cái đầu
                StringBuilder randomWords = new StringBuilder();

                // Lặp qua từng nhóm chữ cái đầu
                for (Map.Entry<Character, List<String>> entry : wordsByFirstLetter.entrySet()) {
                    char letter = entry.getKey();
                    List<String> words = entry.getValue();

                    // Xáo trộn từ và chọn ngẫu nhiên 3 từ từ mỗi nhóm
                    Collections.shuffle(words);
                    int numberOfWordsToShow = Math.min(10, words.size()); // Chọn tối đa 3 từ
                    //randomWords.append("Từ bắt đầu bằng '").append(letter).append("':\n");

                    for (int j = 0; j < numberOfWordsToShow; j++) {
                        randomWords.append(words.get(j)).append("\n");
                    }
                    //randomWords.append("\n"); // Thêm một dòng trống giữa các chữ cái
                }

                // Hiển thị toàn bộ từ ngẫu nhiên lên tAreaNgonNgu
                tAreaNgonNgu.setText(randomWords.toString());
            } else {
                tAreaNgonNgu.setText("Không thể tải danh sách từ.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            tAreaNgonNgu.setText("Có lỗi xảy ra khi tải danh sách từ.");
        }
    }
   
private String lookupWord(String word) {
    StringBuilder result = new StringBuilder();
    try {
        // Tạo URL cho yêu cầu đến Dictionary API
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

            // Phân tích dữ liệu JSON
            JSONArray jsonArray = new JSONArray(content.toString());

            // Kiểm tra xem có kết quả không
            if (jsonArray.length() > 0) {
                JSONObject entry = jsonArray.getJSONObject(0);

                // Lấy định nghĩa
                if (entry.has("meanings")) {
                    JSONArray meanings = entry.getJSONArray("meanings");
                    for (int i = 0; i < meanings.length(); i++) {
                        JSONObject meaning = meanings.getJSONObject(i);
                        result.append("Part of Speech: ").append(meaning.getString("partOfSpeech")).append("\n");

                        // Lấy định nghĩa
                        JSONArray definitions = meaning.getJSONArray("definitions");
                        for (int j = 0; j < definitions.length(); j++) {
                            JSONObject definition = definitions.getJSONObject(j);
                            result.append("Definition: ").append(definition.getString("definition")).append("\n");

                            // Lấy phát âm nếu có
                            if (definition.has("audio")) {
                                result.append("Audio: ").append(definition.getString("audio")).append("\n");
                            }
                        }
                    }
                }

                // Lấy từ đồng nghĩa và từ trái nghĩa nếu có
                if (entry.has("synonyms")) {
                    JSONArray synonyms = entry.getJSONArray("synonyms");
                    if (synonyms.length() > 0) {
                        result.append("Synonyms: ");
                        for (int i = 0; i < synonyms.length(); i++) {
                            result.append(synonyms.getString(i)).append(", ");
                        }
                        result.setLength(result.length() - 2); // Loại bỏ dấu phẩy cuối cùng
                        result.append("\n");
                    }
                } else {
                    result.append("No synonyms available.\n");
                }

                // Nếu không có từ trái nghĩa trong API này, bạn có thể xóa hoặc bỏ qua phần này
                result.append("No antonyms available.\n");
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
>>>>>>> c9ca5f631033a007af671961b0ce07ec1602358d

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
    private javax.swing.JButton btnSort;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea tAreaNgonNgu;
    private javax.swing.JTextArea tAreaTuDich;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
