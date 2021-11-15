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
public class SerieUnoIterativo {
    
    private int num;
    private double res;

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
    
    public double serieUno(){
        for(int i = 1; i<=this.num; i++){
            double aux = i;
            res += 1/aux;
            res = Math.round(res*100.0)/100.0;
        }
        return res;
    }
}
