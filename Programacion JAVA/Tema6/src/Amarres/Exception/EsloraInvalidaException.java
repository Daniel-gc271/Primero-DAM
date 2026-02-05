/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Amarres.Exception;

/**
 *
 * @author goncalda
 */
public class EsloraInvalidaException extends Exception {
    public EsloraInvalidaException(double message) {
        super("La eslora de un barco no puede ser: "+message+"m");
    }
}
