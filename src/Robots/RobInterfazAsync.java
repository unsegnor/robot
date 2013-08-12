/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Robots;

import Utiles.F;
import java.util.ArrayList;
import robocode.AdvancedRobot;
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
public class RobInterfazAsync extends AdvancedRobot {

    RobotInput ri = new RobotInput();
    private boolean leidos = false;

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

    public RobotInput getInput() {

        //Leer los que sólo se leen una vez
        if (!leidos) {
            ri.setBattleFieldHeight(getBattleFieldHeight());
            ri.setBattleFieldWidth(getBattleFieldWidth());
            ri.setGunCoolingRate(getGunCoolingRate());
            ri.setHeight(getHeight());
            ri.setWidth(getWidth());

            leidos = true;
        }

        //Leer el estado de todas las variables del entorno ahora y devolve junto con las que se han actualizado con los 
        //eventos

        if (ri.isOnstatus()) {
            InStatusEvent in = ri.getOs_event();

            ri.setEnergy(in.getEnergy());
            ri.setGunHeading(in.getGunHeading());
            ri.setGunHeat(in.getGunHeat());
            ri.setHeading(in.getHeading());
            ri.setNumRounds(in.getNumRounds());
            ri.setOthers(in.getOthers());
            ri.setRadarHeading(in.getRadarHeading());
            ri.setRoundNum(in.getRoundNum());
            ri.setTime(in.getTime());
            ri.setVelocity(in.getVelocity());
            ri.setX(in.getX());
            ri.setY(in.getY());
        } else {

            ri.setEnergy(getEnergy());
            ri.setGunHeading(getGunHeading());
            ri.setGunHeat(getGunHeat());
            ri.setHeading(getHeading());
            ri.setNumRounds(getNumRounds());
            ri.setOthers(getOthers());
            ri.setRadarHeading(getRadarHeading());
            ri.setRoundNum(getRoundNum());
            ri.setTime(getTime());
            ri.setVelocity(getVelocity());
            ri.setX(getX());
            ri.setY(getY());
        }

        return ri;
    }

    public void reiniciar_input() {
        //Reiniciar las variables del input
        ri.reiniciar();
        leidos = false;
    }

    public void setOutput(RobotOutput robotOutput) {
        //ro.copy(robotOutput);
    }

    @Override
    public void run() {

        while (true) {

            //Reiniciar las entradas
            this.reiniciar_input();

            //Obtener entradas
            RobotInput input = this.getInput();
            //Calcular salidas
            RobotOutput output = this.responder(input);
            
            //Preparar acciones
            if (output.isAhead()) {
                setAhead(output.getV_ahead());
            }
            if (output.isBack()) {
                setBack(output.getV_back());
            }
            if (output.isFire()) {
                setFire(output.getV_fire());
            }
            if (output.isFireBullet()) {
                setFireBullet(output.getV_firebullet());
            }
//            if (output.isScan()) {
//                scan();
//            }
            if (output.isAdjustgunforrobot()) {
                setAdjustGunForRobotTurn(output.isV_adjustgunforrobot());
            }
            if (output.isAdjustradarforgun()) {
                setAdjustRadarForGunTurn(output.isV_adjustradarforgun());
            }
            if (output.isAdjustradarforrobot()) {
                setAdjustRadarForRobotTurn(output.isV_adjustradarforrobot());
            }
//            if (output.isStop()) {
//                stop();
//            }
            if (output.isGunleft()) {
                setTurnGunLeft(output.getV_gunleft());
            }
            if (output.isGunright()) {
                setTurnGunRight(output.getV_gunright());
            }
            if (output.isTurnleft()) {
                setTurnLeft(output.getV_turnleft());
            }
            if (output.isTurnright()) {
                setTurnRight(output.getV_turnright());
            }
            if (output.isRadarleft()) {
                setTurnRadarLeft(output.getV_radarleft());
            }
            if (output.isRadarright()) {
                setTurnRadarRight(output.getV_radarright());
            }

            //Deja de hacer lo que estuvieras haciendo
            //stop(true);
            
            //Ejecutar las salidas
            execute();

        }
    }

    public RobotOutput responder(RobotInput input) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
