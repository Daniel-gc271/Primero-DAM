
#include <iostream>
#include <vector>
#include <fstream>
#include <chrono>
#include <limits>
#include <bitset>
#include <format>

using namespace std;
using namespace std::chrono;

int main()
{
    unsigned long long n;
    cout << "Introduce el límite superior para la criba (máx: " << ULLONG_MAX << "): ";
    cin >> n;

    auto inicio = high_resolution_clock::now();

    vector<bool> esPrimo(n + 1, true);
    esPrimo[0] = esPrimo[1] = false;

    for (unsigned long long i = 2; i * i <= n; i++)
    {
        if (esPrimo[i])
        {
            for (unsigned long long j = i * i; j <= n; j += i)
            {
                esPrimo[j] = false;
            }
        }
    }

    int contadorPrimos = 0;
    ofstream archivo("primos.txt");
    if (!archivo)
    {
        cerr << "Error al abrir el archivo.\n";
        return 1;
    }

    archivo << "Primos hasta " << n << ":\n";
    for (unsigned long long i = 2; i <= n; i++)
    {
        if (esPrimo[i])
        {
            archivo << dec << i << "\t";
            archivo << hex << "Hex: 0x" << i << "\t";

            std::string bin = std::bitset<64>(i).to_string();
            // quitar ceros iniciales (dejando al menos un dígito)
            //bin.erase(0, bin.find_first_not_of('0'));
            //archivo << "Bin: 0b" << bin << "\n";
            archivo<< std::format("0b{:064b}\n", i);
            contadorPrimos++;
        }
    }

    auto fin = high_resolution_clock::now();
    auto duracion = duration_cast<milliseconds>(fin - inicio).count();

    archivo << dec << "\nCantidad de primos encontrados: " << contadorPrimos << "\n";
    archivo << "Tiempo de ejecución: " << duracion << " ms\n";
    archivo.close();

    cout << "Primos guardados en primos.txt\n";
    cout << "Cantidad de primos encontrados: " << contadorPrimos << "\n";
    cout << "Tiempo de ejecución: " << duracion << " ms\n";

    return 0;
}
