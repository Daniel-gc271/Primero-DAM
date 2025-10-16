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
public class Minutos {
    public static void main(String[] args) {
    Scanner scIn = new Scanner(System.in);
    System.out.println("Introduce un valor en segundos");
    int time = scIn.nextInt();
    int horas = time/3600; //int para quitarme los decimales
    time %=3600;
    int minutos = time/60;
    time %=60;
    int segundos = time;
    scIn.close();
    System.out.println("El tiempo eequivale a: "+horas+"h " +minutos+"m "+segundos+"s");
    
    
    
    
    
    
    
    }
}
