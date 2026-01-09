
#include "Persona.h"
#include <iostream>
using string = std::string;
Persona::Persona (string nombre, int edad, string dni) {
    this->nombre = nombre;
    this->edad = edad;
    this->dni = dni;
}

void Persona::mostrarInfo() {
   
    std::cout << "Nombre: " << nombre << ", Edad: " << edad << ", DNI: " << dni<<'\n';
}

