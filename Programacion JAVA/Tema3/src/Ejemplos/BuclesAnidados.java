/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejemplos;

/**
 *
 * @author goncalda
 */
public class BuclesAnidados {

    public static void main(String[] args) {
        int i = 0;
        
        while (i < 3) {
            int j = 0;
            System.out.printf("%d: ",i);
            while (j < 10) {
                
                System.out.printf("%d ",j);
                j++;
            }
            System.out.println("");
            i++;
        }
    }
}
