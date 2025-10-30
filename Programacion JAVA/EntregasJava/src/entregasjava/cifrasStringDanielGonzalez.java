/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entregasjava;

import java.util.Scanner;

/**
 *
 * @author Daniel González
 */
public class CifrasStringDanielGonzalez {

    public static void main(String[] args) {
        Scanner scIn = new Scanner(System.in);
        System.out.println("Introduce el numero del que quieres conocer sus cifras");
        String numA = scIn.nextLine();
        int longitudNum = numA.length();
        if (numA.charAt(0) == '-' || numA.charAt(0) == '+') {
            longitudNum--;
        }
        System.out.printf("El numero %s tiene %d cifras %n", numA, longitudNum);
    }
}
