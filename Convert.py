# Mencetak teks Program Konversi Rupiah ke Dollar
print("Program Konversi Rupiah ke Dollar")

# Tetukan nominal uang dalam Rupiah yang akan di konversikan
rupiah = float(input("Masukkan jumlah uang (Rp): "))

# Proses konversi menggunakan kurs tetap
kurs = 16590

# Pakai rumus Dollar = Rupiah / 16590
dollar = rupiah / kurs

# Mengeluarkan/mencetak hasil konversi Rupiah ke Dollar
print(f"Hasil konversi: ${dollar:.2f}")
