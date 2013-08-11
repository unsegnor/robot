/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Genetica.NNSADNF;

import SimpleNN.NN;
import Utiles.F;
import java.util.Arrays;
import java.util.Random;

/**
 * ADN para una NNSimple de tamaño fijo
 *
 * @author Víctor
 */
public class NNSADNFix {
    
    double[] adn;
    
    //Tamaño de la red
    public static int[] globalCapas = {35,30,20,25,28};
    public static String rutaPoblacion = "PoblacionNNS";
    //umbrales
    //double[] umbrales;
    //int nneuronas;
    //int nconexiones;
    
    static Random r = new Random();

    /**
     * Calcula la longitud válida del ADN para crear una red con las capas
     * determinadas
     *
     * @param capas las capas que queremos que tenga la red
     * @return devuelve la longitud necesaria
     */
    public static int longADN(int[] capas) {
        //Calculamos el número de neuronas y conexiones
        int[] NC = calcularNC(capas);
        //Necesitamos dos veces el número de neuronas (para estado y umbral) y las conexiones.
        return NC[0] * 2 + NC[1];
    }

    /**
     * Calcular número de neuronas y conexiones en función de las capas
     *
     * @return
     */
    public static int[] calcularNC(int[] capas) {
        int[] respuesta = new int[2];
        //Calcular neuronas, sumar capas
        int nneuronas = 0;
        for (int c = 0; c < capas.length; c++) {
            nneuronas += capas[c];
        }

        //Calcular umbrales, tantos como neuronas
        //Calcular conexiones, sumamos el producto del número de neuronas de capas adyacentes
        int nconexiones = 0;
        for (int c = 1; c < capas.length; c++) {
            nconexiones += capas[c] * capas[c - 1];
        }

        respuesta[0] = nneuronas;
        respuesta[1] = nconexiones;

        return respuesta;

    }

    public NN construyeNN(double[] adn, int[] capas, int entradas, int salidas) {
        //Generar vector de capas
        int[] lcapas = new int[capas.length + 2];
        lcapas[0] = entradas;
        System.arraycopy(capas, 1, lcapas, 1, capas.length - 1);
        lcapas[capas.length + 1] = salidas;

        return construyeNN(adn, lcapas);


    }

    public static NN construyeNN(double[] adn, int[] capas) {
        NN respuesta = null;

        //vamos recorriendo el adn asignando valores a lo que toca
        //primero umbrales
        //segundo estados iniciales
        //tercero conexiones

        //calculamos el número de umbrales, neuronas y conexiones
        int[] NC = calcularNC(capas);

        int nneuronas = NC[0];
        int nconexiones = NC[1];

        //recortamos del adn
        double[] umbrales = Arrays.copyOfRange(adn, 0, nneuronas);
        double[] estados = Arrays.copyOfRange(adn, nneuronas, nneuronas + nneuronas);
        double[] pesos = Arrays.copyOfRange(adn, nneuronas + nneuronas, nneuronas + nneuronas + nconexiones);

        System.out.println(nneuronas + "*2 + " + nconexiones + " = " + (nneuronas * 2 + nconexiones));

        respuesta = new NN(capas, umbrales, estados, pesos);


        return respuesta;
    }

    /**
     * *
     * Cruzar adns de la misma longitud
     *
     * @param adn
     * @param adn2
     * @return
     */
    public static double[] cruzar(double[] adn, double[] adn2) {
        double[] respuesta = new double[adn.length];

        //Para cada par de valores cruzar
        for (int i = 0; i < adn.length; i++) {
            respuesta[i] = cruzar(adn[i], adn2[i]);
        }

        return respuesta;
    }
    
    
        public static NNSADNFix cruzar(NNSADNFix adn, NNSADNFix adn2) {
        NNSADNFix respuesta = new NNSADNFix();

        respuesta.adn = NNSADNFix.cruzar(adn.adn, adn2.adn);

        return respuesta;
    }

    public static double cruzar(double gen, double gen2) {
        //Obtener valor aleatorio uniforme dentro del rango que definen los padres más un 20% de "innovación"
        //Determinar rango (diferencia entre padres)
        double rmin = Math.min(gen, gen2);
        double rmax = Math.max(gen, gen2);
        double diff = rmax - rmin;
        //Ampliar un 20%, 10 por cada lado
        double aumento = diff * 0.2;
        rmin -= aumento / 2;
        rmax += aumento / 2;
        //Generar valor aleatorio dentro del rango
        double nuevo_valor = F.aleatorio(rmin, rmax);
        //Asignar valor al nuevo adn 
        return nuevo_valor;
    }

    public static String adn2s(double[] adn) {
        StringBuilder sb = new StringBuilder();

        sb.append(adn[0]);

        for (int i = 1; i < adn.length; i++) {
            sb.append(";").append(adn[i]);
        }


        return sb.toString();
    }
    
    public static double[] s2adn (String adn){
        //Dividir la cadena por ";"
        String[] nums = adn.split(";");
        //Generamos vector de reales con la dimensión necesaria
        double[] respuesta = new double[nums.length];
        //Rellenamos
        for(int i=0; i<nums.length; i++){
            respuesta[i] = Double.parseDouble(nums[i]);
        }
        
        return respuesta;
    }

    public static double[] randomADN(int longitud) {
        double[] respuesta = new double[longitud];
        //Rellenamos con random
        for (int i = 0; i < longitud; i++) {
            respuesta[i] = r.nextDouble();
        }
        return respuesta;
    }
    
    
    
    

}
