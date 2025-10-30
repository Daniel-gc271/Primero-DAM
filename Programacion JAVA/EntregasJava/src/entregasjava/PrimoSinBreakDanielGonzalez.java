/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entregasjava;

import java.util.Scanner;

/**
 *
 * @author goncalda
 */
public class PrimoSinBreakDanielGonzalez {

    public static void main(String[] args) {
        Scanner scIn = new Scanner(System.in);
        System.out.println("Introduce el numero a comprobar si es primo");
        boolean esprimo = true;
        int primo = scIn.nextInt();
        if (primo <= 1) {
            System.exit(1);
            System.err.println("Los numeros primos deben ser mayores a uno");

        }
        int i = 2;
        do {
            esprimo=(primo%i != 0);
            i++;
        } while (i < primo/2&&esprimo);
        System.out.printf("El numero %d%s es primo %n",primo,(esprimo?"":" no") );

       

    }
}
