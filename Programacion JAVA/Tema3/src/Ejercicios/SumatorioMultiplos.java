/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicios;

/**
 *
 * @author goncalda
 */
public class SumatorioMultiplos {

    public static void main(String[] args) {
        int min = 0;
        int max = 100;
        int divisor = 2;
        int i = min/divisor;
        int contador = 0;
        int sigma = 0;

        if (min < 0) {
            System.err.println("el limite inferior debe ser mayor o igual a 0");
            System.exit(1);
        } else 
            while (i<max) 
            {
                
             i+=divisor;
             if(i>max) sigma-=i;
                else {System.out.println(i);
                contador++;
                sigma+=i;}
                
                
               
            }
            System.out.printf("Hay %d numeros divisible por %d entre %d y %d; su suma equivale a %d\n", contador, divisor, min, max, sigma);
        }

    }

