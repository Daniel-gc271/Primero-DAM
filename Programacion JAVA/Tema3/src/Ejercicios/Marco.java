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
public class Marco {

    public static void main(String[] args) {
        
        Scanner scIn = new Scanner(System.in);
        int Altura;
        int Anchura;

        do {
            System.out.println("Introduce la altura del marco");
            Altura = scIn.nextInt();

        } while (Altura < 2);
        do {
            System.out.println("Introduce la anchura del marco");
            Anchura = scIn.nextInt();

        } while (Anchura <2);

        for (int h = 0; h < Altura; h++) {
            for (int b = 0; b < Anchura; b++) {
                if (h==0||h==Altura-1||b==0||b==Anchura-1) {
                       System.out.print("%");    
                   } else {System.out.print(" ");} 
            }

            System.out.print("\n");
        }

        
    }

}
