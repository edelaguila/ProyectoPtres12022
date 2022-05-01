/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.controlador;

import seguridad.controlador.*;

/**
 *
 * @author visitante
 */
public class clsConcepto {
    int aplid;
    String aplnombre;
    String aplestatus;

    public clsConcepto() {
    }

    public clsConcepto(int id_aplicacion) {
        this.aplid= id_aplicacion;
    }

    public clsConcepto(String nombreAplicacion, String estadoAplicacion) {
        this.aplnombre = nombreAplicacion;
        this.aplestatus = estadoAplicacion;
    }

    public int getId_aplicacion() {
        return aplid;
    }

    public void setId_aplicacion(int id_aplicacion) {
        this.aplid = id_aplicacion;
    }

    public String getNombreAplicacion() {
        return aplnombre;
    }

    public void setNombreAplicacion(String nombreAplicacion) {
        this.aplnombre = nombreAplicacion;
    }

    public String getestadoAplicacion() {
        return aplestatus;
    }

    public void setestadoAplicacion(String estadoAplicacion) {
        this.aplestatus = estadoAplicacion;
    }

    @Override
    public String toString() {
        return "tbl_aplicacion{" + "aplid=" + aplid + ", aplnombre=" + aplnombre + ", aplestatus=" + aplestatus + '}';
    }
    
}
