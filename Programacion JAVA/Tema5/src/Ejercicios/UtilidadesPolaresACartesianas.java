/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicios;

import java.util.Scanner;

/**
 *
 * @author goncalda
 */
public class UtilidadesPolaresACartesianas {
    public double degreeToRadian (double grados) {
    return (grados%360)*180/Math.PI;
    }
    public double calcularCoordenadaX(double radio, double angulo) {
    return Math.cos(angulo)*radio;
    }
    public double calcularCoordenadaY(double radio, double angulo) {
    return Math.sin(angulo)*radio;
   
    }
    
    
}
