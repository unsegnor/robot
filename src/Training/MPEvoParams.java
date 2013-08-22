/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Training;

import MemProc.MemProcADN;

/**
 *
 * @author Víctor
 */
public class MPEvoParams {
    
    private int numero_de_individuos = 0;
    private int numero_de_descendientes = 0;
    private double probabilidad_de_mutacion = 0;
    private int numero_de_progenitores = 0;
    private int numero_de_competidores = 0;
    private int longitud_solucion_inicial = 0;
    private double diferencia_minima_en_cruce = 0;
    private int maximo_decremento_adn = 0;
    private int maximo_incremento_adn = 0;
    
    
    private boolean debug = false;
    private MemProcADN solucion;
    
    private boolean printToFile = false;

    /**
     * @return the numero_de_individuos
     */
    public int getNumero_de_individuos() {
        return numero_de_individuos;
    }

    /**
     * @param numero_de_individuos the numero_de_individuos to set
     */
    public void setNumero_de_individuos(int numero_de_individuos) {
        this.numero_de_individuos = numero_de_individuos;
    }

    /**
     * @return the numero_de_descendientes
     */
    public int getNumero_de_descendientes() {
        return numero_de_descendientes;
    }

    /**
     * @param numero_de_descendientes the numero_de_descendientes to set
     */
    public void setNumero_de_descendientes(int numero_de_descendientes) {
        this.numero_de_descendientes = numero_de_descendientes;
    }

    /**
     * @return the probabilidad_de_mutacion
     */
    public double getProbabilidad_de_mutacion() {
        return probabilidad_de_mutacion;
    }

    /**
     * @param probabilidad_de_mutacion the probabilidad_de_mutacion to set
     */
    public void setProbabilidad_de_mutacion(double probabilidad_de_mutacion) {
        this.probabilidad_de_mutacion = probabilidad_de_mutacion;
    }

    /**
     * @return the numero_de_progenitores
     */
    public int getNumero_de_progenitores() {
        return numero_de_progenitores;
    }

    /**
     * @param numero_de_progenitores the numero_de_progenitores to set
     */
    public void setNumero_de_progenitores(int numero_de_progenitores) {
        this.numero_de_progenitores = numero_de_progenitores;
    }

    /**
     * @return the numero_de_competidores
     */
    public int getNumero_de_competidores() {
        return numero_de_competidores;
    }

    /**
     * @param numero_de_competidores the numero_de_competidores to set
     */
    public void setNumero_de_competidores(int numero_de_competidores) {
        this.numero_de_competidores = numero_de_competidores;
    }

    /**
     * @return the longitud_solucion_inicial
     */
    public int getLongitud_solucion_inicial() {
        return longitud_solucion_inicial;
    }

    /**
     * @param longitud_solucion_inicial the longitud_solucion_inicial to set
     */
    public void setLongitud_solucion_inicial(int longitud_solucion_inicial) {
        this.longitud_solucion_inicial = longitud_solucion_inicial;
    }

    /**
     * @return the diferencia_minima_en_cruce
     */
    public double getDiferencia_minima_en_cruce() {
        return diferencia_minima_en_cruce;
    }

    /**
     * @param diferencia_minima_en_cruce the diferencia_minima_en_cruce to set
     */
    public void setDiferencia_minima_en_cruce(double diferencia_minima_en_cruce) {
        this.diferencia_minima_en_cruce = diferencia_minima_en_cruce;
    }

    /**
     * @return the maximo_decremento_adn
     */
    public int getMaximo_decremento_adn() {
        return maximo_decremento_adn;
    }

    /**
     * @param maximo_decremento_adn the maximo_decremento_adn to set
     */
    public void setMaximo_decremento_adn(int maximo_decremento_adn) {
        this.maximo_decremento_adn = maximo_decremento_adn;
    }

    /**
     * @return the minimo_decremento_adn
     */
    public int getMaximo_incremento_adn() {
        return maximo_incremento_adn;
    }

    /**
     * @param minimo_decremento_adn the minimo_decremento_adn to set
     */
    public void setMaximo_incremento_adn(int minimo_decremento_adn) {
        this.maximo_incremento_adn = minimo_decremento_adn;
    }

    void setFromADN(MPEvoParamsADN adnparams) {
        double[] valores = adnparams.valores;
        
        this.setDiferencia_minima_en_cruce(valores[0]);
        this.setLongitud_solucion_inicial((int)valores[1]);
        this.setMaximo_decremento_adn((int)valores[2]);
        this.setMaximo_incremento_adn((int)valores[3]);
        this.setNumero_de_competidores((int)valores[4]);
        this.setNumero_de_descendientes((int)valores[5]);
        this.setNumero_de_individuos((int)valores[6]);
        this.setNumero_de_progenitores((int)valores[7]);
        this.setProbabilidad_de_mutacion(valores[8]);
        
        
    }

    /**
     * @return the debug
     */
    public boolean isDebug() {
        return debug;
    }

    /**
     * @param debug the debug to set
     */
    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    /**
     * @return the solucion
     */
    public MemProcADN getSolucion() {
        return solucion;
    }

    /**
     * @param solucion the solucion to set
     */
    public void setSolucion(MemProcADN solucion) {
        this.solucion = solucion;
    }

    /**
     * @return the printToFile
     */
    public boolean isPrintToFile() {
        return printToFile;
    }

    /**
     * @param printToFile the printToFile to set
     */
    public void setPrintToFile(boolean printToFile) {
        this.printToFile = printToFile;
    }
    
}
