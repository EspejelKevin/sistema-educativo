/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.BinarioDecimalRecursivo;
import Modelo.DecimalBinarioRecursivo;
import Modelo.DividirRecursivo;
import Modelo.FactorialRecursivo;
import Modelo.FibonacciRecursivo;
import Modelo.MCDRecursivo;
import Modelo.MultiRecursivo;
import Modelo.PalabraRecursivo;
import Modelo.PasswordRecursivo;
import Modelo.SerieDosRecursivo;
import Modelo.SerieUnoRecursivo;
import Vista.Recursivos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author kevin
 */
public abstract class CtrlRecursivos implements ActionListener{
    
    private FactorialRecursivo factorialRecursivo;
    private FibonacciRecursivo fiboRecursivo;
    private SerieUnoRecursivo serieUno;
    private SerieDosRecursivo serieDos;
    private MCDRecursivo mcd;
    private MultiRecursivo multi;
    private Recursivos ventanaRecursivos;
    private PalabraRecursivo palabraRecursivo;
    private DividirRecursivo dividirRecu;
    private DecimalBinarioRecursivo decBinRecu;
    private BinarioDecimalRecursivo biDecRecu;
    private PasswordRecursivo passRecu;
    
    public CtrlRecursivos(FactorialRecursivo factorialRecursivo, FibonacciRecursivo fiboRecursivo,
                          SerieUnoRecursivo serieUno, SerieDosRecursivo serieDos,
                          MCDRecursivo mcd, MultiRecursivo multi, 
                          PalabraRecursivo palabraRecursivo, 
                          DividirRecursivo dividirRecu, DecimalBinarioRecursivo decBinRecu, 
                          BinarioDecimalRecursivo biDecRecu, PasswordRecursivo passRecu,
                          Recursivos ventanaRecursivos){
        this.factorialRecursivo = factorialRecursivo;
        this.ventanaRecursivos = ventanaRecursivos;
        this.fiboRecursivo = fiboRecursivo;
        this.serieUno = serieUno;
        this.serieDos = serieDos;
        this.mcd = mcd;
        this.multi = multi;
        this.palabraRecursivo = palabraRecursivo;
        this.dividirRecu = dividirRecu;
        this.decBinRecu = decBinRecu;
        this.biDecRecu = biDecRecu;
        this.passRecu = passRecu;
        this.ventanaRecursivos.btnFactorialRecursivo.addActionListener(this);
        this.ventanaRecursivos.btnFiboRecursivo.addActionListener(this);
        this.ventanaRecursivos.btnMCDRecu.addActionListener(this);
        this.ventanaRecursivos.btnSerieDosRecu.addActionListener(this);
        this.ventanaRecursivos.btnSerieUnoRecu.addActionListener(this);
        this.ventanaRecursivos.btnMultiRecu.addActionListener(this);
        this.ventanaRecursivos.btnRecursivoReves.addActionListener(this);
        this.ventanaRecursivos.btnRecursivoDividir.addActionListener(this);
        this.ventanaRecursivos.btnRecursivoDecABi.addActionListener(this);
        this.ventanaRecursivos.btnRecursivoBiADec.addActionListener(this);
        this.ventanaRecursivos.btnRecursivoPass.addActionListener(this);
        
    }
    
    public static double redondearDecimales(double valorInicial, int numeroDecimales) {
        double parteEntera, resultado;
        resultado = valorInicial;
        parteEntera = Math.floor(resultado);
        resultado = (resultado - parteEntera) * Math.pow(10, numeroDecimales);
        resultado = Math.round(resultado);
        resultado = (resultado / Math.pow(10, numeroDecimales)) + parteEntera;
        return resultado;
    }
    
    @Override
    public void actionPerformed(ActionEvent event){
        if(event.getSource() == ventanaRecursivos.btnFactorialRecursivo){
            int n = Integer.parseInt(JOptionPane.showInputDialog("Digite un número para obtener su factorial"));
            int resultado = factorialRecursivo.factorial(n);
            JOptionPane.showMessageDialog(null, "El factorial de " + n + " es " + resultado);
        }else if(event.getSource() == ventanaRecursivos.btnFiboRecursivo){
            int n = Integer.parseInt(JOptionPane.showInputDialog("La serie empieza en 0 1. Digite el límite de la serie (número)"));
            int resultado = fiboRecursivo.fibo(n);
            fiboRecursivo.setAux(0);
            fiboRecursivo.setX(0);
            fiboRecursivo.setY(1);
            JOptionPane.showMessageDialog(null, "El número fibonacci es " + resultado);
        }else if(event.getSource() == ventanaRecursivos.btnSerieUnoRecu){
            double n = Double.parseDouble(JOptionPane.showInputDialog("Digite un número (límite de la serie)"));
            double resultado = serieUno.serieUno(n);
            resultado = Math.round(resultado*100.0)/100.0;
            JOptionPane.showMessageDialog(null, "El resultado de la serie uno es " + resultado);
        }else if(event.getSource() == ventanaRecursivos.btnSerieDosRecu){
            double n = Double.parseDouble(JOptionPane.showInputDialog("Digite un número (límite de la serie)"));
            double resultado = serieDos.serieDos(n);
            resultado = redondearDecimales(resultado, 4);
            JOptionPane.showMessageDialog(null, "El resultado de la serie dos es " + resultado);
        }else if(event.getSource() == ventanaRecursivos.btnMCDRecu){
            int num1 = Integer.parseInt(JOptionPane.showInputDialog("Digite el primer número"));
            int num2 = Integer.parseInt(JOptionPane.showInputDialog("Digite el segundo número"));
            int resultado = mcd.mcd(num1, num2);
            JOptionPane.showMessageDialog(null, "El M.C.D de "+num1+" y "+num2+" es: "+resultado);
        }else if(event.getSource() == ventanaRecursivos.btnMultiRecu){
            int num1 = Integer.parseInt(JOptionPane.showInputDialog("Digite el primer número (multiplicador)"));
            int num2 = Integer.parseInt(JOptionPane.showInputDialog("Digite el segundo número (multiplicando)"));
            int resultado = multi.multi(num1, num2, 0);
            JOptionPane.showMessageDialog(null, "El producto de "+num1+" y "+num2+" es: "+resultado);
        }else if(event.getSource() == ventanaRecursivos.btnRecursivoReves){
            String palabra=JOptionPane.showInputDialog("Digite una palabra");
            int len = palabra.length();
            String res = palabraRecursivo.reversedWord(palabra, len, "");
            JOptionPane.showMessageDialog(null, "El reverso de "+palabra+" es "+res);
        }else if(event.getSource() == ventanaRecursivos.btnRecursivoDividir){
            double n = Double.parseDouble(JOptionPane.showInputDialog("Digite un número"));
            double res = dividirRecu.dividirRecur(n);
            JOptionPane.showMessageDialog(null, "El resultado de dividir entre 3 el número "+n+" es "+res);
        }else if(event.getSource() == ventanaRecursivos.btnRecursivoDecABi){
            int n = Integer.parseInt(JOptionPane.showInputDialog("Digite un número"));
            String res = decBinRecu.decimalBinarioRecu(n);
            JOptionPane.showMessageDialog(null, "El número binario es "+res);
        }else if(event.getSource() == ventanaRecursivos.btnRecursivoBiADec){
            String binario=JOptionPane.showInputDialog("Digite un número binario");
            int res = biDecRecu.aDecimal(binario);
            JOptionPane.showMessageDialog(null, "El número decimal es "+res);
        }else if(event.getSource() == ventanaRecursivos.btnRecursivoPass){
            String pass = JOptionPane.showInputDialog("Digite una contraseña para verificar si tiene números");
            int len = pass.length();
            boolean res=passRecu.contieneNumeroRecu(pass, len);
            if(res){
                JOptionPane.showMessageDialog(null, "La contraseña tiene números");
            }else{
                JOptionPane.showMessageDialog(null, "La contraseña no tiene números");
            }
        }
    }
}
