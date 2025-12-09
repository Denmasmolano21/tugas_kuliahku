# latihan_for.py

start = int(input("Masukkan awal: "))
stop = int(input("Masukkan akhir: "))

hasil = 1

for i in range(start, stop + 1, 3):
    print(i)
    hasil *= i

print("Hasil perkalian =", hasil)
