/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MemProc;

/**
 * Es una porción de memoria de la que se puede leer y escribir.
 *
 * Le añadimos un latch para simular la simultaneidad de sucesos.
 *
 * @author Víctor
 */
public class Mem {

    double valor = 0;
    double valorSiguiente = valor;

    public Mem() {
    }

    ;
    public Mem(double v) {
        init(v);
    }

    public double get() {
        return valor;
    }

    public void add(double v) {
        valorSiguiente += v;
    }

    private void init(double v) {
        valor = v;
        valorSiguiente = valor;
    }

    /**
     * Actualiza el valor de la Memoria
     */
    public void actualizar() {
        valor = valorSiguiente;
    }

    //Devuelve un getEntradas de mems nuevos inicializados con los valores del vector de entrada
    static Mem[] array(double[] valores) {
        int nvalores = valores.length;
        Mem[] respuesta = new Mem[nvalores];

        for (int i = 0; i < nvalores; i++) {
            respuesta[i] = new Mem(valores[i]);
        }

        return respuesta;
    }

    /**
     * Devuelve <n> Mems inicializados a 0
     *
     * @param n
     * @return
     */
    static Mem[] array(int n) {
        Mem[] respuesta = new Mem[n];

        for (int i = 0; i < n; i++) {

            respuesta[i] = new Mem();
        }

        return respuesta;
    }
}
