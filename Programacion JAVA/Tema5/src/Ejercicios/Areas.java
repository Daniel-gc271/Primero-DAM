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
public class Areas {

    private static void displayMenu() {
        System.out.println(
                "Calculadora de areas\n"
                + "Selecciona que area deseas calcular:\n"
                + "\t 1. Circulo\n"
                + "\t 2. Cuadrado\n"
                + "\t 3. Rectangulo\n"
                + "\t 4. Triangulo\n"
                + "\t 5. Salir"
        );
    }

    private static double calcularAreaCirculo(double radio) {
        double areaCirculo;
        areaCirculo = Math.PI * Math.pow(radio, 2);
        return areaCirculo;
    }

    private static double calcularAreapoligono(double base, double altura, int calculo) {

        if (calculo != 4) {
            return base * altura;
        } else {
            return base * altura / 2.0;
        }
    }

    private static int seleccion(Scanner scIn) {
        boolean entradaIncorrecta=true;
        int eleccionUsuario=0;
        do {
            System.out.println("Selecciona una opcion del menu");
            try {
            eleccionUsuario = scIn.nextInt();
            if (eleccionUsuario == 5) {
                System.out.println("Finalizando programa");
                scIn.close();
                System.exit(0);
            }
            if (eleccionUsuario < 1 || eleccionUsuario > 5) {
               entradaIncorrecta=true;
            } else {entradaIncorrecta=false;}
        } catch (Exception ex) {
            scIn.nextLine();
            System.err.println("Debes introducir un numero!");
            entradaIncorrecta=true;
        } 
        
        } while (entradaIncorrecta);
        return eleccionUsuario;

    }

    private static void ProcesarEleccion(int eleccion, Scanner scIn) {
        
       

    }

    public static void main(String[] args) {
        Scanner scIn = new Scanner(System.in);
        displayMenu();
        int eleccion = seleccion(scIn);

    }
}
