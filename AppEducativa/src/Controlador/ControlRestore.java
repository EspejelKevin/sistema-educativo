package Controlador;

import Modelo.ConexionBD;
import Vista.Restore;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public abstract class ControlRestore extends ConexionBD implements ActionListener {

    private Restore restore;

    public ControlRestore(Restore restore) {
        this.restore = restore;
        this.restore.btnRestoreBD.addActionListener(this);
        this.restore.btnLimpiarCamposBackup.addActionListener(this);
    }

    public void limpiar() {
        restore.txtBackupNombreDelRespaldo.setText(null);
        restore.txtNuevaBaseDatos.setText(null);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == restore.btnRestoreBD) {
            String nombreBD = restore.txtNuevaBaseDatos.getText();
            String nombreRespaldo = restore.txtBackupNombreDelRespaldo.getText();

            crearBasedeDatos("");
            try {
                sentencia.execute("CREATE DATABASE " + nombreBD);
            } catch (SQLException ex) {
                Logger.getLogger(ControlRestore.class.getName()).log(Level.SEVERE, null, ex);
            }

            Process p = null;
            try {
                p = Runtime.getRuntime().exec("mysql -u root -pkm05010002 " + nombreBD);
            } catch (IOException ex) {
                Logger.getLogger(ControlRestore.class.getName()).log(Level.SEVERE, null, ex);
            }

            OutputStream os = p.getOutputStream(); //Pedimos la salida
            FileInputStream fis = null;
            try {
                fis = new FileInputStream("C:\\Users\\kevin\\OneDrive\\Documents\\" + nombreRespaldo); //creamos el archivo para le respaldo
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ControlRestore.class.getName()).log(Level.SEVERE, null, ex);
            }
            byte[] buffer = new byte[1000]; //Creamos una variable de tipo byte para el buffer

            int leido = 0;
            try {
                leido = fis.read(buffer); //Devuelve el número de bytes leídos o -1 si se alcanzó el final del stream.
            } catch (IOException ex) {
                Logger.getLogger(ControlRestore.class.getName()).log(Level.SEVERE, null, ex);
            }
            while (leido > 0) {
                try {
                    os.write(buffer, 0, leido); //Buffer de caracteres, Desplazamiento de partida para empezar a escribir caracteres, Número de caracteres para escribir
                } catch (IOException ex) {
                    Logger.getLogger(ControlRestore.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    leido = fis.read(buffer);
                } catch (IOException ex) {
                    Logger.getLogger(ControlRestore.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            try {
                os.flush(); //vacía los buffers de salida
            } catch (IOException ex) {
                Logger.getLogger(ControlRestore.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                os.close(); //Cierra
            } catch (IOException ex) {
                Logger.getLogger(ControlRestore.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                fis.close(); //Cierra respaldo
            } catch (IOException ex) {
                Logger.getLogger(ControlRestore.class.getName()).log(Level.SEVERE, null, ex);
            }

            JOptionPane.showMessageDialog(null, "Successful database restore");
            limpiar();
            
        } else if (event.getSource() == restore.btnLimpiarCamposBackup) {
            limpiar();
        }

    }
}
