/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entregasjava.Tema4;

import java.util.Scanner;

/**
 * En una cadena buscar las ocurrencias de otra cadena devuelve el total y la
 * posicion de las ocurrencias nota la cadena es una palabra separada por espacios
 *
 * @author goncalda
 */
public class BuscaCadenaDanielGonzalez {

   
   public static void main(String[] args) {
        Scanner scIn = new Scanner(System.in);

        System.out.println("Introduce un texto del que quieras encontrar todas las ocurrencias de una palabra");
        String cadenaOrigen = scIn.nextLine();

        int indiceBuscado = 0;
        int numOcurrencias = 0;

        System.out.println("Introduce la palabra buscada");
        String cadenaBuscada = scIn.nextLine();
        cadenaBuscada+=" ";
        cadenaOrigen+=" ";

        while (!cadenaOrigen.contains(cadenaBuscada)) {
            System.err.println("La palabra buscada no está en el texto, introduce otra");
            cadenaBuscada = scIn.nextLine();
        }
        indiceBuscado = cadenaOrigen.indexOf(cadenaBuscada, 0);
        System.out.printf("La palabra %s se encuentra en las posiciones: ", cadenaBuscada);
        while (indiceBuscado != -1) {
            System.out.printf("%d, ",indiceBuscado);
            numOcurrencias++;   
            indiceBuscado += cadenaBuscada.length();
            indiceBuscado = cadenaOrigen.indexOf(cadenaBuscada, indiceBuscado);
        }
        cadenaBuscada=cadenaBuscada.strip();
        System.out.printf("hay %d ocurrencias de la cadena\"%s\".%n", numOcurrencias, cadenaBuscada);
    }
}

