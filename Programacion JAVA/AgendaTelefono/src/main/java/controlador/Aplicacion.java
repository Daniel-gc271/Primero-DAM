package controlador;

import java.util.ArrayList;
import modelo.Contacto;
import vista.GuiContacto;
import vista.GUIAgendaContactos;
import vista.GuiEditarContacto;

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

        ArrayList<Contacto> listaContactos = new ArrayList<>();
        GuiContacto viewContactGui = new GuiContacto();
        GuiEditarContacto editContactGui = new GuiEditarContacto();
        GUIAgendaContactos mainGui = new GUIAgendaContactos(viewContactGui);
        mainGui.setVisible(true);
    }
}
