package compras.controlador;

public class clsProveedor {
    private int provid;
    private String provnombre;
    private String provestado;
    private int provtelefono;
    private String provdireccion;

    public clsProveedor() {
    }

    public clsProveedor(int provid) {
        this.provid = provid;
    }
    
    public clsProveedor(String provnombre, String provestado) {
        this.provnombre = provnombre;
        this.provestado = provestado;
    }
    
    public clsProveedor(int provid, String provnombre, String provestado) {
        this.provid = provid;
        this.provnombre = provnombre;
        this.provestado = provestado;
    }
    

    public int getprovid() {
        return provid;
    }

    public void setprovid(int provid) {
        this.provid = provid;
    }

    public String getprovnombre() {
        return provnombre;
    }

    public void setprovnombre(String provnombre) {
        this.provnombre = provnombre;
    }

    public String getprovestado() {
        return provestado;
    }

    public void setprovestado(String provestado) {
        this.provestado = provestado;
    }
    
    public int getprovtelefono() {
        return provtelefono;
    }

    public void setprovtelefono(int provtelefono) {
        this.provtelefono = provtelefono;
    }

    public String getprovtdireccion() {
        return provdireccion;
    }

    public void setprovtdireccion(String provdireccion) {
        this.provdireccion = provdireccion;
    }
    @Override
    public String toString() {
        return "tbl_proveedor{" + "provid=" + provid + ", provnombre=" + provnombre + ", provestado=" + provestado + ", provtelefono=" + provtelefono + ", provdireccion" + provdireccion + '}';
    }
    
    
}
