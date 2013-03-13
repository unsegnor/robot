/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Neuronas;

import Entorno.Naturaleza;

/**
 * Neurona con memoria (carga) y umbral de disparo.
 * @author Victor
 */
public class SimpleSpike implements Emisor, Peso {
    
    //Carga
    double carga = 0;
    
    //Signo
    boolean signo = true;
    
    //Umbral
    static double umbral = Naturaleza.umbral_de_disparo; //El umbral de disparo es compartido por todas las neuronas y lo fija la naturaleza

    @Override
    public boolean getInfo() {
        return (carga >= umbral);
    }

    @Override
    public double getPeso() {
        return carga;
    }
    
}
