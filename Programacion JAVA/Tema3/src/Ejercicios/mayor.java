/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicios;

import java.util.Scanner;

/**
 *
 * @author Daniel González
 */
import java.util.ArrayList;
import java.util.Scanner;

public class mayor {

    public static void main(String[] args) {
        Scanner scIn = new Scanner(System.in);
        ArrayList<Integer> numeros = new ArrayList<>();
        int sigma=0;
        int numA;
        int lastNumChk;
        do {
            System.out.println("Introduce un número positivo (0 para parar):");
            numA = scIn.nextInt();

            while (numA < 0) { //El usuario puede ser tonto y seguir metiendo numeros negativos
                System.err.println("Debes introducir un número positivo:");
                numA = scIn.nextInt();
            }
            if (numA != 0) {
                numeros.add(numA);
            }
            lastNumChk = numA;
        } while (numA != 0);

        for (int j = 0; j < numeros.size(); j++) {
            if (lastNumChk >= numeros.get(j)) {
                lastNumChk += 0;
            } else {
                lastNumChk = numeros.get(j);
            }
            
            if (numeros.get(j)%5==0) {
                sigma += numeros.get(j);
            } else {
                sigma+=0;
            }
            
            
        }
        System.out.printf("Has introducido un total de %d numeros, %nel mayor de todos ellos es: %d %nPor ultimo la suma de todos los numeros multiplos de 5 es: %d %n",numeros.size(),lastNumChk,sigma);
    }
}
