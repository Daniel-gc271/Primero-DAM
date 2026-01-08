/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicios.Racionales;

/**
 *
 * @author goncalda
 */
public class Racional {

    private int numerador, denominador;

    //Constructor
    public Racional() {
        //Por defecto la doy valor de uno
        this.numerador = 1;
        this.denominador = 1;
    }

    public Racional(int _num, int _den) {
        if (_den == 0) {
            throw new ArithmeticException("No puedes dar a un numero racional un denominador igual a 0");
        } else {
            if (_den < 0) {
                //Normalizo el sigo, para evitar el signo negativo en el denominador
                this.numerador = _num * -1;
                this.denominador = _den * -1;
            } else {
                this.numerador = _num;
                this.denominador = _den;
            }
        }
    }

    //Getters y setters
    public int getNumerador() {
        return this.numerador;
    }

    public void setNumerador(int numerador) {
        this.numerador = numerador;
    }

    public int getDenominador() {
        return this.denominador;
    }

    public void setDenominador(int denominador) {
        this.denominador = denominador;
    }

    //Metodos
    public Racional suma(Racional fraccion) {
        int denominadorComun = this.denominador * fraccion.getDenominador();
        int numNuevo = this.numerador * fraccion.getDenominador() + this.denominador * fraccion.getNumerador();
        Racional resultado = new Racional(numNuevo, denominadorComun);
        resultado = resultado.simplificar(resultado);
        return resultado;
    }

    public Racional resta(Racional fraccion) {
        int denominadorComun = this.denominador * fraccion.getDenominador();
        int numNuevo = this.numerador * fraccion.getDenominador() - this.denominador * fraccion.getNumerador();
        Racional resultado = new Racional(numNuevo, denominadorComun);
        resultado = resultado.simplificar(resultado);
        return resultado;
    }

    public Racional multiplicacion(Racional fraccion) {
        int denNuevo = this.denominador * fraccion.getDenominador();
        int numNuevo = this.numerador * fraccion.getNumerador();
        Racional resultado = new Racional(numNuevo, denNuevo);
        resultado = resultado.simplificar(resultado);
        return resultado;
    }

    public Racional division(Racional fraccion) {
        int denNuevo = this.denominador * fraccion.getNumerador();
        int numNuevo = this.numerador * fraccion.getDenominador();
        Racional resultado = new Racional(numNuevo, denNuevo);
        resultado = resultado.simplificar(resultado);
        return resultado;
    }

    /*
    Se emplea el algoritmo de euclides para calcular el maximo comun divisor
    entre el numerador y denominador, por definicion matematica,
    al dividir ambos numeros por el MCD la fraccion quedaria reducida
    a la expresion irreducible
     */
    public Racional simplificar(Racional expresion) {
        int numerador = expresion.getNumerador();
        int denominador = expresion.getDenominador();
        int divisorComun = MCD(numerador, denominador);
        return new Racional(numerador / divisorComun, denominador / divisorComun);
    }

    private static int MCD(int numA, int numB) {
        numA = Math.abs(numA);
        numB = Math.abs(numB);
        while (numB != 0) {
            int mcd = numA % numB; // resto
            numA = numB;
            numB = mcd;
        }
        // Si ambos son 0, devuelve 1 
        // (todos los numeros pueden dividirse por uno)
        return numA == 0 ? 1 : numA;
    }

    public double toDecimal() {
        return (double) this.numerador / this.denominador;
    }

    @Override
    public String toString() {
        if (this.denominador != 1) {
            return this.numerador + "/" + this.denominador;
        } else {
            return String.valueOf(this.numerador);
        }
    }

    public int compareTo(Racional expresion) {
        //Expresion es mayor -> -1
        //Expresion es menor -> 1
        // Ambas iguales -> 0
        if (this.denominador * expresion.getNumerador() == this.numerador * expresion.getDenominador()) {
            return 0;
        }
        if (this.denominador * expresion.getNumerador() > this.numerador * expresion.getDenominador()) {
            return 1;
        }
        return -1;
    }

    public Boolean equals(Racional r) {
        /*
        dos fracciones son equivalentes siempre y cuando
        el producto cruzado del numerador y denominador
        (a/b) == (c/d)
        a*d == c*b mientras los denominadores sean distintos de cero
        cosa que ya se comprueba 
         */
        return this.denominador * r.getNumerador() == this.numerador * r.getDenominador();
    }
    //Debug para mostrar y asegurar el funcionamiento
    
    public static void main(String[] args) {
        Racional r1 = new Racional(1, 3);
        Racional r2 = new Racional(1, 5);
        Racional resultado = new Racional(1, 1);

        System.out.println("Original 1");
        System.out.println(r1.toDecimal());
        System.out.println(r1);

        System.out.println("Original 2");
        System.out.println(r2.toDecimal());
        System.out.println(r2);

        System.out.println("Simplificar 1");
        resultado = r1.simplificar(r1);
        System.out.println(resultado.toDecimal());
        System.out.println(resultado);

        System.out.println("Simplificar 2");
        resultado = r2.simplificar(r2);
        System.out.println(resultado.toDecimal());
        System.out.println(resultado);

        System.out.println("Suma");
        resultado = r1.suma(r2);
        System.out.println(resultado.toDecimal());
        System.out.println(resultado);

        System.out.println("Resta");
        resultado = r1.resta(r2);
        System.out.println(resultado.toDecimal());
        System.out.println(resultado);

        System.out.println("Multiplicacion");
        resultado = r1.multiplicacion(r2);
        System.out.println(resultado.toDecimal());
        System.out.println(resultado);

        System.out.println("Division");
        resultado = r1.division(r2);
        System.out.println(resultado.toDecimal());
        System.out.println(resultado);
        
        System.out.println("Compare");
        int comparacion = r1.compareTo(r2);
        System.out.println(comparacion);
        

        System.out.println("Equals");
        Boolean comprobacion = r1.equals(r2);
        System.out.println(comprobacion);
    }
     

}
