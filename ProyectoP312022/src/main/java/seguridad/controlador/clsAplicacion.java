/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguridad.controlador;

public class clsAplicacion {
    int id_aplicacion;
    String nombre_aplicacion;
    String estatus_aplicacion;

    public clsAplicacion() {
    }

    public clsAplicacion(int id_aplicacion) {
        this.id_aplicacion= id_aplicacion;
    }

    public clsAplicacion(String nombre_aplicacion, String estatus_aplicacion) {
        this.nombre_aplicacion = nombre_aplicacion;
        this.estatus_aplicacion= estatus_aplicacion;
    }

    public int getId_aplicacion() {
        return id_aplicacion;
    }

    public void setId_aplicacion(int id_aplicacion) {
        this.id_aplicacion = id_aplicacion;
    }

    public String getNombre_aplicaion() {
        return nombre_aplicacion;
    }

    public void setNombre_aplicacion(String nombre_aplicacion) {
        this.nombre_aplicacion = nombre_aplicacion;
    }

    public String getEstatus_aplicacion() {
        return estatus_aplicacion;
    }

    public void setEstatus_aplicacion(String estatus_aplicacion) {
        this.estatus_aplicacion = estatus_aplicacion;
    }

    @Override
    public String toString() {
        return "Aplicaciones{" + "id_aplicacion=" + id_aplicacion + ", nombre_aplicacion=" + nombre_aplicacion+ ", estatus_aplicacion=" + estatus_aplicacion+ '}';
    }
    
     }
    
    
