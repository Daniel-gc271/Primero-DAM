/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Encuesta.Vista;

/**
 *
 * @author goncalda
 */
public class Usuario {
    public static int cont;
    private int uID;
    private String mail;

    public void setMail(String mail) {
        if (mail.isBlank()) {System.out.println("El correo no puede estar vacio");}
        if (mail.matches("^[A-Za-z0-9]+@[A-Za-z0-9]+\\.[a-z]+$")) {this.mail = mail;}
        
    }
    
}
