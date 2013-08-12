/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SimpleNN;

import Interfaces.Algoritmo;
import Utiles.F;
import java.util.Random;

/**
 * Red neuronal que trabaja con valores reales.
 *
 * @author Víctor
 */
public class NNModOutput implements Algoritmo {

    Random r = new Random();
    private double[][][] pesos; //pesos[A][B][C] Almacenará el peso de la conexión entre la neurona B de la capa A y la neurona C de la capa anterior
    double[][] neuronas;// neuronas[capa][neurona]
    private int nsalidas;
    private int nentradas;
    private int[] nneuronas;
    private int ncapas;
    private int maxnneuronas;
    private double[][] umbral; //umbral[capa][neurona] a partir del cual se considera activa
    private int[] capas;

    public NNModOutput() {
    }

    public NNModOutput(int n) {
        init(n);
    }

    public NNModOutput(int[] capas) {
        init(capas);
    }

    public NNModOutput(int[] capas, double[] umbrales, double[] estados, double[] pesos) {
        init(capas, umbrales, estados, pesos);
    }

    private void init(int[] capas, double[] umbrales, double[] estados, double[] pesos) {
        this.capas = capas;

        calcularES();

        //En cada capa añadimos tantas neuronas como indique el vector

        ncapas = capas.length;
        //Definimos el número de neuronas por capa y almacenamos la mayor capa

        nneuronas = new int[ncapas];

        for (int i = 0; i < ncapas; i++) {
            nneuronas[i] = capas[i];
            if (capas[i] > maxnneuronas) {
                maxnneuronas = capas[i];
            }
        }


        //Creamos las neuronas
        neuronas = new double[ncapas][maxnneuronas];

        //Inicializamos las neuronas según el vector de estados
        int k = 0;
        for (int i = 0; i < ncapas; i++) {
            for (int j = 0; j < nneuronas[i]; j++) {
                double valor;
                if (k < estados.length) {
                    valor = estados[k];
                } else {
                    valor = 0;
                }
                neuronas[i][j] = valor;
                k++;
            }
        }

        setPesos(new double[ncapas][maxnneuronas][maxnneuronas]);

        //Inicializamos los pesos según el vector de pesos
        k = 0;
        for (int capa = 1; capa < ncapas; capa++) {
            for (int neurona = 0; neurona < nneuronas[capa]; neurona++) {
                for (int neurona_anterior = 0; neurona_anterior < nneuronas[capa - 1]; neurona_anterior++) {
                    double valor;
                    if (k < pesos.length) {
                        valor = pesos[k];
                    } else {
                        valor = 0;
                    }
                    getPesos()[capa][neurona][neurona_anterior] = valor;
                    k++;
                }
            }
        }

        setUmbral(new double[ncapas][maxnneuronas]);

        //Inicializamos los umbrales a 0.1 para empezar
        k = 0;
        for (int i = 0; i < getUmbral().length; i++) {
            for (int j = 0; j < getUmbral()[i].length; j++) {
                double valor;
                if (k < umbrales.length) {
                    valor = umbrales[k];
                } else {
                    valor = 0;
                }
                getUmbral()[i][j] = valor;
                k++;
            }
        }

    }

    private void calcularES() {
        nentradas = capas[0];
        nsalidas = capas[capas.length - 1];
    }

    private void init(int[] capas) {

        this.capas = capas;

        calcularES();

        //En cada capa añadimos tantas neuronas como indique el vector

        ncapas = capas.length;
        //Definimos el número de neuronas por capa y almacenamos la mayor capa

        nneuronas = new int[ncapas];

        for (int i = 0; i < ncapas; i++) {
            nneuronas[i] = capas[i];
            if (capas[i] > maxnneuronas) {
                maxnneuronas = capas[i];
            }
        }


        //Creamos las neuronas
        neuronas = new double[ncapas][maxnneuronas];

        //Inicializamos las neuronas a cero
        for (int i = 0; i < ncapas; i++) {
            for (int j = 0; j < nneuronas[i]; j++) {
                neuronas[i][j] = 0;
            }
        }

        setPesos(new double[ncapas][maxnneuronas][maxnneuronas]);

        //Inicializamos los pesos random
        for (int capa = 1; capa < ncapas; capa++) {
            for (int neurona = 0; neurona < nneuronas[capa]; neurona++) {
                for (int neurona_anterior = 0; neurona_anterior < nneuronas[capa - 1]; neurona_anterior++) {
                    getPesos()[capa][neurona][neurona_anterior] = r.nextDouble();
                }
            }
        }

        inicializarumbrales();


    }

    private void init(int n) {
        //n es el número de neuronas, hacemos la red cuadrada

        ncapas = n;

        nneuronas = new int[ncapas];

        //Definimos el número de neuronas por capa
        for (int i = 0; i < ncapas; i++) {
            nneuronas[i] = n;
        }

        //Creamos las neuronas
        neuronas = new double[ncapas][n];

        //Inicializamos las neuronas a cero
        for (int i = 0; i < ncapas; i++) {
            for (int j = 0; j < nneuronas[i]; j++) {
                neuronas[i][j] = 0;
            }
        }

        setPesos(new double[ncapas][n][n]);

        //Inicializamos los pesos random
        for (int capa = 1; capa < ncapas; capa++) {
            for (int neurona = 0; neurona < nneuronas[capa]; neurona++) {
                for (int neurona_anterior = 0; neurona_anterior < nneuronas[capa - 1]; neurona_anterior++) {
                    getPesos()[capa][neurona][neurona_anterior] = r.nextDouble();
                }
            }
        }

        inicializarumbrales();

    }

    @Override
    public double[] exec(double[] entradas) {
        double[] salidas = new double[nsalidas];
        System.arraycopy(entradas, 0, neuronas[0], 0, nneuronas[0]);


        //Para cada capa intermedia
        for (int c = 1; c < ncapas; c++) {

            //Para cada neurona de la capa c
            for (int n = 0; n < nneuronas[c]; n++) {
                //Reiniciamos su valor //TODO versiones que simplemente reducen el peso sin inicializarlo hasta que salta?
                neuronas[c][n] = 0;

                //Comprobar todas sus conexiones con la capa anterior
                for (int i = 0; i < nneuronas[c - 1]; i++) {

                    //Si la conexión está activa entonces comprobamos su peso
                    if (neuronas[c - 1][i] >= getUmbral()[c - 1][i]) {
                        //Sumamos el peso de la conexión al valor de la neurona
                        neuronas[c][n] += getPesos()[c][n][i];
                    }

                }


            }

        }

        //Copiamos las salidas
        System.arraycopy(neuronas[ncapas - 1], 0, salidas, 0, nneuronas[ncapas - 1]);


        //Limitamos los valores entre 0 y 1

        double maxvalor = Double.MIN_VALUE;
        double minvalor = Double.MAX_VALUE;

        for (int i = 0; i < salidas.length; i++) {
            if (salidas[i] > maxvalor) {
                maxvalor = salidas[i];
            }
            if (salidas[i] < minvalor) {
                minvalor = salidas[i];
            }
        }

        for (int i = 0; i < salidas.length; i++) {
            salidas[i] = F.q(salidas[i], maxvalor, minvalor);
        }


        return salidas;
    }

    @Override
    public void setNEntradas(int nentradas) {
        this.nentradas = nentradas;
    }

    @Override
    public void setNSalidas(int nsalidas) {
        this.nsalidas = nsalidas;
    }

    private void inicializarumbrales() {

        setUmbral(new double[ncapas][maxnneuronas]);

        //Inicializamos los umbrales a 0.1 para empezar
        for (int i = 0; i < getUmbral().length; i++) {
            for (int j = 0; j < getUmbral()[i].length; j++) {
                getUmbral()[i][j] = 0.1;
            }
        }
    }

    /**
     * @return the pesos
     */
    public double[][][] getPesos() {
        return pesos;
    }

    /**
     * @param pesos the pesos to set
     */
    public void setPesos(double[][][] pesos) {
        this.pesos = pesos;
    }

    /**
     * @return the umbral
     */
    public double[][] getUmbral() {
        return umbral;
    }

    /**
     * @param umbral the umbral to set
     */
    public void setUmbral(double[][] umbral) {
        this.umbral = umbral;
    }
}
