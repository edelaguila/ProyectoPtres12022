package rrhh.controlador;

import seguridad.controlador.*;

public class clsEmpleados {
    private int empid;
    private String empnombre;
    private String empsueldo; 
    private String empestado;
    private String empdias;
   
    public clsEmpleados() {
    }

    public clsEmpleados(int p_empid) {
        this.empid = p_empid;
    }
    
    public clsEmpleados(String empnombre, String empsueldo, String empestado, String empdias) {
        this.empnombre = empnombre;
        this.empsueldo = empsueldo;
        this.empestado = empestado;
        this.empdias = empdias;
    }
    
    public clsEmpleados(int empid, String empnombre, String empsueldo, String empestado, String empdias) {
        this.empid = empid;
        this.empnombre = empnombre;
        this.empsueldo = empsueldo;
        this.empestado = empestado;
        this.empdias = empdias;
    }
    
    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    public int getempid() {
        return empid;
    }

    public void setempid(int empid) {
        this.empid = empid;
    }

    public String getempnombre() {
        return empnombre;
    }

    public void setempnombre(String empnombre) {
        this.empnombre = empnombre;
    }

    public String getempsueldo() {
        return empsueldo;
    }

    public void setempsueldo(String empsueldo) {
        this.empsueldo = empsueldo;
    }

    public String getempestado() {
        return empestado;
    }

    public void setempestado(String empestado) {
        this.empestado = empestado;
    }

    public String getempdias() {
        return empdias;
    }

    public void setempdias(String empdias) {
        this.empdias = empdias;
    }
}