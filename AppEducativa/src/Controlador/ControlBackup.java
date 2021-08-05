/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.Backup;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author kevin
 */
public abstract class ControlBackup implements ActionListener {

    private Backup backup;

    public ControlBackup(Backup backup) {
        this.backup = backup;
        this.backup.btnBackupBD.addActionListener(this);
        this.backup.btnLimpiarCamposBackup.addActionListener(this);
    }

    public void limpiar() {
        backup.txtNombreDelRespaldo.setText(null);
        backup.txtBaseDeDatosRespaldar.setText(null);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == backup.btnBackupBD) {
            String nombreRespaldo = backup.txtNombreDelRespaldo.getText();
            String nombreBaseDatos = backup.txtBaseDeDatosRespaldar.getText();

            Process p = null;
            try {
                p = Runtime.getRuntime().exec("mysqldump -u root -pkm05010002 " + nombreBaseDatos);
            } catch (IOException ex) {
                Logger.getLogger(ControlBackup.class.getName()).log(Level.SEVERE, null, ex);
            }

            InputStream is = p.getInputStream();//Pedimos la entrada
            FileOutputStream fos = null;
            try {
                fos = new FileOutputStream("C:\\Users\\kevin\\OneDrive\\Documents\\" + nombreRespaldo); //creamos el archivo para le respaldo
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ControlBackup.class.getName()).log(Level.SEVERE, null, ex);
            }
            byte[] buffer = new byte[1000]; //Creamos una variable de tipo byte para el buffer

            int leido = 0;
            try {
                leido = is.read(buffer); //Devuelve el número de bytes leídos o -1 si se alcanzó el final del stream.
            } catch (IOException ex) {
                Logger.getLogger(ControlBackup.class.getName()).log(Level.SEVERE, null, ex);
            }
            while (leido > 0) {
                try {
                    fos.write(buffer, 0, leido);//Buffer de caracteres, Desplazamiento de partida para empezar a escribir caracteres, Número de caracteres para escribir
                } catch (IOException ex) {
                    Logger.getLogger(ControlBackup.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    leido = is.read(buffer);
                } catch (IOException ex) {
                    Logger.getLogger(ControlBackup.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            try {
                fos.close();//Cierra respaldo
            } catch (IOException ex) {
                Logger.getLogger(ControlBackup.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            JOptionPane.showMessageDialog(null, "Successful database backup");
            limpiar();
            
        }else if(event.getSource() == backup.btnLimpiarCamposBackup){
            limpiar();
        }

    }
}
