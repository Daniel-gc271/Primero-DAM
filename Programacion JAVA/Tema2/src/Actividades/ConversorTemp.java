/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicios;

import java.util.Scanner;

/**
 * programa que pase de celsius a farenheit programa que solucione sistemas
 * ecuaciones de dos incognitas
 *
 * @author goncalda
 */
public class ConversorTemp {

    public static void main(String[] args) {
        Scanner scIn = new Scanner(System.in);
        System.out.println("Inserta unicamente el valor de una temperatura sin las unidades en celsius");
        double temp = scIn.nextDouble();
        double oldTem = temp;
        scIn.close();
        temp *= 1.8;
        temp += 32;
        System.out.printf("%fºC = %fF", oldTem, temp);
       

    }

}
