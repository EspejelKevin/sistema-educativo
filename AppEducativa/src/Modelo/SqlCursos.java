
package Modelo;

import Vista.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SqlCursos extends ConexionBD{

    public boolean crearCurso(Cursos curso, Login login) {
        PreparedStatement ps;

        String pass = new String(login.txtPass.getPassword());
        Connection con = getConexion(login.txtUser.getText(), pass);

        String sql_query = "INSERT INTO cursos(codigo, nombre, profesores_rfc) "
                + "VALUES(?, ?, ?);";

        try {
            ps = con.prepareStatement(sql_query);
            ps.setInt(1, curso.getCodigoCurso());
            ps.setString(2, curso.getNombreCurso());
            ps.setString(3, curso.getRfcProfesorCurso());
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
    
    public boolean actualizarCurso(Cursos curso, Login login) {
        PreparedStatement ps;

        String pass = new String(login.txtPass.getPassword());
        Connection con = getConexion(login.txtUser.getText(), pass);

        String sql_query = "UPDATE cursos SET codigo = ?, nombre = ? "
                + "WHERE codigo = ?;";

        try {
            ps = con.prepareStatement(sql_query);
            ps.setInt(1, curso.getCodigoCurso());
            ps.setString(2, curso.getNombreCurso());
            ps.setInt(3, curso.getCodigoCurso());
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
    
    public boolean eliminarCurso(Cursos curso, Login login) {
        PreparedStatement ps;

        String pass = new String(login.txtPass.getPassword());
        Connection con = getConexion(login.txtUser.getText(), pass);

        String sql_query = "DELETE FROM cursos WHERE codigo = ?";

        try {
            ps = con.prepareStatement(sql_query);
            ps.setInt(1, curso.getCodigoCurso());
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
    
    public boolean buscarCurso(Cursos curso, Login login) {
        PreparedStatement ps;
        ResultSet rs;
        
        String pass = new String(login.txtPass.getPassword());
        Connection con = getConexion(login.txtUser.getText(), pass);

        String sql_query = "SELECT * FROM cursos WHERE codigo = ?";

        try {
            ps = con.prepareStatement(sql_query);
            ps.setInt(1, curso.getCodigoCurso());
            rs = ps.executeQuery();
            
            if(rs.next()){
                curso.setCodigoCurso((rs.getInt("codigo")));
                curso.setNombreCurso(rs.getString("nombre"));
                curso.setRfcProfesorCurso(rs.getString("profesores_rfc"));
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
