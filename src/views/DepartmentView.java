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
    Connections con = new Connections();
    DepartmentController departmentController = new DepartmentController(con.getConnection());
    /**
     * Creates new form DepartmentView
     */
    public DepartmentView() {
        initComponents();
        reset();
        selectEmployeeId();
        selectLocatoId();
    }
    
    public void reset() {
        txtDepartID.setEditable(false);
        txtDepartID.setText(String.valueOf(departmentController.maxDepartmentId()));
        txtDepartName.setText("");
        txtSearch.setText("");
        txtSearchId.setText("");
        //btnDelete.setEnabled(false);
        btnSave.setText("Save");
        cbxManagID.setSelectedItem("Pilih Manager");
        cbxLocaId.setSelectedItem("Pilih Location");
        getDatas(departmentController.selectDepartment());
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

        setClosable(true);
        setMaximizable(true);
        setResizable(true);

        tableDepart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Department ID", "Department Name", "Manager", "Location"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableDepart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDepartMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableDepart);
        if (tableDepart.getColumnModel().getColumnCount() > 0) {
            tableDepart.getColumnModel().getColumn(0).setResizable(false);
            tableDepart.getColumnModel().getColumn(1).setResizable(false);
            tableDepart.getColumnModel().getColumn(2).setResizable(false);
            tableDepart.getColumnModel().getColumn(3).setResizable(false);
            tableDepart.getColumnModel().getColumn(4).setResizable(false);
        }

        jLabel1.setText("Department ID");

        txtDepartID.setEditable(false);

        jLabel2.setText("Department Name");

        jLabel3.setText("Manager");

        jLabel4.setText("Location");

        cbxManagID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Manager" }));

        cbxLocaId.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Location" }));

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
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cbxLocaId, 0, 608, Short.MAX_VALUE)
                                .addComponent(cbxManagID, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtDepartID)
                                .addComponent(txtDepartName))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSave)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnDelete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(17, 17, 17))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 749, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtSearchId, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSearchId)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 17, Short.MAX_VALUE))))
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
                    .addComponent(txtDepartName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbxManagID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbxLocaId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnDelete)
                    .addComponent(btnReset))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearch)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchId)
                    .addComponent(txtSearchId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            String idMng= idManager.substring(0, idManager.indexOf(" ")); 
            String idLcn= idLocation.substring(0, idLocation.indexOf(" "));
            if (!idDepartment.equals("") && !nameDepartment.equals("") && !idManager.equals("Pilih Manager") && !idDepartment.equals("Pilih Location")) {
                if (departmentController.insertDepartment(nameDepartment, idMng, idLcn,idDepartment)) {
                    JOptionPane.showMessageDialog(null, "Insert departmen berhasil");
                    reset();
                } else {
                    JOptionPane.showMessageDialog(null, "Insert departmen gagal");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Form input tidak boleh kosong");
            }
        }
        if (btnSave.getText().equals("Update")){
            String idDepartment = txtDepartID.getText();
            String nameDepartment = txtDepartName.getText();
            String idManager = (String) cbxManagID.getSelectedItem();
            String idLocation = (String) cbxLocaId.getSelectedItem();
            String idMng= idManager.substring(0, idManager.indexOf(" ")); 
            String idLcn= idLocation.substring(0, idLocation.indexOf(" "));
            if (!idDepartment.equals("") && !nameDepartment.equals("")) {
                if (departmentController.updateDepartment(nameDepartment, idMng, idLcn, idDepartment)) {
                    JOptionPane.showMessageDialog(null, "Update departmen berhasil");
                    reset();
                } else {
                    JOptionPane.showMessageDialog(null, "Update departmen gagal");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Form input tidak boleh kosong");
            } 
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void tableDepartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDepartMouseClicked
        // TODO add your handling code here:
        int baris = tableDepart.getSelectedRow();
        int kolom = tableDepart.getSelectedColumn();
        String dataTerpilih = tableDepart.getValueAt(baris, kolom).toString();
        String idDepartment = tableDepart.getValueAt(baris, 1).toString();
        String nameDepartment = tableDepart.getValueAt(baris, 2).toString();
        String idManager = tableDepart.getValueAt(baris, 3).toString();
        String idLocation = tableDepart.getValueAt(baris, 4).toString();

        //set from
        txtDepartID.setEditable(false);
        txtDepartID.setText(idDepartment);
        txtDepartName.setText(nameDepartment);
        String employeeName="";
        String city="";
        try {
            for (Employee employee : departmentController.getManagerName(idManager)) {
                employeeName = employee.getLastName();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "selectEmployeeId is " + e.getMessage());
        }
        try {
            for (Location location : departmentController.getCity(idLocation)) {
                city = location.getCity();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "selectEmployeeId is " + e.getMessage());
        }
        String mixMng = idManager +" "+employeeName;
        String mixLcn = idLocation +" "+city;
        if (idManager.equals("0")) {
            cbxManagID.setSelectedItem("Pilih Manager");
            cbxLocaId.setSelectedItem(idLocation);
        } else if (idLocation.equals("0")) {
            cbxManagID.setSelectedItem(idManager);
            cbxLocaId.setSelectedItem("Pilih Location");
        } else if (idManager.equals("0") && idLocation.equals("0")) {
            cbxManagID.setSelectedItem("Pilih Manager");
            cbxLocaId.setSelectedItem("Pilih Location");
        } else {
            cbxManagID.setSelectedItem(mixMng);
            cbxLocaId.setSelectedItem(mixLcn);
        }
        btnSave.setText("Update");
    }//GEN-LAST:event_tableDepartMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        if(!txtDepartID.getText().equals("") && !txtDepartName.getText().equals("")){
            int dialogButton = 0;
            int dialog = JOptionPane.showConfirmDialog (null, "Yakin hapus data?","Warning",dialogButton);
            if(dialog == JOptionPane.YES_OPTION){
                if(departmentController.deleteDepartment(txtDepartID.getText())){
                    JOptionPane.showMessageDialog(null, "Data dengan id : " + txtDepartID.getText()+" berhasil "
                            + "dihapus");
                    reset();
                } else{
                    JOptionPane.showMessageDialog(null, "Gagal menghapus data!");
                    reset();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Pilih data yang ingin dihapus!");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSearchIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchIdActionPerformed
        // TODO add your handling code here:
        if (!txtSearchId.getText().equals("")) {
            getDatas(departmentController.getById(txtSearchId.getText()));
        } else {
            JOptionPane.showMessageDialog(null, "Form input tidak boleh kosong");
        }
        
    }//GEN-LAST:event_btnSearchIdActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        if (!txtSearch.getText().equals("")) {
            getDatas(departmentController.searchDepartment(txtSearch.getText()));
        } else {
            JOptionPane.showMessageDialog(null, "Form input tidak boleh kosong");
        }
            
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_btnResetActionPerformed

    private void getDatas(List<Department> dpm){
        Object[] header = {"No", "Department ID", "Department Name", "Manager", "Location"};
        DefaultTableModel data = new DefaultTableModel(null, header);
        tableDepart.setModel(data);
        int no=1;
        try {
            for (Department department : dpm) {
                no++;
                String isi0 = String.valueOf(no);
                String isi1 = String.valueOf(department.getDepartmentId());
                String isi2 = department.getDepartmentName();
                String isi3 = String.valueOf(department.getManagerId());
                String isi4 = String.valueOf(department.getLocationId());

                String kolom[] = {isi0, isi1, isi2, isi3, isi4};
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
                String employeeName = employee.getLastName();
                String mix = employeeId +" "+ employeeName;
                cbxManagID.addItem(mix);
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
         String city;
        try {
            for (Location location : departmentController.selectLocationId()) {
                locationId = String.valueOf(location.getLocationId());
                city = location.getCity();
                String mix = locationId + " " + city;
                cbxLocaId.addItem(mix);
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
