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
public class Cuadrado {

    public static void main(String[] args) {
        Scanner scIn = new Scanner(System.in);
        int Dimension;
        

        do {
            System.out.println("Introduce la dimension del cuadrado");
            Dimension = scIn.nextInt();

        } while (Dimension < 1);
        

        for (int h = 0; h < Dimension; h++) {
            for (int b = 0; b < Dimension; b++) {
                System.out.print("*");
            }

            System.out.print("\n");
        }
    }
}
