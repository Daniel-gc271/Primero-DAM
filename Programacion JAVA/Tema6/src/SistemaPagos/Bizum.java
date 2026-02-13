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
public final class Bizum implements MetodoPago {
    private int numTel;
    private JustPago justificante;
    public Bizum(String StrNumTel) {
        this.numTel = Integer.parseInt(StrNumTel);
    }

     @Override
    public void pagar(double cantidad) {
        String msg = String.format("¿Cobrar: %.2f€ al telefono: %d?",cantidad,this.numTel);
      if(JOptionPane.showConfirmDialog(null, msg,"Cobro Bizum",JOptionPane.YES_NO_OPTION) ==0 /*Yes*/ ) {
        this.justificante = new JustPago(cantidad);
      } 
    }
     @Override
    public String obtenerComprobante() {
       return this.justificante.toString() + String.format("Metodo: Bizum\nTelefono: %d",this.numTel);
    }

}
