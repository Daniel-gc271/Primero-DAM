/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.terminalventas;

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
        sb.append("\n\tColor:");
        sb.append("\n\tR: ").append(colores.getRed());
        sb.append("\tG: ").append(colores.getGreen());
        sb.append("\tG: ").append(colores.getBlue());
        sb.append("\n\tPrecio: ").append(pvr);
        sb.append('\n');
        return sb.toString();
    }
    
}
