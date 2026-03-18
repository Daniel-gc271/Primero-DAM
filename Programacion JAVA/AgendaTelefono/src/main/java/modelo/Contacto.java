/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import java.util.HashMap;

/**
 *
 * @author goncalda
 */
public class Contacto {

    private Comparator<Contacto> compContacto;
    private LocalDateTime fechaAñadido, fechacumpleaños;
    private String nombre, apellido1, apellido2, correo, descripcion;
    private int numTelf;
    private HashMap<String, String> socials = new HashMap<>();

    public Contacto(String nombre, int numTelf) {
        this.fechaAñadido = LocalDateTime.now();
        this.nombre = nombre;
        this.numTelf = numTelf;
        compContacto = Comparator.comparing((Contacto c) -> 0);
    }

    public void ordenarNombreAsc(ArrayList<Contacto> listaContactos) {
        Collections.sort(listaContactos,
                compContacto.
                        thenComparing(Contacto::getName).
                        thenComparing(Contacto::getApellido1).
                        thenComparing(Contacto::getApellido2)
        );
    }
    public void ordenarNombreDesc(ArrayList<Contacto> listaContactos) {
        Collections.sort(listaContactos,
                compContacto.
                        thenComparing(Contacto::getName).
                        thenComparing(Contacto::getApellido1).
                        thenComparing(Contacto::getApellido2)
        );
        listaContactos.reversed();
    }
    public void ordenarFechaAsc (ArrayList<Contacto> listaContactos) {
        Collections.sort(listaContactos,
                compContacto.
                        thenComparing(Contacto::getFechaAñadido));
    }
    public void ordenarFechaDesc (ArrayList<Contacto> listaContactos) {
        Collections.sort(listaContactos,
                compContacto.
                        thenComparing(Contacto::getFechaAñadido));
        listaContactos.reversed();
    }

    public String getName() {
        return this.nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public LocalDateTime getFechaAñadido() {
        return fechaAñadido;
    }
}
