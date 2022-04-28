package rrhh.controlador;

public class clsdepartamento {
    private int codigo_departamento;
    private String nombre_departamento;
    private String estatus_departamento;

    public clsdepartamento() {
    }

    public clsdepartamento(int codigodepa) {
        this.codigo_departamento = codigodepa;
    }
    
    public clsdepartamento(String snombre, String sestado) {
        this.nombre_departamento = snombre;
        this.estatus_departamento = sestado;
    }
    
    public clsdepartamento(int codigodepa, String snombre, String sestado) {
        this.codigo_departamento = codigodepa;
        this.nombre_departamento = snombre;
        this.estatus_departamento = sestado;
    }
    

    public int getcodigo_departamento() {
        return codigo_departamento;
    }

    public void setcodigo_departamento(int codigodepa) {
        this.codigo_departamento = codigodepa;
    }

    public String getnombre_departamento() {
        return nombre_departamento;
    }

    public void setnombre_departamento(String snombre) {
        this.nombre_departamento = snombre;
    }

    public String getestatus_departamento() {
        return estatus_departamento;
    }

    public void setestatus_departamento(String sestado) {
        this.estatus_departamento = sestado;
    }
    @Override
    public String toString() {
        return "tbl_departamento{" + "codigo_departamento=" + codigo_departamento + ", nombre_departamento="  +  nombre_departamento +", estatus=" + estatus_departamento +  "}";
    }
    
    
}
