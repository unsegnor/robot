/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Robots;

import robocode.RoundEndedEvent;

/**
 *
 * @author Victor
 */
class InRoundEndedEvent {
    private int rounds;
    private int totalturns;
    private int turns;

    public InRoundEndedEvent() {
    }
    
    public void copy(RoundEndedEvent event){
        rounds = event.getRound();
        totalturns = event.getTotalTurns();
        turns = event.getTurns();
    }

    void reiniciar() {
        this.rounds = 0;
        this.totalturns = 0;
        this.turns = 0;
    }
    
}
