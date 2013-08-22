/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Training;

import MemProc.IndividuoMP;
import MemProc.MPEvoManager;
import MemProc.PoblacionMP;

/**
 *
 * @author Víctor
 */
public class MPSoloBattle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int longitud_inicial_adn = 300;
        int nindividuos = 20;
        int nrounds = 100;
        
        MPEvoManager evo = new MPEvoManager();
        
        
        //Generar población inicial
        PoblacionMP poblacion = evo.generarPoblacion(nindividuos, longitud_inicial_adn);
        
        //Seleccionar mejores
        //PoblacionMP mejores = evo.seleccionarMejores(poblacion);
        
        //Lanzar batalla de cada individuo contra el enemigo
        for(int i=0; i<nindividuos; i++){
            IndividuoMP individuo = poblacion.getIndividuos().get(i);
            evo.lanzarBatalla(individuo, true, nrounds, 1);
        }
        
        evo.finalizar();
    }
}
