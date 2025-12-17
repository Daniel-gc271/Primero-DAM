package Puntos;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author goncalda
 */
public class Punto3 {

    private double x, y, z;

    public Punto3() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    public Punto3(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;

    }

    public double getX() {
        return this.x;

    }

    public double getY() {
        return this.y;

    }

    public double getZ() {
        return this.z;

    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setZ(double z) {
        this.z = z;
    }
    public void mover(Punto3 destino) {
        setX(destino.getX());
        setY(destino.getY());
        setZ(destino.getZ());
    }
    public void desplazar(double x,double y, double z) {
        setX(this.x+x);
        setY(this.y+y);
        setZ(this.z+z);
    }
    public double distPaP(Punto3 p1, Punto3 p2) {
        double deltaX = p1.getX() - p2.getX(),
               deltaY = p1.getY() - p2.getY(),
               deltaZ = p1.getZ() - p2.getZ();
        return Math.sqrt(
                  Math.pow(deltaX, 2)
                + Math.pow(deltaY, 2)
                + Math.pow(deltaZ, 2));

    }

    @Override
    public String toString() {
        return String.format("(%f, %f, %f)", this.x, this.y, this.z);
    }

}
