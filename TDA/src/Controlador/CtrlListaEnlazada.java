/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ListaEnlazadaSimple;
import Modelo.Nodo;
import Modelo.Producto;
import Modelo.SqlProductos;

import Vista.ListaEnlazada;
import Vista.ListaEnlazadaBD;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kevin
 */
public abstract class CtrlListaEnlazada implements ActionListener {

    private ListaEnlazadaSimple listaEnlazada;
    private ListaEnlazada ventanaListaEnlazada;
    private ListaEnlazadaBD ventanaListaEnlazadaBD;
    private SqlProductos sqlProductos;

    public CtrlListaEnlazada(ListaEnlazadaSimple listaEnlazada, ListaEnlazada ventanaListaEnlazada,
            ListaEnlazadaBD ventanaListaEnlazadaBD, SqlProductos sqlProductos) {
        this.listaEnlazada = listaEnlazada;
        this.ventanaListaEnlazada = ventanaListaEnlazada;
        this.ventanaListaEnlazadaBD = ventanaListaEnlazadaBD;
        this.sqlProductos = sqlProductos;
        this.ventanaListaEnlazada.btnEjecutarOperacionLista.addActionListener(this);
        this.ventanaListaEnlazadaBD.btnPintarRegistros.addActionListener(this);
        this.ventanaListaEnlazada.operacionesLista.addActionListener(this);
        this.ventanaListaEnlazada.txtDatoEliminarLista.addActionListener(this);
        this.ventanaListaEnlazada.txtDatoPosicionLista.addActionListener(this);
        this.ventanaListaEnlazada.txtDatoTestigo.addActionListener(this);
        this.ventanaListaEnlazada.txtInsertarDatoLista.addActionListener(this);
    }

    public void limpiarCampos() {
        ventanaListaEnlazada.txtDatoEliminarLista.setText("");
        ventanaListaEnlazada.txtDatoPosicionLista.setText("");
        ventanaListaEnlazada.txtDatoTestigo.setText("");
        ventanaListaEnlazada.txtInsertarDatoLista.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        JComboBox combo = ventanaListaEnlazada.operacionesLista;
        JTable tabla = ventanaListaEnlazadaBD.tableProductos;
        if (event.getSource() == ventanaListaEnlazada.btnEjecutarOperacionLista) {
            if (combo.getSelectedIndex() == 1) {
                try {
                    int dato = Integer.parseInt(ventanaListaEnlazada.txtInsertarDatoLista.getText());
                    listaEnlazada.insertarInicio(dato);
                    limpiarCampos();
                    JOptionPane.showMessageDialog(null, "El dato " + dato + " fue insertado exitosamente");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Hubo un error al guardar el dato");
                }
            } else if (combo.getSelectedIndex() == 2) {
                try {
                    int dato = Integer.parseInt(ventanaListaEnlazada.txtInsertarDatoLista.getText());
                    listaEnlazada.insertarFinal(dato);
                    limpiarCampos();
                    JOptionPane.showMessageDialog(null, "El dato " + dato + " fue insertado exitosamente");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Hubo un error al guardar el dato");
                }
            } else if (combo.getSelectedIndex() == 3) {
                try {
                    int dato = Integer.parseInt(ventanaListaEnlazada.txtInsertarDatoLista.getText());
                    int testigo = Integer.parseInt(ventanaListaEnlazada.txtDatoTestigo.getText());
                    listaEnlazada.insertarCualquierPosicion(testigo, dato);
                    limpiarCampos();
                    JOptionPane.showMessageDialog(null, "El dato " + dato + " fue insertado exitosamente");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Hubo un error al guardar el dato");
                }
            } else if (combo.getSelectedIndex() == 4) {
                try {
                    listaEnlazada.eliminarInicio();
                    limpiarCampos();
                    JOptionPane.showMessageDialog(null, "El dato fue eliminado exitosamente");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Hubo un error al eliminar el dato");
                }
            } else if (combo.getSelectedIndex() == 5) {
                try {
                    listaEnlazada.eliminarFinal();
                    limpiarCampos();
                    JOptionPane.showMessageDialog(null, "El dato fue eliminado exitosamente");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Hubo un error al eliminar el dato");
                }
            } else if (combo.getSelectedIndex() == 6) {
                try {
                    int dato = Integer.parseInt(ventanaListaEnlazada.txtDatoEliminarLista.getText());
                    listaEnlazada.eliminar(dato);
                    limpiarCampos();
                    JOptionPane.showMessageDialog(null, "El dato " + dato + " fue eliminado exitosamente");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Hubo un error al eliminar el dato");
                }
            } else if (combo.getSelectedIndex() == 7) {
                try {
                    int dato = Integer.parseInt(ventanaListaEnlazada.txtDatoPosicionLista.getText());
                    if (listaEnlazada.buscarElemento(dato) != null) {
                        JOptionPane.showMessageDialog(null, "El dato " + dato + " fue encontrado");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró el dato");
                    }
                    limpiarCampos();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Hubo un error en la operación");
                }
            } else if (combo.getSelectedIndex() == 8) {
                try {
                    listaEnlazada.ordenarLista();
                    JOptionPane.showMessageDialog(null, "Lista ordenada con éxito");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Hubo un error en la operación");
                }
            } else if (combo.getSelectedIndex() == 9) {
                try {
                    String lista = listaEnlazada.listar();
                    JOptionPane.showMessageDialog(null, "Lisa enlazada:  " + lista);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error al mostrar lista");
                }
            } else if (combo.getSelectedIndex() == 10) {
                int tamanio = listaEnlazada.tamanioLista();
                JOptionPane.showMessageDialog(null, "Número de elementos de la lista: " + tamanio);
            }
        } else if (event.getSource() == ventanaListaEnlazadaBD.btnPintarRegistros) {
            ListaEnlazadaSimple lista = sqlProductos.obtenerRegistros();
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();

            for (int i = 0; i < tabla.getRowCount(); i++) {
                modelo.removeRow(i);
                i -= 1;
            }

            Nodo actual = lista.primero;
            Producto producto;
            while (actual.getSiguiente() != null) {
                producto = (Producto) actual.getDato();
                actual = actual.getSiguiente();
                modelo.addRow(new Object[]{producto.getId(), producto.getNombre(), producto.getDescripcion(), producto.getPrecio()});
                if (actual.getSiguiente() == null) {
                    producto = (Producto) actual.getDato();
                    modelo.addRow(new Object[]{producto.getId(), producto.getNombre(), producto.getDescripcion(), producto.getPrecio()});
                }
            }
            tabla.setModel(modelo);
        }
    }
}
/*
Insertar al inicio
Insertar al final
Insertar en cualquier posición
Eliminar al inicio
Eliminar al final
Eliminar en cualquier posición
Buscar un elemento por posición
Buscar un elemento por valor
Ordenar lista
Mostrar lista
Tamaño de la lista
 */
