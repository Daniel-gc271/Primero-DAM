/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Encuesta.Vista;

import java.util.Objects;
import javax.swing.JOptionPane;

/**
 *
 * @author goncalda
 */
public class Usuario {

    public static int cont;
    private int uID;
    private String mail;

    public void setMail(String mail) {
        if (mail.isBlank()) {
            JOptionPane.showMessageDialog(null, "El correo no puede estar vacio", "error", JOptionPane.ERROR_MESSAGE);
        }
        if (mail.matches("^[A-Za-z0-9]+@[A-Za-z0-9]+\\.[a-z]+$")) {
            this.mail = mail;
        }

    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.uID;
        hash = 53 * hash + Objects.hashCode(this.mail);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (this.uID != other.uID) {
            return false;
        }
        return Objects.equals(this.mail, other.mail);
    }

}
