package SolucionAmarres.barcos;

import java.time.LocalDate;

public class Alquiler {

    private int idAlquiler;
    private Cliente cli;
    private LocalDate fechaIni;
    private LocalDate fechaFin;
    private Amarre amarre;
    private Barco barco;

    public Alquiler(int idAlquiler, Cliente cli, LocalDate fechaIni, LocalDate fechaFin, Amarre amarre, Barco b) { //b=v   b=y
        this.idAlquiler=idAlquiler;
        this.cli = cli;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
        this.amarre = amarre;
        this.amarre.asignarBarco(b);
        this.barco = b;
    }

    public Cliente getCli() {
        return cli;
    }

    public Amarre getAmarre() {
        return amarre;
    }

    public Barco getBarco() {
        return barco;
    }

    public LocalDate getFechaFin() {
       return fechaFin;
    }

    public LocalDate getFechaIni() {
       return fechaIni;
    }

    public void setCli(Cliente cli) {
        this.cli = cli;
    }

    public void setAmarre(Amarre amarre) {
        this.amarre = amarre;
    }

    public void setBarco(Barco barco) {
        this.barco = barco;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setFechaIni(LocalDate fechaIni) {
        this.fechaIni = fechaIni;
    }

    @Override
    public String toString() {
        String s;
        s="Alquiler: " + this.idAlquiler + "\n";
        s += "Cliente: " + this.cli.toString() + "\n";        
        s += "Amarre: " + this.amarre.toString() + "\n";
        s += "Fecha inicio: " + this.getFechaIni() + "Fecha fin: " + this.getFechaFin();
        return s;
    }

    public double totalAlquiler() {       
        long dias=this.fechaFin.toEpochDay() - this.fechaIni.toEpochDay() + 1;
        System.out.println("Días " + dias); //Prueba de cáculo de días
        return dias * barco.getModulo();
    }
}
