/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entregasjava.Tema2;

import java.util.Scanner;

/**
 *
 * @author albagonzalez
 */
public class PorcentajeNotasDanielGonzalez {

    public static void main(String[] args) {
        //Acopiar valores del usuario
        Scanner scIn = new Scanner(System.in);
        System.out.println("Introduce el numero de alumnos con una calificacion de sobresaliente");
        int Sob = scIn.nextInt();
        System.out.println("Introduce el numero de alumnos con una calificacion de notable");
        int Not = scIn.nextInt();
        System.out.println("Introduce el numero de alumnos con una calificacion de suficiente");
        int Suf = scIn.nextInt();
        System.out.println("Introduce el numero de alumnos con una calificacion de insuficiente");
        int Ins = scIn.nextInt();
        System.out.println("Introduce el numero de alumnos no evaluados");
        int Nev = scIn.nextInt();
        scIn.close();
        //Calcular alumnos presentados
        int totPres = Sob + Not + Suf + Ins;
        //Calcular alumnos aprobados
        int totPass = Sob + Not + Suf;
        //Calcular total de alumnos
        int totAlum = Sob + Not + Suf + Ins + Nev;
        //Calcular diversos porcentajes
        double xCentSob = (double) Sob / totAlum * 100;
        double xCentNot = (double) Not / totAlum * 100;
        double xCentSuf = (double) Suf / totAlum * 100;
        double xCentIns = (double) Ins / totAlum * 100;
        double xCentNev = (double) Nev / totAlum * 100;
        //Calcular % alumnos evaluados
        double xCentEval = (double) (totAlum - Nev) / totAlum * 100;
        //Calcular % alumnos aprovados
        double xCentPass = (double) totPass / totPres * 100;
        //Imprimir salida
        System.out.println(totPass);
        double xCentSuspenso = (double) Ins / totPres;
        System.out.println(
                "Sb: " + xCentSob + "%\t"
                + "Nt: " + xCentNot + "%\t"
                + "Suf: " + xCentSuf + "%\t"
                + "Ins: " + xCentIns + "%\t"
                + "Nev: " + xCentNev + "%\t"
                + "Ev: " + (xCentEval) + "%\t"
                + "aprobados: " + xCentPass + "%\t"
                + "suspensos: " + xCentSuspenso + "%\t"
                + "no presentados: " + xCentNev + "%\n"
        );

    }
}
