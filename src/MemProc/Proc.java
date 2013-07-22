/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MemProc;

/**
 * Unidad de procesamiento. Relaciona 4 Mem (Origen, Peso, Destino. Umbral) de forma que:
 *  Cuando el valor de Origen supera el Umbral, entonces se añade a Destino el valor de Peso.
 *  Si Origen.get() > Umbral.get() -> Destino.add(Peso.get())
 * 
 * Se puede realizar la ejecución todas a la vez, por orden (no tiene sentido?) o de forma aleatoria.
 * 
 * 
 * @author Víctor
 */
public class Proc {
    
    Mem Origen,Peso,Destino,Umbral;
    
    public void exec(){
        if(Origen.get()>Umbral.get()){
            Destino.add(Peso.get());
        }
    }
    
    public Proc(){};
    
    public Proc(Mem Origen, Mem Peso, Mem Destino, Mem Umbral){
        init(Origen, Peso, Destino, Umbral);
    }
    
    
    private void init(Mem Origen, Mem Peso, Mem Destino, Mem Umbral){
        this.Origen = Origen;
        this.Peso = Peso;
        this.Destino = Destino;
        this.Umbral = Umbral;
    }
    
    //También podemos actualizar los Mem a través de los Proc
    public void actualizar(){
        Origen.actualizar();
        Peso.actualizar();
        Destino.actualizar();
        Umbral.actualizar();
    }
       
    
}
