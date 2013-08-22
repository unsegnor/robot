/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package General;

/**
 *
 * @author Víctor
 */
public interface ADN {
    
    public ADN aleatorio();
    
    public ADN aleatorio(int longitud);
    
    public ADN cruzar(ADN a, ADN b);
    
    public ADN mutar(ADN a);
    
}
