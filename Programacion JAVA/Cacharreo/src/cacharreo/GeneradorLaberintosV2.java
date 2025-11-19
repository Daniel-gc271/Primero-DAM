/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cacharreo;

import java.util.Random;

/**
 *
 * @author Daniel González
 */
public class GeneradorLaberintosV2 {
    public static void main(String[] args) {
        Laberinto lab = new Laberinto(10, 14);
        lab = lab.crearLaberintoBase(lab);
        lab.imprimirLaberinto(lab);
    }


    
    

}
class Laberinto {

    private int numFilas;
    private int numColumnas;
    private int oX;
    private int oY;
    private char[][] laberinto;

    public Laberinto( int columnas,int filas, int oX, int oY) {
        this.oX = oX;
        this.oY = oY;
        this.numFilas = filas;
        this.numColumnas = columnas;
        this.laberinto = new char[filas][columnas];
    }
    public Laberinto(int filas, int columnas) {
        
        this.numFilas = filas;
        this.numColumnas = columnas;
        this.laberinto = new char[columnas][filas];
    }

    public int getnumFilas() {
        return numFilas;
    }

    public int getnumColumnas() {
        return numColumnas;
    }

    public int getoX() {
        return oX;
    }

    public int getoY() {
        return oY;
    }

    public char[][] getLaberinto() {
        return this.laberinto;
    }
    
    public char getCeldaLaberinto(int fila, int columna) {
        return this.laberinto[fila][columna];
    }
    
    public void setoX(int oX) {
        this.oX = oX;
    }

    public void setoY(int oY) {
        this.oY = oY;
    }

    public void setLaberinto(char[][] laberinto) {
        this.laberinto = laberinto;
    }
    public void setCeldaLaberinto(int fila, int columna, char caracter) {
        this.laberinto[fila][columna] = caracter;
    }
    public Laberinto crearLaberintoBase(Laberinto laberinto) {
        for (int y = 0; y < laberinto.getnumFilas();y++) {
            for (int x = 0; x < laberinto.getnumColumnas(); x++) {
                System.out.printf("%d,%d ",x,y);
                if (y!=laberinto.getnumFilas()-1) {
                    laberinto.setCeldaLaberinto(x, y, 'D');
                }
                if (y==laberinto.getnumFilas()-1) {
                    laberinto.setCeldaLaberinto(x, y, 'S');
                }
            }
            System.out.println("");
        }
    return laberinto;
    }
    public void imprimirLaberinto(Laberinto lab) {
        for (int x = 0; x < lab.getnumColumnas(); x++) {
            for (int y = 0; y < lab.getnumFilas(); y++) {
                System.out.printf(" %s",lab.getLaberinto()[x][y]);
            }
            System.out.println("");
        }
        
    }
}