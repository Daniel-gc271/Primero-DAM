/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicios;

import java.util.Scanner;

/**
 *
 * @author goncalda
 */
public class GetASCIICodeFromChar {
    public static void main(String[] args) {
         Scanner scIn = new Scanner(System.in);
        System.out.println("Introduce un caracter");
        char caracter = scIn.next().charAt(0);
        int ASCII= (int) caracter;
        scIn.close();
        System.out.println("El caracter introducido es: "+ ASCII);
    }
       
        
    
    
    
    
    
    
}
