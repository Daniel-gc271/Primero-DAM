package controlador;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import modelo.Contacto;
import vista.GuiContacto;
import vista.GUIAgendaContactos;
import vista.GuiFiltrarContacto;

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

        HashMap<Integer, Contacto> listaContactos;
        listaContactos = new HashMap<>() 
        {
            
            @Override
            /**
             * Override al metodo to string de la lista de contactos
             * para dar un formato apropiado (que me convenga para listar los cintactos)
             */
            public String toString() {
                String msg="";
                for (Contacto contacto :this.values()) {
                    msg += contacto.toString();
                }
                return msg;
            }
        };
        GuiFiltrarContacto filterContactGui = new GuiFiltrarContacto(listaContactos);
        GuiContacto viewContactGui = new GuiContacto(listaContactos) ;
        GUIAgendaContactos mainGui = new GUIAgendaContactos(viewContactGui,filterContactGui,listaContactos);
        mainGui.setVisible(true);
    }
}
