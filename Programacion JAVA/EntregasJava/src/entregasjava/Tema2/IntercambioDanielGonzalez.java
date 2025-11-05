/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entregasjava.Tema2;

/**
 *
 * @author goncalda
 */
public class IntercambioDanielGonzalez {
    public static void main(String[] args) {
        System.out.println("Intercambio de variables mediante xor");
        int numA=10;
        int numB=12;
        System.out.printf("Valores iniciales A=%d\tB=%d%n",numA,numB);
        numA= numA^numB;
        numB= numA^numB;
        numA= numA^numB;
        System.out.printf("Valores intercambiados A=%d\tB=%d%n",numA,numB);
        
        
        
    }
}
