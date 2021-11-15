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
public class PalabraIterativo {
    
    private String wordInput;
    private String wordOut="";

    public String getWordInput() {
        return wordInput;
    }

    public void setWordInput(String wordInput) {
        this.wordInput = wordInput;
    }

    public String getWordOut() {
        return wordOut;
    }

    public void setWordOut(String wordOut) {
        this.wordOut = wordOut;
    }
    
    public String palabraItera(){
        for(int i = wordInput.length(); i > 0; i--){
            wordOut += wordInput.charAt(i-1);
        }
        
        return wordOut;
    }
}
