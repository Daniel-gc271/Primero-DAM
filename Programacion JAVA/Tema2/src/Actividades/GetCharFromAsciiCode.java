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
public class GetCharFromAsciiCode {
    public static void main(String[] args){
        Scanner scIn = new Scanner(System.in);
    System.out.println("Introduce un codigo ascii");
    char caracter = (char) scIn.nextInt();
    scIn.close();
    System.out.println("El codigo ascii equivale al caracter: "+caracter);
       
    
    }
}
