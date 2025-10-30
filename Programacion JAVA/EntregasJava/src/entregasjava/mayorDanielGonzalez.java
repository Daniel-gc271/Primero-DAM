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
import java.util.ArrayList;
import java.util.Scanner;

public class MayorDanielGonzalez {

    public static void main(String[] args) {
        Scanner scIn = new Scanner(System.in);
        /*
        Agradecimientos a la chati por decirme que
        un array no hacia falta indicarle el tamaño
        porque he intentado resolver con un objeto
        int[] nombre=new int[TAMAÑO] 
        Inicializo un array de integers
         */
        ArrayList<Integer> numeros = new ArrayList<>();
        int sigma = 0;
        int numA;
        int lastNumChk;
        do {
            System.out.println("Introduce un número positivo (0 para parar):");
            numA = scIn.nextInt();

            while (numA < 0) { //El usuario puede ser tonto y seguir metiendo numeros negativos
                System.err.println("Debes introducir un número positivo:");
                numA = scIn.nextInt();
            }
            /*
            Compruebo que el numero no sea 0 para meterlo, porque en caso de ser 0
            no le meteria y dejaria de pedir mas numeros
             */
            if (numA != 0) {
                numeros.add(numA);
            }
            lastNumChk = numA;
        } while (numA != 0);
        /*
        Recorro el array
         */
        for (int j = 0; j < numeros.size(); j++) {
            //Algoritmo que va comprobando el ultimo numero mas alto y lo actualiza
            if (lastNumChk >= numeros.get(j)) {
                lastNumChk += 0;
            } else {
                lastNumChk = numeros.get(j);
            }
            //Algoritmo que acumula los numeros multiplos de 5
            if (numeros.get(j) % 5 == 0) {
                sigma += numeros.get(j);
            } else {
                sigma += 0;
            }

        }
        System.out.printf("Has introducido un total de %d numeros, %nel mayor de todos ellos es: %d %nPor ultimo la suma de todos los numeros multiplos de 5 es: %d %n", numeros.size(), lastNumChk, sigma);
    }
}
