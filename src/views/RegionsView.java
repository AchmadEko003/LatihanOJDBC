/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.RegionController;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.Region;
import tools.Connections;

/**
 *
 * @author Nitani
 */
public class RegionsView extends javax.swing.JInternalFrame {

    Connections con = new Connections();
    RegionController regionController = new RegionController(con.getConnection());

    /**
     * Creates new form RegionsView
     */
    public RegionsView() {
        initComponents();
        bindingTable(regionController.gets());
        update_Button.setEnabled(false);
        deletebutton.setEnabled(false);
        btnNewRegion.setEnabled(false);
        txtRegionId.setEditable(false);
        txtRegionId.setText(String.valueOf(regionController.maxRegionId()));
    }

    /**
     *
     */
    public void getTextInput() {
        String regionId = txtRegionId.getText();
        String regionName = txtRegionName.getText();
    }

    /**
     *
     * @param regions
     */
    public void bindingTable(List<Region> regions) {
        Object[] header = {"No", "Region_Id", "Region_Name"};
        DefaultTableModel model = new DefaultTableModel(null, header);
        getidTable.setModel(model);

        try {
            int no = 1;
            for (Region region : regions) {
                String isi0 = String.valueOf(no);
                String isi1 = String.valueOf(region.getRegionId());
                String isi2 = region.getRegionName();

                String kolom[] = {isi0, isi1, isi2};
                model.addRow(kolom);
                no++;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ops! " + e.getMessage());
        }
    }
    


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        insertbutton = new javax.swing.JButton();
        txtRegionId = new javax.swing.JTextField();
        deletebutton = new javax.swing.JButton();
        update_Button = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        getidTable = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtRegionName = new javax.swing.JTextField();
        btnNewRegion = new javax.swing.JButton();

        setClosable(true);
        setTitle("Region Views");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        insertbutton.setText("Save");
        insertbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertbuttonActionPerformed(evt);
            }
        });

        txtRegionId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRegionIdsearchID(evt);
            }
        });

        deletebutton.setText("Delete");
        deletebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebuttonActionPerformed(evt);
            }
        });

        update_Button.setText("Update");
        update_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_ButtonActionPerformed(evt);
            }
        });

        jLabel4.setText("Region Name");

        getidTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "REGION_ID", "REGION_NAME"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        getidTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                getidTabletableClick(evt);
            }
        });
        jScrollPane4.setViewportView(getidTable);

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchKeyPressed(evt);
            }
        });

        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("Region ID");

        txtRegionName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRegionNameActionPerformed(evt);
            }
        });

        btnNewRegion.setText("New Data");
        btnNewRegion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNewRegionMouseClicked(evt);
            }
        });
        btnNewRegion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewRegionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchButton))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtRegionId, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtRegionName, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 10, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnNewRegion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(update_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(insertbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(deletebutton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchButton)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtRegionId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtRegionName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(update_Button)
                    .addComponent(insertbutton)
                    .addComponent(deletebutton)
                    .addComponent(btnNewRegion))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void insertbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertbuttonActionPerformed

        // TODO add your handling code here:
        String regionId = txtRegionId.getText();
        String regionName = txtRegionName.getText();

        if (!regionId.equals("") && !regionName.equals("")) {
            if (regionController.insert(regionName, regionId)) {
                JOptionPane.showMessageDialog(null, "insert berhasil");
                txtRegionName.setText("");
                txtRegionId.setText("");
                bindingTable(regionController.gets());
                txtRegionId.setText(String.valueOf(regionController.maxRegionId()));
            } else {
                JOptionPane.showMessageDialog(null, "insert gagal");
            }

        } else {
            JOptionPane.showMessageDialog(null, "form input tidak boleh kosong");
        }
    }//GEN-LAST:event_insertbuttonActionPerformed

    private void txtRegionIdsearchID(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRegionIdsearchID
        // TODO add your handling code here:                       
        bindingTable(regionController.getid(txtRegionId.getText()));
    }//GEN-LAST:event_txtRegionIdsearchID

    private void deletebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebuttonActionPerformed
        // TODO add your handling code here:   
        int Pilih = JOptionPane.showConfirmDialog(null, "Yakin akan menghapus data ?", "Pertanyaan", JOptionPane.YES_NO_OPTION);
        if (Pilih == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Hapus data ?");
            String nil = txtRegionId.getText();
            regionController.delete(nil);
            bindingTable(regionController.gets());

            txtRegionId.setText("");
            txtRegionName.setText("");
            deletebutton.setEnabled(false);
            update_Button.setEnabled(false);
            insertbutton.setEnabled(true);
        } else if (Pilih == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(null, "Batalkan hapus data ?");
        }
    }//GEN-LAST:event_deletebuttonActionPerformed

    private void update_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_ButtonActionPerformed
        // TODO add your handling code here:
        String nameRegion = txtRegionName.getText();
        int idRegion = Integer.valueOf(txtRegionId.getText());

        if (regionController.update(nameRegion, idRegion) == true) {
            JOptionPane.showMessageDialog(null, "Update Berhasil");
            txtRegionId.setText("");
            txtRegionName.setText("");
            deletebutton.setEnabled(true);
            insertbutton.setEnabled(true);
            deletebutton.setEnabled(true);
            update_Button.setEnabled(false);
            bindingTable(regionController.gets());
        } else {
            JOptionPane.showMessageDialog(null, "Update Gagal");
        }
    }//GEN-LAST:event_update_ButtonActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void txtSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyPressed
        // TODO add your handling code here:
        bindingTable(regionController.find(txtSearch.getText()));
        txtRegionId.setText("");
        txtRegionName.setText("");
    }//GEN-LAST:event_txtSearchKeyPressed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        // TODO add your handling code here:
        bindingTable(regionController.find(txtSearch.getText()));
        txtRegionId.setEditable(false);
        update_Button.setEnabled(false);
        deletebutton.setEnabled(false);
        insertbutton.setEnabled(true);
        txtRegionId.setText(String.valueOf(regionController.maxRegionId()));
    }//GEN-LAST:event_searchButtonActionPerformed

    private void txtRegionNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRegionNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRegionNameActionPerformed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        // TODO add your handling code here:
    }//GEN-LAST:event_formInternalFrameActivated

    private void getidTabletableClick(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_getidTabletableClick
        // TODO add your handling code here:
        int i = getidTable.getSelectedRow();
        TableModel model = getidTable.getModel();
        txtRegionId.setText(model.getValueAt(i, 1).toString());
        txtRegionName.setText(model.getValueAt(i, 2).toString());
        deletebutton.setEnabled(true);
        insertbutton.setEnabled(false);
        update_Button.setEnabled(true);
        btnNewRegion.setEnabled(true);
    }//GEN-LAST:event_getidTabletableClick

    private void btnNewRegionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewRegionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNewRegionActionPerformed

    private void btnNewRegionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNewRegionMouseClicked
        // TODO add your handling code here:
        txtRegionId.setText("");
        txtRegionName.setText("");
        txtSearch.setText("");
        deletebutton.setEnabled(false);
        update_Button.setEnabled(false);
        insertbutton.setEnabled(true);
        txtRegionId.setText(String.valueOf(regionController.maxRegionId()));
    }//GEN-LAST:event_btnNewRegionMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNewRegion;
    private javax.swing.JButton deletebutton;
    private javax.swing.JTable getidTable;
    private javax.swing.JButton insertbutton;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField txtRegionId;
    private javax.swing.JTextField txtRegionName;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JButton update_Button;
    // End of variables declaration//GEN-END:variables
}
