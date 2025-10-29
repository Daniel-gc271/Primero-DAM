/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicios;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Daniel González
 */
public class Moneda {
    public static void main(String[] args) {
        Random genRandom = new Random();
        Scanner scIn = new Scanner(System.in);
        System.out.println("Introduce el numero de monedas que quieras tirar");
        int numeroMonedas= scIn.nextInt();
        for (int i =0; i<= numeroMonedas; i++)
        {        
        Boolean moneda= genRandom.nextBoolean();
        String msg = moneda ? "Cara":"Cruz";
            System.out.printf("Ha salido %s%n",msg);
            
        }
        scIn.close();
       
    }
}
