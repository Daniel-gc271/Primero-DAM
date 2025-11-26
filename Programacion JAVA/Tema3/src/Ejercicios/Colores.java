/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicios;

/**
 *
 * @author goncalda
 */


public class Colores {
    public static void main(String[] args) {
        final String RESET = "\u001B[0m";
        final String RED = "\u001B[31m";
        final String GREEN = "\u001B[32m";
        final String YELLOW = "\u001B[33m";
        final String BLUE = "\u001B[34m";
        final String PURPLE = "\u001B[35m";
        final String CYAN = "\u001B[36m";
        final String WHITE = "\u001B[37m";

        final String BOLD = "\u001B[1m";
        final String UNDERLINE = "\u001B[4m";

        System.out.println(RED + "Rojo" + RESET);
        System.out.println(GREEN + "Verde" + RESET);
        System.out.println(YELLOW + "Amarillo" + RESET);
        System.out.println(BLUE + "Azul" + RESET);
        System.out.println(PURPLE + "Morado" + RESET);
        System.out.println(CYAN + "Cian" + RESET);
        System.out.println(WHITE + "Blanco" + RESET);

        System.out.println(BOLD + RED + "Rojo en negrita" + RESET);
        System.out.println(UNDERLINE + BLUE + "Azul subrayado" + RESET);
    }
}

