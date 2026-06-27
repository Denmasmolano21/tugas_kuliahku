import sys
print("Versi Python:", sys.version)

print("Argumen Command Line:", sys.argv)
if len(sys.argv) < 2:
    print("Harap masukkan argumen!")
    sys.exit()
print("Program berjalan dengan argumen:", sys.argv[1])