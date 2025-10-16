/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Actividades;

import java.util.Scanner;

/**
 *
 * @author Daniel González
 */
public class DiasDelMes {

    public static void main(String[] args) {
        Scanner scIn = new Scanner(System.in);
        System.out.println("Introduce el numero de un mes para conocer los dias que tiene");
        byte Mes = scIn.nextByte();
        String Mensaje
                //Febrebro 28 dias
                //Meses pares (excepto febrero) 30 dias
                //Meses impares 31 dias
                = ((Mes) < 1) ? "El numero debe ser positivo"
                : ((Mes) >= 12) ? "Solo hay 12 meses animal!"
                : ((Mes) == 2) ? "Tiene 28"
                : ((Mes) % 2 != 0) ? "Tiene 31" : "Tiene 30";
        System.out.println(Mensaje);

    }
}
