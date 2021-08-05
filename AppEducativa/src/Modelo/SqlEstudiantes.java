
package Modelo;

import Vista.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SqlEstudiantes extends ConexionBD{
    
    public boolean crearEstudiante(Estudiantes estudiante, Login login) {
        PreparedStatement ps;

        String pass = new String(login.txtPass.getPassword());
        Connection con = getConexion(login.txtUser.getText(), pass);

        String sql_query = "INSERT INTO alumnos(matricula, nombre, apellidos, email, foto) "
                + "VALUES(?, ?, ?, ?, ?);";

        try {
            ps = con.prepareStatement(sql_query);
            ps.setInt(1, estudiante.getMatricula());
            ps.setString(2, estudiante.getNombre());
            ps.setString(3, estudiante.getApellidos());
            ps.setString(4, estudiante.getEmail());
            ps.setBytes(5, estudiante.getFoto());
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
    
    public boolean actualizarEstudiante(Estudiantes estudiante, Login login) {
        PreparedStatement ps;

        String pass = new String(login.txtPass.getPassword());
        Connection con = getConexion(login.txtUser.getText(), pass);

        String sql_query = "UPDATE alumnos SET nombre = ?, apellidos = ?, "
                + "email = ?, foto = ? WHERE matricula = ?;";

        try {
            ps = con.prepareStatement(sql_query);
            ps.setString(1, estudiante.getNombre());
            ps.setString(2, estudiante.getApellidos());
            ps.setString(3, estudiante.getEmail());
            ps.setBytes(4, estudiante.getFoto());
            ps.setInt(5, estudiante.getMatricula());
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
    
    public boolean eliminarEstudiante(Estudiantes estudiante, Login login) {
        PreparedStatement ps;

        String pass = new String(login.txtPass.getPassword());
        Connection con = getConexion(login.txtUser.getText(), pass);

        String sql_query = "DELETE FROM alumnos WHERE matricula = ?";

        try {
            ps = con.prepareStatement(sql_query);
            ps.setInt(1, estudiante.getMatricula());
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
    
    public boolean buscarEstudiante(Estudiantes estudiante, Login login) {
        PreparedStatement ps;
        ResultSet rs;
        
        String pass = new String(login.txtPass.getPassword());
        Connection con = getConexion(login.txtUser.getText(), pass);

        String sql_query = "SELECT * FROM alumnos WHERE matricula = ?";

        try {
            ps = con.prepareStatement(sql_query);
            ps.setInt(1, estudiante.getMatricula());
            rs = ps.executeQuery();
            
            if(rs.next()){
                estudiante.setMatricula((rs.getInt("matricula")));
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setApellidos(rs.getString("apellidos"));
                estudiante.setEmail(rs.getString("email"));
                estudiante.setFoto(rs.getBytes("foto"));
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
