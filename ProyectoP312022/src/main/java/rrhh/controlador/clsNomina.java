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
public class clsNomina {
    private int Concepid;
    private String Concepnombre;
    private String Concepefecto; 
    private String Concepestado;
    

    public clsNomina() {
    }

    public clsNomina(int id_Concepto) {
        this.Concepid= id_Concepto;
    }

    public clsNomina(String nombre, String estado) {
        this. Concepnombre = nombre;
        this.Concepestado = estado;
    }

    public int getconcepid() {
        return Concepid;
    }

    public void setconcepid(int id_Concepto) {
        this.Concepid = id_Concepto;
    }

    public String getconcepnombre() {
        return Concepnombre;
    }

    public void setconcepnombre(String nombre) {
        this.Concepnombre = nombre;
    }

    public String getconcepestado() {
        return Concepestado;
    }

    public void setconcepestado(String estado) {
        this.Concepestado = estado;
    }
    public String getconcepefecto() {
        return Concepefecto;
    }
     public void setconcepefecto(String efecto) {
        this.Concepefecto = efecto;
     }

    @Override
    public String toString() {
        return "tbl_Concepto{" + "Concepid=" + Concepid + ", Concepnombre=" + Concepnombre + ", Concepestado=" + Concepestado + ",Concepefecto="+ Concepefecto+'}';
    }
    
     }

