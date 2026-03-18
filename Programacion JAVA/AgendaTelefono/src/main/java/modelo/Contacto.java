/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
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
        if (numTelf.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El telefono no puede estar vacio", "ERROR", 1);
        }
        this.lstNumTelf = numTelf;
        this.nombre = nombre;

        compContacto = Comparator.comparing((Contacto c) -> 0);
    }

    public void ordenarNombreAsc(ArrayList<Contacto> listaContactos) {
        Collections.sort(listaContactos,
                compContacto.
                        thenComparing(Contacto::getNombre).
                        thenComparing(Contacto::getApellido1).
                        thenComparing(Contacto::getApellido2)
        );
    }

    public void ordenarNombreDesc(ArrayList<Contacto> listaContactos) {
        Collections.sort(listaContactos,
                compContacto.
                        thenComparing(Contacto::getNombre).
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
        sb.append("\nNombre: ").append(nombre).append('\n');
        if (apellido1 != null || !apellido1.isEmpty() || !apellido1.isBlank()) {
            sb.append("Primer apellido: ").append(apellido1).append('\n');
        }
        if (apellido2 != null || !apellido2.isEmpty() || !apellido2.isBlank()) {
            sb.append("Segundo apellido: ").append(apellido2).append('\n');
        }
        if (fechacumpleaños != null) {
            sb.append("Cumplea\u00f1os: ").append(fechacumpleaños);
        }

        sb.append("Numeros de contacto:\n");
        for (String string : lstNumTelf) {
            sb.append(string).append(" ");
        }

        if (correo != null) {
            if (!correo.isBlank()) {
                sb.append('\n').append("Email: ").append(correo).append('\n');
            }
        }
        if (descripcion != null) {
            if (!descripcion.isBlank()) {
                sb.append("Descripcion: ").append(descripcion);
            }
        }
        sb.append('\n');
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

        if (correo.matches(regexEmail)) {
            this.correo = correo.toLowerCase();
        } else {
            throw new Exception();
        }

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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.fechaAñadido);
        hash = 59 * hash + Objects.hashCode(this.fechacumpleaños);
        hash = 59 * hash + Objects.hashCode(this.nombre);
        hash = 59 * hash + Objects.hashCode(this.apellido1);
        hash = 59 * hash + Objects.hashCode(this.apellido2);
        hash = 59 * hash + Objects.hashCode(this.correo);
        hash = 59 * hash + Objects.hashCode(this.descripcion);
        hash = 59 * hash + Objects.hashCode(this.lstNumTelf);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Contacto other = (Contacto) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apellido1, other.apellido1)) {
            return false;
        }
        if (!Objects.equals(this.apellido2, other.apellido2)) {
            return false;
        }
        if (!Objects.equals(this.correo, other.correo)) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        if (!Objects.equals(this.fechaAñadido, other.fechaAñadido)) {
            return false;
        }
        if (!Objects.equals(this.fechacumpleaños, other.fechacumpleaños)) {
            return false;
        }
        return Objects.equals(this.lstNumTelf, other.lstNumTelf);
    }

    /**
     *
     * @param listContactos la lista de la que buscar
     * @param nombre 
     * @return
     */
    public ArrayList<Contacto> buscarContacto(HashMap<?, Contacto> listContactos, String nombre) {
        ArrayList<Contacto> coincidencias = new ArrayList<>();
        for (Contacto contacto : listContactos.values()) {
            if (contacto.getNombre().toUpperCase().contains(nombre.toUpperCase())) {
                coincidencias.add(contacto);
            }
        }
        return coincidencias;
    }
    public ArrayList<Contacto> buscarMailContacto(HashMap<?, Contacto> listContactos, String mail) {
        ArrayList<Contacto> coincidencias = new ArrayList<>();
        for (Contacto contacto : listContactos.values()) {
            if (contacto.getCorreo().toUpperCase().contains(mail.toUpperCase())) {
                coincidencias.add(contacto);
            }
        }
        return coincidencias;
    }
    
    public ArrayList<Contacto> buscarContacto(HashMap<?, Contacto> listContactos, String nombre, String apellido1) {
        ArrayList<Contacto> coincidencias = new ArrayList<>();
        for (Contacto contacto : listContactos.values()) {
            if (contacto.getNombre().toUpperCase().contains(nombre.toUpperCase())||contacto.getApellido1().toUpperCase().contains(apellido1.toUpperCase())) {
                coincidencias.add(contacto);
            }
        }
        return coincidencias;
    }
    public ArrayList<Contacto> buscarContacto(HashMap<?, Contacto> listContactos, String nombre, String apellido1, String apellido2) {
        ArrayList<Contacto> coincidencias = new ArrayList<>();
        for (Contacto contacto : listContactos.values()) {
            if (contacto.getNombre().toUpperCase().contains(nombre.toUpperCase())||contacto.getApellido1().toUpperCase().contains(apellido1.toUpperCase())||contacto.getApellido2().toUpperCase().contains(apellido2.toUpperCase())) {
                coincidencias.add(contacto);
            }
        }
        return coincidencias;
    }
}
