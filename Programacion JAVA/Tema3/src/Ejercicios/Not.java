/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios;

import static java.lang.Integer.parseInt;
import java.util.Scanner;

/**
 *
 *
 * @author Daniel González
 */
public class Not {

    public static void main(String[] args) {
        Scanner scIn = new Scanner(System.in);

        // Pedir al usuario un numero binario y obtenerlo como string
        System.out.print("Introduce un número binario: ");
        String entrada = scIn.nextLine();

        //Comprobar el numero introducido por el usuario y avisar que ha cometido un error y donde
        int i = 0;
        while (i < entrada.length()) {
            char c = entrada.charAt(i);
            if (c != '0' && c != '1') {
                System.out.println("Entrada inválida. Solo se permiten 0 y 1.");
                System.out.printf("%s el carcater #%d es incorrecto\n",entrada,(i+1));
                System.exit(1);
            }
            i++;
        }

        // Convertir binario a decimal
        int decOrg = Integer.parseInt(entrada, 2);

        // Invertir bits (NOT)
        /* Funcionamiento: se crea un string vacio llamado invBin
         *Mediante el bucle se recorre el string de entrada inicial
        (el numero en bianrio que ha introducido el usuario anteriormente)
        de ese string inicial se va comprobando cada cifra del numero binario,
        mediante el operador "?" en caso de encontrar un 0 se concatena un 1
        += (esta cosa rara de aqui concatena caracteres vale chavles)
        al nuevo string invBin y vicebersa
        */
        String invBin = "";
        i = 0;
        while (i < entrada.length()) {
            invBin += (entrada.charAt(i) == '0') ? '1' : '0';
            i++;
        }
        //Posteriormente se cambia a base 2 base del binario pra q nos entendamos ;)
        int decInv = Integer.parseInt(invBin, 2);

        // Y por ultimo pro no menos importante se imprimen los resultados
        System.out.println("Binario original: " + entrada);
        System.out.println("Decimal original: " + decOrg);
        System.out.println("Binario invertido (NOT): " + invBin);
        System.out.println("Decimal invertido: " + decInv);
    }

}
