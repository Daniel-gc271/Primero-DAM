package Puntos;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author goncalda
 */
public class Punto2 {

    private double x, y, z;

    public Punto2() {
        this.x = 0;
        this.y = 0;
    }

    public Punto2(double x, double y) {
        this.x = x;
        this.y = y;

    }

    public double getX() {
        return this.x;

    }

    public double getY() {
        return this.y;

    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void mover(Punto2 destino) {
        setX(destino.getX());
        setY(destino.getY());
    }

    public void desplazar(double x, double y) {
        setX(this.x + x);
        setY(this.y + y);
    }

    public double distPaP(Punto2 p1, Punto2 p2) {
        double deltaX = p1.getX() - p2.getX(),
                deltaY = p1.getY() - p2.getY();
        return Math.sqrt(
                Math.pow(deltaX, 2)
                + Math.pow(deltaY, 2)
        );

    }

    @Override
    public String toString() {
        return String.format("(%f, %f)", this.x, this.y);
    }

}
