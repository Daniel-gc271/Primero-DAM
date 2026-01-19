/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicios.Ascensor;

/**
 *
 * @author goncalda
 */
public class Persona {
    //Atributos
    private double peso;
    private final String nombre;
    //Constructor
    public Persona(double peso, String nombre) {
        this.peso=peso;
        this.nombre=nombre;
    }
    //Getter y setters
    public double getPeso() {
        return this.peso;
    }

    @Override
    public String toString() {
        return "Persona{" + "peso=" + peso + ", nombre=" + nombre + '}';
    }
    
    
}
