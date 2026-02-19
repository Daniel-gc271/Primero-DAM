/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Matrices.Ejercicios;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author goncalda
 */
public class MatrizPermutada {

    public static void main(String[] args) {
        System.out.println("Introduce el numero de filas de la matriz");
        int numFilas = solicitarDimension();
        System.out.println("Introduce el numero de columnas de la matriz");
        int numColumnas = solicitarDimension();
        Integer matriz[][] = new Integer[numFilas][numColumnas];
        Random rd = new Random();

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                matriz[i][j] = 2 * rd.nextInt(0, 256);

            }
        }
        System.out.println("Matriz original:");
        printMatrix(matriz);
        solicitarOpcion();

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

    private static int solicitarDimension() {
        int dimension = 0;
        Scanner scIn = new Scanner(System.in);
        do {
            System.out.print("\033[2J\033[H");
            try {
                System.out.println("Introduce la dimension, debe ser mayor a uno");
                dimension = scIn.nextInt();
            } catch (Exception e) {
                System.err.println("Debes introducir un numero entero");
                scIn.nextLine();
            }

        } while (dimension <= 1);
        return dimension;
    }

    private static int solicitarOpcion() {
        int dimension = -1;
        Scanner scIn = new Scanner(System.in);
        System.out.print("\033[2J\033[H");

        do {
            showMenu();
            try {
                System.out.println("Introduce la opcion (0...3)");
                dimension = scIn.nextInt();
            } catch (Exception e) {
                System.err.println("Debes seleccionar una opcion valida");
                scIn.nextLine();

            }

        } while (dimension <= 1);
        return dimension;
    }

    private static void showMenu() {
        System.out.println("""
                           Selecciona una opcion
                           0.Salir
                           1.Permutar filas
                           2.Permutar columnas
                           3.Mostrar matriz
                           """);

    }
}
