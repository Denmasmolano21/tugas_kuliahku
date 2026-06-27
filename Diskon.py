# Program Menghitung Diskon Belanja
print("Program Menghitung Diskon Belanja")

# Tetukan harga dan jumlah barang yang akan diinput
harga = float(input("Masukkan harga barang (Rp): "))
jumlah = int(input("Masukkan jumlah barang: "))
diskon = float(input("Masukkan diskon (%): "))

# Proses perhitungan total, potongan, dan jumlah yang harus dibayar
total = harga * jumlah
potongan = total * (diskon / 100)
bayar = total - potongan

# Mengeluarkan/mencetak hasil rincian pembayaran
print("\n--- Rincian Pembayaran ---")
print(f"Total harga sebelum diskon : Rp{total:,.0f}")
print(f"Potongan diskon            : Rp{potongan:,.0f}")
print(f"Total yang harus dibayar   : Rp{bayar:,.0f}")
