/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Cola;
import Vista.ColaVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

/**
 *
 * @author kevin
 */
public abstract class CtrlCola implements ActionListener {

    private Cola cola;
    private ColaVista ventanaCola;

    public CtrlCola(Cola cola, ColaVista ventanaCola) {
        this.cola = cola;
        this.ventanaCola = ventanaCola;
        this.ventanaCola.rbtnEncolar.addActionListener(this);
        this.ventanaCola.rbtnDesencolar.addActionListener(this);
        this.ventanaCola.rbtnDesencolarCualquiera.addActionListener(this);
        this.ventanaCola.rbtnVaciar.addActionListener(this);
        this.ventanaCola.rbtnTamanioCola.addActionListener(this);
        this.ventanaCola.rbtnCabeza.addActionListener(this);
        this.ventanaCola.rbtnCola.addActionListener(this);
        this.ventanaCola.rbtnMostrarCola.addActionListener(this);
        this.ventanaCola.btnEjecutar.addActionListener(this);
        this.ventanaCola.txtDatoEncolar.addActionListener(this);
        this.ventanaCola.txtDatoDesencolar.addActionListener(this);
        this.ventanaCola.txtDatoDesencolar.setEnabled(false);
        this.ventanaCola.txtDatoEncolar.setEnabled(false);
    }

    public void limpiarCampos() {
        ventanaCola.txtDatoEncolar.setText("");
        ventanaCola.txtDatoDesencolar.setText("");
        ventanaCola.rbtnEncolar.setSelected(false);
        ventanaCola.rbtnDesencolar.setSelected(false);
        ventanaCola.rbtnDesencolarCualquiera.setSelected(false);
        ventanaCola.rbtnMostrarCola.setSelected(false);
        ventanaCola.rbtnTamanioCola.setSelected(false);
        ventanaCola.rbtnVaciar.setSelected(false);
        ventanaCola.rbtnCabeza.setSelected(false);
        ventanaCola.rbtnCola.setSelected(false);
    }

    public void estaSeleccionado(JRadioButton rBoton) {
        if (rBoton == ventanaCola.rbtnEncolar) {
            ventanaCola.rbtnDesencolar.setSelected(false);
            ventanaCola.rbtnDesencolarCualquiera.setSelected(false);
            ventanaCola.rbtnMostrarCola.setSelected(false);
            ventanaCola.rbtnTamanioCola.setSelected(false);
            ventanaCola.rbtnVaciar.setSelected(false);
            ventanaCola.rbtnCabeza.setSelected(false);
            ventanaCola.rbtnCola.setSelected(false);
        } else if (rBoton == ventanaCola.rbtnDesencolar) {
            ventanaCola.rbtnEncolar.setSelected(false);
            ventanaCola.rbtnDesencolarCualquiera.setSelected(false);
            ventanaCola.rbtnMostrarCola.setSelected(false);
            ventanaCola.rbtnTamanioCola.setSelected(false);
            ventanaCola.rbtnVaciar.setSelected(false);
            ventanaCola.rbtnCabeza.setSelected(false);
            ventanaCola.rbtnCola.setSelected(false);
        } else if (rBoton == ventanaCola.rbtnDesencolarCualquiera) {
            ventanaCola.rbtnDesencolar.setSelected(false);
            ventanaCola.rbtnEncolar.setSelected(false);
            ventanaCola.rbtnMostrarCola.setSelected(false);
            ventanaCola.rbtnTamanioCola.setSelected(false);
            ventanaCola.rbtnVaciar.setSelected(false);
            ventanaCola.rbtnCabeza.setSelected(false);
            ventanaCola.rbtnCola.setSelected(false);
        } else if (rBoton == ventanaCola.rbtnMostrarCola) {
            ventanaCola.rbtnDesencolar.setSelected(false);
            ventanaCola.rbtnDesencolarCualquiera.setSelected(false);
            ventanaCola.rbtnEncolar.setSelected(false);
            ventanaCola.rbtnTamanioCola.setSelected(false);
            ventanaCola.rbtnVaciar.setSelected(false);
            ventanaCola.rbtnCabeza.setSelected(false);
            ventanaCola.rbtnCola.setSelected(false);
        } else if (rBoton == ventanaCola.rbtnTamanioCola) {
            ventanaCola.rbtnDesencolar.setSelected(false);
            ventanaCola.rbtnDesencolarCualquiera.setSelected(false);
            ventanaCola.rbtnMostrarCola.setSelected(false);
            ventanaCola.rbtnEncolar.setSelected(false);
            ventanaCola.rbtnVaciar.setSelected(false);
            ventanaCola.rbtnCabeza.setSelected(false);
            ventanaCola.rbtnCola.setSelected(false);
        } else if (rBoton == ventanaCola.rbtnVaciar) {
            ventanaCola.rbtnDesencolar.setSelected(false);
            ventanaCola.rbtnDesencolarCualquiera.setSelected(false);
            ventanaCola.rbtnMostrarCola.setSelected(false);
            ventanaCola.rbtnTamanioCola.setSelected(false);
            ventanaCola.rbtnEncolar.setSelected(false);
            ventanaCola.rbtnCabeza.setSelected(false);
            ventanaCola.rbtnCola.setSelected(false);
        } else if (rBoton == ventanaCola.rbtnCabeza) {
            ventanaCola.rbtnDesencolar.setSelected(false);
            ventanaCola.rbtnDesencolarCualquiera.setSelected(false);
            ventanaCola.rbtnMostrarCola.setSelected(false);
            ventanaCola.rbtnTamanioCola.setSelected(false);
            ventanaCola.rbtnVaciar.setSelected(false);
            ventanaCola.rbtnEncolar.setSelected(false);
            ventanaCola.rbtnCola.setSelected(false);
        } else if (rBoton == ventanaCola.rbtnCola) {
            ventanaCola.rbtnDesencolar.setSelected(false);
            ventanaCola.rbtnDesencolarCualquiera.setSelected(false);
            ventanaCola.rbtnMostrarCola.setSelected(false);
            ventanaCola.rbtnTamanioCola.setSelected(false);
            ventanaCola.rbtnVaciar.setSelected(false);
            ventanaCola.rbtnCabeza.setSelected(false);
            ventanaCola.rbtnEncolar.setSelected(false);
        }
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == ventanaCola.rbtnEncolar) {
            ventanaCola.txtDatoDesencolar.setEnabled(false);
            ventanaCola.txtDatoEncolar.setEnabled(true);
            estaSeleccionado(ventanaCola.rbtnEncolar);
        } else if (event.getSource() == ventanaCola.rbtnDesencolarCualquiera) {
            ventanaCola.txtDatoDesencolar.setEnabled(true);
            ventanaCola.txtDatoEncolar.setEnabled(false);
            estaSeleccionado(ventanaCola.rbtnDesencolarCualquiera);
        } else if (event.getSource() == ventanaCola.rbtnDesencolar) {
            estaSeleccionado(ventanaCola.rbtnDesencolar);
        } else if (event.getSource() == ventanaCola.rbtnCabeza) {
            estaSeleccionado(ventanaCola.rbtnCabeza);
        } else if (event.getSource() == ventanaCola.rbtnCola) {
            estaSeleccionado(ventanaCola.rbtnCola);
        } else if (event.getSource() == ventanaCola.rbtnMostrarCola) {
            estaSeleccionado(ventanaCola.rbtnMostrarCola);
        } else if (event.getSource() == ventanaCola.rbtnTamanioCola) {
            estaSeleccionado(ventanaCola.rbtnTamanioCola);
        } else if (event.getSource() == ventanaCola.rbtnVaciar) {
            estaSeleccionado(ventanaCola.rbtnVaciar);
        }
        if (event.getSource() == ventanaCola.btnEjecutar) {
            if (ventanaCola.rbtnEncolar.isSelected()) {
                try {
                    int dato = Integer.parseInt(ventanaCola.txtDatoEncolar.getText());
                    cola.insertarInicio(dato);
                    limpiarCampos();
                    String datos = cola.mostrarCola();
                    ventanaCola.txtDatosCola.setText(datos);
                    JOptionPane.showMessageDialog(null, "El dato " + dato + " fue insertado exitosamente.");
                    ventanaCola.txtDatoEncolar.setEnabled(false);
                } catch (Exception e) {
                    limpiarCampos();
                    JOptionPane.showMessageDialog(null, "Falló al insertar el elemento.");
                }
            } else if (ventanaCola.rbtnDesencolar.isSelected()) {
                try {
                    int dato = cola.extraer();
                    limpiarCampos();
                    String datos = cola.mostrarCola();
                    ventanaCola.txtDatosCola.setText(datos);
                    JOptionPane.showMessageDialog(null, "El dato " + dato + " fue desencolado exitosamente.");
                } catch (Exception e) {
                    limpiarCampos();
                    JOptionPane.showMessageDialog(null, "Error al desencolar el elemento.");
                }
            } else if (ventanaCola.rbtnDesencolarCualquiera.isSelected()){
                try {
                    int dato = Integer.parseInt(ventanaCola.txtDatoDesencolar.getText());
                    cola.extrer(dato);
                    limpiarCampos();
                    String datos = cola.mostrarCola();
                    ventanaCola.txtDatosCola.setText(datos);
                    JOptionPane.showMessageDialog(null, "Los datos fueron desencolados.");
                    ventanaCola.txtDatoDesencolar.setEnabled(false);
                } catch (Exception e) {
                    limpiarCampos();
                    JOptionPane.showMessageDialog(null, "Error al desencolar los elementos.");
                }
            } else if (ventanaCola.rbtnVaciar.isSelected()){
                try {
                    cola.vaciarCola();
                    limpiarCampos();
                    ventanaCola.txtDatosCola.setText("Cola vacía.");
                } catch (Exception e) {
                    limpiarCampos();
                    JOptionPane.showMessageDialog(null, "Error al vaciar cola.");
                }
            } else if (ventanaCola.rbtnTamanioCola.isSelected()){
                try {
                    int tamanio = cola.tamanioCola();
                    limpiarCampos();
                    ventanaCola.txtDatosCola.setText("El tamaño de la cola es de " + tamanio + ".");
                } catch (Exception e) {
                    limpiarCampos();
                    JOptionPane.showMessageDialog(null, "Error al solicitar el tamaño de la cola.");
                }
            } else if (ventanaCola.rbtnCabeza.isSelected()){
                try {
                    int cabeza = cola.mostrarCabeza();
                    limpiarCampos();
                    ventanaCola.txtDatosCola.setText("La cabeza de la cola es " + cabeza + ".");
                } catch (Exception e) {
                    limpiarCampos();
                    JOptionPane.showMessageDialog(null, "Error al solicitar la cabeza de la cola.");
                }
            } else if (ventanaCola.rbtnCola.isSelected()){
                try {
                    int ultimo = cola.mostrarUltimoValor();
                    limpiarCampos();
                    ventanaCola.txtDatosCola.setText("La cola de la cola es " + ultimo + ".");
                } catch (Exception e) {
                    limpiarCampos();
                    JOptionPane.showMessageDialog(null, "Error al solicitar la cola de la cola.");
                }
            } else if (ventanaCola.rbtnMostrarCola.isSelected()){
                try {
                    String datos = cola.mostrarCola();
                    limpiarCampos();
                    ventanaCola.txtDatosCola.setText(datos);
                } catch (Exception e) {
                    limpiarCampos();
                    JOptionPane.showMessageDialog(null, "Error al mostrar los datos de la cola.");
                }
            }
        }
    }
}
