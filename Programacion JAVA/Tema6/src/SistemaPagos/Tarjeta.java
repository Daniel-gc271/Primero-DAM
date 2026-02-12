/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemaPagos;

import java.util.regex.Pattern;

import javax.swing.JOptionPane;

/**
 *
 * @author goncalda
 */
public class Tarjeta implements MetodoPago
{
    private JustPago justificante;
    private long numTarjeta;

    public Tarjeta(String StrNumTarjeta) {
        this.numTarjeta = Long.parseLong(StrNumTarjeta);
    }
     @Override
    public void pagar(double cantidad) {
        String msg = String.format("¿Cobrar: %.2f€ a la tarjeta %d?",cantidad,this.numTarjeta);
      if(JOptionPane.showConfirmDialog(null, msg,"Cobro Tarjeta",JOptionPane.YES_NO_OPTION) ==0 /*Yes*/ ) {
        this.justificante = new JustPago(cantidad);
      } 
    }
     @Override
    public String obtenerComprobante() {
       return this.justificante.toString() + String.format("Metodo: Tarjeta\nNumero: %d",this.numTarjeta);
    }
    
}
