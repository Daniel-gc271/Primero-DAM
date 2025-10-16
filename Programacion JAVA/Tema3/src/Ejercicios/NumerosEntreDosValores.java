/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicios;

import java.util.Scanner;

public class NumerosEntreDosValores {

    public static void main(String[] args) {
        Scanner scIn = new Scanner(System.in);

        System.out.print("Introduce numero1: ");
        int numA = scIn.nextInt();

        System.out.print("Introduce numero2: ");
        int numB = scIn.nextInt();
int i = numA;
        if (numA != numB) {
            if (numA <= numB) {
                while (i <= numB) {
                    System.out.print(i + " ");
                    i++;
                }
            } else {
                while (i >= numB ) {
                    System.out.print(i + " ");
                    i--;
                }
            }

        } else {
            System.out.println("No hay numeros entre dos numeros iguales");
        }
        System.out.println();
    }
}
