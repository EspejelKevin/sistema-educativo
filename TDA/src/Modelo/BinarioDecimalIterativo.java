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
public class BinarioDecimalIterativo {
    
    private String binario=" ";
    private int decimal;
    private int exponente;

    public String getBinario() {
        return binario;
    }

    public void setBinario(String binario) {
        this.binario = binario;
    }

    public int getDecimal() {
        return decimal;
    }

    public void setDecimal(int decimal) {
        this.decimal = decimal;
    }

    public int getExponente() {
        return exponente;
    }

    public void setExponente(int exponente) {
        this.exponente = exponente;
    }
    
    public int binarioDecimal(){
        for(int caracter=0; caracter<binario.length(); caracter++){
            int numero_bi = Character.getNumericValue(binario.charAt(caracter));
            decimal +=  numero_bi * Math.pow(2, exponente);
            exponente -= 1;
        }
        return decimal;
    }
    
    /*public static void main(String[] args) {
        BinarioDecimalIterativo b = new BinarioDecimalIterativo();
        b.setBinario("1010");
        b.setExponente(b.getBinario().length()-1);
        System.out.println(b.binarioDecimal());
    }*/
}
