/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.cola_BIS;

/**
 *
 * @author macarena
 */
public class Documento {
    
    private String nombreDocumento;
    private int numPaginas;

    public Documento(String nombreDocumento, int numPaginas) {
        this.nombreDocumento = nombreDocumento;
        this.numPaginas = numPaginas;
    }

    public String getNombreDocumento() {
        return nombreDocumento;
    }

    public void setNombreDocumento(String nombreDocumento) {
        this.nombreDocumento = nombreDocumento;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    @Override
    public String toString() {
        return nombreDocumento;
    }
    
    
    
}
