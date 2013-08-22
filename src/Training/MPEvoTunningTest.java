/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Training;

import MemProc.MemProcADN;
import java.util.ArrayList;

/**
 *
 * @author Víctor
 */
public class MPEvoTunningTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Determinamos la solución a la que llegar
        MemProcADN solucion = MemProcADN.aleatorio(300);
        MPEvoState state = new MPEvoState();
        
        MPEvoParams params = new MPEvoParams();
        
        params.setSolucion(solucion);
        params.setDebug(true);
        
        //Generamos población de MPEvoParamsADN
        
        
        
        
        
        //Configuración
        MPEvoTunnerConf configuracion = new MPEvoTunnerConf();
        configuracion.solucion = solucion;
        
        //Determinamos los parámetros de la evolución       
        MPEvoParamsADN adnparams = new MPEvoParamsADN();
        params.setFromADN(adnparams);
        
        //Evaluar evolución
        double resultado = MPEvoTunner.evaluar(params, configuracion);
        
        
    }
}
