/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;

/**
 *
 * @author goncalda
 */
public class Contacto {

    private LocalDateTime fechaAñadido;
    private LocalDate fechaNacimiento;
    private String nombre, apellido1, apellido2, correo, descripcion;
    private HashSet<String> lstNumTelf;
//  private HashMap<String, String> socials = new HashMap<>();

    /**
     * Crea un contacto con el instante de creacion ya introducido
     *
     */
    public Contacto() {

    }

    /**
     * Crea un contactocon una fecha de una fuente externa privado para usarse
     * en el clone a la hora de editar un contacto y que persista la fecha de
     * creacion
     *
     * @param nombre
     * @param numTelf
     * @param fechaAñadido
     */
    private Contacto(String nombre, HashSet<String> numTelf, LocalDateTime fechaAñadido) {
        this.fechaAñadido = fechaAñadido;
        this.lstNumTelf = numTelf;
        this.nombre = nombre;
    }

    /**
     * Ordena los contactos segun nombre y apellidos de manera ascendente
     *
     * @param listaCOntactosOrdenados referencia de lista de contactos a ordenar
     */
    public static void ordenarNombreAsc(LinkedHashMap<Integer, Contacto> listaCOntactosOrdenados) {
        ArrayList<Contacto> contactosOrdenados = new ArrayList<>(listaCOntactosOrdenados.values());

        // Orden: nombre → apellido1 → apellido2 (case-insensitive)
        contactosOrdenados.sort(
                Comparator.comparing(Contacto::getNombre, String.CASE_INSENSITIVE_ORDER)
                        .thenComparing(Contacto::getApellido1, String.CASE_INSENSITIVE_ORDER)
                        .thenComparing(Contacto::getApellido2, String.CASE_INSENSITIVE_ORDER)
        );
        listaCOntactosOrdenados.clear();
        for (Contacto contacto : contactosOrdenados) {
            listaCOntactosOrdenados.put(contacto.hashCode(), contacto);
        }

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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.fechaAñadido);
        hash = 59 * hash + Objects.hashCode(this.fechaNacimiento);
        hash = 59 * hash + Objects.hashCode(this.nombre);
        hash = 59 * hash + Objects.hashCode(this.apellido1);
        hash = 59 * hash + Objects.hashCode(this.apellido2);
        hash = 59 * hash + Objects.hashCode(this.correo);
        hash = 59 * hash + Objects.hashCode(this.descripcion);
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
         * En teoria si absolutamente toda la lista de telefonos coincide Los
         * contactos se pueden mergear
         */

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
        hashThis = 59 * hashThis + Objects.hashCode(this.fechaNacimiento);
        hashThis = 59 * hashThis + Objects.hashCode(this.nombre);
        hashThis = 59 * hashThis + Objects.hashCode(this.apellido1);
        hashThis = 59 * hashThis + Objects.hashCode(this.apellido2);
        hashThis = 59 * hashThis + Objects.hashCode(this.correo);

        int hashOther = 3;
        hashOther = 59 * hashOther + Objects.hashCode(other.fechaNacimiento);
        hashOther = 59 * hashOther + Objects.hashCode(other.nombre);
        hashOther = 59 * hashOther + Objects.hashCode(other.apellido1);
        hashOther = 59 * hashOther + Objects.hashCode(other.apellido2);
        hashOther = 59 * hashOther + Objects.hashCode(other.correo);

        return (hashThis == hashOther);

    }

    // <editor-fold defaultstate="collapsed" desc="Metodo filtrarContacto">
    /**
     * Filtra los contactos segun los parametros ingresados
     *
     * @param listaContactos Referencia a la lista de contactos en la que buscar
     * @param nombreBuscado
     * @param app1Buscado
     * @param app2Buscado
     * @param mailBuscado
     * @param telfBuscado
     * @return devuelve la lista de los contactos encontrados
     */
    public static ArrayList<Contacto> filtrarContactos(HashMap<?, Contacto> listaContactos, String nombreBuscado, String app1Buscado, String app2Buscado, String mailBuscado, String telfBuscado) {
        ArrayList<Contacto> resultados = null;
        resultados = new ArrayList<>();

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
                continue;
            } else {
                if (!nombre.isEmpty() && (contacto.getNombre() == null || !contacto.getNombre().toLowerCase().contains(nombre))) {
                    coincide = false;
                    continue;
                } else {// Filtro de Apellido 1
                    if (coincide && !apellido1.isEmpty() && (contacto.getApellido1() == null || !contacto.getApellido1().toLowerCase().startsWith(apellido1))) {
                        coincide = false;
                    } else {// Filtro de Apellido 2
                        if (coincide && !apellido2.isEmpty() && (contacto.getApellido2() == null || !contacto.getApellido2().toLowerCase().startsWith(apellido2))) {
                            coincide = false;
                        } else { // Filtro de Email
                            if (coincide && !eMail.isEmpty() && (contacto.getCorreo() == null || !contacto.getCorreo().toLowerCase().contains(eMail))) {
                                coincide = false;
                            } else {// Filtro de Teléfono
                                if (coincide && !telefono.isEmpty()) {
                                    boolean telEncontrado = false;
                                    for (String telefonos : contacto.getLstNumTelf()) {
                                        if (telefonos.startsWith(telefono)) {
                                            telEncontrado = true;
                                            break;
                                        }
                                    }
                                    if (!telEncontrado) {
                                        coincide = false;
                                    }
                                }
                            }
                        }
                    }
                }
            }

            // Solo si ha pasado todos los filtros activos se añade
            if (coincide) {
                resultados.add(contacto);
            }
        }
        return resultados;
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Metodo añadirContacto">

    public Contacto crearContacto(
            String nombreString,
            String app1String,
            String app2String,
            String cumpleAñosString,
            String emailString,
            String numTelfString,
            String descString,
            Map<Integer, Contacto> listaContactos
    ) throws DatosInvalidosException {
        Contacto contactoAñadir = new Contacto();
        // --- Validación de nombre ---
        if (nombreString == null || nombreString.isBlank()) {
        } else {
            contactoAñadir.setNombre(nombre);
        }
        // --- Validación apellidos ---
        if (app1String.isBlank() && !app2String.isBlank()) {
            throw new DatosInvalidosException("Debes introducir antes el primer apellido");
        } else {
            contactoAñadir.setApellido1(apellido1);
            contactoAñadir.setApellido2(apellido2);
        }
        // --- Procesar teléfonos ---
        ArrayList<String> telefonosInvalidos = new ArrayList<>();
        LinkedHashSet<String> telefonos = new LinkedHashSet<>();

        if (numTelfString.isEmpty()) {
            throw new DatosInvalidosException("Debe indicar al menos un teléfono");
        }

        StringTokenizer st = new StringTokenizer(numTelfString, ",");
        while (st.hasMoreTokens()) {
            String numero = st.nextToken().trim();

            if (!numero.isEmpty()) {
                String normalizado = numero.replaceAll("\\D", "");

                if (!normalizado.matches("\\d{9}")) {
                    telefonosInvalidos.add(normalizado);
                } else {
                    telefonos.add(normalizado);
                }
            }
        }

        if (telefonos.isEmpty()) {
            throw new DatosInvalidosException("No se ha indicado ningún teléfono válido");
        }

        if (!telefonosInvalidos.isEmpty()) {
            throw new DatosInvalidosException("Hay teléfonos inválidos en la lista");
        }

        if (!emailString.isBlank()) {
            try {
                contactoAñadir.setCorreo(emailString);
            } catch (Exception e) {
                throw new DatosInvalidosException("Formato de correo no válido");
            }
        }

        // --- Validación fecha ---
        if (!cumpleAñosString.isBlank()) {
            try {
                DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/uuuu")
                        .withResolverStyle(ResolverStyle.STRICT);

                LocalDate fecha = LocalDate.parse(cumpleAñosString, f);
                contactoAñadir.setFechacumpleaños(fecha);

            } catch (Exception e) {
                throw new DatosInvalidosException("Fecha de cumpleaños inválida: " + cumpleAñosString);
            }
        }

        // --- Datos restantes ---
        contactoAñadir.setDescripcion(descString);
        contactoAñadir.setApellido1(app1String);
        contactoAñadir.setApellido2(app2String);

        // --- Validar duplicado ---
        if (listaContactos.containsValue(contactoAñadir)) {
            throw new DatosInvalidosException("El contacto ya existe, no será añadido");
        }

        // --- Guardar ---
        listaContactos.put(contactoAñadir.hashCode(), contactoAñadir);

        return contactoAñadir;
    }

    // </editor-fold>
    public LocalDateTime getFechaAñadido() {
        return fechaAñadido;
    }

    public LocalDate getFechacumpleaños() {
        return fechaNacimiento;
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
        this.fechaNacimiento = fechacumpleaños;
    }

    public void setNombre(String nombre) throws DatosInvalidosException {
        this.nombre = nombre;
        if (nombre == null || nombre.isBlank()) {
            throw new DatosInvalidosException("El nombre no puede estar vacío");
        }
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
        this.descripcion = descripcion.trim();
    }

    public void setLstNumTelf(HashSet<String> lstNumTelf) {
        this.lstNumTelf = lstNumTelf;
    }

    @Override
    /**
     * Clona un contacto pasando la fecha de creacion del contacto de origen
     */
    public Contacto clone() {
        return new Contacto(nombre, lstNumTelf, this.fechaAñadido);
    }

    private static class DatosInvalidosException extends Exception {

        public DatosInvalidosException(String msg) {
            super(msg);
        }
    }

}
