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
    
    public ControlSistema(){
        
    }
    
    public ControlSistema(PanelControl ventanaPrincipal, Iterativos ventanaIterativos, 
                          ListaEnlazada ventanaListaEnlazada, Recursivos ventanaRecursivos,
                          ListaEnlazadaBD ventanaListaEnlazadaBD){
        this.ventanaPrincipal = ventanaPrincipal;
        this.ventanaIterativos = ventanaIterativos;
        this.ventanaRecursivos = ventanaRecursivos;
        this.ventanaListaEnlazada = ventanaListaEnlazada;
        this.ventanaListaEnlazadaBD = ventanaListaEnlazadaBD;
        this.ventanaPrincipal.menuItemIterativos.addActionListener(this);
        this.ventanaPrincipal.menuItemRecursivos.addActionListener(this);
        this.ventanaPrincipal.menuItemListaEnlazada.addActionListener(this);
        this.ventanaPrincipal.menuItemSalir.addActionListener(this);
        this.ventanaPrincipal.menuItemListaEnlazadaBD.addActionListener(this);
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
        }
    }
}
