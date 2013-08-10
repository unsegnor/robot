/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Robots;

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
public class NNSADNFixRobotTest {
    
    public NNSADNFixRobotTest() {
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
     * Test of responder method, of class NNSADNFixRobot1.
     */
    @Test
    public void testResponder() {
        System.out.println("responder");
        double[] entradas = null;
        NNSADNFixRobot1 instance = new NNSADNFixRobot1();
        double[] expResult = null;
        double[] result = instance.responder(entradas);
        //assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}