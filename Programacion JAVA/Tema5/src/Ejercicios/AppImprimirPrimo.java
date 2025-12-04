/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicios;

import Ejercicios.Primo;

/**
 *
 * @author goncalda
 */
public class AppImprimirPrimo {

    public static void main(String[] args) {
        Primo obj = new Primo();
        int contPrimos = 0;
        int numComp = 2;
        while (contPrimos < 101) {
            if (obj.esPrimo(numComp)) {
                System.out.println(numComp);
                contPrimos++;
            } else {
            }
            numComp++;

        }
    }
}
