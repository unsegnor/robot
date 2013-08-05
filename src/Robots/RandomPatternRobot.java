/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Robots;

import SimpleNN.NN;

/**
 * Robot que utiliza un patrón aleatorio para funcionar
 * @author Víctor
 */
public class RandomPatternRobot extends RobotInterfazReales {
    
    NN red;
    
    public RandomPatternRobot(){
        
        init();
        
    }

    private void init() {
        int[] capas = {35,30,20,10,20,30,35};
        
        red = new NN(capas);
    }
    
    public double[] responder(double[] entradas){
        return red.exec(entradas);
    }
    
}
