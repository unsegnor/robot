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
        heading = b.getHeading();
        headingRadians = b.getHeadingRadians();
        power = b.getPower();
        velocity = b.getVelocity();
        x = b.getX();
        y = b.getY();
        active = b.isActive();
        energy = event.getEnergy();
    }

    void reiniciar() {
        this.active = false;
        this.energy = 0d;
        this.heading = 0d;
        this.headingRadians = 0d;
        this.power = 0d;
        this.velocity = 0d;
        this.x = 0d;
        this.y = 0d;
    }
}
