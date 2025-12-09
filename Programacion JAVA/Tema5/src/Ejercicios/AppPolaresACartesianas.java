/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicios;
/**
 *
 * @author goncalda
 */
public class AppPolaresACartesianas {
    public static void main(String[] args) {
        
        {
           menu();
            
        
        }
        
        
    }
    private static void menu() {
    //Estatico porque no depende de ningun estado de ningun otro objeto o instancia
    //Es un metodo de sporte que sirve para mostrar el menu
        System.out.printf("Convertidor de coordenadas polares al sistema cartesiano"
                + "Instrucciones:"
                + "\tDebes introducir tu angulo en grados\n"
                + "\tLa distancia no debe ser negativa\n"
                + "Opciones:\n"
                + "\t1) Pasar de coordenadas polares a cartesianas\n"
                + "\t2) Pasar de coordenadas cartesianes a polares\n"
                + "\t3) Salir\n");
    
    }
    
    
}
