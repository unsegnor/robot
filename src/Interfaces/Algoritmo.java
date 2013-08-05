/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

/**
 * un Algoritmo debe tener al menos una función a la que llamar pasando las entradas y que devuelva las salidas
 * @author Víctor
 */
public interface Algoritmo {
    
    public double[] exec(double[] entradas);
    
    public void setNEntradas(int nentradas);
    
    public void setNSalidas(int nsalidas);
    
    
}
