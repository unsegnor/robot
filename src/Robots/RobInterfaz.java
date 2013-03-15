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
    
    //RobotOutput ro = new RobotOutput();

    @Override
    public void onBulletHit(BulletHitEvent event) {
        ri.setOnbullethit(true);
        ri.getObh_event().copy(event);
    }

    @Override
    public void onBulletHitBullet(BulletHitBulletEvent event) {
        ri.setOnbullethitbullet(true);
        ri.getObhb_event().copy(event);
    }

    @Override
    public void onBulletMissed(BulletMissedEvent event) {
        ri.setOnbulletmissed(true);
        ri.getObm_event().copy(event);
    }

    @Override
    public void onDeath(DeathEvent event) {
        ri.setOndeath(true);
    }

    @Override
    public void onHitByBullet(HitByBulletEvent event) {
        ri.setOnhitbybullet(true);
        ri.getOhbb_event().copy(event);
    }

    @Override
    public void onHitRobot(HitRobotEvent event) {
        ri.setOnhitrobotevent(true);
        ri.getOhr_event().copy(event);
    }

    @Override
    public void onHitWall(HitWallEvent event) {
        ri.setOnhitwall(true);
        ri.getOhw_event().copy(event);
    }

    @Override
    public void onRobotDeath(RobotDeathEvent event) {
        ri.setOnrobotdeath(true);
        ri.getOrd_event().copy(event);
    }

    @Override
    public void onScannedRobot(ScannedRobotEvent event) {
        ri.setOnscannedrobot(true);
        ri.getOsr_event().copy(event);
    }

    @Override
    public void onWin(WinEvent event) {
        ri.setOnwin(true);
        ri.getOw_event().copy(event);
    }

    @Override
    public void onRoundEnded(RoundEndedEvent event) {
        ri.setOnroundended(true);
        ri.getOre_event().copy(event);
    }

    @Override
    public void onBattleEnded(BattleEndedEvent event) {
        ri.setObattleended(true);
        ri.getObe_event().copy(event);
    }

    @Override
    public void onStatus(StatusEvent e) {
        ri.setOnstatus(true);
        ri.getOs_event().copy(e);
    }

    
    public RobotInput getInput(){
        //Leer el estado de todas las variables del entorno ahora y devolve junto con las que se han actualizado con los 
        //eventos
        ri.setBattleFieldHeight(getBattleFieldHeight());
        ri.setBattleFieldWidth(getBattleFieldWidth());
        ri.setEnergy(getEnergy());
        ri.setGunCoolingRate(getGunCoolingRate());
        ri.setGunHeading(getGunHeading());
        ri.setGunHeat(getGunHeat());
        ri.setHeading(getHeading());
        ri.setHeight(getHeight());
        ri.setNumRounds(getNumRounds());
        ri.setOthers(getOthers());
        ri.setRadarHeading(getRadarHeading());
        ri.setRoundNum(getRoundNum());
        ri.setTime(getTime());
        ri.setVelocity(getVelocity());
        ri.setWidth(getWidth());
        ri.setX(getX());
        ri.setY(getY());
        
        return ri;
    }
    
    public void reiniciar_input(){
        //Reiniciar las variables del input
        ri.reiniciar();
    }
    

    public void setOutput(RobotOutput robotOutput) {
        //ro.copy(robotOutput);
    }

    @Override
    public void run() {
        
        while(true){
        
        //Obtener entradas
        RobotInput input = this.getInput();
        //Calcular salidas
        RobotOutput output = this.responder(input);
        
        //Actuar según las salidas
        if(output.isAhead()) 
            ahead(output.getV_ahead());
        if(output.isBack()) 
            back(output.getV_back());
        if(output.isFire()) 
            fire(output.getV_fire());
        if(output.isFireBullet()) 
            fireBullet(output.getV_firebullet());
        if(output.isScan())
            scan();
        if(output.isAdjustgunforrobot())
            setAdjustGunForRobotTurn(output.isV_adjustgunforrobot());
        if(output.isAdjustradarforgun())
            setAdjustRadarForGunTurn(output.isV_adjustradarforgun());
        if(output.isAdjustradarforrobot())
            setAdjustRadarForRobotTurn(output.isV_adjustradarforrobot());
        if(output.isStop())
            stop();
        if(output.isGunleft())
            turnGunLeft(output.getV_gunleft());
        if(output.isGunright())
            turnGunRight(output.getV_gunright());
        if(output.isTurnleft())
            turnLeft(output.getV_turnleft());
        if(output.isTurnright())
            turnRight(output.getV_turnright());
        if(output.isRadarleft())
            turnRadarLeft(output.getV_radarleft());
        if(output.isRadarright())
            turnRadarRight(output.getV_radarright());
        
        //Reiniciar las entradas
        this.reiniciar_input();
        }
    }

    public RobotOutput responder(RobotInput input) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
