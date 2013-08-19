/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Training;


import Genetica.NNSADNF.NNSADNFix;
import Genetica.NNSADNF.NNSEvoManager;
import Genetica.NNSADNF.PoblacionNNS;
import Genetica.NNSADNF.ResultadosNNS;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import robocode.control.events.BattleAdaptor;

/**
 *
 * @author Víctor
 */
public class NNSFADNEvoBattle10 extends BattleAdaptor {

    public static void main(String[] args) throws InterruptedException {

        NNSEvoManager evo = new NNSEvoManager();

        int nrounds = 10;

        boolean visible = true;


        PoblacionNNS poblacion = evo.generarPoblacionInicial(10, NNSADNFix.longADN(NNSADNFix.globalCapas));
        DateFormat dateFormat = new SimpleDateFormat("ddMMyyyyHHmmss");
        Date hoy = new Date();
        String id_ejecucion = dateFormat.format(hoy);
        for (int i = 0; i < 2000; i++) {
            if (i>100) visible = true;
            evo.guardarGeneracion(id_ejecucion,i,poblacion);
            evo.lanzarBatalla(poblacion,visible,nrounds,1); //Espera a que termine
            
            ResultadosNNS resultados = evo.getResultados();
            PoblacionNNS mejores = evo.seleccionarMejores(poblacion, resultados);
            PoblacionNNS descendientes = evo.cruzar(mejores, 3); //Generamos 3 nuevos descendientes
            PoblacionNNS mutados = evo.mutar(descendientes); //Mutamos los que no son descendientes
            poblacion = evo.sustituirPoblacion(poblacion, resultados, mutados);
            evo.grabarResultados(id_ejecucion, resultados);
        }

            evo.finalizar();


    }

    private void generarPoblacion() {
    }

    private void evaluarPoblacion() {
    }
}