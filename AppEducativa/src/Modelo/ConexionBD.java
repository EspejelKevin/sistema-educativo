/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author kevin
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.Statement;
import java.sql.ResultSet;

public class ConexionBD {

    private final String bd = "dbcursos";
    private final String url = "jdbc:mysql://localhost:3306/" + bd;
    private Connection con = null;

    public Connection getConexion(String usr, String pass) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, usr, pass);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);

        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return con;
    }
    
    public Connection conexion;
    public Statement sentencia;
    public ResultSet resultado;
 
    public void crearBasedeDatos(String bd) {
        try {
            final String Controlador = "com.mysql.cj.jdbc.Driver";
            Class.forName(Controlador);
            final String url_bd = "jdbc:mysql://localhost:3306/";
            final String url_bd2 = "jdbc:mysql://localhost:3306/" + bd;
            if (bd.equals("")) {
                conexion = DriverManager.getConnection(url_bd, "root", "km05010002");
            } else {
                conexion = DriverManager.getConnection(url_bd2, "root", "km05010002");
            }
            sentencia = conexion.createStatement();
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Excepcion", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public Connection getConexionRegistrarUsuario() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, "root", "km05010002");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);

        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return con;
    }
}
