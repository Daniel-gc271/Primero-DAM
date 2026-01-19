/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicios.Ascensor;

import java.util.List;
import Ejercicios.Ascensor.Persona;
import java.util.ArrayList;

/**
 *
 * @author goncalda
 */
public class Ascensor {

    //Atributos
    private int pisoMaximo, pisoMinimo, pisoActual, pisoDestino;
    private double CargaActual, CargaMaxima;
    private boolean puertaAbiertas, alarma; //true abierta false cerrado
    private List<Persona> personas;
    //Constructor

    public Ascensor(int pisoMaximo, int pisoMinimo, double CargaMaxima) {
        this.personas = new ArrayList<>();
        this.pisoMaximo = pisoMaximo;
        this.pisoMinimo = pisoMinimo;
        this.CargaMaxima = CargaMaxima;
    }

    //Interfaz
    public void abrirPuertas() throws Exception {
        if (this.puertaAbiertas) {
            throw new AscensorException("Las puertas ya estan abiertas");
        } else {
            this.puertaAbiertas = true;
        }

    }

    public void cerrarPuertas() throws Exception {
        if (!this.puertaAbiertas) {
            throw new AscensorException("Las puertas ya estan cerradas");
        } else {
            this.puertaAbiertas = false;
        }
    }

    public void entrar(Persona persona) throws Exception {
        double nuevoPeso = this.CargaActual + persona.getPeso();
        if (nuevoPeso > this.CargaMaxima) {
            this.alarma = true;
            throw new AscensorException("Ha saltado la alarma porque se sobrepasa el peso");
        } else {
            this.CargaActual = nuevoPeso;
            personas.add(persona);
        }
    }

    public void bajar(int indexPersona) throws Exception {

        if (indexPersona < 0) {
            throw new AscensorException("Los pasajeros de un ascensor no pueden tener un indice negativo");
        }
        if (indexPersona> this.personas.size()) {throw new AscensorException("Indice de pasajeros fuera de limites");}

    }

}
