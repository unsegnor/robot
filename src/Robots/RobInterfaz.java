/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Robots;

import Utiles.F;
import java.util.ArrayList;
import robocode.BattleEndedEvent;
import robocode.Bullet;
import robocode.BulletHitBulletEvent;
import robocode.BulletHitEvent;
import robocode.BulletMissedEvent;
import robocode.DeathEvent;
import robocode.HitByBulletEvent;
import robocode.HitRobotEvent;
import robocode.HitWallEvent;
import robocode.Robot;
import robocode.RobotDeathEvent;
import robocode.RoundEndedEvent;
import robocode.ScannedRobotEvent;
import robocode.StatusEvent;
import robocode.WinEvent;

/**
 * Debe percibir todo lo que un robot pueda percibir y transformarlo en valores
 *
 * @author Victor
 */
public class RobInterfaz extends Robot {

    RobotInput ri = new RobotInput();

    @Override
    public void onBulletHit(BulletHitEvent event) {
        ri.onbullethit = true;
        ri.obh_event.copy(event);
    }

    @Override
    public void onBulletHitBullet(BulletHitBulletEvent event) {
        ri.onbullethitbullet = true;
        ri.obhb_event.copy(event);
    }

    @Override
    public void onBulletMissed(BulletMissedEvent event) {
        ri.onbulletmissed = true;
        ri.obm_event.copy(event);
    }

    @Override
    public void onDeath(DeathEvent event) {
        ri.ondeath = true;
    }

    @Override
    public void onHitByBullet(HitByBulletEvent event) {
        ri.onhitbybullet = true;
        ri.ohbb_event.copy(event);
    }

    @Override
    public void onHitRobot(HitRobotEvent event) {
        ri.onhitrobotevent = true;
        ri.ohr_event.copy(event);
    }

    @Override
    public void onHitWall(HitWallEvent event) {
        ri.onhitwall = true;
        ri.ohw_event.copy(event);
    }

    @Override
    public void onRobotDeath(RobotDeathEvent event) {
        ri.onrobotdeath = true;
        ri.ord_event.copy(event);
    }

    @Override
    public void onScannedRobot(ScannedRobotEvent event) {
        ri.onscannedrobot = true;
        ri.osr_event.copy(event);
    }

    @Override
    public void onWin(WinEvent event) {
        ri.onwin = true;
        ri.ow_event.copy(event);
    }

    @Override
    public void onRoundEnded(RoundEndedEvent event) {
        ri.onroundended = true;
        ri.ore_event.copy(event);
    }

    @Override
    public void onBattleEnded(BattleEndedEvent event) {
        ri.obattleended = true;
        ri.obe_event.copy(event);
    }

    @Override
    public void onStatus(StatusEvent e) {
        ri.onstatus = true;
        ri.os_event.copy(e);
    }

    
    public RobotInput getInput(){
        //Leer el estado de todas las variables del entorno ahora y devolve junto con las que se han actualizado con los 
        //eventos
        ri.battleFieldHeight = getBattleFieldHeight();
        ri.battleFieldWidth = getBattleFieldWidth();
        ri.energy = getEnergy();
        ri.gunCoolingRate = getGunCoolingRate();
        ri.gunHeating = getGunHeading();
        ri.gunHeat = getGunHeat();
        ri.heading = getHeading();
        ri.height = getHeight();
        ri.numRounds = getNumRounds();
        ri.others = getOthers();
        ri.radarHeating = getRadarHeading();
        ri.roundNum = getRoundNum();
        ri.time = getTime();
        ri.velocity = getVelocity();
        ri.width = getWidth();
        ri.x = getX();
        ri.y = getY();
        
        return ri;
    }
    
    public void reiniciar_input(){
        //Reiniciar las variables del input
        ri.reiniciar();
    }
    

    public void setOutput(boolean[] output) {
        
    }
}
