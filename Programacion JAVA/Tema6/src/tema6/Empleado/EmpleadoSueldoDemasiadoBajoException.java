/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema6.Empleado;

/**
 *
 * @author Daniel González
 */
public class EmpleadoSueldoDemasiadoBajoException extends Exception{

    public EmpleadoSueldoDemasiadoBajoException(double sueldo) {
        super(String.format("El sueldo introducido (%f) es inferior al SMI (1200)", sueldo));
    }

    
    
}
