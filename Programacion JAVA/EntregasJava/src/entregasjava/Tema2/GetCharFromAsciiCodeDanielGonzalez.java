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
public class GetCharFromAsciiCodeDanielGonzalez {
    public static void main(String[] args) {
        Scanner scIn= new Scanner(System.in);
        System.out.println("Introduce el codigo ascii del caracter que quieres conocer");
        int valorASCII= scIn.nextInt();
        char caracter = (char) valorASCII;
        System.out.printf("El codigo %d corresponde al caracter \"%s\"%n",valorASCII,caracter);
    }
}
