/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ActividadFiguras;

/**
 *
 * @author goncalda
 */
public abstract class Cuadrilatero extends Figura {
    protected double base,altura;
    public abstract double calcularDiagonal();

    @Override
    public double calcularArea() {
    return (this.base*this.altura);
    
    };

    @Override
    /**
     *Asumo triangulos equilateros
     *
     *
     *
     */
    public double calcularPerimetro() {
        return this.base*3;
    };
    
    
    @Override
    public String toString() {
        return "Centro: "+this.centro.toString() + "base: " + base + ", altura=" + altura;
    }
    
    
}
