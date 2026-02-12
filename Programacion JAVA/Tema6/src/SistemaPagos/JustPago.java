/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemaPagos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author goncalda
 */
public class JustPago {
    private final LocalDateTime momento;
    private final double importe;
    private final DateTimeFormatter formatoFecha;
    private final DateTimeFormatter formatoHora;
    public JustPago(double importe) {
        this.momento=LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        this.importe = importe;
        this.formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.formatoHora = DateTimeFormatter.ofPattern("HH:mm:ss");

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Comprobante de pago:\n");
        sb.append("Fecha: ").append(momento.format(formatoFecha));
        sb.append("\n");
        sb.append("Hora: ").append(momento.format(formatoHora));
        sb.append("\nImporte: ").append(this.importe);
        sb.append('\n');
        return sb.toString();
    }
    
    
}
