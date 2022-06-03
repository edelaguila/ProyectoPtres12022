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
import ventas.controlador.clsDetalles_Ventas;

/**
 *
 * @author Pablo
 */
public class daoDetalles_Ventas {


    private static final String SQL_SELECT = "SELECT id_detalle_venta, id_venta, producto, cantidad, precio, total FROM tbl_detalles_ventas";
    private static final String SQL_INSERT = "INSERT INTO tbl_detalles_ventas(id_venta, producto, cantidad, precio, total) VALUES(?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_detalles_ventas SET id_venta=?, producto=?, cantidad=?, precio=? AND total=?  WHERE id_detalle_venta=?";
    private static final String SQL_DELETE = "DELETE FROM tbl_detalles_ventas WHERE id_detalle_venta=?";
    private static final String SQL_QUERY = "SELECT id_venta, fecha, pago, id_vendedor, id_cliente, id_venta FROM tbl_detalles_ventas WHERE id_detalle_venta= ?";





    public List<clsDetalles_Ventas> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsDetalles_Ventas venta = null;
        List<clsDetalles_Ventas> ventas = new ArrayList<clsDetalles_Ventas>();

        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_detalle_venta  = rs.getInt("id_detalle_venta");
                int id_venta= rs.getInt("id_venta");
                String producto= rs.getString("producto");
                int cantidad= rs.getInt("cantidad");
                double precio= rs.getDouble("precio");
                double total= rs.getDouble("total");


                venta = new clsDetalles_Ventas();
                venta.setId_detalle_venta(id_detalle_venta);
                venta.setId_venta(id_venta);
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

    public int insert(clsDetalles_Ventas venta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, venta.getId_venta());
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

    public int update(clsDetalles_Ventas venta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, venta.getId_detalle_venta());
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

    public int delete(clsDetalles_Ventas venta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, venta.getId_detalle_venta());
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
    public clsDetalles_Ventas query(clsDetalles_Ventas venta) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<clsDetalles_Ventas> vendedores = new ArrayList<clsDetalles_Ventas>();
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, venta.getId_detalle_venta());
            rs = stmt.executeQuery();
            while (rs.next()) {
                 int id_detalle_venta  = rs.getInt("id_detalle_venta");
                int id_venta= rs.getInt("id_venta");
                String producto= rs.getString("producto");
                int cantidad= rs.getInt("cantidad");
                double precio= rs.getDouble("precio");
                double total= rs.getDouble("total");


                venta = new clsDetalles_Ventas();
                venta.setId_detalle_venta(id_detalle_venta);
                venta.setId_venta(id_venta);
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
