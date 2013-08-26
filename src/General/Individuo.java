/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package General;

/**
 *
 * @author Víctor
 */
public class Individuo {

    private boolean calculado = false;
    private double ultimo_resultado = 0;
    
    private ADN adn;

    /**
     * @return the calculado
     */
    public boolean isCalculado() {
        return calculado;
    }

    /**
     * @param calculado the calculado to set
     */
    public void setCalculado(boolean calculado) {
        this.calculado = calculado;
    }

    /**
     * @return the ultimo_resultado
     */
    public double getUltimo_resultado() {
        return ultimo_resultado;
    }

    /**
     * @param ultimo_resultado the ultimo_resultado to set
     */
    public void setUltimo_resultado(double ultimo_resultado) {
        this.ultimo_resultado = ultimo_resultado;
    }

    /**
     * @return the adn
     */
    public ADN getAdn() {
        return adn;
    }

    /**
     * @param adn the adn to set
     */
    public void setAdn(ADN adn) {
        this.adn = adn;
    }
}
