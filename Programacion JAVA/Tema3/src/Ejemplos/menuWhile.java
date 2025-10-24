/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejemplos;

import java.util.Scanner;

/**
 *
 * @author goncalda
 * Programa que muester el siguiente menu de opciones al usuario
 * 
 */
public class menuWhile {
    private static void showMenu() {
        
        System.out.println("Slecciona una de las siguientes opciones: ");
        System.out.println("Opciona A");
        System.out.println("Opciona B");
        System.out.println("Opciona C");
        System.out.println("S para salir");
        
    }
    
    public static void main(String[] args) {
        boolean exit = true;
        Scanner scIn = new Scanner(System.in);
        while (exit) {
            showMenu();
        
        char opt = scIn.nextLine().toUpperCase().charAt(0);
        
        switch (opt) {
            case 'A' -> System.out.println("Opcion a");
            case 'B' -> System.out.println("Opcion b");
            case 'C' -> System.out.println("Opcion c");
            case 'S' -> {System.out.println("Salir"); exit = false; scIn.close();}
            default -> System.err.println("Seleccion inválida");
        }
        }
       
        
        
    }
}
