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
public class FactorialIterativo {

    private int num;
    private int fac = 1;

    public int getFac() {
        return fac;
    }

    public void setFac(int fac) {
        this.fac = fac;
    }
    
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int facIterativo() {
        for(int i = 1; i<=this.num; i++){
            this.fac *= i;
        }
        return this.fac;
    }

}
