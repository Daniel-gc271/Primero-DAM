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
public class AlternarValidadoDanielGonzalez1 {

    public static void main(String[] args) {
        /*Scanner scIn = new Scanner(System.in);
        System.out.println("Introduce una cadena que quieras transmutar");
        String entrada = new String();
        entrada =scIn.nextLine();
        String alternado = new String();
        do {System.err.println("Has introducido una cadena vacía");entrada=scIn.nextLine();} while(entrada.isBlank());*/
        
        entrada ="Abrigo corto";
        for (int i = 0; i < entrada.length()/2; i++) {
            alternado = alternado.concat(Character.toString(entrada.charAt(i)));
            alternado = alternado.concat(Character.toString(entrada.charAt(entrada.length() - i - 1)));
        }
        System.out.printf("\"%s\"",alternado);
    }
}
