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
public class Signonumero {

    public static void main(String[] args) {
        Scanner scIn = new Scanner(System.in);
        System.out.println("Introduce un numerom para conocer su signo");
        float entrada = scIn.nextFloat();
        scIn.close();
        /* Mal se evaluan los 3;hay que poner el else
        if (entrada==0){System.out.printf("%f es nulo\n",entrada);}
        if (entrada>0){System.out.printf("%f es positivo\n",entrada);}
        if (entrada<0){System.out.printf("%f es negativo\n",entrada);}        
        La manera correcta seria: 
        */
        if (entrada == 0) {
            System.out.printf("%f es nulo\n", entrada);
        } else if (entrada > 0) {
            System.out.printf("%f es positivo\n", entrada);
        } else 
            System.out.printf("%f es negativo\n", entrada);
        
    }
}
