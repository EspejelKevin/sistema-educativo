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
public class PalabraRecursivo {
    
    public String reversedWord(String wordIn, int length, String wordOut){
        String wordO = wordOut;
        if(length != 0){
            wordO += wordIn.charAt(length-1);
            return reversedWord(wordIn, length-1, wordO);
        }else{
            return wordO;
        }
    }
}
