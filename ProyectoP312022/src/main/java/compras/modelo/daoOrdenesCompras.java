/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compras.modelo;

import compras.controlador.clsOrdenesCompras;
import compras.modelo.*;
import seguridad.modelo.*;
import compras.controlador.clsProducto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoOrdenesCompras {

    private static final String SQL_SELECT = "SELECT ordid, ordfecha, provid FROM tbl_ordecompraencabezado";
    private static final String SQL_SELECT2 = "SELECT prodid, ordcantidad, ordcosto FROM tbl_ordecompradetalle";

    private static final String SQL_INSERT = "INSERT INTO tbl_ordecompraencabezado(ordfecha, provid) VALUES ( ?,?)";
    private static final String SQL_INSERT2 = "INSERT INTO tbl_ordecompradetalle(prodid, ordcantidad, ordcosto) VALUES ( ?,?,?)";

    private static final String SQL_UPDATE = "UPDATE tbl_producto SET provid = ?,prodnombre = ?,prodmarca = ?, prodprecio = ?, Prodlinea = ?, prodexistencia = ? WHERE tbl_producto.prodid = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_producto WHERE tbl_producto.prodid = ?";
    private static final String SQL_QUERY = "SELECT prodid, provid, prodnombre,prodmarca,prodprecio,prodlinea,prodexistencia FROM tbl_producto WHERE tbl_producto.prodid = ?";

    public List<clsOrdenesCompras> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsOrdenesCompras ordenes = null;
        List<clsOrdenesCompras> orden = new ArrayList<clsOrdenesCompras>();
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int ordid = rs.getInt("ordid");
                String ordfecha = rs.getString("ordfecha");
                int provid = rs.getInt("provid");


                ordenes = new clsOrdenesCompras();
                ordenes.setordid(ordid);
                ordenes.setordfecha(ordfecha);
                ordenes.setprovid(provid);


                orden.add(ordenes);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return orden;
    }
    public List<clsOrdenesCompras> select2() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsOrdenesCompras ordenes = null;
        List<clsOrdenesCompras> orden = new ArrayList<clsOrdenesCompras>();
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT2);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int prodid = rs.getInt("prodid");
                int ordcantidad = rs.getInt("ordcantidad");
                int ordcosto = rs.getInt("ordcosto");


                ordenes = new clsOrdenesCompras();
                ordenes.setprodid(prodid);
                ordenes.setordcantidad(ordcantidad);
                ordenes.setordcosto(ordcosto);


                orden.add(ordenes);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return orden;
    }

    public int insert(clsOrdenesCompras ordenes) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);

         
            stmt.setString(1, ordenes.getordfecha());
            stmt.setInt(2, ordenes.getprovid());
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

    public int insert2(clsOrdenesCompras ordenes) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT2);
            stmt.setInt(1, ordenes.getprodid());
            stmt.setInt(2, ordenes.getordcantidad());
            stmt.setInt(3, ordenes.getordcosto());
            System.out.println("ejecutando query:" + SQL_INSERT2);
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

    public int update(clsProducto producto) {
       Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, producto.getProvid());
            stmt.setString(2, producto.getProdnombre());
            stmt.setString(3, producto.getProdmarca());
            stmt.setInt(4, producto.getProdprecio());
            stmt.setString(5, producto.getProdlinea());
            stmt.setString(6, producto.getProdexistencia());                      
            stmt.setInt(7, producto.getProdid());
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

    public int delete(clsProducto producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, producto.getProdid());
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

    public clsProducto query(clsProducto producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, producto.getProdid());
             
            rs = stmt.executeQuery();
            while (rs.next()) {
                int provid = rs.getInt("provid");
                String prodnombre = rs.getString("prodnombre");
                String prodmarca = rs.getString("prodmarca");
                int prodprecio = rs.getInt("prodprecio");
                String prodlinea = rs.getString("prodlinea");
                String prodexistencia = rs.getString("prodexistencia");

                producto = new clsProducto();
                producto.setProvid(provid);
                producto.setProdnombre(prodnombre);
                producto.setProdmarca(prodmarca);
                producto.setProdprecio(prodprecio);
                producto.setProdlinea(prodlinea);
                producto.setProdexistencia(prodexistencia);
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
        return producto;
    }
}
