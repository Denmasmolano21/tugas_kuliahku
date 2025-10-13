# Program Menghitung Gaji Karyawan
print("Program Menghitung Gaji Karyawan")

# Tetukan nominal gaji pokok yang akan diinput
gaji_pokok = float(input("Masukkan gaji pokok: "))

# Input tunjangan dan potongan
tunjangan = float(input("Masukkan tunjangan: "))
potongan = float(input("Masukkan potongan: "))

# Proses perhitungan gaji bersih
gaji_bersih = gaji_pokok + tunjangan - potongan

# Mencetak hasil perhitungan gaji
print("\n--- Hasil Perhitungan Gaji ---")
print(f"Gaji Pokok     : Rp{gaji_pokok:,.0f}")
print(f"Tunjangan      : Rp{tunjangan:,.0f}")
print(f"Potongan       : Rp{potongan:,.0f}")
print(f"\nGaji Bersih    : Rp{gaji_bersih:,.0f}")