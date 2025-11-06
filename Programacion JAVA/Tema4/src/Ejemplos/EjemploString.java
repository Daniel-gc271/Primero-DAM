/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejemplos;

/**
 *
 * @author goncalda
 */
public class EjemploString {

    public static void main(String[] args) {
        //Crear cadenas
        String s1 = "String 1";
        String s2 = new String("String 2");
        System.out.println(s2);
        String s3 = new String("String 3");
        //Concatenar
        String s4 = s1 + s3;
        System.out.println(s4);
        String s5 = s1.concat(s3);
        System.out.println(s5);
        //Buscar en cadenas
        String s6 = new String("Hola caraculo");
        System.out.println(s6.contains("c"));
        System.out.println(s6.indexOf("u"));
        //Recuperar de una cadena otra subcadena de ella (En este caso recuperar gato)
        
        
        
        String cadenaBuscada = new String();
        cadenaBuscada="gato";
        String ejemploBuscapalabras= "Hola con botas gatopardo";
        int inicioPalabraGato= ejemploBuscapalabras.indexOf(cadenaBuscada);
        int finalPalabraGato=inicioPalabraGato+cadenaBuscada.length();
        System.out.printf("La palabra gato esta en el caracter numero %d%n",inicioPalabraGato+1);
        String subCadena = ejemploBuscapalabras.substring(inicioPalabraGato,finalPalabraGato).toUpperCase();
        System.out.println(subCadena);
        
        //Eliminar espacios en blanco del inicio y final de una cadena
        String s8="    hola     \n"
                + "    mundo\n"
                + "cruel";
        System.out.println(s8.stripIndent());
        System.out.println("casa".compareTo("casita"));
        

    }

}
