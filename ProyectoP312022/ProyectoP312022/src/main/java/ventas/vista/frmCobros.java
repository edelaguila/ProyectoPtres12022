/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ventas.vista;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import ventas.controlador.clsClientes;
import ventas.controlador.clsCuentas_por_cobrar;
import ventas.controlador.clsVentas;
import ventas.modelo.daoClientes;
import ventas.modelo.daoCuentas_por_cobrar;
import ventas.modelo.daoVentas;

/**
 *
 * @author Pablo
 */
public class frmCobros extends javax.swing.JFrame {

    /**
     * Creates new form frmCobros
     */
int idcobrador=0,idcliente=0;
public void llenadoDeTablas() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Nombre");
        modelo.addColumn("Correo");
        modelo.addColumn("Telefono");
       modelo.addColumn("Estado");
       modelo.addColumn("Tipo");
       modelo.addColumn("Credito");
       modelo.addColumn("Id Cliente");
       modelo.addColumn("Id Cobrador");

        daoClientes clientesDAO = new daoClientes();
        List<clsClientes> clientes = clientesDAO.select();
        tabla_clientes.setModel(modelo);
        String[] dato = new String[8];
        for (int i = 0; i < clientes.size(); i++) {
            dato[0] = String.valueOf(clientes.get(i).fGetnombre_Clientes());
            dato[1] = String.valueOf(clientes.get(i).fGetcorreo_Clientes());
            dato[2] = Integer.toString(clientes.get(i).fGettelefono_Clientes());
            dato[3] = String.valueOf(clientes.get(i).fGetestado_Clientes());
            dato[4] = String.valueOf(clientes.get(i).fGettipo_Clientes());
            dato[5] = String.valueOf(clientes.get(i).fGetcredito_Clientes());
            dato[6] = String.valueOf(clientes.get(i).fGetid_Clientes());
            dato[7] = String.valueOf(clientes.get(i).fGetid_Cobrador());

            //System.out.println("vendedor:" + vendedores);
            modelo.addRow(dato);
        }
    }



    public frmCobros() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        label9 = new javax.swing.JLabel();
        txtidcliente = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtptotal = new javax.swing.JButton();
        txtproporcional = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_clientes = new javax.swing.JTable();
        txttipo = new javax.swing.JTextField();
        txttotal = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        txtpago = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        label9.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label9.setText("Nombre");

        txtidcliente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtidcliente.setEnabled(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Correo");

        txtnombre.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtnombre.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Tipo");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Total");

        txtptotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtptotal.setText("Pago Total");
        txtptotal.setEnabled(false);
        txtptotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtptotalActionPerformed(evt);
            }
        });

        txtproporcional.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtproporcional.setText("Pago Proporcional");
        txtproporcional.setEnabled(false);
        txtproporcional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtproporcionalActionPerformed(evt);
            }
        });

        tabla_clientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Correo", "Telefono", "Estado", "Tipo", "Credito", "id_cliente", "id_cobrador"
            }
        ));
        tabla_clientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_clientesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabla_clientes);

        txttipo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txttipo.setEnabled(false);

        txttotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txttotal.setEnabled(false);

        jButton5.setIcon(new javax.swing.ImageIcon("C:\\Users\\Pablo\\Desktop\\iconos\\Tarjeta.png")); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setIcon(new javax.swing.ImageIcon("C:\\Users\\Pablo\\Desktop\\iconos\\efectivo.png")); // NOI18N

        txtpago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pago", "Efectivo", "Tarjeta", "Cheque" }));
        txtpago.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Tipo de Pago");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label9)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jLabel3)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtidcliente)
                            .addComponent(txtnombre)
                            .addComponent(txttipo)
                            .addComponent(txttotal)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtproporcional)
                            .addComponent(txtptotal))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
                        .addComponent(txtpago, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 662, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label9)
                            .addComponent(txtidcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txttipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtpago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(txtptotal)
                                .addGap(32, 32, 32)
                                .addComponent(txtproporcional)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

double saldo=0;
    private void tabla_clientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_clientesMouseClicked
        // TODO add your handling code here:
     int seleccion=tabla_clientes.rowAtPoint(evt.getPoint());
     txtidcliente.setText(String.valueOf(tabla_clientes.getValueAt(seleccion, 0)));
     txtnombre.setText(String.valueOf(tabla_clientes.getValueAt(seleccion, 1)));
     txttipo.setText(String.valueOf(tabla_clientes.getValueAt(seleccion, 4)));
     txttotal.setText(String.valueOf(tabla_clientes.getValueAt(seleccion, 5)));
    saldo=Double.parseDouble(String.valueOf(tabla_clientes.getValueAt(seleccion, 5)));
     idcliente=Integer.parseInt(String.valueOf(tabla_clientes.getValueAt(seleccion, 6)));
     idcobrador=Integer.parseInt(String.valueOf(tabla_clientes.getValueAt(seleccion, 7)));
     txtpago.setEnabled(true);
     txtptotal.setEnabled(true);
     txtproporcional.setEnabled(true);
    }//GEN-LAST:event_tabla_clientesMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void txtptotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtptotalActionPerformed
        // TODO add your handling code here:
            daoCuentas_por_cobrar cobradorDAO = new daoCuentas_por_cobrar();
        clsCuentas_por_cobrar cobradorAInsertar = new clsCuentas_por_cobrar();
        cobradorAInsertar.setTipo_pago(String.valueOf(txtpago.getSelectedItem()));
        cobradorAInsertar.setId_cobrador(idcobrador);
        cobradorAInsertar.setId_cliente(idcliente);
        cobradorAInsertar.setSaldo(saldo);
        cobradorDAO.insert(cobradorAInsertar);


        daoClientes clientesDAO = new daoClientes();
        clsClientes clientesAInsertar = new clsClientes();
        clsClientes clienteAConsultar = new clsClientes();
        daoClientes clienteDAO = new daoClientes();
        clienteAConsultar.fSetid_Clientes(idcliente);
        clienteAConsultar = clienteDAO.query(clienteAConsultar);
        clientesDAO.update_total_credit(idcliente,saldo*-1,clienteAConsultar.fGetcredito_Clientes());
    }//GEN-LAST:event_txtptotalActionPerformed

    private void txtproporcionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtproporcionalActionPerformed
        // TODO add your handling code here:
     double cantidad_pago = Double.parseDouble(JOptionPane.showInputDialog("Introduzca la cantidad a pagar:"));
        daoCuentas_por_cobrar cobradorDAO = new daoCuentas_por_cobrar();
        clsCuentas_por_cobrar cobradorAInsertar = new clsCuentas_por_cobrar();
        cobradorAInsertar.setTipo_pago(String.valueOf(txtpago.getSelectedItem()));
        cobradorAInsertar.setId_cobrador(idcobrador);
        cobradorAInsertar.setId_cliente(idcliente);
        cobradorAInsertar.setSaldo(cantidad_pago);
        cobradorDAO.insert(cobradorAInsertar);


        daoClientes clientesDAO = new daoClientes();
        clsClientes clientesAInsertar = new clsClientes();
        clsClientes clienteAConsultar = new clsClientes();
        daoClientes clienteDAO = new daoClientes();
        clienteAConsultar.fSetid_Clientes(idcliente);
        clienteAConsultar = clienteDAO.query(clienteAConsultar);
        clientesDAO.update_total_credit(idcliente,cantidad_pago*-1,clienteAConsultar.fGetcredito_Clientes());
       
    }//GEN-LAST:event_txtproporcionalActionPerformed

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
            java.util.logging.Logger.getLogger(frmCobros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCobros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCobros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCobros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmCobros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel label9;
    private javax.swing.JTable tabla_clientes;
    private javax.swing.JTextField txtidcliente;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JComboBox<String> txtpago;
    private javax.swing.JButton txtproporcional;
    private javax.swing.JButton txtptotal;
    private javax.swing.JTextField txttipo;
    private javax.swing.JTextField txttotal;
    // End of variables declaration//GEN-END:variables
}