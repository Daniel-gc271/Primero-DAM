/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicios;

import java.util.Scanner;

/**
 * En una cadena buscar las ocurrencias de otra cadena devuelve el total y la
 * posicion de las ocurrencias
 *
 * @author goncalda
 */
public class BuscaCadena {

   
   public static void main(String[] args) {
        Scanner scIn = new Scanner(System.in);

        System.out.println("Introduce un texto del que quieras encontrar todas las ocurrencias de una palabra");
        String cadenaOrigen = scIn.nextLine();

        int indiceBuscado = 0;
        int numOcurrencias = 0;

        System.out.println("Introduce la palabra buscada");
        String cadenaBuscada = scIn.nextLine();
        cadenaBuscada+=" ";

        while (!cadenaOrigen.contains(cadenaBuscada)) {
            System.err.println("La palabra buscada no está en el texto, introduce otra");
            cadenaBuscada = scIn.nextLine();
        }

        while ((indiceBuscado = cadenaOrigen.indexOf(cadenaBuscada, indiceBuscado)) != -1) {
            indiceBuscado += cadenaBuscada.length();
            System.out.println(indiceBuscado);
            numOcurrencias++;    
        }
        cadenaBuscada.strip();
        System.out.printf("Hay %d ocurrencias de la cadena \"%s\"%n", numOcurrencias, cadenaBuscada);
    }
}

