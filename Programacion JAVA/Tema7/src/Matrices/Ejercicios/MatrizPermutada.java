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
        switch (solicitarOpcion()) {
            case 0:
                System.out.println("Saliendo...");
                break;
            case 1:
                permutarFilas(matriz);
                break;
        
            case 2:
                permutarColumnas(matriz);
                break;
        
        
            case 3:
                System.out.println("Matriz resultante:");
                printMatrix(matriz);
                break;
        
            default:
                System.out.println("Opcion no valida");
                break;
        };

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
        scIn.close();
        return dimension;
    }

    private static int solicitarOpcion() {
        int opt = -1;
        Scanner scIn = new Scanner(System.in);
        System.out.print("\033[2J\033[H");

        do {
            showMenu();
            try {
                System.out.println("Introduce la opcion (0...3)");
                opt = scIn.nextInt();
            } catch (Exception e) {
                System.err.println("Debes seleccionar una opcion valida");
                scIn.nextLine();

            }

        } while (opt <= 1);
        scIn.close();
        return opt;
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
    private Integer[] solicitarMatrizIntegers() {

        Scanner scIn = new Scanner(System.in);
        int longitudVector=solicitarDimension();
        Integer vector[]=new Integer[longitudVector];
        return vector;

    }
     

     private static void permutarFilas(Integer[][] matriz) {
            Scanner scIn = new Scanner(System.in);
            System.out.println("Introduce el número de la primera fila (0-" + (matriz.length - 1) + "):");
            int fila1 = scIn.nextInt();
            System.out.println("Introduce el número de la segunda fila (0-" + (matriz.length - 1) + "):");
            int fila2 = scIn.nextInt();
            
            if (fila1 >= 0 && fila1 < matriz.length && fila2 >= 0 && fila2 < matriz.length) {
                Integer[] temp = matriz[fila1];
                matriz[fila1] = matriz[fila2];
                matriz[fila2] = temp;
                System.out.println("Filas permutadas correctamente");
            } else {
                System.out.println("Índices de fila inválidos");
            }
        }
     private static void permutarColumnas(Integer[][] matriz) {
            Scanner scIn = new Scanner(System.in);
            System.out.println("Introduce el número de la primera columna (0-" + (matriz[0].length - 1) + "):");
            int col1 = scIn.nextInt();
            System.out.println("Introduce el número de la segunda columna (0-" + (matriz[0].length - 1) + "):");
            int col2 = scIn.nextInt();
            
            if (col1 >= 0 && col1 < matriz[0].length && col2 >= 0 && col2 < matriz[0].length) {
                for (int i = 0; i < matriz.length; i++) {
                    Integer temp = matriz[i][col1];
                    matriz[i][col1] = matriz[i][col2];
                    matriz[i][col2] = temp;
                }
                System.out.println("Columnas permutadas correctamente");
            } else {
                System.out.println("Índices de columna inválidos");
            }
        }
}
