/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cacharreo;

import java.util.Scanner;

public class Cacharreo {

    private static float calcularDeterminante(float[][] matriz) {
        int n = matriz.length;

        // Caso base: si la matriz es de 1x1
        if (n == 1) {
            return matriz[0][0];

        }
        // Caso base: si la matriz es de 2x2
        if (n == 2) {
            return (matriz[0][0] * matriz[1][1]) - (matriz[0][1] * matriz[1][0]);
        }
        // Caso general: matriz de tamaño NxN
        float determinante = 0;
        for (int i = 0; i < n; i++) {
            // Crear submatriz excluyendo la primera fila y la columna i
            float[][] submatriz = crearSubmatriz(matriz, 0, i);

            // Aplicar recursión y sumar al determinante
            int signo = 1 - ((i & 1) << 1);

            determinante += signo * matriz[0][i] * calcularDeterminante(submatriz);
        }
        return determinante;
    }

    private static float[][] crearSubmatriz(float[][] matriz, int filaExcluida, int columnaExcluida) {

        int ordenSubmatriz = matriz.length;
        float[][] submatriz = new float[ordenSubmatriz - 1][ordenSubmatriz - 1];

        int subFila = 0;
        for (int i = 0; i < ordenSubmatriz; i++) {
            if (i == filaExcluida) {
                continue;
            }

            int subColumna = 0;
            for (int j = 0; j < ordenSubmatriz; j++) {
                if (j == columnaExcluida) {
                    continue;
                }

                submatriz[subFila][subColumna++] = matriz[i][j];
            }
            subFila++;
        }

        return submatriz;

    }

    private static float[][] getMatrix(int orden, Scanner input) {
        float[][] coeficientes = new float[orden][orden];
        System.out.println("\nIntroduce los coeficientes que acompañan a las incógnitas:");

        for (int fila = 0; fila < orden; fila++) {
            for (int columna = 0; columna < orden; columna++) {
                System.out.printf("Elemento (%d, %d): ", fila + 1, columna + 1);
                coeficientes[fila][columna] = input.nextFloat();
            }
        }
        return coeficientes;
    }

    private static float[] getIndepTerms(int orden, Scanner input) {
        float[] indepTerms = new float[orden];
        System.out.println("\nIntroduce los términos independientes:");

        for (int fila = 0; fila < orden; fila++) {
            System.out.printf("Término de la ecuación %d: ", fila + 1);
            indepTerms[fila] = input.nextFloat();
        }

        return indepTerms;
    }

    private static void imprimirVector(float[] vector) {
        System.out.print("(");
        for (int i = 0; i < vector.length; i++) {
            System.out.printf("%f", vector[i]);
            if (i < vector.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println(")");
    }

    private static float[] aplicarCramer(float[][] matrix, float[] indepTerms, float determinante) {
        int solNum = indepTerms.length;
        float[] soluciones = new float[solNum];
        for (int i = 0; i < solNum; i++) {
            float[][] rplMatrix;
            rplMatrix = replaceCol(matrix, indepTerms, i);
            if (calcularDeterminante(rplMatrix) / determinante == 0) {
                soluciones[i] = 0;
            } else {
                soluciones[i] = calcularDeterminante(rplMatrix) / determinante;

            }
        }
        return soluciones;

    }

    private static void imprimirMatriz(float[][] matrix) {
        for (float[] fila : matrix) {
            for (float valor : fila) {
                System.out.printf("%f ", valor);
            }
            System.out.println();
        }
    }

    private static float[][] replaceCol(float[][] matrix, float[] indepTerms, int colIndex) {
        int orden = matrix.length;
        float[][] matrizReemplazada = new float[orden][orden];

        for (int fila = 0; fila < orden; fila++) {
            for (int columna = 0; columna < orden; columna++) {
                matrizReemplazada[fila][columna] = (columna == colIndex) ? indepTerms[fila] : matrix[fila][columna];
            }
        }

        return matrizReemplazada;
    }

    private static int evaluarRango(float[][] matriz) {
        int rango = matriz.length;
        int ordenMatriz = matriz.length;
        if (calcularDeterminante(matriz) == 0) {
            for (int j = 0; j < ordenMatriz; j++) {
                for (int k = 0; k < ordenMatriz; k++) {
                    float[][] submatriz = crearSubmatriz(matriz, j, k);
                    imprimirMatriz(submatriz);
                    System.out.println(calcularDeterminante(submatriz));
                    if (calcularDeterminante(submatriz) != 0) {
                        return (ordenMatriz - 1);
                    } else {
                        return evaluarRango(submatriz);
                    }
                }
            }
        }
        return ordenMatriz;
    }

    private static float[][] calcularAdjunta(float matriz[][]) {
        int ordenMatriz = matriz.length;
        float[][] matrizAdjunta = new float[ordenMatriz][ordenMatriz];
        for (int j = 0; j < ordenMatriz; j++) {
            for (int k = 0; k < ordenMatriz; k++) {
                int signo = 1 - (((j + k) & 1) << 1);
                matrizAdjunta[j][k] = signo * calcularDeterminante(crearSubmatriz(matriz, j, k));
            }
        }
        return matrizAdjunta;
    }

    private static float[][] calcularInversa(float[][] matriz) {
        int ordenMatriz = matriz.length;
        float detMatriz = calcularDeterminante(matriz);
        float[][] adjT = new float[ordenMatriz][ordenMatriz];
        float[][] matrizInversa = new float[ordenMatriz][ordenMatriz];
        adjT = calcularTraspuesta(calcularAdjunta(matriz));
        for (int j = 0; j < ordenMatriz; j++) {
            for (int k = 0; k < ordenMatriz; k++) {
                matrizInversa[j][k] = (float) adjT[j][k] / detMatriz;
            }
        }
        return matrizInversa;
    }

    private static float[][] calcularTraspuesta(float matriz[][]) {
        int ordenMatriz = matriz.length;
        float[][] matrizTraspuesta = new float[ordenMatriz][ordenMatriz];
        for (int j = 0; j < ordenMatriz; j++) {
            for (int k = 0; k < ordenMatriz; k++) {
                matrizTraspuesta[j][k] = matriz[k][j];
            }
        }
        return matrizTraspuesta;
    }

    public static void main(String[] args) {
        // TODO code application logic here
        float[][] matriz = {
            {1, -1, 2},
            {2, 1, 3},
            {1, 1, 1},};

        //Scanner input = new Scanner(System.in);
        imprimirMatriz(matriz);
        System.out.println("\nRango de la matriz");
        System.out.print(evaluarRango(matriz));

        System.out.println("\nMatriz adjunta:");
        float[][] adjunta = calcularAdjunta(matriz);
        imprimirMatriz(adjunta);

        System.out.println("\nMatriz transpuesta:");
        float[][] transpuesta = calcularTraspuesta(matriz);
        imprimirMatriz(transpuesta);

        System.out.println("\nMatriz inversa:");
        float[][] inversa = calcularInversa(matriz);
        imprimirMatriz(inversa);

        System.out.println("");
    }
}
