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
public class MultiRecursivo {
    
    private double suma;

    public double getSuma() {
        return suma;
    }

    public void setSuma(double suma) {
        this.suma = suma;
    }
    
    public int multi(int num1, int num2, int suma){
        if(num1 % 2 != 0) suma+=num2;
        num1 = (num1/2);
        num2 = num2*2;
        if (num1 < 1) return suma;
        return multi(num1, num2, suma);
    }
}
