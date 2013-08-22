/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MemProc;

/**
 *
 * @author Víctor
 */
public class Utiles {

    //Función para dividir un intervalo determinado en n posiciones con la misma separación entre ellas
    public static double[] posiciones(int nposiciones, double min, double max) {
        double[] respuesta = new double[nposiciones];


        //Calculamos el intervalo
        double intervalo = max - min;

        //Obtenemos la porción que le toca a cada posición
        double porcion = intervalo / (double) nposiciones;
        double p2 = porcion / 2d;

        //La primera posición se encuentra a porcion/2 distancia del inicio del intervalo
        double inicio = min + p2;
        for (int i = 0; i < nposiciones; i++) {
            respuesta[i] = inicio + (porcion * i);
        }


        return respuesta;
    }

    public static double[] posicionesBaja(int nposiciones, double min, double max) {
        double[] respuesta = new double[nposiciones];


        //Calculamos el intervalo
        double intervalo = max - min;

        //Obtenemos la porción que le toca a cada posición
        double porcion = intervalo / (double) nposiciones;

        //La primera posición se encuentra a porcion/2 distancia del inicio del intervalo
        double inicio = min;
        for (int i = 0; i < nposiciones; i++) {
            respuesta[i] = inicio + (porcion * i);
        }


        return respuesta;
    }

    static int maximo(int[] vector) {
        int respuesta = Integer.MIN_VALUE;
        //Recorrer el vector y devolver el máximo

        int l = vector.length;

        for (int i = 0; i < l; i++) {
            int valor = vector[i];

            if (valor > respuesta) {
                respuesta = valor;
            }
        }

        return respuesta;
    }

    static int media(int[] vector) {
        int respuesta = 0;
        //Recorrer el vector y devolver el máximo

        int l = vector.length;

        for (int i = 0; i < l; i++) {
            int valor = vector[i];

            respuesta += valor;
        }

        respuesta = respuesta / l;

        return respuesta;
    }
    
    public static Mem[] getMemArray(int n){
        Mem[] respuesta = new Mem[n];
        
        for(int i=0; i<n; i++){
            respuesta[i] = new Mem();
        }
        
        return respuesta;
    }
}
