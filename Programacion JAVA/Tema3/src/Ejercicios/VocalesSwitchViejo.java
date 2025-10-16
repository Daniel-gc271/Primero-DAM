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
public class VocalesSwitchViejo {

    public static void main(String[] args) {
        Scanner scIn = new Scanner(System.in);
        System.out.println("Introduce un caracter para saber si es una vocal");
        char caracter = scIn.nextLine().charAt(0);
        char minuscula = Character.toLowerCase(caracter);
        scIn.close();
        switch (minuscula) {
            case 97: {
                System.out.printf("%s es vocal\n", caracter);
                break;
            }
            case 101: {
                System.out.printf("%s es vocal\n", caracter);
                break;
            }
            case 105: {
                System.out.printf("%s es vocal\n", caracter);
                break;
            }
            case 111: {
                System.out.printf("%s es vocal\n", caracter);
                break;
            }
            case 117: {
                System.out.printf("%s es vocal\n", caracter);
                break;
            }
            default: {
                System.err.printf("%s no es vocal\n", caracter);
                break;
            }

        }

    }
}
