/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gf.local.Actividades.Almacen;

import gf.local.Actividades.AlmacenCopia.*;

/**
 *
 * @author goncalda
 */
public class Producto {

    private int idProducto, cantidad, tipo;
    private double precio;
    private String descripcion;

    public Producto(int idProducto, String descripcion, double precio, int cantidad, int tipo) {
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.tipo = tipo;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id: ").append(idProducto);
        sb.append('\t');
        sb.append("Descripcion: ").append(descripcion);
        sb.append('\t');
        sb.append("Precio: ").append(precio);
        sb.append('\t');
        return sb.toString();
    }

}
