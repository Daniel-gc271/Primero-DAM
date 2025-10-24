/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejemplos;

import java.util.Scanner;

/**
 *
 * @author goncalda
 * programa que arroja a la consola una serie de asteriscos en fila
 */
public class Asteriscos {
    public static void main(String[] args) {
        Scanner scIn = new Scanner(System.in);
        System.out.println("Introduce el numero de asteriscos a pintar");
        int asteriscos = scIn.nextInt();
        scIn.close();
        int i=0;
        System.out.println("while");
        while (i <asteriscos) {
            System.out.print("*");
            i++;
        }
        System.out.println("\nDo while");
        i=0;
        do { {System.out.print("*");
            i++;} }while (i <asteriscos);
        System.out.println("");
    }
    
}
