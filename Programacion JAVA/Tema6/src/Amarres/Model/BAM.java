/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Amarres.Model;

/**
 *
 * @author goncalda
 */
public abstract class BAM extends Barco {
    private final int POTENCIA;
    
    protected BAM(int POTENCIA, String MATRICULA, String ANIOFAB, double ESLORA)  {
        super(MATRICULA, ANIOFAB, ESLORA);
        this.POTENCIA = POTENCIA;
    }

    @Override
    public double calcularModulo() {
        return super.calcularModulo() + this.POTENCIA; 
    }
    
    
}
