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
        setDistanceRemaining(r.getDistanceRemaining());
        setEnergy(r.getEnergy());
        setGunHeading(r.getGunHeading());
        setGunHeadingR(r.getGunHeadingRadians());
        setGunHeat(r.getGunHeat());
        setGunTurnRemaining(r.getGunTurnRemaining());
        setGunTurnRemainingR(r.getGunTurnRemainingRadians());
        setHeading(r.getHeading());
        setHeadingR(r.getHeadingRadians());
        setNumRounds(r.getNumRounds());
        setOthers(r.getOthers());
        setRadarHeading(r.getRadarHeading());
        setRadarHeadingR(r.getRadarHeadingRadians());
        setRadarTurnRemaining(r.getRadarTurnRemaining());
        setRadarTurnRemainingR(r.getRadarTurnRemainingRadians());
        setRoundNum(r.getRoundNum());
        setTime(r.getTime());
        setTurnRemaining(r.getTurnRemaining());
        setTurnRemainingRadians(r.getTurnRemainingRadians());
        setVelocity(r.getVelocity());
        setX(r.getX());
        setY(r.getY());
    }

    void reiniciar() {
        this.setDistanceRemaining(0d);
        this.setEnergy(0d);
        this.setGunHeading(0d);
        this.setGunHeadingR(0d);
        this.setGunHeat(0d);
        this.setGunTurnRemaining(0d);
        this.setGunTurnRemainingR(0d);
        this.setHeading(0d);
        this.setHeadingR(0d);
        this.setNumRounds(0);
        this.setOthers(0);
        this.setRadarHeading(0d);
        this.setRadarHeadingR(0d);
        this.setRadarTurnRemaining(0d);
        this.setRadarTurnRemainingR(0d);
        this.setRoundNum(0);
        this.setTime(0l);
        this.setTurnRemaining(0d);
        this.setTurnRemainingRadians(0d);
        this.setVelocity(0d);
        this.setX(0d);
        this.setY(0d);
    }

    /**
     * @return the distanceRemaining
     */
    public double getDistanceRemaining() {
        return distanceRemaining;
    }

    /**
     * @param distanceRemaining the distanceRemaining to set
     */
    public void setDistanceRemaining(double distanceRemaining) {
        this.distanceRemaining = distanceRemaining;
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
     * @return the gunHeading
     */
    public double getGunHeading() {
        return gunHeading;
    }

    /**
     * @param gunHeading the gunHeading to set
     */
    public void setGunHeading(double gunHeading) {
        this.gunHeading = gunHeading;
    }

    /**
     * @return the gunHeadingR
     */
    public double getGunHeadingR() {
        return gunHeadingR;
    }

    /**
     * @param gunHeadingR the gunHeadingR to set
     */
    public void setGunHeadingR(double gunHeadingR) {
        this.gunHeadingR = gunHeadingR;
    }

    /**
     * @return the gunHeat
     */
    public double getGunHeat() {
        return gunHeat;
    }

    /**
     * @param gunHeat the gunHeat to set
     */
    public void setGunHeat(double gunHeat) {
        this.gunHeat = gunHeat;
    }

    /**
     * @return the gunTurnRemaining
     */
    public double getGunTurnRemaining() {
        return gunTurnRemaining;
    }

    /**
     * @param gunTurnRemaining the gunTurnRemaining to set
     */
    public void setGunTurnRemaining(double gunTurnRemaining) {
        this.gunTurnRemaining = gunTurnRemaining;
    }

    /**
     * @return the gunTurnRemainingR
     */
    public double getGunTurnRemainingR() {
        return gunTurnRemainingR;
    }

    /**
     * @param gunTurnRemainingR the gunTurnRemainingR to set
     */
    public void setGunTurnRemainingR(double gunTurnRemainingR) {
        this.gunTurnRemainingR = gunTurnRemainingR;
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
     * @return the headingR
     */
    public double getHeadingR() {
        return headingR;
    }

    /**
     * @param headingR the headingR to set
     */
    public void setHeadingR(double headingR) {
        this.headingR = headingR;
    }

    /**
     * @return the numRounds
     */
    public int getNumRounds() {
        return numRounds;
    }

    /**
     * @param numRounds the numRounds to set
     */
    public void setNumRounds(int numRounds) {
        this.numRounds = numRounds;
    }

    /**
     * @return the others
     */
    public int getOthers() {
        return others;
    }

    /**
     * @param others the others to set
     */
    public void setOthers(int others) {
        this.others = others;
    }

    /**
     * @return the radarHeading
     */
    public double getRadarHeading() {
        return radarHeading;
    }

    /**
     * @param radarHeading the radarHeading to set
     */
    public void setRadarHeading(double radarHeading) {
        this.radarHeading = radarHeading;
    }

    /**
     * @return the radarHeadingR
     */
    public double getRadarHeadingR() {
        return radarHeadingR;
    }

    /**
     * @param radarHeadingR the radarHeadingR to set
     */
    public void setRadarHeadingR(double radarHeadingR) {
        this.radarHeadingR = radarHeadingR;
    }

    /**
     * @return the radarTurnRemaining
     */
    public double getRadarTurnRemaining() {
        return radarTurnRemaining;
    }

    /**
     * @param radarTurnRemaining the radarTurnRemaining to set
     */
    public void setRadarTurnRemaining(double radarTurnRemaining) {
        this.radarTurnRemaining = radarTurnRemaining;
    }

    /**
     * @return the radarTurnRemainingR
     */
    public double getRadarTurnRemainingR() {
        return radarTurnRemainingR;
    }

    /**
     * @param radarTurnRemainingR the radarTurnRemainingR to set
     */
    public void setRadarTurnRemainingR(double radarTurnRemainingR) {
        this.radarTurnRemainingR = radarTurnRemainingR;
    }

    /**
     * @return the roundNum
     */
    public int getRoundNum() {
        return roundNum;
    }

    /**
     * @param roundNum the roundNum to set
     */
    public void setRoundNum(int roundNum) {
        this.roundNum = roundNum;
    }

    /**
     * @return the time
     */
    public long getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(long time) {
        this.time = time;
    }

    /**
     * @return the turnRemaining
     */
    public double getTurnRemaining() {
        return turnRemaining;
    }

    /**
     * @param turnRemaining the turnRemaining to set
     */
    public void setTurnRemaining(double turnRemaining) {
        this.turnRemaining = turnRemaining;
    }

    /**
     * @return the turnRemainingRadians
     */
    public double getTurnRemainingRadians() {
        return turnRemainingRadians;
    }

    /**
     * @param turnRemainingRadians the turnRemainingRadians to set
     */
    public void setTurnRemainingRadians(double turnRemainingRadians) {
        this.turnRemainingRadians = turnRemainingRadians;
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

    /**
     * @return the x
     */
    public double getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public double getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(double y) {
        this.y = y;
    }
}
