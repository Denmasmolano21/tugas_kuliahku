# Program Pendaftaran Kursus Online "GANEBO"

# Dictionary berisi data paket kursus
# Key: kode paket (1,2,3)
# Value: detail paket (nama, materi, harga)
paket_kursus = {
    1: {"nama": "Cerdas", "materi": "Android Programming", "harga": 3000000},
    2: {"nama": "Ceria", "materi": "Desain Grafis", "harga": 2500000},
    3: {"nama": "Smile", "materi": "Multimedia", "harga": 2000000}
}

# Perulangan utama program (agar bisa transaksi berulang)
while True:
    # Menampilkan judul program
    print("\n"+" "*20+"KURSUS ONLINE \"GANEBO\"")
    print("_"*60)

    # Input jumlah data siswa yang akan dimasukkan
    jumlah_data = int(input("Masukkan Jumlah Data           : "))

    # List untuk menyimpan seluruh data siswa
    data_siswa = []

    # Perulangan untuk input data setiap siswa
    for i in range(jumlah_data):
        # Validasi nama siswa
        nama_valid = False
        while nama_valid == False:
            nama_siswa = input(f"Masukkan Nama Siswa ke {i+1}       : ")
            # Cek panjang nama maksimal 20 karakter
            if len(nama_siswa) > 20:
                print("ERROR: Nama siswa maksimal 20 karakter. Silakan coba lagi.")
            else:
                nama_valid = True
        
        # Validasi paket kursus
        paket_valid = False
        while paket_valid == False:
            paket_input = input("Masukkan Paket Kursus[1/2/3]   : ")
            # Paket hanya boleh 1, 2, atau 3
            if paket_input == "1" or paket_input == "2" or paket_input == "3":
                paket = int(paket_input)
                paket_valid = True
            else:
                print("ERROR: Paket kursus hanya tersedia 1, 2, dan 3. Silakan coba lagi.")
        
        # Menyimpan data siswa ke dalam list
        data_siswa.append({
            "nama": nama_siswa,
            "paket": paket
        })

    # Menampilkan judul rekapitulasi
    print(f"\n{' '*38}REKAPITULASI PENDAFTARAN KURSUS ONLINE")
    print("_"*108)

    # Membuat header tabel
    print("┌" + "─"*106 + "┐")
    print("│  No │     Nama Siswa       │    Nama Paket    │      Harga      │       Materi         │      Bayar      │")
    print("├" + "─"*106 + "┤")

    # Variabel untuk menghitung total harga
    total_harga = 0
    nomor = 1

    # Menampilkan data siswa satu per satu
    for siswa in data_siswa:
        # Mengambil kode paket siswa
        kode_paket = siswa["paket"]
        # Mengambil informasi paket dari dictionary
        info_paket = paket_kursus[kode_paket]

        # Menampilkan baris data siswa
        print(
            f"│  {nomor:<2} │ {siswa['nama']:<20} │ {info_paket['nama']:<16} │ "
            f"Rp.{info_paket['harga']:>12,} │ {info_paket['materi']:<19}  │ "
            f"Rp.{info_paket['harga']:>12,} │"
        )

        # Menambahkan harga paket ke total harga
        total_harga += info_paket['harga']
        nomor += 1

    # Penutup tabel
    print("└" + "─"*106 + "┘")
    # Menampilkan total pembayaran
    print(f"{' '*73+'Total'}             Rp.{total_harga:,}")

    # Validasi input uang bayar
    uang_valid = False
    while uang_valid == False:
        uang_input = input(f"{' '*73+'Uang Bayar'}        Rp.")
        # Mengecek apakah input berupa angka
        if uang_input.isdigit():
            uang_bayar = int(uang_input)
            # Mengecek apakah uang cukup
            if uang_bayar < total_harga:
                print("ERROR: Uang bayar tidak cukup. Silakan masukkan uang yang lebih besar.")
            else:
                uang_valid = True
        else:
            print("ERROR: Input harus berupa angka. Silakan coba lagi.")
    
    # Menghitung uang kembalian
    uang_kembali = uang_bayar - total_harga

    # Menampilkan uang kembalian
    print(f"{' '*73+'Uang Kembali'}      Rp.{uang_kembali:,}")
    
    # Menanyakan apakah ingin transaksi lagi
    transaksi_lagi = input("\nTransaksi Lagi [Y/T] ? ")

    # Jika Y, program mengulang dari awal
    if transaksi_lagi.upper() == "Y":
        continue
    else:
        # Jika tidak T, program berhenti
        print("\nTerima kasih!")
        break
