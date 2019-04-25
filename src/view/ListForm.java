/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.HistoryDAO;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.History;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author duong
 */
public class ListForm extends javax.swing.JFrame {

    DefaultTableModel model;
    ArrayList<History> history;
    String linkFiles = "/Users/datvl/Downloads/";

    /**
     * Creates new form ListForm
     */
    public ListForm() {
        initComponents();
        jPanelsettingFile.setVisible(false);

    }

    public void showData(String sql) {

    }

    public void findUser() {
        HistoryDAO historyDao = new HistoryDAO();
        history = historyDao.searchHistory(jTextField_ten.getText());
        if(history.isEmpty()){
          JOptionPane.showMessageDialog(rootPane, "Không tìm thấy trong danh sách!");
          return;
        }else {
        model = (DefaultTableModel) jTable_result.getModel();
        model.setRowCount(0);
        model.setColumnIdentifiers(new Object[]{"Ten", "CMND", "thang", "nam", "so tien dong"});
        //Object[] row = new Object[5];
        // for (int i = 0; i < history.size(); i++) {
        for (History user : history) //            row[0]=history.get(i).getFull_name();
        //            row[1]=history.get(i).getCmnd();
        //            row[2]=history.get(i).getThang();
        //            row[3]=history.get(i).getNam();
        //            row[4]=history.get(i).getSotiendong();
        {
            model.addRow(new Object[]{
                user.getFull_name(), user.getCmnd(), user.getThang(), user.getNam(), user.getSotiendong()
            });
        }
        ((DefaultTableModel) (jTable_result.getModel())).fireTableDataChanged();
        
        
        }
        
        //} ((DefaultTableModel) (jTable_result.getModel())).fireTableDataChanged();
    }

    public void export(ArrayList<History> his, String linkFile) throws IOException {
        try {

            Workbook workbook = getWorkbook(linkFile);
            Sheet sheet = workbook.createSheet();
            createHeaderRow(sheet);
            int rowCount = 0;
            for (History user : his) {
                Row row = sheet.createRow(++rowCount);
                writeUser(user, row);
            }

            try (FileOutputStream outputStream = new FileOutputStream(linkFile)) {
                workbook.write(outputStream);
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void writeUser(History user, Row row) {
        Cell cell = row.createCell(1);
        cell.setCellValue(user.getFull_name());

        cell = row.createCell(2);
        cell.setCellValue(user.getCmnd());

        cell = row.createCell(3);
        cell.setCellValue(user.getThang());

        cell = row.createCell(4);
        cell.setCellValue(user.getNam());

        cell = row.createCell(5);
        cell.setCellValue(user.getSotiendong());
    }

    private Workbook getWorkbook(String linkFile) throws IOException {
        Workbook workbook = null;

        if (linkFile.endsWith("xlsx")) {
            workbook = new XSSFWorkbook();
        } else if (linkFile.endsWith("xls")) {
            workbook = new HSSFWorkbook();
        } else {
            throw new IllegalArgumentException("The specified file is not Excel file");
        }

        File file = new File(linkFile);
        if (file.createNewFile()) {
            System.out.println("Success!");
        } else {
            System.out.println("Error, file already exists.");
        }

        return workbook;
    }

    private void createHeaderRow(Sheet sheet) {

        CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
        Font font = sheet.getWorkbook().createFont();
        font.setBold(true);
        font.setFontHeightInPoints((short) 16);
        cellStyle.setFont(font);

        Row row = sheet.createRow(0);
        Cell cellTen = row.createCell(1);
        cellTen.setCellStyle(cellStyle);
        cellTen.setCellValue("Ten");

        Cell cellCMND = row.createCell(2);
        cellCMND.setCellStyle(cellStyle);
        cellCMND.setCellValue("CMND");

        Cell cellThang = row.createCell(3);
        cellThang.setCellStyle(cellStyle);
        cellThang.setCellValue("thang");

        Cell cellNam = row.createCell(4);
        cellNam.setCellStyle(cellStyle);
        cellNam.setCellValue("nam");

        Cell cellSoTien = row.createCell(5);
        cellSoTien.setCellStyle(cellStyle);
        cellSoTien.setCellValue("so tien dong");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jButton_xem = new javax.swing.JButton();
        jTextField_ten = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_result = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanelsettingFile = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFileName = new javax.swing.JTextField();
        jButtonXacNhan = new javax.swing.JButton();
        jBexport = new javax.swing.JButton();
        jButtonback = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton_xem.setText("Xem");
        jButton_xem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_xemActionPerformed(evt);
            }
        });

        jTable_result.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Ten", "CMND", "thang", "nam", "so tien dong"
            }
        ));
        jScrollPane1.setViewportView(jTable_result);

        jLabel1.setText("Tên File");

        jButtonXacNhan.setText("Xác nhận");
        jButtonXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonXacNhanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelsettingFileLayout = new javax.swing.GroupLayout(jPanelsettingFile);
        jPanelsettingFile.setLayout(jPanelsettingFileLayout);
        jPanelsettingFileLayout.setHorizontalGroup(
            jPanelsettingFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelsettingFileLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanelsettingFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonXacNhan)
                    .addGroup(jPanelsettingFileLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFileName, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanelsettingFileLayout.setVerticalGroup(
            jPanelsettingFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelsettingFileLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanelsettingFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFileName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonXacNhan)
                .addContainerGap())
        );

        jBexport.setText("Xuất file exel");
        jBexport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBexportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanelsettingFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jBexport, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jBexport)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelsettingFile, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButtonback.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        jButtonback.setText("<- Quay lại");
        jButtonback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonbackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(jTextField_ten, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(jButton_xem)
                .addGap(100, 100, 100))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonback)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonback)
                .addGap(72, 72, 72)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_xem)
                    .addComponent(jTextField_ten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(81, 81, 81)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("tab1", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 620, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_xemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_xemActionPerformed
        // TODO add your handling code here:
        if(jTextField_ten.getText().trim().equals("")){
            JOptionPane.showMessageDialog(rootPane, "Bạn cần nhập dứ liệu tìm kiếm!");
        }else {
            findUser();
        }
    }//GEN-LAST:event_jButton_xemActionPerformed

    private void jBexportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBexportActionPerformed
        // TODO add your handling code here:
        jPanelsettingFile.setVisible(true);
        
    }//GEN-LAST:event_jBexportActionPerformed

    private void jButtonXacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonXacNhanActionPerformed
        // TODO add your handling code here:
        String FileNAme = "";
        String txtText = jTextFileName.getText();
        if(txtText.equals("")){
            JOptionPane.showMessageDialog(rootPane, "Bạn phải nhập tên file!");
            throw new IllegalArgumentException("The specified file is not Excel file");
        }else if(txtText.endsWith(".xlsx") || txtText.endsWith(".xls")){
            FileNAme = linkFiles + txtText;
            
        }else {
            FileNAme = linkFiles + txtText.replaceAll("[!';:.@$]", "") + ".xlsx";    
        }
        
        try {
                export(history, FileNAme);
                JOptionPane.showMessageDialog(rootPane, "Success!!! Address ExportFile: " +FileNAme);
                jTextFileName.setText("");
                jPanelsettingFile.setVisible(false);
            } catch (IOException ex) {
                Logger.getLogger(ListForm.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_jButtonXacNhanActionPerformed

    private void jButtonbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonbackActionPerformed
        // TODO add your handling code here:
        MainForm mf = new MainForm();
        mf.setVisible(true);
        mf.pack();
        mf.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButtonbackActionPerformed

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
            java.util.logging.Logger.getLogger(ListForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBexport;
    private javax.swing.JButton jButtonXacNhan;
    private javax.swing.JButton jButton_xem;
    private javax.swing.JButton jButtonback;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelsettingFile;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable_result;
    private javax.swing.JTextField jTextField_ten;
    private javax.swing.JTextField jTextFileName;
    // End of variables declaration//GEN-END:variables
}
