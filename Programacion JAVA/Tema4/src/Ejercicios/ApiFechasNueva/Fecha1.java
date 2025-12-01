/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicios.ApiFechasNueva;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Scanner;

/**
 *
 * @author goncalda
 */
public class Fecha1 {

    public static void main(String[] args) {
        Scanner scIn = new Scanner(System.in);
        LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter dtfFull = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        DateTimeFormatter dtfMed = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
        DateTimeFormatter dtfShort = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        System.out.println(fechaActual);

        System.out.println("Introduce tu fecha de nacimiento");
        LocalDate fechaNacimiento = getDate(scIn);

        System.out.printf("Fecha de nacimiento sin formato: " + fechaNacimiento + '\n');
        String fechaFormateada = dtfFull.format(fechaNacimiento);
        System.out.println("Formato long: " + fechaFormateada);
        fechaFormateada = dtfMed.format(fechaNacimiento);
        System.out.println("Formato medium: " + fechaFormateada);
        fechaFormateada = dtfShort.format(fechaNacimiento);
        System.out.println("Formato short: " + fechaFormateada);

    }

    //Validacion de fechas
private static LocalDate getDate(Scanner scIn) {
    LocalDate fechaNacimiento = null;
    boolean fechaIncorrecta;

    do {
        fechaIncorrecta = false;
        try {
            System.out.print("\tDía: ");
            int dia = Integer.parseInt(scIn.nextLine().trim());
            System.out.print("\tMes: ");
            int mes = Integer.parseInt(scIn.nextLine().trim());
            System.out.print("\tAño: ");
            int año = Integer.parseInt(scIn.nextLine().trim());

            fechaNacimiento = LocalDate.of(año, mes, dia);

        } catch (NumberFormatException e) {
            System.err.println("Entrada incorrecta, Introduce números");
            fechaIncorrecta = true;
        } catch (DateTimeException e) {
            System.err.println("Fecha incorrecta, Introducela de nuevo.");
            fechaIncorrecta = true;
        }
    } while (fechaIncorrecta);

    return fechaNacimiento;
}

}