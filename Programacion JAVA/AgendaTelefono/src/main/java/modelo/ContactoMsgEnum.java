/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package modelo;

import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel González
 */
public enum ContactoMsgEnum {
    ERR("0"),
    INFF("1"),
    ERR_EMPTY_NAME("No has introducido un nombre de contacto"),
    ERR_EMPTY_PHONE("No has introducido ningun telefono valido"),
    ERR_CONTACTOS_REPETIDOS("Has introducido %d contactos repetidos (%s)");
    
    
    
    
    
    
    private final String msg;
    private ContactoMsgEnum(String msg) {
        this.msg = msg;
    }
    @Override
    public String toString() {
        return msg;
    }
    public String toString(Object... number) {
        return String.format(msg, number);
    }
    public String getRegex() {
        String pattern = Pattern.quote(this.msg);
        return pattern.replace("%d","\\d+").replace("%s", "[\\w\\s]+");
    }
}
