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
import ventas.controlador.clsCuentas_por_cobrar;

/**
 *
 * @author visitante
 */
public class daoCuentas_por_cobrar {

    private static final String SQL_SELECT = "SELECT Id_cobrador, tipo_pago, id_cobrador, id_cliente, saldo FROM tbl_cuentas_por_cobrar";
    private static final String SQL_INSERT = "INSERT INTO tbl_cuentas_por_cobrar(tipo_pago, id_cobrador, id_cliente, saldo) VALUES(?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_cuentas_por_cobrar SET tipo_pago=?, id_cobrador=?, id_cliente=? AND saldo=? WHERE id_cobro = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_cuentas_por_cobrar WHERE id_cobro=?";
    private static final String SQL_QUERY = "SELECT Id_cobrador, tipo_pago, id_cobrador, id_cliente, saldo FROM tbl_cuentas_por_cobrar WHERE id_cobro= ?";


    public List<clsCuentas_por_cobrar> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsCuentas_por_cobrar cobrador = null;
        List<clsCuentas_por_cobrar> cobradores = new ArrayList<clsCuentas_por_cobrar>();

        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int Id_cobrador = rs.getInt("Id_cobrador");
                String tipo_pago = rs.getString("tipo_pago");
                int id_cobrador = rs.getInt("id_cobrador");
                int id_cliente = rs.getInt("id_cliente");
                double saldo = rs.getDouble("saldo");
           

                cobrador = new clsCuentas_por_cobrar();
                cobrador.setId_cobro(Id_cobrador);
                cobrador.setTipo_pago(tipo_pago);
                cobrador.setId_cobrador(id_cobrador);
                cobrador.setId_cliente(id_cliente);
                cobrador.setSaldo(saldo);
                
                cobradores.add(cobrador);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return cobradores;
    }

    public int insert(clsCuentas_por_cobrar cobrador) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, cobrador.getTipo_pago());
            stmt.setInt(2, cobrador.getId_cobrador());
            stmt.setInt(3, cobrador.getId_cliente());
            stmt.setDouble(4, cobrador.getSaldo());


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

    public int update(clsCuentas_por_cobrar cobrador) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, cobrador.getTipo_pago());
            stmt.setInt(2, cobrador.getId_cobrador());
            stmt.setInt(3, cobrador.getId_cliente());
            stmt.setDouble(4, cobrador.getSaldo());

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

    public int delete(clsCuentas_por_cobrar cobrador) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, cobrador.getId_cobro());
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
    public clsCuentas_por_cobrar query(clsCuentas_por_cobrar cobrador) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<clsCuentas_por_cobrar> cobradores = new ArrayList<clsCuentas_por_cobrar>();
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, cobrador.getId_cobrador());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int Id_cobrador = rs.getInt("Id_cobrador");
                String tipo_pago = rs.getString("tipo_pago");
                int id_cobrador = rs.getInt("id_cobrador");
                int id_cliente = rs.getInt("id_cliente");
                double saldo = rs.getDouble("saldo");
           

                cobrador = new clsCuentas_por_cobrar();
                cobrador.setId_cobro(Id_cobrador);
                cobrador.setTipo_pago(tipo_pago);
                cobrador.setId_cobrador(id_cobrador);
                cobrador.setId_cliente(id_cliente);
                cobrador.setSaldo(saldo);
                
                //cobradores.add(cobrador); // Si se utiliza un ArrayList
            }
            //System.out.println("Registros buscado:" + cobrador);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        //return cobradores;  // Si se utiliza un ArrayList
        return cobrador;
    }
   
}
