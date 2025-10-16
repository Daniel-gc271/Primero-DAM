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
public class SignoNumero {
    public static void main(String[] args) {
        Scanner scIn = new Scanner(System.in);
        System.out.println("Introduce un numero");
        int num = scIn.nextInt();
        scIn.close();
        String mensaje;
        mensaje =(num ==0) ? ("Nulo"):
                 (num > 0) ? ("Positivo") : (num < 0)? "Negativo" : "Valor invalido";
        System.out.println(mensaje);
        
    }
}
