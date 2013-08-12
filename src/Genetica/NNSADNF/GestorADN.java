/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Genetica.NNSADNF;

import Utiles.F;
import java.awt.Color;
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
    static int siguiente = 0;
    //Guardamos la población
    static ArrayList<double[]> poblacion = new ArrayList<double[]>();
    //Guardamos la asignación que hemos hecho
    static HashMap<String, Integer> asignacion = new HashMap<String, Integer>();

    //Añadir población
    public static void addPop(double[] adn) {
        poblacion.add(adn);
    }

    //Generar población aleatoria
    public static void addRandomPop(int n, int longitud) {
        for (int i = 0; i < n; i++) {
            addPop(NNSADNFix.randomADN(longitud));
        }
    }

    /**
     * Entrega ADN al robot que lo pide y anota su nombre para después poderlo
     * recuperar
     *
     * @param name
     * @return
     */
    public static double[] getADN(String name) {

        double[] respuesta = poblacion.get(siguiente);


        //Asignamos el adn al nombre del robot
        asignacion.put(name, siguiente);

        siguiente++;

        return respuesta;
    }

    public static double[] getADN(int num) {
        return poblacion.get(num);
    }

    public static String poblacionToString() {
        StringBuilder sb = new StringBuilder();

        sb.append(NNSADNFix.adn2s(poblacion.get(0)));

        for (int i = 1; i < poblacion.size(); i++) {
            sb.append(":").append(NNSADNFix.adn2s(poblacion.get(i)));
        }


        return sb.toString();
    }

    public static void savetofile(String ruta) {
        //Guardamos la población
        F.guardarArchivo(ruta, poblacionToString());
    }

    public static void cargardearchivo(String ruta) {
        //Leer archivo
        String cadena = F.cargarArchivo(ruta);
        //Dividir por cadenas de adn
        String[] adns = cadena.split(":");
        //Convertir cadenas a adns y añadir al vector de cadenas
        for (int i = 1; i < adns.length; i++) { //Nos saltamos el primero porque la cadena empieza con ":" y está vacío
            addPop(NNSADNFix.s2adn(adns[i]));
        }
    }

    public static Color adn2color(double[] adn) {
        Color respuesta = null;
        
        //Dividimos el adn en 3 partes
        int l = adn.length;
        int p1 = l / 3;
        int p2 = 2 * p1;

        //Sumamos los valores desde 0 a p1 desde p1 a p2 y desde p2 hasta el final
        double s1 = 0;
        double s2 = 0;
        double s3 = 0;
        for (int i = 0; i < adn.length; i++) {
            if(i<p1){
                s1+= adn[i];
            }else if(i<p2){
                s2+= adn[i];
            }else{
                s3+= adn[i];
            }
        }
        
        //Hacemos el módulo de 255
        int ms1 = (int) (s1%255);
        int ms2 = (int) (s2%255);
        int ms3 = (int) (s3%255);
        
        //Montamos el color
        respuesta = new Color(ms1, ms2, ms3);
        
        
        return respuesta;
    }
}
