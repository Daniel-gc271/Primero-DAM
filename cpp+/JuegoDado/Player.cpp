#pragma once;
#include "Player.h"
#include <iostream>
using string=std::string;
Player::Player(int bote,int tirada, int apuesta, string nombre) {
    this-> bote = bote;
    this-> tirada=tirada;
    this-> apuesta=apuesta;
    this-> nombre=nombre;
    Player::showStats() {
        std::cout<<"Hola\n";


    }


}