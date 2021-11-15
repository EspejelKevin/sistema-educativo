/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.text.DecimalFormat;

/**
 *
 * @author kevin
 */
public class SerieDosIterativo {

    private int num;
    private double res = 0;
    private int fac;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getRes() {
        return res;
    }

    public void setRes(double res) {
        this.res = res;
    }

    public int getFac() {
        return fac;
    }

    public void setFac(int fac) {
        this.fac = fac;
    }

    public double serieDos() {
        for (int i = 1; i <= this.num; i++) {
            fac = 1;
            for (int j = 1; j < (i * 2 + 1); j++) {
                fac *= j;
            }
            double a = i;
            res += a / fac;
            DecimalFormat d = new DecimalFormat("##.##");
            d.format(res);
        }
        return redondearDecimales(res, 4);
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
