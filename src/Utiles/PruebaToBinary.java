/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utiles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author Victor
 */
public class PruebaToBinary {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        double valor =0;
        
        while(valor != 88){
        
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader bf = new BufferedReader (isr);
        String lineaTeclado = bf.readLine();
        valor = Double.parseDouble (lineaTeclado);
        
        ArrayList<Boolean> b = F.tobinary(valor);
        
        System.out.println(F.Bool2String(b));
        
        System.out.println(F.Bool2Double(b));
        }
        
    }
}
