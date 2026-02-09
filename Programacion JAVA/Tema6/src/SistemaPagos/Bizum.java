/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemaPagos;

/**
 *
 * @author goncalda
 */
public final class Bizum implements MetodoPago 
{
    private int numTel;
     public Bizum(int numTel) {
        String StrNumTarjeta = String.valueOf(numTel) ;
        if (StrNumTarjeta.matches("^[1-9][0-9]{15}$")) {
        throw new IllegalArgumentException(String.format("%s no es un numero de tarjeta válido",numTel));
        }
    }
}
