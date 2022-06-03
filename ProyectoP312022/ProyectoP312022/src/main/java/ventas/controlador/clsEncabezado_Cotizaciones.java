/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ventas.controlador;

/**
 *
 * @author Pablo
 */
public class clsEncabezado_Cotizaciones {
    private int id_cotizacion;
    private String fecha;
    private String pago;
    private int id_vendedor;
    private int id_cliente;
    private String tipo_cliente;
    private double total;

    public clsEncabezado_Cotizaciones() {
    }

    public clsEncabezado_Cotizaciones(int id_cotizacion, String fecha, String pago, int id_vendedor, int id_cliente, String tipo_cliente, double total) {
        this.id_cotizacion = id_cotizacion;
        this.fecha = fecha;
        this.pago = pago;
        this.id_vendedor = id_vendedor;
        this.id_cliente = id_cliente;
        this.tipo_cliente = tipo_cliente;
        this.total = total;
    }

    public int getId_cotizacion() {
        return id_cotizacion;
    }

    public void setId_cotizacion(int id_cotizacion) {
        this.id_cotizacion = id_cotizacion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getPago() {
        return pago;
    }

    public void setPago(String pago) {
        this.pago = pago;
    }

    public int getId_vendedor() {
        return id_vendedor;
    }

    public void setId_vendedor(int id_vendedor) {
        this.id_vendedor = id_vendedor;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getTipo_cliente() {
        return tipo_cliente;
    }

    public void setTipo_cliente(String tipo_cliente) {
        this.tipo_cliente = tipo_cliente;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

   
   

   

 
  

   @Override
    public String toString() {
         return "tbl_encabezado_cotizacion{" + "id_cotizacion=" + id_cotizacion+ ", fecha =" + fecha + ", pago=" + pago + ", id_vendedor=" + id_vendedor +", id_cliente=" + id_cliente +", tipo_cliente=" + tipo_cliente +", total=" + total + '}';
    }








}
