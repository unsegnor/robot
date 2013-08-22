/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MemProc;

import static MemProc.TestMemProcNet.imprime;

/**
 *
 * @author Víctor
 */
public class MemProcNetNeuron {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Determinar entradas y salidas

        Mem[] entrada = Utiles.getMemArray(4);
        
        entrada[1].setValor(1);

        Mem[] salidas = Utiles.getMemArray(1);
        
        Mem salida = salidas[0];

        Mem umbral = new Mem(0.5);
        
        Mem  min = entrada[0];
                
        Mem max =entrada[1];
        
        Mem pesoA = new Mem(0.3);
        
        Mem pesoB = new Mem(0.5);

        Mem carga = new Mem(0);
        
        //Generar procs
        Proc p1 = new Proc(Proc.tipoProc.SUM, pesoA, carga, entrada[2], min);
        Proc p2 = new Proc(Proc.tipoProc.SUM, pesoB, carga, entrada[3], min);
        Proc p3 = new Proc(Proc.tipoProc.SET, max, salida, carga, umbral);
        //Proc p4 = new Proc(Proc.tipoProc.SUM, entrada[2], entrada[1], entrada[0], umbral);

        //Crear red
        MemProcNet red = new MemProcNet();
        red.add(p1);
        red.add(p2);
        red.add(p3);
        //red.add(p4);

        //Imprimir entradas y salidas
        System.out.print(" Entrada ");
        System.out.print(imprime(entrada));

        System.out.print(" Salida ");
        System.out.println(imprime(salidas));

        for (int i = 0; i < 10; i++) {

            //Ejecutar red
            red.exec();

            //Imprimir entradas y salidas
            System.out.print(" Entrada ");
            System.out.print(imprime(entrada));

            System.out.print(" Salida ");
            System.out.println(imprime(salidas));
        }

        System.out.println(red.toDOT());

    }

    static String imprime(Mem[] v) {
        StringBuilder sb = new StringBuilder();

        for (Mem m : v) {
            sb.append(m.getValor()).append("|");
        }


        return sb.toString();
    }
}
