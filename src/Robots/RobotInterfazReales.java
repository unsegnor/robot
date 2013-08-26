/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Robots;

import Utiles.F;
import robocode.Rules;

/**
 * Esta interfaz convierte todas las entradas en un vector de valores reales
 * @author Víctor
 */
public class RobotInterfazReales extends RobInterfazAsync{
    
    public static final int nentradas = 35;
    public static final int nsalidas = 28;
    
    
    @Override
    public RobotOutput responder (RobotInput input){
        RobotOutput out = new RobotOutput();
        
        double[] e = new double[nentradas];
        
        //Valores reales
        e[0] = F.q(input.getBattleFieldHeight(), 5000, 0);
        e[1] = F.q(input.getBattleFieldWidth(), 5000, 0);
        e[2] = F.q(input.getEnergy(), 10000, 0);
        e[3] = F.q(input.getGunCoolingRate(), 100, 0);
        e[4] = F.q(input.getGunHeading(), 360, 0);
        e[5] = F.q(input.getGunHeat(), 100, 0);
        e[6] = F.q(input.getHeading(), 360, 0);
        e[7] = F.q(input.getHeight(), 5000, 0);
        e[8] = F.q(input.getNumRounds(), Integer.MAX_VALUE, 0);
        e[9] = F.q(input.getOthers(), Integer.MAX_VALUE, 0);
        e[10] = F.q(input.getRadarHeading(), 360, 0);
        e[11] = F.q(input.getRoundNum(), Integer.MAX_VALUE, 0);
        e[12] = F.q(input.getTime(), Double.MAX_VALUE, 0);
        e[13] = F.q(input.getVelocity(), 100000, 0);
        e[14] = F.q(input.getWidth(), 5000, 0);
        e[15] = F.q(input.getX(), 5000, 0);
        e[16] = F.q(input.getY(), 5000, 0);
        
        //Valores booleanos
        e[17] = F.h(input.isObattleended());
        e[18] = F.h(input.isOnbullethit());
        e[19] = F.h(input.isOnbullethitbullet());
        e[20] = F.h(input.isOnbulletmissed());
        e[21] = F.h(input.isOndeath());
        e[22] = F.h(input.isOnhitbybullet());
        e[23] = F.h(input.isOnhitrobotevent());
        e[24] = F.h(input.isOnhitwall());
        e[25] = F.h(input.isOnrobotdeath());
        e[26] = F.h(input.isOnroundended());
        e[27] = F.h(input.isOnscannedrobot());
        e[28] = F.h(input.isOnstatus());
        e[29] = F.h(input.isOnwin());
        
        //OnScannedRobot
        InScannedRobotEvent osr = input.getOsr_event();
        
        e[30] = F.q(osr.getBearing(), 180, -180);
        e[31] = F.q(osr.getDistance(), 10000, 0);
        e[32] = F.q(osr.getEnergy(), 10000, 0);
        e[33] = F.q(osr.getHeading(), 360, 0);
        e[34] = F.q(osr.getVelocity(), 100000, 0);
        
        
        
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
        out.setV_ahead(F.q2(s[18], 5000, -5000));
        out.setV_back(F.q2(s[19], 5000, -5000));
        out.setV_fire(F.q2(s[20], Rules.MAX_BULLET_POWER, Rules.MIN_BULLET_POWER));
        out.setV_firebullet(F.q2(s[21], Rules.MAX_BULLET_POWER, Rules.MIN_BULLET_POWER));
        out.setV_gunleft(F.q2(s[22], 180, -180));
        out.setV_gunright(F.q2(s[23], 180, -180));
        out.setV_radarleft(F.q2(s[24], 180, -180));
        out.setV_radarright(F.q2(s[25], 180, -180));
        out.setV_turnleft(F.q2(s[26], 180, -180));
        out.setV_turnright(F.q2(s[27], 180, -180));
        
        
        
        return out;
    }

    public double[] responder(double[] e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
