/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.modelo;

import rrhh.controlador.clsNomina;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoNomina {

    private static final String SQL_SELECT = "SELECT nomiid, nominombre, nomicargo, nomidepart, nomisalario, nomiconcepto, nomivalor  FROM tbl_nomina";
    private static final String SQL_INSERT = "INSERT INTO tbl_nomina(nominombre, nomicargo, nomidepart, nomisalario, nomiconcepto, nomivalor) VALUES(?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_nomina SET nominombre=?, nomicargo=?, nomidepart=?, nomisalario=?, nomiconcepto=?, nomivalor=? WHERE nomiid = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_nomina WHERE nomiid=?";
    private static final String SQL_QUERY = "SELECT nomiid, nominombre, nomicargo, nomidepart, nomisalario, nomiconcepto, nomivalor FROM tbl_nomina WHERE nomiid=?";
  

    public List<clsNomina> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsNomina nomina = null;
        List<clsNomina> nominas = new ArrayList<clsNomina>();
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("nomiid");
                String nombre = rs.getString("nominombre");
                String cargo = rs.getString("nomicargo");
                String depart = rs.getString("nomidepart");
                String salario = rs.getString("nomisalario");
                String concepto = rs.getString("nomiconcepto");
                String valor = rs.getString("nomivalor");

                nomina = new clsNomina();
                nomina.setnomiid(id);
                nomina.setnominombre(nombre);
                nomina.setnomicargo(cargo);
                nomina.setnomidepart(depart);
                nomina.setnomisalario(salario);
                nomina.setnomiconcepto(concepto);
                nomina.setnomivalor(valor);
                
                nominas.add(nomina);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return nominas;
    }

    public int insert(clsNomina nomina) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, nomina.getnominombre());
            stmt.setString(2, nomina.getnomicargo());
            stmt.setString(3, nomina.getnomidepart());
            stmt.setString(4, nomina.getnomisalario());
            stmt.setString(5, nomina.getnomiconcepto());
            stmt.setString(6, nomina.getnomivalor());
            
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

    public int update(clsNomina nomina) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, nomina.getnominombre());
            stmt.setString(2, nomina.getnomicargo());
            stmt.setString(3, nomina.getnomidepart());
            stmt.setString(4, nomina.getnomisalario());
            stmt.setString(5, nomina.getnomiconcepto());
            stmt.setString(6, nomina.getnomivalor());
            stmt.setInt(7, nomina.getnomiid());

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

    public int delete(clsNomina nomina) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, nomina.getnomiid());
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

    public clsNomina query(clsNomina nomina) 
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, nomina.getnomiid());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("nomiid");
                String nombre = rs.getString("nominombre");
                String cargo = rs.getString("nomicargo");
                String depart = rs.getString("nomidepart");
                String salario = rs.getString("nomisalario");
                String concepto = rs.getString("nomiconcepto");
                String valor = rs.getString("nomivalor");

                nomina = new clsNomina();
                nomina.setnomiid(id);
                nomina.setnominombre(nombre);
                nomina.setnomicargo(cargo);
                nomina.setnomidepart(depart);
                nomina.setnomisalario(salario);   
                nomina.setnomiconcepto(concepto);
                nomina.setnomivalor(valor);  
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
        return nomina;
    }
}
