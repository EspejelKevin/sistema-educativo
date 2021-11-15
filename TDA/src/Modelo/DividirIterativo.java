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
public class DividirIterativo {
    
    private double num;

    public double getNum() {
        return num;
    }

    public void setNum(double num) {
        this.num = num;
    }
    
    public double dividirTres(){
        while(num>1){
            num = num/3;
        }
        return redondearDecimales(num, 4);
    }
    
    public static double redondearDecimales(double valorInicial, int numeroDecimales) {
        double parteEntera, resultado;
        resultado = valorInicial;
        parteEntera = Math.floor(resultado);
        resultado = (resultado - parteEntera) * Math.pow(10, numeroDecimales);
        resultado = Math.round(resultado);
        resultado = (resultado / Math.pow(10, numeroDecimales)) + parteEntera;
        return resultado;
    }
}
