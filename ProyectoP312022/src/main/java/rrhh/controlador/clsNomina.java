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
    private int nomiid;
    private String nominombre;
    private String nomicargo; 
    private String nomidepart;
    private String nomisalario;
    private String nomiconcepto;
    private String nomivalor; 

    public clsNomina() {
    }

    public clsNomina(int nomiid, String nominombre, String nomicargo, String nomidepart, String nomisalario, String nomiconcepto, String nomivalor) {
        this.nomiid= nomiid;
        this.nominombre = nominombre;
        this.nomicargo = nomicargo;
        this.nomidepart = nomidepart;
        this.nomisalario = nomisalario;
        this.nomiconcepto = nomiconcepto;
        this.nomivalor = nomivalor;
    }

    public clsNomina(String nominombre, String nomicargo, String nomidepart, String nomisalario, String nomiconcepto, String nomivalor) {
        this.nomiid= nomiid;
        this.nominombre = nominombre;
        this.nomicargo = nomicargo;
        this.nomidepart = nomidepart;
        this.nomisalario = nomisalario;
        this.nomiconcepto = nomiconcepto;
        this.nomivalor = nomivalor;
    }

    public int getnomiid() {
        return nomiid;
    }

    public void setnomiid(int nomiid) {
        this.nomiid = nomiid;
    }

    public String getnominombre() {
        return nominombre;
    }

    public void setnominombre(String nominombre) {
        this.nominombre = nominombre;
    }

    public String getnomicargo() {
        return nomicargo;
    }

    public void setnomicargo(String nomicargo) {
        this.nomicargo = nomicargo;
    }
    public String getnomidepart() {
        return nomidepart;
    }
     public void setnomidepart(String nomidepart) {
        this.nomidepart = nomidepart;
     }
     
      public String getnomisalario() {
        return nomisalario;
    }
     public void setnomisalario(String nomisalario) {
        this.nomisalario = nomisalario;
    }

      public String getnomiconcepto() {
        return nomiconcepto;
    }
     public void setnomiconcepto(String nomiconcepto) {
        this.nomiconcepto = nomiconcepto;
    }
     
     public String getnomivalor() {
        return nomivalor;
    }
     public void setnomivalor(String nomivalor) {
        this.nomivalor = nomivalor;
    } 
     
    @Override
    public String toString() {
        return "tbl_nomina{" + "nomiid=" + nomiid + ", nominombre=" + nominombre + ", nomicargo=" + nomicargo + ",nomidepart="+ nomidepart+",nomisalario="+ nomisalario+",nomiconcepto"+nomiconcepto+",nomivalor"+nomivalor+'}';
    }
    
     }

