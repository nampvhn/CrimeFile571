/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.hna.gui;

import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import vn.hna.db.CriminalsDB;
import vn.hna.db.PostmortemDB;
import vn.hna.entity.Criminals;
import vn.hna.entity.Postmortems;
import static vn.hna.gui.PnlCriminal.selectedRow;
import vn.hna.util.DateTools;

/**
 *
 * @author Edison
 */
public class PnlPostmortem extends javax.swing.JPanel {

    Vector vColumnHeader = null;
    Vector vData = null; // Lay tu vAll
    Vector<Postmortems> vAll = null; // Load tu SQLServer
    DefaultTableModel tblModel = null;
    static int selectedRow = 0;

    FrmMain frmMain = null;

    /**
     * Creates new form PnlRole
     */
    public PnlPostmortem() {
        initComponents();

        loadColumnHeader();
        loadTable(); // Lay dc vData
        tblModel.setDataVector(vData, vColumnHeader);

        sortColumn();
        
        if ("User".equalsIgnoreCase(FrmLogin.roleName)) {
            lock();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblCriminal = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));

        tblCriminal.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblCriminal);

        btnAdd.setText("Add New");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnEdit.setText("View / Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete)
                        .addGap(57, 57, 57)
                        .addComponent(btnSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearch)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAdd, btnDelete, btnEdit, btnSearch});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnEdit)
                    .addComponent(btnDelete)
                    .addComponent(btnSearch)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(75, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        DlgCriminalAdd dlg = new DlgCriminalAdd(frmMain, true);
        this.setVisible(false);
        dlg.setVisible(true);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        try {

            selectedRow = tblCriminal.getSelectedRow();
            if (selectedRow < 0) {
                JOptionPane.showMessageDialog(this, "You must choose one row.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            DlgCriminalEdit editDialog = new DlgCriminalEdit(frmMain, true);
            this.setVisible(false);
            editDialog.setVisible(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return;
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        PostmortemDB c = new PostmortemDB();
        try {

            selectedRow = tblCriminal.getSelectedRow();
            if (selectedRow < 0) {
                JOptionPane.showMessageDialog(this, "You must choose a row.", "Message", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            Vector vRow = (Vector) vData.get(selectedRow);
            Postmortems criminal = new Postmortems();
            criminal.setPostmortemID(Integer.parseInt(vRow.get(0).toString()));
            int id = criminal.getPostmortemID();

            int choose = JOptionPane.showConfirmDialog(this, "Are you sure to delete this? Y/N?", "Comfirm", JOptionPane.YES_NO_OPTION);
            if (choose == JOptionPane.YES_OPTION) {
                boolean del = c.delete(id);
                if (del) {
                    JOptionPane.showMessageDialog(this, "Deleted.", "Message", JOptionPane.INFORMATION_MESSAGE);
                    loadTable();
                    tblModel.setDataVector(vData, vColumnHeader);
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return;
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        Vector<Postmortems> vFilter = null;
        try {
            vFilter = this.searchByName(vAll, txtSearch.getText().trim());
            if (vFilter == null) {
                JOptionPane.showMessageDialog(this, "Can not found anything.", "Infomation", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            tblModel.setDataVector((Vector) loadData(vFilter), vColumnHeader);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return;
        }
    }//GEN-LAST:event_btnSearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSearch;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCriminal;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

    public Vector loadColumnHeader() {
        vColumnHeader = new Vector();
        try {
            vColumnHeader.add("ID");
            vColumnHeader.add("Victim Name");
            vColumnHeader.add("DateOfDeath");
            vColumnHeader.add("Reason");
            vColumnHeader.add("Doctor Name");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return vColumnHeader;
    }

    public void loadTable() {
        PostmortemDB c = new PostmortemDB();
        try {
            tblModel = (DefaultTableModel) tblCriminal.getModel();
            vAll = (Vector<Postmortems>) c.viewPostmortems();
            if (vAll.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No data.", "Information", JOptionPane.INFORMATION_MESSAGE);
            }
            loadData(vAll);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List loadData(List<Postmortems> listAll) {
        DateTools dt = new DateTools();
        try {
            if (listAll.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No data.", "Information", JOptionPane.INFORMATION_MESSAGE);
            }

            vData = new Vector();
            for (Postmortems criminal : listAll) {
                Vector vRow = new Vector();

                vRow.add(criminal.getPostmortemID());
                vRow.add(criminal.getVictimID().getFullName());
                vRow.add(dt.formatedDate(criminal.getDateOfDeath(), "yyyy-MM-dd"));
                vRow.add(criminal.getReason());
                vRow.add(criminal.getDoctorName());

                vData.add(vRow);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return vData;
    }

    private void sortColumn() {
        try {
            tblCriminal.getTableHeader().setToolTipText("Click here to sort.");
            tblCriminal.setAutoCreateRowSorter(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Vector searchByName(Vector<Postmortems> v, String byName) {
        Vector<Postmortems> vFilter = new Vector();
        try {
            for (Postmortems criminal : v) {
                if (criminal.getVictimID().getFullName().toUpperCase().contains(byName.toUpperCase())) {
                    vFilter.add(criminal);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return vFilter;
    }
    
    public void lock() {
        btnAdd.setVisible(false);
        //btnEdit.setVisible(false);
        btnDelete.setVisible(false);
    }
}
