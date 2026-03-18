package controlador;

import java.util.ArrayList;
import java.util.HashMap;
import modelo.Contacto;
import vista.GuiContacto;
import vista.GUIAgendaContactos;

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

        HashMap<String, Contacto> listaContactos = new HashMap<>();
        GuiContacto viewContactGui = new GuiContacto(listaContactos);
        GUIAgendaContactos mainGui = new GUIAgendaContactos(viewContactGui,listaContactos);
        mainGui.setVisible(true);
    }
}
