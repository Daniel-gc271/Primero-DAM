/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejemplos;

import java.util.Scanner;

/**
 * En este ejemplo veremos como obtener datos del usuario mediante la clase scanner
 * @author goncalda
 */
public class EtradaDatos {
    public static void main(String[] args) {
        
        //Acceso al teclado
        Scanner scIn= new Scanner(System.in);
        System.out.println("Introduce tu nombre");
        //Tomar el dato del teclado String DATO=scIn.next();
       String NOMBRE=scIn.nextLine();
       System.out.println("Introduce tu edad");
       short EDAD= scIn.nextShort();
       System.out.println("Introduce tu altura");
       float ALTURA=scIn.nextFloat();
       System.out.println("Introduce tu peso");
       float PESO=scIn.nextFloat();
        
        
        
        
    }
}
