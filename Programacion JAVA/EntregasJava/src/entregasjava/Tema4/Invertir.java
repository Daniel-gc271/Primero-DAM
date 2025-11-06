/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entregasjava.Tema4;

import java.util.Scanner;

/**
 *
 * @author goncalda
 */
public class Invertir {
    public static void main(String[] args) {
        Scanner scIn =new Scanner(System.in);
        System.out.println("Introduce una cadena");
        String cadena = new String(scIn.nextLine());
        String cadenaInvertida =new String("");
        while (cadena.isEmpty()) {System.err.println("Introduce una cadena válida");cadena=scIn.nextLine();}
        for (int i = 0; i < cadena.length(); i++) {
            char caracter=cadena.charAt(i); 
            if (Character.isLowerCase(caracter)){cadenaInvertida+=Character.toString(caracter).toUpperCase();}
            else if (Character.isUpperCase(caracter)){cadenaInvertida+=Character.toString(caracter).toLowerCase();}
            else {cadenaInvertida+=caracter;}
        }
        System.out.println(cadenaInvertida);
    }
}
