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
public class MPEvoSoloBattleEspeciacion {

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
        params.setNumero_de_descendientes(1);
        params.setNumero_de_individuos(1000);
        params.setNumero_de_progenitores(2);
        params.setProbabilidad_de_mutacion(0.2);

        params.setSolucion(MemProcADN.aleatorio(300));
        params.setDebug(false);
        params.setPrintToFile(true);


        MPEvoState state = new MPEvoState();

        MPEvoManager evo = new MPEvoManager();

        //Establecer configuración de las batallas
        BattleConfig bc = new BattleConfig();
        bc.setEnemigo(1);
        bc.setNrounds(100);
        bc.setVisible(false);

        evo.setBC(bc);

        DateFormat dateFormat = new SimpleDateFormat("ddMMyyyyHHmmss");
        Date hoy = new Date();
        String id_ejecucion = dateFormat.format(hoy);

        //Generar población inicial
        PoblacionMP poblacion = evo.generarPoblacion(params.getNumero_de_individuos(), params.getLongitud_solucion_inicial());

        for (int i = 0; i < Integer.MAX_VALUE; i++) {

            evo.competicionDirectaCercana(poblacion, params, state);


            //Almacenar generacion
            evo.guardarGeneracion(id_ejecucion, i, poblacion, params);
            //Almacenar los resultados
            evo.guardarResultados(id_ejecucion, i, poblacion, params, state);

            //Imprimir los resultados por pantalla
            if (params.isDebug()) {
                if (state.newmax) {
                    System.out.println(i + "\t" + state.getMaxeval());
                    state.newmax = false;
                }
            }


        }

        evo.finalizar();
    }
}
