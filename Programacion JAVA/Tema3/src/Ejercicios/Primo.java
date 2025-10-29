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
public class Primo {

    public static void main(String[] args) {
        Scanner scIn = new Scanner(System.in);
        System.out.println("Introduce el numero a comprobar si es primo");
        int vecesdividido = 0;
        int primo = scIn.nextInt();
        if (primo <= 1) {
            System.exit(1);
            System.err.println("Los numeros primos deben ser mayores a uno");
            
        }
        int i = 1;
        do {
            //System.out.printf("(%d MOD %d)= %d", primo, i, (primo % i));
            if (primo % i == 0) {
                vecesdividido++;
            }
            i++;
        } while (i <= (primo) && vecesdividido <= 2);
        if (vecesdividido > 2) {
            System.out.println("No es primo");
        } else {
            System.out.println("Si es primo");
        }

    }
}
