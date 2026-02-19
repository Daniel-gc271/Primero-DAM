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
public class Matriz1 {

    public static void main(String[] args) {
        Random rd = new Random();
        Integer[][] matrizParA = new Integer[5][5];
        for (int i = 0; i < matrizParA.length; i++) {
            for (int j = 0; j < matrizParA[0].length; j++) {
                if (i % 2 == 0) {
                    matrizParA[i][j] = 2 * rd.nextInt(0, 2048);
                } else {
                    matrizParA[i][j] = 3 * rd.nextInt(0, 2048);
                }

            }
        }
        Integer[][] matrizParB = new Integer[5][5];

        for (int i = 0; i < matrizParB.length; i++) {
            for (int j = 0; j < matrizParB[0].length; j++) {
                if (i % 2 == 0) {
                    matrizParB[i][j] = 2 * rd.nextInt(0, 2048);
                } else {
                    matrizParB[i][j] = 3 * rd.nextInt(0, 2048);
                }

            }
        }

        System.out.println("Mat A:");
        printMatrix(matrizParA);
        System.out.println("Mat B:");
        printMatrix(matrizParB);
        matrizParA = sumMatrix(matrizParA, matrizParB);
        System.out.println("Sumada");
        printMatrix(matrizParA);
        System.out.println("Diagonal:");
        diagonal(matrizParA);
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

    private static Integer[][] sumMatrix(Integer[][] array2dA, Integer[][] array2dB) {
        if (array2dA.length != array2dB.length || array2dA[0].length != array2dB[0].length) {
            throw new ArithmeticException("Para sumar las matrices deben tener las mismas dimensiones");
        } else {Integer matRes[][] = new Integer[array2dA.length][array2dA[0].length];
        //filas eje y
        for (int i = 0; i < array2dA.length; i++) {
            //columnas eje x
            for (int j = 0; j < array2dA[0].length; j++) {
                matRes[i][j] = array2dB[i][j] + array2dA[i][j];

            }

        } return matRes;}
        
        
    }
    private static void diagonal(Object[][] array2d) {
        for (int i = 0; i < array2d.length; i++) {
            for (int j = 0; j < array2d[0].length; j++) {
                String msg= (i==j)? String.valueOf(array2d[i][j]) : "";
                System.out.printf("%4s",msg);
            }
            System.out.println("");
        }
    
    }

}
