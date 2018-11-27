/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.DepartmentController;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Department;
import model.Employee;
import model.Location;
import tools.Connections;

/**
 *
 * @author yudafatah
 */
public class DepartmentView extends javax.swing.JInternalFrame {
    Connections connection = new Connections();
    DepartmentController departmentController = new DepartmentController(connection.getConnection());
    /**
     * Creates new form DepartmentView
     */
    public DepartmentView() {
        initComponents();
        getDatas(departmentController.selectDepartment());
        selectEmployeeId();
        selectLocatoId();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableDepart = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtDepartID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtDepartName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbxManagID = new javax.swing.JComboBox<>();
        cbxLocaId = new javax.swing.JComboBox<>();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        txtSearchId = new javax.swing.JTextField();
        txtSearch = new javax.swing.JTextField();
        btnSearchId = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();

        tableDepart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableDepart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDepartMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableDepart);

        jLabel1.setText("Department ID");

        jLabel2.setText("Department Name");

        jLabel3.setText("Manager ID");

        jLabel4.setText("Location ID");

        cbxManagID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbxLocaId.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnSearchId.setText("Search ID");
        btnSearchId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchIdActionPerformed(evt);
            }
        });

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDepartID)
                    .addComponent(txtDepartName)
                    .addComponent(cbxManagID, 0, 120, Short.MAX_VALUE)
                    .addComponent(cbxLocaId, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSearchId, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(txtSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSearchId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtDepartID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDepartName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave)
                    .addComponent(txtSearchId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchId))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbxManagID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbxLocaId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReset))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        if (btnSave.getText().equals("Save")){
        String idDepartment = txtDepartID.getText();
        String nameDepartment = txtDepartName.getText();
        String idManager = (String) cbxManagID.getSelectedItem();
        String idLocation = (String) cbxLocaId.getSelectedItem();
        
        if (!idDepartment.equals("") && !nameDepartment.equals("") && !idManager.equals("") && !idLocation.equals("")) {
            if (departmentController.insertDepartment(nameDepartment, idManager, idLocation,idDepartment)) {
                JOptionPane.showMessageDialog(null, "Insert departmen berhasil");
            } else {
                JOptionPane.showMessageDialog(null, "Insert departmen gagal");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Form input tidak boleh kosong");
        }
        
        getDatas(departmentController.selectDepartment());
        }
        if (btnSave.getText().equals("Update")){
            String idDepartment = txtDepartID.getText();
        String nameDepartment = txtDepartName.getText();
        String idManager = (String) cbxManagID.getSelectedItem();
        String idLocation = (String) cbxLocaId.getSelectedItem();
        
        if (!idDepartment.equals("") && !nameDepartment.equals("") && !idManager.equals("") && !idLocation.equals("")) {
            if (departmentController.updateDepartment(nameDepartment, idManager, idLocation, idDepartment) == true) {
                JOptionPane.showMessageDialog(null, "Update departmen berhasil");
            } else {
                JOptionPane.showMessageDialog(null, "Update departmen gagal");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Form input tidak boleh kosong");
        }
        
            getDatas(departmentController.selectDepartment());
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void tableDepartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDepartMouseClicked
        // TODO add your handling code here:
        int baris = tableDepart.getSelectedRow();
        int kolom = tableDepart.getSelectedColumn();
        String dataTerpilih = tableDepart.getValueAt(baris, kolom).toString();
        String idDepartment = tableDepart.getValueAt(baris, 0).toString();
        String nameDepartment = tableDepart.getValueAt(baris, 1).toString();
        String idManager = tableDepart.getValueAt(baris, 2).toString();
        String idLocation = tableDepart.getValueAt(baris, 3).toString();

        //set from
        txtDepartID.setEditable(false);
        txtDepartID.setText(idDepartment);
        txtDepartName.setText(nameDepartment);
        cbxManagID.setSelectedItem(idManager);
        cbxLocaId.setSelectedItem(idLocation);
        
        btnSave.setText("Update");
    }//GEN-LAST:event_tableDepartMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        /**
         * execute delete function with parameter got from textfield values
         */
        if(txtDepartID!=null){
            if(departmentController.deleteDepartment(txtDepartID.getText())==true){
                JOptionPane.showMessageDialog(null, "Data dengan id = " + txtDepartID.getText()+" berhasil dihapus");
            }
            else{
                JOptionPane.showMessageDialog(null, "Gagal menghapus data!");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Form input tidak boleh kosong");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSearchIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchIdActionPerformed
        // TODO add your handling code here:
        getDatas(departmentController.getById(txtSearchId.getText()));
    }//GEN-LAST:event_btnSearchIdActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        getDatas(departmentController.searchDepartment(txtSearch.getText()));
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        txtDepartID.setEditable(true);
        txtDepartID.setText("");
        txtDepartName.setText("");
        cbxManagID.setSelectedItem("");
        cbxLocaId.setSelectedItem("");
        txtSearchId.setText("");
        txtSearch.setText("");
        btnSave.setText("Save");
    }//GEN-LAST:event_btnResetActionPerformed

    private void getDatas(List<Department> dpm){
        Object[] header = {"Department ID", "Department Name", "Manager ID", "Location ID"};
        DefaultTableModel data = new DefaultTableModel(null, header);
        tableDepart.setModel(data); 
        try {
            for (Department department : dpm) {
                String isi1 = String.valueOf(department.getDepartmentId());
                String isi2 = department.getDepartmentName();
                String isi3 = String.valueOf(department.getManagerId());
                String isi4 = String.valueOf(department.getLocationId());

                String kolom[] = {isi1, isi2, isi3, isi4};
                data.addRow(kolom);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Oops! : " + e.getMessage());
        }
    }
    public void selectEmployeeId() {
        String employeeId;
        try {
            for (Employee employee : departmentController.selectEmployeeId()) {
                employeeId = String.valueOf(employee.getEmployeeId());
                cbxManagID.addItem(employeeId);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "selectEmployeeId is " + e.getMessage());
        }
    }
    /**
     * select locationid for combo box location id
     */
    public void selectLocatoId() {
         String locationId;
        try {
            for (Location location : departmentController.selectLocationId()) {
                locationId = String.valueOf(location.getLocationId());
                cbxLocaId.addItem(locationId);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "selectLocationId is " + e.getMessage());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSearchId;
    private javax.swing.JComboBox<String> cbxLocaId;
    private javax.swing.JComboBox<String> cbxManagID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableDepart;
    private javax.swing.JTextField txtDepartID;
    private javax.swing.JTextField txtDepartName;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSearchId;
    // End of variables declaration//GEN-END:variables
}
