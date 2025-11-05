/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entregasjava.Tema2;

import java.util.Scanner;

/**
 *
 * @author goncalda
 */
public class SignoNumeroDanielGonzalez {

    public static void main(String[] args) {
        Scanner scIn = new Scanner(System.in);
        System.out.println("Introduce un numero para saber si es positivo negativo o nulo");
        int valor = scIn.nextInt();
        if (valor != 0) {
            if (valor > 0)  {
                System.out.printf("%d es positivo", valor);
            } else {
                System.out.printf("%d es negativo",valor);
            }
        } else {
            System.out.printf("%d es nulo", valor);
        }
        System.out.println("");
    }
}
