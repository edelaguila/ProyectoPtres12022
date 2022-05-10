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
public class clsAsignacion {
    private int aid;
    private String anombre;
    private String aconcepto; 
    private String avalor; 
    

    public clsAsignacion() {
    }

    public clsAsignacion(int id) {
        this.aid= id;
    }

    public clsAsignacion(String nombre,String concepto, String valor) {
        this.anombre = nombre;
        this.aconcepto = concepto;
        this.avalor = valor;
        
    }
     public clsAsignacion(int id, String nombre,String concepto, String valor) {
        this.aid= id;
        this.anombre = nombre;
        this.aconcepto = concepto;
        this.avalor = valor;
    }

    public int getaid() {
        return aid;
    }

    public void setaid(int id) {
        this.aid = id;
    }

    public String getanombre() {
        return anombre;
    }

    public void setanombre(String nombre) {
        this.anombre = nombre;
    }

    public String getaconcepto() {
        return aconcepto;
    }

    public void setaconcepto(String concepto) {
        this.aconcepto = concepto;
    }
    public String getavalor() {
        return avalor;
    }
     public void setavalor(String valor) {
        this.avalor = valor;
     }
      
     

    @Override
    public String toString() {
        return "tbl_asignacion{" + "aid=" + aid + ", anombre=" + anombre + ", aconcepto=" + aconcepto + ", avalor ="+ avalor +'}';
    }
    
     }

