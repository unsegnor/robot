/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Training;

import robocode.control.events.BattleAdaptor;
import robocode.control.events.BattleCompletedEvent;
import robocode.control.events.BattleErrorEvent;
import robocode.control.events.BattleMessageEvent;

/**
 *
 * @author Víctor
 */
 //
 // Our private battle listener for handling the battle event we are interested in.
 //
 public class BattleObserver extends BattleAdaptor {
 
     // Called when the battle is completed successfully with battle results
     public void onBattleCompleted(BattleCompletedEvent e) {
         //System.out.println("-- Battle has completed --");
         
         // Print out the sorted results with the robot names
         System.out.println("Battle results:");
         for (robocode.BattleResults result : e.getSortedResults()) {
             System.out.println("  " + result.getTeamLeaderName() + ": " + result.getScore());
         }
     }
 
     // Called when the game sends out an information message during the battle
     public void onBattleMessage(BattleMessageEvent e) {
         //System.out.println("Msg> " + e.getMessage());
     }
 
     // Called when the game sends out an error message during the battle
     public void onBattleError(BattleErrorEvent e) {
         System.out.println("Err> " + e.getError());
     }
 }
