/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MemProc;

/**
 *
 * @author Víctor
 */
public class BattleConfig {
    
    private int nrounds = 100;
    private boolean visible = false;
    private int enemigo = 1;

    /**
     * @return the nrounds
     */
    public int getNrounds() {
        return nrounds;
    }

    /**
     * @param nrounds the nrounds to set
     */
    public void setNrounds(int nrounds) {
        this.nrounds = nrounds;
    }

    /**
     * @return the visible
     */
    public boolean isVisible() {
        return visible;
    }

    /**
     * @param visible the visible to set
     */
    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    /**
     * @return the enemigo
     */
    public int getEnemigo() {
        return enemigo;
    }

    /**
     * @param enemigo the enemigo to set
     */
    public void setEnemigo(int enemigo) {
        this.enemigo = enemigo;
    }
    
}
