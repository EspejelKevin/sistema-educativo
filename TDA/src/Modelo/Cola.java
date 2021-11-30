/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


/**
 *
 * @author kevin
 */
public class Cola extends ListaEnlazadaSimple{
    
    private Nodo inicioCola, finalCola;
    private int tamanio;
    private String cola = "";
    
    public Cola(){
        inicioCola = finalCola = null;
        tamanio = 0;
    }
    
    public boolean colaVacia(){
        return inicioCola == null;
    }
    
    @Override
    public void insertarInicio(Object dato){
        Nodo nuevo = new Nodo(dato, this.primero);
        if(colaVacia()){
            inicioCola = finalCola = nuevo;
            tamanio++;
        }else{
            finalCola.setSiguiente(nuevo);
            finalCola = nuevo;
            tamanio++;
        }
    }
    
    public int extraer(){
        if(!colaVacia()){
            int dato = (int)inicioCola.getDato();
            if(inicioCola == finalCola){
                inicioCola = finalCola = null;
                tamanio--;
            }else{
                inicioCola = inicioCola.getSiguiente();
                tamanio--;
            }
            return dato;
        }else{
            return Integer.MAX_VALUE;
        }
    }
    
    public void extrer(Object dato){
        Nodo recorrido = inicioCola;
        
        while(recorrido != null){
            if((int)dato != (int)recorrido.getDato()){
                extraer();
            }else{
                extraer();
                return;
            }
            recorrido = recorrido.getSiguiente();
        }
    }
    
    public void vaciarCola(){
        while(!colaVacia()){
            extraer();
        }
    }
    
    public int tamanioCola(){
        return tamanio;
    }
    
    public int mostrarUltimoValor(){
        return (int)finalCola.getDato();
    }
    
    public int mostrarCabeza(){
        return (int)inicioCola.getDato();
    }
    
    public String mostrarCola(){
        Nodo recorrido = inicioCola;
        String colaInvertida = "";
        
        while(recorrido != null){
            cola += recorrido.getDato() + " "; // 10  20   30  40
            recorrido = recorrido.getSiguiente();
        }
        
        String cadena [] = cola.split(" "); // [10, 20, 30, 40]
        
        for(int i = cadena.length - 1; i >= 0; i--){
            colaInvertida += " " + cadena[i]; // 40 30 20 10
        }
        cola = "";
        return colaInvertida;
    }
}
