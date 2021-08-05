package Modelo;

import Vista.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SqlProfesores extends ConexionBD {
    
    public boolean crearProfesor(Profesores profe, Login login) {
        PreparedStatement ps;

        String pass = new String(login.txtPass.getPassword());
        Connection con = getConexion(login.txtUser.getText(), pass);

        String sql_query = "INSERT INTO profesores(rfc, nombre, direccion, telefono, foto) "
                + "VALUES(?, ?, ?, ?, ?);";

        try {
            ps = con.prepareStatement(sql_query);
            ps.setString(1, profe.getRFC());
            ps.setString(2, profe.getNombre());
            ps.setString(3, profe.getDireccion());
            ps.setInt(4, profe.getTelefono());
            ps.setBytes(5, profe.getFotoProfesor());
            ps.execute();

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(SqlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            return false;

        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(SqlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public boolean actualizarProfesor(Profesores profe, Login login) {
        PreparedStatement ps;

        String pass = new String(login.txtPass.getPassword());
        Connection con = getConexion(login.txtUser.getText(), pass);

        String sql_query = "UPDATE profesores SET nombre = ?, direccion = ?, "
                + "telefono = ?, foto = ? WHERE rfc = ?;";

        try {
            ps = con.prepareStatement(sql_query);
            ps.setString(1, profe.getNombre());
            ps.setString(2, profe.getDireccion());
            ps.setInt(3, profe.getTelefono());
            ps.setBytes(4, profe.getFotoProfesor());
            ps.setString(5, profe.getRFC());
            ps.execute();
            
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(SqlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            return false;

        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(SqlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public boolean eliminarProfesor(Profesores profe, Login login) {
        PreparedStatement ps;

        String pass = new String(login.txtPass.getPassword());
        Connection con = getConexion(login.txtUser.getText(), pass);

        String sql_query = "DELETE FROM profesores WHERE rfc = ?";

        try {
            ps = con.prepareStatement(sql_query);
            ps.setString(1, profe.getRFC());
            ps.execute();
            
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(SqlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            return false;

        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(SqlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public boolean buscarProfesor(Profesores profe, Login login) {
        PreparedStatement ps;
        ResultSet rs;
        
        String pass = new String(login.txtPass.getPassword());
        Connection con = getConexion(login.txtUser.getText(), pass);

        String sql_query = "SELECT * FROM profesores WHERE rfc = ?";

        try {
            ps = con.prepareStatement(sql_query);
            ps.setString(1, profe.getRFC());
            rs = ps.executeQuery();
            
            if(rs.next()){
                profe.setRFC((rs.getString("rfc")));
                profe.setNombre(rs.getString("nombre"));
                profe.setDireccion(rs.getString("direccion"));
                profe.setTelefono(rs.getInt("telefono"));
                profe.setFotoProfesor(rs.getBytes("foto"));
                return true;
            }
            
            return false;

        } catch (SQLException ex) {
            Logger.getLogger(SqlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            return false;

        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(SqlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
