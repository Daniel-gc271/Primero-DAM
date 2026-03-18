/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import java.util.HashSet;
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
    HashSet<String> lstNumTelf;
//    private HashMap<String, String> socials = new HashMap<>();

    public Contacto(String nombre, HashSet<String> numTelf) {
        this.fechaAñadido = LocalDateTime.now();
        System.out.println("Fecha de contactoAsociada");
        System.out.println("nombre.length()= "+nombre.length());
        
        if (numTelf.isEmpty()) {JOptionPane.showMessageDialog(null, "El telefono no puede estar vacio", "ERROR", 1);}
        this.lstNumTelf = numTelf;
        this.nombre = nombre;

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
        sb.append("Nombre: ").append(nombre).append('\n');
        if (apellido1 != null||apellido1.isEmpty()||apellido1.isBlank()) {
            sb.append("Primer apellido: ").append(apellido1).append('\n');
        }
        if (apellido2 != null ||apellido2.isEmpty()||apellido2.isBlank()) {
            sb.append("Segundo apellido: ").append(apellido2).append('\n');
        }
        if (fechacumpleaños != null) {
            sb.append("Cumplea\u00f1os: ").append(fechacumpleaños);
        }
        
            sb.append("Numeros de contacto:\n");
            for (String string : lstNumTelf) {
                sb.append(string).append(" ");
            }
        
        if (correo != null||correo.isEmpty()||correo.isBlank()) {
            sb.append('\n').append("Email: ").append(correo).append('\n');
        }
        if (descripcion != null ||descripcion.isEmpty()||descripcion.isBlank()) {
            sb.append("Descripcion: ").append(descripcion).append('\n');
        }
        return sb.toString();
    }

    public LocalDateTime getFechacumpleaños() {
        return fechacumpleaños;
    }

    public void setFechacumpleaños(LocalDateTime fechacumpleaños) {
        this.fechacumpleaños = fechacumpleaños;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido1(String app1) {
        this.apellido1 = app1;
    }

    public void setApellido2(String app2) {
        this.apellido2 = app2;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) throws Exception {
        String regexEmail = "^\\w+@\\w+.\\w+$";
        
        if (correo.matches(regexEmail)) {this.correo = correo; }
        else {throw new Exception();}
        
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String contactoShort() {
        return nombre + apellido1;
    }

}
