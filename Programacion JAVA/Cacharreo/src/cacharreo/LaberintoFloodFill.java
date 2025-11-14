
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.Timer;

public class LaberintoFloodFill extends JFrame {

    public static void main(String[] args) {
        int celdas = 4;
        int[][] matrix = new int[celdas * celdas + 1][celdas * celdas];
        for (int i = 0; i < celdas * celdas + 1; i++) {
            for (int j = 0; j < celdas * celdas; j++) {
                if (i % 2 == 0 && j < celdas * celdas - 1) {
                    matrix[i][j] = 5;
                } else if (i < celdas * celdas) {
                    matrix[i][celdas * celdas - 1] = 8;
                } else {}

            }
            //5 derecha, 8 abajo
        }
        matrix[celdas * celdas][celdas * celdas - 1] = 1;
        int numFilas = matrix.length;
        int numColumnas = matrix[0].length;
        for (int i = 0; i < numFilas; i++) {
            for (int j = 0; j < numColumnas; j++) {
                System.out.printf(" %d", matrix[i][j]);
            }
            System.out.println("");
        }
    }
}
