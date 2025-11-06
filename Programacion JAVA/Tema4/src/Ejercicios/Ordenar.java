/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicios;

import java.util.Scanner;

/**
 *
 * @author Daniel González
 */
public class Ordenar {

    public static void main(String[] args) {
        Scanner scIn = new Scanner(System.in);
        System.out.println("Introduce por consola dos palabras que quieras ordenar alfabéticamente");
        String s3 = new String(scIn.nextLine());
        String s1;
        String s2;
        while (s3.isBlank()) {System.err.println("Debes introducir una lista valida");s3=scIn.nextLine();}
        s3=s3.strip();
        
        //Bucle que reemplaza todas las instancias de dos espacios por un espacio y se repite hasta que no contenga dos espacios
        do {
            s3 = s3.replace("  ", " "); 
        } while (s3.contains("  "));
        s1=s3.substring(0, s3.indexOf(" "));
        s2=s3.substring(s3.indexOf(" "),s3.length());
        System.out.println(s1);
        System.out.println(s2);
        int orden = s1.compareTo(s2);
        
        if (orden>0) {System.out.printf("%s es anterior a %s alfabeticamente hablando",s1,s2);}
         

    }
}
