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
public class Pila extends ListaEnlazadaSimple{
    
    private Nodo ultimo;
    int tamanio = 0;
    String pila = "";
    
    public Pila(){
        ultimo = null;
        tamanio = 0;
    }
    
    public boolean pilaVacia(){
        return ultimo == null;
    }
    
    
    @Override
    public void insertarInicio(Object dato){
        Nodo nuevo = new Nodo(dato, ultimo);
        ultimo = nuevo;
        tamanio++;
    }
    
    
    @Override
    public int eliminarInicio(){
        int auxiliar = (int)ultimo.getDato();
        ultimo = ultimo.getSiguiente();
        tamanio--;
        return auxiliar;
    }
    
    @Override
    public void eliminar(Object dato){
        Nodo recorrido = ultimo;
        while(recorrido != null){
            if((int)recorrido.getDato()!= (int)dato){
                eliminarInicio();
                
                recorrido = recorrido.getSiguiente();
            }else{
                eliminarInicio();
                
                return;
            }
        }
    }
    
    public int mostrarUltimoValor(){
        return (int)ultimo.getDato();
    }
    
    
    public int tamanioPila(){
        return tamanio;
    }
    
    
    public void vaciarPila(){
        while(!pilaVacia()){
            eliminarInicio();
        }
    }
    
    
    public String mostrarPila(){
        Nodo recorrido = ultimo;
        while(recorrido != null){
            pila += "\t  " + recorrido.getDato() + "\n";
            recorrido = recorrido.getSiguiente();
        }
        String pilaDatos = pila;
        pila = "";
        return pilaDatos;
    }
}
