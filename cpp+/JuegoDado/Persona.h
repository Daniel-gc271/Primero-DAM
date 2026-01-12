
#pragma once

#include <string>
using string = std::string;
class Persona {
private:
    string nombre;
    int edad;
    string dni;

public:
    Persona(string nombre, int edad, string dni);
    void mostrarInfo();
};

