@echo off
:: Verifica si se ha pasado un argumento (el .jar arrastrado)
if "%~1"=="" (
    echo Arrastra un archivo .jar sobre este .bat para ejecutarlo.
    pause
    exit /b
)

:: Ejecuta el .jar con Java
java -jar "%~1"
pause