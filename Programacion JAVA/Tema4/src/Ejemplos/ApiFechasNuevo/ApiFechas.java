/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejemplos.ApiFechasNuevo;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Scanner;
import java.lang.Exception;

/**
 *
 * @author goncalda
 */
public class ApiFechas {

    public static void main(String[] args) {
        Scanner scIn = new Scanner(System.in);
        LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter dtfLong = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        DateTimeFormatter dtfMed = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
        System.out.println(fechaActual);

        System.out.println("Introduce tu fecha de nacimiento");
        LocalDate fechaNacimiento = getDate(scIn);

        System.out.printf("Fecha de nacimiento sin formato: " + fechaNacimiento + '\n');
        String fechaFormateada = dtfLong.format(fechaNacimiento);
        System.out.println("Formato long: " + fechaFormateada);
        fechaFormateada = dtfMed.format(fechaNacimiento);
        System.out.println("Formato medium: " + fechaFormateada);

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
