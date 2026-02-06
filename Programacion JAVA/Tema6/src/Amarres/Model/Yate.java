/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Amarres.Model;

/**
 *
 * @author goncalda
 */
public class Yate extends BAM{
    private final int CAMAROTES;
    public Yate(int CAMAROTES, int POTENCIA, String MATRICULA, String ANIOFAB, double ESLORA) {
        super(POTENCIA, MATRICULA, ANIOFAB, ESLORA);
        this.CAMAROTES = CAMAROTES;
    }

    @Override
    public double calcularModulo() {
        return super.calcularModulo()+this.CAMAROTES; 
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", CAMAROTES=").append(CAMAROTES);
        return super.toString() + sb.toString();
    }
    
    
    
}
