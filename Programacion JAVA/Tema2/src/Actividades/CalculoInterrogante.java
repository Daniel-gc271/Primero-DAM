/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Ejercicios;

import java.util.Scanner;

/**
 *
 * @author albagonzalez
 */
public class CalculoInterrogante {

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
        char op = scIn.next().charAt(0);
        scIn.close();
        double resultado = 
                ((op =='+') ? (numA+numB):
                ((op =='-') ? (numA-numB):
                ((op =='*') ? (numA*numB):
                ((op =='/') && (numB!=0) ? (numA/numB):
                ((op =='%') ? (numA%numB): 
                Double.MIN_VALUE)))));
        
        String mensaje = (resultado ==  Double.MIN_VALUE) ? 
                "SYNTAX ERROR":
                String.valueOf(resultado);
        System.out.println( mensaje);
        
        
        
        /*
        switch ((int) op.charAt(0)) {
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
*/
        

    }

}
