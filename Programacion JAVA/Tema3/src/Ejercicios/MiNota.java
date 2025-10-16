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
public class MiNota {

    public static void main(String[] args) {
        Scanner scIn = new Scanner(System.in);
        float media = 0;
        int[] nota = new int[5];
        for (int i = 0; i < 5; i++) {
            System.out.printf("Introduce la nota #%d",i);
            nota[i] = scIn.nextInt();
            System.out.println(nota[i]);
            media += nota[i];
            System.out.printf("Nota #%d",i);
            if ((nota[i] >= 90) && (nota[i] <= 100)) {
                System.out.println("Calificacion: A");
            } else {
                if ((nota[i] >= 80) && (nota[i] <= 89)) {
                    System.out.println("Calificacion: A");

                } else {
                    if ((nota[i] >= 70) && (nota[i] <= 79)) {
                        System.out.println("Calificacion: A");

                    } else {
                        if ((nota[i] >= 60) && (nota[i] <= 69)) {
                            System.out.println("Calificacion: A");

                        } else {
                            if ((nota[i] >= 0) && (nota[i] <= 59)) {
                                System.out.println("Calificacion: A");

                            } else {
                                if ((nota[i] < 0) || (nota[i] > 100)) {System.err.println("Fuera de rango");
                                System.exit(1);
                                }
                            }

                        }
                        media /= 4.0;
                        System.out.printf("\nLa nota media es: ",media);
                    }
                }
            }}}}
