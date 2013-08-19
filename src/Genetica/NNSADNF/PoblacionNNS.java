/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Genetica.NNSADNF;

import Training.OrdenarPoblacionNNS;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Mantiene conjuntos de individuos
 * @author Víctor
 */
public class PoblacionNNS {
    
    public ArrayList<IndividuoNNS> individuos = new ArrayList<IndividuoNNS>();
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        int l = individuos.size();
        
        
        for(int i=0; i<l; i++){
            sb.append(":").append(NNSADNFix.adn2s(individuos.get(i).adn.adn));
        }
        
        
        return sb.toString();
    }

    public PoblacionNNS ordenar(boolean inverso) {
        PoblacionNNS respuesta = new PoblacionNNS();
        
        //Copiamos el vector de individuos
        respuesta.individuos = new ArrayList<IndividuoNNS>(this.individuos);
        
        //Ordenamos el vector de la respuesta
        Collections.sort(respuesta.individuos, new OrdenarPoblacionNNS(inverso));
        
        
        return respuesta;
    }
    
}
