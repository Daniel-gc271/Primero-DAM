/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tema5;


/**
 *
 * @author goncalda
 */
public class AppImprimirPrimoDanielGonzalez {

    public static void main(String[] args) {
        PrimoDanielGonzalez obj = new PrimoDanielGonzalez();
        int contPrimos = 0;
        int numComp = 1;
        while (contPrimos < 10) {
            if (obj.esPrimo(numComp)) {
                System.out.println(numComp);
                contPrimos++;
            } else {
            }
            numComp++;

        }
    }
}
