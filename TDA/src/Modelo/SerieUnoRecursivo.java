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
public class SerieUnoRecursivo {
    
    public double serieUno(double n){
        if(n==1) return 1/n;
        else return 1/n + serieUno(n-1);
    }
}
