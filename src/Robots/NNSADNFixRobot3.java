/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Robots;

import Genetica.NNSADNF.GestorADN;
import Genetica.NNSADNF.NNSADNFix;
import SimpleNN.NN;
import java.util.Random;

/**
 *
 * @author Víctor
 */
public class NNSADNFixRobot3 extends RobotInterfazReales {
    
    NN red;
    public static int lastrobot=0;
    
    public NNSADNFixRobot3(){
        
        init();
        
    }

    private void init() {
        int[] capas = NNSADNFix.globalCapas;
        
        //Preguntamos longitud del ADN válida para las capas que queremos
        int lADN = NNSADNFix.longADN(capas);
        
        //Ordenamos al gestor que cargue las cadenas si no las tiene ya
        if(!GestorADN.iniciado){
            GestorADN.cargardearchivo("poblaciones");
            GestorADN.iniciado = true;
        }
        
        //Obtenemos el adn
        double[] adn = GestorADN.getADN(3);

        
        //System.out.println("ClassLoader del Robot: " + this.getClass().getClassLoader().toString() + " hijo de ");
        
        red = NNSADNFix.construyeNN(adn, capas);
    }
    
    public double[] responder(double[] entradas){
        return red.exec(entradas);
    }
    
}
