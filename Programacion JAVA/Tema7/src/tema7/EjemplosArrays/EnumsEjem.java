/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package tema7.EjemplosArrays;

/**
 *
 * @author goncalda
 */
public enum EnumsEjem {
    EXTRAPEQUEÑA("XS"), PEQUEÑA("S"), MEDIANA("M"), GRANDE("L"), EXTRAGRANDE("XL");
    private final String abreviatura;
    EnumsEjem(String abreviatura){
        this.abreviatura = abreviatura;
    }
    public String getAbreviatura() {
        return abreviatura;
    }
}
