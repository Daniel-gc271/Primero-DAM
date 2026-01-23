/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicios.Ascensor;
    import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
/**
 *
 * @author goncalda
 */
public class EstudiFechas {


public static void main(String[] args) {
DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
LocalDate date1 = LocalDate.now();
LocalDate date2 = LocalDate.parse("27/04/1997", dtf);

long daysBetween = ChronoUnit.DAYS.between(date1, date2);
System.out.println("Days: " + daysBetween);
}
}

