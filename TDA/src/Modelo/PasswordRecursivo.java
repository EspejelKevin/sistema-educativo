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
public class PasswordRecursivo {
    
    public boolean contieneNumeroRecu(String pass, int lenPass){
        String numeros [] = {"0","1","2","3","4","5","6","7","8","9"};
        if(lenPass != 0){
            for(String numero:numeros){
                if(pass.contains(numero)){
                    return true;
                }
            }
        }else{
            contieneNumeroRecu(pass, lenPass-1);
        }
        return false;
    }
}
