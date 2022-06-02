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
public class clsVentas {
    //declaracion de variable para Vendedores 
    int iId_venta;
    String sTipo;
    int iCantidad;
    String sProducto;
    double fPrecio;
    double fTotal;
    String sFecha;
    int iId_cliente;
    int iId_vendedor;
    String Stipo_de_pago;

    public clsVentas() {
    }

    public clsVentas(int iId_venta) {
    this.iId_venta = iId_venta;
    }

     public clsVentas(int iId_venta, String sTipo, int iCantidad, String sProducto, String sFecha, int iId_cliente, int iId_vendedor, double fPrecio, double fTotal, String Stipo_de_pago) {
        this.iId_venta = iId_venta;
        this.sTipo = sTipo;
        this.iCantidad = iCantidad;
        this.sProducto = sProducto;
        this.fPrecio = fPrecio;
        this.fTotal = fTotal;
        this.sFecha = sFecha;
        this.iId_cliente = iId_cliente;
        this.iId_vendedor = iId_vendedor;
        this.Stipo_de_pago = Stipo_de_pago;
    }



public int fGetid_Venta () {
        return iId_venta;
    }

    public void fSetid_Venta(int iId_venta) {
        this.iId_venta = iId_venta;
    }


    public String fGettipo_Venta() {
        return sTipo;
    }

    public void fSettipo_Venta(String sTipo) {
        this.sTipo = sTipo;
    }



public int fGetcantidad_Venta () {
        return iCantidad;
    }

    public void fSetcantidad_Venta(int iCantidad) {
        this.iCantidad = iCantidad;
    }



    public String fGetproducto_Venta() {
        return sProducto;
    }

    public void fSetproducto_Venta(String sProducto) {
        this.sProducto = sProducto;
    }



    public double fGetprecio_Venta() {
        return fPrecio;
    }

    public void fSetprecio_Venta(double fPrecio) {
        this.fPrecio = fPrecio;
    }



    public double fGettotal_Venta() {
        return fTotal;
    }

    public void fSettotal_Venta(double fTotal) {
        this.fTotal = fTotal;
    }






    public String fGetfecha_Venta() {
        return sFecha;
    }

    public void fSetfecha_Venta(String sFecha) {
        this.sFecha = sFecha;
    }

    

 public int fGetid_Cliente () {
        return iId_cliente;
    }

    public void fSetid_Cliente(int iId_cliente) {
        this.iId_cliente = iId_cliente;
    }



 public int fGetid_Vendedor () {
        return iId_vendedor;
    }

    public void fSetid_Vendedor(int iId_vendedor) {
        this.iId_vendedor = iId_vendedor;
    }


 public String fGetpago_Vendedor () {
        return Stipo_de_pago;
    }

    public void fSetpago_Cliente(String Stipo_de_pago) {
        this.Stipo_de_pago = Stipo_de_pago;
    }



    @Override
    public String toString() {
         return "tbl_ventas{" + "id_venta =" + iId_venta + ", tipo=" + sTipo + ", cantidad=" + iCantidad + ", producto=" + sProducto +", precio=" + fPrecio +", total=" + fTotal +", fecha=" + sFecha +", id_cliente=" + iId_cliente +", id_vendedor=" + iId_vendedor +", tipo_de_pago=" + Stipo_de_pago + '}';
    }
    
}
