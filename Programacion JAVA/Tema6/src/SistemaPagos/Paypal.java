/*
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemaPagos;

/**
 *
 * @author goncalda
 */
public final class Paypal implements MetodoPago
{
    private String correoElectronico;

    public Paypal(String correoElectronico) {
        if (correoElectronico.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")){throw new IllegalArgumentException(correoElectronico+" No es un email válido");}
        this.correoElectronico = correoElectronico;
    }

    @Override
    public void pagar(double cantidad) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String obtenerComprobante() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean validarMetodo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
