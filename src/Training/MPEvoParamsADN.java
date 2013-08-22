/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Training;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Víctor
 */
class MPEvoParamsADN {
    
    static Random r = new Random();
    
    static int longitud = 9;
    
    double[] valores;
    
    public static MPEvoParamsADN aleatorio(){
        MPEvoParamsADN respuesta = new MPEvoParamsADN();
        
        double[] r_valores = new double[longitud];
        
        //Aunque sean valores aleatorios vamos a poner un límite para que no se flipe
        
        //TODO hacer todo con porcentajes
        
        r_valores[0] = r.nextDouble(); //Diferencia mínima en cruce, valor entre 0 y 1
        r_valores[1] = r.nextInt(1000); // Longitud inicial del adn
        r_valores[2] = r.nextInt(100); //Máximo decremento adn
        r_valores[3] = r.nextInt(100); //Máximo incremento de adn
        r_valores[4] = 2+r.nextInt(1000); //Número de competidores
        r_valores[5] = 1+r.nextInt(1000); //Número de descendientes
        r_valores[6] = 3+r.nextInt(10000); //Número de individuos
        r_valores[7] = 2+r.nextInt(1000); //Número de progenitores
        r_valores[8] = r.nextDouble(); //Probabilidad de mutación
        
        
        return respuesta;
    }
    
    public static MPEvoParamsADN cruzar(MPEvoParamsADN a, MPEvoParamsADN b){
        MPEvoParamsADN respuesta = new MPEvoParamsADN();
        
        double[] vectora = a.valores;
        double[] vectorb = b.valores;
        double[] vectorz = new double[longitud];
        
        for(int i=0; i<longitud; i++){
            
            double va = vectora[i];
            double vb = vectorb[i];
            
            double min = Math.min(va, vb);
            double max = Math.max(va, vb);
            
            min -=0.1;
            max +=0.1;
            
            if(min <0) min=0;
            
            vectorz[i] = min + r.nextDouble() * (max-min);
        }
        
        respuesta.valores = vectorz;
        
        return respuesta;
    }
    
    public static MPEvoParamsADN mutar(MPEvoParamsADN adn){
        MPEvoParamsADN respuesta = MPEvoParamsADN.aleatorio();
        
        double[] valores = adn.valores;
        
        for(int i=0; i<longitud; i++){
            double probabilidad = r.nextDouble();
            if(probabilidad < 0.8){ //Probabilida de no mutar
                respuesta.valores[i] = valores[i];
            }
        }
        
        return respuesta;
    }
    
}
