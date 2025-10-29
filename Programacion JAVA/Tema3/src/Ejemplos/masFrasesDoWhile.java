/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejemplos;

import java.util.Scanner;

/**
 *
 * @author goncalda programa que proponga al usuario de escribir frases hasta
 * que no quiera mas para ello entre frase y frase debera responder a la
 * pregunra ¿Introducir otra frase? (Si o No)
 */
public class masFrasesDoWhile {

    public static void main(String[] args) {
        Scanner scIn = new Scanner(System.in);
        boolean otraFrase = true;
        String frase = "";
        int contFrases = 0;
        char respuesta;
        do {
            System.out.println("Introduce una frase");
            frase = scIn.nextLine();
            if (frase.length()!=0) {contFrases++;}
            else {System.out.println("No has introducido una frase, entonces no se cuenta");}
            
            System.out.println("Introducir otra frase si o no?");
            respuesta =scIn.nextLine().toLowerCase().charAt(0);
            otraFrase = respuesta=='s';
        } while (otraFrase);
        System.out.println("Has introducido "+contFrases+" frases");
       
    }

}
