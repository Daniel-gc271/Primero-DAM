/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicios;

/**
 *
 * @author goncalda
 */
public class ToFarenheit {
    private static double calcFFomC(int degreeC) {
    double degreeF= (9/5.0)*degreeC+32;
    return degreeF;
    }
    
    public static void main(String[] args) {
        System.out.printf("-42ºC = %.2fF%n", calcFFomC(-42));
        
        
    }
}
