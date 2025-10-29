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
public class cifrasString {
    public static void main(String[] args) {
        Scanner scIn = new Scanner(System.in);
        System.out.println("Introduce el numero del que quieres conocer sus cifras");
        String numA= scIn.nextLine();
        if (numA.charAt(0)=='-') {System.out.printf("El numero %s tiene %d cifras %n",numA,(numA.length()-1));}
        else {System.out.printf("El numero %s tiene %d cifras %n",numA,numA.length());}
    }
}
