/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejemplos;

import com.sun.source.tree.ContinueTree;
import java.util.Scanner;

/**
 * bucles
 *
 * @author goncalda
 */
public class Bucles {

    private static void bucleInfinito() {
        int i = 0;
        while (1 == 1/*Condicion*/) {
            i++;
            System.out.println(i);
        }
    }

    private static void bucleAscendenteCustom(int rep) {
        int i = -1;
        while (i < rep/*Condicion*/) {
            i++;
            System.out.println(i);
        }
    }

    private static void bucleDescendenteCustom(int rep) {
        int i = 1;
        while (i > rep/*Condicion*/) {
            i--;
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        //Mostrar por pantalla 20 veces hola
        //int i=0;
        // while (i!=20){i++;System.out.printf("Hola #%d\n",i);}
        //while (i!=100){i++;System.out.printf("#%d\n",i);}
        /*
        int j=100;
        while (j>-1){System.out.printf("#%d\n",j);j--;} //bucle que imprima los numeros de 100 a 0
        System.out.println("Introduce las iteraciones del bucle");
        Scanner scIn = new Scanner(System.in);
        j = scIn.nextInt();
        if (j>0)  bucleAscendenteCustom(j); else bucleDescendenteCustom(j);
        while (i != 100)
        {
            i++;
            if (i%2==0) System.out.printf("Numeros pares: %d\n", i);
                   }
*
        
        int cuentaNoPar=0;
        int i=1;
        while (i < 100)
        {
            System.out.printf("Numeros no pares: %d\n", i);cuentaNoPar++;
            i +=2;
        }    
        System.out.printf("Hay %d numeros impares\n",cuentaNoPar);
         */
        Scanner scIn = new Scanner(System.in);
        int sigma=0;
        System.out.println("Introduce la cantidad de numeros que quieres sumar");
        int j = scIn.nextInt();
        System.out.println("Introduce el numero por el que deben ser divisibles");
        int k = scIn.nextInt();
        if (j > 0 || k > 0) {
            int i = 0;
            while (i < (j * k + 1)) {
                System.out.println(i);
                i++;
                if (i%j==0){
                sigma +=i;
                }
            }
        } else {
            System.err.println("Introduce un numero positivo");
            System.exit(1);
        }
        System.out.println("La suma es: "+sigma);
        scIn.close();
    }
}
