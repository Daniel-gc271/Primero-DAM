/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios;

/**
 *
 * @author Daniel González
 */
public class tablaAscii {
    public static void main(String[] args) {
        int i = 0;
        while (i<129) {
        if (i<32){System.out.printf("El valor ascii #%d, representa un caracter no imprimible\n",i);}
        if (i>=32) {
        char caracter = (char) i;
        System.out.println(i+":\""+caracter+"\"");
        }
        i++;
        }
    }
}
