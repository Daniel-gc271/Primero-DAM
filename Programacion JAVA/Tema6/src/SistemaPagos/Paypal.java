/*
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemaPagos;

import javax.swing.JOptionPane;

/**
 *
 * @author goncalda
 */
public final class Paypal implements MetodoPago
{
    private String correoElectronico;
    private JustPago justificante;
    public Paypal(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    @Override
    public void pagar(double cantidad) {
        String msg = String.format("¿Cobrar: %.2f€ a la cuenta: %s?",cantidad,this.correoElectronico);
      if(JOptionPane.showConfirmDialog(null, msg,"Cobro Paypal",JOptionPane.YES_NO_OPTION) ==0 /*Yes*/ ) {
        this.justificante = new JustPago(cantidad);
      } 
    
    }

    @Override
    public String obtenerComprobante() {
       return this.justificante.toString() + String.format("Metodo: Paypal\nCuenta: %s",this.correoElectronico);
    }

    
    
}
