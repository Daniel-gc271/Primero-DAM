/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema6.Empleado;

/**
 *
 * @author Daniel González
 */
public class Técnico extends Empleado {

    private String especialidad;
    private double plusPeligrosidad;
    public Técnico() {
    }

    public Técnico(String especialidad, double plusprivacidad) {
        this.especialidad = especialidad;
        this.plusPeligrosidad = plusprivacidad;
    }

    public Técnico(String especialidad, double plusprivacidad, String nombre, String apellidos, int IdEmpleado, double sueldoBase) {
        super(nombre, apellidos, IdEmpleado, sueldoBase);
        this.especialidad = especialidad;
        this.plusPeligrosidad = plusprivacidad;
    }

    

    
    
    
    
    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {

        return String.format(super.toString() + """
                                                      especialidad: %s
                                                      """, this.especialidad);
    }
    public double salarioMensual() {
        return super.salarioMensual()+ this.plusPeligrosidad;
    }
}
