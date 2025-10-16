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
public class divisible {
    public static void main(String[] args) {
        Scanner scIn = new Scanner(System.in);
    System.out.println("Introduce el numerador");
    double numA =scIn.nextDouble();
    System.out.println("Introduce el denominador");
    double numB =scIn.nextDouble();
    if((numA%numB)==0) System.out.printf("%f es divisible por %f",numA,numB);
    else {System.out.printf("%f no es divisible por %f\n",numA,numB);}
    
    }
}
