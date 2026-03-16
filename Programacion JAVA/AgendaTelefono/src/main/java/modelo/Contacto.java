/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;

import java.util.HashMap;


/**
 *
 * @author goncalda
 */
public class Contacto {

    private LocalDateTime fechaAñadido,fechacumpleaños;
    private String nombre,apellido1,apellido2,correo, descripcion;
    private int numTelf;
    private HashMap<String,String> socials = new HashMap<>();
    private ArrayList<Contacto> listaContactos = new ArrayList<>();

    public Contacto( String nombre, int numTelf) {
        this.fechaAñadido =LocalDateTime.now();
        this.nombre = nombre;
        this.numTelf = numTelf;
    }

   
            

    
}
