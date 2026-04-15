/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 *
 * @author goncalda
 */
public class ContactoCp {

    private LocalDateTime fechaAñadido;
    private LocalDate fechaNacimiento;
    private String nombre, apellido1, apellido2, correo, descripcion;
    private HashSet<String> lstNumTelf;
    private Map<String, List<String>> lstRedesSociales;

    public ContactoCp() {
       this.fechaAñadido = LocalDateTime.now();
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) throws DatosInvalidosException {
        if (fechaNacimiento==null) {throw new DatosInvalidosException("Fecha de nacimiento vacia");}
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public HashSet<String> getLstNumTelf() {
        return lstNumTelf;
    }

    public void setLstNumTelf(HashSet<String> lstNumTelf) {
        this.lstNumTelf = lstNumTelf;
    }

    public Map<String, List<String>> getLstRedesSociales() {
        return lstRedesSociales;
    }

    public void setLstRedesSociales(Map<String, List<String>> lstRedesSociales) {
        this.lstRedesSociales = lstRedesSociales;
    }
    
    
    
     @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nNombre: ").append(nombre);
        if (apellido1 != null && !apellido1.isEmpty() && !apellido1.isBlank()) {
            sb.append(", Primer apellido: ").append(apellido1);
        }
        if (apellido2 != null && !apellido2.isEmpty() && !apellido2.isBlank()) {
            sb.append(", Segundo apellido: ").append(apellido2);
        }
        if (fechaNacimiento != null) {
            DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/uuuu");
            sb.append(", Fecha de nacimiento: ").append(fechaNacimiento.format(f));
        }

        sb.append(", Numeros de contacto: ");
        sb.append(String.join(", ", lstNumTelf));
        sb.append(", Redes sociales: ");
        //sb.append(String.join(", ", lstRedesSociales));

        if (correo != null) {
            if (!correo.isBlank()) {
                sb.append(", Email: ").append(correo);
            }
        }
        if (descripcion != null) {
            if (!descripcion.isBlank()) {
                sb.append(", Descripcion: \"").append(descripcion).append('"');
            }
        }

        return sb.toString();
    }
    
    private static class DatosInvalidosException extends Exception {

        public DatosInvalidosException(String msg) {
            super(msg);
        }
    }
}
