/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Genetica.NNSADNF;

import java.util.ArrayList;

/**
 * Mantiene conjuntos de individuos
 * @author Víctor
 */
public class PoblacionNNS {
    
    ArrayList<IndividuoNNS> individuos = new ArrayList<IndividuoNNS>();
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        int l = individuos.size();
        
        
        for(int i=0; i<l; i++){
            sb.append(":").append(NNSADNFix.adn2s(individuos.get(i).adn.adn));
        }
        
        
        return sb.toString();
    }
    
}
