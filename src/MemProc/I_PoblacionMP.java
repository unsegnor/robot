/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MemProc;

import java.util.ArrayList;

/**
 *
 * @author Víctor
 */
public interface I_PoblacionMP {
    String rutaPoblacion = "poblacionMP";

    /**
     * @return the individuos
     */
    ArrayList<IndividuoMP> getIndividuos();

    void grabar();

    void grabar(String ruta);

    PoblacionMP ordenar(boolean inverso);

    /**
     * @param individuos the individuos to set
     */
    void setIndividuos(ArrayList<IndividuoMP> individuos);

    String toString();
    
}
