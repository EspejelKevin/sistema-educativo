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
public class ListaEnlazadaSimple {

    public Nodo primero;
    private int numElementos;

    public ListaEnlazadaSimple() {
        this.primero = null;
        this.numElementos = 0;
    }

    public void insertarInicio(Object dato) {
        Nodo nuevo = new Nodo(dato, this.primero); // 
        this.primero = nuevo;
        numElementos++;
    }

    public void insertarFinal(Object dato) {
        Nodo nuevo = new Nodo(dato, null);
        if (this.primero == null) { // no hay nodos en la lista
            this.primero = nuevo;
        } else {
            Nodo actual = this.primero;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
                //actual = nodo 4
            }
            actual.setSiguiente(nuevo);
            numElementos++;
        }
    }

    public void insertarCualquierPosicion(Object testigo, Object dato) {
        Nodo nuevo, anterior;
        anterior = buscarElemento(testigo);
        if (anterior != null) {
            nuevo = new Nodo(dato, null);
            nuevo.setSiguiente(anterior.getSiguiente());
            anterior.setSiguiente(nuevo);
            numElementos++;
        }
    }

    public Nodo buscarElemento(Object dato) {
        Nodo indice;
        for (indice = this.primero; indice != null; indice = indice.getSiguiente()) {
            if (dato == indice.getDato()) {
                return indice;
            }
        }
        return null;
    }

    public Nodo buscarPosicion(int posicion) {
        Nodo indice;
        int i;
        if (posicion < 0) {
            return null;
        }
        indice = this.primero;
        for (i = 1; (i < posicion) && (indice != null); i++) {
            indice = indice.getSiguiente();
        }
        return indice;
    }

    public void ordenarLista() {
        Nodo actual;
        int tem, t = 1;
        do {
            actual = this.primero;
            Nodo siguiente = actual.getSiguiente();
            while (actual.getSiguiente() != null) {
                if ((int) actual.getDato() > (int) siguiente.getDato()) {
                    tem = (int) actual.getDato();

                    actual.setDato(siguiente.getDato());

                    siguiente.setDato(tem);

                    actual = actual.getSiguiente();
                    siguiente = siguiente.getSiguiente();

                } else {
                    actual = actual.getSiguiente();
                    siguiente = siguiente.getSiguiente();
                }
            }
            t++;
        } while (t <= numElementos);
    }

    public void eliminar(Object dato) {
        Nodo actual = this.primero, anterior = null;
        boolean encontrado = false;
        while (actual != null && !encontrado) {
            encontrado = actual.getDato() == dato;
            if (!encontrado) {
                anterior = actual;
                actual = actual.getSiguiente();
            }
        }
        if (actual != null) {
            if (actual == this.primero) {
                this.primero = actual.getSiguiente();
                numElementos--;
            } else {
                numElementos--;
                anterior.setSiguiente(actual.getSiguiente());
            }
        }
    }

    public int eliminarInicio() {
        int auxiliar = (int) this.primero.getDato();
        this.primero = this.primero.getSiguiente();
        numElementos--;
        return auxiliar;
    }

    public void eliminarFinal() {
        Nodo actual = this.primero, anterior;
        while (actual != null) {
            anterior = actual;
            actual = actual.getSiguiente();

            if (actual.getSiguiente() == null) {
                anterior.setSiguiente(actual.getSiguiente());
                numElementos--;
                return;
            }
        }
    }

    public String listar() {
        String salida="";
        try {
            Nodo actual = this.primero;
            while (actual.getSiguiente() != null) {
                salida+=actual.getDato()+"     ";
                actual = actual.getSiguiente();   
            }
            salida+=actual.getDato();
        } catch (Exception e) {
            salida = "No has insertado elementos";
        }
        return salida; // 10     5
    }

    public int tamanioLista() {
        return numElementos;
    }
    
    public static void main(String[] args) {
        ListaEnlazadaSimple l = new ListaEnlazadaSimple();
        l.insertarCualquierPosicion(0, 5);
        

        System.out.println(l.listar());
    }
}
