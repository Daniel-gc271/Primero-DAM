/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entregasjava.Tema4;

import java.util.Scanner;

/**
 * En una cadena buscar las ocurrencias de otra cadena devuelve el total y la
 * posicion de las ocurrencias nota la cadena es una palabra separada por
 * espacios
 *
 * @author goncalda
 */
public class BuscaCaracteresDanielGonzalez1 {

    public static void main(String[] args) {
        Scanner scIn = new Scanner(System.in);
        //Inicializar variables
        int posicionBuscada = 0;
        int ocurrencias = 0;
        //Solicitar las entradas necesarias
        System.out.println("Introduce un texto del que quieras encontrar todas las ocurrencias de un caracter");
        String cadenaOrigen = scIn.nextLine();

        System.out.println("Introduce la letra buscada");
        String cadenaBuscada = scIn.nextLine();
        //Validacion simple
        do {
            if (cadenaBuscada.length() != 1) {
                System.err.println("Debes introducir una letra");
                cadenaBuscada = scIn.nextLine();
            }
            if (!cadenaOrigen.contains(cadenaBuscada)) {
                System.err.println("La letra buscada no está en el texto, introduce otra");
                cadenaBuscada = scIn.nextLine();
            }

            scIn.close();
        } while (cadenaBuscada.length() != 1 || !cadenaOrigen.contains(cadenaBuscada));

        System.out.printf("El caracter %s se encuentra en las posiciones: ", cadenaBuscada);
        

        posicionBuscada = cadenaOrigen.indexOf(cadenaBuscada, 0); //Iniciar la busqueda a partir del indice 0 (aka el principio)
        while (posicionBuscada != -1) {
            System.out.printf("%d, ", posicionBuscada); //imprimir los lugares donde se ha encontrado el caracter buscado
            ocurrencias++;
            posicionBuscada += cadenaBuscada.length(); //Sumar la longitud para asegurarse que no se cuente la misma ocurrencia
            posicionBuscada = cadenaOrigen.indexOf(cadenaBuscada, posicionBuscada); //Actualizar la nueva posicion buscada para buscar la siguiente ocurrencia
        }

        cadenaBuscada = cadenaBuscada.strip();
        System.out.printf("hay %d ocurrencias del caracter \"%s\".%n", ocurrencias, cadenaBuscada);
    }
}
