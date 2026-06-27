@echo off
setlocal enabledelayedexpansion
cd /d "%~dp0"

echo.
echo ===== PILIH PROGRAM YANG INGIN DIJALANKAN =====
echo.

REM Create list of .class files
set count=0
for %%f in (*.class) do (
    set /a count+=1
    set "class[!count!]=%%~nf"
    echo [!count!] %%~nf
)

echo.
if %count% equ 0 (
    echo ERROR: Tidak ada file .class yang ditemukan.
    echo Jalankan compile.bat terlebih dahulu.
    pause
    exit /b 1
)

echo.
set /p choice="Masukkan nomor pilihan (1-%count%): "

if not defined choice (
    echo ERROR: Pilihan tidak boleh kosong.
    pause
    exit /b 1
)

REM Validate choice
if %choice% lss 1 (
    echo ERROR: Pilihan harus lebih besar dari 0.
    pause
    exit /b 1
)

if %choice% gtr %count% (
    echo ERROR: Pilihan harus lebih kecil atau sama dengan %count%.
    pause
    exit /b 1
)

REM Run selected class
set "selected=!class[%choice%]!"
echo.
echo ===== Menjalankan: %selected% =====
echo.
java %selected%

echo.
echo ===== Program selesai =====
pause