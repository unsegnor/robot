/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MemProc;

import MemProc.Proc.tipoProc;
import static MemProc.Proc.tipoProc.SET;
import static MemProc.Proc.tipoProc.SUB;
import static MemProc.Proc.tipoProc.SUM;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 *
 * @author Víctor
 */
public class MemProcADNNet {
    
    public static final double entradas_min = 0;
    public static final double entradas_max = 0.2;
    public static final double salidas_min = 0.8;
    public static final double salidas_max = 1;

    //Mems
    TreeMap<Double, Mem> mems = new TreeMap<Double, Mem>();
    //Procs
    HashSet<Proc> procs = new HashSet<Proc>();

    public void add(double posicion, Mem mem) {
        mems.put(posicion, mem);
    }

    public void add(Proc proc) {
        procs.add(proc);
    }
    
        //Ejecutar un paso
    public void exec() {
        //Ejecutar los Proc
        for (Proc p : procs) {
            p.exec();
        }
        //Actualizar los Mem
        for (Mem m : mems.values()) {
            m.actualizar();
        }
    }

    public void setEntradas(Mem[] mems) {
        //Añadir las entradas al hashmap dentro del rango de las entradas
        int l = mems.length;
        double[] posiciones = Utiles.posicionesBaja(l, entradas_min, entradas_max);
        for (int i = 0; i < mems.length; i++) {
            this.add(posiciones[i], mems[i]);
        }
    }

    public void setSalidas(Mem[] mems) {
        //Añadir las salidas al treemap dentro del rango de las salidas
        int l = mems.length;
        double[] posiciones = Utiles.posicionesBaja(l, salidas_min, salidas_max);
        for (int i = 0; i < mems.length; i++) {
            this.add(posiciones[i], mems[i]);
        }
    }

    public MemProcADNNet() {
        
        //Inicializamos los mems con al menos uno, el cero
        mems.put(0d, new Mem(0));
        
        
    }
    //Devuelve el mem más cercano a la posición especificada

    public Mem getMem(double posicion) {
        Mem respuesta = null;

        //Utilizamos la función del TreeMap floor que devuelve la entrada con el valor más cercano por debajo o igual a la posición especificada
        Double key = mems.floorKey(posicion);
        respuesta = mems.get(key);


        return respuesta;
    }

    public void setFromADN(MemProcADN adn) {

        double[] valores = adn.valores;
        int l = adn.valores.length;

//hemos terminado
        boolean terminado = false;

        int i = 0;

        //Recorrer el adn conformando la red
        while (!terminado) {
            //Hasta 0.5 define un Mem
            if (valores[i] <= 0.5) {
                //Miramos los 2 valores siguientes si los hay
                if (l > i + 2) {
                    //Si tenemos valores los usamos para formar y añadir un mem
                    this.add(valores[i + 1], new Mem(valores[i + 2]));
                    //Actualizamos el índice
                    i += 3;
                } else {
                    //Si no quedan valores para montar un mem, hemos terminado
                    terminado = true;
                }

            } else {
                //Sino define un proc
                if (l > i + 5) {
                    tipoProc tipo;
                    double n_tipoProc = valores[i + 1];
                    if (n_tipoProc <= 0.33333) {
                        tipo = tipoProc.SUM;
                    } else if (n_tipoProc <= 0.66666) {
                        tipo = tipoProc.SUB;
                    } else {
                        tipo = tipoProc.SET;
                    }

                    //Recuperar los mems a los que se hace referencia
                    Mem origen = this.getMem(valores[i + 2]);
                    Mem destino = this.getMem(valores[i + 3]);
                    Mem valor = this.getMem(valores[i + 4]);
                    Mem umbral = this.getMem(valores[i + 5]);

                    //Crear el Proc y añadir
                    Proc nuevoProc = new Proc(tipo, origen, destino, valor, umbral);

                    this.add(nuevoProc);

                    //Actualizamos el índice
                    i += 6;

                } else {
                    //Si no quedan valores para montar un proc, hemos terminado
                    terminado = true;
                }

            }

            //Si i es mayor que el máximo también hemos terminado
            if (i >= l) {
                terminado = true;
            }
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
        for (Entry<Double, Mem> e : mems.entrySet()) {

            Mem m = e.getValue();
            Double posicion = e.getKey();
            
            sb.append(m.hashCode()).append("[")
                    .append("label=\"").append(posicion).append("[").append(m.get()).append("]\"")
                    .append(", ").append("shape=box");
                    
                    //Si está en el rango de las entradas la pintamos de verde
                    if(posicion < entradas_max && posicion > entradas_min){
                        sb.append(", ").append("color=green");
                    }else if( posicion < salidas_max && posicion > salidas_min){
                        sb.append(", ").append("color=red");
                    }
            
            
                    //Si está en el rango de las salidas de rojo
            
                    
                    
                    sb.append("];\n");


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
