/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MemProc;

import General.Individuo;
import Genetica.NNSADNF.IndividuoNNS;
import java.util.Comparator;

/**
 *
 * @author Víctor
 */
class OrdenarPoblacion implements Comparator<Individuo> {


        boolean inverso = false;
    
    public OrdenarPoblacion(){
        init(false);
    }
    
    public OrdenarPoblacion(boolean inverso){
        init(inverso);
    }
    
    @Override
    public int compare(Individuo o1, Individuo o2) {
        if(inverso){
            return Double.compare(o2.getUltimo_resultado(), o1.getUltimo_resultado());
        }else{
            return Double.compare(o1.getUltimo_resultado(), o2.getUltimo_resultado());
        }
    }

    private void init(boolean inverso) {
        this.inverso = inverso;
    }
}
