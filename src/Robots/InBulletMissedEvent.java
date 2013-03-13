/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Robots;

import robocode.Bullet;
import robocode.BulletMissedEvent;

/**
 *
 * @author Victor
 */
class InBulletMissedEvent {
    private double heading;
    private double headingRadians;
    private double power;
    private double velocity;
    private double x;
    private double y;
    private boolean active;
    
    public void copy(BulletMissedEvent event){
        Bullet b = event.getBullet();
        heading = b.getHeading();
        headingRadians = b.getHeadingRadians();
        power = b.getPower();
        velocity = b.getVelocity();
        x = b.getX();
        y = b.getY();
        active = b.isActive();
    }

    void reiniciar() {
        this.active = false;
        this.heading = 0d;
        this.headingRadians = 0d;
        this.power = 0d;
        this.velocity = 0d;
        this.x = 0d;
        this.y = 0d;
    }
    
}
