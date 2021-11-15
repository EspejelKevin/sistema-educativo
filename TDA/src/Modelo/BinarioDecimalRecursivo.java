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
public class BinarioDecimalRecursivo {
    
    public int aDecimal(String binario) {
        return aDecimalAux(binario, 0, 0);
    }

    public int aDecimalAux(String binario, int numero, int exponente) {
        if (binario.length() != 0) {
            int digito = binario.charAt(binario.length() - 1)  == '0' ? 0 : 1;
            numero += digito == 1 ? (int) Math.pow(2, exponente) : 0;
            return aDecimalAux(binario.substring(0, binario.length() - 1), numero, exponente + 1);
        } 

        return numero;
    }
}
