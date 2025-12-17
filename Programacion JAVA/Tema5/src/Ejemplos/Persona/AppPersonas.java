/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejemplos.Persona;

import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author macarena
 */
public class AppPersonas {

    public static void main(String[] args) {

        Persona maria=null; 
        System.out.println(">>Construyendo persona");
        maria=new Persona("71232863T","Maria","Perez");
        System.out.println(">>Modificando con setDni");
        maria.setDni("71232863T");
        maria.setSexo('M');
        maria.setTrabaja(true);        
        maria.setFechaNac(LocalDate.of(2000,Month.JANUARY,1));
        System.out.println(maria.getEdad());
        


//        
        

    }

}
