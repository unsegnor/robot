/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Training;

import Genetica.NNSADNF.NNSEvoManager;
import Robots.NNSADNFR;
import robocode.control.events.BattleAdaptor;
import robocode.control.events.BattleCompletedEvent;

/**
 *
 * @author Víctor
 */
public class ControladorDeBatalla extends BattleAdaptor {

    NNSEvoManager evo;

    public ControladorDeBatalla(NNSEvoManager evomanager) {
        this.evo = evomanager;
    }

    //Cuando la batalla termina 
    public void onBattleCompleted(BattleCompletedEvent e) {

        //Aquí tenemos los resultados de la última batalla, los valores de fitness calculados

        //Los pasamos al GestorADN en forma de array de resultados
        int l = e.getIndexedResults().length;
        double[] resultados = new double[l];
        int[] resultadosOrdenados = new int[l];


        int orden = 0;

        for (robocode.BattleResults result : e.getSortedResults()) {
            String cadena = result.getTeamLeaderName();

            //Si no es de los nuestros no lo anotamos
            if (cadena.contains(NNSADNFR.prefijo)) {

                int id_robot = Integer.parseInt(cadena.substring((NNSADNFR.prefijo.length()), cadena.length() - 1));

                //Almacenamos el resultado del robot
                resultados[id_robot] = result.getScore();

                //System.out.println("  " + result.getTeamLeaderName() + ": " + result.getScore());

                resultadosOrdenados[orden] = id_robot;
                orden++;
            }
        }

        //Ahora pasamos los resultados al GestorADN que decidirá a quién cruzar con quien y todo eso
        evo.anotarResultados(resultados, resultadosOrdenados);
    }
}
