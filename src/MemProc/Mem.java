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

    double max = 1;
    double min = 0;
    private double valor = 0;
    double valorSiguiente = getValor();

    
    public Mem() {
    }

    ;
    public Mem(double v) {
        init(v);
    }

    public double get() {
        return getValor();
    }

    public void add(double v) {
        valorSiguiente += v;
    }

    public void sub(double v) {
        valorSiguiente -= v;
    }

    public void set(double v) {
        valorSiguiente = v;
    }
    
        private void init(double v) {
        setValor(v);
        valorSiguiente = getValor();
    }

    private void init(double posicion, double v) {
        setValor(v);
        valorSiguiente = getValor();
    }

    /**
     * Actualiza el valor de la Memoria, sesgamos entre max y min
     */
    public void actualizar() {
        if (valorSiguiente >= max) {
            setValor(max);
        } else if (valorSiguiente <= min) {
            setValor(min);
        } else {
            setValor(valorSiguiente);
        }
    }

    @Override
    public String toString(){
        return Double.toString(getValor());
    }

    /**
     * @return the valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(double valor) {
        this.valor = valor;
    }
            
    
}
