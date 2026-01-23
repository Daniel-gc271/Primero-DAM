/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema6.Empleado;

/**
 *
 * @author Daniel González clase base que modela los empleados con sus
 * caracteristicas base
 */
public class Empleado {

    private String nombre, apellidos;
    private int IdEmpleado;
    private double sueldoBase;
    private static final double SMI = 1200;
    //Constructores

    public Empleado() {
        this.sueldoBase=this.SMI;
    }

    public Empleado(String nombre, String apellidos, int IdEmpleado, double sueldoBase) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.IdEmpleado = IdEmpleado;
        if (sueldoBase < this.SMI) {
            System.err.println("Sueldo insuficiente, ajustado al SMI");
        } else {
            this.sueldoBase = sueldoBase;
        }
    }

    //Getter setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getIdEmpleado() {
        return IdEmpleado;
    }

    public void setIdEmpleado(int IdEmpleado) {
        this.IdEmpleado = IdEmpleado;
    }

    public double getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(double sueldoBase) {
        this.sueldoBase = sueldoBase;
    }
    //Metodos propios

    @Override
    public String toString() {
        return String.format("""
                             Empleado (%s)
                             Name: %s   Surname: %s
                             Id: %d
                             Base salary: %f
                             """,
                this.getClass().getSimpleName(), this.nombre, this.apellidos, this.IdEmpleado, this.sueldoBase);
    }
     public double salarioMensual() {
        return this.sueldoBase;
    }
}
