/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejemplos;

import java.util.Scanner;

/**
 *
 * @author goncalda programa que proponga al usuario de escribir frases hasta
 * que no quiera mas para ello entre frase y frase debera responder a la
 * pregunra ¿Introducir otra frase? (Si o No)
 */
public class banderas1 {

    private static boolean preguntar(Scanner scIn) {
        System.out.println("¿Introducir otra frase? (Si o No)");
        char entrada = scIn.nextLine().toUpperCase().charAt(0);
        if (entrada != 'S' && entrada != 'N') {
            System.err.println("Debes responder Si o No");
            return preguntar(scIn);
        }
        return entrada == 'S';
    }

    public static void main(String[] args) {
        boolean masFrases = true;
        Scanner scIn = new Scanner(System.in);
        while (masFrases) {
            System.out.println("Introduce una frase");
            String frase = scIn.nextLine();
            masFrases = preguntar(scIn);

        }
    }

}
