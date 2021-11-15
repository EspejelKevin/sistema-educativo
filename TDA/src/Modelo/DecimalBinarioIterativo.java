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
public class DecimalBinarioIterativo {
    
    private int decimal;
    private boolean parada = false;
    private String binario = "";

    public int getDecimal() {
        return decimal;
    }

    public void setDecimal(int decimal) {
        this.decimal = decimal;
    }

    public boolean isParada() {
        return parada;
    }

    public void setParada(boolean parada) {
        this.parada = parada;
    }

    public String getBinario() {
        return binario;
    }

    public void setBinario(String binario) {
        this.binario = binario;
    }
    
    public String decimalBinario(){
        while(!parada){
            String resto = String.valueOf(decimal%2);
            decimal = decimal / 2;
            binario += resto;
            if(decimal<=0){
                parada = true;
            }
        }
        return reversedWord(binario, binario.length(), "");
    }
    
    public String reversedWord(String wordIn, int length, String wordOut){
        String wordO = wordOut;
        if(length != 0){
            wordO += wordIn.charAt(length-1);
            return reversedWord(wordIn, length-1, wordO);
        }else{
            return wordO;
        }
    }
}
