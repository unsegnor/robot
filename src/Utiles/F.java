/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utiles;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Victor
 */
public class F {

    static Random r = new Random();

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

    //Normaliza un número real entre el máximo y el mínimo indicado
    public static double q(double valor, double max, double min) {
        return (valor - min) / (max - min);
    }

    //Convierte double en boolean y viceversa
    public static double h(boolean valor) {
        return valor ? 1 : 0;
    }

    public static boolean h(double valor) {
        return (valor >= 0.5);
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

    public static double Bool2Double(List<Boolean> b) {
        int num = 0;

        //Recorrer e ir sumando
        for (int i = b.size() - 1; i > 0; i--) {
            if (b.get(i)) {
                num++;
            }
            //TODO averiguar por qué se multiplica por dos el resultado final, comprobar esto
            num = num << 1; //Pase lo que pase multiplicamos por 2
        }

        return ((double) num) / 100d;
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
    //Devuelve el valor de los trozos del array desde from hasta to

    public static double s(ArrayList<Boolean> v, int from, int to) {
        return Bool2Double(v.subList(from, to));
    }

    /**
     * Si se pasa del máximo o el mínimo hacemos que sature
     *
     * @param valor
     * @param max
     * @param min
     * @return
     */
    public static double q2(double valor, double max, double min) {
        double respuesta = 0;

        if (valor >= max) {
            respuesta = max;
        } else if (valor <= min) {
            respuesta = min;
        } else {
            respuesta = min + ((max - min) * valor);
        }


        return respuesta;
    }

    public static double aleatorio(double min, double max) {
        return min + (r.nextDouble() * (max - min));
    }

    /*
     * Guardar archivo con el nombre "nombre" y contenido "contenido"
     */
    public static void guardarArchivo(String nombre, String contenido) {
        BufferedWriter bw = null;
        try {
            File archivo = new File(nombre);
            bw = new BufferedWriter(new FileWriter(archivo));

            bw.write(contenido);

            System.out.println("Generado " + nombre);

        } catch (IOException ex) {
            Logger.getLogger(F.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                bw.close();
            } catch (IOException ex) {
                Logger.getLogger(F.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void appendArchivo(String nombre, String contenido) {
        BufferedWriter bw = null;
        try {
            File archivo = new File(nombre);
            bw = new BufferedWriter(new FileWriter(archivo, true));

            bw.append(contenido);

            System.out.println("Generado " + nombre);

        } catch (IOException ex) {
            Logger.getLogger(F.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                bw.close();
            } catch (IOException ex) {
                Logger.getLogger(F.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static String cargarArchivo(String ruta) {
        String respuesta = null;
        File archivo = new File(ruta);
        try {
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            respuesta = br.readLine();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(F.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(F.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }
/**
 * Crea la carpeta si no existe
 * @param ruta 
 */
    public static void crearCarpeta(String ruta) {
        File archivo = new File(ruta);
        if(!archivo.exists()){
            archivo.mkdir();
        }
    }
}
