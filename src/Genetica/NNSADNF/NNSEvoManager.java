/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Genetica.NNSADNF;

import Genetica.NNSADNF.GestorADN;
import Genetica.NNSADNF.NNSADNFix;
import Training.BattleObserver;
import Training.ControladorDeBatalla;
import Utiles.F;
import java.util.ArrayList;
import robocode.control.BattleSpecification;
import robocode.control.BattlefieldSpecification;
import robocode.control.RobocodeEngine;
import robocode.control.RobotSpecification;

/**
 *
 * @author Víctor
 */
public class NNSEvoManager {

    double[] resultados;
    int[] orden;
    RobocodeEngine engine;
    BattleObserver bo;
    ControladorDeBatalla CB;

    public NNSEvoManager() {
        inicializar();
    }

    public void inicializar() {



        // Disable log messages from Robocode
        RobocodeEngine.setLogMessagesEnabled(false);

        // Create the RobocodeEngine
        //   RobocodeEngine engine = new RobocodeEngine(); // Run from current working directory
        engine = new RobocodeEngine(new java.io.File("C:/Robocode")); // Run from C:/Robocode

        // Add our own battle listener to the RobocodeEngine 
        bo = new BattleObserver();
        CB = new ControladorDeBatalla(this);
        engine.addBattleListener(bo);
        engine.addBattleListener(CB);
    }

    public void generarPoblacionInicial(int longitud) {
        //CargarADN random
        Genetica.NNSADNF.GestorADN.addRandomPop(10, longitud);

        //Guardar población en archivo
        GestorADN.savetofile("poblaciones");
    }

    public PoblacionNNS generarPoblacionInicial(int n, int longitudADN) {
        PoblacionNNS respuesta = new PoblacionNNS();
        for (int i = 0; i < n; i++) {
            NNSADNFix adn = new NNSADNFix();
            adn.adn = NNSADNFix.randomADN(longitudADN);

            IndividuoNNS ind = new IndividuoNNS();
            ind.adn = adn;

            respuesta.individuos.add(ind);
        }

        return respuesta;
    }

    public void lanzarBatalla(PoblacionNNS poblacion) {

        //Guardamos la población en un archivo
        F.guardarArchivo(NNSADNFix.rutaPoblacion, poblacion.toString());

        int numberOfRounds = 1;
        BattlefieldSpecification battlefield = new BattlefieldSpecification(800, 600); // 800x600
        RobotSpecification[] selectedRobots = engine.getLocalRepository(
                "Robots.NNSADNFR0*,"
                + "Robots.NNSADNFR1*,"
                + "Robots.NNSADNFR2*,"
                + "Robots.NNSADNFR3*,"
                + "Robots.NNSADNFR4*,"
                + "Robots.NNSADNFR5*,"
                + "Robots.NNSADNFR6*,"
                + "Robots.NNSADNFR7*,"
                + "Robots.NNSADNFR8*,"
                + "Robots.NNSADNFR9*");

        BattleSpecification battleSpec = new BattleSpecification(numberOfRounds, battlefield, selectedRobots);

        // Show the Robocode battle view
        engine.setVisible(true);

        // Run our specified battle and let it run till it is over
        engine.runBattle(battleSpec, true); // waits till the battle finishes


        // Cleanup our RobocodeEngine
        //engine.close();
    }

    public void anotarResultados(double[] resultados, int[] orden) {
        this.resultados = resultados;
        this.orden = orden;
    }

    public ResultadosNNS getResultados() {
        ResultadosNNS respuesta = new ResultadosNNS();

        respuesta.resultados = this.resultados;
        respuesta.orden = this.orden;

        return respuesta;
    }

    public PoblacionNNS seleccionarMejores(PoblacionNNS poblacion, ResultadosNNS resultados) {
        //Seleccionamos los mejores de la población según los resultados obtenidos
        PoblacionNNS respuesta = new PoblacionNNS();

        if(resultados !=null){
        //De momento serán los 2 primeros
        IndividuoNNS mejor = poblacion.individuos.get(resultados.orden[0]);
        IndividuoNNS segundo = poblacion.individuos.get(resultados.orden[1]);

        respuesta.individuos.add(mejor);
        respuesta.individuos.add(segundo);
        }else{
            System.err.println("Los resultados son null");
        }
        return respuesta;
    }

    /**
     * Devuelve tantos descendientes como se indiquen de los individuos en la
     * población mejores
     *
     * @param mejores
     * @param descendientes
     * @return
     */
    //TODO estamos suponiendo que llegan siempre dos individuos en la población "mejores"
    public PoblacionNNS cruzar(PoblacionNNS mejores, int descendientes) {
        PoblacionNNS respuesta = new PoblacionNNS();

        for (int i = 0; i < descendientes; i++) {
            //Generamos el nuevo adn
            NNSADNFix nuevoadn = NNSADNFix.cruzar(mejores.individuos.get(0).adn, mejores.individuos.get(1).adn);
            //Generamos el nuevo individuo
            IndividuoNNS nuevo = new IndividuoNNS();
            nuevo.adn = nuevoadn;
            //Lo añadimos a la población de respuesta
            respuesta.individuos.add(nuevo);
        }


        return respuesta;
    }

    public PoblacionNNS sustituirPoblacion(PoblacionNNS poblacion, ResultadosNNS resultados, PoblacionNNS descendientes) {
        PoblacionNNS respuesta = new PoblacionNNS();

        //De momento simplemente sustituiremos los peores por los descendientes


        //Identificamos a los 3 peores y los sustituimos
        int npob = poblacion.individuos.size();
        int nnuevos = descendientes.individuos.size();

        //Copiamos la población
        respuesta.individuos = new ArrayList<IndividuoNNS>(poblacion.individuos);

        int asustituir = npob - 1;
        for (int i = 0; i < nnuevos; i++) {
            //Obtenemos la posición del peor sin sustituir
            int posicion_del_peor_no_sustituido = resultados.orden[asustituir];
            //Sustituimos el adn del individuo //TODO sólo estamos sustituyendo el ADN del individuo
            respuesta.individuos.get(posicion_del_peor_no_sustituido).adn = descendientes.individuos.get(i).adn;
            //Ahora vamos a por el siguiente peor
            asustituir--;
        }




        return respuesta;

    }

    public void finalizar() {
        engine.close();

        // Make sure that the Java VM is shut down properly
        System.exit(0);
    }

    //Guarda la población como generación i en un archivo
    //public void guardarGeneracion(int i, PoblacionNNS poblacion) {
        //F.guardarArchivo("g"+i+"-"+System.currentTimeMillis(), poblacion.toString());
    //}

    public void guardarGeneracion(String id_ejecucion, int generacion, PoblacionNNS poblacion) {
        
        F.crearCarpeta(id_ejecucion);
        F.guardarArchivo(id_ejecucion + "/" + id_ejecucion + "-g" + generacion, poblacion.toString());
    }

    public void grabarResultados(String id_ejecucion, ResultadosNNS resultados) {
        
        //Componemos la fila a añadir
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<resultados.resultados.length; i++){
            sb.append(resultados.resultados[i]).append("\t");
        }
        
        sb.append("\n");
        
        F.crearCarpeta(id_ejecucion);
        F.appendArchivo(id_ejecucion + "/" + id_ejecucion + "-resultados", sb.toString());
    }
}
