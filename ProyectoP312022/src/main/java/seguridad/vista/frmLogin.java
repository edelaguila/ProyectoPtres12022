/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguridad.vista;



import seguridad.controlador.clsUsuario;
import java.awt.HeadlessException;
import java.time.LocalDate;
import java.util.Date;
import ventas.vista.mdiVentas;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import prototipos.vista.mdiPrototipo;
import seguridad.controlador.clsUsuarioConectado;
import seguridad.modelo.daoBitacora;
import seguridad.modelo.daoUsuario;
import seguridad.controlador.clsBitacora;


/**
 *
 * @author visitante
 */
public class frmLogin extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public frmLogin() {
        initComponents();
        setLocationRelativeTo(null);
        setSize(356, 220);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
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
        txtUsuario = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtContraseña = new javax.swing.JPasswordField();
        cbxAreas = new javax.swing.JComboBox<>();
        lblArea = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Seguridad del Sistema");

        jLabel2.setText("Usuario");

        jLabel3.setText("Contraseña");

        txtUsuario.setName("txtUsuario"); // NOI18N
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });

        btnAceptar.setLabel("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        cbxAreas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione:", "Area Seguridad", "Area Logistica", "Area Compras", "Area Ventas", "Area RRHH", "Prototipo" }));
        cbxAreas.setName(""); // NOI18N
        cbxAreas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxAreasActionPerformed(evt);
            }
        });

        lblArea.setText("Area");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblArea, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxAreas, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtUsuario)
                                .addComponent(txtContraseña)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnAceptar)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton2))))))
                .addContainerGap(87, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxAreas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblArea))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(jButton2))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
         Object[] options = {"Compras","Ventas","Cuentas por cobrar","Visualizar/editar/eliminar"};
        Object seleccion = JOptionPane.showInputDialog(null, "Seleccione la accion que realizará", 
                "Bitacora", JOptionPane.ERROR_MESSAGE, null, options, options[0]);
 
        if(seleccion.equals("Compras")){
            JOptionPane.showMessageDialog(null, seleccion);
        }else if (seleccion.equals("Ventas")) {
            JOptionPane.showMessageDialog(null, seleccion);
        }else if (seleccion.equals("Cuentas por cobrar")) {
            JOptionPane.showMessageDialog(null, seleccion);
        }else if (seleccion.equals("Visualizar/editar/eliminar")) {
            JOptionPane.showMessageDialog(null, seleccion);
        }

        if (txtUsuario.getText().trim().isEmpty() || txtContraseña.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "NO PUEDEN HABER CAMPOS VACIOS", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                clsUsuario usuarioAConsultar = new clsUsuario();
                daoUsuario usuarioDAO = new daoUsuario();
                usuarioAConsultar.setUsunombre((txtUsuario.getText().trim()));
                // Recuperación de información a través de otro objeto
                usuarioAConsultar = usuarioDAO.queryn(usuarioAConsultar);

                if (txtContraseña.getText().equals(usuarioAConsultar.getUsucontrasena()) && txtUsuario.getText().equals(usuarioAConsultar.getUsunombre())) {
                    JOptionPane.showMessageDialog(null, "Bienvenido al SISTEMA\n", "Mensaje de bienvenida", JOptionPane.INFORMATION_MESSAGE);
                    
                    //mdiGeneral menuGeneral = new mdiGeneral();
                    //menuGeneral.setVisible(true);
                    //this.dispose();
                    clsUsuarioConectado usuarioRegistrado = new clsUsuarioConectado();                                   usuarioRegistrado.setUsunombre(txtUsuario.getText().trim());
                    
                    //---Agregado para considerar todos los módulos
                    String areaSeleccionada;
                    areaSeleccionada = cbxAreas.getSelectedItem().toString();


                    String nombrepc = System.getProperty("user.name");
                    Date fecha = new Date();
                    LocalDate todaysDate = LocalDate.now();
                    //(fecha,accion.idusuario,idaplicacion)
                    daoBitacora prueba = new daoBitacora();
                    prueba.metodoBitacora(String.valueOf(todaysDate),areaSeleccionada,String.valueOf(seleccion),3,prueba.dato(txtUsuario.getText()));
                    switch (areaSeleccionada) {

                        case "Area Seguridad":
                        try {
                            mdiGeneral menuSeguridad = new mdiGeneral();
                            menuSeguridad.setVisible(true);
                            this.dispose();
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        break;
                        case "Prototipo":
                        try {
                            mdiPrototipo menuPrototipo = new mdiPrototipo();
                            menuPrototipo.setVisible(true);
                            this.dispose();
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        break;     
                        case "Area Ventas":
                        try {
                            mdiVentas menuPrototipo = new mdiVentas();
                            menuPrototipo.setVisible(true);
                            this.dispose();
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        break;                    
                        default:
                            break;
                    }
                    //---fin agregado

                } else {
                    JOptionPane.showMessageDialog(this, "ERROR AL ENCONTRAR USUARIO o CONTRASEÑA", "ERROR", JOptionPane.ERROR_MESSAGE);
                    txtContraseña.setText("");
                    txtUsuario.setText("");
                }
            } catch (HeadlessException e) {
                JOptionPane.showMessageDialog(this, "ERROR AL ENCONTRAR USUARIO o CONTRASEÑA", "ERROR", JOptionPane.ERROR_MESSAGE);
                txtContraseña.setText("");
                txtUsuario.setText("");
            }
        }

    }//GEN-LAST:event_btnAceptarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cbxAreasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxAreasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxAreasActionPerformed

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
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JComboBox<String> cbxAreas;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblArea;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
