/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entregasjava.Tema3;

import java.util.Scanner;

/**
 *
 * @author goncalda
 */
public class BinarioDanielGonzalez {

    /**
     *
     * @author Daniel González
     */
    public static void main(String[] args) {
        Scanner scIn = new Scanner(System.in);
        char[] entrada =new char[3];
        byte valor=0;
        int i=0;
        do {        
            System.out.println("Introduce una cifra binaria 1 o 0");  
            entrada[i]=scIn.next().charAt(0);
            while (entrada[i]!='0'&&entrada[i]!='1') {
            System.err.println("Debes introducir una cifra binaria 1 o 0!");  
            entrada[i]=scIn.next().charAt(0);}
            i++;
        } while (i<3);
        for (int j=(entrada.length-1); j>=0;j-- ){
            if (entrada[j]!='0') {valor+=1<<j;}
        }
        System.out.printf("El valor es %d%n",valor);
    }
}
