/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Figuras;

/**
 *
 * @author goncalda
 */
public class UtilidadesGeometria {
    public static double calcAnguloVectores(Punto vec1, Punto vec2) {
        double prodEscalar = calcProdEscalar (vec1,vec2);
        double magnitudVec1 = Math.pow(vec1.getPosX(), 2)+ Math.pow(vec1.getPosY(), 2);
        double magnitudVec2 = Math.pow(vec2.getPosX(), 2)+ Math.pow(vec2.getPosY(), 2);
        double cos = prodEscalar/(Math.sqrt(magnitudVec1)*Math.sqrt(magnitudVec2));
        return Math.toDegrees(Math.acos(cos)) ;
    }
    public static double calcProdEscalar (Punto vec1, Punto vec2) {
    double prodEscalar= vec1.getPosX()*vec2.getPosX()+ vec1.getPosY()*vec2.getPosY();
    return prodEscalar;
    }
    public static Punto calcVectorRecta(Punto p1, Punto p2) {
        
        
        return new Punto(p1.getPosX()-p2.getPosX(), p1.getPosY()-p2.getPosY());
    }
    public static void main(String[] args) {
        Punto vec1= new Punto(4, 6);
        Punto vec2= new Punto(-2, 8);
        System.out.println(calcAnguloVectores(vec1, vec2));
    }
}
