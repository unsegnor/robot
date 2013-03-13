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
        bearing = event.getBearing();
        bearingRadians = event.getBearingRadians();
        distance = event.getDistance();
        energy = event.getEnergy();
        heading = event.getHeading();
        headingRadians = event.getHeadingRadians();
        velocity = event.getVelocity();
    }

    void reiniciar() {
        this.bearing = 0d;
        this.bearingRadians = 0d;
        this.distance = 0d;
        this.energy = 0d;
        this.heading = 0d;
        this.headingRadians = 0d;
        this.velocity = 0d;
    }
    
}
