/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicios;

/**
 *
 * @author goncalda
 */
public class Utilidades {
    
public boolean esPar(int numero) {
        return numero%2==0;
    }   

public double calcFFomC(int degreeC) {
    double degreeF= (9/5.0)*degreeC+32;
    return degreeF;
    }
    /* 
public int mayorDivisor(int numero) {
        int largestDivider=1;
        for (int i = 1; i < numero/2+1; i++) {
            if (numero % i == 0) {
                largestDivider = i;

            }
        }
        return largestDivider;
    }*/
   public int mayorDivisor(int numero) {
        int divisorMasGrande =numero/2+1;
            while (divisorMasGrande>0) {
                if(numero%divisorMasGrande==0)
                    return divisorMasGrande;
                divisorMasGrande--;
            }
        return 1;
   }
}
