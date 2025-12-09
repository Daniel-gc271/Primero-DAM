
@echo off
:: Solicitar el número al usuario
set /p num=Introduce el número del ejercicio: 

:: Crear la carpeta principal
set folder=Ejercicio%num%
mkdir %folder%

:: Crear la subcarpeta assets
mkdir %folder%\assets

:: Crear el archivo style.css vacío
echo. > %folder%\style.css

:: Crear el archivo index.html con el contenido solicitado
(
echo ^<!DOCTYPE html^>
echo ^<html lang="en"^>
echo ^<head^>
echo     ^<meta charset="UTF-8"^>
echo     ^<meta name="viewport" content="width=device-width, initial-scale=1.0"^>

echo     ^<link rel="stylesheet" href="./style.css"^>
echo     ^<title^>ejercicio%num%^</title^>
echo ^</head^>
echo ^<body^>
echo     
echo ^</body^>
echo ^</html^>
) > %folder%\index.html

echo Carpeta y archivos creados correctamente en %folder%.
pause
