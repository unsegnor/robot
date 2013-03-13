/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Robots;

import robocode.HitRobotEvent;

/**
 *
 * @author Victor
 */
class InHitRobotEvent {
    private double bearing;
    private double bearingRadians;
    private double energy;
    private boolean myfault;

    public InHitRobotEvent() {
    }
    
    public void copy(HitRobotEvent event){
        bearing = event.getBearing();
        bearingRadians = event.getBearingRadians();
        energy = event.getEnergy();
        myfault = event.isMyFault();
    }

    void reiniciar() {
        this.bearing = 0d;
        this.bearingRadians = 0d;
        this.energy = 0d;
        this.myfault = false;
    }
    
}
