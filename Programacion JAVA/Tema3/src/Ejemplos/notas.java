/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejemplos;

import java.util.Scanner;

/**
 *
 * @author goncalda
 * Programa que pedira al usuario su nota y le indicara si ha aprobado o suspendido
 */
public class notas {
    public static void main(String[] args){
        
    Scanner scIn = new Scanner(System.in);
    System.out.println("Introduce la asignatura");
    String asignatura = scIn.nextLine();
    System.out.println("Introduce tu calificacion");
    float nota = scIn.nextFloat();
    scIn.close();
    if (nota >= 5) System.out.printf("tu nota de %f en %s indica que has aprovado",nota,asignatura);
    System.out.printf("tu nota de %f en %s indica que has suspendido",nota,asignatura);
    }
}
