"""
Program Interaktif Multi-Fungsi - Versi Pemula
Menu:
1. Konversi Suhu (Celsius ↔ Fahrenheit)
2. Cek Ganjil / Genap
3. Hitung Luas Segitiga
4. Keluar
"""

# Program dimulai dengan perulangan untuk menu
ulang = True

while ulang:
    # Tampilkan menu utama
    print()
    print("="*50)
    print("            MENU UTAMA")
    print("="*50)
    print("1. Konversi Suhu (Celsius ↔ Fahrenheit)")
    print("2. Cek Ganjil / Genap")
    print("3. Hitung Luas Segitiga")
    print("4. Keluar")
    print("="*50)
    
    # Input pilihan menu
    pilihan = int(input("Pilih menu (1-4): "))
    
    # Menu 1: Konversi Suhu
    if pilihan == 1:
        print()
        print("="*50)
        print("         KONVERSI SUHU")
        print("="*50)
        print("1. Celsius → Fahrenheit")
        print("2. Fahrenheit → Celsius")
        print("="*50)
        
        jenis = int(input("Pilih jenis konversi (1/2): "))
        
        if jenis == 1:
            # Celsius ke Fahrenheit
            celsius = float(input("Masukkan suhu dalam Celsius: "))
            fahrenheit = (celsius * 9/5) + 32
            print()
            print("Hasil:", celsius, "°C =", fahrenheit, "°F")
            
        elif jenis == 2:
            # Fahrenheit ke Celsius
            fahrenheit = float(input("Masukkan suhu dalam Fahrenheit: "))
            celsius = (fahrenheit - 32) * 5/9
            print()
            print("Hasil:", fahrenheit, "°F =", celsius, "°C")
            
        else:
            print()
            print("Pilihan tidak valid!")
    
    # Menu 2: Cek Ganjil/Genap
    elif pilihan == 2:
        print()
        print("="*50)
        print("         CEK GANJIL / GENAP")
        print("="*50)
        
        bilangan = int(input("Masukkan bilangan bulat: "))
        
        print()
        if bilangan % 2 == 0:
            print("Hasil: Bilangan", bilangan, "adalah bilangan GENAP")
        else:
            print("Hasil: Bilangan", bilangan, "adalah bilangan GANJIL")
    
    # Menu 3: Hitung Luas Segitiga
    elif pilihan == 3:
        print()
        print("="*50)
        print("         HITUNG LUAS SEGITIGA")
        print("="*50)
        
        alas = float(input("Masukkan panjang alas (cm): "))
        tinggi = float(input("Masukkan tinggi segitiga (cm): "))
        
        # Rumus luas segitiga = 1/2 x alas x tinggi
        luas = 0.5 * alas * tinggi
        
        print()
        print("="*50)
        print("Alas segitiga   :", alas, "cm")
        print("Tinggi segitiga :", tinggi, "cm")
        print("Luas segitiga   :", luas, "cm²")
        print("="*50)
    
    # Menu 4: Keluar
    elif pilihan == 4:
        print()
        print("="*50)
        print("Terima kasih telah menggunakan program ini!")
        print("="*50)
        ulang = False  # Menghentikan perulangan
    
    # Pilihan tidak valid
    else:
        print()
        print("Pilihan tidak valid! Silakan pilih menu 1-4.")

print()
print("Program selesai.")