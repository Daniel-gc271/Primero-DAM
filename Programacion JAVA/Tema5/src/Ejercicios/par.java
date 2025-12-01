/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicios;

/**
 *
 * @author goncalda
 */
public class par {
    private static boolean esPar(int numero) {
        return numero%2==0;
    }
    public static void main(String[] args) {
        System.out.println("Is 4 even? "+ esPar(4));
    }
}
