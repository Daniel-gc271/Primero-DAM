/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicios;

/**
 *
 * @author Daniel González
 */
public class amigos {

    public static void main(String[] args) {
        int A = 284;
        int B = 220;
        if (sumatoriodivisores(A)==B&&sumatoriodivisores(B)==A) {System.out.printf("%d y %d son numeros amigos", A, B);}
    }

    private static int sumatoriodivisores(int num) {
        int sigma = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                sigma += i;
            } else {
              sigma+=0;  
            }
        }
        return sigma;
    }
}
