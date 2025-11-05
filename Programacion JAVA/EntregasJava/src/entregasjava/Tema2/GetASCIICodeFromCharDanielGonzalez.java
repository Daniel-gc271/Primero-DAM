/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entregasjava.Tema2;

import java.util.Scanner;

/**
 *
 * @author goncalda
 */
public class GetASCIICodeFromCharDanielGonzalez {
    public static void main(String[] args) {
    Scanner scIn = new Scanner(System.in);
        System.out.println("Introduce el caracter del cual quieres conocer su codigo ASCII");
        char caracter=scIn.next().charAt(0);
        int valorASCII=((int)caracter);
        System.out.printf("El caracter \"%s\" corresponde al valor: %d%n",caracter, valorASCII);
    }
}
