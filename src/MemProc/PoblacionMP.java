/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MemProc;

import Genetica.NNSADNF.IndividuoNNS;
import Genetica.NNSADNF.PoblacionNNS;
import Training.OrdenarPoblacionNNS;
import Utiles.F;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Víctor
 */
public class PoblacionMP {

    public static final String rutaPoblacion = "poblacionMP";

        private ArrayList<IndividuoMP> individuos = new ArrayList<IndividuoMP>();
    
    static PoblacionMP poblacionAleatoria(int nindividuos, int longitud_inicial_adn) {
        PoblacionMP respuesta = new PoblacionMP();

        //Generamos los individuos con adn aleatorio y los agregamos a la población

        for (int i = 0; i < nindividuos; i++) {
            //Generar individuo con adn aleatorio
            IndividuoMP individuo = new IndividuoMP();
            individuo.setAdn(MemProcADN.aleatorio(longitud_inicial_adn));

            //Agregar el individuo a la población
            respuesta.getIndividuos().add(individuo);
        }

        return respuesta;
    }


    public static PoblacionMP cargarPoblacion() {
        return cargarPoblacion(rutaPoblacion);
    }

    public static PoblacionMP cargarPoblacion(String ruta) {
        PoblacionMP respuesta = new PoblacionMP();

        //Leer el archivo
        String cadena = F.cargarArchivo(ruta);

        //Dividir la cadena
        String[] s_adns = cadena.split(":");

        //Para cada cadena que es un adn lo cargamos
        for (int i = 0; i < s_adns.length; i++) {
            //Obtenemos el adn
            MemProcADN adn = MemProcADN.parseADN(s_adns[i]);

            //Generamos el individuo
            IndividuoMP individuo = new IndividuoMP();
            individuo.setAdn(adn);

            //Lo añadimos a la población de respuesta
            respuesta.getIndividuos().add(individuo);
        }

        return respuesta;
    }

    public void grabar() {
        grabarPoblacion(this);
    }

    public void grabar(String ruta) {
        grabarPoblacion(this, ruta);
    }

    public static void grabarPoblacion(PoblacionMP poblacion) {
        grabarPoblacion(poblacion, rutaPoblacion);
    }

    private static void grabarPoblacion(PoblacionMP poblacion, String ruta) {
        //Componer cadena
        String cadena = poblacion.toString();

        //Grabar la cadena en el archivo
        F.guardarArchivo(ruta, cadena);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        int nindividuos = this.getIndividuos().size();

        if (nindividuos > 0) {

            //Grabamos el primero
            sb.append(getIndividuos().get(0).toString());

            //Grabamos el resto
            for (int i = 1; i < nindividuos; i++) {
                sb.append(":").append(getIndividuos().get(i).toString());
            }

        }
        return sb.toString();
    }

    /**
     * @return the individuos
     */
    public ArrayList<IndividuoMP> getIndividuos() {
        return individuos;
    }

    /**
     * @param individuos the individuos to set
     */
    public void setIndividuos(ArrayList<IndividuoMP> individuos) {
        this.individuos = individuos;
    }

    public PoblacionMP ordenar(boolean inverso) {
         PoblacionMP respuesta = new PoblacionMP();
        
        //Copiamos el vector de individuos
        respuesta.setIndividuos(new ArrayList<IndividuoMP>(this.getIndividuos()));
        
        //Ordenamos el vector de la respuesta
        Collections.sort(respuesta.getIndividuos(), new OrdenarPoblacionMP(inverso));
        
        
        return respuesta;
    }
}
