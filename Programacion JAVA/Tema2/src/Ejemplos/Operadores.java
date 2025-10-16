/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejemplos;

/**
 *
 * @author goncalda Ejemplo de uso de los diferentes operadores en java
 * Asignacion Aritmeticos + - * / % (m?dulo) 
 * Relacionales
 * < > == <= >= != L?gicos AND && OR || NOT ! XOR ^
 */
public class Operadores {

    public static void main(String[] args) {
        //Operadores aritm?ticos
        int a;
        int b;
        int i1;
        int i2;
        a = 12;
        b = 7;
        i1 = 1;
        i1 = 2;
        System.out.println(a + b);
        System.out.println(a - b);
        /*
        no saca decimales, dos soluciones
        cambiar el tipo de variable o hacer un casting
         */
        System.out.println((double) a / b);
        System.out.println(a * b);
        System.out.println(a % b);
        // ++ Incremento en una unidad 
        // --Decremento en una unidad 
        // +=x Incremento en x 
        // -=x Decremento en x 
        i1++;
        System.out.println(i1);
        //operadores relacionales devuelven si se cumple una condicion 
        int edad = 25;
        System.out.println("Es mayor de edad " + (edad > 18));
        int nota = 4;
        System.out.println("Est? suspenso? " + (nota < 5));
        int edadA = 18;
        int edadB = 19;
        System.out.println("Tienen la misma edad? " + (edadA == edadB));
        System.out.println("Tienen distinta edad? " + (edadA != edadB));
        //Logicos
        //AND &&
        //OR ||
        //NOT !
        boolean hasLicense = false;
        edad = 17;
        boolean canDrive = hasLicense && !(edad < 18);
        System.out.println("Puede conducir? " + canDrive);
        if (hasLicense && !(edad < 18)) {
            System.out.println("Si puede conducir");
        } else 
        {
            System.out.println("No puede conducir");
        }
        /*
        Programa que dependiendo de la edad te dice la propina semanal que recibes
        en funcion de si eres menor (20?) o mayor de edad (50?) la edad se introduce por teclado, emplea el operador ? 
        */
        //Operador ? sustituye en ciertos casos devolviendo un valor u otro en funcion de la condicion
        int paga = (edad>18)?20:50;

    }
}
