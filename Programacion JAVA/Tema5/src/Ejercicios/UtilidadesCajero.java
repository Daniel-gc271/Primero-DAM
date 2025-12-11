/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicios;

/**
 *
 * @author macarena
 */
import java.util.Scanner;

public class UtilidadesCajero {

    
    
    
     public double ingresarPasta(double saldo, Scanner sc) {
        System.out.println("Cantidad a ingres   ar:");
        double cantidad = sc.nextDouble();
        saldo += cantidad;
        System.out.println("Ingreso realizado. Saldo actual: " + saldo);
        return saldo;

    }
    public double retirarPasta(double saldo, Scanner sc) {
        System.out.println("Cantidad a retirar:");
                    double cantidad = sc.nextDouble();
                    if (cantidad <= saldo) {
                        saldo -= cantidad;
                        System.out.println("Retirada realizada. Saldo actual: " + saldo);
                        return saldo;

                    } else {
                        System.out.println("Saldo insuficiente.");
                        return saldo;

                    }
        
    }
    
}
