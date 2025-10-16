/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicios;

import java.util.Scanner;

/**
 *
 * @author goncalda
 */
public class Notas {

    public static void main(String[] args) {
        Scanner scIn = new Scanner(System.in);
        System.out.println("Introduce una nota para conocer tu calificacion correspondiente");
        int entrada = scIn.nextInt();
        scIn.close();

        if ((entrada < 0) || (entrada > 10)) {
            System.out.printf("%d es un valor inválido\n", entrada);
        } else if ((entrada >= 0) && (entrada <= 2)) {
            System.out.printf("%d corresponde a MD\n", entrada);
        } else if ((entrada >= 3) && (entrada <= 4)) {
            System.out.printf("%d corresponde a I\n", entrada);
        } else if (entrada == 5) {
            System.out.printf("%d corresponde a S\n", entrada);
        } else if (entrada == 6) {
            System.out.printf("%d corresponde a B\n", entrada);
        } else if ((entrada >= 7) && (entrada <= 8)) {
            System.out.printf("%d corresponde a N\n", entrada);
        } else if ((entrada >= 9) && (entrada <= 10)) {
            System.out.printf("%d corresponde a SB\n", entrada);
        }
        System.out.println("Con case switch");

        switch (entrada) {
            case 0 -> System.out.printf("%d corresponde a MD\n", entrada);
            case 1 -> System.out.printf("%d corresponde a MD\n", entrada);
            case 2 -> System.out.printf("%d corresponde a MD\n", entrada);
            case 3 -> System.out.printf("%d corresponde a I\n", entrada);
            case 4 -> System.out.printf("%d corresponde a I\n", entrada);
            case 5 -> System.out.printf("%d corresponde a S\n", entrada);
            case 6 -> System.out.printf("%d corresponde a B\n", entrada);
            case 7 -> System.out.printf("%d corresponde a N\n", entrada);
            case 8 -> System.out.printf("%d corresponde a N\n", entrada);
            case 9 -> System.out.printf("%d corresponde a SB\n", entrada);
            case 10 -> System.out.printf("%d corresponde a SB\n", entrada);
            default -> System.out.printf("%d es un valor inválido\n", entrada);
        }

    }

}

