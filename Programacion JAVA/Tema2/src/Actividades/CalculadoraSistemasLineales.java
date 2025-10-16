package Actividades;

import java.util.Scanner;

public class CalculadoraSistemasLineales {

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

    // Método principal para calcular el determinante
    public static float calcularDeterminante(float[][] matriz) {
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
            float[][] submatriz = crearSubmatriz(matriz, i);

            // Aplicar recursión y sumar al determinante
            int signo = 1 - ((i & 1) << 1);

            determinante += signo * matriz[0][i] * calcularDeterminante(submatriz);
            System.out.println("Submatriz #" + i);
            System.out.println("coeficiente del cofactor: " + (signo * matriz[0][i]));
            imprimirMatriz(submatriz);
        }
        return determinante;
    }

    // Método para crear una submatriz excluyendo la primera fila y una columna específica
    private static float[][] crearSubmatriz(float[][] matriz, int columnaExcluida) {
        int n = matriz.length;
        float[][] submatriz = new float[n - 1][n - 1];

        for (int i = 1; i < n; i++) {
            int subColumna = 0;
            for (int j = 0; j < n; j++) {
                if (j == columnaExcluida) {
                    continue;
                }
                
                submatriz[i - 1][subColumna++] = matriz[i][j];
            }
        }

        return submatriz;
    }

    private static float[][] replaceCol(float[][] matrix, float[] indepTerms, int colIndex) {
        int orden = matrix.length;
        float[][] newMatrix = new float[orden][orden];

        for (int fila = 0; fila < orden; fila++) {
            for (int columna = 0; columna < orden; columna++) {
                newMatrix[fila][columna] = (columna == colIndex) ? indepTerms[fila] : matrix[fila][columna];
            }
        }

        return newMatrix;
    }

    private static float[] aplicarCramer(float[][] matrix, float[] indepTerms, float determinante) {
        int solNum = indepTerms.length;
        float[] soluciones = new float[solNum];
        for (int i = 0; i < solNum; i++) {
            float[][] rplMatrix;

            rplMatrix = replaceCol(matrix, indepTerms, i);
            //System.out.println("Matriz reemplazada #"+i);
            //imprimirMatriz(rplMatrix);
            if (calcularDeterminante(rplMatrix) / determinante == 0) {
                soluciones[i] = 0;
            } else {
                soluciones[i] = calcularDeterminante(rplMatrix) / determinante;

            }
        }
        return soluciones;

    }

    private static void resolverSistema(float matrizPrincipal[][], float[] vectorIndependiente) {

        System.out.println("Matriz principal");
        imprimirMatriz(matrizPrincipal);
        float determinante = calcularDeterminante(matrizPrincipal);

        if (determinante == 0) {
            System.out.println("El determinante es 0 por ende el sistema no tiene soluciones reales");
        } else {
            System.out.println("El determinante es: " + determinante);
            System.out.println("\nVector de términos independientes:");
            imprimirVector(vectorIndependiente);
//            System.out.println("Soluciones:");
            float[] soluciones = aplicarCramer(matrizPrincipal, vectorIndependiente, determinante);
            imprimirVector(soluciones);
            System.out.println("");

        }

    }

    // Método principal para probar el cálculo
    public static void main(String[] args) {

        Scanner scIn = new Scanner(System.in);
        System.out.print("\nIntroduce el número de incógnitas: ");
        int orden = scIn.nextInt();
        float matrizPrincipal[][] = getMatrix(orden, scIn);
        System.out.println("Matriz principal");
        imprimirMatriz(matrizPrincipal);
        float determinante = calcularDeterminante(matrizPrincipal);

        if (determinante == 0) {
            System.out.println("El determinante es 0 por ende el sistema no tiene soluciones reales");
        } else {
            System.out.println("El determinante es: " + determinante);
            float[] vectorIndependiente = getIndepTerms(orden, scIn);
            System.out.println("\nVector de términos independientes:");
            imprimirVector(vectorIndependiente);
            System.out.println("Soluciones:");
            float[] soluciones = aplicarCramer(matrizPrincipal, vectorIndependiente, determinante);
            imprimirVector(soluciones);
            System.out.println("");
            scIn.close();
            }
         
    }
}
