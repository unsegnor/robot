/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Robots;

import Genetica.NNSADNFix;
import SimpleNN.NN;
import java.util.Random;

/**
 * Robot que utiliza un patrón aleatorio para funcionar
 * @author Víctor
 */
public class RandomNNSADNRobot extends RobotInterfazReales {
    
    NN red;
    Random r = new Random();
    
    public RandomNNSADNRobot(){
        
        init();
        
    }

    private void init() {
        int[] capas = {35,30,20,25,28};
        
        //Preguntamos longitud del ADN válida para las capas que queremos
        int lADN = NNSADNFix.longADN(capas);
        
        double[] adn = new double[lADN];
        
        //Rellenamos con random
        for(int i=0; i<lADN; i++){
            adn[i] = r.nextDouble();
        }
        
        
        red = NNSADNFix.construyeNN(adn, capas);
    }
    
    public double[] responder(double[] entradas){
        return red.exec(entradas);
    }
    
}
