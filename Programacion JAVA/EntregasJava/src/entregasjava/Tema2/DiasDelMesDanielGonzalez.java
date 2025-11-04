/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entregasjava.Tema2;

import java.util.Scanner;

/**
 *
 * @author goncalda
 */
public class DiasDelMesDanielGonzalez {

    public static void main(String[] args) {
        Scanner scIn = new Scanner(System.in);
        byte mes;
        do {
            System.out.println("Introduce el numero del mes del que quieras conocer sus dias");
            mes = scIn.nextByte();
        } while (mes < 1 || mes > 12);
        if (mes == 2) {
            System.out.println("Tiene 28 dias");
        } else if (mes % 2 == 0) {
            System.out.println("Tiene 30 dias");
        } else {
        System.out.println("Tiene 31 dias");
        }
        scIn.close();
    }
}
