/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Robots;

import robocode.Bullet;
import robocode.BulletHitBulletEvent;

/**
 *
 * @author Victor
 */
class InBulletHitBulletEvent {

    private double heading;
    private double headingRadians;
    private double power;
    private double velocity;
    private double x;
    private double y;
    private boolean active;
    private double heading2;
    private double headingRadians2;
    private double power2;
    private double velocity2;
    private double x2;
    private double y2;
    private boolean active2;

    public InBulletHitBulletEvent(BulletHitBulletEvent event) {
        copy(event);
    }

    InBulletHitBulletEvent() {
    }

    public void copy(BulletHitBulletEvent event) {
        Bullet b = event.getBullet();
        setHeading(b.getHeading());
        setHeadingRadians(b.getHeadingRadians());
        setPower(b.getPower());
        setVelocity(b.getVelocity());
        setX(b.getX());
        setY(b.getY());
        setActive(b.isActive());

        Bullet c = event.getHitBullet();
        setHeading2(c.getHeading());
        setHeadingRadians2(c.getHeadingRadians());
        setPower2(c.getPower());
        setVelocity2(c.getVelocity());
        setX2(c.getX());
        setY2(c.getY());
        setActive2(c.isActive());
    }

    void reiniciar() {
        this.setActive(false);
        this.setActive2(false);
        this.setHeading(0d);
        this.setHeading2(0d);
        this.setHeadingRadians(0d);
        this.setHeadingRadians2(0d);
        this.setPower(0d);
        this.setPower2(0d);
        this.setVelocity(0d);
        this.setVelocity2(0d);
        this.setX(0d);
        this.setX2(0d);
        this.setY(0d);
        this.setY2(0d);
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
     * @return the heading2
     */
    public double getHeading2() {
        return heading2;
    }

    /**
     * @param heading2 the heading2 to set
     */
    public void setHeading2(double heading2) {
        this.heading2 = heading2;
    }

    /**
     * @return the headingRadians2
     */
    public double getHeadingRadians2() {
        return headingRadians2;
    }

    /**
     * @param headingRadians2 the headingRadians2 to set
     */
    public void setHeadingRadians2(double headingRadians2) {
        this.headingRadians2 = headingRadians2;
    }

    /**
     * @return the power2
     */
    public double getPower2() {
        return power2;
    }

    /**
     * @param power2 the power2 to set
     */
    public void setPower2(double power2) {
        this.power2 = power2;
    }

    /**
     * @return the velocity2
     */
    public double getVelocity2() {
        return velocity2;
    }

    /**
     * @param velocity2 the velocity2 to set
     */
    public void setVelocity2(double velocity2) {
        this.velocity2 = velocity2;
    }

    /**
     * @return the x2
     */
    public double getX2() {
        return x2;
    }

    /**
     * @param x2 the x2 to set
     */
    public void setX2(double x2) {
        this.x2 = x2;
    }

    /**
     * @return the y2
     */
    public double getY2() {
        return y2;
    }

    /**
     * @param y2 the y2 to set
     */
    public void setY2(double y2) {
        this.y2 = y2;
    }

    /**
     * @return the active2
     */
    public boolean isActive2() {
        return active2;
    }

    /**
     * @param active2 the active2 to set
     */
    public void setActive2(boolean active2) {
        this.active2 = active2;
    }
}
