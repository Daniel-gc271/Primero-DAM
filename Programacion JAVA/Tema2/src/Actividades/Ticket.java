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
public class Ticket {
   public static void main(String[] args){
   Scanner scIn = new Scanner(System.in);
   System.out.println("Intorduce el importe con impuestos");
   double TaxPrice = scIn.nextDouble();
   System.out.println("Intorduce los impuestos que aplican ej 21");
   double TAX = scIn.nextDouble();
   //Calcular el precio sin iva
   double noTaxPrice = TaxPrice/(1.0+(TAX/100.0));
   //Calcular el coste de impuestos pagados
   double paidTax = TaxPrice - noTaxPrice;
   System.out.println("Precio sin impuestos: "+noTaxPrice);
   System.out.println("Impuestos aplicados; "+paidTax);
   
   
   
   
   
   
   
   
   
   } 
}
