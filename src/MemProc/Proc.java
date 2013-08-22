/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MemProc;

/**
 * Unidad de procesamiento. Relaciona 4 Mem (Valor, Origen, Destino. Umbral) de
 * forma que: Cuando el valor de Valor supera el Umbral, entonces se añade a
 * Destino el valor de Origen. Si Valor.get() > Umbral.get() ->
 * Destino.add(Origen.get())
 *
 * Se puede realizar la ejecución todas a la vez, por orden (no tiene sentido?)
 * o de forma aleatoria.
 *
 *
 * @author Víctor
 */
public class Proc {

    public enum tipoProc {

        SUM, SUB, SET
    };
    tipoProc tipo = tipoProc.SUM;
    Mem Valor, Origen, Destino, Umbral;

    public void exec() {
        if (Valor.get() > Umbral.get()) {
            switch (tipo) {
                case SUM:
                    Destino.add(Origen.get());
                    break;
                case SUB:
                    Destino.sub(Origen.get());
                    break;
                case SET:
                    Destino.set(Origen.get());
                    break;
            }
        }
    }

    public Proc() {
    }

    ;
    
    public Proc(tipoProc tipo, Mem Origen, Mem Destino, Mem Valor, Mem Umbral) {
        init(tipo, Origen, Destino, Valor, Umbral);
    }

    private void init(tipoProc tipo, Mem Origen, Mem Destino, Mem Valor, Mem Umbral) {
        this.Valor = Valor;
        this.Origen = Origen;
        this.Destino = Destino;
        this.Umbral = Umbral;
        this.tipo = tipo;
    }

    //También podemos actualizar los Mem a través de los Proc
    public void actualizar() {
        Valor.actualizar();
        Origen.actualizar();
        Destino.actualizar();
        Umbral.actualizar();
    }
}
