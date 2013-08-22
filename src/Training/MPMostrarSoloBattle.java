/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Training;

import Genetica.NNSADNF.IndividuoNNS;
import Genetica.NNSADNF.PoblacionNNS;
import MemProc.BattleConfig;
import MemProc.IndividuoMP;
import MemProc.MPEvoManager;
import MemProc.MemProcADN;
import MemProc.PoblacionMP;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Víctor
 */
public class MPMostrarSoloBattle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //int longitud_inicial_adn = 300;
        //int nindividuos = 20;
        int nprogenitores = 2;
        int ngrupos = 3;
        int nhijos = 3;
        
        String id_ejecucion = "21082013122802";
        int generacion = 7500;

        MPEvoManager evo = new MPEvoManager();

        //Establecer configuración de las batallas
        BattleConfig bc = new BattleConfig();
        bc.setEnemigo(1);
        bc.setNrounds(10);
        bc.setVisible(true);

        evo.setBC(bc);

        

        //Cargar población
        PoblacionMP poblacion = evo.cargarGeneracion(id_ejecucion, generacion, true);

                //Obtener orden de individuos
        PoblacionMP ordenada = poblacion.ordenar(true);
        
        //Recorrer ordenada mostrando las batallas
        int nindividuos = ordenada.getIndividuos().size();
        for(int i=0; i<nindividuos; i++){
            
            IndividuoMP individuo = ordenada.getIndividuos().get(i);
            
            //Lanar una batalla para el individuo
            evo.lanzarBatalla(individuo);
            
        }

        evo.finalizar();
    }
}
