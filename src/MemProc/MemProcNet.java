/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MemProc;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Red que se compone de elementos Mem y Proc
 * @author Víctor
 */
public class MemProcNet {
    
    //Colección de Mem
    HashSet<Mem> mems = new HashSet<Mem>();
    
    //Colección de Proc
    ArrayList<Proc> procs = new ArrayList<Proc>();
    
    //Añadir Mem
    public void add(Mem mem){
        mems.add(mem);
    }
    
    //Añadir Proc
    public void add(Proc proc){
        procs.add(proc);
        
        //Añadimos también los Mem que utilice el Proc
        add(proc.Origen);
        add(proc.Peso);
        add(proc.Destino);
    }
    
    //Ejecutar un paso
    public void exec(){
        //Ejecutar los Proc
        for(Proc p : procs){
            p.exec();
        }
        //Actualizar los Mem
        for(Mem m : mems){
            m.actualizar();
        }
    }
    
    /**
     * Imprimir para graphviz en DOT
     */
    public String toDOT(){
        StringBuilder sb = new StringBuilder();
        
        sb.append("digraph memprocnet{");
        
        //Definición de los mems
        for(Mem m : mems){
            
        }
        
        
        
        for(Proc p : procs){
            
            
            
        }
        
        sb.append("}");
        
        
        return sb.toString();
    }
    
    
}
