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
public class SerieDosRecursivo {
    
    public double serieDos(double n){
        if(n==1) return n/factorial(n*2);
        else return n/factorial(n*2) + serieDos(n-1);
    }
    public double factorial(double n){
        if(n==0) return 1;
        else return n * factorial(n-1);
    }
}
