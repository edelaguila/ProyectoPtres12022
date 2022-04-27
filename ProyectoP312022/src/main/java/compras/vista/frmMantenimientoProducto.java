/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compras.vista;

import seguridad.vista.*;
import compras.vista.*;
import compras.modelo.daoProducto;
import compras.controlador.clsProducto;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author visitante
 */
public class frmMantenimientoProducto extends javax.swing.JInternalFrame {

  

    public void llenadoDeTablas() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID Producto");
        modelo.addColumn("ID Proveedor");
        modelo.addColumn("Nombre Producto");
        modelo.addColumn("Marca Producto");
        modelo.addColumn("Precio Producto");
        modelo.addColumn("Linea");
        modelo.addColumn("existencia");
        daoProducto productoDAO = new daoProducto();
        List<clsProducto> producto = productoDAO.select();
        tablaVendedores.setModel(modelo);
        String[] dato = new String[7];
        for (int i = 0; i < producto.size(); i++) {
            dato[0] = Integer.toString(producto.get(i).getProdid());
            dato[1] = Integer.toString(producto.get(i).getProvid());
            dato[2] = producto.get(i).getProdnombre();
            dato[3] = producto.get(i).getProdmarca();
            dato[4] = Integer.toString(producto.get(i).getProdprecio());
            dato[5] = producto.get(i).getProdlinea();
            dato[6] = producto.get(i).getProdexistencia();
            //System.out.println("vendedor:" + vendedores);
            modelo.addRow(dato);
        }
    }

    public void buscarProducto() {
        clsProducto productoAConsultar = new clsProducto();
        daoProducto productoDAO = new daoProducto();
        productoAConsultar.setProdid(Integer.parseInt(txtbuscado.getText()));
        productoAConsultar = productoDAO.query(productoAConsultar);
        txtProveedor.setText(String.valueOf(productoAConsultar.getProvid()));
        txtNombre.setText(productoAConsultar.getProdnombre());
        txtMarca.setText(productoAConsultar.getProdmarca());
        txtPrecio.setText(String.valueOf(productoAConsultar.getProdprecio()));
        txtlinea.setText(productoAConsultar.getProdlinea());
        txtExistencia.setText(productoAConsultar.getProdexistencia());
        
    }

    public frmMantenimientoProducto() {
        initComponents();
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
        btnEliminar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        label1 = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        label3 = new javax.swing.JLabel();
        txtbuscado = new javax.swing.JTextField();
        txtProveedor = new javax.swing.JTextField();
        btnLimpiar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaVendedores = new javax.swing.JTable();
        txtPrecio = new javax.swing.JTextField();
        label5 = new javax.swing.JLabel();
        lb = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        label6 = new javax.swing.JLabel();
        label7 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtMarca = new javax.swing.JTextField();
        label4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtlinea = new javax.swing.JTextField();
        label8 = new javax.swing.JLabel();
        txtExistencia = new javax.swing.JTextField();
        label9 = new javax.swing.JLabel();

        lb2.setForeground(new java.awt.Color(204, 204, 204));
        lb2.setText(".");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Mantenimiento Productos");
        setPreferredSize(new java.awt.Dimension(1100, 550));
        setVisible(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 95, 30));

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 330, 95, 30));

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 370, 100, 30));

        label1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label1.setText("PRODUCTOS");
        getContentPane().add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(686, 0, -1, -1));

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        getContentPane().add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 370, 95, 30));

        label3.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label3.setText("Codigo Del Producto");
        getContentPane().add(label3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 410, -1, -1));
        getContentPane().add(txtbuscado, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 430, 102, -1));

        txtProveedor.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtProveedor.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        getContentPane().add(txtProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 220, 20));

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 95, 30));

        tablaVendedores.setBackground(new java.awt.Color(204, 255, 255));
        tablaVendedores.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        tablaVendedores.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tablaVendedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Vendedor", "ID Empleado", "Correo", "Telefono", "Direccion", "Porcentaje", "Comision"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaVendedores);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(409, 20, 612, 440));

        txtPrecio.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtPrecio.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        getContentPane().add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 220, 20));

        label5.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label5.setText("Precio Producto");
        getContentPane().add(label5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));

        lb.setForeground(new java.awt.Color(204, 204, 204));
        lb.setText(".");
        getContentPane().add(lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(389, 20, 13, -1));

        jButton2.setText("Ayuda");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 330, 100, 30));

        label6.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label6.setText("Nombre Producto");
        getContentPane().add(label6, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 100, -1, -1));

        label7.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label7.setText("Marca Producto");
        getContentPane().add(label7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        txtNombre.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtNombre.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 220, 20));

        txtMarca.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtMarca.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        getContentPane().add(txtMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 220, 20));

        label4.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label4.setText("Codigo Proveedor");
        getContentPane().add(label4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 65, -1, -1));

        jButton1.setText("?");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 430, 40, -1));

        txtlinea.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtlinea.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        getContentPane().add(txtlinea, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 220, 20));

        label8.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label8.setText("linea producto");
        getContentPane().add(label8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        txtExistencia.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtExistencia.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        getContentPane().add(txtExistencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 220, 20));

        label9.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label9.setText("existencia del producto");
        getContentPane().add(label9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        daoProducto productoDAO = new daoProducto();
        clsProducto productoAEliminar = new clsProducto();
        productoAEliminar.setProdid(Integer.parseInt(txtbuscado.getText()));
        productoDAO.delete(productoAEliminar);
        llenadoDeTablas();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        daoProducto productoDAO = new daoProducto();
        clsProducto productoAInsertar = new clsProducto();
        productoAInsertar.setProvid(Integer.parseInt(txtProveedor.getText()));
        productoAInsertar.setProdnombre(txtNombre.getText());
        productoAInsertar.setProdmarca(txtMarca.getText());
        productoAInsertar.setProdprecio(Integer.parseInt(txtPrecio.getText()));
        productoAInsertar.setProdlinea(txtlinea.getText());
        productoAInsertar.setProdexistencia(txtExistencia.getText());
        productoDAO.insert(productoAInsertar);
        llenadoDeTablas();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        buscarProducto();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
//        // TODO add your handling code here:
        daoProducto productoDAO = new daoProducto();
        clsProducto productoAActualizar = new clsProducto();
        productoAActualizar.setProdid(Integer.parseInt(txtbuscado.getText()));
        productoAActualizar.setProvid(Integer.parseInt(txtProveedor.getText()));
        productoAActualizar.setProdnombre(txtNombre.getText());
        productoAActualizar.setProdmarca(txtMarca.getText());
        productoAActualizar.setProdprecio(Integer.parseInt(txtPrecio.getText()));
        productoAActualizar.setProdlinea(txtlinea.getText());
        productoAActualizar.setProdexistencia(txtExistencia.getText());
        productoDAO.update(productoAActualizar);
        llenadoDeTablas();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
       
        txtProveedor.setText("");
        txtPrecio.setText("");
        txtbuscado.setText("");
        txtNombre.setText("");
        txtMarca.setText("");
        txtlinea.setText("");
        txtExistencia.setText("");
        btnRegistrar.setEnabled(true);
        btnModificar.setEnabled(true);
        btnEliminar.setEnabled(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiarActionPerformed

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(rootPane, "INGRESE EL CODIGO DEL PRODUCTO QUE DESEA BUSCAR,ELIMINAR O REGISTRAR");
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel label4;
    private javax.swing.JLabel label5;
    private javax.swing.JLabel label6;
    private javax.swing.JLabel label7;
    private javax.swing.JLabel label8;
    private javax.swing.JLabel label9;
    private javax.swing.JLabel lb;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lbusu;
    private javax.swing.JTable tablaVendedores;
    private javax.swing.JTextField txtExistencia;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtProveedor;
    private javax.swing.JTextField txtbuscado;
    private javax.swing.JTextField txtlinea;
    // End of variables declaration//GEN-END:variables
}
