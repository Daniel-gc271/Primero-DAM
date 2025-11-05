/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entregasjava.Tema3;

/**
 *
 * @author goncalda
 */
public class OperacionesAritméticasDanielGonzalez {
    public static void main(String[] args) {
        double numA;
        double numB;
        numA =(int) (Math.random() * 11);
        numB =(int) (Math.random() * 11);
            System.out.println(numA);
            System.out.println(numB);
            
            
            
        if (numB==0) {
            System.out.println("No se puede dividir entre cero");
        } else {System.out.printf("A/B=%f",(numA/numB));}
        
                
    }
}
