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
public class Bisiesto {
    public static void main(String[] args){
        Scanner scIn = new Scanner(System.in);
    int year=scIn.nextInt();
    boolean multFour = (year%4 == 0);
    boolean multHundred =(year%100 == 0);
       boolean multFourHundred =(year%400 == 0);
       String mensaje = (multFour && !multHundred)|| (multFourHundred)? "es bisiesto":"no es bisiesto";
        System.out.printf("El año %d %s\n",year,mensaje); 
        
        
        
        
        
        
        
        
        
        
    }
}

