/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cacharreo;

/**
 *
 * @author Daniel González
 */
public class GeneradorLaberintos {
    public static void main(String[] args) {
        int grado = 4;
        int numFilas = grado*grado+1, numColumnas= grado*grado+1;
        int[][] laberinto=new int [numFilas][numColumnas];
        for (int i = 0; i < numFilas; i++) {
            for (int j = 0; j < numColumnas; j++) {
                if ((i>1)&&(i<numFilas)&&(i%2==0)&&j!=0&&j<numColumnas-1)
                {
                laberinto[i-1][j]=1;
                if (j==numColumnas-2&&i<numColumnas-1) {laberinto[i][j]=1;}
                }
            }
        }
        laberinto[numFilas-2][numColumnas-2]=3;
        imprimirMatriz(laberinto);
    }
    private static void imprimirMatriz(int[][] matrix) {
        int numFilas = matrix.length;
        int numColumnas = matrix[0].length;
        for (int i = 0; i < numFilas; i++) {
            for (int j = 0; j < numColumnas; j++) {
                System.out.printf(" %d", matrix[i][j]);
            }
            System.out.println("");
        }
    }
}
