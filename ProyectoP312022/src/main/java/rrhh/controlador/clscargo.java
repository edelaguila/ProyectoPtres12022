package rrhh.controlador;

public class clscargo {
    private int idcargo;
    private String nombrecargo;
    private String estatuscargo;

    public clscargo() {
    }

    public clscargo(int idcargo) {
        this.idcargo = idcargo;
    }
    
    public clscargo(String snombre, String sestado) {
        this.nombrecargo = snombre;
        this.estatuscargo = sestado;
    }
    
    public clscargo(int idcargo, String snombre, String sestado) {
        this.idcargo = idcargo;
        this.nombrecargo = snombre;
        this.estatuscargo = sestado;
    }
    

    public int getidcargo() {
        return idcargo;
    }

    public void setidcargo(int idcargo) {
        this.idcargo = idcargo;
    }

    public String getnombrecargo() {
        return nombrecargo;
    }

    public void setnombrecargo(String snombre) {
        this.nombrecargo = snombre;
    }

    public String getestatuscargo() {
        return estatuscargo;
    }

    public void setestatuscargo(String sestado) {
        this.estatuscargo = sestado;
    }
    @Override
    public String toString() {
        return "tbl_cargo{" + "idcargo=" + idcargo + ", nombrecargo="  +  nombrecargo +", estatus=" + estatuscargo +  "}";
    }
    
    
}
