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
public class MCDIterativo {
    
    private int num1;
    private int num2;
    private int residuo;
    private boolean stop = false;

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public int getResiduo() {
        return residuo;
    }

    public void setResiduo(int residuo) {
        this.residuo = residuo;
    }

    public boolean isStop() {
        return stop;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }
    
    public int mcd(){
        while(!stop){
            residuo = num1 % num2;
            num1 = num2;
            num2 = residuo;
            if (residuo == 0)stop = true;
        }
        return num1;
    }
}
