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
public class Vocales {
    public static void main(String[] args) {
        Scanner scIn = new Scanner(System.in);
        // char caracter = scIn.nextLine().charAt(0); evitar comparaciones extra
char caracter = scIn.nextLine().toLowerCase().charAt(0);
        if (caracter == 'a' || caracter == 'e' || caracter == 'i' || caracter == 'o' || caracter == 'u'
                || caracter == 'A' || caracter == 'E' || caracter == 'I'
                || caracter == 'O' || caracter == 'U')
        {
            System.out.printf("La letra %s es vocal\n", caracter);
        }   
          else {
                System.out.printf("La letra %s no es vocal\n", caracter);
                }
    }
}
