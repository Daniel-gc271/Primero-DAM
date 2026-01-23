/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema6.Empleado;

/**
 *
 * @author Daniel González
 */
public class ProgramadorJunior extends Programador {

    public ProgramadorJunior(double complementoProductividad, int horas, double precioHora) {
        super(complementoProductividad, horas, precioHora);
    }

    public ProgramadorJunior(double complementoProductividad, int horas, double precioHora, String nombre, String apellidos, int IdEmpleado, double sueldoBase) {
        super(complementoProductividad, horas, precioHora, nombre, apellidos, IdEmpleado, sueldoBase);
    }

    @Override
    public String toString() {
        return super.toString();
    }
    public double salarioMensual() {
        return super.salarioMensual();
    }
       
}
