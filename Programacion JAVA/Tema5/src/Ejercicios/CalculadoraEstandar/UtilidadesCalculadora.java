/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicios.CalculadoraEstandar;

/**
 *
 * @author goncalda
 */
public class UtilidadesCalculadora {
    public static double suma(double numA, double numB) {
        System.out.println(numA+" + "+numB);
    double res=numA+numB;
        return res;
    }
    public static double resta(double numA, double numB) {
        System.out.println(numA+" - "+numB);
    double res=numA-numB;
        return res;
    }
    public static double prod(double numA, double numB) {
        System.out.println(numA+" * "+numB);
    double res=numA*numB;
        return res;
    }
    public static double qoc(double numA, double numB) {
        System.out.println(numA+" / "+numB);
    double res=numA / numB;
    if (numB !=0) {return res;}
    else {throw new ArithmeticException("No se puede dividir entre 0");}
    }
    
    public static double mod(double numA, double numB) {
       System.out.println(numA+" % "+numB);
    double res= numA % numB;
    if (numB != 0) {return res;}
    else {return numA;}
    }
    
}
