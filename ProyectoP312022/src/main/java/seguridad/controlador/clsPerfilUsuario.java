package seguridad.controlador;

public class clsPerfilUsuario {

    private String perid;
    private String usuid;

    public clsPerfilUsuario() {
    }


    
    public clsPerfilUsuario(String perid, String usuid) {
        this.perid = perid;
        this.usuid = usuid;
    }
    
 
  

    public String getperfil() {
        return perid;
    }

    public void setperfil(String perid) {
        this.perid= perid;
    }

    public String getusuario() {
        return usuid;
    }

    public void setusuario(String usuid) {
        this.usuid = usuid;
    }

    @Override
    public String toString() {
        return "tbl_perfilusuario{"  + " Perid=" + perid + ", usuid=" + usuid + '}';
    }
    
    
}
