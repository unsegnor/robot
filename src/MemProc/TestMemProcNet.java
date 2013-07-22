/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MemProc;

/**
 *
 * @author Víctor
 */
public class TestMemProcNet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Determinar entradas y salidas

        double[] valores_entrada = {1, 2, 5};

        Mem[] entrada = Mem.array(valores_entrada);

        Mem[] salida = Mem.array(3);
        
        Mem umbral = new Mem(2);

        //Generar procs
        Proc p1 = new Proc(entrada[0], entrada[1], salida[0], umbral);
        Proc p2 = new Proc(entrada[1], entrada[2], salida[1], umbral);
        Proc p3 = new Proc(entrada[2], entrada[2], salida[2], umbral);
        Proc p4 = new Proc(entrada[2], entrada[1], entrada[0], umbral);

        //Crear red
        MemProcNet red = new MemProcNet();
        red.add(p1);
        red.add(p2);
        red.add(p3);
        red.add(p4);

        //Imprimir entradas y salidas
        System.out.print(" Entrada ");
        System.out.print(imprime(entrada));

        System.out.print(" Salida ");
        System.out.println(imprime(salida));

        for (int i = 0; i < 10; i++) {

            //Ejecutar red
            red.exec();

            //Imprimir entradas y salidas
            System.out.print(" Entrada ");
            System.out.print(imprime(entrada));

            System.out.print(" Salida ");
            System.out.println(imprime(salida));
        }
        
        System.out.println(red.toDOT());

    }

    static String imprime(Mem[] v) {
        StringBuilder sb = new StringBuilder();

        for (Mem m : v) {
            sb.append(m.valor).append("|");
        }


        return sb.toString();
    }
}
