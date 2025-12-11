/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicios;

/**
 *
 * @author macarena
 */
import java.util.Scanner;

public class Cajero {

    public static void main(String[] args) {
        UtilidadesCajero uc = new UtilidadesCajero();
        Scanner sc = new Scanner(System.in);
        double saldo = 0;
        int opcion;

        do {
            opcion = showMenu(sc);
            switch (opcion) {
                case 1 -> {
                    saldo = uc.ingresarPasta(saldo, sc);
                }
                case 2 -> {
                    saldo = uc.retirarPasta(saldo, sc);
                }
                case 3 ->
                    System.out.println("Saldo actual: " + saldo);
                default -> {
                }
            }
        } while (opcion != 4);
    }


    private static int showMenu(Scanner sc) {
        System.out.println("1. Ingresar dinero");
        System.out.println("2. Retirar dinero");
        System.out.println("3. Consultar saldo");
        System.out.println("4. Salir");
        return sc.nextInt();
    }

   
}
