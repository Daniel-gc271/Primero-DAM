/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemaPagos;

import java.util.regex.Pattern;

/**
 *
 * @author goncalda
 */
public class Tarjeta implements MetodoPago
{
    private String numTarjeta;

    public Tarjeta(int numTarjeta) {
        String StrNumTarjeta = String.valueOf(numTarjeta) ;
        if (StrNumTarjeta.matches("^[1-9][0-9]{15}$")) {
        throw new IllegalArgumentException(String.format("%s no es un numero de tarjeta válido",numTarjeta));
        }
    }
    
}
