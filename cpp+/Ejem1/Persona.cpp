#include "Persona.h"
#include <iostream>

// Lista de inicialización: más eficiente e idiomática
Persona::Persona(const std::string& nombre, int edad, const std::string& dni)
    : nombre(nombre), edad(edad), dni(dni) {}

void Persona::mostrarInfo() const {
    std::cout << "Nombre: " << nombre
              << "\t Edad: " << edad
              << "\t DNI: " << dni
              << '\n';
}

std::string Persona::getName() const {
    return nombre;
}

std::string Persona::getDni() const {
    return dni;
}

int Persona::getAge() const {
    return edad;
}
