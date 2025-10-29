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
public class cifrasInt {
    public static void main(String[] args) {
        Scanner scIn = new Scanner(System.in);
        System.out.println("Introduce el numero del que quieres conocer sus cifras");
        int numA= scIn.nextInt();
        int numB = numA;
        numA = Math.abs(numA);
        int cont=0;
        while (numA>0) {numA/=10;cont++;}
        System.out.printf("El numero %d tiene %d cifras%n",numB,cont);
    }
}
