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


        //Obtener respuesta en bits
        ArrayList<Boolean> rbits = this.responder(entrada);

        //Transformar respuesta de bits a valores de la respuesta
        
        
        //Devolver respuesta
        RobotOutput respuesta = new RobotOutput();
        respuesta.setAhead(true);
        respuesta.setV_ahead(100);

        return respuesta;
    }

    public ArrayList<Boolean> responder(ArrayList<Boolean> input) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
