/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package modelo;

/**
 *
 * @author Daniel González
 */
public class ContactoException extends Exception {

    /**
     * Creates a new instance of <code>ContactoException</code> without detail
     * message.
     */
    public ContactoException() {
    }

    /**
     * Constructs an instance of <code>ContactoException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ContactoException(String msg) {
        super(msg);
    }

    ContactoException(ContactoMsgEnum contactoMsgEnum) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
