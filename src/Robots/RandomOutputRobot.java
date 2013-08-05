/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Robots;

import java.util.Random;

/**
 *
 * @author Víctor
 */
public class RandomOutputRobot extends RobotInterfazReales {
    
    Random r = new Random();
    
    @Override
    public double[] responder(double[] input){
        double[] respuesta = new double[30];
        
        for(int i=0; i<respuesta.length; i++){
            respuesta[i] = r.nextDouble();
        }
        
        
        return respuesta;
    }
    
}
