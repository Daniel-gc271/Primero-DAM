/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cacharreo.Calculadoras;

/**
 *
 * @author goncalda
 */
public abstract class Conversor {

    public Conversor(double vInMin, double vInMax, double vOut, double iOut, double eficiency, double swFreq) {
        this.vInMin = vInMin;
        this.vInMax = vInMax;
        this.vOut = vOut;
        this.iOut = iOut;
        this.eficiency = eficiency;
        this.swFreq = swFreq;
    }
    
   public double vInMin, vInMax, vOut, iOut, dCycle, eficiency,vRipple, iRipple, swFreq, lInductor;
   public abstract double calcDuttyCycle();
   public abstract double calcIInudctorIripple();
   public abstract double calcLInudctorValue();
   
   
   
}
