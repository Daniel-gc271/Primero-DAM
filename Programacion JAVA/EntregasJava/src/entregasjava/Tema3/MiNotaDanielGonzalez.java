/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entregasjava.Tema3;

import java.util.Scanner;

/**
 *
 * @author goncalda
 */
public class MiNotaDanielGonzalez {

    public static void main(String[] args) {
        Scanner scIn = new Scanner(System.in);
        int[] notas = new int[4];
        float media = 0;
        int i = 0;
        do {
            System.out.println("Introduce una nota");
            notas[i] = scIn.nextInt();
            while (notas[i] < 0 || notas[i] > 100) {
                System.err.println("Debes introducir una nota entre 0 y 100!");
                notas[i] = scIn.nextInt();
            }
            media += notas[i];
            i++;
        } while (i < 4);
        scIn.close();
        for (int j = 0; j < notas.length; j++) {
            int notaActual = notas[j];
            String calificacion = "";
            if (notaActual >= 0 && notaActual <= 59) {
                calificacion = "E";
            } else if (notaActual >= 60 && notaActual <= 69) {
                calificacion = "D";
            } else if (notaActual >= 70 && notaActual <= 79) {
                calificacion = "C";
            } else if (notaActual >= 80 && notaActual <= 89) {
                calificacion = "B";
            } else if (notaActual >= 90 && notaActual <= 100) {
                calificacion = "A";
            }
            System.out.printf("\nLa nota %d coresponde a %s", notaActual, calificacion);
        }
        media /= notas.length;
        System.out.printf("\nLa nota media es: %f\n", media);
        scIn.close();

    }
}
