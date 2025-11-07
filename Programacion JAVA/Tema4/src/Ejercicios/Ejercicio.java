/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicios;

import java.util.Random;

/**
 *
 * @author goncalda
 */
public class Ejercicio{

    public static void main(String[] args) {
        Random numAleatorio = new Random();
        int numMayor = 0;
        int numRandom;

        for (int i = 0; i < 22; i++) {
            numRandom = numAleatorio.nextInt(0, 1001); // Generar número aleatorio primero
            System.out.printf("Iteración %d%n", i);
            System.out.println("Número aleatorio: " + numRandom);
            System.out.println("Número mayor actual: " + numMayor);

            if (numMayor <= numRandom) {
                numMayor = numRandom;
            }
        }

    }
}
