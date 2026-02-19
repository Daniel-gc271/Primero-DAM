/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Matrices.Ejercicios;

import java.util.Random;

/**
 *
 * @author goncalda
 */
public class Matriz1DanielGonzalez {

    public static void main(String[] args) {
        Random rd = new Random();
        Integer matrizPar[][] = new Integer[5][5];
        for (int i = 0; i < matrizPar.length; i++) {
            for (int j = 0; j < matrizPar[0].length; j++) {
                if (i % 2 == 0) {
                    matrizPar[i][j] = 2 * rd.nextInt(0, 2048);
                } else {
                    matrizPar[i][j] = 2 * rd.nextInt(0, 2048) + 1;
                }

            }
        }
        printMatrix(matrizPar);
    }

    private static void printMatrix(Object[][] array2d) {
        //filas eje y
        for (int i = 0; i < array2d.length; i++) {
            //columnas eje x
            for (int j = 0; j < array2d[0].length; j++) {
                System.out.print(array2d[i][j] + "\t");

            }
            System.out.println("");
        }

    }
}
