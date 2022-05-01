/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.controlador;


/**
 *
 * @author visitante
 */
public class clsConcepto {
    private int Concepid;
    private String Concepnombre;
    private String Concepefecto; 
    private String Concepestado;
    

    public clsConcepto() {
    }

    public clsConcepto(int id_Concepto) {
        this.Concepid= id_Concepto;
    }

    public clsConcepto(String nombre, String estado) {
        this. Concepnombre = nombre;
        this.Concepestado = estado;
    }

    public int getId_Concepto() {
        return Concepid;
    }

    public void setId_Concepto(int id_Concepto) {
        this.Concepid = id_Concepto;
    }

    public String getNombre() {
        return Concepnombre;
    }

    public void setNombre(String nombre) {
        this.Concepnombre = nombre;
    }

    public String getestado() {
        return Concepestado;
    }

    public void setestado(String estado) {
        this.Concepestado = estado;
    }
    public String getefecto() {
        return Concepefecto;
    }
     public void setefecto(String efecto) {
        this.Concepefecto = efecto;
     }

    @Override
    public String toString() {
        return "tbl_Concepto{" + "Concepid=" + Concepid + ", Concepnombre=" + Concepnombre + ", Concepestado=" + Concepestado + ",Concepefecto="+ Concepefecto+'}';
    }
    
     }

