/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Training;

import Genetica.NNSADNF.GestorADN;
import Genetica.NNSADNF.NNSADNFix;
import robocode.control.BattleSpecification;
import robocode.control.BattlefieldSpecification;
import robocode.control.RobocodeEngine;
import robocode.control.RobotSpecification;

/**
 *
 * @author Víctor
 */
public class NNSFDifADNBattle {

    public static void main(String[] args) {
 
         // Disable log messages from Robocode
         RobocodeEngine.setLogMessagesEnabled(false);

         // Create the RobocodeEngine
         //   RobocodeEngine engine = new RobocodeEngine(); // Run from current working directory
         RobocodeEngine engine = new RobocodeEngine(new java.io.File("C:/Robocode")); // Run from C:/Robocode
          
         // Add our own battle listener to the RobocodeEngine 
         BattleObserver bo = new BattleObserver();
         engine.addBattleListener(bo);
         
         //Preparar población
         int longitud = NNSADNFix.longADN(NNSADNFix.globalCapas);
         
         Genetica.NNSADNF.GestorADN.addRandomPop(3, longitud);
         
         //Guardar población en archivo
         GestorADN.savetofile("poblaciones");
         
         //Quizá haya que cambair y recompilar los robots antes de cada batalla
         System.out.println("ClassLoader de GestorADN: " + GestorADN.class.getClassLoader().toString());
         //Cargar el Gestor de ADN desde un classloader común y superior a los robots que se cargarán luego... se podrá? no creo
         
         
         // Show the Robocode battle view
         engine.setVisible(true);
 
         // Setup the battle specification
 
         int numberOfRounds = 1;
         BattlefieldSpecification battlefield = new BattlefieldSpecification(800, 600); // 800x600
         RobotSpecification[] selectedRobots = engine.getLocalRepository("Robots.NNSADNFixRobot1*,Robots.NNSADNFixRobot2*,Robots.NNSADNFixRobot3*");
         
         
         
         BattleSpecification battleSpec = new BattleSpecification(numberOfRounds, battlefield, selectedRobots);
 
         // Run our specified battle and let it run till it is over
         engine.runBattle(battleSpec, true); // waits till the battle finishes
         
 
         // Cleanup our RobocodeEngine
         engine.close();
 
         // Make sure that the Java VM is shut down properly
         System.exit(0);
     }
    
    private void generarPoblacion(){
        
    }
    
    private void evaluarPoblacion(){
        
    }
    
    
    
}
