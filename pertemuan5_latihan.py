import random
from datetime import datetime

mulai = datetime.now()

angka_acak = random.randint(1, 100)
print("Angka acak yang dihasilkan:", angka_acak)

nama_file = "Angka_Yang_Sudah_Di_Acak.txt"
with open(nama_file, "w") as file:
    file.write(f"Angka acak: {angka_acak}\n")

print(f"Hasil disimpan di dalam file: {nama_file}")

selesai = datetime.now()
durasi = selesai - mulai
print("Program selesai pada:", selesai.strftime("%d-%m-%Y %H:%M:%S"))
print("Waktu eksekusi (detik):", durasi.total_seconds(), "detik")
