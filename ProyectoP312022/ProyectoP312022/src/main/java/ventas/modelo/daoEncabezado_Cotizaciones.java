/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ventas.modelo;
import ventas.controlador.clsEncabezado_Cotizaciones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import seguridad.modelo.clsConexion;
import seguridad.modelo.clsConexion;
import ventas.controlador.clsClientes;

/**
 *
 * @author Pablo
 */
public class daoEncabezado_Cotizaciones {


    private static final String SQL_SELECT = "SELECT id_cotizacion, fecha, id_vendedor, id_cliente, tipo_cliente, total FROM tbl_encabezado_cotizacion";
    private static final String SQL_INSERT = "INSERT INTO tbl_encabezado_cotizacion (fecha, id_vendedor, id_cliente, tipo_cliente, total) VALUES(?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_encabezado_cotizacion SET fecha=?, id_vendedor=?, id_cliente=?, tipo_cliente=? AND total=?  WHERE id_cotizacion = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_encabezado_cotizacion WHERE id_cotizacion=?";
    private static final String SQL_QUERY = "SELECT id_venta, fecha, id_vendedor, id_cliente, tipo_cliente, total FROM tbl_encabezado_cotizacion WHERE id_cotizacion= ?";





    public List<clsEncabezado_Cotizaciones> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsEncabezado_Cotizaciones venta = null;
        List<clsEncabezado_Cotizaciones> ventas = new ArrayList<clsEncabezado_Cotizaciones>();

        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int iId_cotizacion   = rs.getInt("id_cotizacion");
                String sFecha = rs.getString("fecha");
                int iId_vendedor  = rs.getInt("id_vendedor");
                int iId_cliente  = rs.getInt("id_cliente");
                String tipo_cliente  = rs.getString("tipo_cliente");
                double total  = rs.getDouble("total");


                venta = new clsEncabezado_Cotizaciones();
                venta.setId_cotizacion(iId_cotizacion);
                venta.setFecha(sFecha);
                venta.setId_cliente(iId_cliente);
                venta.setId_vendedor(iId_vendedor);
                venta.setTipo_cliente(tipo_cliente);
                venta.setTotal(total);
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

    public int insert(clsEncabezado_Cotizaciones venta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, venta.getFecha());
            stmt.setInt(2, venta.getId_vendedor());
            stmt.setInt(3, venta.getId_cliente());
            stmt.setString(4, venta.getTipo_cliente());
            stmt.setDouble(5, venta.getTotal());


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

    public int update(clsEncabezado_Cotizaciones venta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, venta.getId_cotizacion());
            stmt.setString(2, venta.getFecha());
            stmt.setInt(3, venta.getId_vendedor());
            stmt.setInt(4, venta.getId_cliente());
            stmt.setString(5, venta.getTipo_cliente());
            stmt.setDouble(6, venta.getTotal());

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

    public int delete(clsEncabezado_Cotizaciones venta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, venta.getId_cotizacion());
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
    public clsEncabezado_Cotizaciones query(clsEncabezado_Cotizaciones venta) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<clsEncabezado_Cotizaciones> vendedores = new ArrayList<clsEncabezado_Cotizaciones>();
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, venta.getId_cotizacion());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int iId_cotizacion   = rs.getInt("id_cotizacion");
                String sFecha = rs.getString("fecha");
                int iId_vendedor  = rs.getInt("id_vendedor");
                int iId_cliente  = rs.getInt("id_cliente");
                String tipo_cliente  = rs.getString("tipo_cliente");
                double total  = rs.getDouble("total");


                venta = new clsEncabezado_Cotizaciones();
                venta.setId_cotizacion(iId_cotizacion);
                venta.setFecha(sFecha);
                venta.setId_cliente(iId_cliente);
                venta.setId_vendedor(iId_vendedor);
                venta.setTipo_cliente(tipo_cliente);
                venta.setTotal(total);
                
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
