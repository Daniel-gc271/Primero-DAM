/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicios;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author goncalda
 */
public class MasLarga {

    public static void main(String[] args) {
        ArrayList<Integer> lengFrase = new ArrayList<>();
        ArrayList<String> frases = new ArrayList<>();
        Scanner scIn = new Scanner(System.in);
        String frase=new String("");
        int IndiceFraseMasLarga=0;
        int lastLengthCHKD;    
        do {
            System.out.println("Introduce frases para comrobar cual es la mas larga (frase vacia para terminar)");
            frase=scIn.nextLine();
            if (frase.isBlank()){frases.add(frase);lengFrase.add(frase.length());}
        } while (!frase.isBlank());
        lastLengthCHKD=lengFrase.getFirst();
        for (int i = 0; i < lengFrase.size(); i++) {
            
            if(lastLengthCHKD<=lengFrase.get(i)) {lastLengthCHKD=lengFrase.get(i);
                IndiceFraseMasLarga=i;} else {
                
            }  
        }
        String FraseMasLarga=frases.get(IndiceFraseMasLarga);
        int longFraseMasLarga = lengFrase.get(IndiceFraseMasLarga);
        System.out.printf("La frase más larga es \"%s\" y mide %d caracteres%n",FraseMasLarga,longFraseMasLarga);
    
    }
}
