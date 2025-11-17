/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cacharreo;

import java.util.Random;

/**
 *
 * @author Daniel González
 */
public class GeneradorLaberintos {

    

    private static char[][] randomizarLaberinto(char[][] laberinto, int iteraciones, Random numAleatorio) {
        int oI = 0, oJ = 0, contIteraciones = 0, mov = 0;
        while (contIteraciones <= iteraciones) {
            for (int i = 0; i < laberinto.length; i++) {
                for (int j = 0; j < laberinto[0].length; j++) {
                    if (laberinto[i][j] == 'O') {
                        oI = i;
                        oJ = j;
                        break;
                    }
                }
            }
            mov = numAleatorio.nextInt(4);
            if (oJ - 1 >= 0 && mov == 0) {
                laberinto[oI][oJ] = 'A';
                laberinto[oI][oJ - 1] = 'O';
                contIteraciones++;
            }
            if (oJ + 1 < laberinto[0].length && mov == 1) {
                laberinto[oI][oJ + 1] = 'O';
                laberinto[oI][oJ] = 'D';
                contIteraciones++;
            }
            if (oI - 1 >= 0 && mov == 2) {
                laberinto[oI][oJ] = 'W';
                laberinto[oI - 1][oJ] = 'O';
                contIteraciones++;
            }
            if (oI + 1 < laberinto[0].length && mov == 3) {
                laberinto[oI + 1][oJ] = 'O';
                laberinto[oI][oJ] = 'S';
                contIteraciones++;
            }
        }
        return laberinto;
    }

    private static char[][] generarLaberinto(int grado) {
        char[][] vectoresUnidos = new char[grado][grado];
        for (int i = 0; i < vectoresUnidos.length; i++) {
            for (int j = 0; j < vectoresUnidos[0].length; j++) {
                if (j != vectoresUnidos[0].length - 1) {
                    vectoresUnidos[i][j] = 'D';
                }
                if (j == vectoresUnidos.length - 1) {
                    vectoresUnidos[i][j] = 'S';
                }
            }
        }
        vectoresUnidos[vectoresUnidos.length - 1][vectoresUnidos[0].length - 1] = 'O';
        return vectoresUnidos;
    }
    private static void imprimirMatriz(char[][] matrix) {
        int numFilas = matrix.length;
        int numColumnas = matrix[0].length;
        for (int i = 0; i < numFilas; i++) {
            for (int j = 0; j < numColumnas; j++) {
                System.out.printf(" %s", matrix[i][j]);
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        Random numAleatorio = new Random();
        char[][] laberinto = generarLaberinto(16);
        laberinto = randomizarLaberinto(laberinto, 4092, numAleatorio);
        imprimirMatriz(laberinto);

    }

}
