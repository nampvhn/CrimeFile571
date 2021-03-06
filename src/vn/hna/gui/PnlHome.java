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
import vn.hna.db.ComplaintsDB;
import vn.hna.db.CriminalsDB;
import vn.hna.db.FIRsDB;
import vn.hna.entity.Criminals;
import vn.hna.util.DateTools;

/**
 *
 * @author Edison
 */
public class PnlHome extends javax.swing.JPanel {
    ComplaintsDB c = new ComplaintsDB();
    FIRsDB f = new FIRsDB();
    CriminalsDB cr = new CriminalsDB();
    
    Vector vColumnHeader = null;
    Vector vData = null; // Lay tu vAll
    Vector<Criminals> vAll = null; // Load tu SQLServer
    DefaultTableModel tblModel = null;
    static int selectedRow = 0;

    FrmMain frmMain = null;

    /**
     * Creates new form PnlHome
     */
    public PnlHome() {
        initComponents();
        
        lblNumOfComplaint.setText("Number of new complaint: " + c.numOfNewComplaint());
        lblNumOfFIR.setText("Number of new FIR: " + f.numOfNewFIR());
        //lblNumOfComplaint1.setText("Number of Juvendile deliquency: " + cr.numOfJuvenile());
        lblNumOfComplaint1.setVisible(false);
        
        loadColumnHeader();
        loadTable(); // Lay dc vData
        tblModel.setDataVector(vData, vColumnHeader);

        sortColumn();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNumOfComplaint = new javax.swing.JLabel();
        lblNumOfFIR = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCriminal = new javax.swing.JTable();
        btnEdit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblNumOfComplaint1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        lblNumOfComplaint.setText("Number of new complaint: ");

        lblNumOfFIR.setText("Number of new FIR");

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

        btnEdit.setText("View / Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setText("MOST WANTED");

        lblNumOfComplaint1.setText("Number of juvendile delinquency: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNumOfFIR)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNumOfComplaint)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblNumOfComplaint1)
                        .addGap(165, 165, 165))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(259, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEdit)
                    .addComponent(jLabel1))
                .addGap(253, 253, 253))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(21, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumOfComplaint)
                    .addComponent(lblNumOfComplaint1))
                .addGap(27, 27, 27)
                .addComponent(lblNumOfFIR)
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 249, Short.MAX_VALUE)
                .addComponent(btnEdit)
                .addGap(45, 45, 45))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(112, 112, 112)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(105, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        try {

            selectedRow = tblCriminal.getSelectedRow();
            if (selectedRow < 0) {
                JOptionPane.showMessageDialog(this, "You must choose one row.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            DlgWanted editDialog = new DlgWanted(frmMain, true);
            this.setVisible(false);
            editDialog.setVisible(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return;
        }
    }//GEN-LAST:event_btnEditActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEdit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNumOfComplaint;
    private javax.swing.JLabel lblNumOfComplaint1;
    private javax.swing.JLabel lblNumOfFIR;
    private javax.swing.JTable tblCriminal;
    // End of variables declaration//GEN-END:variables

    public Vector loadColumnHeader() {
        vColumnHeader = new Vector();
        try {
            vColumnHeader.add("Criminal ID");
            vColumnHeader.add("Full Name");
            vColumnHeader.add("Birthday");
            vColumnHeader.add("Image");
            vColumnHeader.add("IdentificationMark");
            //vColumnHeader.add("Crimes");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return vColumnHeader;
    }

    public void loadTable() {
        CriminalsDB c = new CriminalsDB();
        try {
            tblModel = (DefaultTableModel) tblCriminal.getModel();
            vAll = (Vector<Criminals>) c.getMostWantedList(true);
            if (vAll.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No data.", "Information", JOptionPane.INFORMATION_MESSAGE);
            }
            loadData(vAll);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List loadData(List<Criminals> listAll) {
        DateTools dt = new DateTools();
        try {
            if (listAll.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No data.", "Information", JOptionPane.INFORMATION_MESSAGE);
            }

            vData = new Vector();
            for (Criminals criminal : listAll) {
                Vector vRow = new Vector();

                vRow.add(criminal.getCriminalID());
                vRow.add(criminal.getFullName());
                vRow.add(dt.formatedDate(criminal.getBirthday(), "yyyy-MM-dd"));
                vRow.add(criminal.getImage1());
                vRow.add(criminal.getIdentificationMark());
//                List<CrimeCriminal> l = criminal.getCrimeCriminalList();
//                String crimeList = "";
//                for (CrimeCriminal cc : l) {
//                    crimeList += cc.getCrimeTypeID().getCrimeTypeName() + "; ";
//                }
//                vRow.add(crimeList);

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
}
