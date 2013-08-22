/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MemProc;

import General.Individuo;

/**
 *
 * @author Víctor
 */
public class IndividuoMP{
    
    public boolean calculado = false;
    public double ultimo_resultado = 0;
    
    private MemProcADN adn;
    

    /**
     * @return the adn
     */
    public MemProcADN getAdn() {
        return adn;
    }

    /**
     * @param adn the adn to set
     */
    public void setAdn(MemProcADN adn) {
        this.adn = adn;
    }
    @Override
    public String toString(){
        return adn.toString();
    }
    
}
