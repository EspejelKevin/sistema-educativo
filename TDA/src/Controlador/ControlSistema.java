/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.Iterativos;
import Vista.ListaEnlazada;
import Vista.ListaEnlazadaBD;
import Vista.PanelControl;
import Vista.Recursivos;
import Vista.ColaVista;
import Vista.PilaVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author kevin
 */
public class ControlSistema implements ActionListener{
    
    private PanelControl ventanaPrincipal;
    private Iterativos ventanaIterativos;
    private Recursivos ventanaRecursivos;
    private ListaEnlazada ventanaListaEnlazada;
    private ListaEnlazadaBD ventanaListaEnlazadaBD;
    private ColaVista ventanaCola;
    private PilaVista ventanaPila;
    
    public ControlSistema(){
        
    }
    
    public ControlSistema(PanelControl ventanaPrincipal, Iterativos ventanaIterativos, 
                          ListaEnlazada ventanaListaEnlazada, Recursivos ventanaRecursivos,
                          ListaEnlazadaBD ventanaListaEnlazadaBD, ColaVista ventanaCola, PilaVista ventanaPila){
        this.ventanaPrincipal = ventanaPrincipal;
        this.ventanaIterativos = ventanaIterativos;
        this.ventanaRecursivos = ventanaRecursivos;
        this.ventanaListaEnlazada = ventanaListaEnlazada;
        this.ventanaListaEnlazadaBD = ventanaListaEnlazadaBD;
        this.ventanaCola = ventanaCola;
        this.ventanaPila = ventanaPila;
        this.ventanaPrincipal.menuItemIterativos.addActionListener(this);
        this.ventanaPrincipal.menuItemRecursivos.addActionListener(this);
        this.ventanaPrincipal.menuItemListaEnlazada.addActionListener(this);
        this.ventanaPrincipal.menuItemSalir.addActionListener(this);
        this.ventanaPrincipal.menuItemListaEnlazadaBD.addActionListener(this);
        this.ventanaPrincipal.menuItemCola.addActionListener(this);
        this.ventanaPrincipal.menuItemPila.addActionListener(this);
    }
    
    public void iniciar() {
        ventanaPrincipal.setLocationRelativeTo(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent event){
        if (event.getSource() == ventanaPrincipal.menuSalir){
            System.exit(0);
        }else if(event.getSource() == ventanaPrincipal.menuItemSalir){
            System.exit(0);
        }else if(event.getSource() == ventanaPrincipal.menuItemIterativos){
            ventanaPrincipal.dpEscritorio.add(ventanaIterativos);
            ventanaIterativos.show();
        }else if(event.getSource() == ventanaPrincipal.menuItemRecursivos){
            ventanaPrincipal.dpEscritorio.add(ventanaRecursivos);
            ventanaRecursivos.show();
        }else if(event.getSource() == ventanaPrincipal.menuItemListaEnlazada){
            ventanaPrincipal.dpEscritorio.add(ventanaListaEnlazada);
            ventanaListaEnlazada.show();
        }else if(event.getSource() == ventanaPrincipal.menuItemListaEnlazadaBD){
            ventanaPrincipal.dpEscritorio.add(ventanaListaEnlazadaBD);
            ventanaListaEnlazadaBD.show();
        }else if(event.getSource() == ventanaPrincipal.menuItemCola){
            ventanaPrincipal.dpEscritorio.add(ventanaCola);
            ventanaCola.show();
        }else if(event.getSource() == ventanaPrincipal.menuItemPila){
            ventanaPrincipal.dpEscritorio.add(ventanaPila);
            ventanaPila.show();
        }
    }
}
