/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemaPagos;

/**
 *
 * @author goncalda
 */
public interface MetodoPago {
 void pagar(double cantidad);
 String obtenerComprobante();
}
