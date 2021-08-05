
package Modelo;

public class Profesores {
    
    private String RFC;
    private String nombre;
    private String direccion;
    private int telefono;
    private byte[] fotoProfesor;

    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public byte[] getFotoProfesor() {
        return fotoProfesor;
    }

    public void setFotoProfesor(byte[] fotoProfesor) {
        this.fotoProfesor = fotoProfesor;
    }
    
    
}
