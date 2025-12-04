/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tema5;

/**
 *
 * @author goncalda
 */
public class PrimoDanielGonzalez {
    public boolean esPrimo(int numero) {
        for (int i = numero/2+1; i>1; i--) {
            if (numero%i==0) {return false;}
            
        }
        return true;
    }  
}
