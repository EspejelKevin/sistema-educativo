/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import Controlador.ControlSistema;
import Controlador.CtrlCola;
import Controlador.CtrlIterativos;
import Controlador.CtrlListaEnlazada;
import Controlador.CtrlPila;
import Controlador.CtrlRecursivos;
import Modelo.BinarioDecimalIterativo;
import Modelo.BinarioDecimalRecursivo;
import Modelo.Cola;
import Modelo.DecimalBinarioIterativo;
import Modelo.DecimalBinarioRecursivo;
import Modelo.DividirIterativo;
import Modelo.DividirRecursivo;
import Modelo.FactorialIterativo;
import Modelo.FactorialRecursivo;
import Modelo.FibonacciIterativo;
import Modelo.FibonacciRecursivo;
import Modelo.ListaEnlazadaSimple;
import Modelo.MCDIterativo;
import Modelo.MCDRecursivo;
import Modelo.MultiIterativo;
import Modelo.MultiRecursivo;
import Modelo.PalabraIterativo;
import Modelo.PalabraRecursivo;
import Modelo.PasswordIterativo;
import Modelo.PasswordRecursivo;
import Modelo.Pila;
import Modelo.SerieDosIterativo;
import Modelo.SerieDosRecursivo;
import Modelo.SerieUnoIterativo;
import Modelo.SerieUnoRecursivo;
import Modelo.SqlProductos;
import Vista.ColaVista;
import Vista.Iterativos;
import Vista.ListaEnlazada;
import Vista.ListaEnlazadaBD;
import Vista.PanelControl;
import Vista.PilaVista;
import Vista.Recursivos;

/**
 *
 * @author kevin
 */
public class Main {
    public static void main(String[] args) {
        
        FactorialIterativo factorialIterativo = new FactorialIterativo();
        FibonacciIterativo fiboIterativo = new FibonacciIterativo();
        SerieUnoIterativo serieUnoI = new SerieUnoIterativo();
        SerieDosIterativo serieDos = new SerieDosIterativo();
        MCDIterativo mcd = new MCDIterativo();
        MultiIterativo multi = new MultiIterativo();
        PalabraIterativo palabraIterativo = new PalabraIterativo();
        DividirIterativo dividirIterativo = new DividirIterativo();
        DecimalBinarioIterativo decBinaItera = new DecimalBinarioIterativo();
        BinarioDecimalIterativo biDecItera = new BinarioDecimalIterativo();
        PasswordIterativo passItera = new PasswordIterativo();
        FactorialRecursivo factorialRecursivo = new FactorialRecursivo();
        FibonacciRecursivo fiboRecursivo = new FibonacciRecursivo();
        SerieUnoRecursivo serieUnoR = new SerieUnoRecursivo();
        SerieDosRecursivo serieDosR = new SerieDosRecursivo();
        MCDRecursivo mcdR = new MCDRecursivo();
        MultiRecursivo multiR = new MultiRecursivo();
        PalabraRecursivo palabraRecursivo = new PalabraRecursivo();
        DividirRecursivo dividirRecu = new DividirRecursivo();
        DecimalBinarioRecursivo decBinRecu = new DecimalBinarioRecursivo();
        BinarioDecimalRecursivo biDecRecu = new BinarioDecimalRecursivo();
        PasswordRecursivo passRecu = new PasswordRecursivo();
        Iterativos ventanaIterativos = new Iterativos();
        ListaEnlazadaSimple listaEnlazada = new ListaEnlazadaSimple();
        Cola cola = new Cola();
        Pila pila = new Pila();
        PanelControl ventanaPrincipal = new PanelControl();
        Recursivos ventananaRecursivos = new Recursivos();
        ListaEnlazada ventanaListaEnlazada = new ListaEnlazada();
        ListaEnlazadaBD ventanaListaEnlazadaBD = new ListaEnlazadaBD();
        ColaVista colaVista = new ColaVista();
        PilaVista pilaVista = new PilaVista();
        SqlProductos productos = new SqlProductos();
        
        ControlSistema sistema = new ControlSistema(ventanaPrincipal,ventanaIterativos, 
                                                    ventanaListaEnlazada, ventananaRecursivos, ventanaListaEnlazadaBD, colaVista, pilaVista);
        CtrlIterativos iterativosCtrl = new CtrlIterativos(factorialIterativo, fiboIterativo, 
                                                               serieUnoI, serieDos, mcd, 
                                                               multi, palabraIterativo, dividirIterativo,
                                                               decBinaItera, biDecItera, 
                                                               passItera, ventanaIterativos){};
        CtrlRecursivos recursivosCtrl = new CtrlRecursivos(factorialRecursivo, fiboRecursivo, 
                                                           serieUnoR, serieDosR, mcdR, multiR,
                                                           palabraRecursivo, dividirRecu,
                                                           decBinRecu, biDecRecu,
                                                           passRecu, ventananaRecursivos) {};
        
        CtrlListaEnlazada listaEnlazadaCtrl = new CtrlListaEnlazada(listaEnlazada, ventanaListaEnlazada, 
                                                                    ventanaListaEnlazadaBD, productos) {};
        
        CtrlCola ctrlCola = new CtrlCola(cola, colaVista) {};
        
        CtrlPila ctrlPila = new CtrlPila(pila, pilaVista) {};
        
        sistema.iniciar();
        ventanaPrincipal.setVisible(true);
        
    }
}
