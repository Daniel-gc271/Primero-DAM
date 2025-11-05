/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tema2;

import java.util.Scanner;

/**
 *
 * @author albagonzalez
 */
public class Calculo {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scIn = new Scanner(System.in);
        System.out.println("Inserte un numero entero");
        double numA = scIn.nextDouble();
        System.out.println("Inserte un numero entero");
        double numB = scIn.nextDouble();
        System.out.println("Inserte una operacion matemática");
        System.out.println("+, -, /, *, %");
        String operacion = scIn.next();
        scIn.close();
        
        
        
        
        switch (operacion.charAt(0)) {
            case 43 ->
                System.out.println(numA + "+" + numB + "=" + (numA + numB)); //Suma 43   
            case 45 ->
                System.out.println(numA + "-" + numB + "=" + (numA - numB)); //Suma 45
            case 42 ->
                System.out.println(numA + "*" + numB + "=" + (numA * numB)); //Multiplicacion 42

            case 47 -> {
                if (numB == 0) {
                    System.out.println("No se puede dividir por 0");
                } else {
                    System.out.println(numA + "/" + numB + "=" + (numA / numB)); //Division 47                  
                }
            }
            case 37 ->
                System.out.println(numA + "%" + numB + "=" + (numA % numB)); //Modulo 37

        }

    }

}
