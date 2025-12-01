/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicios;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author goncalda
 */
public class AspaRGB {

    public static void main(String[] args) {
        int colorSeleccionado;
        Scanner scIn = new Scanner(System.in);
        Random rd = new Random();
        int dimensionHaspa = rd.nextInt(3, 10);
        final String DEFAULT = "\u001B[0m";
        final String RED = "\u001B[31m";
        final String GREEN = "\u001B[32m";
        final String YELLOW = "\u001B[33m";
        final String BLUE = "\u001B[34m";
        final String PURPLE = "\u001B[35m";
        final String CYAN = "\u001B[36m";
        final String WHITE = "\u001B[37m";
        String[] paletaDeColor = {DEFAULT,RED,GREEN,YELLOW,BLUE,PURPLE,CYAN,WHITE};
        //Validacion sencilla al seleccionar un color de la paleta
        do {
        //En teoria aqui deberia limpiar la linea de comandos pero no encuentro como    
        // ANSI escape code to clear screen and move cursor to top-left (gracias chatti aka chat gpt x intentarlo )
        //Inteno fallido // System.out.print("\033[H\033[2J");
        for (int i = 0; i < paletaDeColor.length; i++) {
            System.out.println(paletaDeColor[i]+"Color #"+i);
        }
        System.out.println("Selecciona un color de la lista para pintar el haspa");
        colorSeleccionado=scIn.nextInt();
        } while (colorSeleccionado<0||colorSeleccionado>paletaDeColor.length-1);
        //Llamada al metodo que imprime haspas, con su dimension y su paleta
        //P.d tambien se le puede pasar el objeto random para no crear la variable del tamaño
        // o que en todo caso fuera local al metodo.
        pintarHaspa(dimensionHaspa, paletaDeColor[colorSeleccionado]);
        
        
    }
    //Metodo que pinta el haspa por claridad y organizacion
    private static void pintarHaspa(int dimensionHaspa, String color) {
        
        for (int i = 0; i < dimensionHaspa; i++) {
            for (int j = 0; j < dimensionHaspa; j++) {
                //System.out.printf("x%d y%d ", j, i);//Debug
                //Usado para derivar la formula que valida las posiciones donde pintar
                //Para pintar una diagonal es necesario que las posiciones del cursor x e y sean iguales
                //Para pintar la contradiagonal, se debe cumplir que una de las posiciones 
                //sea igual a restar la otra posicion al tamaño del haspa
                System.out.print(color);//refrescar siempre el color que se va con cada salto de linea
               
                if ((j==i)||(j==dimensionHaspa-1-i&&i==dimensionHaspa-1-j)) {
                    System.out.print("x");
                } else {
                    System.out.print(" ");
                } 
            }
            System.out.println("");
            
        }
        System.out.println("\u001B[0m"+"Color reseteado");
    }
}
