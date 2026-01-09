#include <iostream>
#include "Math271.h"
static double* sqrtCache = new double[1000];
static bool cacheInitialized = false;


double Math271::sqrt(double square, int iterations)
{
    if (square ==0) return 0;
    double guess = square/2; 
    // Buscamos el primer entero cuyo cuadrado supere o iguale al objetivo
    

    // Aplicamos la fórmula de Herón el número de veces solicitado
    for (int i = 0; i < iterations; i++)
    {
        guess = heronSqrtFormula(square, guess);
    }
    return guess;
}

double Math271::heronSqrtFormula(double square, double guess)
{
    // Fórmula: (x + S/x) / 2
    return (guess + square / guess) / 2.0;
}