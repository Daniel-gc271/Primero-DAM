/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejemplos;

/**
 * programa que muestre alternativamente el mensaje hola, adios
 * @author goncalda
 */
public class banderas2 {
    public static void main(String[] args) {
        boolean mensaje = true;
        while (true) {
            String msg = (mensaje)? "Hola":"Adios";
            System.out.println(msg); 
            mensaje = !mensaje;
        
        
        }
    }
}
