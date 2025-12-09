/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cacharreo;

/**
 *
 * @author goncalda
 */
public class MotorBBDDV2 {

    /**
     * Recibe un string con bloques separados por comas. En cada bloque la
     * primera "palabra" (secuencia sin espacios) es la que se extrae. Devuelve
     * todas las primeras palabras unidas con el separador "|".
     *
     * Ejemplo de entrada: " alpha beta gamma, delta epsilon zeta " Salida:
     * "alpha|delta"
     */
    public static void main(String[] args) {

//        String entrada = "create table CLIENTES  \n" +
//"( \n" +
//"   NUM_CLIE             INTEGER              not null, \n" +
//"   REP_CLIE             INTEGER              not null, \n" +
//"   EMPRESA              VARCHAR(20), \n" +
//"   LIMITE_CREDITO       NUMBER, \n" +
//"   constraint PK_CLIENTES primary key (NUM_CLIE) \n" +
//");";

        String entrada ="create table CLIENTES daufvsd";
        entrada=entrada.trim().replaceAll("\\s{2,}", " ");
        System.out.println(entrada);
        String tabla="";
        //Buscar inicio de la tabla
        
        int startIndexSearched = 0;
        int endIndexSearched = 0;
        System.out.println(findTableName(entrada));
        
//     
}
public static String findTableName(String cadena) {
 String nombreTabla="";
 String cadenaBuscada = "create table ";
 int indexTableName = cadena.indexOf(cadenaBuscada)+1;