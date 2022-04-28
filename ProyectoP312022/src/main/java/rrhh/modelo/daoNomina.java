/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.modelo;


import rrhh.controlador.clsNominas;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoNomina {

    private static final String SQL_SELECT = "SELECT nomid, nomnombre, nomcargo, nombredepartamento, nompercepciones, nomdeducciones, nomdiaslaborados FROM tbl_nomina";
    private static final String SQL_INSERT = "INSERT INTO tbl_nomina(nomnombre, nombrecargo, nombredepartamento, nompercepciones, nomdeducciones, nomdiaslaborados) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_nomina SET nomnombre=?, nomcargo=?, nombredepartamento=?, nompercepciones=?, nomdeducciones=?, nomdiaslaborados =? WHERE nomid = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_nomina WHERE nomid=?";
    private static final String SQL_QUERY = "SELECT nomid, nomnombre, nomcargo,  nombredepartamento, nompercepciones, nomdeducciones, nomdiaslaborados FROM tbl_nomina WHERE nomid=?";
    private static final String SQL_QUERYN = "SELECT nomid, nomnombre, nomcargo, nombredepartamento, nompercepciones, nomdeducciones, nomdiaslaborados FROM tbl_nomina WHERE nomnombre=?";    

    public List<clsNominas> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsNominas usuario = null;
        List<clsNominas> usuarios = new ArrayList<clsNominas>();
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int Nomid = rs.getInt("nomid");
                String Nomnombre = rs.getString("nomnombre");
                String Nomcargo = rs.getString("momcargo");
                String Nomdepartamento = rs.getString("nomdepartamento");
                String Nompercepciones = rs.getString("nompercepciones");
                String Nomdeducciones = rs.getString("nomdeducciones");
                String Nomdiaslaborados = rs.getString("nomdiaslaborados");
                

                usuario = new clsNominas();
                usuario.setnomid(Nomid);
                usuario.setnomnombre(Nomnombre);
                usuario.setnomcargo(Nomcargo);
                usuario.setnomdepartamento(Nomdepartamento);
                usuario.setnompercepciones(Nompercepciones);
                usuario.setnomdeducciones(Nomdeducciones);
                usuario.setnomdiaslaborados(Nomdiaslaborados);
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

    public int insert(clsNominas usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, usuario.getnomnombre());
            stmt.setString(2, usuario.getnomcargo());
            stmt.setString(3, usuario.getnomdepartamento());
            stmt.setString(4, usuario.getnompercepciones());
            stmt.setString(5, usuario.getnomdeducciones());            
            stmt.setString(6, usuario.getnomdiaslaborados());
                      

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

    public int update(clsNominas usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, usuario.getnomnombre());
            stmt.setString(2, usuario.getnomcargo());
            stmt.setString(3, usuario.getnomdepartamento());
            stmt.setString(4, usuario.getnompercepciones());
            stmt.setString(5, usuario.getnomdeducciones());            
            stmt.setString(6, usuario.getnomdiaslaborados());
                        
            stmt.setInt(9, usuario.getnomid());

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

    public int delete(clsNominas usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, usuario.getnomid());
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

    public clsNominas query(clsNominas usuario) 
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, usuario.getnomid());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int Nomid = rs.getInt("nomid");
                String nomnombre = rs.getString("nomnombre");
                String nomcargo = rs.getString("momcargo");
                String nomdepartamento = rs.getString("nomdepartamento");
                String nompercepciones = rs.getString("nompercepciones");
                String nomdeducciones = rs.getString("nomdeducciones");
                String nomdiaslaboradose = rs.getString("nomdiaslaboradose");
                

                usuario = new clsNominas();
                usuario.setnomid(Nomid);
                usuario.setnomnombre(nomnombre);
                usuario.setnomcargo(nomcargo);
                usuario.setnomdepartamento(nomdepartamento);
                usuario.setnompercepciones(nompercepciones);
                usuario.setnomdeducciones(nomdeducciones);
                usuario.setnomdiaslaboradose(nomdiaslaboradose);
                
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
        return usuario;
    }
public clsNominas queryn(clsNominas usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERYN);
            stmt.setString(1, usuario.getnomnombre());
            rs = stmt.executeQuery();
            while (rs.next()) {
                
                int Nomid = rs.getInt("nomid");
                String nomnombre = rs.getString("nomnombre");
                String nomcargo = rs.getString("momcargo");
                String nomdepartamento = rs.getString("nomdepartamento");
                String nompercepciones = rs.getString("nompercepciones");
                String nomdeducciones = rs.getString("nomdeducciones");
                String nomdiaslaboradose = rs.getString("nomdiaslaboradose");
                
                usuario = new clsNominas();
                usuario.setnomid(Nomid);
                usuario.setnomnombre(nomnombre);
                usuario.setnomcargo(nomcargo);
                usuario.setnomdepartamento(nomdepartamento);
                usuario.setnompercepciones(nompercepciones);
                usuario.setnomdeducciones(nomdeducciones);
                usuario.setnomdiaslaboradose(nomdiaslaboradose);
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
        return usuario;
    }
    
}
