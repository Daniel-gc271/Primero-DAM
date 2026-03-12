#include <iostream>
#include <vector>

using std::string;
using std::vector;
using std::cout;
int main() {
    vector<string> nombres(4);
    nombres[0]="Daniel";
    nombres[1]="Pedro";
    nombres[2]="Martina";
    nombres[3]="Marina";
    for (string nombre : nombres)
    {
        cout <<"Hola a: "<<nombre<<'\n';
    }
    cout <<"Bienvenidos al curso de iniciacion a c++"<<'\n';
    return 0;
}