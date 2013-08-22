/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MemProc;

import Genetica.NNSADNF.IndividuoNNS;
import java.util.Comparator;

/**
 *
 * @author Víctor
 */
class OrdenarPoblacionMP implements Comparator<IndividuoMP> {


        boolean inverso = false;
    
    public OrdenarPoblacionMP(){
        init(false);
    }
    
    public OrdenarPoblacionMP(boolean inverso){
        init(inverso);
    }
    
    @Override
    public int compare(IndividuoMP o1, IndividuoMP o2) {
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
