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
public class Cambio {
   public static void main(String[] args){
   Scanner scIn = new Scanner(System.in);
   System.out.println("Intorduce un valor en euros para convertir en dolares");
   double Valor = scIn.nextDouble();
       double DIVISA = 1.17;
       scIn.close();
   System.out.println(Valor+" Euros equivalen a: "+(Valor*DIVISA)+"en dolares");
   
   
   
   
   
   
   
   
   } 
}
