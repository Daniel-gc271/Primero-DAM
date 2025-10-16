/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicios;

import java.util.Scanner;

/**
 *
 * @author Daniel González
 */
public class Binario {

    public static void main(String[] args) {
        Scanner scIn = new Scanner(System.in);
        byte num = 0;
        int i = 2;
        while ( i > -1) {
            System.out.println("Introduce una cifra en binario");
            int input = scIn.nextInt();
            switch (input) {
                case 0 ->
                    num += 0;

                case 1 ->
                    num += Math.pow(2, i);
                default -> {
                    System.err.println("Introduce o 0 o 1");
                    System.exit(1);
                }
               
            }
            i--;
        } System.out.println("El valor es: "+num);
    }
}
