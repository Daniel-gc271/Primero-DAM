/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 *
 * @author goncalda
 */
public class Contacto {

    private final Comparator<Contacto> compContacto;
    private final LocalDateTime fechaAñadido;
    private LocalDateTime fechacumpleaños;
    private String nombre, apellido1, apellido2, correo, descripcion;
    ArrayList<String> lstNumTelf;
//    private HashMap<String, String> socials = new HashMap<>();

    public Contacto(String nombre, String numTelf) {
        this.fechaAñadido = LocalDateTime.now();
        if (nombre == null || nombre.isBlank()||nombre.length()==0) {
            System.out.println("Pene1");
            JOptionPane.showMessageDialog(null, "El nombre no puede estar vacio", "ERROR", 1);}
        if (numTelf == null ||numTelf.isBlank()||numTelf.length()==0) {
                        System.out.println("Pene2");

            JOptionPane.showMessageDialog(null, "El teléfono no puede estar vacio", "ERROR", 1);}
        this.nombre = nombre;
        this.lstNumTelf.add(numTelf);
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

    public void ordenarFechaAsc(ArrayList<Contacto> listaContactos) {
        Collections.sort(listaContactos,
                compContacto.
                        thenComparing(Contacto::getFechaAñadido));
    }

    public void ordenarFechaDesc(ArrayList<Contacto> listaContactos) {
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(nombre).append(" ");
        sb.append(apellido1).append(" ");
        sb.append(apellido2).append(" ");
      
        sb.append("Cumplea\u00f1os: ").append(fechacumpleaños);
        return sb.toString();
    }

    public String contactoShort() {
        return nombre + apellido1;
    }

}
