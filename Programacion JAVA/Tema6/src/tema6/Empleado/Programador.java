/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema6.Empleado;

/**
 *
 * @author Daniel González
 */
public class Programador extends Empleado {
    private double complementoProductividad;
    private int horas;
    private double precioHora;
    //Constructor

    public Programador(double complementoProductividad, int horas, double precioHora) {
        this.complementoProductividad = complementoProductividad;
        this.horas = horas;
        this.precioHora = precioHora;
    }

    public Programador(double complementoProductividad, int horas, double precioHora, String nombre, String apellidos, int IdEmpleado, double sueldoBase) {
        super(nombre, apellidos, IdEmpleado, sueldoBase);
        this.complementoProductividad = complementoProductividad;
        this.horas = horas;
        this.precioHora = precioHora;
    }

   
    
    
    
    
    
    //getter setter
    public double getComplementoProductividad() {
        return complementoProductividad;
    }

    public void setComplementoProductividad(double complementoProductividad) {
        this.complementoProductividad = complementoProductividad;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public double getPrecioHora() {
        return precioHora;
    }

    public void setPrecioHora(double precioHora) {
        this.precioHora = precioHora;
    }
    
    //Metodos
    
    @Override
    public String toString() {
            return String.format(super.toString()+"""
                                                  horas: %d
                                                  Precio por hora: %f
                                                  Complementos:
                                                    Productividad: %f
                                                  """, this.horas,this.precioHora, this.complementoProductividad);
        }
    public double salarioMensual() {
        return super.salarioMensual()+ this.complementoProductividad+((double)this.precioHora*this.horas);
    }
    
}
