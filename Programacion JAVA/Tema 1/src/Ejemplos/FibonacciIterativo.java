/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejemplos;

/**
 *
 * @author goncalda
 */
public class FibonacciIterativo {
    public static void main(String[] args) {
        int serie = 1000; // Cantidad de números de la serie a generar
        int num1 = 0, num2 = 1;

        System.out.println("Serie de Fibonacci (Iterativa):");
        System.out.println(num1); // Muestra el primer número (0)

        for (int i = 1; i < serie; i++) {
            System.out.println(num2); // Muestra el siguiente número
            int suma = num1 + num2; // Calcula el próximo número de la serie
            num1 = num2;          // Actualiza num1 al valor anterior de num2
            num2 = suma;          // Actualiza num2 al nuevo valor calculado
        }
    }
}
