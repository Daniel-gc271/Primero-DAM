/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejemplos;

import java.util.Random;

/**
 *
 * @author goncalda
 */
public class ApiClases {
    public static void main(String[] args) {
        Random numAleatorio = new Random();
        double degrees=numAleatorio.nextDouble()*360;
        System.out.printf("%f grados equivale a %f radianes%n",degrees,(Math.toRadians(degrees)));
    }
}
