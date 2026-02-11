/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema7.EjemplosArrays;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author goncalda
 */
public class EquipoBasket {

    public static void main(String[] args) {
        int numIntegrantes = 20;
        Random rd = new Random();
        double alturas[]= new double[numIntegrantes];
        double ordenadoCreciente[] = new double[numIntegrantes];
        for (double altura : alturas) {
            System.out.println(altura);
        }
        System.out.println("\n" + Arrays.toString(alturas));
        Arrays.fill(alturas, 15);
        System.out.println("\n" + Arrays.toString(alturas));
        for (int i = 0; i < alturas.length; i++) {
            alturas[i] = rd.nextInt(150, 223);

        }

        System.out.println("\n" + Arrays.toString(alturas));

        System.out.printf(
                "Altura media: %.2f\nAltura minima: %.2f\nAltura maxima: %.2f\n",
                calcMediaAltura(alturas),
                calcMinAltura(alturas),
                calcMaxAltura(alturas));
        ordenadoCreciente = ordenarCrec(alturas);
        System.out.println("Orden creciente:\n");
        for (double elemento : ordenadoCreciente) {
            System.out.printf("%.2f\n",elemento);
        }
    }
    
    private static double calcMediaAltura(double[] alturas) {
        double mediaEquipo = 0;
        for (double altura : alturas) {
            mediaEquipo += altura;
        }
        mediaEquipo /= alturas.length;
        return mediaEquipo;

    }

    private static double calcMaxAltura(double[] alturas) {
        double altMax;
        altMax = alturas[0];
        for (double altura : alturas) {
            if (altura >= altMax) {
                altMax = altura;
            }

        }
        return altMax;
    }

    private static double calcMinAltura(double[] alturas) {
        double altMin;
        altMin = alturas[0];
        for (double altura : alturas) {

            if (altura <= altMin) {
                altMin = altura;
            }

        }
        return altMin;
    }

    private static double[] ordenarCrec(double[] arrayOrdenar) {
        int index = 0;
        double[] arrayOrdenado = arrayOrdenar.clone();
        while (index < arrayOrdenado.length) {
            // Si estamos al principio o el orden es correcto → avanzar
            if (index == 0 || arrayOrdenado[index] >= arrayOrdenado[index - 1]) {
                index++;
            } else {
                // Si el orden está mal → intercambiar y retroceder
                double temp = arrayOrdenado[index];
                arrayOrdenado[index] = arrayOrdenado[index - 1];
                arrayOrdenado[index - 1] = temp;
                index--;
            }
        }
        return arrayOrdenado;
    }

}
