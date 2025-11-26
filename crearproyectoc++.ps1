# Pedir al usuario el nombre del proyecto
$projectName = Read-Host "Introduce el nombre del proyecto"

# Crear la carpeta en el directorio actual
$folderPath = Join-Path -Path (Get-Location) -ChildPath $projectName
New-Item -ItemType Directory -Path $folderPath -Force | Out-Null

# Ruta del archivo .cpp
$filePath = Join-Path -Path $folderPath -ChildPath "main.cpp"

# Contenido del archivo
$code = @'
#include <iostream>
using namespace std;
int main() {
    cout << "Hello, world!" << endl;
    return 0;
}
'@

# Crear el archivo con el contenido
Set-Content -Path $filePath -Value $code

Write-Host "Proyecto '$projectName' creado en $folderPath"
Write-Host "Archivo main generado: $filePath"