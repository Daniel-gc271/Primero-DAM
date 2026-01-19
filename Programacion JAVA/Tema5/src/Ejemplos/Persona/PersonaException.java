/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejemplos.Persona;

/**
 *
 * @author goncalda
 */
public class PersonaException extends Exception {
    //Argumentos formales los que necesita el metodo
    //Argumentos actual valores que paso en una llamada
    public PersonaException(){}
    
    public PersonaException(String errMsg) {
        super(errMsg);
    }
}
