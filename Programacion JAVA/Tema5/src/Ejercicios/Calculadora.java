/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicios;

import java.util.Scanner;

/**
 *
 * @author macarena
 */
public class Calculadora {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("1. Sumar");
        System.out.println("2. Restar");
        System.out.println("3. Multiplicar");
        System.out.println("4. Dividir");
        System.out.print(">>");
        int opcion = sc.nextInt();

        System.out.println("Introduce el primer número:");
        double a = sc.nextDouble();
        System.out.println("Introduce el segundo número:");
        double b = sc.nextDouble();

        double resultado = 0;
        switch (opcion) {
            case 1 -> resultado = a + b;
            case 2 -> resultado = a - b;
            case 3 -> resultado = a * b;
            case 4 -> resultado = a / b;
            default -> {
            }
        }

        System.out.println("Resultado: " + resultado);
        
    }
}
