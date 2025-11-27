package entregasjava.Tema3;

import java.util.Scanner;

public class MarcoDanielGonzalez {

    public static void main(String[] args) {
        
        Scanner scIn = new Scanner(System.in);
        int altura;
        int anchura;
        String entradaCaracterMarco;
        char caracterMarco;
        do {
            System.out.println("Introduce la altura del marco");
            altura = scIn.nextInt();

        } while (altura < 2);
        do {
            System.out.println("Introduce la anchura del marco");
            anchura = scIn.nextInt();

        } while (anchura <2);
        
        do {
            System.out.println("Introduce el caracter del borde del marco");
            entradaCaracterMarco = scIn.next();
            caracterMarco = entradaCaracterMarco.charAt(0);
        
        } while (!entradaCaracterMarco.isBlank());

        for (int h = 0; h < altura; h++) {
            for (int b = 0; b < anchura; b++) {
                if (h==0||h==altura-1||b==0||b==anchura-1) {
                       System.out.print("%");    
                   } else {System.out.print(" ");} 
            }
            System.out.print("\n");
        }

        
    }

}
