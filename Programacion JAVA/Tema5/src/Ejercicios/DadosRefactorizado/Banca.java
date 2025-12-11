/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicios.DadosRefactorizado;

/**
 *
 * @author goncalda
 */
public class Banca {
    
    private boolean turno;
    private int turnosJugados;
    private long tiempoInicio;
    private long tiempoSalida;
    private int bote;
    
    public Banca() {
       this.tiempoInicio = System.currentTimeMillis();
       this.bote= 0;
       this.turnosJugados = 0;
    }
}
