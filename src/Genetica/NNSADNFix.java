/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Genetica;

import SimpleNN.NN;
import java.util.Arrays;

/**
 * ADN para una NNSimple de tamaño fijo
 * @author Víctor
 */
public class NNSADNFix {
    
    //Tamaño de la red
    //int[] capas = {35,30,20,25,28};
    //umbrales
    //double[] umbrales;
    //int nneuronas;
    //int nconexiones;
    
    /**
     * Calcula la longitud válida del ADN para crear una red con las capas determinadas
     * @param capas las capas que queremos que tenga la red
     * @return devuelve la longitud necesaria
     */
    public static int longADN(int[] capas){
        //Calculamos el número de neuronas y conexiones
        int[] NC = calcularNC(capas);
        //Necesitamos dos veces el número de neuronas (para estado y umbral) y las conexiones.
        return NC[0]*2 + NC[1];
    }
    
    
    /**
     * Calcular número de neuronas y conexiones en función de las capas
     * @return 
     */
    public static int[] calcularNC(int[] capas){
        int[] respuesta = new int[2];
        //Calcular neuronas, sumar capas
        int nneuronas = 0;
        for(int c=0; c<capas.length; c++){
            nneuronas += capas[c];
        }
        
        //Calcular umbrales, tantos como neuronas
        //Calcular conexiones, sumamos el producto del número de neuronas de capas adyacentes
        int nconexiones = 0;
        for(int c=1; c<capas.length; c++){
            nconexiones += capas[c] * capas[c-1];
        }
        
        respuesta[0] = nneuronas;
        respuesta[1] = nconexiones;
        
        return respuesta;
        
    }
    
    public NN construyeNN(double[] adn, int[] capas, int entradas, int salidas){
        //Generar vector de capas
        int[] lcapas = new int[capas.length+2];
        lcapas[0] = entradas;
        System.arraycopy(capas, 1, lcapas, 1, capas.length - 1);
        lcapas[capas.length+1] = salidas;
        
        return construyeNN(adn, lcapas);
        
        
    }
    
    public static NN construyeNN(double[] adn, int[] capas){
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
        double[] estados = Arrays.copyOfRange(adn, nneuronas, nneuronas+nneuronas);
        double[] pesos = Arrays.copyOfRange(adn, nneuronas+nneuronas, nneuronas+nneuronas+nconexiones);
        
        System.out.println(nneuronas + "*2 + " + nconexiones + " = " + (nneuronas*2 + nconexiones));
        
        respuesta = new NN(capas,umbrales,estados,pesos);
        
        
        return respuesta;
    }
    /***
     * Cruzar adns de la misma longitud
     * @param adn
     * @param adn2
     * @return 
     */
    public double[] cruzar(double[] adn, double[] adn2){
        double[] respuesta = new double[adn.length];
        
        //Para cada par de valores cruzar
        for(int i=0; i<adn.length; i++){
            //Obtener valor aleatorio uniforme dentro del rango que definen los padres más un 20% de "innovación"
            //Determinar rango (diferencia entre padres)
            //Ampliar un 20%, 10 por cada lado
            //Generar valor aleatorio dentro del rango
            //Asignar valor al nuevo adn 
            
        }
        
        return respuesta;
    }
    
}
