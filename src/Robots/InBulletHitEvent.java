/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Robots;

import robocode.Bullet;
import robocode.BulletHitEvent;

/**
 *
 * @author Victor
 */
class InBulletHitEvent {

    private double heading;
    private double headingRadians;
    private double power;
    private double velocity;
    private double x;
    private double y;
    private boolean active;
    private double energy;

    public InBulletHitEvent(BulletHitEvent event) {

        copy(event);

    }

    InBulletHitEvent() {
    }

    void copy(BulletHitEvent event) {
        Bullet b = event.getBullet();
        setHeading(b.getHeading());
        setHeadingRadians(b.getHeadingRadians());
        setPower(b.getPower());
        setVelocity(b.getVelocity());
        setX(b.getX());
        setY(b.getY());
        setActive(b.isActive());
        setEnergy(event.getEnergy());
    }

    void reiniciar() {
        this.setActive(false);
        this.setEnergy(0d);
        this.setHeading(0d);
        this.setHeadingRadians(0d);
        this.setPower(0d);
        this.setVelocity(0d);
        this.setX(0d);
        this.setY(0d);
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

    /**
     * @return the active
     */
    public boolean isActive() {
        return active;
    }

    /**
     * @param active the active to set
     */
    public void setActive(boolean active) {
        this.active = active;
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
}
