/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Genetica.NNSADNF;

import Genetica.NNSADNF.GestorADN;
import static Genetica.NNSADNF.GestorADN.addPop;
import Genetica.NNSADNF.NNSADNFix;
import Training.BattleObserver;
import Training.ControladorDeBatalla;
import Utiles.F;
import java.util.ArrayList;
import java.util.Random;
import robocode.control.BattleSpecification;
import robocode.control.BattlefieldSpecification;
import robocode.control.RobocodeEngine;
import robocode.control.RobotSpecification;

/**
 *
 * @author Víctor
 */
public class NNSEvoManager {

    Random r = new Random();
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

    public void lanzarBatalla(PoblacionNNS poblacion, boolean visible, int nrounds, int enemigo) {

        int ncuerpos = poblacion.individuos.size();

        //Guardamos la población en un archivo
        F.guardarArchivo(NNSADNFix.rutaPoblacion, poblacion.toString());

        int numberOfRounds = nrounds;
        BattlefieldSpecification battlefield = new BattlefieldSpecification(800, 600); // 800x600

        StringBuilder sb = new StringBuilder();

        //Añadimos el primer cuerpo

        sb.append("Robots.NNSADNFR0*");

        //Y los demás si hay
        for (int i = 1; i < ncuerpos; i++) {
            sb.append("," + "Robots.NNSADNFR").append(i).append("*");
        }

        if (enemigo == 1) {
            sb.append("," + "sample.SpinBot");
        }

        RobotSpecification[] selectedRobots = engine.getLocalRepository(sb.toString());
        /*
         "Robots.NNSADNFR0*"
         + "," + "Robots.NNSADNFR1*"
         + "," + "Robots.NNSADNFR2*"
         + "," + "Robots.NNSADNFR3*"
         + "," + "Robots.NNSADNFR4*"
         + "," + "Robots.NNSADNFR5*"
         + "," + "Robots.NNSADNFR6*"
         + "," + "Robots.NNSADNFR7*"
         + "," + "Robots.NNSADNFR8*"
         + "," + "Robots.NNSADNFR9*"
         + "," + "sample.SpinBot"
         );
         * */

        BattleSpecification battleSpec = new BattleSpecification(numberOfRounds, battlefield, selectedRobots);

        // Show the Robocode battle view
        engine.setVisible(visible);

        // Run our specified battle and let it run till it is over
        engine.runBattle(battleSpec, true); // waits till the battle finishes


        // Cleanup our RobocodeEngine
        //engine.close();
    }

    public void lanzarBatalla(IndividuoNNS individuo, boolean visible, int nrounds, int enemigo) {

        PoblacionNNS poblacion = new PoblacionNNS();
        poblacion.individuos.add(individuo);

        int ncuerpos = 1;

        //Guardamos la población en un archivo
        F.guardarArchivo(NNSADNFix.rutaPoblacion, poblacion.toString());

        int numberOfRounds = nrounds;
        BattlefieldSpecification battlefield = new BattlefieldSpecification(800, 600); // 800x600

        StringBuilder sb = new StringBuilder();

        //Añadimos el primer cuerpo

        sb.append("Robots.NNSADNFR0*");

        //Y los demás si hay
        for (int i = 1; i < ncuerpos; i++) {
            sb.append("," + "Robots.NNSADNFR").append(i).append("*");
        }

        if (enemigo == 1) {
            sb.append("," + "sample.SpinBot");
        }

        RobotSpecification[] selectedRobots = engine.getLocalRepository(sb.toString());
        /*
         "Robots.NNSADNFR0*"
         + "," + "Robots.NNSADNFR1*"
         + "," + "Robots.NNSADNFR2*"
         + "," + "Robots.NNSADNFR3*"
         + "," + "Robots.NNSADNFR4*"
         + "," + "Robots.NNSADNFR5*"
         + "," + "Robots.NNSADNFR6*"
         + "," + "Robots.NNSADNFR7*"
         + "," + "Robots.NNSADNFR8*"
         + "," + "Robots.NNSADNFR9*"
         + "," + "sample.SpinBot"
         );
         * */

        BattleSpecification battleSpec = new BattleSpecification(numberOfRounds, battlefield, selectedRobots);

        // Show the Robocode battle view
        engine.setVisible(visible);

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

        if (resultados != null) {

            //Nresultados
            int nres = resultados.orden.length;

            //Escogemos 3 al azar y seleccionamos el mejor de los 3
            int p1;

            p1 = 0;//Math.min(r.nextInt(nres), Math.min(r.nextInt(nres), r.nextInt(nres)));


            int p2 = p1;

            //Buscamos otro y garantizamos que sea diferente
            while (p2 == p1) {
                p2 = Math.min(r.nextInt(nres), Math.min(r.nextInt(nres), r.nextInt(nres)));
            }


            IndividuoNNS ind1 = poblacion.individuos.get(resultados.orden[p1]);
            IndividuoNNS ind2 = poblacion.individuos.get(resultados.orden[p2]);

            respuesta.individuos.add(ind1);
            respuesta.individuos.add(ind2);
        } else {
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
            IndividuoNNS individuo = respuesta.individuos.get(posicion_del_peor_no_sustituido);
            individuo.adn = descendientes.individuos.get(i).adn;

            //marcamos el individuo como nuevo
            individuo.calculado = false;

            //Ahora vamos a por el siguiente peor
            asustituir--;
        }

        int naleatorios = 1;

        //Introducimos un individuo aleatorio
        for (int i = 0; i < naleatorios; i++) {
            //Obtenemos la posición del peor sin sustituir
            int posicion_del_peor_no_sustituido = resultados.orden[asustituir];
            //Sustituimos el adn del individuo
            IndividuoNNS individuo = respuesta.individuos.get(posicion_del_peor_no_sustituido);
            int longitud = individuo.adn.adn.length;
            individuo.adn.adn = NNSADNFix.randomADN(longitud);
            //lo marcamos como no calculado
            individuo.calculado = false;
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

        F.crearCarpeta("resultados/" + id_ejecucion);
        F.guardarArchivo("resultados/" + id_ejecucion + "/" + id_ejecucion + "-g" + generacion, poblacion.toString());
    }

    public void grabarResultados(String id_ejecucion, ResultadosNNS resultados) {

        //Componemos la fila a añadir
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < resultados.resultados.length; i++) {
            sb.append(resultados.resultados[i]).append("\t");
        }

        sb.append("\n");

        F.crearCarpeta("resultados/" + id_ejecucion);
        F.appendArchivo("resultados/" + id_ejecucion + "/" + id_ejecucion + "-resultados", sb.toString());
    }

    public PoblacionNNS mutar(PoblacionNNS poblacion) {
        //Cambiamos de cada individuo algún valor al azar el 20%

        for (IndividuoNNS ind : poblacion.individuos) {
            NNSADNFix.mutar(ind.adn);
        }






        return poblacion;

    }

    public PoblacionNNS cargarGeneracion(String id_ejecucion, int generacion) {


        String rutaAdn = "resultados/" + id_ejecucion + "/" + id_ejecucion + "-g" + generacion;
        String rutaResultados = "resultados/" + id_ejecucion + "/" + id_ejecucion + "-resultados";

        PoblacionNNS respuesta = new PoblacionNNS();

        //Leer archivo
        String cadenaAdn = F.cargarArchivo(rutaAdn);
        //Dividir por cadenas de adn
        String[] adns = cadenaAdn.split(":");
        //Convertir cadenas a adns y añadir al vector de cadenas

        for (int i = 1; i < adns.length; i++) { //Nos saltamos el primero porque la cadena empieza con ":" y está vacío
            IndividuoNNS individuo = new IndividuoNNS();
            individuo.adn = new NNSADNFix();
            individuo.adn.adn = NNSADNFix.s2adn(adns[i]);
            respuesta.individuos.add(individuo);
        }


        String cadenaResultados = F.cargarArchivoEntero(rutaResultados);
        String[] lineas = cadenaResultados.split("\n");

        //Seleccionamos la línea de la generación
        String res = lineas[generacion];
        String[] resultados = res.split("\t");


        for (int i = 0; i < resultados.length; i++) {

            double result = Double.parseDouble(resultados[i]);

            respuesta.individuos.get(i).ultimo_resultado = result;
            respuesta.individuos.get(i).calculado = true;
        }

        return respuesta;
    }
}
