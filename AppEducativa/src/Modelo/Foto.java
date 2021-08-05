
package Modelo;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.swing.ImageIcon;

public class Foto extends javax.swing.JPanel {

    public String ruta;
    
    public Foto(int x, int y, String ruta) {
        this.setSize(x, y); //se selecciona el tamaño del panel
        this.ruta = ruta;
    }

//Se crea un método cuyo parámetro debe ser un objeto Graphics
    public void paint(Graphics grafico) {
        Dimension height = getSize();
        System.out.println(ruta);
//Se selecciona la imagen
        Image imagenExterna = new ImageIcon(ruta).getImage();

//se dibuja la imagen que seleccionemos
        grafico.drawImage(imagenExterna, 0, 0, height.width, height.height, null);

        setOpaque(false);
        super.paintComponent(grafico);
    }
    
    public byte[] obtenerImagen(){
        File imagen = new File(ruta);
        try{
            byte[] icono = new byte[(int) imagen.length()];
            InputStream input = new FileInputStream(imagen);
            input.read(icono);
            return icono;
        }catch(Exception e){
            return null;
        }
    }
}