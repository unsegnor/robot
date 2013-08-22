/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MemProc;

import Training.MPEvoParams;
import Utiles.F;
import java.util.Random;

/**
 * Es el ADN que utilizarán las redes MemProc
 *
 * @author Víctor
 */
public class MemProcADN {

    static Random r = new Random();
    private static int maxdiff = 10; //Diferencia máxima de longitud de adn
/*
     public static MemProcADN cargarADN() {
     MemProcADN respuesta = new MemProcADN();
        
     //Leer el archivo
     String cadena = F.cargarArchivo(rutaADN);
        
     //Dividir la cadena
     String[] s_adns = cadena.split(":");
        
     //Obtener el primero y convertir en adn
     double[] adn = parseADN(s_adns[1]);
        
     respuesta.valores = adn;
        
     return respuesta;
     }
     * */

    public static void grabarADN(MemProcADN adn) {
        String cadena = adn.toString();
    }

    public static MemProcADN parseADN(String cadena) {
        MemProcADN respuesta = new MemProcADN();

        double[] valores = parseValores(cadena);

        respuesta.valores = valores;


        return respuesta;
    }

    private static double[] parseValores(String cadena) {
        double[] respuesta;

        //Convertir adn a doubles
        String[] s_valores = cadena.split(";");

        int lvalores = s_valores.length;

        respuesta = new double[lvalores];

        for (int i = 0; i < lvalores; i++) {
            respuesta[i] = Double.parseDouble(s_valores[i]);
        }

        return respuesta;
    }
    double[] valores;

    public static MemProcADN aleatorio(int longitud) {
        MemProcADN respuesta = new MemProcADN();

        //Obtenemos valores aleatorios
        double[] valores = new double[longitud];
        //Rellenamos con random
        for (int i = 0; i < longitud; i++) {
            valores[i] = r.nextDouble();
        }

        //Los añadimos al adn
        respuesta.valores = valores;

        return respuesta;
    }

    //Mutar es cambiar algunos valores y alargar o acortar el ADN
    public static MemProcADN mutar(MemProcADN adn, MPEvoParams parametros) {
        MemProcADN respuesta = new MemProcADN();


        //Decidir el nuevo tamaño del adn
        int mindiff = parametros.getMaximo_decremento_adn();
        int maxdiff = parametros.getMaximo_incremento_adn();

        int diferencia_maxmin = maxdiff + mindiff;

        int diff;
        if (diferencia_maxmin > 0) {
            diff = r.nextInt(diferencia_maxmin) - mindiff; //Un número entre -mindiff y maxdiff
        } else {
            diff = 0;
        }


        int l = adn.valores.length;
        int ntam = l + diff;

        double[] valores;

        //No le dejamos bajar de cero
        if (ntam < 0) {
            ntam = 0;
        }

        //Formar nuevo vector

        valores = new double[ntam];


        int mintam = Math.min(l, ntam);

        //Copiamos lo que es común a los dos vectores     
        System.arraycopy(adn.valores, 0, valores, 0, mintam);

        //Ahora

        //Si la diferencia es positiva tenemos que inventarnos números
        if (diff > 0) {
            //Rellenamos el resto del vector con números aleatorios
            for (int i = mintam; i < ntam; i++) {
                valores[i] = r.nextDouble();
            }
        }

        //Ahora mutamos los valores

        //Para cada valor existe una posibilidad del 20% de sufrir una mutación
        for (int i = 0; i < valores.length; i++) {
            double p = r.nextDouble();
            if (p <= parametros.getProbabilidad_de_mutacion()) {
                //La mutación consiste en sustituir el valor por otro aleatorio
                valores[i] = r.nextDouble();
            }
        }

        //Ponemos el adn en el objeto respuesta y fin
        respuesta.valores = valores;

        return respuesta;

    }

    public static MemProcADN cruzar(MemProcADN[] progenitores) {
        MemProcADN respuesta = new MemProcADN();

        //Número de progenitores
        int nprogenitores = progenitores.length;

        //Anotar longitudes de adns de progenitores
        int[] l = new int[nprogenitores];

        int maxl = 0;
        int minl = Integer.MAX_VALUE;
        for (int i = 0; i < nprogenitores; i++) {
            int longitud = progenitores[i].valores.length;
            l[i] = longitud;
            if (longitud > maxl) {
                maxl = longitud;
            }

            if (longitud < minl) {
                minl = longitud;
            }
        }

        //Seleccionar la longitud del adn entre el rango que definen los progenitores
        int diferencia = maxl - minl;
        int longitud;
        if (diferencia > 0) {
            longitud = minl + r.nextInt(maxl - minl);
        } else {
            longitud = minl;
        }
        //int longitud = Utiles.media(l);

        double[] valores = new double[longitud];

        //Para cada valor del adn más largo
        for (int i = 0; i < longitud; i++) {
            //Obtener rango
            double min = Double.MAX_VALUE;
            double max = -1;
            for (int p = 0; p < nprogenitores; p++) {
                //Si el progenitor tiene tantos valores
                if (i < l[p]) {
                    double valor = progenitores[p].valores[i];
                    if (valor < min) {
                        min = valor;
                    }
                    if (valor > max) {
                        max = valor;
                    }
                }
            }

            //Tenemos el rango
            double diff = max - min;

            //Expandir rango
            double exp = diff * 0.1;
            if (exp < 0.001) {
                exp = 0.001; //Diferencia mínima
            }
            max += exp;
            min -= exp;

            //Dejarlos entre 0 y 1
            if (max > 1) {
                max = 1;
            }
            if (min < 0) {
                min = 0;
            }

            //Seleccionar valor dentro del rango
            double valorfinal = min + (r.nextDouble() * (max - min));

            valores[i] = valorfinal;
        }

        respuesta.valores = valores;

        return respuesta;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(valores[0]);

        for (int i = 1; i < valores.length; i++) {
            sb.append(";").append(valores[i]);
        }


        return sb.toString();
    }
}
