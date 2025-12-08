/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicios.FechasNuevas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Scanner;

/**
 *
 * @author Daniel González
 */
public class Fechas12 {

    public static void main(String[] args) {
        Scanner scIn = new Scanner(System.in);
        DateTimeFormatter dtfShort = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter dtfLong = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
                boolean fechaIncorrecta = true;
                LocalDate fechaFactura = LocalDate.now();
        do {
        System.out.println("Por favor introduce la fecha de tu factura en formato dd/mm/AAAA");

            try {
                String fechaIntroducida = scIn.nextLine();
                fechaFactura = LocalDate.parse(fechaIntroducida, dtfShort);
                fechaIncorrecta=false;
            } catch (Exception ex) {fechaIncorrecta=true;
            }

        } while (fechaIncorrecta);

        System.out.println("La fecha que has introducido de la factura es: " + dtfShort.format(fechaFactura));
        System.out.println("Por favor introduce el termino de pago:\n7D\t14D\t3x30");
        String periodoPago = (validarPeriodoPago(scIn));
        System.out.println("Ha seleccionado el termino de pago: " + periodoPago);
        long importeTotalFactura = 0;
        do {
            try {

                System.out.println("Introduce la cuantia de la factura en € sin las unidades solo un numero");
                importeTotalFactura = scIn.nextLong();
                if (importeTotalFactura <= 0) {
                    System.err.println("El importe debe ser mayor a 0");
                    importeTotalFactura = scIn.nextLong();
                }
            } catch (Exception ex) {
                importeTotalFactura = -1;
            }
        } while (importeTotalFactura <= 0);
        switch (periodoPago.charAt(0)) {
            case '7' -> {
                System.out.printf("Deberas pagar %d€ el dia: %s", importeTotalFactura, dtfLong.format(fechaFactura.plusDays(7)));
            }
            case '1' -> {
                System.out.printf("Deberas pagar %d€ el dia: %s", importeTotalFactura, dtfLong.format(fechaFactura.plusDays(14)));
            }
        }
        LocalDate fechaVto1 = fechaFactura.plusDays(30);
        LocalDate fechaVto2 = fechaVto1.plusDays(30);
        LocalDate fechaVto3 = fechaVto2.plusDays(30);
        int[] proporcionPagos = new int[3];
        int sigmaRepartoPagos = 0;
        do {
                sigmaRepartoPagos = 0;
            for (int i = 0; i < 3; i++) {
                System.out.println("Introduce el reparto de pagos en porcentaje sin el simbolo %");
                proporcionPagos[i] = scIn.nextInt();
                sigmaRepartoPagos += proporcionPagos[i];
            }
                if (sigmaRepartoPagos == 99) {
                    break;
                }
        } while (sigmaRepartoPagos != 100);
        if (sigmaRepartoPagos == 99) {
            proporcionPagos[2] = proporcionPagos[2] + 1;
        }
        System.out.printf("Deberas pagar la factura en los siguientes términos: \n\t%f€ el dia %s\n\t%f€ el dia %s\n\t%f€ el dia %s\n", (double) importeTotalFactura * proporcionPagos[0] / 100, dtfLong.format(fechaVto1), (double) importeTotalFactura * proporcionPagos[1] / 100, dtfLong.format(fechaVto2), (double) importeTotalFactura * proporcionPagos[2] / 100, dtfLong.format(fechaVto3)
                
        );
    }

    private static String validarPeriodoPago(Scanner scIn) {
        String entrada = new String(scIn.nextLine());
        if (entrada.contentEquals("7D") || entrada.contentEquals("14D") || entrada.contentEquals("3x30")) {
            return entrada;
        } else {
            System.err.printf("Has introducido: %s\nDebes seleccionar entre: \n\t7D\n\t14D\n\t3x30\n", entrada);
            return validarPeriodoPago(scIn);
        }
    }
}
