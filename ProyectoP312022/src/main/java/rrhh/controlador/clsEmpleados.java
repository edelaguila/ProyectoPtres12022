package rrhh.controlador;

import seguridad.controlador.*;

public class clsEmpleados {
    private int empid;
    private String empnombre;
    private int empsueldo; 
    private String empestado;
    private int empdias;
   
    public clsEmpleados() {
    }

    public clsEmpleados(int p_empid) {
        this.empid = p_empid;
    }
    
    public clsEmpleados(String empnombre, int empsueldo, String empestado, int empdias) {
        this.empnombre = empnombre;
        this.empsueldo = empsueldo;
        this.empestado = empestado;
        this.empdias = empdias;
    }
    
    public clsEmpleados(int empid, String empnombre, int empsueldo, String empestado, int empdias) {
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

    public int getempsueldo() {
        return empsueldo;
    }

    public void setempsueldo(int empsueldo) {
        this.empsueldo = empsueldo;
    }

    public String getempestado() {
        return empestado;
    }

    public void setempestado(String empestado) {
        this.empestado = empestado;
    }

    public int getempdias() {
        return empdias;
    }

    public void setempdias(int empdias) {
        this.empdias = empdias;
    }
}