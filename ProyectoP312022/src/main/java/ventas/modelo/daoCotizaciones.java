/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas.modelo;

import seguridad.vista.*;
import ventas.controlador.clsCotizaciones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import seguridad.modelo.clsConexion;


/**
 *
 * @author visitante
 */
public class daoCotizaciones {

    private static final String SQL_SELECT = "SELECT Id_cotizacion, tipo, cantidad, producto, precio, total, fecha, id_cliente, id_vendedor FROM tbl_cotizaciones";
    private static final String SQL_INSERT = "INSERT INTO tbl_cotizaciones(tipo, cantidad, producto, precio, total, fecha, id_cliente, id_vendedor) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_cotizaciones SET tipo=?, cantidad=?, producto=?, precio=?, total=?, fecha=?, id_cliente=? AND id_vendedor=? WHERE Id_cotizacion = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_cotizaciones WHERE Id_cotizacion=?";
    private static final String SQL_QUERY = "SELECT id_venta, tipo, cantidad, producto, precio, total, fecha, id_cliente, id_vendedor FROM tbl_cotizaciones WHERE Id_cotizacion = ?";


    public List<clsCotizaciones> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsCotizaciones cotizacion = null;
        List<clsCotizaciones> cotizaciones = new ArrayList<clsCotizaciones>();

        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int iId_Cotizacion = rs.getInt("Id_cotizacion");
                String sTipo = rs.getString("tipo");
                int iCantidad = rs.getInt("cantidad");
                String sProducto = rs.getString("producto");
                double dPrecio = rs.getDouble("precio");
                double dTotal = rs.getDouble("total");
                String Sfecha = rs.getString("fecha");
                int iId_cliente = rs.getInt("id_cliente");
                int iId_vendedor = rs.getInt("id_vendedor");

                cotizacion = new clsCotizaciones();
                cotizacion.fSetid_Cotizacion(iId_Cotizacion);
                cotizacion.fSetTipo_Cotizacion(sTipo);
                cotizacion.fSetCantidad_Cotizacion(iCantidad);
                cotizacion.fSetProducto_Cotizacion(sProducto);
                cotizacion.fSetPrecio_Cotizacion(dPrecio);
                cotizacion.fSetTotal_Cotizacion(dTotal);
                cotizacion.fSetFecha_Cotizacion(Sfecha);
                cotizacion.fSetId_Cliente(iId_cliente);
                cotizacion.fSetid_Vendedor(iId_vendedor);
                
                cotizaciones.add(cotizacion);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return cotizaciones;
    }

    public int insert(clsCotizaciones cotizacion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, cotizacion.fGetTipo_Cotizacion());
            stmt.setInt(2, cotizacion.fGetCantidad_Cotizacion());
            stmt.setString(3, cotizacion.fGetProducto_Cotizacion());
            stmt.setDouble(4, cotizacion.fGetPrecio_Cotizacion());
            stmt.setDouble(5, cotizacion.fGetTotal_Cotizacion());
            stmt.setString(6, cotizacion.fGetFecha_Cotizacion());
            stmt.setInt(7, cotizacion.fGetId_Cliente());
            stmt.setInt(8, cotizacion.fGetId_Vendedor());


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

    public int update(clsCotizaciones cotizacion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, cotizacion.fGetTipo_Cotizacion());
            stmt.setInt(2, cotizacion.fGetCantidad_Cotizacion());
            stmt.setString(3, cotizacion.fGetProducto_Cotizacion());
            stmt.setDouble(4, cotizacion.fGetPrecio_Cotizacion());
            stmt.setDouble(5, cotizacion.fGetTotal_Cotizacion());
            stmt.setString(6, cotizacion.fGetFecha_Cotizacion());
            stmt.setInt(7, cotizacion.fGetId_Cliente());
            stmt.setInt(8, cotizacion.fGetId_Vendedor());

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

    public int delete(clsCotizaciones cotizacion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, cotizacion.fGetid_Cotizacion());
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
    public clsCotizaciones query(clsCotizaciones cotizacion) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<clsCotizaciones> cotizaciones = new ArrayList<clsCotizaciones>();
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, cotizacion.fGetid_Cotizacion());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int iId_Cotizacion = rs.getInt("Id_cotizacion");
                String sTipo = rs.getString("tipo");
                int iCantidad = rs.getInt("cantidad");
                String sProducto = rs.getString("producto");
                double dPrecio = rs.getDouble("precio");
                double dTotal = rs.getDouble("total");
                String Sfecha = rs.getString("fecha");
                int iId_cliente = rs.getInt("id_cliente");
                int iId_vendedor = rs.getInt("id_vendedor");

                cotizacion = new clsCotizaciones();
                cotizacion.fSetid_Cotizacion(iId_Cotizacion);
                cotizacion.fSetTipo_Cotizacion(sTipo);
                cotizacion.fSetCantidad_Cotizacion(iCantidad);
                cotizacion.fSetProducto_Cotizacion(sProducto);
                cotizacion.fSetPrecio_Cotizacion(dPrecio);
                cotizacion.fSetTotal_Cotizacion(dTotal);
                cotizacion.fSetFecha_Cotizacion(Sfecha);
                cotizacion.fSetId_Cliente(iId_cliente);
                cotizacion.fSetid_Vendedor(iId_vendedor);
                
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
        return cotizacion;
    }



}
