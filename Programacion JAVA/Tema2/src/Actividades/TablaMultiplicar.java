/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema2;

import java.util.Scanner;

/**
 *
 * @author albagonzalez
 */
public class TablaMultiplicar {
    public static void main(String[] args){
    System.out.println("Hola");
    Scanner scIn=new Scanner(System.in);
    System.out.println("Inserta el numero del que quieres la tabla de multipliclar");
    int numTable = scIn.nextInt();
    System.out.println("Inserta hasta que valor quieres conocer sus productos");
    int numFinal= scIn.nextInt();
    scIn.close();
        for (int i =0; i<=numFinal; i++) {
            System.out.print(i+"*"+numTable+"="+(i*numTable)+"\t");
            
        }
        System.out.print("\n");
    
    
    
    
    }
}
