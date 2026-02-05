/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Amarres.Exception;

/**
 *
 * @author goncalda
 */
public class MatriculaInvalidaException extends Exception {

    public MatriculaInvalidaException(String message) {
        super("La matricula: "+message+" no es valida");
    }
    
}
