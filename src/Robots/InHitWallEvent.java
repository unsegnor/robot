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
        setBearing(event.getBearing());
        setBearingRadians(event.getBearingRadians());
    }

    void reiniciar() {
        this.setBearing(0d);
        this.setBearingRadians(0d);
    }

    /**
     * @return the bearing
     */
    public double getBearing() {
        return bearing;
    }

    /**
     * @param bearing the bearing to set
     */
    public void setBearing(double bearing) {
        this.bearing = bearing;
    }

    /**
     * @return the bearingRadians
     */
    public double getBearingRadians() {
        return bearingRadians;
    }

    /**
     * @param bearingRadians the bearingRadians to set
     */
    public void setBearingRadians(double bearingRadians) {
        this.bearingRadians = bearingRadians;
    }
    
}
