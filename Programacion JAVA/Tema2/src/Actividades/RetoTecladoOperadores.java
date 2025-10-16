/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicios;

import java.util.Scanner;

/**
 *
        Programa que dependiendo de la edad te dice la propina semanal que recibes
        en funcion de si eres menor (20?) o mayor de edad (50?) la edad se introduce por teclado, emplea el operador ? 
        Operador ? sustituye en ciertos casos devolviendo un valor u otro en funcion de la condicion
 * 
 * @author goncalda
 */
public class RetoTecladoOperadores {
    public static void main(String[] args) {
        Scanner scIn= new Scanner(System.in);
        
        System.out.println("Introduce tu edad");
        double edad = scIn.nextDouble();
        double paga = (edad<18)? 20:50;
        scIn.close();
        System.out.println("Tu paga semanal es de: "+ paga);
    }
}
