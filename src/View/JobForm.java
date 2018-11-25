/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.JobController;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.Job;
import tools.Connections;

/**
 *
 * @author AD
 */
public class JobForm extends javax.swing.JFrame {

    Connections con = new Connections();
    JobController jc = new JobController(con.getConnection());

    /**
     * Creates new form JobForm
     */
    public JobForm() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtJobId = new javax.swing.JTextField();
        txtJobTitle = new javax.swing.JTextField();
        txtMinSalary = new javax.swing.JTextField();
        txtMaxSalary = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableJob = new javax.swing.JTable();
        btnGetAll = new javax.swing.JButton();
        btnInsert = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        btnSearchId = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Job ID             :");

        jLabel2.setText("Job Title          :");

        jLabel3.setText("Min Salary       :");

        jLabel4.setText("Max Salary     :");

        tableJob.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "", "", "", ""
            }
        ));
        tableJob.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableJobMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableJob);

        btnGetAll.setText("Show Data");
        btnGetAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGetAllMouseClicked(evt);
            }
        });

        btnInsert.setText("Save");
        btnInsert.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInsertMouseClicked(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteMouseClicked(evt);
            }
        });

        btnSearch.setText("Search");
        btnSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSearchMouseClicked(evt);
            }
        });

        btnSearchId.setText("Search By ID");
        btnSearchId.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSearchIdMouseClicked(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdateMouseClicked(evt);
            }
        });

        btnClear.setText("Clear");
        btnClear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnClearMouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("TABLE JOBS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnGetAll)
                        .addGap(145, 145, 145)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(242, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(btnClear, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                                            .addComponent(txtMaxSalary, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtMinSalary, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addGap(18, 18, 18))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel2))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtJobTitle)
                                            .addComponent(txtJobId))
                                        .addGap(18, 18, 18)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnInsert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnSearchId, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(22, 22, 22))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(btnInsert)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtJobId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(btnDelete)
                    .addComponent(txtJobTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMinSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate)
                    .addComponent(jLabel3))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSearchId, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(txtSearch)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnGetAll)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaxSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnClear)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGetAllMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGetAllMouseClicked
        Object[] header = {"Job ID", "Job Title", "Min Salary", "Max Salary"};
        DefaultTableModel data = new DefaultTableModel(null, header);
        tableJob.setModel(data);

        try {
            for (Job job : jc.getAllJob()) {
                String isi1 = job.getJobId();
                String isi2 = job.getJobTitle();
                String isi3 = String.valueOf(job.getMinSalary());
                String isi4 = String.valueOf(job.getMaxSalary());

                String kolom[] = {isi1, isi2, isi3, isi4};
                data.addRow(kolom);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Oops! : " + e.getMessage());
        }
    }//GEN-LAST:event_btnGetAllMouseClicked

    private void btnInsertMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInsertMouseClicked
        String jobId = txtJobId.getText();
        String jobTitle = txtJobTitle.getText();
        String minSalary = (String) txtMinSalary.getText();
        String maxSalary = (String) txtMaxSalary.getText();

        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(this, "Data akan di tambahkan ?",
                "Insert Data", dialogButton);
        if (dialogResult == 0) {
            if (!jobId.equals("") && !jobTitle.equals("") && !minSalary.equals("") && !maxSalary.equals("")) {
                if (jc.insert(jobId, jobTitle, minSalary, maxSalary) == true) {
                    JOptionPane.showMessageDialog(null, "Insert Data Berhasil !");
                } else {
                    JOptionPane.showMessageDialog(null, "Insert Data Gagal !", "Message Alert",
                            JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Form input tidak boleh kosong !", "Message Alert",
                        JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnInsertMouseClicked

    private void btnDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseClicked
        String jobId = txtJobId.getText();
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(this, "Data akan di hapus ?",
                "Hapus Data", dialogButton);

        if (dialogResult == 0) {
            if (!jobId.equals("")) {
                if (jc.delete(jobId) == true) {
                    JOptionPane.showMessageDialog(null, "Data berhasil di Hapus !");
                } else {
                    JOptionPane.showMessageDialog(null, "Data ini tidak dapat di hapus !", "Message Alert",
                            JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Form input tidak boleh kosong", "Message Alert",
                        JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnDeleteMouseClicked

    private void tableJobMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableJobMouseClicked
        txtJobId.setEditable(false);

        int i = tableJob.getSelectedRow();
        TableModel model = tableJob.getModel();
        txtJobId.setText(model.getValueAt(i, 0).toString());
        txtJobTitle.setText(model.getValueAt(i, 1).toString());
        txtMinSalary.setText(model.getValueAt(i, 2).toString());
        txtMaxSalary.setText(model.getValueAt(i, 3).toString());
    }//GEN-LAST:event_tableJobMouseClicked

    private void btnSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseClicked
        Object[] header = {"Job ID", "Job Title", "Min Salary", "Max Salary"};
        DefaultTableModel data = new DefaultTableModel(null, header);
        tableJob.setModel(data);

        try {
            String object = txtSearch.getText();
            for (Job job : jc.searchByJobs(object)) {
                String isi1 = job.getJobId();
                String isi2 = job.getJobTitle();
                String isi3 = String.valueOf(job.getMinSalary());
                String isi4 = String.valueOf(job.getMaxSalary());

                String kolom[] = {isi1, isi2, isi3, isi4};
                data.addRow(kolom);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Oops! : " + e.getMessage());
        }
    }//GEN-LAST:event_btnSearchMouseClicked

    private void btnUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseClicked
        String jobId = txtJobId.getText();
        String jobTitle = txtJobTitle.getText();
        String minSalary = (String) txtMinSalary.getText();
        String maxSalary = (String) txtMaxSalary.getText();

        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(this, "Data akan di update ?",
                "Update Data", dialogButton);

        if (dialogResult == 0) {
            if (!jobId.equals("") && !jobTitle.equals("") && !minSalary.equals("") && !maxSalary.equals("")) {
                if (jc.update(jobId, jobTitle, minSalary, maxSalary) == true) {
                    JOptionPane.showMessageDialog(null, "Data berhasil di Update !");
                } else {
                    JOptionPane.showMessageDialog(null, "Update Data gagal !", "Message Alert",
                            JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Form input tidak boleh kosong !", "Message Alert",
                        JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnUpdateMouseClicked

    private void btnClearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClearMouseClicked
        txtJobId.setEditable(true);

        txtJobId.setText("");
        txtJobTitle.setText("");
        txtMinSalary.setText("");
        txtMaxSalary.setText("");
        txtSearch.setText("");
    }//GEN-LAST:event_btnClearMouseClicked

    private void btnSearchIdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchIdMouseClicked

        Object[] header = {"Job ID", "Job Title", "Min Salary", "Max Salary"};
        DefaultTableModel data = new DefaultTableModel(null, header);
        tableJob.setModel(data);

        try {
            String jobId = txtSearch.getText();
            for (Job job : jc.getById(jobId)) {
                String isi1 = job.getJobId();
                String isi2 = job.getJobTitle();
                String isi3 = String.valueOf(job.getMinSalary());
                String isi4 = String.valueOf(job.getMaxSalary());

                String kolom[] = {isi1, isi2, isi3, isi4};
                data.addRow(kolom);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Oops! : " + e.getMessage());
        }
    }//GEN-LAST:event_btnSearchIdMouseClicked

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
            java.util.logging.Logger.getLogger(JobForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JobForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JobForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JobForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JobForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnGetAll;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSearchId;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableJob;
    private javax.swing.JTextField txtJobId;
    private javax.swing.JTextField txtJobTitle;
    private javax.swing.JTextField txtMaxSalary;
    private javax.swing.JTextField txtMinSalary;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
