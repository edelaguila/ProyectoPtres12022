/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ventas.controlador;

/**
 *
 * @author Pablo
 */
public class clsCuentas_por_cobrar {
    int id_cobro;
    String tipo_pago;
    int id_cobrador;
    int id_cliente;
    double saldo;

    public clsCuentas_por_cobrar() {
    }

    public clsCuentas_por_cobrar(int id_cobro, String tipo_pago, int id_cobrador, int id_cliente, double saldo) {
        this.id_cobro = id_cobro;
        this.tipo_pago = tipo_pago;
        this.id_cobrador = id_cobrador;
        this.id_cliente = id_cliente;
        this.saldo = saldo;
    }

    public int getId_cobro() {
        return id_cobro;
    }

    public void setId_cobro(int id_cobro) {
        this.id_cobro = id_cobro;
    }

    public String getTipo_pago() {
        return tipo_pago;
    }

    public void setTipo_pago(String tipo_pago) {
        this.tipo_pago = tipo_pago;
    }

    public int getId_cobrador() {
        return id_cobrador;
    }

    public void setId_cobrador(int id_cobrador) {
        this.id_cobrador = id_cobrador;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }


  @Override
    public String toString() {
         return "tbl_cuentas_por_cobrar{" + "id_cobro =" + id_cobro + ", tipo_pago=" + tipo_pago + ", id_cobrador=" + id_cobrador + ", id_cliente=" + id_cliente +", saldo=" + saldo + '}';
    }

}
