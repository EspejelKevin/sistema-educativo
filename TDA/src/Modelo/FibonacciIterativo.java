/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javax.swing.JOptionPane;

/**
 *
 * @author kevin
 */
public class FibonacciIterativo {
    
    private int x=0;
    private int y=1;
    private int num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
    
    public void fiboIterativo(){
        String a = "0 1 1";
        for(int i = 0; i<this.num; i++){
            int aux = x;
            x = y;
            y = aux + y;
            if(aux != 0){
                a += " ";
                a += Integer.toString(y);
            }
        }
        JOptionPane.showMessageDialog(null, "Serie fibonacci: "+a);
    }
}
