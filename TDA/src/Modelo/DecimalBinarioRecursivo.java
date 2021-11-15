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
public class DecimalBinarioRecursivo {
    
    public String decimalBinarioRecu(int decimal){
        if(decimal == 0){
            return "";
        }else{
            return decimalBinarioRecu(decimal/2) + String.valueOf(decimal%2);
        }
    }
}
