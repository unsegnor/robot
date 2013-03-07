/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utiles;

/**
 *
 * @author Victor
 */
public class Funciones {
    
    
    public static boolean[] double2bool(double valor){
        
        boolean[] respuesta;
        
        String cadena = Long.toBinaryString(Double.doubleToLongBits(valor));
        
        int l = cadena.length();
        
        respuesta = new boolean[l];
        
        for(int i=0; i<l; i++){
            respuesta[i] = cadena.charAt(i) == '1';
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
    
}
