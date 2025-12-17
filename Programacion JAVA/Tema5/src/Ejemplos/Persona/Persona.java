/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejemplos.Persona;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.MatchException;

/**
 *
 * @author macarena
 *
 * La edad en función de la fecha de nacimiento DNI válido (algoritmo de la
 * letra)
 *
 *
 */
public class Persona {

    //atributos
    private String dni;
    private String nombre;
    private String apellidos;
    private int edad;
    private LocalDate fechaNac;
    private Character sexo;
    private boolean trabaja;

    //constructor por defecto
    public Persona() {
    }

    //constructor con parametros
    public Persona(String dni, String nombre, String apellidos) {
        setDni(dni);
        setNombre(nombre);
        setApellidos(apellidos);
        this.apellidos = apellidos;
        this.edad = 0; //en años
        this.fechaNac = null;
        this.sexo = '-';
        this.trabaja = false;
    }

    //getter y setter
    public String getDni() {
        return this.dni;
    }

    public void setDni(String dni) {
        //validación del dni
        //b) con el dni bien construido, comprobar si su letra es la correcta
        char letraValida = getletraDni(dni);
        char letraRecibida = dni.charAt(dni.length() - 1);
        if (letraValida == letraRecibida) {
            this.dni = dni;
        } else {
            System.err.println("Error. DNI no valido porque la letra no se corresponde.");
        }

    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return this.apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = dni;
    }

    public int getEdad() {
        return this.edad;
    }

    private void setEdad(int edad) {
        this.edad = edad;
    }

    public LocalDate getFechaNac() {
        return this.fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
        //calculamos la edad
        calcularEdad();
    }

    public Character getSexo() {
        return this.sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public boolean getTrabaja() {
        return this.trabaja;
    }

    public void setTrabaja(boolean trabaja) {
        this.trabaja = trabaja;
    }

    private void calcularEdad() {
        long diasDiferencia = LocalDate.now().toEpochDay() - this.fechaNac.toEpochDay();
        this.edad = (int) diasDiferencia / 365;
    }

    public char getletraDni(String dniCompleto) { // 12345678Z
        //a) ver si está bien construido [0-9]{8}[A-Z]
        if (testDNIStruct(dniCompleto.toUpperCase())) {
            String lista = "TRWAGMYFPDXBNJZSQVHLCKE";
            int numeroDni = Integer.parseInt(dniCompleto.substring(0, dniCompleto.length() - 1));
            int indice = numeroDni % 23;
            char letra = lista.charAt(indice);
            return letra;
        } else {
            System.err.println("Error. DNI no valido porque el patron no se corresponde.");
            String msgErr = new String();
            msgErr += "\""+dniCompleto+"\" No es un dni válido";
            throw new IllegalArgumentException(msgErr);
        }

    }

    private boolean testDNIStruct(String dni) {
        dni = dni.toUpperCase();
        //Explicacion comprobar si los 8 primeros caracteres se encuentran entre 0 y 9 y el ultimo caracter es una letra
        Pattern patDNI = Pattern.compile("^[0-9]{8}[A-Z]{1}$");
        Matcher matDNI = patDNI.matcher(dni);
        if (matDNI.matches()) {
            System.out.println("Patron de dni verificado correctamente");
            return true;
        } else {
            //System.err.println("Error. DNI no valido porque el patron no se corresponde.");
            return false;
        }

    }

}
