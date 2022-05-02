/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.vista;


import rrhh.modelo.daoEmpleados;
import rrhh.controlador.clsEmpleados;
import rrhh.modelo.daocargo;
import rrhh.controlador.clscargo;
import rrhh.modelo.daodepartamento;
import rrhh.controlador.clsdepartamento;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import java.io.File;

/**
 *
 * @author visitante
 */
public class frmMantenimientoEmpleados extends javax.swing.JInternalFrame {

    public void llenadoDeCombosCar() {
        daocargo cargoDAO = new daocargo();
        List<clscargo> cargos = cargoDAO.select();
        cbox_cargos.addItem("Seleccione un cargo");
        for (int i = 0; i < cargos.size(); i++) {
            cbox_cargos.addItem(cargos.get(i).getcarnombre());
        }
    }

    public void llenadoDeCombosDepar() {
        daodepartamento departamentoDAO = new daodepartamento();
        List<clsdepartamento> departamentos = departamentoDAO.select();
        cbox_departamentos.addItem("Seleccione un departamento");
        for (int i = 0; i < departamentos.size(); i++) {
            cbox_departamentos.addItem(departamentos.get(i).getdeparnombre());
        }
    }
    
    public void llenadoDeTablas() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Id empleado");
        modelo.addColumn("Nombre");
        modelo.addColumn("Salario");
        modelo.addColumn("Estado");
        modelo.addColumn("Dias laborados");
        modelo.addColumn("Cargo");
        modelo.addColumn("Departamento");
        daoEmpleados empleadoDAO = new daoEmpleados();
        List<clsEmpleados> empleados = empleadoDAO.select();
        tablaEmpleados.setModel(modelo);
        String[] dato = new String[8];
        for (int i = 0; i < empleados.size(); i++) {
            dato[0] = Integer.toString(empleados.get(i).getempid());
            dato[1] = empleados.get(i).getempnombre();
            dato[2] = empleados.get(i).getempsueldo();
            dato[3] = empleados.get(i).getempestado();
            dato[4] = empleados.get(i).getempdias();
            dato[5] = empleados.get(i).getempcargo();
            dato[6] = empleados.get(i).getempdepart();
            //System.out.println("vendedor:" + vendedores);
            modelo.addRow(dato);
        }
    }

    public void buscarEmpleados() {
        clsEmpleados empleadoAConsultar = new clsEmpleados();
        daoEmpleados empleadoDAO = new daoEmpleados();
        empleadoAConsultar.setempid(Integer.parseInt(txtbuscado.getText()));
        empleadoAConsultar = empleadoDAO.query(empleadoAConsultar);
        txtNombre.setText(empleadoAConsultar.getempnombre());
        txtSalario.setText(empleadoAConsultar.getempsueldo());
        txtEstado.setText(empleadoAConsultar.getempestado());
        txtDias.setText(empleadoAConsultar.getempdias());
        cbox_cargos.setSelectedItem(empleadoAConsultar.getempcargo());
        cbox_departamentos.setSelectedItem(empleadoAConsultar.getempdepart());
      
    }

    public frmMantenimientoEmpleados() {
        initComponents();
        llenadoDeTablas();
        llenadoDeCombosCar();
        llenadoDeCombosDepar();
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
        cbox_cargos = new javax.swing.JComboBox<>();
        label4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        txtSalario = new javax.swing.JTextField();
        label8 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtDias = new javax.swing.JTextField();
        label9 = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        label11 = new javax.swing.JLabel();
        label12 = new javax.swing.JLabel();
        label6 = new javax.swing.JLabel();
        label13 = new javax.swing.JLabel();
        label14 = new javax.swing.JLabel();
        label5 = new javax.swing.JLabel();
        cbox_departamentos = new javax.swing.JComboBox<>();
        label7 = new javax.swing.JLabel();
        label10 = new javax.swing.JLabel();

        lb2.setForeground(new java.awt.Color(204, 204, 204));
        lb2.setText(".");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Mantenimiento empleados");
        setVisible(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 390, 95, -1));

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 95, -1));

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 390, 95, -1));

        label1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label1.setText("Datos");
        getContentPane().add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 30, -1, -1));

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        getContentPane().add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 430, 95, -1));
        getContentPane().add(txtbuscado, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 390, 102, -1));

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 95, -1));

        tablaEmpleados.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tablaEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id empleado", "Nombre", "Salario", "Estado", "Dias laborados", "Cargo", "Departamento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaEmpleados);
        if (tablaEmpleados.getColumnModel().getColumnCount() > 0) {
            tablaEmpleados.getColumnModel().getColumn(4).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 70, 680, 330));

        cbox_cargos.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        cbox_cargos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox_cargosActionPerformed(evt);
            }
        });
        getContentPane().add(cbox_cargos, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 280, 150, -1));

        label4.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label4.setText("-----------------Asignacion de cargo y departamento-----------------");
        getContentPane().add(label4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 360, -1));

        jButton2.setText("Ayuda");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 430, 100, -1));

        txtSalario.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtSalario.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txtSalario.setOpaque(false);
        getContentPane().add(txtSalario, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 260, -1));

        label8.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        getContentPane().add(label8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 450, -1, -1));

        txtNombre.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtNombre.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txtNombre.setOpaque(false);
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 260, -1));

        txtDias.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtDias.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txtDias.setOpaque(false);
        txtDias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiasActionPerformed(evt);
            }
        });
        getContentPane().add(txtDias, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 260, -1));

        label9.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label9.setText("Salario empleado");
        getContentPane().add(label9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        txtEstado.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtEstado.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txtEstado.setOpaque(false);
        getContentPane().add(txtEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 260, -1));

        label11.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        getContentPane().add(label11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));

        label12.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label12.setText("Dias");
        getContentPane().add(label12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, -1));

        label6.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label6.setText("Cargos disponibles");
        getContentPane().add(label6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, -1));

        label13.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label13.setText(".");
        getContentPane().add(label13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 450, 20, -1));

        label14.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label14.setText("Empleado estado");
        getContentPane().add(label14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        label5.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label5.setText("-----------------Ingreso de datos del empleado-----------------");
        getContentPane().add(label5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 360, -1));

        cbox_departamentos.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        cbox_departamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox_departamentosActionPerformed(evt);
            }
        });
        getContentPane().add(cbox_departamentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 330, 150, -1));

        label7.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label7.setText("Departamentos disponibles");
        getContentPane().add(label7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, -1, -1));

        label10.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label10.setText("Nombre empleado");
        getContentPane().add(label10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        daoEmpleados empleadoDAO = new daoEmpleados();
        clsEmpleados empleadoAEliminar = new clsEmpleados();
        empleadoAEliminar.setempid(Integer.parseInt(txtbuscado.getText()));
        empleadoDAO.delete(empleadoAEliminar);
        llenadoDeTablas();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        daoEmpleados empleadoDAO = new daoEmpleados();
        clsEmpleados empleadoAInsertar = new clsEmpleados();
        empleadoAInsertar.setempnombre(txtNombre.getText());
        empleadoAInsertar.setempsueldo(txtSalario.getText());
        empleadoAInsertar.setempestado(txtEstado.getText());
        empleadoAInsertar.setempdias(txtDias.getText());
        empleadoAInsertar.setempcargo(cbox_cargos.getSelectedItem().toString());
        empleadoAInsertar.setempdepart(cbox_departamentos.getSelectedItem().toString());
        empleadoDAO.insert(empleadoAInsertar);
        llenadoDeTablas();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        buscarEmpleados();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
//        // TODO add your handling code here:
        daoEmpleados empleadoDAO = new daoEmpleados();
        clsEmpleados empleadoAActualizar = new clsEmpleados();
        empleadoAActualizar.setempid(Integer.parseInt(txtbuscado.getText()));
        empleadoAActualizar.setempnombre(txtNombre.getText());
        empleadoAActualizar.setempsueldo(txtSalario.getText());
        empleadoAActualizar.setempestado(txtEstado.getText());
        empleadoAActualizar.setempdias(txtDias.getText());  
        empleadoAActualizar.setempcargo(cbox_cargos.getSelectedItem().toString());
        empleadoAActualizar.setempdepart(cbox_departamentos.getSelectedItem().toString());
        empleadoDAO.update(empleadoAActualizar);
        llenadoDeTablas();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        cbox_cargos.setSelectedIndex(0);
        cbox_departamentos.setSelectedIndex(0);
        txtNombre.setText("");
        txtSalario.setText("");
        txtEstado.setText("");
        txtDias.setText("");
        txtbuscado.setText("");
        btnRegistrar.setEnabled(true);
        btnModificar.setEnabled(true);
        btnEliminar.setEnabled(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void cbox_cargosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbox_cargosActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_cbox_cargosActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try {
            if ((new File("src\\main\\java\\ayudas\\ProcesoMayor.chm")).exists()) {
                Process p = Runtime
                        .getRuntime()
                        .exec("rundll32 url.dll,FileProtocolHandler src\\main\\java\\ayudas\\ProcesoMayor.chm");
                p.waitFor();
            } else {
                System.out.println("La ayuda no Fue encontrada");
            }
            System.out.println("Correcto");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtDiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiasActionPerformed

    private void cbox_departamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbox_departamentosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbox_departamentosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cbox_cargos;
    private javax.swing.JComboBox<String> cbox_departamentos;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label10;
    private javax.swing.JLabel label11;
    private javax.swing.JLabel label12;
    private javax.swing.JLabel label13;
    private javax.swing.JLabel label14;
    private javax.swing.JLabel label4;
    private javax.swing.JLabel label5;
    private javax.swing.JLabel label6;
    private javax.swing.JLabel label7;
    private javax.swing.JLabel label8;
    private javax.swing.JLabel label9;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lbusu;
    private javax.swing.JTable tablaEmpleados;
    private javax.swing.JTextField txtDias;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtSalario;
    private javax.swing.JTextField txtbuscado;
    // End of variables declaration//GEN-END:variables
}
