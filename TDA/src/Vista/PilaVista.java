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
public class PilaVista extends javax.swing.JInternalFrame {

    /**
     * Creates new form PilaVista
     */
    public PilaVista() {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        rbtnPush = new javax.swing.JRadioButton();
        rbtnPop = new javax.swing.JRadioButton();
        rbtnPopCualquiera = new javax.swing.JRadioButton();
        rbtnVaciarPila = new javax.swing.JRadioButton();
        rbtnTamanioPila = new javax.swing.JRadioButton();
        rbtnTope = new javax.swing.JRadioButton();
        rbtnMostrarPila = new javax.swing.JRadioButton();
        btnEjecutar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtDatoPush = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtDatoPop = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtDatosPila = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Pila");

        jPanel1.setBackground(new java.awt.Color(0, 204, 153));

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Pila");

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Seleccione una operación:");

        rbtnPush.setBackground(new java.awt.Color(0, 204, 153));
        rbtnPush.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        rbtnPush.setForeground(new java.awt.Color(255, 255, 255));
        rbtnPush.setText("Push");
        rbtnPush.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnPushActionPerformed(evt);
            }
        });

        rbtnPop.setBackground(new java.awt.Color(0, 204, 153));
        rbtnPop.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        rbtnPop.setForeground(new java.awt.Color(255, 255, 255));
        rbtnPop.setText("Pop");
        rbtnPop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnPopActionPerformed(evt);
            }
        });

        rbtnPopCualquiera.setBackground(new java.awt.Color(0, 204, 153));
        rbtnPopCualquiera.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        rbtnPopCualquiera.setForeground(new java.awt.Color(255, 255, 255));
        rbtnPopCualquiera.setText("Pop cualquiera");
        rbtnPopCualquiera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnPopCualquieraActionPerformed(evt);
            }
        });

        rbtnVaciarPila.setBackground(new java.awt.Color(0, 204, 153));
        rbtnVaciarPila.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        rbtnVaciarPila.setForeground(new java.awt.Color(255, 255, 255));
        rbtnVaciarPila.setText("Vaciar pila");
        rbtnVaciarPila.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnVaciarPilaActionPerformed(evt);
            }
        });

        rbtnTamanioPila.setBackground(new java.awt.Color(0, 204, 153));
        rbtnTamanioPila.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        rbtnTamanioPila.setForeground(new java.awt.Color(255, 255, 255));
        rbtnTamanioPila.setText("Tamaño de la pila");
        rbtnTamanioPila.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnTamanioPilaActionPerformed(evt);
            }
        });

        rbtnTope.setBackground(new java.awt.Color(0, 204, 153));
        rbtnTope.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        rbtnTope.setForeground(new java.awt.Color(255, 255, 255));
        rbtnTope.setText("¿Cuál es el tope de la pila?");
        rbtnTope.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnTopeActionPerformed(evt);
            }
        });

        rbtnMostrarPila.setBackground(new java.awt.Color(0, 204, 153));
        rbtnMostrarPila.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        rbtnMostrarPila.setForeground(new java.awt.Color(255, 255, 255));
        rbtnMostrarPila.setText("Mostrar pila");
        rbtnMostrarPila.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnMostrarPilaActionPerformed(evt);
            }
        });

        btnEjecutar.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        btnEjecutar.setText("Ejecutar");
        btnEjecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEjecutarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Escriba aquí un dato:");

        txtDatoPush.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 2, 10)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("El dato debe ir ligado con la operación push.");

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Dato a popear:");

        txtDatoPop.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        txtDatoPop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDatoPopActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 2, 10)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Este dato define el límite del popeamiento.");

        jPanel2.setBackground(new java.awt.Color(255, 255, 102));
        jPanel2.setToolTipText("");
        jPanel2.setName(""); // NOI18N

        txtDatosPila.setBackground(new java.awt.Color(255, 255, 102));
        txtDatosPila.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        txtDatosPila.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDatosPila.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDatosPilaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtDatosPila, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtDatosPila, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbtnPush)
                    .addComponent(jLabel2)
                    .addComponent(rbtnPop)
                    .addComponent(rbtnPopCualquiera)
                    .addComponent(rbtnVaciarPila)
                    .addComponent(rbtnTamanioPila)
                    .addComponent(rbtnTope)
                    .addComponent(rbtnMostrarPila)
                    .addComponent(btnEjecutar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtDatoPop, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtDatoPush, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel5))))
                        .addGap(36, 36, 36))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rbtnPush)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbtnPop)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbtnPopCualquiera)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbtnVaciarPila)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbtnTamanioPila)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbtnTope)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbtnMostrarPila)
                        .addGap(18, 18, 18)
                        .addComponent(btnEjecutar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtDatoPush, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtDatoPop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addGap(31, 31, 31)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbtnPushActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnPushActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnPushActionPerformed

    private void rbtnPopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnPopActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnPopActionPerformed

    private void rbtnPopCualquieraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnPopCualquieraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnPopCualquieraActionPerformed

    private void rbtnVaciarPilaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnVaciarPilaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnVaciarPilaActionPerformed

    private void rbtnTamanioPilaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnTamanioPilaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnTamanioPilaActionPerformed

    private void rbtnTopeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnTopeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnTopeActionPerformed

    private void rbtnMostrarPilaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnMostrarPilaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnMostrarPilaActionPerformed

    private void btnEjecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEjecutarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEjecutarActionPerformed

    private void txtDatoPopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDatoPopActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDatoPopActionPerformed

    private void txtDatosPilaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDatosPilaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDatosPilaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnEjecutar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JRadioButton rbtnMostrarPila;
    public javax.swing.JRadioButton rbtnPop;
    public javax.swing.JRadioButton rbtnPopCualquiera;
    public javax.swing.JRadioButton rbtnPush;
    public javax.swing.JRadioButton rbtnTamanioPila;
    public javax.swing.JRadioButton rbtnTope;
    public javax.swing.JRadioButton rbtnVaciarPila;
    public javax.swing.JTextField txtDatoPop;
    public javax.swing.JTextField txtDatoPush;
    public javax.swing.JTextField txtDatosPila;
    // End of variables declaration//GEN-END:variables
}
