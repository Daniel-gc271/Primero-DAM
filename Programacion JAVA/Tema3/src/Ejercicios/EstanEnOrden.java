/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios;

import java.util.Scanner;

/**
 *
 * @author Daniel González
 */
public class EstanEnOrden {
    public static void main(String[] args) {
         Scanner scIn = new Scanner(System.in);
        System.out.println("Inserta un numero");
        int a =scIn.nextInt();
        System.out.println("Inserta un numero");
        int b =scIn.nextInt();
        System.out.println("Inserta un numero");
        int c =scIn.nextInt();
        if ((a>b && a>c) &&(b>c)) System.out.println("Ordenados de mayor a menor");
        else {if ((c>b && c>a)&&b>a)System.out.println("Ordenados de menor a mayor");
        else System.out.println("Estan desordenados");
            
            }
    }
}
