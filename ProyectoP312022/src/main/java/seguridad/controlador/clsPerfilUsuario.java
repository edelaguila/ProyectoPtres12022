package seguridad.controlador;

public class clsPerfilUsuario {
    int perid;
    int usuid;

    public clsPerfilUsuario() {
    }

    public clsPerfilUsuario(int perid, int usuid) {
        this.perid= perid;
        this.usuid= usuid;
    }

    public int getperfil() {
        return perid;
    }

    public void setperfil(int perid) {
        this.perid = perid;
    }

 public int getusuario() {
        return usuid;
    }
 
public void setusuario(int usuid) {
        this.usuid = usuid;
    }

    @Override
    public String toString() {
        return "tbl_perfilusuario{" + "perid=" + perid + ", usuid=" + usuid + '}';
    }
    
}
