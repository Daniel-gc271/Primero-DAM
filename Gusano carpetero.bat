@echo off
setlocal enabledelayedexpansion

:: --- CONFIGURA AQUÍ EL NOMBRE DE LA CARPETA A CREAR ---
set "NOMBRE_CARPETA=Prueba

:: Directorio actual del script
set "DIR_ACTUAL=%~dp0"

echo Carpeta a crear: %NOMBRE_CARPETA%
echo Directorio actual: %DIR_ACTUAL%
echo.

:: Crear la carpeta si no existe



if not exist "%DIR_ACTUAL%%NOMBRE_CARPETA%" mkdir "%DIR_ACTUAL%%NOMBRE_CARPETA%"

set "URL=https://picsum.photos/800/600"
set "DEST=%DIR_ACTUAL%%NOMBRE_CARPETA%\imagen_random.jpg"


powershell -Command "Write-Host 'DESCARGANDO'; (New-Object Net.WebClient).DownloadFile('%URL%', '%DEST%')"
echo ERRORLEVEL = %ERRORLEVEL%
pause

echo Imagen guardada en: %DEST%
pause






set "TIENE_SUBCARPETAS=0"

for /d %%A in ("%DIR_ACTUAL%*") do (
    set "CARPETA=%%~nxA"

    :: Omitir la carpeta cuyo nombre coincide con NOMBRE_CARPETA
    if /I "!CARPETA!" NEQ "%NOMBRE_CARPETA%" (

        set "TIENE_SUBCARPETAS=1"
        echo Procesando subcarpeta: %%A

        :: Copiar la carpeta creada
        xcopy "%DIR_ACTUAL%%NOMBRE_CARPETA%" "%%A\%NOMBRE_CARPETA%" /E /I /Y >nul

        :: Copiar este script
        copy "%~f0" "%%A\propagar.bat" >nul

        :: Ejecutar script dentro del hijo (misma ventana, sin abrir nueva)
        pushd "%%A"
        call "propagar.bat"
        popd
    ) else (
        echo Omitiendo carpeta: %%A
    )
)

:: Si no hay más subcarpetas, eliminarse
if "%TIENE_SUBCARPETAS%"=="0" (
    echo No hay más subcarpetas. Eliminando script...
    del "%~f0"
    exit /b
)

:: Eliminar script padre
echo Eliminando script padre...
del "%~f0"
exit /b