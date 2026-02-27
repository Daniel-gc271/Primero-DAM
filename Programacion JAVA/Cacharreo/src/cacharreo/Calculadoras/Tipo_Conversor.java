/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package cacharreo.Calculadoras;

/**
 *
 * @author goncalda
 */
public enum Tipo_Conversor {
    Buck("BUCK"),Boost("BOOST"),BUCK_BOOST("BUCK-BOOST");
    private final String txt;

    private Tipo_Conversor(String txt) {
        this.txt = txt;
    }

    

    public static Tipo_Conversor Buck() {
        return Buck;
    }

    public static Tipo_Conversor Boost() {
        return Boost;
    }

    public static Tipo_Conversor Buck_Boost() {
        return BUCK_BOOST;
    }

   
    
}
