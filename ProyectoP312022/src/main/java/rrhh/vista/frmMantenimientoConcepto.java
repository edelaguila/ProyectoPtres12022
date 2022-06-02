/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.vista;



import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import rrhh.modelo.daoConcepto;
import rrhh.controlador.clsConcepto;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import javax.swing.JOptionPane;

/**
 *
 * @author visitante
 */
public class frmMantenimientoConcepto extends javax.swing.JInternalFrame {

    public void llenadoDeCombos() {
        daoConcepto EmpleadoDAO = new daoConcepto();
        List<clsConcepto> empleados = EmpleadoDAO.select();
        cbox_trabajadores.addItem("Seleccione una opción");
        for (int i = 0; i < empleados.size(); i++) {
            cbox_trabajadores.addItem(empleados.get(i).getconcepnombre());
        }
    }
   
     public void efecto() {    
        cbox_efecto.addItem("Seleccione una opción");
        cbox_efecto.addItem("+");
        cbox_efecto.addItem("-");
    }
 
       
    public void estado() {    
        cbox_estado.addItem("Seleccione una opción");
        cbox_estado.addItem("activo");
        cbox_estado.addItem("inactivo");
    }

   

    public void llenadoDeTablas() {
        DefaultTableModel modelo = new DefaultTableModel();
        //modelo.addColumn("Id empleado");
        modelo.addColumn("concepid");
        modelo.addColumn("concepnombre");
        modelo.addColumn("concepefecto");
        modelo.addColumn("concepestado");
        modelo.addColumn("concepvalor");
        //modelo.addColumn("Dias laborados");
        daoConcepto empleadoDAO = new daoConcepto();
        List<clsConcepto> empleados = empleadoDAO.select();
        tablaEmpleados.setModel(modelo);
        String[] dato = new String[6];
        for (int i = 0; i < empleados.size(); i++) {
           
           dato[0] = Integer.toString(empleados.get(i).getconcepid());
            dato[1] = empleados.get(i).getconcepnombre();
            dato[2] = empleados.get(i).getconcepefecto();
            dato[3] = empleados.get(i).getconcepestado();
            dato[4] = empleados.get(i).getconcepvalor();
           
            
            modelo.addRow(dato);
        }
    }

    public void buscarconceptos() {
        clsConcepto empleadoAConsultar = new clsConcepto();
        daoConcepto empleadoDAO = new daoConcepto();
        empleadoAConsultar.setconcepid(Integer.parseInt(txtbuscado.getText()));
        empleadoAConsultar = empleadoDAO.query(empleadoAConsultar);
        txtNombre.setText(empleadoAConsultar.getconcepnombre());
        cbox_efecto.setSelectedItem(empleadoAConsultar.getconcepefecto());
        cbox_estado.setSelectedItem(empleadoAConsultar.getconcepestado());
        txtValor.setText(empleadoAConsultar.getconcepvalor());
      
    }

    public frmMantenimientoConcepto() {
        initComponents();
        llenadoDeTablas();
        llenadoDeCombos();
        efecto();
        estado();

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
        btnEliminar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        label1 = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        txtbuscado = new javax.swing.JTextField();
        btnLimpiar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEmpleados = new javax.swing.JTable();
        cbox_trabajadores = new javax.swing.JComboBox<>();
        label4 = new javax.swing.JLabel();
        ayuda = new javax.swing.JButton();
        label8 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        label9 = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        label12 = new javax.swing.JLabel();
        label6 = new javax.swing.JLabel();
        label13 = new javax.swing.JLabel();
        cbox_efecto = new javax.swing.JComboBox<>();
        label14 = new javax.swing.JLabel();
        cbox_estado = new javax.swing.JComboBox<>();

        lb2.setForeground(new java.awt.Color(204, 204, 204));
        lb2.setText(".");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Mantenimiento Conceptos");
        setVisible(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, 95, -1));

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 95, -1));

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 300, 95, -1));

        label1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label1.setText("Datos");
        getContentPane().add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 0, -1, -1));

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        getContentPane().add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 340, 95, -1));
        getContentPane().add(txtbuscado, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 300, 102, -1));

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 95, -1));

        tablaEmpleados.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tablaEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Concepto", "Nombre", "Efecto", "Estado", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaEmpleados);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 30, 680, 303));

        cbox_trabajadores.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        cbox_trabajadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox_trabajadoresActionPerformed(evt);
            }
        });
        getContentPane().add(cbox_trabajadores, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 360, 263, -1));

        label4.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label4.setText("-----------------Ingreso de datos del empleado-----------------");
        getContentPane().add(label4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 360, -1));

        ayuda.setText("Ayuda");
        ayuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ayudaActionPerformed(evt);
            }
        });
        getContentPane().add(ayuda, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 340, 100, -1));

        label8.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label8.setText("Nombre");
        getContentPane().add(label8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        txtNombre.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtNombre.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txtNombre.setOpaque(false);
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 200, -1));

        label9.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label9.setText("Efecto ");
        getContentPane().add(label9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        txtValor.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtValor.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txtValor.setOpaque(false);
        getContentPane().add(txtValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, 200, -1));

        label12.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label12.setText("Valor");
        getContentPane().add(label12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));

        label6.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label6.setText("Concepto");
        getContentPane().add(label6, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 360, -1, -1));

        label13.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label13.setText(".");
        getContentPane().add(label13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 400, 20, -1));

        cbox_efecto.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        cbox_efecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox_efectoActionPerformed(evt);
            }
        });
        getContentPane().add(cbox_efecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 200, -1));

        label14.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label14.setText("Estado");
        getContentPane().add(label14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        getContentPane().add(cbox_estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 200, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        int i =JOptionPane.showConfirmDialog(this, "seguro que quieres borrar este dato ");
        if ( i == 0){
        daoConcepto empleadoDAO = new daoConcepto();
        clsConcepto empleadoAEliminar = new clsConcepto();
        empleadoAEliminar.setconcepid(Integer.parseInt(txtbuscado.getText()));
        empleadoDAO.delete(empleadoAEliminar);

        } else if(1==1){
         JOptionPane.showMessageDialog(this, "no se a borrado los datos ");
        }
        llenadoDeTablas();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        daoConcepto empleadoDAO = new daoConcepto();
        clsConcepto empleadoAInsertar = new clsConcepto();
        empleadoAInsertar.setconcepnombre(txtNombre.getText());
        empleadoAInsertar.setconcepefecto(cbox_efecto.getSelectedItem().toString());
        empleadoAInsertar.setconcepestado(cbox_estado.getSelectedItem().toString());
        empleadoAInsertar.setconcepvalor(txtValor.getText());
        //empleadoAInsertar.setempdias(txtDias.getText());
        empleadoDAO.insert(empleadoAInsertar);
        llenadoDeTablas();
        
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        buscarconceptos(); 
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
//        // TODO add your handling code here:
int i =JOptionPane.showConfirmDialog(this, "seguro que quieres modificar este dato ");
        if ( i == 0){
        daoConcepto empleadoDAO = new daoConcepto();
        clsConcepto empleadoAActualizar = new clsConcepto();
        empleadoAActualizar.setconcepid(Integer.parseInt(txtbuscado.getText()));
        empleadoAActualizar.setconcepnombre(txtNombre.getText());
        empleadoAActualizar.setconcepefecto(cbox_efecto.getSelectedItem().toString());
        empleadoAActualizar.setconcepestado(cbox_estado.getSelectedItem().toString());
         empleadoAActualizar.setconcepvalor(txtValor.getText());
        //empleadoAActualizar.setempdias(txtDias.getText());  
        empleadoDAO.update(empleadoAActualizar);
        
        }   else if(1==1){
         JOptionPane.showMessageDialog(this, "no se a modificado los datos ");
        }
         llenadoDeTablas();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        cbox_trabajadores.setSelectedIndex(0);
        cbox_efecto.setSelectedIndex(0);
        txtNombre.setText("");
        txtValor.setText("");
        txtbuscado.setText("");
        btnRegistrar.setEnabled(true);
        btnModificar.setEnabled(true);
        btnEliminar.setEnabled(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void cbox_trabajadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbox_trabajadoresActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_cbox_trabajadoresActionPerformed

    private void ayudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ayudaActionPerformed
        // TODO add your handling code here:
  
 
//EVENTO DEL BOTON
ayuda.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent evento)
{
 
try{
            
            Desktop.getDesktop().browse(new URI("https://docs.oracle.com/netbeans/nb81/netbeans/NBDAG.pdf"));
        } catch (Exception e){
JOptionPane.showMessageDialog(null, "No se puede abrir el archivo de ayuda, probablemente fue borrado","ERROR",JOptionPane.ERROR_MESSAGE);
 

        }

 

}

});
       
    }//GEN-LAST:event_ayudaActionPerformed

    private void cbox_efectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbox_efectoActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cbox_efectoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ayuda;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cbox_efecto;
    private javax.swing.JComboBox<String> cbox_estado;
    private javax.swing.JComboBox<String> cbox_trabajadores;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label12;
    private javax.swing.JLabel label13;
    private javax.swing.JLabel label14;
    private javax.swing.JLabel label4;
    private javax.swing.JLabel label6;
    private javax.swing.JLabel label8;
    private javax.swing.JLabel label9;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lbusu;
    private javax.swing.JTable tablaEmpleados;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtValor;
    private javax.swing.JTextField txtbuscado;
    // End of variables declaration//GEN-END:variables
}
