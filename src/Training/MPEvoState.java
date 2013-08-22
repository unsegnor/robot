/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Training;

/**
 *
 * @author Víctor
 */
public class MPEvoState {
    
    public boolean newmax = false;
    private double maxeval = 0;
    public double[] adn;
    public int nevals = 0;

    /**
     * @return the maxeval
     */
    public double getMaxeval() {
        return maxeval;
    }

    /**
     * @param maxeval the maxeval to set
     */
    public void setMaxeval(double maxeval) {
        this.maxeval = maxeval;
        newmax = true;
    }
    
}
