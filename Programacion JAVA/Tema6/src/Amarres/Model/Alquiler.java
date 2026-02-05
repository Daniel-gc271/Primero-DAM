/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Amarres.Model;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author goncalda
 */
public class Alquiler {
    private final String DNI;
    private final Barco BARCO;
    private final int posicion;
    private final LocalDateTime FECHAINICIO,FECHAFINAL;

    public Alquiler(String DNI, Barco BARCO, int posicion, LocalDateTime FECHAINICIO, LocalDateTime FECHAFINAL) {
        this.DNI = DNI;
        this.BARCO = BARCO;
        this.posicion = posicion;
        this.FECHAINICIO = FECHAINICIO;
        this.FECHAFINAL = FECHAFINAL;
    }
    public double calcAlquiler() {
        long dias=ChronoUnit.DAYS.between(FECHAINICIO, FECHAFINAL)+1;
        return this.BARCO.calcularModulo()*(double) dias;
    }
            
}
