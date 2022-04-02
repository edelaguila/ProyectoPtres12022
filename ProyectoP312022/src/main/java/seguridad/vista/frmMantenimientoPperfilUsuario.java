/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguridad.vista;

import seguridad.modelo.daoPerfilUsuario;
import seguridad.controlador.clsPerfilUsuario;
import seguridad.modelo.daoUsuario;
import seguridad.controlador.clsUsuario;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import seguridad.controlador.clsAplicacion;


/**
 *
 * @author visitante
 */
public class frmMantenimientoPperfilUsuario extends javax.swing.JInternalFrame {

 
      public void llenadoDeTablas() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("nombre");
        modelo.addColumn("Ultima sesion");
        modelo.addColumn("Estatus");
        modelo.addColumn("Nombre real");
        modelo.addColumn("Correo");
        modelo.addColumn("telefono");
        modelo.addColumn("direccion");
        daoUsuario usuarioDAO = new daoUsuario();
        List<clsUsuario> usuarios = usuarioDAO.select();
        tablaVendedores.setModel(modelo);
        String[] dato = new String[8];
        for (int i = 0; i < usuarios.size(); i++) {
            dato[0] = Integer.toString(usuarios.get(i).getUsuid());
            dato[1] = usuarios.get(i).getUsunombre();
            dato[2] = usuarios.get(i).getUsuultimasesion();
            dato[3] = usuarios.get(i).getUsuestatus();
            dato[4] = usuarios.get(i).getUsunombrereal();
            dato[5] = usuarios.get(i).getUsucorreoe();
            dato[6] = usuarios.get(i).getUsutelefono();
            dato[7] = usuarios.get(i).getUsudireccion();
            //System.out.println("vendedor:" + vendedores);
            modelo.addRow(dato);
        }
    }



   

    public frmMantenimientoPperfilUsuario() {
  llenadoDeTablas();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb2 = new javax.swing.JLabel();
        lbusu = new javax.swing.JLabel();
        lbl_Aaplicacion = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbl_code = new javax.swing.JLabel();
        txt_IDperfil = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaperfil = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaVendedores = new javax.swing.JTable();

        lb2.setForeground(new java.awt.Color(204, 204, 204));
        lb2.setText(".");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Mantenimiento Proceso Perfil usuario");
        setVisible(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_Aaplicacion.setText("Usuarios");
        getContentPane().add(lbl_Aaplicacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 70, -1, -1));

        jLabel2.setText("perfil");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, -1, -1));

        lbl_code.setText("CODIGO PERFIIL:");
        getContentPane().add(lbl_code, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 100, -1));

        txt_IDperfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_IDperfilActionPerformed(evt);
            }
        });
        getContentPane().add(txt_IDperfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 100, -1));

        tablaperfil.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tablaperfil.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Perfil", "Nombre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tablaperfil);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 290, 210));

        jButton2.setText("Agregar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 130, -1, -1));

        jButton3.setText("Eliminar");
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 170, 70, -1));

        jButton4.setText("Agregar todos");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 210, -1, -1));

        jButton5.setText("Eliminar todos");
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 250, 100, -1));

        jButton1.setText("Buscar");
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, -1, -1));

        tablaVendedores.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tablaVendedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID usuario", "nombre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaVendedores);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 100, 400, 210));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_IDperfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_IDperfilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_IDperfilActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lbl_Aaplicacion;
    private javax.swing.JLabel lbl_code;
    private javax.swing.JLabel lbusu;
    private javax.swing.JTable tablaVendedores;
    private javax.swing.JTable tablaperfil;
    private javax.swing.JTextField txt_IDperfil;
    // End of variables declaration//GEN-END:variables
}
