/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Genetica.NNSADNF;

import Utiles.F;
import java.util.ArrayList;
import java.util.HashMap;
import robocode.Robot;

/**
 *
 * @author Víctor
 */
public class GestorADN {
    
    public static boolean iniciado = false;
    
    
    //Siguiente por asignar
   static int siguiente=0;
    
    //Guardamos la población
    static ArrayList<double[]> poblacion = new ArrayList<double[]>();
    
    //Guardamos la asignación que hemos hecho
    static HashMap<String, Integer> asignacion = new HashMap<String, Integer>();
    
    
    //Añadir población
    public static void addPop(double[] adn){
        poblacion.add(adn);
    }
    
    //Generar población aleatoria
    public static void addRandomPop(int n, int longitud){
        for(int i=0; i<n; i++){
            addPop(NNSADNFix.randomADN(longitud));
        }
    }
    
        /**
     * Entrega ADN al robot que lo pide y anota su nombre para después poderlo recuperar
     * @param name
     * @return 
     */
    public static double[] getADN(String name){
        
        double[] respuesta = poblacion.get(siguiente);
        
        
        //Asignamos el adn al nombre del robot
        asignacion.put(name, siguiente);
        
        siguiente++;
        
        return respuesta;
    }
    
    public static double[] getADN(int num){
        return poblacion.get(num);
    }
    
    public static String poblacionToString(){
        StringBuilder sb = new StringBuilder();
        
        sb.append(NNSADNFix.adn2s(poblacion.get(0)));
        
        for(int i=1; i<poblacion.size(); i++){
            sb.append(":").append(NNSADNFix.adn2s(poblacion.get(i)));
        }
        
        
        return sb.toString();
    }
    
    public static void savetofile(String ruta){
        //Guardamos la población
        F.guardarArchivo(ruta, poblacionToString());
    }
    
    public static void cargardearchivo(String ruta){
        //Leer archivo
        String cadena = F.cargarArchivo(ruta);
        //Dividir por cadenas de adn
        String[] adns = cadena.split(":");
        //Convertir cadenas a adns y añadir al vector de cadenas
        for(int i=0; i<adns.length; i++){
            addPop(NNSADNFix.s2adn(adns[i]));
        }
    }
}
