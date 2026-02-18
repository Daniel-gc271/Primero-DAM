/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VentaCamisetas;

import java.awt.Color;

/**
 *
 * @author goncalda
 */
public class Camiseta {

    private Tallas talla;
    private Color colores;
    private double pvr;

    public Camiseta(Tallas talla) {
        this.talla = talla;
    }

    public Tallas getTalla() {
        return talla;
    }

    public void setTalla(Tallas talla) {
        this.talla = talla;
    }

    public Color getColores() {
        return colores;
    }

    public void setColores(Color colores) {
        this.colores = colores;
    }

    public double getPvr() {
        return pvr;
    }

    public void setPvr(double pvr) {
        this.pvr = pvr;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cmiseta:");
        sb.append("\n\tTalla: ").append(talla);
        sb.append("\n\tColor: ").append(colores);
        sb.append("\n\tPrecio: ").append(pvr);
        sb.append('\n');
        return sb.toString();
    }
    
}
