package Controlador;

import Modelo.Estudiantes;
import Modelo.Foto;
import Modelo.FotoMySQL;
import Modelo.SqlEstudiantes;
import Vista.EstudiantesForm;
import Vista.Login;
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

public abstract class ControlEstudiantes implements ActionListener {
    
    private Login login;
    private Estudiantes modEstudiantes;
    private EstudiantesForm ventanaEstudiantes;
    private SqlEstudiantes modSqlEstudiantes;
    private Foto foto;
    private FotoMySQL icono;
    private byte[] imagen;

    public ControlEstudiantes(Login login, Estudiantes modEstudiantes, EstudiantesForm ventanaEstudiantes,
            SqlEstudiantes modSqlEstudiantes) {
        this.login = login;
        this.modEstudiantes = modEstudiantes;
        this.ventanaEstudiantes = ventanaEstudiantes;
        this.modSqlEstudiantes = modSqlEstudiantes;
        this.ventanaEstudiantes.btnBuscarAlumno.addActionListener(this);
        this.ventanaEstudiantes.btnEliminarAlumno.addActionListener(this);
        this.ventanaEstudiantes.btnGuardarAlumno.addActionListener(this);
        this.ventanaEstudiantes.btnHabilitarCamposEstudiantes.addActionListener(this);
        this.ventanaEstudiantes.btnLimpiarCamposEstudiantes.addActionListener(this);
        this.ventanaEstudiantes.btnModificarAlumno.addActionListener(this);
        this.ventanaEstudiantes.btnNuevoAlumno.addActionListener(this);
        this.ventanaEstudiantes.btnSeleccionarFotoEstudiante.addActionListener(this);

    }

    public void limpiar() {
        try {
            ventanaEstudiantes.txtNombreAlumno.setText(null);

            ventanaEstudiantes.txtApellidosAlumno.setText(null);
            ventanaEstudiantes.txtCorreoAlumno.setText(null);
            ventanaEstudiantes.txtIdAlumno.setText(null);

            if (ventanaEstudiantes.panelFotoEstudiante.getComponent(0) == foto) {
                ventanaEstudiantes.panelFotoEstudiante.remove(foto);
                ventanaEstudiantes.panelFotoEstudiante.setBackground(Color.GRAY);
                ventanaEstudiantes.panelFotoEstudiante.repaint();
            } else {
                ventanaEstudiantes.panelFotoEstudiante.remove(icono);
                ventanaEstudiantes.panelFotoEstudiante.setBackground(Color.GRAY);
                ventanaEstudiantes.panelFotoEstudiante.repaint();
            }
        } catch (Exception e) {

        }
    }

    public void buscarFoto() {
        JFileChooser escogerArchivo = new JFileChooser();
        escogerArchivo.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        FileNameExtensionFilter extensionArchivo = new FileNameExtensionFilter("*.PNG", "png");
        escogerArchivo.setFileFilter(extensionArchivo);

        int seleccionImagen = escogerArchivo.showOpenDialog(ventanaEstudiantes);

        if (seleccionImagen == JFileChooser.APPROVE_OPTION) {
            File archivo = escogerArchivo.getSelectedFile();
            String ruta = archivo.getAbsolutePath();

            int x = ventanaEstudiantes.panelFotoEstudiante.getWidth();
            int y = ventanaEstudiantes.panelFotoEstudiante.getHeight();

            foto = new Foto(x, y, ruta);
            ventanaEstudiantes.panelFotoEstudiante.add(foto);
            ventanaEstudiantes.panelFotoEstudiante.repaint();
        }
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == ventanaEstudiantes.btnNuevoAlumno) {
            ventanaEstudiantes.txtNombreAlumno.setEnabled(true);
            ventanaEstudiantes.txtApellidosAlumno.setEnabled(true);
            ventanaEstudiantes.txtCorreoAlumno.setEnabled(true);
            ventanaEstudiantes.btnSeleccionarFotoEstudiante.setEnabled(true);

        } else if (event.getSource() == ventanaEstudiantes.btnGuardarAlumno) {
            modEstudiantes.setMatricula(Integer.parseInt(ventanaEstudiantes.txtIdAlumno.getText()));
            modEstudiantes.setNombre(ventanaEstudiantes.txtNombreAlumno.getText());
            modEstudiantes.setApellidos(ventanaEstudiantes.txtApellidosAlumno.getText());
            modEstudiantes.setEmail(ventanaEstudiantes.txtCorreoAlumno.getText());
            imagen = foto.obtenerImagen();
            modEstudiantes.setFoto(imagen);
            if (modSqlEstudiantes.crearEstudiante(modEstudiantes, login)) {
                JOptionPane.showMessageDialog(null, "Student saved successfully");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Save error");
                limpiar();
            }

        } else if (event.getSource() == ventanaEstudiantes.btnSeleccionarFotoEstudiante) {
            buscarFoto();

        } else if (event.getSource() == ventanaEstudiantes.btnLimpiarCamposEstudiantes) {
            limpiar();

        } else if (event.getSource() == ventanaEstudiantes.btnBuscarAlumno) {
            modEstudiantes.setMatricula(Integer.parseInt(ventanaEstudiantes.txtIdAlumno.getText()));
            
            if (modSqlEstudiantes.buscarEstudiante(modEstudiantes, login)) {
                ventanaEstudiantes.txtIdAlumno.setText(String.valueOf(modEstudiantes.getMatricula()));
                ventanaEstudiantes.txtNombreAlumno.setText(modEstudiantes.getNombre());
                ventanaEstudiantes.txtApellidosAlumno.setText(modEstudiantes.getApellidos());
                ventanaEstudiantes.txtCorreoAlumno.setText(modEstudiantes.getEmail());
                try {
                    imagen = modEstudiantes.getFoto();
                    BufferedImage bufferedImage = null;
                    InputStream inputStream = new ByteArrayInputStream(imagen);
                    bufferedImage = ImageIO.read(inputStream);
                    icono = new FotoMySQL(ventanaEstudiantes.panelFotoEstudiante.getWidth(),
                            ventanaEstudiantes.panelFotoEstudiante.getHeight(), bufferedImage);
                    ventanaEstudiantes.panelFotoEstudiante.add(icono);
                    ventanaEstudiantes.panelFotoEstudiante.repaint();
                } catch (IOException ex) {
                    Logger.getLogger(ControlProfesores.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                JOptionPane.showMessageDialog(null, "Student not found");
                limpiar();
            }
            
        }else if(event.getSource() == ventanaEstudiantes.btnModificarAlumno){
            modEstudiantes.setMatricula(Integer.parseInt(ventanaEstudiantes.txtIdAlumno.getText()));
            modEstudiantes.setNombre(ventanaEstudiantes.txtNombreAlumno.getText());
            modEstudiantes.setApellidos(ventanaEstudiantes.txtApellidosAlumno.getText());
            modEstudiantes.setEmail(ventanaEstudiantes.txtCorreoAlumno.getText());
            modEstudiantes.setFoto(imagen);
            
            if (modSqlEstudiantes.actualizarEstudiante(modEstudiantes, login)) {
                JOptionPane.showMessageDialog(null, "Student updated successfully");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Update error");
                limpiar();
            }
            
        }else if(event.getSource() == ventanaEstudiantes.btnEliminarAlumno){
            modEstudiantes.setMatricula(Integer.parseInt(ventanaEstudiantes.txtIdAlumno.getText()));
            
            if(modSqlEstudiantes.eliminarEstudiante(modEstudiantes, login)){
                JOptionPane.showMessageDialog(null, "Student deleted successfully");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Delete error");
                limpiar();
            }
            
        }else if(event.getSource() == ventanaEstudiantes.btnHabilitarCamposEstudiantes){
            ventanaEstudiantes.txtNombreAlumno.setEnabled(true);
            ventanaEstudiantes.txtApellidosAlumno.setEnabled(true);
            ventanaEstudiantes.txtCorreoAlumno.setEnabled(true);
            ventanaEstudiantes.btnSeleccionarFotoEstudiante.setEnabled(true);
        }
    }
}
