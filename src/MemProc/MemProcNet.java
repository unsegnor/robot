/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MemProc;

import static MemProc.Proc.tipoProc.SUM;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Red que se compone de elementos Mem y Proc
 *
 * @author Víctor
 */
public class MemProcNet {

    //Colección de Mem
    HashSet<Mem> mems = new HashSet<Mem>();
    //Espacio de Mem
    HashMap<Double, Mem> espacioMem = new HashMap<Double, Mem>();
    //Colección de Proc
    ArrayList<Proc> procs = new ArrayList<Proc>();

    //Añadir Mem
    public void add(Mem mem) {
        mems.add(mem);
    }

    //Añadir Proc
    public void add(Proc proc) {
        procs.add(proc);

        //Añadimos también los Mem que utilice el Proc
        add(proc.Origen);
        add(proc.Destino);
        add(proc.Valor);
        add(proc.Umbral);
    }

    //Ejecutar un paso
    public void exec() {
        //Ejecutar los Proc
        for (Proc p : procs) {
            p.exec();
        }
        //Actualizar los Mem
        for (Mem m : mems) {
            m.actualizar();
        }
    }

    /**
     * Imprimir para graphviz en DOT
     */
    public String toDOT() {
        StringBuilder sb = new StringBuilder();

        sb.append("digraph memprocnet{\n");

        //Definición de los mems entradas y salidas


        //Definición de los mems
        for (Mem m : mems) {

            sb.append(m.hashCode()).append("[")
                    .append("label=").append(m.get()).append(", ")
                    .append("shape=box")
                    .append("];\n");


        }


        //Definición de los procs
        for (Proc p : procs) {

            //Definimos cómo se representa el proc
            sb.append(p.hashCode()).append("[");
            switch (p.tipo) {
                case SUM:
                    sb.append("label=\"+\"");
                    break;
                case SUB:
                    sb.append("label=\"-\"");
                    break;
                case SET:
                    sb.append("label=\"=\"");
                    break;
            }

            sb.append(", shape=\"doublecircle\"")
                    .append("];\n");

            //Dibujamos el arco del Valor al proc
            sb.append(p.hashCode()).append("->").append(p.Valor.hashCode()).append("[arrowhead=\"invodot\"];\n");
            //De proc a Origen
            sb.append(p.hashCode()).append("->").append(p.Origen.hashCode()).append("[arrowhead=\"inv\"];\n");
            //De proc a Umbral
            sb.append(p.hashCode()).append("->").append(p.Umbral.hashCode()).append("[arrowhead=\"odot\"];\n");
            //De proc a destino
            sb.append(p.hashCode()).append("->").append(p.Destino.hashCode()).append("[arrowhead=\"normal\"];\n");
        }

        sb.append("}");


        return sb.toString();
    }
}
