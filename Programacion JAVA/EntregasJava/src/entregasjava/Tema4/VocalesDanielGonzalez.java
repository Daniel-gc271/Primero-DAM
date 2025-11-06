/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entregasjava.Tema4;

import java.util.Scanner;

/**
 *
 * @author goncalda
 */
public class VocalesDanielGonzalez {

    public static void main(String[] args) {
        Scanner scIn = new Scanner(System.in);
        //Inicializar variables
        int posicionBuscada = 0;
        int ocurrencias = 0;
        //Solicitar las entradas necesarias
        System.out.println("Introduce un texto del que quieras saber cuantas vocales tiene");
        String cadenaOrigen = scIn.nextLine().toLowerCase();   
        String cadenaBuscada = "a";
        posicionBuscada = cadenaOrigen.indexOf(cadenaBuscada, 0); //Iniciar la busqueda a partir del indice 0 (aka el principio)
        while (posicionBuscada != -1) {
            ocurrencias++;
            posicionBuscada += cadenaBuscada.length(); //Sumar la longitud para asegurarse que no se cuente la misma ocurrencia
            posicionBuscada = cadenaOrigen.indexOf(cadenaBuscada, posicionBuscada); //Actualizar la nueva posicion buscada para buscar la siguiente ocurrencia
        }
        cadenaBuscada = "e";
        posicionBuscada = cadenaOrigen.indexOf(cadenaBuscada, 0); //Iniciar la busqueda a partir del indice 0 (aka el principio)
        while (posicionBuscada != -1) {
            ocurrencias++;
            posicionBuscada += cadenaBuscada.length(); //Sumar la longitud para asegurarse que no se cuente la misma ocurrencia
            posicionBuscada = cadenaOrigen.indexOf(cadenaBuscada, posicionBuscada); //Actualizar la nueva posicion buscada para buscar la siguiente ocurrencia
        }
        cadenaBuscada = "i";
        posicionBuscada = cadenaOrigen.indexOf(cadenaBuscada, 0); //Iniciar la busqueda a partir del indice 0 (aka el principio)
        while (posicionBuscada != -1) {
            ocurrencias++;
            posicionBuscada += cadenaBuscada.length(); //Sumar la longitud para asegurarse que no se cuente la misma ocurrencia
            posicionBuscada = cadenaOrigen.indexOf(cadenaBuscada, posicionBuscada); //Actualizar la nueva posicion buscada para buscar la siguiente ocurrencia
        }
        
        cadenaBuscada = "o";
        posicionBuscada = cadenaOrigen.indexOf(cadenaBuscada, 0); //Iniciar la busqueda a partir del indice 0 (aka el principio)
        while (posicionBuscada != -1) {
            ocurrencias++;
            posicionBuscada += cadenaBuscada.length(); //Sumar la longitud para asegurarse que no se cuente la misma ocurrencia
            posicionBuscada = cadenaOrigen.indexOf(cadenaBuscada, posicionBuscada); //Actualizar la nueva posicion buscada para buscar la siguiente ocurrencia
        }
        cadenaBuscada = "u";
        posicionBuscada = cadenaOrigen.indexOf(cadenaBuscada, 0); //Iniciar la busqueda a partir del indice 0 (aka el principio)
        while (posicionBuscada != -1) {
            ocurrencias++;
            posicionBuscada += cadenaBuscada.length(); //Sumar la longitud para asegurarse que no se cuente la misma ocurrencia
            posicionBuscada = cadenaOrigen.indexOf(cadenaBuscada, posicionBuscada); //Actualizar la nueva posicion buscada para buscar la siguiente ocurrencia
        }
        
        System.out.printf("hay %d vocales%n", ocurrencias);

        }
    }
