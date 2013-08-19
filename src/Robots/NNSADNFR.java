/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Robots;

import Genetica.NNSADNF.GestorADN;
import Genetica.NNSADNF.NNSADNFix;
import SimpleNN.NN;
import java.awt.Color;
import java.util.Random;

/**
 *
 * @author Víctor
 */
public class NNSADNFR extends RobotInterfazReales {
    public static String prefijo = "Robots.NNSADNFR";
    
    NN red;
    boolean coloreado = false;
    double[] adn;
    Color color;
    
    
    public NNSADNFR(int n){
        
        init(n);
        
    }

    protected void init(int n) {
        int[] capas = NNSADNFix.globalCapas;
        
        //Preguntamos longitud del ADN válida para las capas que queremos
        int lADN = NNSADNFix.longADN(capas);
        
        //Ordenamos al gestor que cargue las cadenas
        GestorADN.cargardearchivo(NNSADNFix.rutaPoblacion);
        
        //Obtenemos el adn
        adn = GestorADN.getADN(n);

        
        //Calcular color en función del ADN
        color = GestorADN.adn2color(adn);
        
        
        //System.out.println("ClassLoader del Robot: " + this.getClass().getClassLoader().toString() + " hijo de ");
        
        red = NNSADNFix.construyeNN(adn, capas);
    }
    
    public double[] responder(double[] entradas){
        //Si no tiene color asignado se lo ponemos
        if(!coloreado){
            setAllColors(color);
            coloreado = true;
        }
            
        
        
        return red.exec(entradas);
    }
    
}
