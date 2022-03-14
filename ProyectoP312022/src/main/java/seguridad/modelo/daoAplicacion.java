/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguridad.modelo;

import seguridad.controlador.clsAplicacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoAplicacion {

    private static final String SQL_SELECT = "SELECT id_aplicacion, nombre_aplicacion, estatus_aplicacion FROM Aplicacion";
    private static final String SQL_INSERT = "INSERT INTO Aplicacion(nombre_aplicacion, estatus_aplicacion) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE Aplicacion SET nombre_aplicacion=?,estatus_aplicacion=? WHERE id_aplicacion = ?";
    private static final String SQL_DELETE = "DELETE FROM Aplicacion WHERE id_aplicacion=?";
    private static final String SQL_QUERY = "SELECT id_aplicacion, nombre_aplicacion, estatus_aplicacion FROM Aplicacion WHERE id_aplicacion = ?";

    public List<clsAplicacion> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsAplicacion Aplicacion= null;
        List<clsAplicacion> aplicaciones = new ArrayList<clsAplicacion>();

        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_aplicacion = rs.getInt("id_aplicacion");
                String nombre = rs.getString("nombre_aplicacion");
                String estado = rs.getString("estatus_aplicacion");
                
                Aplicacion = new clsAplicacion();
                Aplicacion.setId_aplicacion(id_aplicacion);
                Aplicacion.setNombre_aplicacion(nombre);
                Aplicacion.setEstatus_aplicacion(estado);
                
                aplicaciones.add(Aplicacion);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return aplicaciones;
    }

    public int insert(clsAplicacion aplicacion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, aplicacion.getNombre_aplicaion());
            stmt.setString(2, aplicacion.getEstatus_aplicacion());


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

    public int update(clsAplicacion aplicacion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, aplicacion.getNombre_aplicaion());
            stmt.setString(2, aplicacion.getEstatus_aplicacion());
            stmt.setInt(3, aplicacion.getId_aplicacion());

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

    public int delete(clsAplicacion aplicacion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, aplicacion.getId_aplicacion());
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
    public clsAplicacion query(clsAplicacion aplicacion) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<clsAplicacion> aplicaciones = new ArrayList<clsAplicacion>();
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, aplicacion.getId_aplicacion());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_aplicacion = rs.getInt("id_aplicacion");
                String nombre = rs.getString("nombreAplicacion");
                String estado = rs.getString("estadoAplicacion");
                
                aplicacion = new clsAplicacion();
                aplicacion.setId_aplicacion(id_aplicacion);
                aplicacion.setNombre_aplicacion(nombre);
                aplicacion.setEstatus_aplicacion(estado);
                
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
        return aplicacion;
    }
        
}
