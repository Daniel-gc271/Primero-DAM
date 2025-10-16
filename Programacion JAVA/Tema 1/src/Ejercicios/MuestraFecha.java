/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicios;
import java.time.LocalDateTime;
import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalTime;


/**
 *
 * @author goncalda
 */
public class MuestraFecha {
    public static void main(String[] args){
        
    LocalDate fecha =  LocalDate.now();
    System.out.println("La fecha actual es: "+fecha);
    
    LocalTime hora =  LocalTime.now();
    System.out.println("La hora actual es: "+hora);
    
    LocalDateTime hoy = LocalDateTime.now();
    System.out.println("La fecha completa actual es: "+hoy);
    
    }
    
}
