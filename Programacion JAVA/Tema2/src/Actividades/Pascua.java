package Ejercicios;

import java.util.Scanner;

/**
 *
 * @author goncalda
 */
public class Pascua {

    public static void main(String[] args) {
        Scanner scIn = new Scanner(System.in);
        System.out.println("Introduce un año para saber cuando es el domingo de pascua");
        int Año = scIn.nextInt();
        scIn.close();
        int A = Año % 19;
        int B = Año % 4;
        int C = Año % 7;
        int D = (19 * A + 24) % 30;
        int E = (2 * B + 4 * C + 6 * D + 5) % 7;
        int N = 22 + D + E;
        String msg = (N <= 31) ? "Marzo" : "Abril";
        N %= 31;
        System.out.printf("Pascua es el domingo %d de %s del %d\n", N, msg, Año);

    }
}
