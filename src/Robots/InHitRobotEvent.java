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
        setBearing(event.getBearing());
        setBearingRadians(event.getBearingRadians());
        setEnergy(event.getEnergy());
        setMyfault(event.isMyFault());
    }

    void reiniciar() {
        this.setBearing(0d);
        this.setBearingRadians(0d);
        this.setEnergy(0d);
        this.setMyfault(false);
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

    /**
     * @return the energy
     */
    public double getEnergy() {
        return energy;
    }

    /**
     * @param energy the energy to set
     */
    public void setEnergy(double energy) {
        this.energy = energy;
    }

    /**
     * @return the myfault
     */
    public boolean isMyfault() {
        return myfault;
    }

    /**
     * @param myfault the myfault to set
     */
    public void setMyfault(boolean myfault) {
        this.myfault = myfault;
    }
    
}
