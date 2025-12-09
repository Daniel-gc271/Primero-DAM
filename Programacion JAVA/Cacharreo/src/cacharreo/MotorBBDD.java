/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cacharreo.src.cacharreo;

/**
 *
 * @author goncalda
 */
public class MotorBBDD {

    /**
     * Recibe un string con bloques separados por comas. En cada bloque la
     * primera "palabra" (secuencia sin espacios) es la que se extrae. Devuelve
     * todas las primeras palabras unidas con el separador "|".
     *
     * Ejemplo de entrada: " alpha beta gamma, delta epsilon zeta " Salida:
     * "alpha|delta"
     */
    public static void main(String[] args) {

        String entrada = "create table CLIENTES  \n" +
"( \n" +
"   NUM_CLIE             INTEGER              not null, \n" +
"   REP_CLIE             INTEGER              not null, \n" +
"   EMPRESA              VARCHAR(20), \n" +
"   LIMITE_CREDITO       NUMBER, \n" +
"   constraint PK_CLIENTES primary key (NUM_CLIE) \n" +
");";
        //String entrada ="";
        entrada=entrada.trim().replaceAll("\\s{2,}", " ");
        System.out.println(entrada);
        String tabla="";
        //Buscar inicio de la tabla
        String cadenaBuscada = "create table ";
        int startIndexSearched = 0;
        int endIndexSearched = 0;
//        int contTablas=1;
        while (entrada.indexOf("create table ", startIndexSearched) != -1) {
            //Buscar creacion de la tabla
            cadenaBuscada = "create table ";
            startIndexSearched = entrada.indexOf(cadenaBuscada, startIndexSearched) + cadenaBuscada.length();
            endIndexSearched = entrada.indexOf(" ", startIndexSearched);
            String nombreTabla = entrada.substring(startIndexSearched, endIndexSearched);
            startIndexSearched = 0;
            entrada = entrada.substring(endIndexSearched);
//        System.out.println(startIndexSearched);
//        System.out.printf("Tabla #%d \t %s\n",contTablas,nombreTabla);
//        contTablas++;
            System.out.println(nombreTabla);
            tabla += '\n'+nombreTabla+'\n';
            
            cadenaBuscada = "( ";
            startIndexSearched = entrada.indexOf(cadenaBuscada, startIndexSearched) + cadenaBuscada.length();
            endIndexSearched = entrada.indexOf(" ", startIndexSearched);
            nombreTabla = entrada.substring(startIndexSearched, endIndexSearched);
            System.out.println(nombreTabla);
            while (entrada.indexOf(", ", startIndexSearched) != -1) {
            cadenaBuscada = ", ";
            startIndexSearched = entrada.indexOf(cadenaBuscada, startIndexSearched) + cadenaBuscada.length();
            endIndexSearched = entrada.indexOf(" ", startIndexSearched);
            nombreTabla = entrada.substring(startIndexSearched, endIndexSearched);
            tabla += '\t';
                    tabla+=nombreTabla;
            System.out.println(nombreTabla); }
        }
        System.out.println(tabla);

    }

    //Encontrar un create table
}
