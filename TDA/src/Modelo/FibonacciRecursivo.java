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
public class FibonacciRecursivo {
    
    private int x=0;
    private int y=1;
    private int aux;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getAux() {
        return aux;
    }

    public void setAux(int aux) {
        this.aux = aux;
    }
    
    public int fibo(int n){
        aux = x;
        x = y;
        y = aux + y;
        if(n==0) return x;
        else return fibo(n-1);
        
    }
}
