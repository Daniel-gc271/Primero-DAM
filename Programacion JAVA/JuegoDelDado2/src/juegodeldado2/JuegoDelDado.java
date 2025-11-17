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

    //Metodo para validar si el jugador introduce si o no
    private static boolean validarEntrada(Scanner scIn) {
        //Bucle para la validacion de entrada
        String entrada;
        entrada = scIn.nextLine();
        do {
            if (!(entrada.equalsIgnoreCase("S") || entrada.equalsIgnoreCase("N")) && !entrada.isBlank()) {
                System.err.printf("Has introducido %s,debes introducir (S o N)%n", entrada);
                entrada = scIn.nextLine();
            } else if (entrada.isBlank()) {
                System.err.println("No has introducido nada,debes introducir S o N");
                entrada = scIn.nextLine();
            }

        } while (entrada.isBlank() || !(entrada.equalsIgnoreCase("S") || entrada.equalsIgnoreCase("N")));
        return entrada.equalsIgnoreCase("S");
    }
    
    private static boolean tiradaInicial(Random numAleatorio) {
        System.out.println("Tirada inicial");
        int tiradaJugador = numAleatorio.nextInt(2, 13);
        int tiradaMaquina = numAleatorio.nextInt(2, 13);
        do {
            System.out.printf("Habeis sacado lo mismo (%d), volviendo a tirar%n", tiradaJugador);
            tiradaMaquina = numAleatorio.nextInt(2, 13);
            tiradaJugador = numAleatorio.nextInt(2, 13);
        } while (tiradaJugador == tiradaMaquina);
        if (tiradaJugador > tiradaMaquina) {
            System.out.println("Enhorabuena, sales tú");
            return true;
        } else {
            System.out.println("Que pena, sale la máquina");
            return false;
        }
    }
    public static void main(String[] args) {
        Random numAleatorio = new Random();
        Scanner scIn = new Scanner(System.in);
        //Inicializar variables a los valores iniciales para preparar el juego

        boolean tuTurno;
        boolean seguirJugando = true;
        int boteBanca = 0;
        int boteJugador = 100;
        int boteMaquina = 100;
        int tiradaJugador;
        int tiradaMaquina;
        int punto = 0;
        boolean esTiradaSalida = true;
        //Inicio del programa que explica (o no) como jugar
        System.out.println("Bienvenido al casino de ciudad Malvalona");
        System.out.println("Aqui es típico jugar a un juego llamado el juego de los dados");
        System.out.println("Sabes jugar? (S o N)");

        if (validarEntrada(scIn)) {
        } else {
            explainRules();
        }
        //Tirada inicial: sale quien obtenga la puntuacion más alta
        tuTurno = tiradaInicial(numAleatorio);
        //tuTurno = true;Debug quitar para que funcione
        //System.out.println((tuTurno ? "Te toca a ti" : "Le toca a la máquina"));
        //quitar tb porque el metodo que se encarga de manejar la tirada inicial
        //ya indica de quien es el turno
        do {
            esTiradaSalida = true;

            //Bucle del juego que se repite hasta que uno de los dos jugadores se queda sin dinero
            while (tuTurno && boteJugador >= 15 && seguirJugando) {
                tiradaJugador = numAleatorio.nextInt(2, 13);
                if (esTiradaSalida) {
                    System.out.printf("Tirada inicial: %d%n", tiradaJugador);
                    if (tiradaJugador == 7 || tiradaJugador == 11 && esTiradaSalida) {
                        System.out.printf("Ganas automáticamente%n", tiradaJugador);
                        boteMaquina -= 15;
                        boteJugador += 15;
                        tuTurno = false;
                        System.out.printf("Bote jugador: %d%nBote maquina: %d%nBote banca: %d%n", boteJugador, boteMaquina, boteBanca);
                        System.out.println("Le toca a la máquina");
                    } else if (tiradaJugador == 2 || tiradaJugador == 3 || tiradaJugador == 12 && esTiradaSalida) {
                        System.out.printf("Pierdes automáticamente%n", tiradaJugador);
                        boteJugador -= 15;
                        boteMaquina += 15;
                        tuTurno = false;
                        System.out.printf("Bote jugador: %d%nBote maquina: %d%nBote banca: %d%n", boteJugador, boteMaquina, boteBanca);
                        System.out.println("Le toca a la máquina");

                    } else {
                        punto = tiradaJugador;
                        esTiradaSalida = false;
                    }
                } else {
                    System.out.printf("Punto: %d    Tirada para el punto: %d%n", punto, tiradaJugador);
                    if (tiradaJugador == 7) {
                        System.out.printf("Has perdido%n");
                        boteJugador -= 15;
                        boteBanca += 15;
                        tuTurno = false;
                        System.out.printf("Bote jugador: %d%nBote maquina: %d%nBote banca: %d%n", boteJugador, boteMaquina, boteBanca);

                        System.out.println("Le toca a la máquina");
                    } else if (tiradaJugador == punto) {
                        System.out.printf("Has ganado%n");
                        boteJugador += 15;
                        boteMaquina -= 15;
                        tuTurno = false;
                        System.out.printf("Bote jugador: %d%nBote maquina: %d%nBote banca: %d%n", boteJugador, boteMaquina, boteBanca);
                        System.out.println("Le toca a la máquina");

                    }

                }

            }
            if (boteJugador >= 15 || boteMaquina >= 15) {
                System.out.println("Seguir jugando (S o N)?");
                seguirJugando = validarEntrada(scIn);
            } else {
            }

            esTiradaSalida = true;
            while (!tuTurno && boteMaquina >= 15 && seguirJugando) {
                tiradaMaquina = numAleatorio.nextInt(2, 13);
                if (esTiradaSalida) {
                    System.out.printf("Tirada inicial: %d%n", tiradaMaquina);
                    if (tiradaMaquina == 7 || tiradaMaquina == 11 && esTiradaSalida) {
                        System.out.printf("Gano automáticamente%n", tiradaMaquina);
                        boteJugador -= 15;
                        boteMaquina += 15;
                        tuTurno = true;
                        System.out.printf("Bote jugador: %d%nBote maquina: %d%nBote banca: %d%n", boteJugador, boteMaquina, boteBanca);
                        if (seguirJugando) {
                            System.out.println("Le toca al jugador");
                        }

                    } else if (tiradaMaquina == 2 || tiradaMaquina == 3 || tiradaMaquina == 12 && esTiradaSalida) {
                        System.out.printf("Pierdo automáticamente%n");
                        boteMaquina -= 15;
                        boteJugador += 15;
                        tuTurno = true;
                        System.out.printf("Bote jugador: %d%nBote maquina: %d%nBote banca: %d%n", boteJugador, boteMaquina, boteBanca);
                        System.out.printf("Bote jugador: %d%nBote maquina: %d%nBote banca: %d%n", boteJugador, boteMaquina, boteBanca);
                        if (seguirJugando) {
                            System.out.println("Le toca al jugador");
                        }

                    } else {
                        punto = tiradaMaquina;
                        esTiradaSalida = false;
                    }
                } else {
                    System.out.printf("Punto: %d    Tirada para el punto: %d%n", punto, tiradaMaquina);
                    if (tiradaMaquina == 7) {
                        System.out.printf("He perdido%n");
                        boteMaquina -= 15;
                        boteBanca += 15;
                        tuTurno = true;
                        System.out.printf("Bote jugador: %d%nBote maquina: %d%nBote banca: %d%n", boteJugador, boteMaquina, boteBanca);

                        if (seguirJugando) {
                            System.out.println("Le toca al jugador");
                        }
                    } else if (tiradaMaquina == punto) {
                        System.out.printf("He ganado%n");
                        boteJugador -= 15;
                        boteMaquina += 15;
                        tuTurno = true;
                        System.out.printf("Bote jugador: %d%nBote maquina: %d%nBote banca: %d%n", boteJugador, boteMaquina, boteBanca);

                        if (seguirJugando) {
                            System.out.println("Le toca al jugador");
                        }
                    }

                }

            }
            if (boteJugador >= 15 || boteMaquina >= 15) {
                System.out.println("Juegas (S o N)?");
                seguirJugando = validarEntrada(scIn);
            } else {
            }
        } while ((boteJugador >= 15 || boteMaquina >= 15) && seguirJugando);

    }

    
}
