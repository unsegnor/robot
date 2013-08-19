/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Training;

import java.util.Comparator;

/**
 *
 * @author Víctor
 */
public class OrdenarResultados implements Comparator<Resultado> {

    boolean ordenar_por_valor;
    boolean inverso;

    public OrdenarResultados(boolean por_valor, boolean inverso) {
        this.ordenar_por_valor = por_valor;
        this.inverso = inverso;
    }

    @Override
    public int compare(Resultado o1, Resultado o2) {
        if (ordenar_por_valor) {
            if (inverso) {
                return Double.compare(o2.b, o1.b);
            } else {
                return Double.compare(o1.b, o2.b);
            }
        } else {
            if (inverso) {
                return Integer.compare(o2.a, o1.a);
            } else {
                return Integer.compare(o1.a, o2.a);
            }
        }
    }
}
