/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

/**
 *
 * @author goncalda
 */
public class Contacto {

    private final Comparator<Contacto> compContacto;
    private LocalDateTime fechaAñadido;
    private LocalDate fechacumpleaños;
    private String nombre, apellido1, apellido2, correo, descripcion;
    private HashSet<String> lstNumTelf;
//    private HashMap<String, String> socials = new HashMap<>();

    public Contacto(String nombre, HashSet<String> numTelf) {
        this.fechaAñadido = LocalDateTime.now();
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
    public void ordenarFechaAsc(ArrayList<Contacto> listaContactos) {
        Collections.sort(listaContactos,
                compContacto.
                        thenComparing(Contacto::getFechaAñadido));
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
        if (fechacumpleaños != null) {
            DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/uuuu");
            sb.append(", Cumplea\u00f1os: ").append(fechacumpleaños.format(f));
        }

        sb.append(", Numeros de contacto: ");
        sb.append(String.join(",",lstNumTelf ));

        if (correo != null) {
            if (!correo.isBlank()) {
                sb.append(", Email: ").append(correo);
            }
        }
        if (descripcion != null) {
            if (!descripcion.isBlank()) {
                sb.append(", Descripcion: ").append(descripcion);
            }
        }
        
        return sb.toString();
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
        final Contacto other = (Contacto) obj;
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        /**
         * En teoria si absolutamente toda la lista de telefonos coincide
         * Los contactos se pueden mergear
         */
        if (this.lstNumTelf.equals(other.lstNumTelf)) {
            return true;
        }

        /**
         *
         * Los comparo con el hash pero sin tener en cuenta la fecha añadido a
         * la hora de hacer el hash (Comparo el resto de campos que
         * identificarian a una persona) (Nombre apellidos, correo y numeros de
         * )
         *
         *
         */
        //Uso to array en la lista de telefonos porque 
        int hashThis = 3;
        hashThis = 59 * hashThis + Objects.hashCode(this.fechacumpleaños);
        hashThis = 59 * hashThis + Objects.hashCode(this.nombre);
        hashThis = 59 * hashThis + Objects.hashCode(this.apellido1);
        hashThis = 59 * hashThis + Objects.hashCode(this.apellido2);
        hashThis = 59 * hashThis + Objects.hashCode(this.correo);
        hashThis = 59 * hashThis + Objects.hashCode(this.lstNumTelf.toArray());

        int hashOther = 3;
        hashOther = 59 * hashOther + Objects.hashCode(other.fechacumpleaños);
        hashOther = 59 * hashOther + Objects.hashCode(other.nombre);
        hashOther = 59 * hashOther + Objects.hashCode(other.apellido1);
        hashOther = 59 * hashOther + Objects.hashCode(other.apellido2);
        hashOther = 59 * hashOther + Objects.hashCode(other.correo);
        hashOther = 59 * hashOther + Objects.hashCode(other.lstNumTelf.toArray());

        return (hashThis == hashOther);

    }
    
    
    public static ArrayList<Contacto> filtrarContactos(HashMap<?, Contacto> listaContactos, String nombreBuscado, String app1Buscado, String app2Buscado, String mailBuscado, String telfBuscado) {
    ArrayList<Contacto> resultados = new ArrayList<>();
    
    // Normalizamos las búsquedas a minúsculas y sin espacios
    String nombre = nombreBuscado.trim().toLowerCase();
    String apellido1 = app1Buscado.trim().toLowerCase();
    String apellido2 = app2Buscado.trim().toLowerCase();
    String eMail = mailBuscado.trim().toLowerCase();
    String telefono = telfBuscado.trim();

    for (Contacto contacto : listaContactos.values()) {
        boolean coincide = true;

        // Filtro de Nombre
        if (!nombre.isEmpty() && (contacto.getNombre() == null || !contacto.getNombre().toLowerCase().contains(nombre))) {
            coincide = false;
        }
        // Filtro de Apellido 1
        if (coincide && !apellido1.isEmpty() && (contacto.getApellido1() == null || !contacto.getApellido1().toLowerCase().contains(apellido1))) {
            coincide = false;
        }
        // Filtro de Apellido 2
        if (coincide && !apellido2.isEmpty() && (contacto.getApellido2() == null || !contacto.getApellido2().toLowerCase().contains(apellido2))) {
            coincide = false;
        }
        // Filtro de Email
        if (coincide && !eMail.isEmpty() && (contacto.getCorreo() == null || !contacto.getCorreo().toLowerCase().contains(eMail))) {
            coincide = false;
        }
        // Filtro de Teléfono
        if (coincide && !telefono.isEmpty()) {
            boolean telEncontrado = false;
            for (String telefonos : contacto.getLstNumTelf()) {
                if (telefonos.contains(telefono)) {
                    telEncontrado = true;
                    break;
                }
            }
            if (!telEncontrado) coincide = false;
        }

        // Solo si ha pasado todos los filtros activos se añade
        if (coincide) {
            resultados.add(contacto);
        }
    }
    return resultados;
}

    public LocalDateTime getFechaAñadido() {
        return fechaAñadido;
    }

    public LocalDate getFechacumpleaños() {
        return fechacumpleaños;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public String getCorreo() {
        return correo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public HashSet<String> getLstNumTelf() {
        return lstNumTelf;
    }

    public void setFechaAñadido(LocalDateTime fechaAñadido) {
        this.fechaAñadido = fechaAñadido;
    }

    public void setFechacumpleaños(LocalDate fechacumpleaños) {
        this.fechacumpleaños = fechacumpleaños;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public void setCorreo(String correo) throws Exception {
        //Regex email -> ChatGpt
        String regexEmail = "^[A-Za-z0-9_+]+(?:\\.[A-Za-z0-9_+]+)*@[A-Za-z0-9](?:[A-Za-z0-9-]*[A-Za-z0-9])?(?:\\.[A-Za-z0-9](?:[A-Za-z0-9-]*[A-Za-z0-9])?)*\\.[A-Za-z]{1,}$";
        if (correo.matches(regexEmail)) {
            this.correo = correo.toLowerCase();
        } else {
            throw new Exception();
        }
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setLstNumTelf(HashSet<String> lstNumTelf) {
        this.lstNumTelf = lstNumTelf;
    }
    
    
    
}
