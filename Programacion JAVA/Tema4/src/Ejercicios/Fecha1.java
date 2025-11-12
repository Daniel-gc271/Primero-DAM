/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicios;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author goncalda
 */
public class Fecha1 {
     public static void main(String[] args) {
        Scanner scIn = new Scanner(System.in);
        Boolean fechaIncorrecta=null;
        Date parsedDate=null;
        DateFormat dfParse = new SimpleDateFormat("dd/MM/yyyy");
        dfParse.setLenient(false);
        DateFormat dfShort = DateFormat.getDateInstance(DateFormat.SHORT);
        DateFormat dfLong = DateFormat.getDateInstance(DateFormat.LONG);
        do {String rawDate = pideFecha(scIn);
            try {
                parsedDate = dfParse.parse(rawDate);
                fechaIncorrecta=false;
                
                        } catch (ParseException ex) {
                            System.err.println("Has introducido una fecha invalida");
                            fechaIncorrecta=true;
            }
            
        
        } while(fechaIncorrecta);
         System.out.println("Fecha corta: "+dfShort.format(parsedDate));
         System.out.println("Fecha larga: "+dfLong.format(parsedDate));
    }
     private static String pideFecha(Scanner scIn)
     {  String fecha=new String();
        System.out.println("Introduce el dia de tu nacimiento");
        fecha += scIn.nextLine()+"/";
        System.out.println("Introduce el mes de tu nacimiento");
        fecha += scIn.nextLine()+"/";
        System.out.println("Introduce el año de tu nacimiento");
        fecha += scIn.nextLine();
        return fecha;
     }
     
}
