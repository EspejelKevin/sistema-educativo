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
public class MultiIterativo {
    
    private int multiplicador;
    private int multiplicando;
    private boolean stop=false;
    private int suma;

    public int getMultiplicador() {
        return multiplicador;
    }

    public void setMultiplicador(int multiplicador) {
        this.multiplicador = multiplicador;
    }

    public int getMultiplicando() {
        return multiplicando;
    }

    public void setMultiplicando(int multiplicando) {
        this.multiplicando = multiplicando;
    }

    public boolean isStop() {
        return stop;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }

    public int getSuma() {
        return suma;
    }

    public void setSuma(int suma) {
        this.suma = suma;
    }
    
    public int multiplicacion(){
        while(!stop){
            if(multiplicador % 2 != 0){
                suma += multiplicando;
            }
            multiplicador = multiplicador/2;
            multiplicando = multiplicando * 2;
            if (multiplicador < 1){
                stop = true;
            }
        }
        return suma;
    }
}
