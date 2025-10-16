/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicios;

/**
 *COmo dar formato a datos con el metodo printf
 * @author goncalda
 */
public class Formateo {
    public static void main(String[] args) {
        double d1 = 1.123465134;
        int i1 =123;
        String S1 ="Hola";
        //%f decimales
        //%d enteros
        //%s string
        //%n salto de linea
        System.out.printf("Valor decimal %.2f - Valor entero %d - Cadena: %s%n",d1,i1,S1);
       
    }
}
