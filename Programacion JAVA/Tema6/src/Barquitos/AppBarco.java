/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Barquitos;

/**
 *
 * @author goncalda
 */
public class AppBarco {
    public static void activaAlarma(Barco barco) {
        barco.alarma();
    }
    public static void main(String[] args) {
        Yate y=new Yate();
        activaAlarma(y);
    }
}
