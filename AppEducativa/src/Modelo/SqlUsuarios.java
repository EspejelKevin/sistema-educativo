package Modelo;

import Vista.Login;
import Vista.Registrar;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SqlUsuarios extends ConexionBD {

    public boolean loginUsuario(Usuarios usr, Login login) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        String pass = new String(login.txtPass.getPassword());
        Connection con = getConexion(login.txtUser.getText(), pass);

        String sql_query = "SELECT idUsuario, nombre, usuario, aes_decrypt(clave, 'aes'), idRol FROM usuarios WHERE usuario = ?";

        try {
            ps = con.prepareStatement(sql_query);
            ps.setString(1, usr.getUsuario());
            rs = ps.executeQuery();

            if (rs.next()) {
                if (usr.getClave().equals(rs.getString(4))) {
                    usr.setIdUsuario(rs.getInt(1));
                    usr.setNombre(rs.getString(2));
                    usr.setIdRol(rs.getInt(5));
                    return true;
                } else {
                    return false;
                }
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

    public boolean registrarUsuario(Registrar registrar) {
        PreparedStatement ps = null;
        String pass = new String(registrar.txtPassRegistrar.getPassword());
        Connection con = getConexionRegistrarUsuario();

        String sql_query = "CALL registrarUsuario(?, ?, ?, ?);";
       
        try {
            ps = con.prepareStatement(sql_query);
            ps.setString(1, registrar.txtNombreRegistrar.getText());
            ps.setString(2, registrar.txtUserRegistrar.getText());
            ps.setString(3, pass);
            ps.setString(4, registrar.cbxRegistrarRole.getSelectedItem().toString());
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

    public boolean crearUsuario(Usuarios usr, Login login) {
        PreparedStatement ps;

        String pass = new String(login.txtPass.getPassword());
        Connection con = getConexion(login.txtUser.getText(), pass);

        String sql_query = "INSERT INTO usuarios(nombre, usuario, clave, idRol) "
                + "VALUES(?, ?, AES_ENCRYPT(?, ?), ?);";

        try {
            ps = con.prepareStatement(sql_query);
            ps.setString(1, usr.getNombre());
            ps.setString(2, usr.getUsuario());
            ps.setString(3, usr.getClave());
            ps.setString(4, "aes");
            ps.setInt(5, usr.getIdRol());
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

    public boolean actualizarUsuario(Usuarios usr, Login login) {
        PreparedStatement ps;

        String pass = new String(login.txtPass.getPassword());
        Connection con = getConexion(login.txtUser.getText(), pass);

        String sql_query = "UPDATE usuarios SET nombre = ?, usuario = ?, "
                + "clave = AES_ENCRYPT(?, ?), idRol = ? WHERE idUsuario = ?;";

        try {
            ps = con.prepareStatement(sql_query);
            ps.setString(1, usr.getNombre());
            ps.setString(2, usr.getUsuario());
            ps.setString(3, usr.getClave());
            ps.setString(4, "aes");
            ps.setInt(5, usr.getIdRol());
            ps.setInt(6, usr.getIdUsuario());
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

    public boolean eliminarUsuario(Usuarios usr, Login login) {
        PreparedStatement ps;

        String pass = new String(login.txtPass.getPassword());
        Connection con = getConexion(login.txtUser.getText(), pass);

        String sql_query = "DELETE FROM usuarios WHERE idUsuario = ?;";

        try {
            ps = con.prepareStatement(sql_query);
            ps.setInt(1, usr.getIdUsuario());
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

    public boolean buscarUsuario(Usuarios usr, Login login) {
        PreparedStatement ps;
        ResultSet rs;

        String pass = new String(login.txtPass.getPassword());
        Connection con = getConexion(login.txtUser.getText(), pass);

        String sql_query = "SELECT idUsuario, nombre, usuario, idRol, AES_DECRYPT(clave, ?) as clave FROM usuarios AS u INNER JOIN "
                + "roles AS r ON u.idRol = r.id WHERE idUsuario = ?;";

        try {
            ps = con.prepareStatement(sql_query);
            ps.setString(1, "aes");
            ps.setInt(2, usr.getIdUsuario());
            rs = ps.executeQuery();

            if (rs.next()) {
                usr.setIdUsuario(Integer.parseInt(rs.getString("idUsuario")));
                usr.setNombre(rs.getString("nombre"));
                usr.setUsuario(rs.getString("usuario"));
                usr.setIdRol(rs.getInt("idRol"));
                usr.setClave(rs.getString("clave"));
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
