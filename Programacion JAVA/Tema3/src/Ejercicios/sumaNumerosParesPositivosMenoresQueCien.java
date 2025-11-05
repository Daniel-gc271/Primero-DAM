/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicios;

/**
 *
 * @author goncalda
 */
public class sumaNumerosParesPositivosMenoresQueCien {

    public static void main(String[] args) {
        System.out.println("Sumrea de los numeros pares comprendidos entre el 0 y el 100 incluidos");
        int sigma = 0;
        for (int i = 0; i <= 100; i += 2) {
            sigma += i;
        }
        System.out.println(sigma);

        System.out.println("Potencias de 2 hasta que el resultado alcance (o supere) 100");
        int potencia;
        for (int exponente = 0; (potencia = 1 << exponente) <= 100; exponente++) {
            System.out.println("2^" + exponente + " = " + potencia);
        }
        
    }
}
