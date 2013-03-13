/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utiles;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Random;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Victor
 */
public class FuncionesTest {
    
    Random r;
    
    public FuncionesTest() {
        r = new Random();
    }

    /**
     * Test of double2bool method, of class Funciones.
     */
    @Test
    public void testDouble2bool() {
        System.out.println("double2bool");
        double valor = -100.5;//21545698;
        boolean[] result = F.double2bool(valor);
        //assertArrayEquals(expResult, result);
        
        System.out.println("Número en decimal: " + valor);
        System.out.println("Resultado obtenido: " + F.bits2string(result));
        
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of double2bool method, of class Funciones.
     */
    @Test
    public void testDouble2bool_doubleArr() {
        System.out.println("double2bool");
        double[] valores = {1.0,-1.1,1.2,-1.3,1.4,-1.5,1.6};
        boolean[] expResult = null;
        boolean[] result = F.double2bool(valores);
        //assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        System.out.println("Resultado obtenido: " + F.bits2string(result));
    }

    /**
     * Test of bits2string method, of class Funciones.
     */
    @Test
    public void testBits2string() {
        System.out.println("bits2string");
        boolean[] bits = {true, true, false, false, true, false, true, false};
        String expResult = "11001010";
        String result = F.bits2string(bits);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test
    public void testDoubleLong(){
        
        System.out.println("TestDoubleLong");
        
        //Almacenamos los resultados en un HashMap
        HashMap<Integer, Integer> cuentas = new HashMap<Integer, Integer>();
        
        //Producir números dobles aleatorios
        for(int i=0; i<100000; i++){
            //Obtener valor aleatorio
            double valor = Double.MIN_VALUE + (r.nextDouble() * (Double.MAX_VALUE - Double.MIN_VALUE));
            
            
            //Obtener su representación binaria en string
            String cadena = Long.toBinaryString(Double.doubleToRawLongBits(valor));
            
            int l = cadena.length();
            
            if(cuentas.containsKey(l)){
            cuentas.put(l, cuentas.get(l)+1); //Sumar uno a la longitud que ha salido
            }else{
                cuentas.put(l, 1);
            }
            
        }
        
        //Mostrar las cuentas
        for(Entry<Integer, Integer> e : cuentas.entrySet()){
            System.out.println(e.getKey() + "->" + e.getValue());
        }
        
    }
}
