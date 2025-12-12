/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Ejercicios.DadosRefactorizado;

/**
 *
 * @author goncalda
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import Ejercicios.DadosRefactorizado.Player;
import java.util.Random;
import java.util.Scanner;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author goncalda
 */
public class JuegoDelDadoRefactorizado {

    //Metodo que se llama para explicar las reglas (Por legilibilidad del codigo y la salud mental del programador)
    /*
        long tJugado = System.currentTimeMillis();
        Random numAleatorio = new Random();
        Scanner scIn = new Scanner(System.in);
        //Inicializar variables a los valores iniciales para preparar el juego
        int contVictM = 0;
        int contVictJ = 0;
        boolean tuTurno;
        boolean seguirJugando = true;
        int boteBanca = 0;
        int boteJugador = 100;
        int boteMaquina = 100;
        int tiradaJugador;
        int tiradaMaquina;
        int punto = 0;
        boolean esTiradaSalida = true;
        
        
     */
    //Tirada inicial: sale quien obtenga la puntuacion más alta
    //tuTurno = tiradaInicial(numAleatorio);
    //tuTurno = true;Debug quitar para que funcione
    //System.out.println((tuTurno ? "Te toca a ti" : "Le toca a la máquina"));
    //quitar tb porque el metodo que se encarga de manejar la tirada inicial
    //ya indica de quien es el turno
    /*
        do {
            esTiradaSalida = true;

            //Bucle del juego que se repite hasta que uno de los dos jugadores se queda sin dinero
            while (tuTurno && boteJugador >= 15 && boteMaquina >= 15 && seguirJugando) {
                tiradaJugador = numAleatorio.nextInt(2, 13);
                if (esTiradaSalida) {
                    System.out.printf("Tirada inicial: %d%n", tiradaJugador);
                    if (tiradaJugador == 7 || tiradaJugador == 11 && esTiradaSalida) {
                        System.out.printf("Ganas automáticamente%n", tiradaJugador);
                        contVictJ++;
                        boteMaquina -= 15;
                        boteJugador += 15;
                        System.out.printf("Bote jugador: %d%nBote maquina: %d%nBote banca: %d%n", boteJugador, boteMaquina, boteBanca);
                        System.out.println("Sigues jugando (S o N)?");
                        seguirJugando = validarEntrada(scIn);
                    } else if (tiradaJugador == 2 || tiradaJugador == 3 || tiradaJugador == 12 && esTiradaSalida) {
                        System.out.printf("Pierdes automáticamente%n", tiradaJugador);
                        contVictM++;
                        boteJugador -= 15;
                        boteMaquina += 15;
                        tuTurno = false;
                        System.out.printf("Bote jugador: %d%nBote maquina: %d%nBote banca: %d%n", boteJugador, boteMaquina, boteBanca);
                        System.out.println("Le toca a la máquina");
                        System.out.println("Juegas (S o N)?");
                        seguirJugando = validarEntrada(scIn);
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
                        System.out.println("Juegas (S o N)?");
                        seguirJugando = validarEntrada(scIn);
                    } else if (tiradaJugador == punto) {
                        System.out.printf("Has ganado%n");
                        contVictJ++;
                        boteJugador += 15;
                        boteMaquina -= 15;
                        System.out.printf("Bote jugador: %d%nBote maquina: %d%nBote banca: %d%n", boteJugador, boteMaquina, boteBanca);
                        System.out.println("Sigues jugando (S o N)?");
                        seguirJugando = validarEntrada(scIn);
                    }

                }

            }

            esTiradaSalida = true;
            while (!tuTurno && boteJugador >= 15 && boteMaquina >= 15 && seguirJugando) {
                tiradaMaquina = numAleatorio.nextInt(2, 13);
                if (esTiradaSalida) {
                    System.out.printf("Tirada inicial: %d%n", tiradaMaquina);
                    if (tiradaMaquina == 7 || tiradaMaquina == 11 && esTiradaSalida) {
                        System.out.printf("Gano automáticamente%n", tiradaMaquina);
                        contVictM++;
                        boteJugador -= 15;
                        boteMaquina += 15;
                        System.out.printf("Bote jugador: %d%nBote maquina: %d%nBote banca: %d%n", boteJugador, boteMaquina, boteBanca);
                        System.out.println("Le toca a la máquina");
                        System.out.println("Juegas (S o N)?");
                        seguirJugando = validarEntrada(scIn);
                    } else if (tiradaMaquina == 2 || tiradaMaquina == 3 || tiradaMaquina == 12 && esTiradaSalida) {
                        System.out.printf("Pierdo automáticamente%n");
                        contVictJ++;
                        boteMaquina -= 15;
                        boteJugador += 15;
                        tuTurno = true;
                        System.out.printf("Bote jugador: %d%nBote maquina: %d%nBote banca: %d%n", boteJugador, boteMaquina, boteBanca);
                        System.out.println("Te toca");
                        System.out.println("Juegas (S o N)?");
                        seguirJugando = validarEntrada(scIn);

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
                        System.out.println("Te toca");
                        System.out.println("Juegas (S o N)?");
                        seguirJugando = validarEntrada(scIn);

                    } else if (tiradaMaquina == punto) {
                        System.out.printf("He ganado%n");
                        contVictM++;
                        boteJugador -= 15;
                        boteMaquina += 15;
                        tuTurno = true;
                        System.out.printf("Bote jugador: %d%nBote maquina: %d%nBote banca: %d%n", boteJugador, boteMaquina, boteBanca);
                        System.out.println("Le toca a la máquina");
                        System.out.println("Juegas (S o N)?");
                        seguirJugando = validarEntrada(scIn);

                    }

                }

            }

        } while ((boteJugador >= 15 && boteMaquina >= 15) && seguirJugando);
     */
    public static void main(String[] args) {

        Random numAleatorio = new Random();
        Scanner scIn = new Scanner(System.in);
        Banca banca = new Banca();
        Player jugador = new Player("Daniel");
        Player maquina = new Player("CPU");
        
        //Inicio del programa que explica (o no) como jugar
        System.out.println("Bienvenido al casino de ciudad Malvalona");
        System.out.println("Aqui es típico jugar a un juego llamado el juego de los dados");
        System.out.println("Sabes jugar? (S o N)\n>>");

        if (validarEntrada(scIn)) {
        } else {
            explainRules();
        }
        banca.setTurno(tiradaInicial(numAleatorio, jugador, maquina));

        Boolean quiereSeguirJugando;
        System.out.println(jugador.getName() + ", te apetece jugar? (S o N)\n>>");
        quiereSeguirJugando = validarEntrada(scIn);
        do { //Bucle del juego
            banca.setTiradaSalida(true);
            int tirada = 0;
            if (banca.getTiradaSalida()) {
                switch (1) {
                    case 7, 11 -> {

                        
                    }
                    case 2, 3, 12 -> {
                        

                    }
                    default -> {
                        banca.setTiradaSalida(false);
                        
                    }
                }
            } else {
                
                if (tirada == 7) {                    
                
                }      
            
            
            }

            
            
            System.out.println(jugador.getName() + ", quieres seguir jugando? (S o N)\n>>");
            quiereSeguirJugando = validarEntrada(scIn);

        } while (sePuedeSeguirJugando(jugador, maquina) && quiereSeguirJugando);

    }
    //Metodo que muestra las estadisticas finales de la partida

    private static void menuFinPartida(Player humano, Player maquina, long timePlayed, int turnosTotales) {
        String mensaje
                = "***************************"
                + "*******Estadisticas********"
                + "***************************"
                + '\n';
        mensaje
                += mensaje.formatted("Victorias Jugador: %d"
                        + "\tVictorias Maquina%d\n"
                        + " Bote final del jugador: %d"
                        + "\t Bote final de la maquina: %d\n"
                        + "Turnos totales: %d\nTiempo jugado: %dns\tTiempo jugado: %ds",
                        humano.getVictorias(),
                        maquina.getVictorias(),
                        humano.getBote(),
                        maquina.getBote(),
                        turnosTotales,
                        timePlayed, timePlayed / 1000);
        System.out.println(mensaje);
    }

    private static void explainRules() {
        System.out.println("Las reglas son las siguientes: ");
        System.out.println("Se juega con dos dados. Inicialmente cada jugador dispone de un bote de 100 €.");
        System.out.println("Una partida comienza con una primera tirada de dados llamada ”tirada de salida”.");
        System.out.println("Si el jugador obtiene en la \"tirada de salida\" 7 o 11 gana automáticamente y pierde si obtiene 2, 3, o 12.");
        System.out.println("Si obtiene 4, 5, 6, 8, 9 o 10, el número obtenido se convierte en su “punto”.");
        System.out.println("En este caso, para poder ganar debe de salir repetido el “punto” antes de sacar un 7.");
        System.out.println("En caso de que salga 7 antes de que salga el “punto” el jugador pierde.");
        System.out.println("Por tanto, esta ronda termina cuando el jugador lanza los dados y obtiene el “punto” o el número 7.");
        System.out.println("Cada vez que un jugador gana incrementa su bote en 15 €, dinero que sale del bote del jugador perdedor.");
        System.out.println("Si un jugador pierde en su turno, los 15 € se pagan a la banca.");
        System.out.println("Cuando se inicia el juego se realizará una tirada de dados para determinar quién empieza jugando.");
        System.out.println("Empezará el que saque mayor puntuación");
    }

    //Metodo para validar si el jugador introduce si o no
    private static boolean validarEntrada(Scanner scIn) {
        //Bucle para la validacion de entrada
        String entrada;
        entrada = scIn.nextLine();
        do {
            if (!(entrada.equalsIgnoreCase("S") || entrada.equalsIgnoreCase("N")) && !entrada.isBlank()) {
                System.err.printf("Has introducido %s,debes introducir (S o N)%n", entrada);
                System.out.print(">>");
                entrada = scIn.nextLine();
            } else if (entrada.isBlank()) {
                System.err.println("No has introducido nada,debes introducir S o N");
                System.out.print(">>");
                entrada = scIn.nextLine();
            }

        } while (entrada.isBlank() || !(entrada.equalsIgnoreCase("S") || entrada.equalsIgnoreCase("N")));
        return entrada.equalsIgnoreCase("S");
    }

    private static boolean tiradaInicial(Random numAleatorio, Player jugador, Player maquina) {
        System.out.println("Tirada inicial:");
        int tiradaJugador = numAleatorio.nextInt(2, 13);
        int tiradaMaquina = numAleatorio.nextInt(2, 13);
        do {
            System.out.printf("Habeis sacado lo mismo (%d), volviendo a tirar%n", tiradaJugador);
            tiradaMaquina = numAleatorio.nextInt(2, 13);
            tiradaJugador = numAleatorio.nextInt(2, 13);
        } while (tiradaJugador == tiradaMaquina);
        if (tiradaJugador > tiradaMaquina) {
            System.out.printf("Enhorabuena, sale %s (tu) (%d > %d)\n", jugador.getName(), tiradaJugador, tiradaMaquina);
            return true;
        } else {
            System.out.printf("Que pena, sale %s (la máquina) (%d > %d)\n", maquina.getName(), tiradaMaquina, tiradaJugador);
            return false;
        }
    }
    //Devuelve true si se cumple que:
    //El bote del jugador es mayor o igual a su propia apuesta (la apuesta es lo que se pierde cuando pierdes)
    //El bote de la maquina es mayor o igual a su propia apuesta (la apuesta es lo que se pierde cuando pierdes)

    private static boolean sePuedeSeguirJugando(Player jugador, Player maquina) {
        return (maquina.getBote() >= maquina.getApuesta() && jugador.getBote() >= jugador.getApuesta());

    }
}
