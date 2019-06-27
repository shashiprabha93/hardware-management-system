/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.forms.Tarnsaport;

import Controller.TransportController;
import application.entity.Transport;
import application.forms.Customer.CustomerView;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class VehicleAdd extends javax.swing.JDialog {
    private TransportController transportController;
    private VehicleView vehicleView1;
    

    /**
     * Creates new form VehicleAdd
     */
    public VehicleAdd(java.awt.Dialog parent, boolean modal,VehicleView vehicleView1) {
        super(parent, modal);
        setResizable(false);
        initComponents();
        setLocationRelativeTo(this);
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
        txtVregistration = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtBrand = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnVehicleAdd = new javax.swing.JButton();
        btnCansel = new javax.swing.JButton();
        txtModel = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        combType = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Vehicale Add");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Vehicle Registration");

        txtVregistration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVregistrationActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Brand");

        txtBrand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBrandActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Model");

        btnVehicleAdd.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnVehicleAdd.setText("Add");
        btnVehicleAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVehicleAddActionPerformed(evt);
            }
        });

        btnCansel.setText("Cansel");
        btnCansel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCanselActionPerformed(evt);
            }
        });

        jLabel2.setText("Type");

        combType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Internal Vehicle", "External Vehicle" }));
        combType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combTypeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVehicleAdd)
                .addGap(18, 18, 18)
                .addComponent(btnCansel)
                .addGap(20, 20, 20))
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtModel)
                    .addComponent(combType, 0, 143, Short.MAX_VALUE)
                    .addComponent(txtBrand)
                    .addComponent(txtVregistration))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtVregistration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtBrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(combType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVehicleAdd)
                    .addComponent(btnCansel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtVregistrationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVregistrationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVregistrationActionPerformed

    private void txtBrandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBrandActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBrandActionPerformed

    private void btnVehicleAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVehicleAddActionPerformed

        Transport transport = new Transport();
        TransportController transportController = new TransportController();
        transport.setvNumber(txtVregistration.getText().trim());
        transport.setBrand(txtBrand.getText().trim());
        transport.setModel(txtModel.getText().trim());
        transport.setType(combType.getSelectedItem().toString());
        transport.setStatus(true);

        if (transportController.save(transport)) {
            JOptionPane.showMessageDialog(this, "Vehicle added successfully. ", "Success Message", JOptionPane.INFORMATION_MESSAGE);
            transportController.getAllVehicle(vehicleView1.modelVehicle);
            clearFileds();
            txtVregistration.requestFocus();
        } else {
            JOptionPane.showMessageDialog(this, "Error in Vehicle adding.", "Error Message", JOptionPane.ERROR_MESSAGE);
            txtVregistration.requestFocus();
        }

    }//GEN-LAST:event_btnVehicleAddActionPerformed

    private void btnCanselActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCanselActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCanselActionPerformed

    private void combTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combTypeActionPerformed

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
            java.util.logging.Logger.getLogger(VehicleAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VehicleAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VehicleAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VehicleAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VehicleAdd dialog = new VehicleAdd(new javax.swing.JDialog(), true,null);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    
     private void clearFileds() {
        txtVregistration.setText("");
        txtBrand.setText("");
        txtModel.setText("");
        txtVregistration.requestFocus();
        
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCansel;
    private javax.swing.JButton btnVehicleAdd;
    private javax.swing.JComboBox<String> combType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtBrand;
    private javax.swing.JTextField txtModel;
    private javax.swing.JTextField txtVregistration;
    // End of variables declaration//GEN-END:variables
}
