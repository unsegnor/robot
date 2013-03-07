package Robots;


import robocode.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Victor
 */
public class Prueba extends Robot{
    
    @Override
    public void run(){
        while (true){
            
            ahead(100);
            turnGunRight(360);
            back(100);
            turnGunRight(360);
            
        }
    }
    
    @Override
    public void onScannedRobot(ScannedRobotEvent e){
        fire(1);
        
    }
    
}
