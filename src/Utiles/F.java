/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utiles;

/**
 *
 * @author Victor
 */
public class F {
    
    
    public static boolean[] double2bool(double valor){
        
        boolean[] respuesta;
        
        String cadena = Long.toBinaryString(Double.doubleToLongBits(valor));
        
        int l = cadena.length();
        
        respuesta = new boolean[64];
        
        //Si l es menor que 64 entonces rellenamos con ceros el principio
        int diff = 64 -l;
        int i=0;
        if(diff > 0){ 
            
            //TODO determinar si se añaden trues o falses
            for(int j=0; j<diff; j++){ 
            respuesta[j] = false;
            }
            i=diff;
        }
        
        for(;i<l; i++){
            respuesta[i] = cadena.charAt(i) == '1';
        }
        
        return respuesta;
    }
    
    public static boolean[] double2bool(double[] valores){
            //Preparamos el vector de bits final
        int l = valores.length; //Número de valores dobles
        int t = l*64; //64 bits por cada doble
        boolean[] respuesta = new boolean[t];
        
        //Para cada doble de la lista
        for(int i=0; i<l; i++){
            //Calcular el vector de bits
            boolean[] v = F.double2bool(valores[i]);           
            
            //La posición es el vector que toque por 64
            int p = i<<6; //Multiplicamos i por 64
            
            //Añadirlo al vector tocho
            System.arraycopy(v, 0, respuesta, p, 64);
        }
            
            
         return respuesta;   
    }
    
    public static String bits2string(boolean[] bits){
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<bits.length; i++){
            sb.append(bits[i]?"1":"0");
        }
        
        return sb.toString();
    }

    public static Object n(boolean b) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public static Object n(double energy) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    

    
}
