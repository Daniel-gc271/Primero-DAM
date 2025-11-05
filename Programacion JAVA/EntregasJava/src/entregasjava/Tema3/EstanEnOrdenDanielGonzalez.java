/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entregasjava.Tema3;

import java.util.Scanner;

/**
 *
 * @author goncalda
 */
public class EstanEnOrdenDanielGonzalez {
    public static void main(String[] args) {
        Scanner scIn=new Scanner(System.in);
        int[] numeros = new int[3];
        for (int i = 0; i < 3; i++) {
        System.out.println("Introduce un numero");
        numeros[i] = scIn.nextInt();
        }
        if (numeros[0]>numeros[1]&&numeros[1]>numeros[2])
        {System.out.println("Estan ordenados de mayor a menor");}
        else if (numeros[0]<numeros[1]&&numeros[1]<numeros[2])
        {System.out.println("Estan ordenados de menor a mayor");}
        else {System.out.println("Estan desordenados");}
    }
}
