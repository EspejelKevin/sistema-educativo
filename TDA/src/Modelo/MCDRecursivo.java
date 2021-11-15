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
public class MCDRecursivo {
    
    public int mcd(int num1, int num2){
        int residuo = num1%num2;
        if(residuo == 0) return num2;
        else return mcd(num2, residuo);
    }
}
