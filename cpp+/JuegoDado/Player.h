#pragma once

#include <string>
using string = std::string;

class Player
{
private:
    int bote;
    int tirada;
    int apuesta;
    string nombre;
public:

    Player(int bote,int tirada, int apuesta, string nombre);
    void showStats();
};