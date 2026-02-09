/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejemplos.Interfaces;

/**
 *
 * @author goncalda
 */
public class MiClase implements MiInterfaz{
    private int att1,att2,att3;

    public MiClase(int att1, int att2, int att3) {
        this.att1 = att1;
        this.att2 = att2;
        this.att3 = att3;
    }

    public int getAtt1() {
        return att1;
    }

    public void setAtt1(int att1) {
        this.att1 = att1;
    }

    public int getAtt2() {
        return att2;
    }

    public void setAtt2(int att2) {
        this.att2 = att2;
    }

    public int getAtt3() {
        return att3;
    }

    public void setAtt3(int att3) {
        this.att3 = att3;
    }

    @Override
    public String toString() {
        return "MiClase{" + "att1=" + att1 + ", att2=" + att2 + ", att3=" + att3 + '}';
    }
    
}
