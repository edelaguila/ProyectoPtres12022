package compras.controlador;
import compras.vista.*;

public class clsConcepto {
 private int conid;   
 private String connombre;
 private String conefecto;
 private String conestatus;

    public clsConcepto() {
    }

    public clsConcepto(int conid, String connombre, String conefecto, String conestatus) {
        this.conid = conid; 
        this.connombre = connombre;
        this.conefecto = conefecto;
        this.conestatus = conestatus;
    }

    public int getConid() {
        return conid;
    }

    public void setConid(int conid) {
        this.conid = conid;
    }
 

    public String getConnombre() {
        return connombre;
    }

    public void setConnombre(String connombre) {
        this.connombre = connombre;
    }

    public String getConefecto() {
        return conefecto;
    }

    public void setConefecto(String conefecto) {
        this.conefecto = conefecto;
    }

    public String getConestatus() {
        return conestatus;
    }

    public void setConestatus(String conestatus) {
        this.conestatus = conestatus;
    }

    @Override
    public String toString() {
        return "clsConcepto{" + "conid=" + conid + ", connombre=" + connombre + ", conefecto=" + conefecto + ", conestatus=" + conestatus +'}';
    }

 
    
}
