/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Training;

import Genetica.NNSADNF.IndividuoNNS;
import java.util.Comparator;

/**
 *
 * @author Víctor
 */
public class OrdenarPoblacionNNS implements Comparator<IndividuoNNS>{

    
    boolean inverso = false;
    
    public OrdenarPoblacionNNS(){
        init(false);
    }
    
    public OrdenarPoblacionNNS(boolean inverso){
        init(inverso);
    }
    
    @Override
    public int compare(IndividuoNNS o1, IndividuoNNS o2) {
        if(inverso){
            return Double.compare(o2.ultimo_resultado, o1.ultimo_resultado);
        }else{
            return Double.compare(o1.ultimo_resultado, o2.ultimo_resultado);
        }
    }

    private void init(boolean inverso) {
        this.inverso = inverso;
    }
    
}
