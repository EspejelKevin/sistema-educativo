/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.SqlUsuarios;
import Modelo.Usuarios;
import Vista.Login;
import Vista.UsuariosForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author kevin
 */
public abstract class ControlUsuarios implements ActionListener {
    
    private Login login;
    private Usuarios modUsuarios;
    private UsuariosForm ventanaUsuarios;
    private SqlUsuarios modSqlUsuarios;

    public ControlUsuarios(Login login, Usuarios modUsuarios, UsuariosForm ventanaUsuarios, SqlUsuarios modSqlUsuarios) {
        this.login = login;
        this.modUsuarios = modUsuarios;
        this.ventanaUsuarios = ventanaUsuarios;
        this.modSqlUsuarios = modSqlUsuarios;
        this.ventanaUsuarios.btnNuevoUsuario.addActionListener(this);
        this.ventanaUsuarios.btnGuardarUsuario.addActionListener(this);
        this.ventanaUsuarios.btnBuscarUsuario.addActionListener(this);
        this.ventanaUsuarios.btnModificarUsuario.addActionListener(this);
        this.ventanaUsuarios.btnHabilitarCamposUsuarios.addActionListener(this);
        this.ventanaUsuarios.btnEliminarUsuario.addActionListener(this);
        this.ventanaUsuarios.btnLimpiarCamposUsuarios.addActionListener(this);
    }

    public void limpiar() {
        ventanaUsuarios.txtUsuarioUsuario.setText(null);
        ventanaUsuarios.txtNombreUsuario.setText(null);
        ventanaUsuarios.txtIdUsuario.setText(null);
        ventanaUsuarios.txtContrasenaUsuario.setText(null);
        ventanaUsuarios.txtConfirmarContrasena.setText(null);
        ventanaUsuarios.cmbxPerfiles.setSelectedIndex(0);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == ventanaUsuarios.btnNuevoUsuario) {
            ventanaUsuarios.txtUsuarioUsuario.setEnabled(true);
            ventanaUsuarios.txtNombreUsuario.setEnabled(true);
            ventanaUsuarios.txtContrasenaUsuario.setEnabled(true);
            ventanaUsuarios.txtConfirmarContrasena.setEnabled(true);
            ventanaUsuarios.cmbxPerfiles.setEnabled(true);
            
        } else if (event.getSource() == ventanaUsuarios.btnGuardarUsuario) {
            modUsuarios.setNombre(ventanaUsuarios.txtNombreUsuario.getText());
            modUsuarios.setUsuario(ventanaUsuarios.txtUsuarioUsuario.getText());
            char contrasenaArray[] = ventanaUsuarios.txtContrasenaUsuario.getPassword();
            String contrasena = new String(contrasenaArray);
            modUsuarios.setClave(contrasena);
            modUsuarios.setIdRol(ventanaUsuarios.cmbxPerfiles.getSelectedIndex());

            if (modSqlUsuarios.crearUsuario(modUsuarios, login)) {
                JOptionPane.showMessageDialog(null, "User saved successfully");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Save error");
                limpiar();
            }
            
        } else if(event.getSource() == ventanaUsuarios.btnBuscarUsuario){
            modUsuarios.setIdUsuario(Integer.parseInt(ventanaUsuarios.txtIdUsuario.getText()));
            
            if(modSqlUsuarios.buscarUsuario(modUsuarios, login)){
                ventanaUsuarios.txtIdUsuario.setText(String.valueOf(modUsuarios.getIdUsuario()));
                ventanaUsuarios.txtNombreUsuario.setText(modUsuarios.getNombre());
                ventanaUsuarios.txtUsuarioUsuario.setText(modUsuarios.getUsuario());
                ventanaUsuarios.cmbxPerfiles.setSelectedIndex(modUsuarios.getIdRol());
            }else{
                JOptionPane.showMessageDialog(null, "User not found");
                limpiar();
            }
            
        } else if(event.getSource() == ventanaUsuarios.btnModificarUsuario){
            modUsuarios.setIdUsuario(Integer.parseInt(ventanaUsuarios.txtIdUsuario.getText()));
            modUsuarios.setNombre(ventanaUsuarios.txtNombreUsuario.getText());
            modUsuarios.setUsuario(ventanaUsuarios.txtUsuarioUsuario.getText());
            char contrasenaArray[] = ventanaUsuarios.txtContrasenaUsuario.getPassword();
            String contrasena = new String(contrasenaArray);
            char contrasenaConfirmacionArray[] = ventanaUsuarios.txtConfirmarContrasena.getPassword();
            String contrasenaConfirmacion = new String(contrasenaConfirmacionArray);
            if(!contrasena.equals("") || !contrasenaConfirmacion.equals("")){
                modUsuarios.setClave(contrasena);
            }
            modUsuarios.setIdRol(ventanaUsuarios.cmbxPerfiles.getSelectedIndex());
            if(modSqlUsuarios.actualizarUsuario(modUsuarios, login)){
                JOptionPane.showMessageDialog(null, "User updated successfully");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Update error");
                limpiar();
            }
            
        }else if(event.getSource() == ventanaUsuarios.btnHabilitarCamposUsuarios){
            ventanaUsuarios.txtUsuarioUsuario.setEnabled(true);
            ventanaUsuarios.txtNombreUsuario.setEnabled(true);
            ventanaUsuarios.txtContrasenaUsuario.setEnabled(true);
            ventanaUsuarios.txtConfirmarContrasena.setEnabled(true);
            ventanaUsuarios.cmbxPerfiles.setEnabled(true);
            
        }else if(event.getSource() == ventanaUsuarios.btnEliminarUsuario){
            modUsuarios.setIdUsuario(Integer.parseInt(ventanaUsuarios.txtIdUsuario.getText()));
            
            if(modSqlUsuarios.eliminarUsuario(modUsuarios, login)){
                JOptionPane.showMessageDialog(null, "User deleted successfully");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Delete error");
                limpiar();
            }
            
        }else if(event.getSource() == ventanaUsuarios.btnLimpiarCamposUsuarios){
            limpiar();
        }
    }
}
