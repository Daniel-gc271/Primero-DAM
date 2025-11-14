/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicios;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import static java.util.concurrent.TimeUnit.DAYS;




/**
 *
 * @author goncalda
 */
public class Fecha2 {

    public static void main(String[] args) {
        Scanner scIn = new Scanner(System.in);
        Boolean fechaIncorrecta = null;
        Date parsedDate = null;
        DateFormat dfParse = new SimpleDateFormat("dd/MM/yyyy");
        dfParse.setLenient(false);

        Calendar currentDate = new GregorianCalendar();
        Date fechaActual = currentDate.getTime();

        DateFormat dfShort = DateFormat.getDateInstance(DateFormat.SHORT);
        DateFormat dfLong = DateFormat.getDateInstance(DateFormat.LONG);
        do {
            String rawDate = pideFecha(scIn);
            try {
                parsedDate = dfParse.parse(rawDate);
                fechaIncorrecta = false;

            } catch (ParseException ex) {
                System.err.println("Has introducido una fecha invalida");
                fechaIncorrecta = true;
            }
        } while (fechaIncorrecta);
        long deltaFechas = fechaActual.getTime() - parsedDate.getTime();
        long dias =deltaFechas/(3600*24000);
        System.out.println(dias);
        
            
        }
    

    private static String pideFecha(Scanner scIn) {
        String fecha = new String();
        System.out.println("Introduce la fecha en formato dd/mm/aaaa donde \"d\" es para dia \"m\" para mes y \"a\" para año");
        fecha = scIn.nextLine();
        return fecha;
    }

}
