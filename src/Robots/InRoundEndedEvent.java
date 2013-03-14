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
        setRounds(event.getRound());
        setTotalturns(event.getTotalTurns());
        setTurns(event.getTurns());
    }

    void reiniciar() {
        this.setRounds(0);
        this.setTotalturns(0);
        this.setTurns(0);
    }

    /**
     * @return the rounds
     */
    public int getRounds() {
        return rounds;
    }

    /**
     * @param rounds the rounds to set
     */
    public void setRounds(int rounds) {
        this.rounds = rounds;
    }

    /**
     * @return the totalturns
     */
    public int getTotalturns() {
        return totalturns;
    }

    /**
     * @param totalturns the totalturns to set
     */
    public void setTotalturns(int totalturns) {
        this.totalturns = totalturns;
    }

    /**
     * @return the turns
     */
    public int getTurns() {
        return turns;
    }

    /**
     * @param turns the turns to set
     */
    public void setTurns(int turns) {
        this.turns = turns;
    }
    
}
