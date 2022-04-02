/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seguridad.modelo;

import seguridad.controlador.clsPerfilUsuario;
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
public class daoPerfilUsuario {

    private static final String SQL_SELECT = "SELECT perid,usuid FROM tbl_perfilusuario";
    private static final String SQL_INSERT = "INSERT INTO tbl_perfilusuario(perid, usuid) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_perfilusuario SET perid=?, usuid=? WHERE perid = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_perfilusuario WHERE perid=?";
    private static final String SQL_QUERY = "SELECT perid, usuid FROM tbl_perfilusuario WHERE tbl_perfilusuario = ?";

    public List<clsPerfilUsuario> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsPerfilUsuario perfilusuario = null;
        List<clsPerfilUsuario>  perfilusuarios = new ArrayList<clsPerfilUsuario>();
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                
                int perfil = rs.getInt("perid");
                int usuario = rs.getInt("usuid");
                

                perfilusuario= new clsPerfilUsuario();
                perfilusuario.setperfil(perfil);
                perfilusuario.setusuario(usuario);
                
                perfilusuarios.add(perfilusuario);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return perfilusuarios;
    }

    public int insert(clsPerfilUsuario perfilusuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, perfilusuario.getperfil());
            stmt.setInt(2, perfilusuario.getusuario());

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

    public int update(clsPerfilUsuario perfilusuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, perfilusuario.getperfil());
            stmt.setInt(2, perfilusuario.getusuario());
            

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

    public int delete(clsPerfilUsuario perfilusuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
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

    public clsPerfilUsuario query(clsPerfilUsuario perfilusuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, perfilusuario.getperfil());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int perfil = rs.getInt("perid");
                int usuario = rs.getInt("usuid");

                perfilusuario = new clsPerfilUsuario();
                perfilusuario.setperfil(perfil);
                perfilusuario.setusuario(usuario);
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
        return perfilusuario;
    }
}
