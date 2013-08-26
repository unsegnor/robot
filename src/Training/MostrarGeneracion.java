/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Training;

import Genetica.NNSADNF.IndividuoNNS;
import Genetica.NNSADNF.NNSEvoManager;
import Genetica.NNSADNF.PoblacionNNS;

/**
 *
 * @author Víctor
 */
public class MostrarGeneracion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String id_ejecucion = "26082013024424";
        int generacion = 15;
        int nrounds = 10;
        int enemigo = 1;
        
        if(args.length >=2){
            id_ejecucion = args[0];
            generacion = Integer.parseInt(args[1]);
        }
        

        
        //Abrimos el archivo

        
        NNSEvoManager evo = new NNSEvoManager();
        
        
        //Cargar población con resultados
        PoblacionNNS poblacion = evo.cargarGeneracion(id_ejecucion, generacion);
        
        //Obtener orden de individuos
        PoblacionNNS ordenada = poblacion.ordenar(true);
        
        //Recorrer ordenada mostrando las batallas
        for(int i=0; i<ordenada.individuos.size(); i++){
            
            IndividuoNNS individuo = ordenada.individuos.get(i);
            
            //Lanar una batalla para el individuo
            evo.lanzarBatalla(individuo, true, nrounds, enemigo);
            
        }
        
        
        
        
        
        
        
        
        
    }
}
