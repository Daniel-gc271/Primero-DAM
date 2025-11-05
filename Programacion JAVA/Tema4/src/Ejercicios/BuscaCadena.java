/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicios;

import java.util.Scanner;

/**
 * En una cadena buscar las ocurrencias de otra cadena devuelve el total y la posicion de las ocurrencias
 * 
 * @author goncalda
 */
public class BuscaCadena {
    public static void main(String[] args) {
        
        Scanner scIn =new Scanner(System.in);
        System.out.println("Introduce un texto del que quieras encontrar todas las ocurrencias de una palabra");
        String cadenaOrigen= new String(scIn.nextLine());
        String cadenaBuscada = new String();
        int indiceBuscado;
        System.out.println("Introduce la palabra buscada");
        cadenaBuscada=scIn.nextLine();
        do {
            System.err.println("La palabra buscada no esta en el texto, introduce otra");
            cadenaBuscada=scIn.nextLine();
         } while (!cadenaOrigen.contains(cadenaBuscada));
        indiceBuscado=cadenaOrigen.indexOf(cadenaBuscada);
        
        
    }
    
}
