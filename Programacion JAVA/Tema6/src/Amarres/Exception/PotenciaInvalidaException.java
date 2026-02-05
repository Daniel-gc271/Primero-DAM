/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Amarres.Exception;

/**
 *
 * @author goncalda
 */
public class PotenciaInvalidaException extends Exception {

    public PotenciaInvalidaException(double message) {
        super("Un barco no puede tener:"+message+" caballos de fuerza");
    }
    
}
