/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entregasjava;

/**
 *
 * @author Daniel González
 */
public class AmigosDanielGonzalez {

    public static void main(String[] args) {
        int A = 284;
        int B = 220;

        int sumatorioDivisoresA = sumatoriodivisores(A);

        if (sumatorioDivisoresA == B) {
            int sumatorioDivisoresB = sumatoriodivisores(B);
            if (sumatorioDivisoresB==A) {System.out.printf("%d y %d son amigos%n",A,B);}
        } else {System.out.printf("%d y %d no son amigos%n",A,B);}
        
    }

    private static int sumatoriodivisores(int num) {
        int sigma = 0;
        for (int i = 1; i < num; i++) {
            System.out.println(i);
            if (num % i == 0) {
                sigma += i;
            } else {
                sigma += 0;
            }
        }
        return sigma;
    }

}
