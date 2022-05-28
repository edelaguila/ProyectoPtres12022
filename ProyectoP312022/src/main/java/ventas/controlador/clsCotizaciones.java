/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ventas.controlador;

/**
 *
 * @author Pablo
 */
public class clsCotizaciones {
    int iId_cotizacion;
    String sTipo;
    int iCantidad;
    String sProducto;
    double dPrecio;
    double dTotal;
    String sFecha;
    int iId_cliente;
    int iId_vendedor;


    public clsCotizaciones() {
    }
    public clsCotizaciones(int iId_cotizacion) {
    this.iId_cotizacion = iId_cotizacion;
    }

public clsCotizaciones(int iId_cotizacion, String sTipo, int iCantidad, String sProducto, double dPrecio, double dTotal, String sFecha, int iId_cliente, int iId_vendedor){
    this.iId_cotizacion=iId_cotizacion;
    this.sTipo=sTipo;
    this.iCantidad=iCantidad;
    this.sProducto=sProducto;
    this.dPrecio=dPrecio;
    this.dTotal=dTotal;
    this.sFecha=sFecha;
    this.iId_cliente=iId_cliente;
    this.iId_vendedor=iId_vendedor;
}


    public int fGetid_Cotizacion () {
        return iId_cotizacion;
    }

    public void fSetid_Cotizacion(int iId_cotizacion) {
        this.iId_cotizacion = iId_cotizacion;
    }


    public String fGetTipo_Cotizacion () {
        return sTipo;
    }

    public void fSetTipo_Cotizacion(String sTipo) {
        this.sTipo = sTipo;
    }

   public int fGetCantidad_Cotizacion () {
        return iCantidad;
    }

    public void fSetCantidad_Cotizacion(int iCantidad) {
        this.iCantidad = iCantidad;
    }


    public String fGetProducto_Cotizacion () {
        return sProducto;
    }

    public void fSetProducto_Cotizacion(String sProducto) {
        this.sProducto = sTipo;
    }

    public double fGetPrecio_Cotizacion () {
        return dPrecio;
    }

    public void fSetPrecio_Cotizacion(double dPrecio) {
        this.dPrecio = dPrecio;
    }


    public double fGetTotal_Cotizacion () {
        return dTotal;
    }

    public void fSetTotal_Cotizacion(double dTotal) {
        this.dTotal = dTotal;
    }

    public String fGetFecha_Cotizacion () {
        return sFecha;
    }

    public void fSetFecha_Cotizacion(String sFecha) {
        this.sFecha = sFecha;
    }

   public int fGetId_Cliente () {
        return iId_cliente;
    }

    public void fSetId_Cliente(int iId_cliente) {
        this.iId_cliente = iId_cliente;
    }


  public int fGetId_Vendedor () {
        return iId_vendedor;
    }

    public void fSetid_Vendedor(int iId_vendedor) {
        this.iId_vendedor = iId_vendedor;
    }

    @Override
    public String toString() {
         return "tbl_cotizaciones{" + "Id_cotizacion =" + iId_cotizacion + ", tipo=" + sTipo + ", cantidad=" + iCantidad + ", producto=" + sProducto +", precio=" + dPrecio +", total=" + dTotal +", fecha=" + sFecha +", id_cliente=" + iId_cliente +", id_vendedor=" + iId_vendedor + '}';
    }

}
