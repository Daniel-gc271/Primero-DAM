/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gonzalezdanielretocolas;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 *
 * @author goncalda
 */
public class WebPage {
    private String url,titulo;
    private LocalDateTime fechaVisita;
    
    public WebPage(String url, String titulo, LocalDateTime fechaVisita) {
        this.url = url;
        this.titulo = titulo;
        this.fechaVisita = fechaVisita;
    }

    
    
    
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDateTime getFechaVisita() {
        return fechaVisita;
    }

    public void setFechaVisita(LocalDateTime fechaVisita) {
        this.fechaVisita = fechaVisita;
    }

    @Override
    public String toString() {
        String patronFecha="EEEE d 'de' MMMM 'de' uuuu 'a las' HH:mm:ss";
        DateTimeFormatter formateadorFecha =DateTimeFormatter.ofPattern(patronFecha);
        StringBuilder sb = new StringBuilder();
        sb.append("Fecha de visita: ").append((String)formateadorFecha.format(this.fechaVisita));
        sb.append("    ");
        sb.append("URL: ").append(url);
        sb.append("    ");
        sb.append("Título: ").append(titulo);
        return sb.toString();
    }
    
}
