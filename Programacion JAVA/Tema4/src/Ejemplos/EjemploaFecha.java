/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejemplos;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.*;
import java.util.*;

public class EjemploaFecha {
    public static void main(String[] args) {
        Calendar dayOfBirth = new GregorianCalendar(2007, Calendar.SEPTEMBER, 21);
        Calendar currentDate = new GregorianCalendar();

        Date nacimiento = dayOfBirth.getTime();
        Date fechaActual = currentDate.getTime();

        System.out.println("Fecha raw: " + nacimiento);

        DateFormat dfShort = DateFormat.getDateInstance(DateFormat.SHORT);
        DateFormat dfMedium = DateFormat.getDateInstance(DateFormat.MEDIUM);
        DateFormat dfLong = DateFormat.getDateInstance(DateFormat.LONG);
        DateFormat dfFull = DateFormat.getDateInstance(DateFormat.FULL);

        DateFormat dfCustom = new SimpleDateFormat("EEEEEEEEE dd 'de' MMMMM 'del' yyyy 'a las' HH:mm:ss zzzz");

        System.out.println(dfShort.format(nacimiento));
        System.out.println(dfFull.format(fechaActual));

        // Parsear String a Date
        String fechaCannetRock = "25/07/2025";
        Date fechaTexto = null;
        try {
            DateFormat dfParse = new SimpleDateFormat("dd/MM/yyyy");
            fechaTexto = dfParse.parse(fechaCannetRock);
            System.out.println("Bien chaval");
        } catch (ParseException ex) {
            System.err.println("Fecha inválida");
        }

        System.out.println("Fecha larga: " + dfLong.format(fechaActual));
        System.out.println(dfMedium.format(fechaTexto));
        System.out.println("Fecha custom: " + dfCustom.format(fechaActual));
    }
}

