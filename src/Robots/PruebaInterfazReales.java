/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Robots;

/**
 *
 * @author Víctor
 */
public class PruebaInterfazReales extends RobotInterfazReales {
    
    @Override
    public double[] responder(double[] entradas){
        double[] salidas = new double[30];
        
        salidas[3] = 1;
        salidas[18] = 100;
        
        
        
        return salidas;
    }
    
}
