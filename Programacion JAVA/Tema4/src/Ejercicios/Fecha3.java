/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicios;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author goncalda
 */
public class Fecha3 {
    public static void main(String[] args) {
        Scanner scIn =new Scanner(System.in);
        Calendar fechaActual = new GregorianCalendar();
        long segundos;
        DateFormat dateFormat = SimpleDateFormat(DateFormat.LONG);
        System.out.println("Introduce el numero de segundos que quieres avanzar o retroceder desde la fecha actual (negativo para retroceders)");
        segundos=scIn.nextLong();
        long nouData = (fechaActual.getTime())+(segundos*1000);
        
    }   
}
