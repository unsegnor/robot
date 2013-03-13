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
        bearing = event.getBearing();
        bearingRadians = event.getBearingRadians();

        Bullet b = event.getBullet();
        headingb = b.getHeading();
        headingRadiansb = b.getHeadingRadians();
        powerb = b.getPower();
        velocityb = b.getVelocity();
        xb = b.getX();
        yb = b.getY();
        activeb = b.isActive();

        heading = event.getHeading();
        headingRadians = event.getHeadingRadians();
        power = event.getPower();
        velocity = event.getVelocity();
    }

    void reiniciar() {
        this.activeb = false;
        this.bearing = 0d;
        this.bearingRadians = 0d;
        this.heading = 0d;
        this.headingRadians = 0d;
        this.headingRadiansb = 0d;
        this.headingb = 0d;
        this.power = 0d;
        this.powerb = 0d;
        this.velocity = 0d;
        this.velocityb = 0d;
        this.xb = 0d;
        this.yb = 0d;
    }
}
