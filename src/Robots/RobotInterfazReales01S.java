/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Robots;

import Utiles.F;
import robocode.Rules;

/**
 * Esta interfaz pretende mejorar la RobInterfazReales01 haciéndola más simple para el robot
 * @author Víctor
 */
public class RobotInterfazReales01S extends RobInterfazAsync{
    
    public static final int nentradas = 22;
    public static final int nsalidas = 28;
    
    
    @Override
    public RobotOutput responder (RobotInput input){
        RobotOutput out = new RobotOutput();
        
        double[] e = new double[100];
        
        //Valores reales
        e[0] = F.q(input.getEnergy(), 10000, 0);
        e[1] = F.q(input.getGunCoolingRate(), 100, 0);
        e[2] = F.q(input.getGunHeading(), 360, 0);
        e[3] = F.q(input.getGunHeat(), 100, 0);
        e[4] = F.q(input.getHeading(), 360, 0);
        e[5] = F.q(input.getRadarHeading(), 360, 0);
        e[6] = F.q(input.getTime(), Double.MAX_VALUE, 0);
        e[7] = F.q(input.getVelocity(), 100000, 0);
        e[8] = F.q(input.getX(), 5000, 0);
        e[9] = F.q(input.getY(), 5000, 0);
        
        //Valores booleanos
        e[10] = F.h(input.isOnbullethit());
        e[11] = F.h(input.isOnbulletmissed());
        e[12] = F.h(input.isOnhitbybullet());
        e[13] = F.h(input.isOnhitrobotevent());
        e[14] = F.h(input.isOnhitwall());
        e[15] = F.h(input.isOnrobotdeath());
        e[16] = F.h(input.isOnscannedrobot());
        
        //OnScannedRobot
        InScannedRobotEvent osr = input.getOsr_event();
        
        e[17] = F.q(osr.getBearing(), 180, -180);
        e[18] = F.q(osr.getDistance(), 10000, 0);
        e[19] = F.q(osr.getEnergy(), 10000, 0);
        e[20] = F.q(osr.getHeading(), 360, 0);
        e[21] = F.q(osr.getVelocity(), 100000, 0);
        
        
        
        //Obtener respuesta en reales
        double[] s = responder(e);
        
        
        //Transformar las salidas en acciones
        out.setAdjustgunforrobot(F.h(s[0]));
        out.setAdjustradarforgun(F.h(s[1]));
        out.setAdjustradarforrobot(F.h(s[2]));
        out.setAhead(F.h(s[3]));
        out.setBack(F.h(s[4]));
        out.setFire(F.h(s[5]));
        out.setFireBullet(F.h(s[6]));
        out.setGunleft(F.h(s[7]));
        out.setGunright(F.h(s[8]));
        out.setRadarleft(F.h(s[9]));
        out.setRadarright(F.h(s[10]));
        out.setScan(F.h(s[11]));
        out.setStop(F.h(s[12]));
        out.setTurnleft(F.h(s[13]));
        out.setTurnright(F.h(s[14]));
        out.setV_adjustgunforrobot(F.h(s[15]));
        out.setV_adjustradarforgun(F.h(s[16]));
        out.setV_adjustradarforrobot(F.h(s[17]));
        out.setV_ahead(F.q201(s[18], 5000, -5000));
        out.setV_back(F.q201(s[19], 5000, -5000));
        out.setV_fire(F.q201(s[20], Rules.MAX_BULLET_POWER, Rules.MIN_BULLET_POWER));
        out.setV_firebullet(F.q201(s[21], Rules.MAX_BULLET_POWER, Rules.MIN_BULLET_POWER));
        out.setV_gunleft(F.q201(s[22], 180, -180));
        out.setV_gunright(F.q201(s[23], 180, -180));
        out.setV_radarleft(F.q201(s[24], 180, -180));
        out.setV_radarright(F.q201(s[25], 180, -180));
        out.setV_turnleft(F.q201(s[26], 180, -180));
        out.setV_turnright(F.q201(s[27], 180, -180));
        
        
        
        return out;
    }

    public double[] responder(double[] e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
