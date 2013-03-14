/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Robots;

import robocode.ScannedRobotEvent;

/**
 *
 * @author Victor
 */
class InScannedRobotEvent {
    private double bearing;
    private double bearingRadians;
    private double distance;
    private double energy;
    private double heading;
    private double headingRadians;
    private double velocity;
    
    public void copy(ScannedRobotEvent event){
        setBearing(event.getBearing());
        setBearingRadians(event.getBearingRadians());
        setDistance(event.getDistance());
        setEnergy(event.getEnergy());
        setHeading(event.getHeading());
        setHeadingRadians(event.getHeadingRadians());
        setVelocity(event.getVelocity());
    }

    void reiniciar() {
        this.setBearing(0d);
        this.setBearingRadians(0d);
        this.setDistance(0d);
        this.setEnergy(0d);
        this.setHeading(0d);
        this.setHeadingRadians(0d);
        this.setVelocity(0d);
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
     * @return the distance
     */
    public double getDistance() {
        return distance;
    }

    /**
     * @param distance the distance to set
     */
    public void setDistance(double distance) {
        this.distance = distance;
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
     * @return the heading
     */
    public double getHeading() {
        return heading;
    }

    /**
     * @param heading the heading to set
     */
    public void setHeading(double heading) {
        this.heading = heading;
    }

    /**
     * @return the headingRadians
     */
    public double getHeadingRadians() {
        return headingRadians;
    }

    /**
     * @param headingRadians the headingRadians to set
     */
    public void setHeadingRadians(double headingRadians) {
        this.headingRadians = headingRadians;
    }

    /**
     * @return the velocity
     */
    public double getVelocity() {
        return velocity;
    }

    /**
     * @param velocity the velocity to set
     */
    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }
    
}
