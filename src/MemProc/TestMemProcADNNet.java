/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MemProc;

/**
 *
 * @author Víctor
 */
public class TestMemProcADNNet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        MemProcADNNet red = new MemProcADNNet();
        
        
        //Establecer entradas
        Mem[] entradas = new Mem[3];
        
        entradas[0]= new Mem(0.1);
        entradas[1]= new Mem(0.2);
        entradas[2]= new Mem(0.3);
        
        red.setEntradas(entradas);
        
        //Establecer salidas
        Mem[] salidas = new Mem[2];
        
        salidas[0]= new Mem(0.4);
        salidas[1]= new Mem(0.5);
        
        red.setSalidas(salidas);
        
        //Obtener ADN
        MemProcADN adn = new MemProcADN();
        
        double[] valores = {
        //Definimos los mems
        0,0.101,0
        ,0,0.201,1
        ,0,0.301,0.5
        ,0,0.401,0.6
        ,0,0.501,0.7
        ,0,0.601,0.8
        ,0,0.701,0.9
        //Definimos los procs
        ,1,0.1,0.2,0.3,0.4,0.5
        ,1,0.5,0.6,0.7,0.8,0.9
        ,1,0.8,0.9,0.8,0.1,0
        };    
        
        adn.valores = valores;
        
        //Montar red 
        red.setFromADN(adn);
        
        //Imprimir la red
        System.out.println(red.toDOT());
        
        //Ejecutar la red
        red.exec();
        
        //Imprimir la red
        System.out.println(red.toDOT());
        
    }
}
