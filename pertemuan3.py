print("Program Kasir Sederhana Toko Buah")

nama_pembeli = input("Masukkan nama pembeli: ")  # Input nama pembeli
nama_buah = input("Masukkan Nama Buah: ") # Input nama buah
harga_buah = int(input("Masukkan Harga Buah: ")) # Input harga buah
jumlah_buah = int(input("Masukkan Jumlah Buah: ")) # Input jumlah buah

total_harga = harga_buah * jumlah_buah # Menghitung total harga

if jumlah_buah > 10: # Cek apakah jumlah buah lebih besar dari 10 untuk mendapatkan diskon
    diskon = total_harga * 0.05 # Hitung diskon total harga dikalikan 5%
    total_bayar = total_harga - diskon # Hitung total bayar setelah diskon
else:
    diskon = 0 # Tidak ada diskon
    total_bayar = total_harga # Total bayar sama dengan total harga

print("Nama Pembeli     :", nama_pembeli) # Output nama pembeli
print("Total Harga      : Rp", total_harga) # Output total harga
print("Diskon           : Rp", diskon) # Output diskon
print("Jumlah Buah      :", jumlah_buah, "buah") # Output jumlah buah
print("\nTotal yang harus dibayar : Rp", total_bayar) # Output total yang harus dibayar
