/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SimpleNN;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Víctor
 */
public class NNTest {
    
    public NNTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of exec method, of class NN.
     */
    @Test
    public void testExec() {
        System.out.println("exec");
        double[] entradas = {0.3,0.4,0.6,0.1,0};
        int[] capas = {35,30,35};
        NN instance = new NN(capas);
        double[] expResult = null;
        double[] result = instance.exec(entradas);
        for(int i=0; i<result.length; i++){
            System.out.println(result[i]);
        }

        //assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setNEntradas method, of class NN.
     */
    //@Test
    public void testSetNEntradas() {
        System.out.println("setNEntradas");
        int nentradas = 0;
        NN instance = new NN();
        instance.setNEntradas(nentradas);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNSalidas method, of class NN.
     */
    //@Test
    public void testSetNSalidas() {
        System.out.println("setNSalidas");
        int nsalidas = 0;
        NN instance = new NN();
        instance.setNSalidas(nsalidas);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}