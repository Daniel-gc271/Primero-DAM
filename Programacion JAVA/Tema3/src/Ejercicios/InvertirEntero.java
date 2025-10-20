/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicios;

import java.util.Scanner;

/**
 *
 * @author goncalda
 */
public class InvertirEntero {
    /*Método que comprueba que el numero es valido
      aprovecha la codificacion de los caraacteres en la tabla ascii
      las cifras (0->9) se encuentran en el rango cerrado 48-57
    */
    private static boolean validar(char caracter) {
        int ASCII = (int) caracter;
        return ASCII >= 48  && ASCII <= 57;
    }

    public static void main(String[] args) {
        /*
        Iniciar escaner y valores 
        */
        Scanner scIn = new Scanner(System.in);
        //Solicitar al usuario el numero a invertir
        System.out.println("Introduce un numero que quieras invertir");
        String numOrg = scIn.nextLine();
        scIn.close(); //Liberar recursos
        //Iniciar variables miscelaneas
        String numInv = ""; 
        Boolean valido = true;
        int i = numOrg.length();
        //Bucle sescendente que permite invertir el numero 
        //Concatenando los caracteres en el string "numInv"
        //Las condiciones hacen que el bucle se salte en caso
        //de que el numero no sea valido
        while (i > 0 && valido) {
            valido = validar(numOrg.charAt(i - 1));
            numInv += numOrg.charAt(i - 1);
            i--;
        }
        //Al terminar el bucle se comprueba que el numero fuera valido y se da una
        //respuesta acorde
        if (valido) {
            System.out.println("Has introducido el numero: " + numOrg);
            System.out.println("El numero inverso es: " + numInv);
            
        } else {System.err.println("Has introducido un numero invalido");}

    }
}
