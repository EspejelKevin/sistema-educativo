/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

/**
 *
 * @author kevin
 */
public class ProfesoresForm extends javax.swing.JInternalFrame {

    /**
     * Creates new form Profesores
     */
    public ProfesoresForm() {
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

        jLabel7 = new javax.swing.JLabel();
        txtRFC = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtNombreProfesor = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtDireccionProfesor = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        btnModificarProfesor = new javax.swing.JButton();
        btnGuardarProfesor = new javax.swing.JButton();
        btnEliminarProfesor = new javax.swing.JButton();
        btnBuscarProfesor = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        btnNuevoProfesor = new javax.swing.JButton();
        panelFotoProfesor = new javax.swing.JPanel();
        btnSeleccionarFotoProfesor = new javax.swing.JButton();
        btnLimpiarCamposProfesores = new javax.swing.JButton();
        btnHabilitarCamposProfesores = new javax.swing.JButton();
        txtTelefonoProfesor = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Teachers");

        jLabel7.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jLabel7.setText("RFC:");

        txtRFC.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        txtRFC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRFCActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jLabel8.setText("Name:");

        txtNombreProfesor.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        txtNombreProfesor.setEnabled(false);
        txtNombreProfesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreProfesorActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jLabel9.setText("Address:");

        txtDireccionProfesor.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        txtDireccionProfesor.setEnabled(false);
        txtDireccionProfesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionProfesorActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jLabel10.setText("Phone:");

        btnModificarProfesor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edituser.png"))); // NOI18N
        btnModificarProfesor.setToolTipText("Modify teacher");

        btnGuardarProfesor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/savechanges.png"))); // NOI18N
        btnGuardarProfesor.setToolTipText("Save teacher");

        btnEliminarProfesor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N
        btnEliminarProfesor.setToolTipText("Delete teacher");

        btnBuscarProfesor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        btnBuscarProfesor.setToolTipText("Search teacher");

        jLabel12.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jLabel12.setText("Photo:");

        btnNuevoProfesor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new user.png"))); // NOI18N
        btnNuevoProfesor.setToolTipText("New teacher");

        panelFotoProfesor.setBackground(new java.awt.Color(153, 204, 255));

        javax.swing.GroupLayout panelFotoProfesorLayout = new javax.swing.GroupLayout(panelFotoProfesor);
        panelFotoProfesor.setLayout(panelFotoProfesorLayout);
        panelFotoProfesorLayout.setHorizontalGroup(
            panelFotoProfesorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelFotoProfesorLayout.setVerticalGroup(
            panelFotoProfesorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 88, Short.MAX_VALUE)
        );

        btnSeleccionarFotoProfesor.setText("Select photo");
        btnSeleccionarFotoProfesor.setEnabled(false);
        btnSeleccionarFotoProfesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarFotoProfesorActionPerformed(evt);
            }
        });

        btnLimpiarCamposProfesores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clean.png"))); // NOI18N
        btnLimpiarCamposProfesores.setToolTipText("Clean fields");

        btnHabilitarCamposProfesores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/habilitar.png"))); // NOI18N
        btnHabilitarCamposProfesores.setToolTipText("Enable fields");

        txtTelefonoProfesor.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        txtTelefonoProfesor.setEnabled(false);
        txtTelefonoProfesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoProfesorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNuevoProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnGuardarProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnModificarProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnEliminarProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscarProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLimpiarCamposProfesores, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnHabilitarCamposProfesores, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNombreProfesor, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                            .addComponent(txtRFC, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDireccionProfesor)
                            .addComponent(txtTelefonoProfesor))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel12)
                            .addComponent(btnSeleccionarFotoProfesor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelFotoProfesor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtRFC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtNombreProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtDireccionProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtTelefonoProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelFotoProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSeleccionarFotoProfesor)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnModificarProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiarCamposProfesores, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNuevoProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardarProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHabilitarCamposProfesores, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtRFCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRFCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRFCActionPerformed

    private void txtNombreProfesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreProfesorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreProfesorActionPerformed

    private void txtDireccionProfesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionProfesorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionProfesorActionPerformed

    private void btnSeleccionarFotoProfesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarFotoProfesorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSeleccionarFotoProfesorActionPerformed

    private void txtTelefonoProfesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoProfesorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoProfesorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnBuscarProfesor;
    public javax.swing.JButton btnEliminarProfesor;
    public javax.swing.JButton btnGuardarProfesor;
    public javax.swing.JButton btnHabilitarCamposProfesores;
    public javax.swing.JButton btnLimpiarCamposProfesores;
    public javax.swing.JButton btnModificarProfesor;
    public javax.swing.JButton btnNuevoProfesor;
    public javax.swing.JButton btnSeleccionarFotoProfesor;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public javax.swing.JPanel panelFotoProfesor;
    public javax.swing.JTextField txtDireccionProfesor;
    public javax.swing.JTextField txtNombreProfesor;
    public javax.swing.JTextField txtRFC;
    public javax.swing.JTextField txtTelefonoProfesor;
    // End of variables declaration//GEN-END:variables
}
