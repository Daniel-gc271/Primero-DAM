/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entregasjava;

import java.util.Scanner;

/**
 *
 * @author Daniel González
 */
public class CifrasIntDanielGonzalez {

    public static void main(String[] args) {
        Scanner scIn = new Scanner(System.in);
        System.out.println("Introduce el numero del que quieres conocer sus cifras");
        int numero = scIn.nextInt();
        int copiaNumero = numero; //Guardar una copia para la salida
        numero = Math.abs(numero); //Pasar a positivo para que entre en el bucle while
         /*
            Bucle que cuenta las veces que ha dividido entre 10;
          */ 
         int cont = 0;//Contador de cifras
        while (numero > 0) {
            numero /= 10;
            cont++;
        }if (numero==0) {cont++;}
        System.out.printf("El numero %d tiene %d cifras%n", copiaNumero, cont);
    }
}
