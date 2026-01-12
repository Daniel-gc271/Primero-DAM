

#include <iostream>
#include "Persona.h"
#include "Player.h"
int main() {
    Player jugador(1, 1,1,"Fran");
    jugador.showStats();
    Persona p("Daniel", 30,"71232863T");
    p.mostrarInfo();
    return 0;
}

