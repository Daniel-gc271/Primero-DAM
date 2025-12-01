/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Scanner;

/**
 *
 * @author goncalda
 */

import java.time.temporal.ChronoUnit;

public class Fecha2 {
    public static void main(String[] args) {
        Scanner scIn = new Scanner(System.in);

        // Formato esperado: dd/MM/yyyy
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);

        System.out.print("Introduce la fecha (dd/MM/yyyy): ");
        String fechaTexto = scIn.nextLine();

        // Parsear la fecha introducida
        LocalDate fechaIntroducida = LocalDate.parse(fechaTexto, formatter);

        // Fecha actual
        LocalDate fechaActual = LocalDate.now();

        // Calcular diferencia en días
        long diasTranscurridos = ChronoUnit.DAYS.between(fechaIntroducida, fechaActual);

        System.out.println("Han transcurrido " + diasTranscurridos + " días desde " + fechaIntroducida + " hasta hoy.");

        scIn.close();
    }
}

