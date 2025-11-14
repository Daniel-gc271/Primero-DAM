/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package juegodeldado2;

/**
 *
 * @author goncalda
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import java.util.Random;
import java.util.Scanner;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author goncalda
 */
public class JuegoDelDado {

    //Metodo que se llama para explicar las reglas (Por legilibilidad del codigo y la salud mental del programador)
    private static void explainRules() {
        System.out.println("Las reglas son las siguientes: ");
        System.out.println("Place holder explicar reglas");
    }

    //Metodo que maneja la tirada inicial y el jugador que empieza (Por legilibilidad del codigo y la salud mental del programador)
    private static boolean tiradaInicial(Random numAleatorio) {
        System.out.println("Tirada inicial");
        int tiradaJugador = numAleatorio.nextInt(1, 13);
        int tiradaMaquina = numAleatorio.nextInt(1, 13);
        do {
            System.out.printf("Has sacado un %d y la máquina ha sacado un %d%n", tiradaJugador, tiradaMaquina);
        } while (tiradaJugador == tiradaMaquina);
        if (tiradaJugador > tiradaMaquina) {
            System.out.println("Enhorabuena, sales tú");
            return true;
        } else {
            System.out.println("Que pena, sale la maquina" );
            return false;
        }
        
    }

    public static void main(String[] args) {
        Random numAleatorio = new Random();
        Scanner scIn = new Scanner(System.in);
        //Inicializar variables a los valores iniciales para preparar el juego
        boolean turno;
        int boteBanca = 0;
        int boteJugador = 100;
        int boteMaquina = 100;
        int tiradaSalida = 0;
        int tiradaJugador = 0;
        int tiradaMaquina = 0;
        String entrada;

        //Inicio del programa que explica (o no) como jugar
        System.out.println("Bienvenido al casino de ciudad Malvalona");
        System.out.println("Aqui es típico jugar a un juego llamado el juego de los dados");
        System.out.println("Sabes jugar? (S o N)");
        entrada = scIn.nextLine();
        //Bucle para la validacion de entrada
        do {
            if (!(entrada.equalsIgnoreCase("S") || entrada.equalsIgnoreCase("N")) && !entrada.isBlank()) {
                System.err.printf("Has introducido %s,debes introducir S o N%n", entrada);
                entrada = scIn.nextLine();
            } else if (entrada.isBlank()) {
                System.err.println("No has introducido nada,debes introducir S o N");
                entrada = scIn.nextLine();
            }

        } while (entrada.isBlank() || !(entrada.equalsIgnoreCase("S") || entrada.equalsIgnoreCase("N")));
        if (entrada.equalsIgnoreCase("N")) {
            explainRules();
        }
        //Tirada inicial: sale quien obtenga la puntuacion más alta

    }

}
