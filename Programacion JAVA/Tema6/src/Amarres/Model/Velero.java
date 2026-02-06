/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Amarres.Model;

/**
 *
 * @author goncalda
 */
public class Velero extends Barco {
    private final int MASTILES;

    public Velero(int MASTILES, String MATRICULA, String ANIOFAB, double ESLORA) {
        super(MATRICULA, ANIOFAB, ESLORA);
        this.MASTILES = MASTILES;
    }

    @Override
    public double calcularModulo() {
        return super.calcularModulo()+ this.MASTILES; 
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", MASTILES=").append(MASTILES);
        return super.toString() + sb.toString();
    }
    
    
    
}
