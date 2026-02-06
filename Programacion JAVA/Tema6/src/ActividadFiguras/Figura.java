/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ActividadFiguras;

/**
 *
 * @author goncalda
 * Todas las figuras pueden dibujarse, calcular el area y perimetro.
 * Solo para los cuadrilateros calcular su diagonal
 * Todas las figuras se situan en un punto xy en un punto
 */
public abstract class Figura {
    
    protected Punto2 centro;

    @Override
    public String toString() {
        return  "Centro: " + centro.toString(); 
    }
    
  
    /**
    * Abstract method to calculate the area of a figures
    * 
    * @return returns the area as a double 
    */
    public abstract double calcularArea();
    /**
    * Abstract method to calculate the perimeter of a figures
    * 
    * @return returns the perimeter as a double 
    */
    public abstract double calcularPerimetro();
    /**
     * Draws a figure on screen
     * 
     */
    public abstract void dibujarfigura(); 
}
