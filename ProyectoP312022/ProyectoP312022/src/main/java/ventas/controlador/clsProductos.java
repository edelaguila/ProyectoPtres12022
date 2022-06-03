/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas.controlador;



/**
 *
 * @author visitante
 */
public class clsProductos {
    //declaracion de variable para Vendedores 
    int iId_producto ;
    String sproducto;
    double dprecio_mayorista;
    double dprecio_minorista;
    int idexistencia;

    public clsProductos() {
    }

    public clsProductos(int iId_producto) {
    this.iId_producto = iId_producto;
    }

     public clsProductos(int iId_producto, String sproducto, double dprecio_mayorista, double dprecio_minorista, int idexistencia ) {
        this.iId_producto = iId_producto;
        this.sproducto = sproducto;
        this.dprecio_mayorista = dprecio_mayorista;
        this.dprecio_minorista = dprecio_minorista;
        this.idexistencia = idexistencia;
    }



public int fGetid_Producto () {
        return iId_producto;
    }

    public void fSetid_Producto (int iId_producto) {
        this.iId_producto = iId_producto;
    }



public String fGetproducto_Producto () {
        return sproducto;
    }

    public void fSetproducto_Producto (String sproducto) {
        this.sproducto = sproducto;
    }

 


public double fGetpreciomayorista_Producto () {
        return dprecio_mayorista;
    }

    public void fSetpreciomayorista_Producto (double dprecio_mayorista) {
        this.dprecio_mayorista = dprecio_mayorista;
    }


public double fGetpreciominorista_Producto () {
        return dprecio_minorista;
    }

    public void fSetpreciominorista_Producto (double dprecio_minorista) {
        this.dprecio_minorista = dprecio_minorista;
    }



public int fGetexistencia_Producto () {
        return idexistencia;
    }

    public void fSetexistencia_Producto (int idexistencia) {
        this.idexistencia = idexistencia;
    }



    @Override
    public String toString() {
         return "tbl_productos{" + "Id_producto =" + iId_producto + ", producto=" + sproducto + ", precio_mayorista=" + dprecio_mayorista + ", precio_minorista=" + dprecio_minorista +", existencia=" + idexistencia + '}';
    }
    
}
