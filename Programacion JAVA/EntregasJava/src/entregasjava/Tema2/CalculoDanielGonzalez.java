/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entregasjava.Tema2;

import java.util.Scanner;

/**
 *
 * @author goncalda
 */
public class CalculoDanielGonzalez {
 


public class Calculo {



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
            case '+' ->
                System.out.println(numA + "+" + numB + "=" + (numA + numB)); //Suma 43   
            case '-' ->
                System.out.println(numA + "-" + numB + "=" + (numA - numB)); //Suma 45
            case '*' ->
                System.out.println(numA + "*" + numB + "=" + (numA * numB)); //Multiplicacion 42

            case '/' -> {
                if (numB == 0) {
                    System.out.println("No se puede dividir por 0");
                } else {
                    System.out.println(numA + "/" + numB + "=" + (numA / numB)); //Division 47                  
                }
            }
            case '%' ->
                System.out.println(numA + "%" + numB + "=" + (numA % numB)); //Modulo 37

        }

    }

}
}
