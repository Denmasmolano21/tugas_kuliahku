# ======================================================
#    APLIKASI DAFTAR NILAI SISWA SEDERHANA
# ======================================================
# Nama Program: Aplikasi Daftar Nilai Siswa
# Fungsi: Mengelola data nilai siswa
# ======================================================

# Inisialisasi list terpisah untuk nama dan nilai
# List untuk menyimpan nama siswa
nama_siswa = []

# List untuk menyimpan nilai siswa
nilai_siswa = []
11
print("="*50)
print("  APLIKASI DAFTAR NILAI SISWA".center(50))
print("="*50)
print()

# Loop utama program
while True:
    # Tampilkan menu
    print("\n" + "="*50)
    print("MENU UTAMA")
    print("="*50)
    print("1. Tambah Data Siswa")
    print("2. Tampilkan Semua Data Siswa")
    print("3. Tampilkan Statistik (Rata-rata, Tertinggi, Terendah)")
    print("4. Cari Data Siswa Berdasarkan Nama")
    print("5. Keluar")
    print("="*50)
    
    # Input pilihan menu
    pilihan = input("Pilih menu (1-5): ")
    
    # ========== MENU 1: TAMBAH DATA SISWA ==========
    if pilihan == "1":
        print("\n--- TAMBAH DATA SISWA ---")
        
        # Input nama siswa
        nama = input("Masukkan nama siswa: ")
        
        # Validasi nama tidak boleh kosong
        if nama == "":
            print("PERINGATAN: Nama tidak boleh kosong!")
        else:
            # Input nilai siswa
            nilai = input("Masukkan nilai siswa (0-100): ")
            
            # Konversi string ke float
            nilai = float(nilai)
            
            # Validasi rentang nilai
            if nilai < 0 or nilai > 100:
                print("PERINGATAN: Nilai harus antara 0-100!")
            else:
                # Simpan data ke list yang terpisah
                # Nama ke list nama_siswa
                nama_siswa.append(nama)
                
                # Nilai ke list nilai_siswa
                nilai_siswa.append(nilai)
                
                print("DATA BERHASIL DITAMBAHKAN!")
    
    # ========== MENU 2: TAMPILKAN SEMUA DATA ==========
    elif pilihan == "2":
        print("\n--- DAFTAR SEMUA SISWA ---")
        
        # Cek apakah ada data
        if len(nama_siswa) == 0:
            print("Data siswa masih kosong.")
        else:
            # Header tabel
            print("-" * 50)
            print("No.  Nama Siswa                 Nilai")
            print("-" * 50)
            
            # Tampilkan setiap siswa dengan loop
            # Gunakan index untuk mengakses nama dan nilai
            for i in range(len(nama_siswa)):
                nomor = i + 1
                # nama_siswa[i] = nama siswa ke-i
                # nilai_siswa[i] = nilai siswa ke-i
                print(f"{nomor:<5}{nama_siswa[i]:<25} {nilai_siswa[i]:.2f}")
            
            print("-" * 50)
            print(f"Total siswa: {len(nama_siswa)}")
    
    # ========== MENU 3: TAMPILKAN STATISTIK ==========
    elif pilihan == "3":
        print("\n--- STATISTIK NILAI ---")
        
        # Cek apakah ada data
        if len(nilai_siswa) == 0:
            print("Data siswa masih kosong.")
        else:
            # Hitung rata-rata nilai
            total_nilai = 0
            for nilai in nilai_siswa:
                total_nilai = total_nilai + nilai
            
            rata_rata = total_nilai / len(nilai_siswa)
            
            # Cari nilai tertinggi
            nilai_tertinggi = nilai_siswa[0]
            index_tertinggi = 0
            
            for i in range(len(nilai_siswa)):
                if nilai_siswa[i] > nilai_tertinggi:
                    nilai_tertinggi = nilai_siswa[i]
                    index_tertinggi = i
            
            # Ambil nama siswa dengan nilai tertinggi
            nama_tertinggi = nama_siswa[index_tertinggi]
            
            # Cari nilai terendah
            nilai_terendah = nilai_siswa[0]
            index_terendah = 0
            
            for i in range(len(nilai_siswa)):
                if nilai_siswa[i] < nilai_terendah:
                    nilai_terendah = nilai_siswa[i]
                    index_terendah = i
            
            # Ambil nama siswa dengan nilai terendah
            nama_terendah = nama_siswa[index_terendah]
            
            # Tampilkan statistik
            print("-" * 50)
            print(f"Rata-rata nilai    : {rata_rata:.2f}")
            print(f"Nilai tertinggi    : {nilai_tertinggi:.2f} ({nama_tertinggi})")
            print(f"Nilai terendah     : {nilai_terendah:.2f} ({nama_terendah})")
            print(f"Jumlah siswa       : {len(nama_siswa)}")
            print("-" * 50)
    
    # ========== MENU 4: CARI DATA SISWA ==========
    elif pilihan == "4":
        print("\n--- CARI DATA SISWA ---")
        
        # Cek apakah ada data
        if len(nama_siswa) == 0:
            print("Data siswa masih kosong.")
        else:
            # Input kata kunci pencarian
            keyword = input("Masukkan nama siswa yang dicari: ")
            
            # Konversi ke huruf kecil untuk pencarian
            keyword = keyword.lower()
            
            # List untuk menyimpan index hasil pencarian
            index_hasil = []
            
            # Cari siswa dengan loop
            for i in range(len(nama_siswa)):
                # Konversi nama siswa ke huruf kecil
                nama_lower = nama_siswa[i].lower()
                
                # Cek apakah keyword ada dalam nama
                if keyword in nama_lower:
                    index_hasil.append(i)
            
            # Tampilkan hasil
            if len(index_hasil) == 0:
                print(f"Tidak ditemukan siswa dengan nama '{keyword}'")
            else:
                print(f"\nDitemukan {len(index_hasil)} siswa:")
                print("-" * 50)
                print("Nama Siswa                 Nilai")
                print("-" * 50)
                
                for i in index_hasil:
                    print(f"{nama_siswa[i]:<25} {nilai_siswa[i]:.2f}")
                
                print("-" * 50)
    
    # ========== MENU 5: KELUAR ==========
    elif pilihan == "5":
        print("\n" + "="*50)
        print("Terima kasih telah menggunakan aplikasi ini!")
        print("="*50)
        break
    
    # Pilihan tidak valid
    else:
        print("PERINGATAN: Pilihan tidak valid! Silakan pilih 1-5.")
    
    # Tanya apakah ingin mengulang
    print()
    ulang = input("Apakah ingin mengulang kembali? (y/n): ")
    
    if ulang == "n" or ulang == "N":
        print("\n" + "="*50)
        print("Terima kasih telah menggunakan aplikasi ini!")
        print("="*50)
        break

# Program selesai
print("\nProgram selesai dijalankan.")