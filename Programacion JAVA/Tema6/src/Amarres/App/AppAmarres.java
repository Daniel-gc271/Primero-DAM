/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Amarres.App;

import Amarres.Model.Barco;
import Amarres.Model.Deportivo;
import Amarres.Model.Yate;
import java.util.Scanner;

/**
 *
 * @author goncalda
 */
public class AppAmarres {

    /**
     *
     */
    public static void main(String[] args) {
        Barco y = new Yate(10, 12, "2665CNP", "2024", 29);
        System.out.println(y);
    }

}
