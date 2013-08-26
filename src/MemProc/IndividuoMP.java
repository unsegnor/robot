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
public class IndividuoMP extends Individuo{
    
    private MemProcADN MPadn;
    

    /**
     * @return the adn
     */
    @Override
    public MemProcADN getAdn() {
        return MPadn;
    }

    /**
     * @param adn the adn to set
     */
    public void setAdn(MemProcADN adn) {
        this.MPadn = adn;
    }
    @Override
    public String toString(){
        return MPadn.toString();
    }
    
}
