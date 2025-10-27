/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cacharreo;

import java.util.Scanner;

/**
 *
 * @author goncalda
 *
 *
 */
public class SubmatrizEjemplo {

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
            System.out.println("Submatriz #" + i);
            System.out.println("coeficiente del cofactor: " + (signo * matriz[0][i]));

        }
        return determinante;
    }

    // Método para crear una submatriz excluyendo la primera fila y una columna específica
    private static float[][] crearSubmatriz(float[][] matriz, int filaExcluida, int columnaExcluida) {
        
        
 int n = matriz.length;
    float[][] submatriz = new float[n - 1][n - 1];

    int subFila = 0;
    for (int i = 0; i < n; i++) {
        if (i == filaExcluida) {
            continue;
        }

        int subColumna = 0;
        for (int j = 0; j < n; j++) {
            if (j == columnaExcluida) {
                continue;
            }

            submatriz[subFila][subColumna++] = matriz[i][j];
        }
        subFila++;
    }

    return submatriz;

    }

    private static float[][] calcularAdjunta(float matriz[][]) {
        int ordenMatriz = matriz.length;
        float[][] matrizAdjunta = new float[ordenMatriz][ordenMatriz];
        for (int j = 0; j < ordenMatriz; j++) {
            for (int k = 0; k < ordenMatriz; k++) {
               float[][] submatriz = crearSubmatriz(matriz, j, k);
                System.out.println("submatriz");
                imprimirMatriz(submatriz);
                matrizAdjunta[j][k] = calcularDeterminante( crearSubmatriz(submatriz,j,k));
            }
        }
        return matrizAdjunta;
    }

    private static float[][] transponerMatriz(float matriz[][]) {
        int ordenMatriz = matriz.length;
        float[][] matrizTraspuesta = new float[ordenMatriz][ordenMatriz];
        for (int j = 0; j < ordenMatriz; j++) {
            for (int k = 0; k < ordenMatriz; k++) {
                matrizTraspuesta[j][k] = matriz[k][j];
            }
        }
        return matrizTraspuesta;
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

    private static void imprimirMatriz(float[][] matrix) {
        for (float[] fila : matrix) {
            for (float valor : fila) {
                System.out.printf("%f ", valor);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        float[][] matriz = {
            {1.0f, 2.0f, 3.0f},
            {4.0f, 5.0f, 6.0f},
            {7.0f, 8.0f, 9.0f}
        };

        Scanner input = new Scanner(System.in);
        imprimirMatriz(matriz);
        imprimirMatriz(crearSubmatriz(matriz, , 0));

        System.out.println("\nMatriz adjunta:");
        float[][] adjunta = calcularAdjunta(matriz);
        imprimirMatriz(adjunta);

        System.out.println("\nMatriz transpuesta:");
        float[][] transpuesta = transponerMatriz(matriz);
        imprimirMatriz(transpuesta);
        
        System.out.println("");
    }
}
