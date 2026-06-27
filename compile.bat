@echo off
REM Compile all Java source files in this folder
cd /d "%~dp0"
echo Compiling all Java files...
javac *.java
if errorlevel 1 (
    echo Compilation failed.
    exit /b 1
)
echo Compilation successful.