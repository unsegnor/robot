/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Robots;

import robocode.HitWallEvent;

/**
 *
 * @author Victor
 */
class InHitWallEvent {
    private double bearing;
    private double bearingRadians;
    
    public void copy(HitWallEvent event){
        bearing = event.getBearing();
        bearingRadians = event.getBearingRadians();
    }

    void reiniciar() {
        this.bearing = 0d;
        this.bearingRadians = 0d;
    }
    
}
