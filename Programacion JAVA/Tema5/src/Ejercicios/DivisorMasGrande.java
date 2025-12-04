/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicios;

/**
 *
 * @author goncalda
 */
public class DivisorMasGrande {

    static int divisorMasGrande(int numero) {
        int largestDivider=1;
        for (int i = 1; i < numero/2+1; i++) {
            if (numero % i == 0) {
                largestDivider = i;

            }
        }
        return largestDivider;
    }

    public static void main(String[] args) {
         System.out.printf("El divisor mas grande de 100 es: %d%n",divisorMasGrande(100));
    }
}
