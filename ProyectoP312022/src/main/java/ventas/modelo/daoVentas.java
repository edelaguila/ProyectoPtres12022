/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas.modelo;

import ventas.controlador.clsVendedores;
import ventas.controlador.clsVentas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import seguridad.modelo.clsConexion;
import ventas.controlador.clsClientes;
import ventas.controlador.clsVentas;

/**
 *
 * @author visitante
 */
public class daoVentas {

    private static final String SQL_SELECT = "SELECT id_venta, tipo, cantidad, producto, precio, total, fecha, id_cliente, id_vendedor FROM tbl_ventas";
    private static final String SQL_INSERT = "INSERT INTO tbl_ventas(tipo, cantidad, producto, precio, total, fecha, id_cliente, id_vendedor) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_ventas SET tipo=?, cantidad=?, producto=?, precio=?, total=?, fecha=?, id_cliente=? AND id_vendedor=? WHERE id_venta = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_ventas WHERE id_venta=?";
    private static final String SQL_QUERY = "SELECT id_venta, tipo, cantidad, producto, precio, total, fecha, id_cliente, id_vendedor FROM tbl_ventas WHERE id_venta = ?";


    public List<clsVentas> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsVentas venta = null;
        List<clsVentas> ventas = new ArrayList<clsVentas>();

        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int iId_venta = rs.getInt("id_venta");
                String sTipo = rs.getString("tipo");
                int iCantidad = rs.getInt("cantidad");
                String sProducto = rs.getString("producto");
                double fPrecio = rs.getDouble("precio");
                double fTotal = rs.getDouble("total");
                String Sfecha = rs.getString("fecha");
                int iId_cliente = rs.getInt("id_cliente");
                int iId_vendedor = rs.getInt("id_vendedor");

                venta = new clsVentas();
                venta.fSetid_Venta(iId_venta);
                venta.fSettipo_Venta(sTipo);
                venta.fSetcantidad_Venta(iCantidad);
                venta.fSetproducto_Venta(sProducto);
                venta.fSetprecio_Venta(fPrecio);
                venta.fSettotal_Venta(fTotal);
                venta.fSetfecha_Venta(Sfecha);
                venta.fSetid_Cliente(iId_cliente);
                venta.fSetid_Vendedor(iId_vendedor);
                
                ventas.add(venta);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return ventas;
    }

    public int insert(clsVentas venta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, venta.fGettipo_Venta());
            stmt.setInt(2, venta.fGetcantidad_Venta());
            stmt.setString(3, venta.fGetproducto_Venta());
            stmt.setDouble(4, venta.fGetprecio_Venta());
            stmt.setDouble(5, venta.fGettotal_Venta());
            stmt.setString(6, venta.fGetfecha_Venta());
            stmt.setInt(7, venta.fGetid_Cliente());
            stmt.setInt(8, venta.fGetid_Vendedor());


            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return rows;
    }

    public int update(clsVentas venta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, venta.fGettipo_Venta());
            stmt.setInt(2, venta.fGetcantidad_Venta());
            stmt.setString(3, venta.fGetproducto_Venta());
            stmt.setDouble(4, venta.fGetprecio_Venta());
            stmt.setDouble(5, venta.fGettotal_Venta());
            stmt.setString(6, venta.fGetfecha_Venta());
            stmt.setInt(7, venta.fGetid_Cliente());
            stmt.setInt(8, venta.fGetid_Vendedor    ());

            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return rows;
    }

    public int delete(clsVentas venta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, venta.fGetid_Venta());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return rows;
    }

//    public List<Persona> query(Persona vendedor) { // Si se utiliza un ArrayList
    public clsVentas query(clsVentas venta) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<clsVentas> vendedores = new ArrayList<clsVentas>();
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, venta.fGetid_Venta());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int iId_venta = rs.getInt("id_venta");
                String sTipo = rs.getString("tipo");
                int iCantidad = rs.getInt("cantidad");
                String sProducto = rs.getString("producto");
                double fPrecio = rs.getFloat("precio");
                double fTotal = rs.getFloat("total");
                String Sfecha = rs.getString("fecha");
                int iId_cliente = rs.getInt("id_cliente");
                int iId_vendedor = rs.getInt("id_vendedor");

                venta = new clsVentas();
                venta.fSetid_Venta(iId_venta);
                venta.fSettipo_Venta(sTipo);
                venta.fSetcantidad_Venta(iCantidad);
                venta.fSetproducto_Venta(sProducto);
                venta.fSetprecio_Venta(fPrecio);
                venta.fSettotal_Venta(fTotal);
                venta.fSetfecha_Venta(Sfecha);
                venta.fSetid_Cliente(iId_cliente);
                venta.fSetid_Vendedor(iId_vendedor);
                
                //vendedores.add(vendedor); // Si se utiliza un ArrayList
            }
            //System.out.println("Registros buscado:" + vendedor);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        //return vendedores;  // Si se utiliza un ArrayList
        return venta;
    }


    public String email( String cliente){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
    String correo="";
    try{
    conn = clsConexion.getConnection();
    stmt = conn.prepareStatement("SELECT Correo FROM tbl_clientes WHERE Id_cliente  = '"+cliente+"'");
    rs = stmt.executeQuery();
    clsClientes clientes = new clsClientes();
    while (rs.next()) {
    correo=rs.getString("Correo");
    }
    } catch(Exception e){

    }   
    return correo;
    }


public String name( String cliente){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
String nombre="";
try{
conn = clsConexion.getConnection();
stmt = conn.prepareStatement("SELECT Nombre FROM tbl_clientes WHERE Id_cliente  = '"+cliente+"'");
rs = stmt.executeQuery();
clsClientes clientes = new clsClientes();
while (rs.next()) {
nombre=rs.getString("Nombre");
}
} catch(Exception e){

}
return nombre;
}



public int vendor( String cliente){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
int vendedor=0;
try{
conn = clsConexion.getConnection();
stmt = conn.prepareStatement("SELECT Id_vendedor FROM tbl_clientes WHERE Id_cliente  = '"+cliente+"'");
rs = stmt.executeQuery();
clsClientes clientes = new clsClientes();
while (rs.next()) {
vendedor=rs.getInt("Id_vendedor");
}
} catch(Exception e){

}
return vendedor;
}



public String type( String cliente){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
String tipo="";
try{
conn = clsConexion.getConnection();
stmt = conn.prepareStatement("SELECT Tipo FROM tbl_clientes WHERE Id_cliente  = '"+cliente+"'");
rs = stmt.executeQuery();
clsClientes clientes = new clsClientes();
while (rs.next()) {
tipo=rs.getString("Tipo");
}
} catch(Exception e){

}
return tipo;
}




}
