print("SISTEM PERHITUNGAN BIAYA PARKIR")
print("Tarif Parkir:")
print("- 2 jam pertama: Rp 5.000")
print("- Jam berikutnya: Rp 2.000/jam")

# Input jam masuk
jam_masuk = input("\nMasukkan jam masuk (format 24 jam, contoh: 8): ")

# Input jam keluar
jam_keluar = input("Masukkan jam keluar (format 24 jam, contoh: 12): ")

# Validasi input harus berupa angka
if jam_masuk.isdigit() and jam_keluar.isdigit():
    jam_masuk = int(jam_masuk)
    jam_keluar = int(jam_keluar)
    
    # Validasi jam harus antara 0-23
    if 0 <= jam_masuk <= 23 and 0 <= jam_keluar <= 23:
        
        # Validasi jam keluar harus lebih besar dari jam masuk
        if jam_keluar > jam_masuk:
            
            # Hitung durasi parkir
            durasi_parkir = jam_keluar - jam_masuk
            
            # Hitung biaya parkir berdasarkan durasi
            if durasi_parkir <= 2:
                # Jika parkir 2 jam atau kurang
                biaya_parkir = 5000
            else:
                # Jika parkir lebih dari 2 jam
                # 2 jam pertama = Rp 5000
                # Jam berikutnya = (durasi - 2) × Rp 2000
                jam_tambahan = durasi_parkir - 2
                biaya_parkir = 5000 + (jam_tambahan * 2000)
            # Tampilkan hasil
            print("\n")
            print("RINCIAN PARKIR")
            print("Jam Masuk       :", jam_masuk, ":00")
            print("Jam Keluar      :", jam_keluar, ":00")
            print("Durasi Parkir   :", durasi_parkir, "jam")
            # Tampilkan detail perhitungan
            if durasi_parkir <= 2:
                print("2 jam pertama   : Rp 5.000")
            else:
                print("2 jam pertama   : Rp 5.000")
                print("Jam tambahan    :", jam_tambahan, "jam × Rp 2.000 = Rp", jam_tambahan * 2000)
            print("TOTAL BIAYA     : Rp", biaya_parkir)
            print("\nTerima kasih telah menggunakan layanan parkir kami!")
            
        else:
            print("Error: Jam keluar harus lebih besar dari jam masuk!")
    else:
        print("Error: Jam harus antara 0-23!")
else:
    print("Error: Input harus berupa angka!")