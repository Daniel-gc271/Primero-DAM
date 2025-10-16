/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tema2;

/**
 *
 * @author Daniel González
 */
public class Intercambio {
    public static void main(String[] args){
    int varA;
    int varB;
    
    varA=1;
    varB=3;
    System.out.printf("Valor A antes del cambio:%2d \n", varA);
    System.out.printf("Valor B antes del cambio:%2d \n", varB);
    //Ejecutar el cambio
    int varTemp;
    varTemp = varB;
    varB = varA;
    varA = varTemp;
        System.out.println("Ahora se efectuara el cambio");
    System.out.printf("Valor A despues del cambio:%2d \n", varA);
    System.out.printf("Valor B despues del cambio:%2d \n", varB);
    
            
    
    
    
    
    
    
    
    }
}
