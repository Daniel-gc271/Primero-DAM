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
public class Rectangulo {

    public static void main(String[] args) {
        Scanner scIn = new Scanner(System.in);
        int Altura = 3;
        int Anchura = 5;

        do {
            System.out.println("Introduce la altura del rectángulo");
            Altura = scIn.nextInt();

        } while (Altura < 1);
        do {
            System.out.println("Introduce la anchura del rectángulo");
            Anchura = scIn.nextInt();

        } while (Anchura < 1);

        for (int h = 0; h < Altura; h++) {
            for (int b = 0; b < Anchura; b++) {
                System.out.print("*");
            }

            System.out.print("\n");
        }
    }
}
