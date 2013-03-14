/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Robots;

import robocode.Bullet;
import robocode.HitByBulletEvent;

/**
 *
 * @author Victor
 */
class InHitByBulletEvent {

    private double bearing;
    private double bearingRadians;
    private double headingb;
    private double headingRadiansb;
    private double powerb;
    private double velocityb;
    private double xb;
    private double yb;
    private boolean activeb;
    private double heading;
    private double headingRadians;
    private double power;
    private double velocity;

    public InHitByBulletEvent() {
    }

    public void copy(HitByBulletEvent event) {
        setBearing(event.getBearing());
        setBearingRadians(event.getBearingRadians());

        Bullet b = event.getBullet();
        setHeadingb(b.getHeading());
        setHeadingRadiansb(b.getHeadingRadians());
        setPowerb(b.getPower());
        setVelocityb(b.getVelocity());
        setXb(b.getX());
        setYb(b.getY());
        setActiveb(b.isActive());

        setHeading(event.getHeading());
        setHeadingRadians(event.getHeadingRadians());
        setPower(event.getPower());
        setVelocity(event.getVelocity());
    }

    void reiniciar() {
        this.setActiveb(false);
        this.setBearing(0d);
        this.setBearingRadians(0d);
        this.setHeading(0d);
        this.setHeadingRadians(0d);
        this.setHeadingRadiansb(0d);
        this.setHeadingb(0d);
        this.setPower(0d);
        this.setPowerb(0d);
        this.setVelocity(0d);
        this.setVelocityb(0d);
        this.setXb(0d);
        this.setYb(0d);
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
     * @return the headingb
     */
    public double getHeadingb() {
        return headingb;
    }

    /**
     * @param headingb the headingb to set
     */
    public void setHeadingb(double headingb) {
        this.headingb = headingb;
    }

    /**
     * @return the headingRadiansb
     */
    public double getHeadingRadiansb() {
        return headingRadiansb;
    }

    /**
     * @param headingRadiansb the headingRadiansb to set
     */
    public void setHeadingRadiansb(double headingRadiansb) {
        this.headingRadiansb = headingRadiansb;
    }

    /**
     * @return the powerb
     */
    public double getPowerb() {
        return powerb;
    }

    /**
     * @param powerb the powerb to set
     */
    public void setPowerb(double powerb) {
        this.powerb = powerb;
    }

    /**
     * @return the velocityb
     */
    public double getVelocityb() {
        return velocityb;
    }

    /**
     * @param velocityb the velocityb to set
     */
    public void setVelocityb(double velocityb) {
        this.velocityb = velocityb;
    }

    /**
     * @return the xb
     */
    public double getXb() {
        return xb;
    }

    /**
     * @param xb the xb to set
     */
    public void setXb(double xb) {
        this.xb = xb;
    }

    /**
     * @return the yb
     */
    public double getYb() {
        return yb;
    }

    /**
     * @param yb the yb to set
     */
    public void setYb(double yb) {
        this.yb = yb;
    }

    /**
     * @return the activeb
     */
    public boolean isActiveb() {
        return activeb;
    }

    /**
     * @param activeb the activeb to set
     */
    public void setActiveb(boolean activeb) {
        this.activeb = activeb;
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
     * @return the power
     */
    public double getPower() {
        return power;
    }

    /**
     * @param power the power to set
     */
    public void setPower(double power) {
        this.power = power;
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
