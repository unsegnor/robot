/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Genetica;

import Genetica.NNSADNF.NNSADNFix;
import SimpleNN.NN;
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
public class NNSADNFixTest {
    
    public NNSADNFixTest() {
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
     * Test of longADN method, of class NNSADNFix.
     */
    //@Test
    public void testLongADN() {
        System.out.println("longADN");
        int[] capas = null;
        int expResult = 0;
        int result = NNSADNFix.longADN(capas);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calcularNC method, of class NNSADNFix.
     */
    //@Test
    public void testCalcularNC() {
        System.out.println("calcularNC");
        int[] capas = null;
        int[] expResult = null;
        int[] result = NNSADNFix.calcularNC(capas);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of construyeNN method, of class NNSADNFix.
     */
    //@Test
    public void testConstruyeNN_4args() {
        System.out.println("construyeNN");
        double[] adn = null;
        int[] capas = null;
        int entradas = 0;
        int salidas = 0;
        NNSADNFix instance = new NNSADNFix();
        NN expResult = null;
        NN result = instance.construyeNN(adn, capas, entradas, salidas);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of construyeNN method, of class NNSADNFix.
     */
    //@Test
    public void testConstruyeNN_doubleArr_intArr() {
        System.out.println("construyeNN");
        double[] adn = null;
        int[] capas = null;
        NN expResult = null;
        NN result = NNSADNFix.construyeNN(adn, capas);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cruzar method, of class NNSADNFix.
     */
    //@Test
    public void testCruzar_doubleArr_doubleArr() {
        System.out.println("cruzar");
        double[] adn = null;
        double[] adn2 = null;
        NNSADNFix instance = new NNSADNFix();
        double[] expResult = null;
        double[] result = instance.cruzar(adn, adn2);
        //assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cruzar method, of class NNSADNFix.
     */
    //@Test
    public void testCruzar_double_double() {
        System.out.println("cruzar");
        double gen = 0.0;
        double gen2 = 0.0;
        NNSADNFix instance = new NNSADNFix();
        double expResult = 0.0;
        double result = instance.cruzar(gen, gen2);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of adn2s method, of class NNSADNFix.
     */
    @Test
    public void testADNtoString() {
        System.out.println("ADN2S");
        double[] adn = NNSADNFix.randomADN(3000);
        String result = NNSADNFix.adn2s(adn);
        double[] expResult = NNSADNFix.s2adn(result);
        assertArrayEquals(expResult, adn, 0);
        
        
        
        
    }
}