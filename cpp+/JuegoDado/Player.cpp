
#include "Player.h"
#include <iostream>
using string=std::string;
Player::Player(int bote,int tirada, int apuesta, string nombre) {
    this-> bote = bote;
    this-> tirada=tirada;
    this-> apuesta=apuesta;
    this-> nombre=nombre;
}
void Player::showStats() {
        printf(
R"(H
o
l
a
 
q
u
e

t
a
l
?
)"
"%d", bote);}