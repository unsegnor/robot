/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Robots;

import Utiles.F;
import java.util.ArrayList;

/**
 *
 * @author Victor
 */
public class RobotInterfazBitsSimple extends RobInterfaz {

    @Override
    public RobotOutput responder(RobotInput input) {
        //Seleccionar entradas y convertir a vector de bits
        InScannedRobotEvent osr = input.getOsr_event();

        ArrayList<Boolean> entrada = new ArrayList<Boolean>();

        entrada.addAll(F.tobinary(input.getEnergy()));
        entrada.addAll(F.tobinary(input.getRadarHeading()));
        entrada.addAll(F.tobinary(input.getGunHeading()));
        entrada.addAll(F.tobinary(input.getGunHeat()));
        entrada.addAll(F.tobinary(input.getHeading()));
        entrada.addAll(F.tobinary(input.getOthers()));
        entrada.addAll(F.tobinary(input.getX()));
        entrada.addAll(F.tobinary(input.getY()));
        entrada.addAll(F.tobinary(input.getVelocity()));
        entrada.addAll(F.tobinary(input.isOnhitbybullet()));
        entrada.addAll(F.tobinary(input.getOhbb_event().getBearing()));
        entrada.addAll(F.tobinary(input.isOnhitrobotevent()));
        entrada.addAll(F.tobinary(input.getOhr_event().getBearing()));
        entrada.addAll(F.tobinary(input.isOnhitwall()));
        entrada.addAll(F.tobinary(input.getOhw_event().getBearing()));
        entrada.addAll(F.tobinary(input.isOnscannedrobot()));

        entrada.addAll(F.tobinary(osr.getBearing()));
        entrada.addAll(F.tobinary(osr.getDistance()));
        entrada.addAll(F.tobinary(osr.getEnergy()));
        entrada.addAll(F.tobinary(osr.getHeading()));
        entrada.addAll(F.tobinary(osr.getVelocity()));


        //Obtener respuesta en bits (la respuesta debe tener 231 bits)
        ArrayList<Boolean> rbits = this.responder(entrada);

        //Transformar respuesta de bits a valores de la respuesta
        RobotOutput respuesta = new RobotOutput();
        
        respuesta.setAdjustgunforrobot(rbits.get(0));
        respuesta.setV_adjustgunforrobot(rbits.get(1));
        respuesta.setAdjustradarforgun(rbits.get(2));
        respuesta.setV_adjustradarforgun(rbits.get(3));
        respuesta.setAdjustradarforrobot(rbits.get(4));
        respuesta.setV_adjustradarforrobot(rbits.get(5));
        respuesta.setAhead(rbits.get(6));
        respuesta.setV_ahead(F.s(rbits,6,30));
        respuesta.setBack(rbits.get(30));
        respuesta.setV_back(F.s(rbits,31, 55));
        respuesta.setFire(rbits.get(55));
        respuesta.setV_fire(F.s(rbits,56,80));
        respuesta.setGunleft(rbits.get(80));
        respuesta.setV_gunleft(F.s(rbits, 81, 105));
        respuesta.setGunright(rbits.get(105));
        respuesta.setV_gunright(F.s(rbits, 106,130));
        respuesta.setRadarleft(rbits.get(130));
        respuesta.setV_radarleft(F.s(rbits,131, 155));
        respuesta.setRadarright(rbits.get(155));
        respuesta.setV_radarright(F.s(rbits,156,180));
        respuesta.setTurnleft(rbits.get(180));
        respuesta.setV_turnleft(F.s(rbits, 181,205));
        respuesta.setTurnright(rbits.get(205));
        respuesta.setV_turnright(F.s(rbits, 206, 230));
        respuesta.setScan(rbits.get(230));
        respuesta.setStop(rbits.get(231));

        //Devolver respuesta
        

        return respuesta;
    }

    public ArrayList<Boolean> responder(ArrayList<Boolean> input) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
