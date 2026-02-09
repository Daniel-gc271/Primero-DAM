/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemaPagos;

/**
 *
 * @author goncalda
 */
public class PlataformaPago {
    public static void main(String[] args) {
        JustPago justificante= new JustPago(29.99);
        System.out.println(justificante);
        Paypal paypal= new Paypal("gcdani271gmail.com");
    }
    
}
