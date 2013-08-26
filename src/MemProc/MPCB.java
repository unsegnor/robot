/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MemProc;

import General.ResultadosBatalla;
import General.AnotadorDeResultados;
import Genetica.NNSADNF.NNSEvoManager;
import Robots.NNSADNFR;
import robocode.control.events.BattleAdaptor;
import robocode.control.events.BattleCompletedEvent;

/**
 * Controlador de Batalla para MP
 * @author Víctor
 */
public class MPCB extends BattleAdaptor{
    
    AnotadorDeResultados anotador;
    String prefijo;

    /**
     * El prefijo es el que se utilizará para reconocer los nombres de los robots cuyos resultados debemos anotar
     * @param anotador
     * @param prefijo 
     */
    public MPCB(AnotadorDeResultados anotador, String prefijo) {
        this.anotador = anotador;
        this.prefijo = prefijo;
    }

    //Cuando la batalla termina 
    @Override
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
            if (cadena.contains(prefijo)) {

                int id_robot = Integer.parseInt(cadena.substring((prefijo.length()), cadena.length() - 1));

                //Almacenamos el resultado del robot
                resultados[id_robot] = result.getScore();
                //resultados[id_robot] = result.getBulletDamage();

                //System.out.println("  " + result.getTeamLeaderName() + ": " + result.getScore());

                resultadosOrdenados[orden] = id_robot;
                orden++;
            }
        }

        //Generamos resultados de batalla
        ResultadosBatalla rb = new ResultadosBatalla();
        rb.orden = resultadosOrdenados;
        rb.resultados = resultados;
        
        //Ahora pasamos los resultados al anotador 
        anotador.anotarResultados(rb);
    }
}
