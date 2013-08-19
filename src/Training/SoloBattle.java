/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Training;

import Genetica.NNSADNF.IndividuoNNS;
import Genetica.NNSADNF.NNSADNFix;
import Genetica.NNSADNF.NNSEvoManager;
import Genetica.NNSADNF.PoblacionNNS;
import Genetica.NNSADNF.ResultadosNNS;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

/**
 *
 * Ejecuta un conjunto de batallas para evolucionar un robot. Sólo se emplea un
 * cuerpo de robot.
 *
 * @author Víctor
 */
public class SoloBattle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        NNSEvoManager evo = new NNSEvoManager();

        int nrounds = 100;

        boolean visible = false;

        int npoblacion = 20;

        double maxeval = 0;

        PoblacionNNS poblacion = evo.generarPoblacionInicial(npoblacion, NNSADNFix.longADN(NNSADNFix.globalCapas));
        DateFormat dateFormat = new SimpleDateFormat("ddMMyyyyHHmmss");
        Date hoy = new Date();
        String id_ejecucion = dateFormat.format(hoy);
        for (int i = 0; i < 2000; i++) {
            if (i > 10) {
                //visible = true;
            }
            evo.guardarGeneracion(id_ejecucion, i, poblacion);

            //Lanzamos una batalla por cada individuo
            int l = poblacion.individuos.size();
            PoblacionNNS unoPoblacion = new PoblacionNNS();
            unoPoblacion.individuos.add(poblacion.individuos.get(0));

            //Estructura para almacenar los resultados
            ArrayList<Resultado> res = new ArrayList<Resultado>();


            //Como aquí el problema es siempre el mismo podemos aprovechar para los individuos que repiten los datos que teníamos y ahorrar evaluaciones

            for (int ind = 0; ind < npoblacion; ind++) {
                //Si el individuo ya tiene el resultado calculado pasamos
                IndividuoNNS individuo = poblacion.individuos.get(ind);
                if (!individuo.calculado) {
                    //Si no tenemos resultado lo calculamos
                    unoPoblacion.individuos.set(0, individuo);
                    evo.lanzarBatalla(unoPoblacion, visible, nrounds, 1); //Espera a que termine
                    ResultadosNNS resultados = evo.getResultados(); //Conformamos nuestros propios resultados
                    //todosResultados.resultados[ind] = resultados.resultados[0]; //Anotamos el resultado de este individuo
                    double i_resultado = resultados.resultados[0] / nrounds;//Hacemos la media de puntos por ronda
                    res.add(new Resultado(ind, i_resultado));
                    //marcamos el individuo como calculado con su valor
                    individuo.ultimo_resultado = i_resultado;
                    individuo.calculado = true;

                    if (i_resultado > maxeval) {
                        maxeval = i_resultado;
                        System.out.println("Maxeval: " + maxeval);
                        //Lanzamos una batalla visible con 3 rounds para ver el comportamiento
                        //evo.lanzarBatalla(unoPoblacion, true, 3, 1);
                    }

                } else {
                    //Si ya hemos calculado el fitness lo dejamos
                    res.add(new Resultado(ind, individuo.ultimo_resultado));
                }
            }
            //Ordenamos los resultados y formamos los dos vectores esperados
            //Al salir de aquí están ya ordenados por identificador
            double[] v_resultados = new double[npoblacion];

            for (int o = 0; o < res.size(); o++) {
                v_resultados[o] = (res.get(o).b);
            }

            //Ahora los ordenamos por resultado
            Collections.sort(res, new OrdenarResultados(true, true));
            int[] v_orden = new int[npoblacion];

            for (int j = 0; j < res.size(); j++) {
                v_orden[j] = res.get(j).a;
            }



            ResultadosNNS todosResultados = new ResultadosNNS();
            todosResultados.resultados = v_resultados;
            todosResultados.orden = v_orden;



            PoblacionNNS mejores = evo.seleccionarMejores(poblacion, todosResultados);
            PoblacionNNS descendientes = evo.cruzar(mejores, 10); //Generamos 10 nuevos descendientes
            PoblacionNNS mutados = evo.mutar(descendientes); //Mutamos los que no son descendientes
            poblacion = evo.sustituirPoblacion(poblacion, todosResultados, mutados);
            evo.grabarResultados(id_ejecucion, todosResultados);

        }

        evo.finalizar();








    }
}
