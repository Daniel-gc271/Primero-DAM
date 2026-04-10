/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gf.local.Actividades.AlmacenCopia;

/**
 *
 * @author goncalda
 */
public class TipoProducto {
    
    private int idTipo;
    private String tipo;

    public TipoProducto(int idTipo, String tipo) {
        this.idTipo = idTipo;
        this.tipo = tipo;
    }

    TipoProducto() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(tipo);
        return sb.toString();
    }
}
