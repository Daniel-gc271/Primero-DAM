/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Figuras;

/**
 *
 * @author goncalda
 */
public class Punto {
    private final double posX, posY;

    public Punto(double posX, double posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public double getPosX() {
        return posX;
    }

    public double getPosY() {
        return posY;
    }
    
    @Override
    public String toString() {
        return String.format("(%f, %f)", this.posX,this.posY);
    }
    
}
