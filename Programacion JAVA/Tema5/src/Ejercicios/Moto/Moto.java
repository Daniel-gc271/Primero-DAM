/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicios.Moto;

/**
 *
 * @author goncalda
 */
public class Moto {

    //Atributos
    private String matrícula;
    private String marca;
    private String modelo;
    private int potencia;
    private double combustibleActual;
    private boolean arrancado;
    private int velocidadActual;
    private final int velocidadMaxima;
    private final int aceleracion=10;
    private final double autonomiaMaxima;
    private final double consumoXAceleron = 0.5;
    private final int ocupantesMaximos;

    public Moto(String matrícula, int velocidadMaxima, double autonomiaMaxima, int ocupantesMaximos) {
        this.matrícula = matrícula;
        this.velocidadMaxima = velocidadMaxima;
        this.autonomiaMaxima = autonomiaMaxima;
        this.ocupantesMaximos = ocupantesMaximos;
    }

    public Moto(String matrícula, String marca, String modelo, int potencia, double combustibleActual, boolean arrancado, int velocidadActual, int velocidadMaxima, double autonomiaMaxima, int ocupantesMaximos) {
        this.matrícula = matrícula;
        this.marca = marca;
        this.modelo = modelo;
        this.potencia = potencia;
        this.combustibleActual = combustibleActual;
        this.arrancado = arrancado;
        this.velocidadActual = velocidadActual;
        this.velocidadMaxima = velocidadMaxima;
        this.autonomiaMaxima = autonomiaMaxima;
        this.ocupantesMaximos = ocupantesMaximos;
    }

    private void setArrancado(boolean arrancado) {
        this.arrancado = arrancado;
    }

    public void arrancar() //throws Exception 
    {
        if (this.combustibleActual <= 1.5) {
            System.out.println("No hay combustible");
        } else {
            setCombustibleActual(this.combustibleActual - 1.5);
        }
        if (!this.arrancado) {
            System.out.println("Arrancando la moto");
            System.out.println("Brrrm Brrrrrm");
        } else {
            System.out.println("La moto ya esta arrancada");
            //throw new Exception("The motorcycle is already on");
        }
    }

    public void parar() //throws Exception 
    {
        if (!this.arrancado) {
            System.out.println("La moto ya esta parada");
            //throw new Exception("The motorcycle is already off");
        } else {
            System.out.println("Parando la moto");
        }
    }

    private void setCombustibleActual(double combustibleRepostado) {
        this.combustibleActual = combustibleRepostado;
    }

    public void repostar() throws Exception {
        if (this.arrancado == true) {
            throw new Exception("No puedes repostar con la moto arrancada");
        }
        this.combustibleActual = this.autonomiaMaxima;
    }

    public void repostar(double combustibleRepostado) throws Exception {
        if (this.arrancado == true) {
            throw new Exception("No puedes repostar con la moto arrancada");
        }

        double nuevoCombustible = this.combustibleActual + combustibleRepostado;
        if (nuevoCombustible <= this.autonomiaMaxima) {
            setCombustibleActual(nuevoCombustible);
        } else {
            System.out.println("No puedes repostar tanto");
            repostar();
        }

    }

    public void setVelocidadActual(int velocidadActual) {
        this.velocidadActual = velocidadActual;
    }

    public void acelerar() throws Exception {
        if (this.combustibleActual < consumoXAceleron) {
            throw new Exception("Necesitas mas combustible para acelerar");
        }
        if (this.velocidadActual+this.aceleracion>this.velocidadMaxima) {
            throw new Exception("No puedes acelerar por encima de la velocidad máxima");
        }
        int nuevaVelocidad = this.velocidadActual + aceleracion;
        double nuevoCombustible = this.combustibleActual - consumoXAceleron;
        if (nuevaVelocidad <= this.velocidadMaxima && nuevoCombustible >= 0) {
            setVelocidadActual(nuevaVelocidad);
            setCombustibleActual(nuevoCombustible);
        } else {
            System.out.println("No puedes acelerar");
        }

    }
    public void decelerar() {
        int nuevaVelocidad = this.velocidadActual - 5;
        if (nuevaVelocidad >= 0) {
            setVelocidadActual(nuevaVelocidad);
        } else {
            System.out.println("No puedes decelerar");
        }

    }

}
