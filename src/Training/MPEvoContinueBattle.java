/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Training;

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
public class MPEvoContinueBattle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        MPEvoParams params = new MPEvoParams();
        params.setLongitud_solucion_inicial(300);
        params.setDiferencia_minima_en_cruce(0.01);
        params.setMaximo_decremento_adn(10);
        params.setMaximo_incremento_adn(10);
        params.setNumero_de_competidores(3);
        params.setNumero_de_descendientes(3);
        params.setNumero_de_individuos(20);
        params.setNumero_de_progenitores(2);
        params.setProbabilidad_de_mutacion(0.2);
        
        
        String id_ejecucion = "21082013122802";
        int generacion = 7881;

        MPEvoManager evo = new MPEvoManager();

        MPEvoState state = new MPEvoState();
        
        //Establecer configuración de las batallas
        BattleConfig bc = new BattleConfig();
        bc.setEnemigo(1);
        bc.setNrounds(100);
        bc.setVisible(false);

        evo.setBC(bc);

        

        //Cargar población
        PoblacionMP poblacion = evo.cargarGeneracion(id_ejecucion, generacion, false);

        for (int i = generacion+1; i < Integer.MAX_VALUE; i++) {
            

            //Población de progenitores seleccionamos 2 de grupos de 3
            PoblacionMP progenitores = evo.seleccionarMejoresDeGrupoAleatorio(poblacion, params.getNumero_de_progenitores(),params.getNumero_de_competidores(), params,state);

            //Cruzar los progenitores y obtener 3 descendientes
            PoblacionMP descendientes = evo.cruzar(progenitores, params.getNumero_de_descendientes());

            //Mutar descendientes
            evo.mutar(descendientes, params);

            //Seleccionar peores de la población
            PoblacionMP peores = evo.seleccionarPeoresDeGrupoAleatorio(poblacion, params.getNumero_de_descendientes(), params.getNumero_de_competidores(), params, state);

            //Sustituir peores por los descendientes
            int l=peores.getIndividuos().size();
            
            for (int j=0; j<l; j++){
                IndividuoMP individuo = peores.getIndividuos().get(j);
                MemProcADN nuevoadn = descendientes.getIndividuos().get(j).getAdn();
                individuo.setAdn(nuevoadn);
                individuo.setCalculado(false);
            }


            //Almacenar generacion
            evo.guardarGeneracion(id_ejecucion, i, poblacion, params);
            //Almacenar los resultados
            evo.guardarResultados(id_ejecucion, i, poblacion, params, state);


        }

        evo.finalizar();
    }
}
