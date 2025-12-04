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
                + "\t 5. Salir");
    }

    private static double calcularAreaCirculo(Scanner scIn) {
        double radio = validarMedidas(scIn, "radio para calcular el area del circulo");
        double areaCirculo;
        areaCirculo = Math.PI * Math.pow(radio, 2);
        System.out.printf("El area del circulo es de %s u cuadradas", areaCirculo);
        return areaCirculo;
    }

    private static double calcularAreapoligono(int eleccion, Scanner scIn) {
        double base, altura;
        base = validarMedidas(scIn, "valor para la base");
        altura = validarMedidas(scIn, "valor para la altura");
        if (eleccion != 4) {
            System.out.printf("El area del poligono es de %s u cuadradas", base * altura / 1.0);
            return base * altura;

        } else {
            System.out.printf("El area del triangulo es de %s u cuadradas", base * altura / 2.0);
            return base * altura / 2.0;
        }
    }

    private static int seleccion(Scanner scIn) {
        boolean entradaIncorrecta = true;
        int eleccionUsuario = 0;
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
                    entradaIncorrecta = true;
                } else {
                    entradaIncorrecta = false;
                }
            } catch (Exception ex) {
                scIn.nextLine();
                System.err.println("Debes introducir un numero!");
                entradaIncorrecta = true;
            }

        } while (entradaIncorrecta);
        return eleccionUsuario;

    }

    private static double validarMedidas(Scanner scIn, String msg) {
        boolean entradaIncorrecta = true;
        double medidaIntroducida = 0;
        System.out.println("Introduce un " + msg);
        while (entradaIncorrecta) {
            try {
                medidaIntroducida = scIn.nextDouble();
                if (medidaIntroducida <= 0) {
                    System.err.println("Debes introducir un numero positivo!");
                    entradaIncorrecta = true;
                } else {
                    entradaIncorrecta = false;

                }
            } catch (Exception ex) {
                scIn.nextLine();
                System.err.println("Debes introducir un numero positivo!");
                entradaIncorrecta = true;
            }

        }
        return medidaIntroducida;

    }

    // private static void ProcesarEleccion(int eleccion, Scanner scIn) {
    //     if (eleccion == 1){}
    // }
    public static void main(String[] args) {
        Scanner scIn = new Scanner(System.in);
        displayMenu();
        int eleccion = seleccion(scIn);
        if (eleccion == 1) {
            calcularAreaCirculo(scIn);
        } else {
            calcularAreapoligono(eleccion, scIn);
        }
        scIn.close();
        System.out.println("");

    }
}
