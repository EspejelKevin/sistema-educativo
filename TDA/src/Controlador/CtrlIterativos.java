/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.BinarioDecimalIterativo;
import Modelo.DecimalBinarioIterativo;
import Modelo.DividirIterativo;
import Modelo.FactorialIterativo;
import Modelo.FibonacciIterativo;
import Modelo.MCDIterativo;
import Modelo.MultiIterativo;
import Modelo.PalabraIterativo;
import Modelo.PasswordIterativo;
import Modelo.SerieDosIterativo;
import Modelo.SerieUnoIterativo;
import Vista.Iterativos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author kevin
 */
public abstract class CtrlIterativos implements ActionListener {

    private FactorialIterativo factorialIterativo;
    private FibonacciIterativo fiboIterativo;
    private SerieUnoIterativo serieUno;
    private SerieDosIterativo serieDos;
    private MCDIterativo mcd;
    private MultiIterativo multi;
    private Iterativos ventanaIterativos;
    private PalabraIterativo palabraIterativo;
    private DividirIterativo dividirIterativo;
    private DecimalBinarioIterativo decBinaItera;
    private BinarioDecimalIterativo biDecItera;
    private PasswordIterativo passItera;
    
    public CtrlIterativos(FactorialIterativo factorialIterativo, FibonacciIterativo fiboIterativo,
            SerieUnoIterativo serieUno, SerieDosIterativo serieDos,
            MCDIterativo mcd, MultiIterativo multi, PalabraIterativo palabraIterativo, DividirIterativo dividirIterativo,
            DecimalBinarioIterativo decBinaItera, BinarioDecimalIterativo biDecItera, 
            PasswordIterativo passItera, Iterativos ventanaIterativos) {
        this.factorialIterativo = factorialIterativo;
        this.fiboIterativo = fiboIterativo;
        this.serieUno = serieUno;
        this.serieDos = serieDos;
        this.mcd = mcd;
        this.multi = multi;
        this.palabraIterativo = palabraIterativo;
        this.dividirIterativo = dividirIterativo;
        this.decBinaItera = decBinaItera;
        this.biDecItera = biDecItera;
        this.passItera = passItera;
        this.ventanaIterativos = ventanaIterativos;
        this.ventanaIterativos.btnIterativoFactorial.addActionListener(this);
        this.ventanaIterativos.btnIterativoFibo.addActionListener(this);
        this.ventanaIterativos.btnIterativoSerie1.addActionListener(this);
        this.ventanaIterativos.btnIterativoSerie2.addActionListener(this);
        this.ventanaIterativos.btnIterativoMCD.addActionListener(this);
        this.ventanaIterativos.btnIterativoMulti.addActionListener(this);
        this.ventanaIterativos.btnIterativoReves.addActionListener(this);
        this.ventanaIterativos.btnIterativoDividir.addActionListener(this);
        this.ventanaIterativos.btnIterativoDecABi.addActionListener(this);
        this.ventanaIterativos.btnIterativoBiADec.addActionListener(this);
        this.ventanaIterativos.btnIterativoPass.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == ventanaIterativos.btnIterativoFactorial) {
            int n = Integer.parseInt(JOptionPane.showInputDialog("Digite un n??mero para obtener su factorial"));
            factorialIterativo.setNum(n);
            int factorial = factorialIterativo.facIterativo();
            factorialIterativo.setFac(1);
            JOptionPane.showMessageDialog(null, "El factorial de " + n + " es " + factorial);
        } else if (event.getSource() == ventanaIterativos.btnIterativoFibo) {
            int n = Integer.parseInt(JOptionPane.showInputDialog("Digite un n??mero (l??mite de la serie Fibonacci)"));
            fiboIterativo.setNum(n);
            fiboIterativo.fiboIterativo();
            fiboIterativo.setY(1);
            fiboIterativo.setX(0);
        } else if (event.getSource() == ventanaIterativos.btnIterativoSerie1) {
            int n = Integer.parseInt(JOptionPane.showInputDialog("Digite un n??mero (l??mite de la serie)"));
            serieUno.setNum(n);
            double resultado = serieUno.serieUno();
            serieUno.setRes(0);
            JOptionPane.showMessageDialog(null, "Resultado de la serie uno es: " + resultado);
        } else if (event.getSource() == ventanaIterativos.btnIterativoSerie2) {
            int n = Integer.parseInt(JOptionPane.showInputDialog("Digite un n??mero (l??mite de la serie)"));
            serieDos.setNum(n);
            double resultado = serieDos.serieDos();
            serieDos.setRes(0);
            JOptionPane.showMessageDialog(null, "Resultado de la serie dos es: " + resultado);
        } else if (event.getSource() == ventanaIterativos.btnIterativoMCD) {
            int num1 = Integer.parseInt(JOptionPane.showInputDialog("Digite el primer n??mero"));
            int num2 = Integer.parseInt(JOptionPane.showInputDialog("Digite el segundo n??mero"));
            mcd.setNum1(num1);
            mcd.setNum2(num2);
            int resultado = mcd.mcd();
            mcd.setStop(false);
            JOptionPane.showMessageDialog(null, "El M.C.D de "+num1+" y "+num2+" es: "+resultado);
        } else if(event.getSource() == ventanaIterativos.btnIterativoMulti){
            int num1 = Integer.parseInt(JOptionPane.showInputDialog("Digite el primer n??mero (multiplicador)"));
            int num2 = Integer.parseInt(JOptionPane.showInputDialog("Digite el segundo n??mero (multiplicando)"));
            multi.setMultiplicador(num1);
            multi.setMultiplicando(num2);
            int resultado = multi.multiplicacion();
            multi.setStop(false);
            multi.setMultiplicador(0);
            multi.setMultiplicando(0);
            multi.setSuma(0);
            JOptionPane.showMessageDialog(null, "El producto de "+num1+" y "+num2+" es: "+resultado);
        } else if(event.getSource() == ventanaIterativos.btnIterativoReves){
            String palabra=JOptionPane.showInputDialog("Digite una palabra");
            palabraIterativo.setWordInput(palabra);
            String res=palabraIterativo.palabraItera();
            palabraIterativo.setWordOut("");
            JOptionPane.showMessageDialog(null, "El reverso de "+palabra+" es "+res);
        } else if(event.getSource() == ventanaIterativos.btnIterativoDividir){
            double n = Double.parseDouble(JOptionPane.showInputDialog("Digite un n??mero"));
            dividirIterativo.setNum(n);
            double res = dividirIterativo.dividirTres();
            dividirIterativo.setNum(0.0);
            JOptionPane.showMessageDialog(null, "El resultado de dividir entre 3 el n??mero "+n+" es "+res);
        } else if(event.getSource() == ventanaIterativos.btnIterativoDecABi){
            int n = Integer.parseInt(JOptionPane.showInputDialog("Digite un n??mero"));
            decBinaItera.setDecimal(n);
            String res = decBinaItera.decimalBinario();
            decBinaItera.setBinario("");
            decBinaItera.setDecimal(0);
            decBinaItera.setParada(false);
            JOptionPane.showMessageDialog(null, "El n??mero binario es "+res);   
        } else if(event.getSource() == ventanaIterativos.btnIterativoBiADec){
            String binario=JOptionPane.showInputDialog("Digite un n??mero binario");
            biDecItera.setBinario(binario);
            biDecItera.setExponente(binario.length()-1);
            int res = biDecItera.binarioDecimal();
            biDecItera.setBinario(" ");
            biDecItera.setExponente(0);
            biDecItera.setDecimal(0);
            JOptionPane.showMessageDialog(null, "El n??mero decimal es "+res);
        } else if(event.getSource() == ventanaIterativos.btnIterativoPass){
            String pass = JOptionPane.showInputDialog("Digite una contrase??a para verificar si tiene n??meros");
            passItera.setPass(pass);
            String res=passItera.contieneNumero();
            passItera.setPass("");
            passItera.setResultado("");
            if(res.isEmpty()){
                JOptionPane.showMessageDialog(null, "La contrase??a no tiene n??meros");
            }else{
                JOptionPane.showMessageDialog(null, "Estos son los n??meros que tiene la contrase??a: "+res);
            }
        }
    }
}
