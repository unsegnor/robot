/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Robots;

import MemProc.Mem;
import MemProc.MemProcADN;
import MemProc.MemProcADNNet;
import MemProc.PoblacionMP;
import Utiles.F;

/**
 *
 * @author Víctor
 */
public class MPRobot extends RobotInterfazReales01 {
    
    MemProcADNNet red = new MemProcADNNet();
    
    Mem[] entradas;
    Mem[] salidas;
    
    MemProcADN adn;
    
    public MPRobot(int n){
        init(n);
    }
    
    
    @Override
    public double[] responder(double[] entradas){
        double[] respuesta = new double[nsalidas];
        
        //Poner las entradas en los mems de entrada
        for(int i=0; i<nentradas; i++){
            this.entradas[i].setValor(entradas[i]);
        }
        
        //Ejecutar la red
        red.exec();
        
        //Recoger las salidas
        for(int i=0; i<nsalidas; i++){
            respuesta[i] = salidas[i].get();
        }
        
        return respuesta;
    }

    private void init(int n) {
        
        entradas = new Mem[RobotInterfazReales.nentradas];
        salidas = new Mem[RobotInterfazReales.nsalidas];
        
        //Inicializamos las entradas y salidas
        
        for(int i=0; i<entradas.length; i++){
            entradas[i] = new Mem();
        }
        
        for(int i=0; i<salidas.length; i++){
            salidas[i] = new Mem();
        }
        
        
        //Generamos las entradas y salidas de la red
        red.setEntradas(entradas);
        red.setSalidas(salidas);
        
        
        //Cargamos la población
        PoblacionMP poblacion = PoblacionMP.cargarPoblacion();
        
        //Cargamos el ADN del indidivuo n
        adn = poblacion.getIndividuos().get(n).getAdn();
        
        //Generamos la red a partir del adn
        red.setFromADN(adn);
        
        //Guardamos la red en un archivo gv
        F.guardarArchivo("RED.gv", red.toDOT());
        
    }
    
}
