/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.modelo;

import rrhh.controlador.clsdepartamento;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daodepartamento {

    private static final String SQL_SELECT = "SELECT codigo_departamento, nombre_departamento, estatus_departamento FROM departamento";
    private static final String SQL_INSERT = "INSERT INTO departamento(nombre_departamento,estatus_departamento) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE departemento SET nombre_departamento=?, estatus_departamento=? WHERE codigo_departamento = ?";
    private static final String SQL_DELETE = "DELETE FROM departamento WHERE odigo_departamento=?";
    private static final String SQL_QUERY = "SELECT  codigo_departamento, nombre_departamento, estatus_departamento FROM departamento WHERE nombre_departamento = ?";

    public List<clsdepartamento> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsdepartamento usuario = null;
        List<clsdepartamento> usuarios = new ArrayList<clsdepartamento>();
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigo = rs.getInt("codigo_departamento");
                String nombre = rs.getString("nombre_departamento");
                String estatus = rs.getString("estatus_departamento");

                usuario = new clsdepartamento();
                usuario.setcodigo_departamento(codigo);
                usuario.setnombre_departamento(nombre);
                usuario.setestatus_departamento(estatus);

                usuarios.add(usuario);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return usuarios;
    }

    public int insert(clsdepartamento perfil) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, perfil.getnombre_departamento());
            stmt.setString(2, perfil.getestatus_departamento());

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

    public int update(clsdepartamento perfil) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
             
            stmt.setString(2, perfil.getnombre_departamento());
            stmt.setString(3, perfil.getestatus_departamento());
            
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

    public int delete(clsdepartamento perfil) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, perfil.getcodigo_departamento());
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

    public clsdepartamento query(clsdepartamento perfil) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, perfil.getnombre_departamento());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigo = rs.getInt("codigo_departamento");
                String nombre = rs.getString("nombre_departamento");
                String estatus = rs.getString("estatus_departamento");

                perfil = new clsdepartamento();
                perfil.setcodigo_departamento(codigo);
                perfil.setnombre_departamento(nombre);
                perfil.setestatus_departamento(estatus);
                
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return perfil;
    }
}
