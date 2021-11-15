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
public class PasswordIterativo {
    
    private String pass;
    private String resultado="";
    private String numeros [] = {"0","1","2","3","4","5","6","7","8","9"};

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
    
    public String contieneNumero(){
        for(int num=0; num<numeros.length; num++){
            if(pass.contains(numeros[num])){
                resultado += numeros[num]+" ";
            }
        }
        return resultado;
    }
}
