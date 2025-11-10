/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cacharreo;

import java.util.Random;

/**
 *
 * @author goncalda
 */
public class PassworGen {

    public static void main(String[] args) {
        int passwordLength = 32;
        char separator = '-';
        int passwordBlockSize = 8;
        Random aleatorio = new Random();
        System.out.println(genSpecialChar(aleatorio));
        
 StringBuilder password = new StringBuilder();

        for (int i = 0; i < passwordLength; i++) {
            int tipo = aleatorio.nextInt(3); // 0 = minúscula, 1 = mayúscula, 2 = especial
            char caracter;

            switch (tipo) {
                case 0:
                    caracter = genLowercaseChar(aleatorio);
                    break;
                case 1:
                    caracter = genUppercaseChar(aleatorio);
                    break;
                default:
                    caracter = genSpecialChar(aleatorio);
                    break;
            }

            password.append(caracter);

            // Añadir separador si corresponde
            if ((i + 1) % passwordBlockSize == 0 && i != passwordLength - 1) {
                password.append(separator);
            }
        }

        System.out.println("Contraseña generada: " + password);
    }

    

    private static char genLowercaseChar(Random numAleatorio) {
        char caracter = (char) numAleatorio.nextInt(97, 123);
        return caracter;
    }

    private static char genUppercaseChar(Random numAleatorio) {
        char caracter = (char) numAleatorio.nextInt(65, 91);
        return caracter;
    }

    private static char genSpecialChar(Random numAleatorio) {
        char caracter;
        do {
            caracter = (char) numAleatorio.nextInt(33, 39);
        } while ((int) caracter == 34);
        return caracter;
    }
    
}
