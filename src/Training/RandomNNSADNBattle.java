/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Training;

import robocode.control.BattleSpecification;
import robocode.control.BattlefieldSpecification;
import robocode.control.RobocodeEngine;
import robocode.control.RobotSpecification;

/**
 *
 * @author Víctor
 */
public class RandomNNSADNBattle {

    public static void main(String[] args) {
 
         // Disable log messages from Robocode
         RobocodeEngine.setLogMessagesEnabled(false);

         // Create the RobocodeEngine
         //   RobocodeEngine engine = new RobocodeEngine(); // Run from current working directory
         RobocodeEngine engine = new RobocodeEngine(new java.io.File("C:/Robocode")); // Run from C:/Robocode
          
         // Add our own battle listener to the RobocodeEngine 
         BattleObserver bo = new BattleObserver();
         engine.addBattleListener(bo);
 
         // Show the Robocode battle view
         engine.setVisible(true);
 
         // Setup the battle specification
 
         int numberOfRounds = 1;
         BattlefieldSpecification battlefield = new BattlefieldSpecification(800, 600); // 800x600
         RobotSpecification[] selectedRobots = engine.getLocalRepository("Robots.RandomNNSADNRobot*,Robots.RandomNNSADNRobot*,Robots.RandomNNSADNRobot*");
         
         System.out.println(RobocodeEngine.getRobotsDir());
         
         RobotSpecification[] allRobots = engine.getLocalRepository();
         
         System.out.println("Robots en el repositorio");
         
         for(RobotSpecification rs : allRobots){
             System.out.println(rs.getName());
         }
         
         BattleSpecification battleSpec = new BattleSpecification(numberOfRounds, battlefield, selectedRobots);
 
         // Run our specified battle and let it run till it is over
         engine.runBattle(battleSpec, true); // waits till the battle finishes
 
         // Cleanup our RobocodeEngine
         engine.close();
 
         // Make sure that the Java VM is shut down properly
         System.exit(0);
     }
}
