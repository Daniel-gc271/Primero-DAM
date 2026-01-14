
#pragma once

#include <string>

class Persona {
private:
    std::string nombre;
    int edad;
    std::string dni;

public:
    // Constructor: parámetros por const referencia para evitar copias
    Persona(const std::string& nombre, int edad, const std::string& dni);

    // Métodos: marcar const cuando no modifican el estado
    void mostrarInfo() const;

    // Getters: por valor (simple/seguro; el compilador suele optimizar bien)
    std::string getName() const;
    std::string getDni() const;
    int getAge() const;
};
