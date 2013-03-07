/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utiles;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Victor
 */
public class FuncionesTest {
    
    public FuncionesTest() {
    }

    /**
     * Test of double2bool method, of class Funciones.
     */
    @Test
    public void testDouble2bool() {
        System.out.println("double2bool");
        double valor = -100.5;//21545698;
        boolean[] result = Funciones.double2bool(valor);
        //assertArrayEquals(expResult, result);
        
        System.out.println("Número en decimal: " + valor);
        System.out.println("Resultado obtenido: " + Funciones.bits2string(result));
        
        // TODO review the generated test code and remove the default call to fail.
    }
}
