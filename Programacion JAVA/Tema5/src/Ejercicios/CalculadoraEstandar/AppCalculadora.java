/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicios.CalculadoraEstandar;

import java.util.InputMismatchException;
import java.util.Scanner;
import Ejercicios.CalculadoraEstandar.UtilidadesCalculadora;
/**
 *
 * @author goncalda
 */
public class AppCalculadora {

    private static void showOpSelMenu() {
        String menu = "0. Salir\n" + "1. Suma\n" + "2. Resta\n" + "3. Producto\n" + "4. Cociente\n" + "5. Modulo\n";
        System.out.print(menu);
    }

    private static int validarSeleccionOperacion(Scanner scIn) {

        int seleccion;
        try {
            do {
                System.out.println("Selecciona del menu la operacion a realizar");
                showOpSelMenu();
                System.out.print(">>");
                seleccion = scIn.nextInt();
                if (seleccion > 7 || seleccion < 0) {
                    showOpSelMenu();
                }
            } while (seleccion > 7 || seleccion < 0);

            return seleccion;
        } catch (InputMismatchException e) {
            System.err.println("Debes introducir un valor numerico");
            scIn.nextLine(); //Quitar el "enter" del buffer
            seleccion = validarSeleccionOperacion(scIn);
            return seleccion;
        }

    }

    private static double validarEntradaNumerica(Scanner scIn) {
        double entrada;
        try {
            System.out.println("Introduce un valor numérico");
            System.out.print(">>");
            entrada = scIn.nextDouble();

            return entrada;
        } catch (InputMismatchException e) {
            System.err.println("Debes introducir un valor numerico");
            scIn.nextLine(); //Quitar el "enter" del buffer
            entrada = validarEntradaNumerica(scIn);
            return entrada;
        }

    }

    public static void main(String[] args) {
        Scanner scIn = new Scanner(System.in);
        int opSeleccionada;
        do {
            opSeleccionada = validarSeleccionOperacion(scIn);
            switch (opSeleccionada) {
                case 0 -> {
                }
                case 1 -> {
                    double numA = validarEntradaNumerica(scIn);
                    double numB = validarEntradaNumerica(scIn);
                    System.out.println(UtilidadesCalculadora.suma(numA, numB));
                }
                case 2 -> {
                    double numA = validarEntradaNumerica(scIn);
                    double numB = validarEntradaNumerica(scIn);
                    System.out.println(UtilidadesCalculadora.resta(numA, numB));
                }
                case 3 -> {
                    double numA = validarEntradaNumerica(scIn);
                    double numB = validarEntradaNumerica(scIn);
                    System.out.println(UtilidadesCalculadora.prod(numA, numB));
                }
                case 4 -> {
                    double numA = validarEntradaNumerica(scIn);
                    double numB = validarEntradaNumerica(scIn);
                    System.out.println(UtilidadesCalculadora.qoc(numA, numB));
                }
                case 5 -> {
                    double numA = validarEntradaNumerica(scIn);
                    double numB = validarEntradaNumerica(scIn);
                    System.out.println(UtilidadesCalculadora.mod(numA, numB));
                }
                

            }

        } while (opSeleccionada != 0);
        System.out.println(">> Saliendo");
    }
}
