/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Robots;

import java.util.ArrayList;

/**
 *
 * @author Victor
 */
public class RobotInterfazBitsSimple extends RobInterfaz{

    @Override
    public RobotOutput responder(RobotInput input) {
        //Seleccionar entradas y convertir a vector de bits
        /*
        input.energy;
        input.heading;
        input.onhitwall;
        input.ohw_event;
        input.gunHeat;
        input.
        */
        
        ArrayList<Boolean> entrada = new ArrayList<Boolean>();
        
        
        
        //Obtener respuesta en bits
        
        //Transformar respuesta
        
        //Devolver respuesta
        RobotOutput respuesta = new RobotOutput();
        respuesta.setAhead(true);
        respuesta.setV_ahead(100);
        
        return respuesta;
    }
    
}
