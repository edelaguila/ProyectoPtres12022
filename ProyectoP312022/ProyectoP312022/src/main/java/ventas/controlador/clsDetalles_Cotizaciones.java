/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ventas.controlador;

/**
 *
 * @author Pablo
 */
public class clsDetalles_Cotizaciones {
    private int id_detalle_cotizacion;
    private int id_cotizacion;
    private String producto;
    private int cantidad;
    private double precio;
    private double total;

    public clsDetalles_Cotizaciones() {
    }

    public clsDetalles_Cotizaciones(int id_detalle_cotizacion, int id_cotizacion, String producto, int cantidad, double precio, double total) {
        this.id_detalle_cotizacion = id_detalle_cotizacion;
        this.id_cotizacion = id_cotizacion;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.total = total;
    }

    public int getId_detalle_cotizacion() {
        return id_detalle_cotizacion;
    }

    public void setId_detalle_cotizacion(int id_detalle_cotizacion) {
        this.id_detalle_cotizacion = id_detalle_cotizacion;
    }

    public int getId_cotizacion() {
        return id_cotizacion;
    }

    public void setId_cotizacion(int id_cotizacion) {
        this.id_cotizacion = id_cotizacion;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    

    

 @Override
    public String toString() {
         return "tbl_detalles_cotizaciones{" + "id_detalle_venta=" + id_detalle_cotizacion+ ", id_cotizacion=" + id_cotizacion + ", producto=" + producto + ", cantidad=" + cantidad +", precio=" + precio +", total=" + total + '}';
    }


}
