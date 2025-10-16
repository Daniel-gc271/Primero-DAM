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
public class Bucle8DanielGonzalez {
    public static void main(String[] args) {
        Scanner scIn = new Scanner(System.in);
        int input=1;//Dar un valor inicial a input  no igual a 0 para entrar al bucle for
        int cont=0; //Inicializar el contador en 0
        while (input!=0){
            System.out.println("Introduce un numero (0 para terminar)"); //Pedir al usuario el valor de entrada
            input=scIn.nextInt(); //Actualizar la variable input con el nuevo valor de entrada
            cont++;    //Incrementar contador
        } 
        cont--;//Disminuir en una unidad el contador para que no contabilice el ultimo 0
        scIn.close(); //Liberalizar recursos al finalizar las entradas
        System.out.printf("Has introducido %d numeros\n",cont); //Imprimir los resultados del programa (el numero de cifras introducido)
    }
}
