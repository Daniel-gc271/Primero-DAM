/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Ejercicios;

import java.util.Scanner;

/**
 *
 * @author Daniel González
 */
public class VocalesSwitch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scIn = new Scanner(System.in);
        System.out.println("Inserta un caracter");
        char letra = scIn.next().toLowerCase().charAt(0);
        scIn.close();
        System.out.print(letra);
        switch ((int) letra) {
            case 97 -> {
                System.out.println(" es vocal");
            }
            case 101 -> {
                System.out.println(" es vocal");
            }
            case 105 -> {
                System.out.println(" es vocal");
            }
            case 111 -> {
                System.out.println(" es vocal");
            }
            case 117 -> {
                System.out.println(" es vocal");
            }
            default -> {
                System.out.println(" no es vocal");
            }

        }

    }

}
