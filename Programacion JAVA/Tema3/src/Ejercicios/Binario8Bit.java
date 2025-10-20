/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicios;

import java.util.Scanner;

/**
 *
 * @author Daniel González
 */
public class Binario8Bit {

    public static void main(String[] args) {
        Scanner scIn = new Scanner(System.in);       
        System.out.println("Introduce una cifra en binario de 8 bits");
            String input = scIn.nextLine();
            scIn.close();
            if (input.length()!= 8) {System.err.println("No has metido un numero de 8 bits");System.exit(1);}
        int i = 7;
        int num=0;
        while ( i >= 0) {
           
            System.out.println(i);
            System.out.println("Caracter actual: "+(input.charAt(i)));
            switch(input.charAt(i)) {
                case '1': {num += (int)Math.pow(2, i);}
                case '0': {num+=0;}
                default: {System.err.println("No has introducido un numero en binario");System.exit(1);}
            
            
             i--;  
            }
            
        }
    }}

