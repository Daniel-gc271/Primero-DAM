/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicios.FigurasGeometricas;

import ActividadFiguras.Punto2;

/**
 *
 * @author goncalda
 */
public class Circulo extends PoligonoIrregular {
    private double radio;
    public Circulo(double radio) {
        this.radio=radio;
        this.centro= new Punto2(0, 0);
    }
            
}
