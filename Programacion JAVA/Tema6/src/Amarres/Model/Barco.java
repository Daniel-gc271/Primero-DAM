/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Amarres.Model;

/**
 *
 * @author goncalda
 */
public abstract class Barco {
    private final String MATRICULA, ANIOFAB;
    private final double ESLORA;
    private final double CONSTINFLACION=2;

    public Barco(String MATRICULA, String ANIOFAB, double ESLORA)  {
        this.MATRICULA = MATRICULA;
        this.ANIOFAB = ANIOFAB;
        
        this.ESLORA = ESLORA;
    }
    public double calcularModulo() {
        return this.ESLORA*this.CONSTINFLACION*10;
    }
    
}
