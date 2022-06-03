/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas.modelo;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import seguridad.modelo.clsConexion;
import ventas.controlador.clsProductos;

/**
 *
 * @author visitante
 */
public class daoProductos {

    private static final String SQL_SELECT = "SELECT Id_producto, producto, precio_mayorista, precio_minorista, existencia FROM tbl_productos";
    private static final String SQL_INSERT = "INSERT INTO tbl_productos(producto, precio_mayorista, precio_minorista, existencia) VALUES(?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_productos SET producto=?, precio_mayorista=?, precio_minorista=?, AND existencia=? WHERE Id_producto = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_productos WHERE Id_producto=?";
    private static final String SQL_QUERY = "SELECT Id_producto, producto, precio_mayorista, precio_minorista, existencia FROM tbl_productos WHERE producto = ?";


    public List<clsProductos> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsProductos productor = null;
        List<clsProductos> productos = new ArrayList<clsProductos>();

        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int iId_vendedor = rs.getInt("Id_producto");
                String sproducto= rs.getString("producto");
                double dprecio_mayorista= rs.getDouble("precio_mayorista");
                double dprecio_minorista= rs.getDouble("precio_minorista");
                int idexistencia= rs.getInt("existencia");

                productor = new clsProductos();
                productor.fSetid_Producto(iId_vendedor);
                productor.fSetproducto_Producto(sproducto);
                productor.fSetpreciomayorista_Producto(dprecio_mayorista);
                productor.fSetpreciominorista_Producto(dprecio_minorista);
                productor.fSetexistencia_Producto(idexistencia);
                
                productos.add(productor);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return productos;
    }

    public int insert(clsProductos productor) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, productor.fGetproducto_Producto());
            stmt.setDouble(2, productor.fGetpreciomayorista_Producto());
            stmt.setDouble(3, productor.fGetpreciominorista_Producto());
            stmt.setInt(4, productor.fGetexistencia_Producto());


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

    public int update(clsProductos productor) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, productor.fGetproducto_Producto());
            stmt.setDouble(2, productor.fGetpreciomayorista_Producto());
            stmt.setDouble(3, productor.fGetpreciominorista_Producto());
            stmt.setInt(4, productor.fGetexistencia_Producto());

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

    public int delete(clsProductos productor) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, productor.fGetid_Producto());
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
    public clsProductos query(clsProductos productor) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<clsProductos> ventas = new ArrayList<clsProductos>();
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, productor.fGetproducto_Producto());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int iId_producto = rs.getInt("Id_producto");
                String sproducto= rs.getString("producto");
                double dprecio_mayorista= rs.getDouble("precio_mayorista");
                double dprecio_minorista= rs.getDouble("precio_minorista");
                int idexistencia= rs.getInt("existencia");

                productor = new clsProductos();
                productor.fSetid_Producto(iId_producto);
                productor.fSetproducto_Producto(sproducto);
                productor.fSetpreciomayorista_Producto(dprecio_mayorista);
                productor.fSetpreciominorista_Producto(dprecio_minorista);
                productor.fSetexistencia_Producto(idexistencia);
                
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
        return productor;
    }
   


public void update_total_value(String producto, int existencias) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " +  "UPDATE tbl_productos SET existencia=? WHERE producto = ?");
            stmt = conn.prepareStatement("UPDATE tbl_productos SET existencia="+existencias+" WHERE producto = '"+producto+"'");
            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

    }



}
