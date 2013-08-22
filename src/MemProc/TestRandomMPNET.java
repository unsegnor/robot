/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MemProc;

/**
 *
 * @author Víctor
 */
public class TestRandomMPNET {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MemProcADNNet red = new MemProcADNNet();
        
        MemProcADN adn = MemProcADN.aleatorio(30);
        
        red.setFromADN(adn);
        
        System.out.println(red.toDOT());
        
        red.exec();
        
        System.out.println(red.toDOT());
    }
}
