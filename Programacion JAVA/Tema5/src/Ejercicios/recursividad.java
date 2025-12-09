/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicios;

/**
 * 5!
 * @author goncalda
 */
public class recursividad {
    public static void main(String[] args) {
        recursividad obj = new recursividad();
        double factorial=obj.factorialR(11);
        System.out.println(factorial);
        System.out.println(obj.factorialNR(11));
        System.out.println( obj.potenciaNR(2,4));
        obj.imprimirRHasta(1,100);
        obj.imprimirNRHasta (4,8);
        System.out.println(obj.productoNR(2, 3));
        System.out.println(obj.productoR(-2, -3));
        
    }
    
    
    public long factorialR(long n) {
           if (n==0) {return 1;}
        return  n =n*factorialR(--n);
    }
    
    public long factorialNR(long n) {
        long factorial=1;
         for (int i = 1; i <= n; i++) {
            factorial *=i;
        }
           return factorial;
    }
    public long potenciaR(long base, long exponente) {
        if (exponente==0) {return 1;}
        return base= base*potenciaR(base,--exponente);
    }
    public long potenciaNR(long base, long exponente) {
        long potencia=base;
        for (int i = 1; i < exponente; i++) {
            potencia*=base;
            
        }
        return potencia;
    }
    public void imprimirRHasta(long numInicio, long numFinal) {
        if (numInicio>numFinal) {return;}
        System.out.println(numInicio);
         imprimirRHasta(++numInicio,numFinal);
        
    }
    public void imprimirNRHasta (long numInicio, long numFinal) {
        for (long i = numInicio; i <=  numFinal; i++) {
            System.out.println(i);
        }
    
    }
    public long productoNR (long numInicio, long numFinal) {
        long prod=0;
        if (numFinal<0) {
        numInicio = numInicio^numFinal;
        numFinal = numInicio^numFinal;
        numInicio = numInicio^numFinal;
        }
        
        if(numInicio==0||numFinal==0) {return 0;}
        if (numFinal>0) {
        for (long i = 1; i <=  numFinal; i++) {
            prod+=numInicio;
        }
        return prod;
        } else {
            for (long i = numFinal;i<0;i++) {
            prod-=numInicio;
        }
        return prod;
        
        }
        
    
    }
    public long productoR (long numInicio, long numFinal) {
        if (numInicio==0|numFinal==0) return 0;
        return numInicio + productoR(numInicio, --numFinal);
    }
    
}
