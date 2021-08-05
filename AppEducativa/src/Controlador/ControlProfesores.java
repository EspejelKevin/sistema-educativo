package Controlador;

import Modelo.Foto;
import Modelo.FotoMySQL;
import Modelo.Profesores;
import Modelo.SqlProfesores;
import Vista.Login;
import Vista.ProfesoresForm;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public abstract class ControlProfesores implements ActionListener {
    
    private Login login;
    private Profesores modProfesores;
    private ProfesoresForm ventanaProfesores;
    private SqlProfesores modSqlProfesores;
    private Foto foto;
    private FotoMySQL icono;
    private byte[] imagen;

    public ControlProfesores(Login login, Profesores modProfesores, ProfesoresForm ventanaProfesores,
            SqlProfesores modSqlProfesores) {
        
        this.login = login;
        this.modProfesores = modProfesores;
        this.modSqlProfesores = modSqlProfesores;
        this.ventanaProfesores = ventanaProfesores;
        this.ventanaProfesores.btnNuevoProfesor.addActionListener(this);
        this.ventanaProfesores.btnGuardarProfesor.addActionListener(this);
        this.ventanaProfesores.btnModificarProfesor.addActionListener(this);
        this.ventanaProfesores.btnEliminarProfesor.addActionListener(this);
        this.ventanaProfesores.btnBuscarProfesor.addActionListener(this);
        this.ventanaProfesores.btnLimpiarCamposProfesores.addActionListener(this);
        this.ventanaProfesores.btnHabilitarCamposProfesores.addActionListener(this);
        this.ventanaProfesores.btnSeleccionarFotoProfesor.addActionListener(this);
    }

    public void limpiar() {
        try{
            ventanaProfesores.txtNombreProfesor.setText(null);
        
            ventanaProfesores.txtDireccionProfesor.setText(null);
            ventanaProfesores.txtTelefonoProfesor.setText(null);
            ventanaProfesores.txtRFC.setText(null);

            if (ventanaProfesores.panelFotoProfesor.getComponent(0) == foto) {
                ventanaProfesores.panelFotoProfesor.remove(foto);
                ventanaProfesores.panelFotoProfesor.setBackground(Color.GRAY);
                ventanaProfesores.panelFotoProfesor.repaint();
            } else {
                ventanaProfesores.panelFotoProfesor.remove(icono);
                ventanaProfesores.panelFotoProfesor.setBackground(Color.GRAY);
                ventanaProfesores.panelFotoProfesor.repaint();
            }
        }catch(Exception e){
            
        }
    }

    public void buscarFoto() {
        JFileChooser escogerArchivo = new JFileChooser();
        escogerArchivo.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        FileNameExtensionFilter extensionArchivo = new FileNameExtensionFilter("*.PNG", "png");
        escogerArchivo.setFileFilter(extensionArchivo);

        int seleccionImagen = escogerArchivo.showOpenDialog(ventanaProfesores);

        if (seleccionImagen == JFileChooser.APPROVE_OPTION) {
            File archivo = escogerArchivo.getSelectedFile();
            String ruta = archivo.getAbsolutePath();

            int x = ventanaProfesores.panelFotoProfesor.getWidth();
            int y = ventanaProfesores.panelFotoProfesor.getHeight();

            foto = new Foto(x, y, ruta);
            ventanaProfesores.panelFotoProfesor.add(foto);
            ventanaProfesores.panelFotoProfesor.repaint();
        }
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == ventanaProfesores.btnNuevoProfesor) {
            ventanaProfesores.txtNombreProfesor.setEnabled(true);
            ventanaProfesores.txtDireccionProfesor.setEnabled(true);
            ventanaProfesores.txtTelefonoProfesor.setEnabled(true);
            ventanaProfesores.btnSeleccionarFotoProfesor.setEnabled(true);

        } else if (event.getSource() == ventanaProfesores.btnGuardarProfesor) {
            modProfesores.setRFC(ventanaProfesores.txtRFC.getText());
            modProfesores.setNombre(ventanaProfesores.txtNombreProfesor.getText());
            modProfesores.setDireccion(ventanaProfesores.txtDireccionProfesor.getText());
            modProfesores.setTelefono(Integer.parseInt(ventanaProfesores.txtTelefonoProfesor.getText()));
            imagen = foto.obtenerImagen();
            modProfesores.setFotoProfesor(imagen);
            if (modSqlProfesores.crearProfesor(modProfesores, login)) {
                JOptionPane.showMessageDialog(null, "Teacher saved successfully");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Save error");
                limpiar();
            }

        } else if (event.getSource() == ventanaProfesores.btnSeleccionarFotoProfesor) {
            buscarFoto();

        } else if (event.getSource() == ventanaProfesores.btnLimpiarCamposProfesores) {
            limpiar();

        } else if (event.getSource() == ventanaProfesores.btnBuscarProfesor) {
            modProfesores.setRFC(ventanaProfesores.txtRFC.getText());

            if (modSqlProfesores.buscarProfesor(modProfesores, login)) {
                ventanaProfesores.txtRFC.setText(modProfesores.getRFC());
                ventanaProfesores.txtNombreProfesor.setText(modProfesores.getNombre());
                ventanaProfesores.txtDireccionProfesor.setText(modProfesores.getDireccion());
                ventanaProfesores.txtTelefonoProfesor.setText(String.valueOf(modProfesores.getTelefono()));
                try {
                    imagen = modProfesores.getFotoProfesor();
                    BufferedImage bufferedImage = null;
                    InputStream inputStream = new ByteArrayInputStream(imagen);
                    bufferedImage = ImageIO.read(inputStream);
                    icono = new FotoMySQL(ventanaProfesores.panelFotoProfesor.getWidth(),
                            ventanaProfesores.panelFotoProfesor.getHeight(), bufferedImage);
                    ventanaProfesores.panelFotoProfesor.add(icono);
                    ventanaProfesores.panelFotoProfesor.repaint();
                } catch (IOException ex) {
                    Logger.getLogger(ControlProfesores.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                JOptionPane.showMessageDialog(null, "Teacher not found");
                limpiar();
            }

        } else if (event.getSource() == ventanaProfesores.btnModificarProfesor) {
            modProfesores.setRFC(ventanaProfesores.txtRFC.getText());
            modProfesores.setNombre(ventanaProfesores.txtNombreProfesor.getText());
            modProfesores.setDireccion(ventanaProfesores.txtDireccionProfesor.getText());
            modProfesores.setTelefono(Integer.parseInt(ventanaProfesores.txtTelefonoProfesor.getText()));
            modProfesores.setFotoProfesor(imagen);
            
            if (modSqlProfesores.actualizarProfesor(modProfesores, login)) {
                JOptionPane.showMessageDialog(null, "Teacher updated successfully");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Update error");
                limpiar();
            }
            
        }else if(event.getSource() == ventanaProfesores.btnEliminarProfesor){
            modProfesores.setRFC(ventanaProfesores.txtRFC.getText());
            
            if(modSqlProfesores.eliminarProfesor(modProfesores, login)){
                JOptionPane.showMessageDialog(null, "Teacher deleted successfully");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Delete error");
                limpiar();
            }
            
        }else if(event.getSource() == ventanaProfesores.btnHabilitarCamposProfesores){
            ventanaProfesores.txtNombreProfesor.setEnabled(true);
            ventanaProfesores.txtDireccionProfesor.setEnabled(true);
            ventanaProfesores.txtTelefonoProfesor.setEnabled(true);
            ventanaProfesores.btnSeleccionarFotoProfesor.setEnabled(true);
        }
    }
}
