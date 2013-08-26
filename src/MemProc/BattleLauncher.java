/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MemProc;

import General.ResultadosBatalla;
import General.AnotadorDeResultados;

/**
 * lanza batallas y devuelve los resultados
 * @author Víctor
 */
public class BattleLauncher implements AnotadorDeResultados {

    ResultadosBatalla resultados;
    
    
    
    
    @Override
    public void anotarResultados(ResultadosBatalla resultados) {
        this.resultados = resultados;
    }
    
}
