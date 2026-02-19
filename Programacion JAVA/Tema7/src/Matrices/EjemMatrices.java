/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Matrices;

/**
 *
 * @author goncalda
 */
public class EjemMatrices {
    
    public static void main(String[] args) {
        Integer [][] array2d = new Integer [4][4];
        array2d[0][0]=00;
        array2d[0][1]=01;
        printMatrix(array2d);
        
    }
    private static void printMatrix(Object[][] array2d) {
     //filas eje y
        for (int i = 0; i < array2d.length; i++) {
            //columnas eje x
            for (int j = 0; j < array2d[0].length; j++) {
                System.out.print(array2d[i][j]+"\t");
                
            }
            System.out.println("");
        }
    
    }
    
}
