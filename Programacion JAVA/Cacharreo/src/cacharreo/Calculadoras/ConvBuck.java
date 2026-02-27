/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cacharreo.Calculadoras;

/**
 *
 * @author goncalda
 */
public class ConvBuck extends Conversor {

    public ConvBuck(double vInMin, double vInMax, double vOut, double iOut, double eficiency, double swFreq) {
        super(vInMin, vInMax, vOut, iOut, eficiency, swFreq);
        this.dCycle = calcDuttyCycle();
        this.lInductor = calcLInudctorValue();

    }

    @Override
    public double calcDuttyCycle() {
        return (double) (vOut * eficiency) / vInMax;
    }

    @Override
    public double calcIInudctorIripple() {
        return (double) ((vInMax - vOut) * dCycle) / (swFreq * lInductor);
    }

    @Override
    public double calcLInudctorValue() {
        return (double) (vOut * ((vInMax + vInMin / 2.0) - vOut)) / (iRipple * iOut) * (vInMax + vInMin / 2.0) * swFreq;
    }

}
