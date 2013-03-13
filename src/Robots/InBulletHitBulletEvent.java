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
        heading = b.getHeading();
        headingRadians = b.getHeadingRadians();
        power = b.getPower();
        velocity = b.getVelocity();
        x = b.getX();
        y = b.getY();
        active = b.isActive();

        Bullet c = event.getHitBullet();
        heading2 = c.getHeading();
        headingRadians2 = c.getHeadingRadians();
        power2 = c.getPower();
        velocity2 = c.getVelocity();
        x2 = c.getX();
        y2 = c.getY();
        active2 = c.isActive();
    }

    void reiniciar() {
        this.active = false;
        this.active2 = false;
        this.heading = 0d;
        this.heading2 = 0d;
        this.headingRadians = 0d;
        this.headingRadians2 = 0d;
        this.power = 0d;
        this.power2 = 0d;
        this.velocity = 0d;
        this.velocity2 = 0d;
        this.x = 0d;
        this.x2 = 0d;
        this.y = 0d;
        this.y2 = 0d;
    }
}
