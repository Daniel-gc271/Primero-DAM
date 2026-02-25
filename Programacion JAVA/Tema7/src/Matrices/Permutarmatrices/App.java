/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Matrices.Permutarmatrices;

import javax.swing.JOptionPane;

/**
 *
 * @author bazgomjo
 */
public class App {
    
    //constantes
    public static final int dimensionMax=10;//dimension maxima de la matriz
    public static final int dimensionMin=2;//dimension minima de la matriz
    
    
    private static Integer[] getvalores(){
        Integer[] array=new Integer[dimensionMax-dimensionMin+1];
        int valor=dimensionMin;
        for (int i = 0 + dimensionMin; i <= dimensionMax; i++) {
            array[i-dimensionMin]=i;
        }
        return array;
    }
    
    public static void main(String[] args) {
        
        Integer[] valores=getvalores();
        
       Integer filas =(Integer) JOptionPane.showInputDialog(null, "Introduce numero de filas", "Dimension madtriz", -1, null, valores, valores[0]);//valores son los valores de un array de objeto y valores[0]es para que aparezca en la ventana un valor por defecto.
        // JOptionPane.showInputDialog(null, "Introduce numero de columnas", "Dimension madtriz", -1, null, valores2, valores2[0]);
        System.out.println(filas);
        if (filas==null) {return;}
    
        
       Integer columnas =(Integer) JOptionPane.showInputDialog(null, "Introduce numero de columnas", "Dimension madtriz", -1, null, valores, valores[0]);//valores son los valores de un array de objeto y valores[0]es para que aparezca en la ventana un valor por defecto.
        // JOptionPane.showInputDialog(null, "Introduce numero de columnas", "Dimension madtriz", -1, null, valores2, valores2[0]);
        System.out.println(columnas);
        if (columnas==null) {return;}
        GUIMatriz gui=new GUIMatriz (new Integer[filas][columnas]);
    }
    
    
}
