/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MemProc;

import General.ResultadosBatalla;
import General.AnotadorDeResultados;
import Genetica.NNSADNF.IndividuoNNS;
import Genetica.NNSADNF.NNSADNFix;
import Genetica.NNSADNF.PoblacionNNS;
import Training.BattleObserver;
import Training.ControladorDeBatalla;
import Training.MPEvoParams;
import Training.MPEvoState;
import Utiles.F;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import robocode.control.BattleSpecification;
import robocode.control.BattlefieldSpecification;
import robocode.control.RobocodeEngine;
import robocode.control.RobotSpecification;

/**
 *
 * @author Víctor
 */
public class MPEvoManager implements AnotadorDeResultados {

    public static String ruta_poblaciones = "poblacionMP";
    Random r = new Random();
    private ResultadosBatalla resultados;
    RobocodeEngine engine;
    BattleObserver bo;
    MPCB CB;
    private BattleConfig BC = new BattleConfig();

    public MPEvoManager() {
        inicializar();
    }

    private void inicializar() {

        // Disable log messages from Robocode
        RobocodeEngine.setLogMessagesEnabled(false);

        // Create the RobocodeEngine
        //   RobocodeEngine engine = new RobocodeEngine(); // Run from current working directory
        engine = new RobocodeEngine(new java.io.File("C:/Robocode")); // Run from C:/Robocode

        // Add our own battle listener to the RobocodeEngine 
        bo = new BattleObserver();
        CB = new MPCB(this, "Robots.MPRobot");
        engine.addBattleListener(bo);
        engine.addBattleListener(CB);
    }

    public PoblacionMP generarPoblacion(int nindividuos, int longitud_inicial_adn) {
        PoblacionMP respuesta;

        respuesta = PoblacionMP.poblacionAleatoria(nindividuos, longitud_inicial_adn);


        return respuesta;
    }

    //TODO para generalizar simplemente hacer interfaz de población y pasar prefijo quizá con un objeto con interfaz Configuración
    public void lanzarBatalla(PoblacionMP poblacion, boolean visible, int nrounds, int enemigo) {

        int ncuerpos = poblacion.getIndividuos().size();

        //Guardamos la población en un archivo
        poblacion.grabar();

        int numberOfRounds = nrounds;
        BattlefieldSpecification battlefield = new BattlefieldSpecification(800, 600); // 800x600

        StringBuilder sb = new StringBuilder();

        //Añadimos el primer cuerpo

        sb.append("Robots.MPRobot0*");

        //Y los demás si hay
        for (int i = 1; i < ncuerpos; i++) {
            sb.append("," + "Robots.MPRobot").append(i).append("*");
        }

        if (enemigo == 1) {
            sb.append("," + "sample.SpinBot");
        }

        RobotSpecification[] selectedRobots = engine.getLocalRepository(sb.toString());

        BattleSpecification battleSpec = new BattleSpecification(numberOfRounds, battlefield, selectedRobots);

        // Show the Robocode battle view
        engine.setVisible(visible);

        // Run our specified battle and let it run till it is over
        engine.runBattle(battleSpec, true); // waits till the battle finishes

    }

    public void lanzarBatalla(IndividuoMP individuo) {
        lanzarBatalla(individuo, BC.isVisible(), BC.getNrounds(), BC.getEnemigo());
    }

    public void lanzarBatalla(IndividuoMP individuo, boolean visible, int nrounds, int enemigo) {

        PoblacionMP poblacion = new PoblacionMP();
        poblacion.getIndividuos().add(individuo);

        int ncuerpos = poblacion.getIndividuos().size();

        //Guardamos la población en un archivo
        poblacion.grabar();

        int numberOfRounds = nrounds;
        BattlefieldSpecification battlefield = new BattlefieldSpecification(800, 600); // 800x600

        StringBuilder sb = new StringBuilder();

        //Añadimos el primer cuerpo

        sb.append("Robots.MPRobot0*");

        //Y los demás si hay
        for (int i = 1; i < ncuerpos; i++) {
            sb.append("," + "Robots.MPRobot").append(i).append("*");
        }

        if (enemigo == 1) {
            sb.append("," + "sample.SpinBot");
        } else if (enemigo == 2) {
            sb.append("," + "sample.Walls");
        }

        RobotSpecification[] selectedRobots = engine.getLocalRepository(sb.toString());

        BattleSpecification battleSpec = new BattleSpecification(numberOfRounds, battlefield, selectedRobots);

        // Show the Robocode battle view
        engine.setVisible(visible);

        // Run our specified battle and let it run till it is over
        engine.runBattle(battleSpec, true); // waits till the battle finishes

    }

    //public PoblacionMP seleccionarMejores(PoblacionMP poblacion, int nmejores, int ncompetidores) {
    //Hacemos nmejores grupos de ncompetidores individuos y nos quedamos con el mejor
    //}
    @Override
    public void anotarResultados(ResultadosBatalla resultados) {
        this.setResultados(resultados);
    }

    /**
     * @return the resultados
     */
    public ResultadosBatalla getResultados() {
        return resultados;
    }

    /**
     * @param resultados the resultados to set
     */
    private void setResultados(ResultadosBatalla resultados) {
        this.resultados = resultados;
    }

    public void finalizar() {
        engine.close();

        // Make sure that the Java VM is shut down properly
        System.exit(0);
    }

    public IndividuoMP seleccionarMejorDeGrupoCercano(PoblacionMP poblacion, int n, MPEvoParams params, MPEvoState state) {
        IndividuoMP respuesta = null;

        PoblacionMP poblacionSeleccionada = this.obtenerSubPoblacionCercana(poblacion, n);

        ArrayList<IndividuoMP> seleccionados = poblacionSeleccionada.getIndividuos();

        //Aquí ya tenemos un vector con n individuos elegidos por sorteo

        //Comprobamos su fitness
        double maxeval = -1;
        for (int i = 0; i < seleccionados.size(); i++) {
            IndividuoMP individuo = seleccionados.get(i);

            if (!individuo.isCalculado()) {
                individuo.setUltimo_resultado(this.evaluar(individuo, params, state));
                individuo.setCalculado(true);
            }

            double resultado = individuo.getUltimo_resultado();
            //Nos quedamos con el mejor
            if (resultado > maxeval) {
                maxeval = resultado;
                respuesta = individuo;
            }
        }

        return respuesta;
    }

    public IndividuoMP seleccionarMejorDeGrupoAleatorio(PoblacionMP poblacion, int n, MPEvoParams params, MPEvoState state) {
        IndividuoMP respuesta = null;

        PoblacionMP poblacionSeleccionada = this.obtenerSubPoblacionAleatoria(poblacion, n);

        ArrayList<IndividuoMP> seleccionados = poblacionSeleccionada.getIndividuos();

        //Aquí ya tenemos un vector con n individuos elegidos por sorteo

        //Comprobamos su fitness
        double maxeval = -1;
        for (int i = 0; i < seleccionados.size(); i++) {
            IndividuoMP individuo = seleccionados.get(i);

            if (!individuo.isCalculado()) {
                individuo.setUltimo_resultado(this.evaluar(individuo, params, state));
                individuo.setCalculado(true);
            }

            double resultado = individuo.getUltimo_resultado();
            //Nos quedamos con el mejor
            if (resultado > maxeval) {
                maxeval = resultado;
                respuesta = individuo;
            }
        }

        return respuesta;
    }

    private double evaluar(IndividuoMP individuo, MPEvoParams params, MPEvoState state) {
        double respuesta;

        if (params.isDebug()) {


            state.nevals++;
            respuesta = this.distancia(individuo.getAdn(), params.getSolucion());

            //Convertimos la distancia en negativo para que mayor sea mejor, más cerca de cero
            //respuesta = -respuesta;

            //Hacemos el inverso para que cuanto más bajo mejor
            respuesta = 1 / respuesta;

        } else {

            //Evaluamos al individuo y devolvemos su resultado
            this.lanzarBatalla(individuo, BC.isVisible(), BC.getNrounds(), BC.getEnemigo());

            //Los resultados se almacenan en la variable global resultados
            respuesta = resultados.resultados[0] / (double) BC.getNrounds(); //Hacemos la media de los rounds
        }

        return respuesta;
    }

    /**
     * @return the BC
     */
    public BattleConfig getBC() {
        return BC;
    }

    /**
     * @param BC the BC to set
     */
    public void setBC(BattleConfig BC) {
        this.BC = BC;
    }

    public PoblacionMP cruzar(PoblacionMP progenitores, int nhijos) {
        PoblacionMP respuesta = new PoblacionMP();

        int nprogenitores = progenitores.getIndividuos().size();

        //Elaborar vector de adns
        MemProcADN[] adns = new MemProcADN[nprogenitores];

        for (int i = 0; i < nprogenitores; i++) {
            adns[i] = progenitores.getIndividuos().get(i).getAdn();
        }

        //Cruzarlos nhijos veces
        for (int i = 0; i < nhijos; i++) {
            //Crear nuevo individuo
            IndividuoMP individuo = new IndividuoMP();

            MemProcADN nuevoadn = MemProcADN.cruzar(adns);

            individuo.setAdn(nuevoadn);

            respuesta.getIndividuos().add(individuo);
        }



        return respuesta;
    }

    public PoblacionMP obtenerSubPoblacionAleatoria(PoblacionMP poblacion, int n) {
        PoblacionMP respuesta = new PoblacionMP();


        //Seleccionar n individuos de la población
        int spoblacion = poblacion.getIndividuos().size();

        ArrayList<IndividuoMP> individuos = new ArrayList<IndividuoMP>(poblacion.getIndividuos());


        //Si n es menor que spoblación tenemos que quitar algunos de la lista
        if (n < spoblacion) {
            int aeliminar = spoblacion - n;

            for (int i = 0; i < aeliminar; i++) {
                //Seleccionar uno al azar
                int posicion_a_eliminar = r.nextInt(individuos.size() - 1);

                //Eliminarlo
                individuos.remove(posicion_a_eliminar);
            }
        }

        respuesta.setIndividuos(individuos);

        return respuesta;

    }

    public PoblacionMP obtenerSubPoblacionCercana(PoblacionMP poblacion, int n) {
        PoblacionMP respuesta = new PoblacionMP();


        int amplitud_del_grupo = 3;

        //Seleccionar n individuos de la población
        int spoblacion = poblacion.getIndividuos().size();
        ArrayList<Integer> posiciones = new ArrayList<Integer>();

        int posicioninicial = r.nextInt(spoblacion - 1);

        //Seleccionar un individuo de la población al azar
        posiciones.add(posicioninicial);

        int seleccionados = 1;
        int siguente = 1;
        //Seleccionar a partir de él n-1 posiciones de individuos cercanos
        while (seleccionados < n) {
            int posicion = (int) (posicioninicial + (r.nextGaussian() * amplitud_del_grupo));

            //Si nos hemos pasado por arriba volvemos a empezar
            if (posicion > spoblacion - 1) {
                posicion = posicion % (spoblacion - 1);
            } else if (posicion < 0) {
                //Si nos pasamos por abajo volvemos por arriba
                posicion = (spoblacion - 1) - (Math.abs(posicion) % (spoblacion - 1));
            }

            //Comprobamos que no lo hayamos seleccionado antes?
            if (!posiciones.contains(posicion)) {
                posiciones.add(posicion);
                seleccionados++;
            }

        }

        for (int i = 0; i < seleccionados; i++) {
            IndividuoMP individuo = poblacion.getIndividuos().get(posiciones.get(i));
            respuesta.getIndividuos().add(individuo);
        }

        return respuesta;

    }

    public void guardarGeneracion(String id_ejecucion, int generacion, PoblacionMP poblacion, MPEvoParams params) {
        if (params.isPrintToFile()) {
            F.crearCarpeta("resultados/" + id_ejecucion);
            F.guardarArchivo("resultados/" + id_ejecucion + "/" + id_ejecucion + "-g" + generacion, poblacion.toString());
        }
    }

    public IndividuoMP seleccionarPeorDeGrupoAleatorio(PoblacionMP poblacion, int n, MPEvoParams params, MPEvoState state) {

        IndividuoMP respuesta = null;

        PoblacionMP poblacionSeleccionada = this.obtenerSubPoblacionAleatoria(poblacion, n);

        ArrayList<IndividuoMP> seleccionados = poblacionSeleccionada.getIndividuos();

        //Aquí ya tenemos un vector con n individuos elegidos por sorteo

        //Comprobamos su fitness
        double mineval = Double.MAX_VALUE;
        for (int i = 0; i < seleccionados.size(); i++) {
            IndividuoMP individuo = seleccionados.get(i);

            if (!individuo.isCalculado()) {
                individuo.setUltimo_resultado(this.evaluar(individuo, params, state));
                individuo.setCalculado(true);
            }

            double resultado = individuo.getUltimo_resultado();
            //Nos quedamos con el mejor
            if (resultado < mineval) {
                mineval = resultado;
                respuesta = individuo;
            }
        }

        return respuesta;
    }

    public void mutar(PoblacionMP poblacion, MPEvoParams parametros) {
        int l = poblacion.getIndividuos().size();
        for (int i = 0; i < l; i++) {
            IndividuoMP individuo = poblacion.getIndividuos().get(i);
            MemProcADN antiguo = individuo.getAdn();
            MemProcADN nuevo = MemProcADN.mutar(antiguo, parametros);

            individuo.setAdn(nuevo);
        }
    }

    public void guardarResultados(String id_ejecucion, int generacion, PoblacionMP poblacion, MPEvoParams params, MPEvoState state) {

        if (params.isDebug()) {

            //Reponer maxeval en el state
            int npoblacion = poblacion.getIndividuos().size();

            for (int i = 0; i < npoblacion; i++) {
                IndividuoMP individuo = poblacion.getIndividuos().get(i);
                if (individuo.isCalculado()) {
                    double eval = individuo.getUltimo_resultado();
                    if (eval > state.getMaxeval()) {
                        state.setMaxeval(eval);
                        state.adn = Arrays.copyOf(individuo.getAdn().valores, individuo.getAdn().valores.length);
                    }
                }
            }

        } else {
            F.crearCarpeta("resultados/" + id_ejecucion);

            StringBuilder sb = new StringBuilder();

            int npoblacion = poblacion.getIndividuos().size();

            //Anotamos máximo, mímino y media
            double max = -1;
            double min = Double.MAX_VALUE;
            double media = 0;
            int convalor = 0;

            for (int i = 0; i < npoblacion; i++) {
                IndividuoMP individuo = poblacion.getIndividuos().get(i);

                double valor = -1;
                if (individuo.isCalculado()) {
                    valor = individuo.getUltimo_resultado();

                    if (valor > max) {
                        max = valor;
                    }

                    if (valor < min) {
                        min = valor;
                    }

                    media += valor;
                    convalor++;
                }




                sb.append(valor).append("\t");
            }

            //Calculamos la media
            media = media / (double) convalor;

            //Anotamos las 4 últimas columnas
            sb.append(convalor)
                    .append("\t").append(max)
                    .append("\t").append(media)
                    .append("\t").append(min)
                    .append("\n");

            F.appendArchivo("resultados/" + id_ejecucion + "/" + id_ejecucion + "-resultados", sb.toString());
        }
    }

    public PoblacionMP seleccionarMejoresDeGrupoAleatorio(PoblacionMP poblacion, int nmejores, int grupo_size, MPEvoParams params, MPEvoState state) {
        PoblacionMP respuesta = new PoblacionMP();

        //Tantos como nmejores se pidan
        for (int i = 0; i < nmejores; i++) {
            IndividuoMP mejor = this.seleccionarMejorDeGrupoAleatorio(poblacion, grupo_size, params, state);
            respuesta.getIndividuos().add(mejor);
        }

        return respuesta;
    }

    public PoblacionMP seleccionarMejoresDeGrupoCercano(PoblacionMP poblacion, int nmejores, int grupo_size, MPEvoParams params, MPEvoState state) {
        PoblacionMP respuesta = new PoblacionMP();

        //Tantos como nmejores se pidan
        for (int i = 0; i < nmejores; i++) {
            IndividuoMP mejor = this.seleccionarMejorDeGrupoCercano(poblacion, grupo_size, params, state);
            respuesta.getIndividuos().add(mejor);
        }

        return respuesta;
    }

    public PoblacionMP seleccionarPeoresDeGrupoAleatorio(PoblacionMP poblacion, int npeores, int grupo_size, MPEvoParams params, MPEvoState state) {
        PoblacionMP respuesta = new PoblacionMP();

        //Tantos como nmejores se pidan
        for (int i = 0; i < npeores; i++) {
            IndividuoMP peor = this.seleccionarPeorDeGrupoAleatorio(poblacion, grupo_size, params, state);
            respuesta.getIndividuos().add(peor);
        }

        return respuesta;
    }

    public PoblacionMP cargarGeneracion(String id_ejecucion, int generacion, boolean cargar_resultados) {
        String rutaAdn = "resultados/" + id_ejecucion + "/" + id_ejecucion + "-g" + generacion;
        String rutaResultados = "resultados/" + id_ejecucion + "/" + id_ejecucion + "-resultados";

        PoblacionMP respuesta = PoblacionMP.cargarPoblacion(rutaAdn);

        if (cargar_resultados) {
            String cadenaResultados = F.cargarArchivoEntero(rutaResultados);
            String[] lineas = cadenaResultados.split("\n");

            //Seleccionamos la línea de la generación
            String res = lineas[generacion];
            String[] s_resultados = res.split("\t");


            //nindividuos
            int nindividuos = respuesta.getIndividuos().size();
            for (int i = 0; i < nindividuos; i++) {

                double result = Double.parseDouble(s_resultados[i]);
                if (result >= 0) {
                    respuesta.getIndividuos().get(i).setUltimo_resultado(result);
                    respuesta.getIndividuos().get(i).setCalculado(true);
                }
            }
        }
        return respuesta;
    }

    public void competicionDirectaCercana(PoblacionMP poblacion, MPEvoParams params, MPEvoState state) {
        //Seleccionamos ncompetidores individuos cercanos y los nprogenitores mejores se reproducen para sustituir a los nhijos peores

        //obtenemos una subpoblación cercana
        PoblacionMP competidores = this.obtenerSubPoblacionCercana(poblacion, params.getNumero_de_competidores());

        //Los evaluamos a todos y ordenamos de mejor a peor
        for (int i = 0; i < competidores.getIndividuos().size(); i++) {
            IndividuoMP individuo = competidores.getIndividuos().get(i);
            if (!individuo.isCalculado()) {
                individuo.setUltimo_resultado(this.evaluar(individuo, params, state));
                individuo.setCalculado(true);
            }
        }

        PoblacionMP competidoresOrdenados = competidores.ordenar(true);

        //Seleccionamos a los nprogenitores
        PoblacionMP progenitores = new PoblacionMP();
        progenitores.setIndividuos(new ArrayList<IndividuoMP>(competidoresOrdenados.getIndividuos().subList(0, params.getNumero_de_progenitores())));

        //Obtenemos a los descendientes
        PoblacionMP descendientes = this.cruzar(progenitores, params.getNumero_de_descendientes());

        //Mutamos a los descendientes
        this.mutar(descendientes, params);

        //Seleccionamos a los nhijos peores de la población original para sustituirlos
        PoblacionMP peores = new PoblacionMP();
        int inicioPeores = params.getNumero_de_competidores() - params.getNumero_de_descendientes();
        int finPeores = params.getNumero_de_competidores();
        peores.setIndividuos(new ArrayList<IndividuoMP>(competidoresOrdenados.getIndividuos().subList(inicioPeores, finPeores)));

        //Sustituir a los peores por los descendientes
        for (int i = 0; i < params.getNumero_de_descendientes(); i++) {
            IndividuoMP individuo = peores.getIndividuos().get(i);

            individuo.setAdn(descendientes.getIndividuos().get(i).getAdn());

            individuo.setCalculado(false);

        }

    }

    private double distancia(MemProcADN adn, MemProcADN solucion) {
        //Calculamos la distancia euclídea contando los valores que están en un vector y en otro no como lo más distantes posible(1)
        int ladn = adn.valores.length;
        int lsolucion = solucion.valores.length;
        int minl = Math.min(ladn, lsolucion);
        int maxl = Math.max(ladn, lsolucion);

        double diferencias = 0;

        //Calculamos la parte que comparten
        for (int i = 0; i < minl; i++) {
            double dif = Math.abs(adn.valores[i] - solucion.valores[i]);
            diferencias += dif * dif;
        }

        //Calculamos la parte que no comparten aumiendo máxima distancia posible(1)
        int restantes = maxl - minl;

        //sumamos las diferencias restantes, sumamos por cada una ya que 1 al cuadrado sigue siendo 1
        diferencias += restantes;

        //hacemos la raíz cuadrada para obtener la distancia
        return Math.sqrt(diferencias);

    }

    public void guardarParams(String id_ejecucion, MPEvoParams params) {
        if (params.isPrintToFile()) {
            F.crearCarpeta("resultados/" + id_ejecucion);
            F.guardarArchivo("resultados/" + id_ejecucion + "/" + id_ejecucion + "-params", params.toString());
        }
    }
}
