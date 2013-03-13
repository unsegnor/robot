/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Robots;

import robocode.RobotStatus;
import robocode.StatusEvent;

/**
 *
 * @author Victor
 */
class InStatusEvent {

    private double distanceRemaining;
    private double energy;
    private double gunHeading;
    private double gunHeadingR;
    private double gunHeat;
    private double gunTurnRemaining;
    private double gunTurnRemainingR;
    private double heading;
    private double headingR;
    private int numRounds;
    private int others;
    private double radarHeading;
    private double radarHeadingR;
    private double radarTurnRemaining;
    private double radarTurnRemainingR;
    private int roundNum;
    private long time;
    private double turnRemaining;
    private double turnRemainingRadians;
    private double velocity;
    private double x;
    private double y;

    public InStatusEvent() {
    }

    public void copy(StatusEvent e) {
        RobotStatus r = e.getStatus();
        distanceRemaining = r.getDistanceRemaining();
        energy = r.getEnergy();
        gunHeading = r.getGunHeading();
        gunHeadingR = r.getGunHeadingRadians();
        gunHeat = r.getGunHeat();
        gunTurnRemaining = r.getGunTurnRemaining();
        gunTurnRemainingR = r.getGunTurnRemainingRadians();
        heading = r.getHeading();
        headingR = r.getHeadingRadians();
        numRounds = r.getNumRounds();
        others = r.getOthers();
        radarHeading = r.getRadarHeading();
        radarHeadingR = r.getRadarHeadingRadians();
        radarTurnRemaining = r.getRadarTurnRemaining();
        radarTurnRemainingR = r.getRadarTurnRemainingRadians();
        roundNum = r.getRoundNum();
        time = r.getTime();
        turnRemaining = r.getTurnRemaining();
        turnRemainingRadians = r.getTurnRemainingRadians();
        velocity = r.getVelocity();
        x = r.getX();
        y = r.getY();
    }

    void reiniciar() {
        this.distanceRemaining = 0d;
        this.energy = 0d;
        this.gunHeading = 0d;
        this.gunHeadingR = 0d;
        this.gunHeat = 0d;
        this.gunTurnRemaining = 0d;
        this.gunTurnRemainingR = 0d;
        this.heading = 0d;
        this.headingR = 0d;
        this.numRounds = 0;
        this.others = 0;
        this.radarHeading = 0d;
        this.radarHeadingR = 0d;
        this.radarTurnRemaining = 0d;
        this.radarTurnRemainingR = 0d;
        this.roundNum = 0;
        this.time = 0l;
        this.turnRemaining = 0d;
        this.turnRemainingRadians = 0d;
        this.velocity = 0d;
        this.x = 0d;
        this.y = 0d;
    }
}
