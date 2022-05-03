/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compras.modelo;

import compras.vista.frmMantenimientoProveedor;
import compras.controlador.clsProveedor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import seguridad.modelo.clsConexion;

/**
 *
 * @author visitante
 */
public class daoProveedor {

    private static final String SQL_SELECT2 = "SELECT provid, provnombre, provsaldo, provestado, provtelefono, provdireccion FROM tbl_proveedor";
    private static final String SQL_INSERT = "INSERT INTO tbl_proveedor(provnombre,provsaldo,provestado,provtelefono,provdireccion) VALUES(?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE tbl_proveedor SET provnombre = ?, provsaldo = ?, provestado = ?, provtelefono = ?, provdireccion = ? WHERE tbl_proveedor.provid = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_proveedor WHERE tbl_proveedor.provid = ?";
    private static final String SQL_QUERY = "SELECT provid, provnombre, provsaldo, provestado, provtelefono, provdireccion FROM tbl_proveedor WHERE provid = ?";

    public List<clsProveedor> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsProveedor usuario = null;
        List<clsProveedor> usuarios = new ArrayList<clsProveedor>();
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT2);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int provid = rs.getInt("provid");
                String provnombre = rs.getString("provnombre");
                int provsaldo = rs.getInt("provsaldo");
                String provestado = rs.getString("provestado");
                int provtelefono = rs.getInt("provtelefono");
                String provdireccion = rs.getString("provdireccion");


                usuario = new clsProveedor();
                usuario.setprovid(provid);
                usuario.setprovnombre(provnombre);
                usuario.setprovsaldo(provsaldo);
                usuario.setprovestado(provestado);
                usuario.setprovtelefono(provtelefono);
                usuario.setprovtdireccion(provdireccion);

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

    public int insert(clsProveedor proveedor) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, proveedor.getprovnombre());
            stmt.setInt(2, proveedor.getprovsaldo());
            stmt.setString(3, proveedor.getprovestado());
            stmt.setInt(4, proveedor.getprovtelefono());
            stmt.setString(5, proveedor.getprovtdireccion());

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

    public int update(clsProveedor proveedor) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, proveedor.getprovnombre());
            stmt.setInt(2, proveedor.getprovsaldo());
            stmt.setString(3, proveedor.getprovestado());
            stmt.setInt(4, proveedor.getprovtelefono());
            stmt.setString(5, proveedor.getprovtdireccion());
            stmt.setInt(6, proveedor.getprovid());



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

    public int delete(clsProveedor perfil) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, perfil.getprovid());
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

    public clsProveedor query(clsProveedor proveedor) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, proveedor.getprovid());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int provid = rs.getInt("provid");
                String provnombre = rs.getString("provnombre");
                int provsaldo = rs.getInt("provsaldo");
                String provestado = rs.getString("provestado");
                int provtelefono = rs.getInt("provtelefono");
                String provdireccion = rs.getString("provdireccion");

                proveedor = new clsProveedor();
                proveedor.setprovid(provid);
                proveedor.setprovnombre(provnombre);
                proveedor.setprovsaldo(provsaldo);
                proveedor.setprovestado(provestado);
                proveedor.setprovtelefono(provtelefono);
                proveedor.setprovtdireccion(provdireccion);
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
        return proveedor;
    }
}
