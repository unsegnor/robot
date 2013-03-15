/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utiles;

import java.util.ArrayList;

/**
 *
 * @author Victor
 */
public class F {

    public static boolean[] double2bool(double valor) {

        boolean[] respuesta;

        String cadena = Long.toBinaryString(Double.doubleToLongBits(valor));

        int l = cadena.length();

        respuesta = new boolean[64];

        //Si l es menor que 64 entonces rellenamos con ceros el principio
        int diff = 64 - l;
        int i = 0;
        if (diff > 0) {

            //TODO determinar si se añaden trues o falses
            for (int j = 0; j < diff; j++) {
                respuesta[j] = false;
            }
            i = diff;
        }

        for (; i < l; i++) {
            respuesta[i] = cadena.charAt(i) == '1';
        }

        return respuesta;
    }

    public static boolean[] double2bool(double[] valores) {
        //Preparamos el vector de bits final
        int l = valores.length; //Número de valores dobles
        int t = l * 64; //64 bits por cada doble
        boolean[] respuesta = new boolean[t];

        //Para cada doble de la lista
        for (int i = 0; i < l; i++) {
            //Calcular el vector de bits
            boolean[] v = F.double2bool(valores[i]);

            //La posición es el vector que toque por 64
            int p = i << 6; //Multiplicamos i por 64

            //Añadirlo al vector tocho
            System.arraycopy(v, 0, respuesta, p, 64);
        }


        return respuesta;
    }

    public static String bits2string(boolean[] bits) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < bits.length; i++) {
            sb.append(bits[i] ? "1" : "0");
        }

        return sb.toString();
    }

    public static Object n(boolean b) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public static Object n(double energy) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public static ArrayList<Boolean> tobinary(boolean b) {
        ArrayList<Boolean> respuesta = new ArrayList<Boolean>();

        respuesta.add(b);

        return respuesta;
    }
    //La inversa de "tobinary"
    public static double Bool2Double(ArrayList<Boolean> b){
        int num = 0;
        
        //Recorrer e ir sumando
        for(int i=b.size()-1; i>=0; i--){
            if(b.get(i)){
                num++;
            }
            //TODO averiguar por qué se multiplica por dos el resultado final, comprobar esto
            num = num << 1; //Pase lo que pase multiplicamos por 2
        }
        
        return ((double)num)/100d;
    }

    //Devuelve un vector de 24 bits que representa el double que se le pasa
    public static ArrayList<Boolean> tobinary(double d) {

        ArrayList<Boolean> respuesta = new ArrayList<Boolean>();

        int num = (int) (d * 100d); //Utilizamos precisión de dos decimales

        for (int i = 0; i < 24; i++) {
            respuesta.add(num % 2 != 0); //Añadimos verdad si el número es impar
            num = num >> 1;   //Dividimos entre 2
        }

        //Añadir el último que representa el signo
        //respuesta.add(d<0);
        
        
        return respuesta;
    }

    public static String Bool2String(ArrayList<Boolean> v) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < v.size(); i++) {
            sb.append(v.get(i) ? "1" : "0");
        }

        return sb.toString();
    }
}
