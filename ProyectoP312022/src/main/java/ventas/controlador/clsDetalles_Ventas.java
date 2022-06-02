/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ventas.controlador;

/**
 *
 * @author Pablo
 */
public class clsDetalles_Ventas {
    private int id_detalle_venta;
    private int id_venta;
    private String producto;
    private int cantidad;
    private double precio;
    private double total;

    public clsDetalles_Ventas() {
    }

    public clsDetalles_Ventas(int id_detalle_venta, int id_venta, String producto, int cantidad, double precio, double total) {
        this.id_detalle_venta = id_detalle_venta;
        this.id_venta = id_venta;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.total = total;
    }

    public int getId_detalle_venta() {
        return id_detalle_venta;
    }

    public void setId_detalle_venta(int id_detalle_venta) {
        this.id_detalle_venta = id_detalle_venta;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
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
         return "tbl_detalles_ventas{" + "id_detalle_venta=" + id_detalle_venta  + ", id_venta=" + id_venta + ", producto=" + producto + ", cantidad=" + cantidad +", precio=" + precio +", total=" + total + '}';
    }


}
