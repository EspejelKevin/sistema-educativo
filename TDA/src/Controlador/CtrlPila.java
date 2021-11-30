/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Pila;
import Vista.PilaVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

/**
 *
 * @author kevin
 */
public abstract class CtrlPila implements ActionListener  {
    
    private Pila pila;
    private PilaVista ventanaPila;
    
    public CtrlPila(Pila pila, PilaVista ventanaPila) {
        this.pila = pila;
        this.ventanaPila = ventanaPila;
        this.ventanaPila.rbtnPush.addActionListener(this);
        this.ventanaPila.rbtnPop.addActionListener(this);
        this.ventanaPila.rbtnPopCualquiera.addActionListener(this);
        this.ventanaPila.rbtnTamanioPila.addActionListener(this);
        this.ventanaPila.rbtnTope.addActionListener(this);
        this.ventanaPila.rbtnVaciarPila.addActionListener(this);
        this.ventanaPila.rbtnMostrarPila.addActionListener(this);
        this.ventanaPila.btnEjecutar.addActionListener(this);
        this.ventanaPila.txtDatoPush.addActionListener(this);
        this.ventanaPila.txtDatoPop.addActionListener(this);
        this.ventanaPila.txtDatoPush.setEnabled(false);
        this.ventanaPila.txtDatoPop.setEnabled(false);
    }
    
    public void limpiarCampos() {
        ventanaPila.txtDatoPop.setText("");
        ventanaPila.txtDatoPush.setText("");
        ventanaPila.rbtnMostrarPila.setSelected(false);
        ventanaPila.rbtnPop.setSelected(false);
        ventanaPila.rbtnPopCualquiera.setSelected(false);
        ventanaPila.rbtnPush.setSelected(false);
        ventanaPila.rbtnTamanioPila.setSelected(false);
        ventanaPila.rbtnTope.setSelected(false);
        ventanaPila.rbtnVaciarPila.setSelected(false);
    }

    public void estaSeleccionado(JRadioButton rBoton) {
        if (rBoton == ventanaPila.rbtnMostrarPila) {
            ventanaPila.rbtnPop.setSelected(false);
            ventanaPila.rbtnPopCualquiera.setSelected(false);
            ventanaPila.rbtnPush.setSelected(false);
            ventanaPila.rbtnTamanioPila.setSelected(false);
            ventanaPila.rbtnTope.setSelected(false);
            ventanaPila.rbtnVaciarPila.setSelected(false);
        } else if (rBoton == ventanaPila.rbtnPop) {
            ventanaPila.rbtnMostrarPila.setSelected(false);
            ventanaPila.rbtnPopCualquiera.setSelected(false);
            ventanaPila.rbtnPush.setSelected(false);
            ventanaPila.rbtnTamanioPila.setSelected(false);
            ventanaPila.rbtnTope.setSelected(false);
            ventanaPila.rbtnVaciarPila.setSelected(false);
        } else if (rBoton == ventanaPila.rbtnPopCualquiera) {
            ventanaPila.rbtnMostrarPila.setSelected(false);
            ventanaPila.rbtnPop.setSelected(false);
            ventanaPila.rbtnPush.setSelected(false);
            ventanaPila.rbtnTamanioPila.setSelected(false);
            ventanaPila.rbtnTope.setSelected(false);
            ventanaPila.rbtnVaciarPila.setSelected(false);
        } else if (rBoton == ventanaPila.rbtnPush) {
            ventanaPila.rbtnMostrarPila.setSelected(false);
            ventanaPila.rbtnPop.setSelected(false);
            ventanaPila.rbtnPopCualquiera.setSelected(false);
            ventanaPila.rbtnTamanioPila.setSelected(false);
            ventanaPila.rbtnTope.setSelected(false);
            ventanaPila.rbtnVaciarPila.setSelected(false);
        } else if (rBoton == ventanaPila.rbtnTamanioPila) {
            ventanaPila.rbtnMostrarPila.setSelected(false);
            ventanaPila.rbtnPop.setSelected(false);
            ventanaPila.rbtnPopCualquiera.setSelected(false);
            ventanaPila.rbtnPush.setSelected(false);
            ventanaPila.rbtnTope.setSelected(false);
            ventanaPila.rbtnVaciarPila.setSelected(false);
        } else if (rBoton == ventanaPila.rbtnTope) {
            ventanaPila.rbtnMostrarPila.setSelected(false);
            ventanaPila.rbtnPop.setSelected(false);
            ventanaPila.rbtnPopCualquiera.setSelected(false);
            ventanaPila.rbtnPush.setSelected(false);
            ventanaPila.rbtnTamanioPila.setSelected(false);
            ventanaPila.rbtnVaciarPila.setSelected(false);
        } else if (rBoton == ventanaPila.rbtnVaciarPila) {
            ventanaPila.rbtnMostrarPila.setSelected(false);
            ventanaPila.rbtnPop.setSelected(false);
            ventanaPila.rbtnPopCualquiera.setSelected(false);
            ventanaPila.rbtnPush.setSelected(false);
            ventanaPila.rbtnTamanioPila.setSelected(false);
            ventanaPila.rbtnTope.setSelected(false);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == ventanaPila.rbtnPush) {
            ventanaPila.txtDatoPop.setEnabled(false);
            ventanaPila.txtDatoPush.setEnabled(true);
            estaSeleccionado(ventanaPila.rbtnPush);
        } else if (event.getSource() == ventanaPila.rbtnPopCualquiera) {
            ventanaPila.txtDatoPop.setEnabled(true);
            ventanaPila.txtDatoPush.setEnabled(false);
            estaSeleccionado(ventanaPila.rbtnPopCualquiera);
        } else if (event.getSource() == ventanaPila.rbtnMostrarPila) {
            estaSeleccionado(ventanaPila.rbtnMostrarPila);
        } else if (event.getSource() == ventanaPila.rbtnPop) {
            estaSeleccionado(ventanaPila.rbtnPop);
        } else if (event.getSource() == ventanaPila.rbtnTamanioPila) {
            estaSeleccionado(ventanaPila.rbtnTamanioPila);
        } else if (event.getSource() == ventanaPila.rbtnTope) {
            estaSeleccionado(ventanaPila.rbtnTope);
        } else if (event.getSource() == ventanaPila.rbtnVaciarPila) {
            estaSeleccionado(ventanaPila.rbtnVaciarPila);
        } 
        if (event.getSource() == ventanaPila.btnEjecutar) {
            if (ventanaPila.rbtnPush.isSelected()) {
                try {
                    int dato = Integer.parseInt(ventanaPila.txtDatoPush.getText());
                    pila.insertarInicio(dato);
                    limpiarCampos();
                    String datos = pila.mostrarPila();
                    ventanaPila.txtDatosPila.setText(datos);
                    JOptionPane.showMessageDialog(null, "El dato " + dato + " fue insertado exitosamente.");
                    ventanaPila.txtDatoPush.setEnabled(false);
                } catch (Exception e) {
                    limpiarCampos();
                    JOptionPane.showMessageDialog(null, "Falló al insertar el elemento.");
                }
            } else if (ventanaPila.rbtnPop.isSelected()) {
                try {
                    int dato = pila.eliminarInicio();
                    limpiarCampos();
                    String datos = pila.mostrarPila();
                    ventanaPila.txtDatosPila.setText(datos);
                    JOptionPane.showMessageDialog(null, "El dato " + dato + " fue popeado exitosamente.");
                } catch (Exception e) {
                    limpiarCampos();
                    JOptionPane.showMessageDialog(null, "Error al popear el elemento.");
                }
            } else if (ventanaPila.rbtnPopCualquiera.isSelected()){
                try {
                    int dato = Integer.parseInt(ventanaPila.txtDatoPop.getText());
                    pila.eliminar(dato);
                    limpiarCampos();
                    String datos = pila.mostrarPila();
                    ventanaPila.txtDatosPila.setText(datos);
                    JOptionPane.showMessageDialog(null, "Los datos fueron popeados.");
                    ventanaPila.txtDatoPop.setEnabled(false);
                } catch (Exception e) {
                    limpiarCampos();
                    JOptionPane.showMessageDialog(null, "Error al popear los elementos.");
                }
            } else if (ventanaPila.rbtnMostrarPila.isSelected()){
                try {
                    String datos = pila.mostrarPila();
                    limpiarCampos();
                    ventanaPila.txtDatosPila.setText(datos);
                } catch (Exception e) {
                    limpiarCampos();
                    JOptionPane.showMessageDialog(null, "Error al mostrar la pila.");
                }
            } else if (ventanaPila.rbtnTamanioPila.isSelected()){
                try {
                    int tamanio = pila.tamanioPila();
                    limpiarCampos();
                    ventanaPila.txtDatosPila.setText("El tamaño de la pila es de " + tamanio + ".");
                } catch (Exception e) {
                    limpiarCampos();
                    JOptionPane.showMessageDialog(null, "Error al solicitar el tamaño de la pila.");
                }
            } else if (ventanaPila.rbtnTope.isSelected()){
                try {
                    int tope = pila.mostrarUltimoValor();
                    limpiarCampos();
                    ventanaPila.txtDatosPila.setText("El tope de la pila es " + tope + ".");
                } catch (Exception e) {
                    limpiarCampos();
                    JOptionPane.showMessageDialog(null, "Error al solicitar el tope de la pila.");
                }
            } else if (ventanaPila.rbtnVaciarPila.isSelected()){
                try {
                    pila.vaciarPila();
                    limpiarCampos();
                    ventanaPila.txtDatosPila.setText("Pila vacía.");
                } catch (Exception e) {
                    limpiarCampos();
                    JOptionPane.showMessageDialog(null, "Error al vaciar la pila.");
                }
            } 
        }
    }
}
