/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package General;

/**
 *
 * @author Víctor
 */
public interface IADN {

    ADN cruzar(ADN a, ADN b);

    double[] getValores();

    ADN mutar(ADN a);
    
    void setRandom();
    
    void setRandom(int n);
    
}
