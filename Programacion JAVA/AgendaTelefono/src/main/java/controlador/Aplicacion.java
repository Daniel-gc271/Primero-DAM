package controlador;

import com.formdev.flatlaf.FlatDarkLaf;
import java.util.LinkedHashMap;
import modelo.Contacto;
import vista.GuiPrincipalAgendaContactos;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author goncalda
 */
public class Aplicacion {

    public static void main(String args[]) {

        LinkedHashMap<Integer, Contacto> listaContactos;
        listaContactos = new LinkedHashMap<>() {
            @Override
            /**
             * Override al metodo to string de la lista de contactos para dar un
             * formato apropiado (que me convenga para listar los cintactos x consola)
             */
            public String toString() {
                String msg = "";
                for (Contacto contacto : this.values()) {
                    msg += contacto.toString();
                }
                return msg;
            }
        };
        GuiPrincipalAgendaContactos mainGui = new GuiPrincipalAgendaContactos(listaContactos);
        FlatDarkLaf.setup();
        mainGui.setVisible(true);
    }
}
