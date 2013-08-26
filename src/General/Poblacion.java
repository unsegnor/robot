/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package General;

import java.util.ArrayList;

/**
 *
 * @author Víctor
 */
public interface Poblacion<K extends Individuo> {
    
    public ArrayList<K> getIndividuos();
    
    public Poblacion poblacionAleatoria(int n);
    
}
