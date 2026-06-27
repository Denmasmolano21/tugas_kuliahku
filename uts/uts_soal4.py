print("="*50)
print("    SISTEM PEMBELIAN TIKET BIOSKOP")
print("="*50)

# Input data pembeli
nama = input("Masukkan nama pembeli: ")

# Input dan validasi jumlah tiket
jumlah_tiket = input("Masukkan jumlah tiket: ")

# Validasi input harus berupa angka
if jumlah_tiket.isdigit():
    jumlah_tiket = int(jumlah_tiket)
    
    # Validasi jumlah tiket harus positif
    if jumlah_tiket > 0:
        # Konstanta harga tiket
        harga_per_tiket = 50000
        
        # Hitung total harga
        total_harga = jumlah_tiket * harga_per_tiket
        
        # Cek apakah mendapat diskon
        if jumlah_tiket >= 5:
            # Hitung diskon 10%
            potongan = total_harga * 10 / 100
        else:
            # Tidak ada diskon
            potongan = 0
        
        # Hitung total yang harus dibayar
        total_bayar = total_harga - potongan
        
        # Tampilkan hasil
        print("\n" + "="*50)
        print("           RINCIAN PEMBAYARAN")
        print("="*50)
        print("Nama Pembeli    :", nama)
        print("Jumlah Tiket    :", jumlah_tiket, "tiket")
        print("Harga per Tiket : Rp", harga_per_tiket)
        print("-"*50)
        print("Total Harga     : Rp", total_harga)
        print("Potongan (10%)  : Rp", int(potongan))
        print("-"*50)
        print("TOTAL BAYAR     : Rp", int(total_bayar))
        print("="*50)
        
        # Informasi tambahan jika dapat diskon
        if jumlah_tiket >= 5:
            print("Selamat! Anda mendapat diskon 10%")
        else:
            print("Beli 5 tiket atau lebih untuk diskon 10%")
        
        print("\nTerima kasih telah membeli tiket!")
    else:
        print("Error: Jumlah tiket harus lebih dari 0!")
else:
    print("Error: Input harus berupa angka!")