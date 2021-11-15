/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Conexion.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kevin
 */
public class SqlProductos extends ConexionDB {
 
    public ListaEnlazadaSimple obtenerRegistros() {
        ListaEnlazadaSimple listaEnlazada = new ListaEnlazadaSimple();

        PreparedStatement ps;
        ResultSet rs;

        Connection con = getConexion();

        String consulta = "SELECT * FROM productos;";

        try {
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();

            while (rs.next()) {
                Producto producto = new Producto();
                producto.setId(rs.getInt("id"));
                producto.setNombre(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecio(rs.getDouble("precio"));
                listaEnlazada.insertarFinal(producto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SqlProductos.class.getName()).log(Level.SEVERE, null, ex);
            return listaEnlazada;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(SqlProductos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaEnlazada;
    }
}
