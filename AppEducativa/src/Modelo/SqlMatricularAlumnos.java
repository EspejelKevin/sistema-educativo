
package Modelo;

import Vista.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SqlMatricularAlumnos extends ConexionBD{
    
    public boolean crearAlumnoMatriculado(MatricularAlumnos matricularAlumnos, Login login) {
        PreparedStatement ps;

        String pass = new String(login.txtPass.getPassword());
        Connection con = getConexion(login.txtUser.getText(), pass);

        String sql_query = "INSERT INTO cursos_alumnos(cursos_codigo, alumnos_matricula) "
                + "VALUES(?, ?);";

        try {
            ps = con.prepareStatement(sql_query);
            ps.setInt(1, matricularAlumnos.getCursos_codigo());
            ps.setInt(2, matricularAlumnos.getAlumnos_matricula());
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
    
    public boolean eliminarCurso(MatricularAlumnos matricularAlumnos, Login login) {
        PreparedStatement ps;

        String pass = new String(login.txtPass.getPassword());
        Connection con = getConexion(login.txtUser.getText(), pass);

        String sql_query = "DELETE FROM cursos_alumnos WHERE cursos_codigo = ? AND alumnos_matricula = ?;";

        try {
            ps = con.prepareStatement(sql_query);
            ps.setInt(1, matricularAlumnos.getCursos_codigo());
            ps.setInt(2, matricularAlumnos.getAlumnos_matricula());
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
    
    public boolean buscarAlumnoMatriculado(MatricularAlumnos matricularAlumnos, Login login) {
        PreparedStatement ps;
        ResultSet rs;
        
        String pass = new String(login.txtPass.getPassword());
        Connection con = getConexion(login.txtUser.getText(), pass);

        String sql_query = "CALL buscarAlumnoMatriculado(?, ?);";

        try {
            ps = con.prepareStatement(sql_query);
            ps.setInt(1, matricularAlumnos.getCursos_codigo());
            ps.setInt(2, matricularAlumnos.getAlumnos_matricula());
            rs = ps.executeQuery();
            
            if(rs.next()){
                matricularAlumnos.setCursos_codigo((rs.getInt("id_curso")));
                matricularAlumnos.setAlumnos_matricula(rs.getInt("id_estudiante"));
                matricularAlumnos.setNombreCursoMatriculado(rs.getString("nombre_curso"));
                matricularAlumnos.setNombreEstudianteMatriculado(rs.getString("nombre_estudiante"));
                matricularAlumnos.setNombreProfesorMatriculado(rs.getString("nombre_profe"));
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
