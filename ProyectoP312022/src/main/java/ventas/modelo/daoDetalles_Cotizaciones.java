/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ventas.modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import seguridad.modelo.clsConexion;
import seguridad.modelo.clsConexion;
import ventas.controlador.clsDetalles_Cotizaciones;

/**
 *
 * @author Pablo
 */
public class daoDetalles_Cotizaciones {


    private static final String SQL_SELECT = "SELECT Id_detalle_cotizacion, id_cotizacion, producto, cantidad, precio, total FROM tbl_detalles_cotizaciones";
    private static final String SQL_INSERT = "INSERT INTO tbl_detalles_cotizaciones(id_cotizacion, producto, cantidad, precio, total) VALUES(?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_detalles_cotizaciones SET id_cotizacion=?, producto=?, cantidad=?, precio=? AND total=?  WHERE Id_detalle_cotizacion=?";
    private static final String SQL_DELETE = "DELETE FROM tbl_detalles_cotizaciones WHERE Id_detalle_cotizacion=?";
    private static final String SQL_QUERY = "SELECT id_cotizacion, fecha, pago, id_vendedor, id_cliente, id_venta FROM tbl_detalles_cotizaciones WHERE Id_detalle_cotizacion= ?";





    public List<clsDetalles_Cotizaciones> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsDetalles_Cotizaciones venta = null;
        List<clsDetalles_Cotizaciones> ventas = new ArrayList<clsDetalles_Cotizaciones>();

        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int Id_detalle_cotizacion  = rs.getInt("Id_detalle_cotizacion");
                int id_cotizacion= rs.getInt("id_cotizacion");
                String producto= rs.getString("producto");
                int cantidad= rs.getInt("cantidad");
                double precio= rs.getDouble("precio");
                double total= rs.getDouble("total");


                venta = new clsDetalles_Cotizaciones();
                venta.setId_detalle_cotizacion(id_cotizacion);
                venta.setId_cotizacion(id_cotizacion);
                venta.setProducto(producto);
                venta.setCantidad(cantidad);
                venta.setPrecio(precio);
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

    public int insert(clsDetalles_Cotizaciones venta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, venta.getId_cotizacion());
            stmt.setString(2, venta.getProducto());
            stmt.setInt(3, venta.getCantidad());
            stmt.setDouble(4, venta.getPrecio());
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

    public int update(clsDetalles_Cotizaciones venta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, venta.getId_detalle_cotizacion());
            stmt.setString(2, venta.getProducto());
            stmt.setString(3, venta.getProducto());
            stmt.setInt(4, venta.getCantidad());
            stmt.setDouble(5, venta.getPrecio());
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

    public int delete(clsDetalles_Cotizaciones venta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, venta.getId_detalle_cotizacion());
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
    public clsDetalles_Cotizaciones query(clsDetalles_Cotizaciones venta) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<clsDetalles_Cotizaciones> vendedores = new ArrayList<clsDetalles_Cotizaciones>();
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, venta.getId_detalle_cotizacion());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int Id_detalle_cotizacion  = rs.getInt("Id_detalle_cotizacion");
                int id_cotizacion= rs.getInt("id_cotizacion");
                String producto= rs.getString("producto");
                int cantidad= rs.getInt("cantidad");
                double precio= rs.getDouble("precio");
                double total= rs.getDouble("total");


                venta = new clsDetalles_Cotizaciones();
                venta.setId_detalle_cotizacion(id_cotizacion);
                venta.setId_cotizacion(id_cotizacion);
                venta.setProducto(producto);
                venta.setCantidad(cantidad);
                venta.setPrecio(precio);
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

}
