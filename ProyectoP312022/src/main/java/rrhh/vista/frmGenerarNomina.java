/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.vista;

import rrhh.modelo.daoNomina;
import rrhh.controlador.clsNomina;
import rrhh.modelo.daoEmpleados;
import rrhh.controlador.clsEmpleados;
import rrhh.modelo.daoConcepto;
import rrhh.controlador.clsConcepto;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import java.io.File;

/**
 *
 * @author visitante
 */
public class frmGenerarNomina extends javax.swing.JInternalFrame {

    frmGenerarNomina(frmMantenimientoConcepto aThis, boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    public void asigna(){
    
    cbox_Asigna.addItem("Seleccione una opción");
    cbox_Asigna.addItem("Algunos");
    cbox_Asigna.addItem("Muchos");
    cbox_Asigna.addItem("Muchos a exepcion de:");
    
    }
   
   
    
    public void proceso(){
         double sueldoliquido=0, c;
    int contador = 1, contador2 = 1;
    int limitante, limitante2;
    double porcentaje,porcentaje2,valorigss,valorisr,valorhoras;
   String a=""; 
    
    
    if (cbox_Asigna.getSelectedItem().toString()=="Muchos"){
        
    limitante = Integer.parseInt(limite.getText());
    limitante2 = Integer.parseInt(limite2.getText());
    //llama a todos los empleados que estan registrados
     clsEmpleados empleadoAConsultar = new clsEmpleados();
     daoEmpleados empleadoDAO = new daoEmpleados();
     //esto registra todos los datos en la nomina
      daoNomina nominaDAO = new daoNomina();
        clsNomina nominaAInsertar = new clsNomina();
     //llama a todos los conceptos registrados
     clsConcepto concepAConsultar = new clsConcepto();
     daoConcepto concepDAO = new daoConcepto();   
    
    
    while(contador<=limitante){
     empleadoAConsultar.setempid(contador);
     empleadoAConsultar = empleadoDAO.query(empleadoAConsultar); 
     
      empleadoAConsultar.getempnombre();
      empleadoAConsultar.getempcargo();
      empleadoAConsultar.getempdepart();    
      
      c = Integer.parseInt(empleadoAConsultar.getempsueldo()); 
      
      
      while(contador2<=limitante2){
       concepAConsultar.setconcepid(contador2);
       concepAConsultar = concepDAO.query(concepAConsultar);


        
        a = a + concepAConsultar.getconcepnombre()+","; 
        
       if (concepAConsultar.getconcepnombre()=="IGSS" & concepAConsultar.getconcepnombre()=="igss" ){
       
       if(concepAConsultar.getconcepefecto()=="-"){
       double valor = Integer.parseInt(concepAConsultar.getconcepvalor());
       double sueldo = Integer.parseInt(empleadoAConsultar.getempsueldo()) ;
       porcentaje = sueldo - sueldo * valor;
       valorigss=sueldo - porcentaje;
       
       sueldoliquido = c - valorigss; 
       
       }

       }
       
       if (concepAConsultar.getconcepnombre()=="ISR" & concepAConsultar.getconcepnombre()=="isr" ){
       
       if(concepAConsultar.getconcepefecto()=="-"){
       double valor = Integer.parseInt(concepAConsultar.getconcepvalor());
       double sueldo = Integer.parseInt(empleadoAConsultar.getempsueldo()) ;
       porcentaje2 = sueldo - sueldo * valor;
       valorisr =sueldo - porcentaje2;
       sueldoliquido = c - valorisr; 
       }
       }
       if (concepAConsultar.getconcepnombre()=="HORAS" & concepAConsultar.getconcepnombre()=="horas" & concepAConsultar.getconcepnombre()=="horas extras" ){
       
       if(concepAConsultar.getconcepefecto()=="+"){
       double hora =  Integer.parseInt(empleadoAConsultar.getempdias());
       double valor = Integer.parseInt(concepAConsultar.getconcepvalor());
       double sueldo = Integer.parseInt(empleadoAConsultar.getempsueldo()) ;
       
       valorhoras = valor * hora;
       sueldoliquido = c - valorhoras;
       
       }
       }
        
        
     contador2++;
      }
     
      nominaAInsertar.setnominombre( empleadoAConsultar.getempnombre());
      nominaAInsertar.setnomicargo(empleadoAConsultar.getempcargo());
      nominaAInsertar.setnomidepart(empleadoAConsultar.getempdepart());
      nominaAInsertar.setnomisalario(empleadoAConsultar.getempsueldo());
      nominaAInsertar.setnomiconcepto(a);
      nominaAInsertar.setnomivalor(String.valueOf(sueldoliquido));
      nominaDAO.insert(nominaAInsertar);
      
      llenadoDeTablas();
      
    contador++;
     
    }
  
    }
    }
    
    
    
    
    
    public void llenadoDeTablas() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Id Nomina");
        modelo.addColumn("Nombre empleado");
        modelo.addColumn("Cargo");
         modelo.addColumn("Departamento");
        modelo.addColumn("Salario");
        modelo.addColumn("conceptos");
        modelo.addColumn("Valor Nomina");
        
        daoNomina nominaDAO = new daoNomina();
        List<clsNomina> nominas = nominaDAO.select();
        Nomina.setModel(modelo);
        String[] dato = new String[8];
        for (int i = 0; i < nominas.size(); i++) {
            dato[0] = Integer.toString(nominas.get(i).getnomiid());
            dato[1] = nominas.get(i).getnominombre();
            dato[2] = nominas.get(i).getnomicargo();
            dato[3] = nominas.get(i).getnomidepart();
            dato[4] = nominas.get(i).getnomisalario();
            dato[5] = nominas.get(i).getnomiconcepto();
            dato[6] = nominas.get(i).getnomivalor();
            
            //System.out.println("cargo:" + cargos);
            modelo.addRow(dato);
        }
    }

 

    public frmGenerarNomina() {
        initComponents();
        llenadoDeTablas();
        asigna();
        proceso();
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
        Generar = new javax.swing.JButton();
        label1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Nomina = new javax.swing.JTable();
        lb = new javax.swing.JLabel();
        label6 = new javax.swing.JLabel();
        label7 = new javax.swing.JLabel();
        cbox_Asigna = new javax.swing.JComboBox<>();
        label8 = new javax.swing.JLabel();
        limite = new javax.swing.JTextField();
        label10 = new javax.swing.JLabel();
        limite2 = new javax.swing.JTextField();
        label11 = new javax.swing.JLabel();
        cbox_Asigna1 = new javax.swing.JComboBox<>();
        label9 = new javax.swing.JLabel();

        lb2.setForeground(new java.awt.Color(204, 204, 204));
        lb2.setText(".");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Generacion de nominas");
        setVisible(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Generar.setText("Generar");
        Generar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenerarActionPerformed(evt);
            }
        });
        getContentPane().add(Generar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, 95, -1));

        label1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label1.setText("Visualizacion de la nomina");
        getContentPane().add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 160, -1, -1));

        Nomina.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        Nomina.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Nomina", "Nombre empleado", "Cargo", "Departamento", "Salario", "Conceptos", "Valor Nomina"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Nomina);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, 880, 303));

        lb.setForeground(new java.awt.Color(204, 204, 204));
        lb.setText(".");
        getContentPane().add(lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 20, 13, -1));

        label6.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label6.setText("-----------------Asignacion de conceptos-----------------");
        getContentPane().add(label6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 360, -1));

        label7.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label7.setText("-----------------Generacion de nomina-----------------");
        getContentPane().add(label7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 360, -1));

        cbox_Asigna.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        cbox_Asigna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox_AsignaActionPerformed(evt);
            }
        });
        getContentPane().add(cbox_Asigna, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 200, 30));

        label8.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label8.setText("Tipo");
        getContentPane().add(label8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        limite.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        limite.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        limite.setOpaque(false);
        getContentPane().add(limite, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 130, 20));

        label10.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label10.setText("No. empleados");
        getContentPane().add(label10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 110, -1));

        limite2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        limite2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        limite2.setOpaque(false);
        getContentPane().add(limite2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, 130, 20));

        label11.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label11.setText("No. Conceptos");
        getContentPane().add(label11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 110, -1));

        cbox_Asigna1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        cbox_Asigna1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox_Asigna1ActionPerformed(evt);
            }
        });
        getContentPane().add(cbox_Asigna1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, 200, -1));

        label9.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label9.setText("Empleado");
        getContentPane().add(label9, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenerarActionPerformed
proceso();
    }//GEN-LAST:event_GenerarActionPerformed

    private void cbox_AsignaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbox_AsignaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbox_AsignaActionPerformed

    private void cbox_Asigna1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbox_Asigna1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbox_Asigna1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Generar;
    private javax.swing.JTable Nomina;
    private javax.swing.JComboBox<String> cbox_Asigna;
    private javax.swing.JComboBox<String> cbox_Asigna1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label10;
    private javax.swing.JLabel label11;
    private javax.swing.JLabel label6;
    private javax.swing.JLabel label7;
    private javax.swing.JLabel label8;
    private javax.swing.JLabel label9;
    private javax.swing.JLabel lb;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lbusu;
    private javax.swing.JTextField limite;
    private javax.swing.JTextField limite2;
    // End of variables declaration//GEN-END:variables
}
