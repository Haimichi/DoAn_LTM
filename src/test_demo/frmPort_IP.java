package test_demo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.io.*;
import java.net.*;
/**
 *
 * @author ad
 */
public class frmPort_IP extends javax.swing.JFrame {
    private Connection connection;

    public frmPort_IP() {
        initComponents();
        loadSavedConnections();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtPort = new javax.swing.JTextField();
        txtIP = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbOk = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbList = new javax.swing.JTable();
        btnKetNoi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Kết nối Server");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("PORT & IP");

        jLabel2.setText("PORT :");

        jLabel3.setText("IP :");

        jLabel4.setText("Bạn có muốn lưu lại Port & IP cho lần sau?");

        cbOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbOkActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Danh sách các Port & IP");

        tbList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Port", "IP"
            }
        ));
        tbList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbList);

        btnKetNoi.setText("Kết nối");
        btnKetNoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKetNoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabel3))
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtPort, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIP, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)))))
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnKetNoi, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbOk, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addComponent(jLabel1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbOk)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnKetNoi)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private boolean connectToServer(String ip, String port) {
        try {
            int portNumber = Integer.parseInt(port);
            // Attempt to connect to the TCP server
            Socket socket = new Socket(ip, portNumber); 
            System.out.println("Connected to the server at " + ip + ":" + portNumber);
            return true; // Connection successful
        } catch (SocketException se) {
            System.err.println("SocketException: " + se.getMessage());
            return false; // Connection failed
        } catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
            return false; // Connection failed
        } catch (NumberFormatException e) {
            System.err.println("Invalid port number: " + e.getMessage());
            return false; // Port was not a valid integer
        }
    }
    
    private void saveConnection(String ip, String port) {
        try {
            SQLServerConnection dbConnection = new SQLServerConnection();
            dbConnection.saveConnection(ip, port);
            loadSavedConnections(); // Reload to display updated data
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to save connection.", "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void loadSavedConnections() {
        try {
            SQLServerConnection dbConnection = new SQLServerConnection();
            ResultSet rs = dbConnection.getConnections();

            DefaultTableModel model = (DefaultTableModel) tbList.getModel();
            model.setRowCount(0); // Clear existing rows

            while (rs.next()) {
                String ip = rs.getString("ip");
                int port = rs.getInt("port");
                model.addRow(new Object[]{ip, port}); // Add a new row for each connection
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to load connections.", "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void btnKetNoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKetNoiActionPerformed
        String ip = txtIP.getText().trim();
        String port = txtPort.getText().trim();

        if (ip.isEmpty() || port.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter both IP address and Port.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            // Tạo một kết nối socket tới server
            Socket socket = new Socket(ip, Integer.parseInt(port)); // Khởi tạo socket kết nối với server
            System.out.println("Kết nối thành công tới server tại IP: " + ip + ", Port: " + port);

            if (cbOk.isSelected()) {
                saveConnection(ip, port); // Lưu lại IP và Port nếu cần
            }

            // Truyền socket đã kết nối sang form Login
            Login loginForm = new Login(socket); // Tạo Login với socket
            loginForm.setVisible(true); // Hiển thị form Login
            this.dispose(); // Đóng form hiện tại

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Kết nối thất bại: " + e.getMessage(), "Connection Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnKetNoiActionPerformed
    
    private void cbOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbOkActionPerformed

    }//GEN-LAST:event_cbOkActionPerformed

    private void tbListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbListMouseClicked
        // TODO add your handling code here:
        int row = tbList.rowAtPoint(evt.getPoint());
            if (row >= 0) {
                String ip = tbList.getValueAt(row, 0).toString();
                String port = tbList.getValueAt(row, 1).toString();
                txtIP.setText(ip);
                txtPort.setText(port);
            }
    }//GEN-LAST:event_tbListMouseClicked

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
            java.util.logging.Logger.getLogger(frmPort_IP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPort_IP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPort_IP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPort_IP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        try {  
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {  
                if ("Nimbus".equals(info.getName())) {  
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());  
                    break;  
                }  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        } 
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPort_IP().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKetNoi;
    private javax.swing.JCheckBox cbOk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbList;
    private javax.swing.JTextField txtIP;
    private javax.swing.JTextField txtPort;
    // End of variables declaration//GEN-END:variables
}
