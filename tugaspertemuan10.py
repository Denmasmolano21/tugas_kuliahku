# Program Penjualan Tiket Bus
print("PENJUALAN TIKET BUS")

# Input data
nama_penumpang = input("Masukkan Nama Penumpang (2 kata): ")
kode_bus = input("Masukkan Kode Bus (RS/SJ/HU): ")

# Konversi nama ke UPPER dan kode bus ke UPPER untuk pengecekan
nama_penumpang = nama_penumpang.upper()
kode_bus = kode_bus.upper()

# Tentukan nama bus dan tampilkan pilihan tujuan berdasarkan kode bus
if kode_bus == "RS":
    nama_bus = "Rosalia"
    print("\nPilihan Tujuan Bus Rosalia:")
    print("1. SBY - Rp 300.000")
    print("2. MLG - Rp 400.000")
    tujuan = input("Masukkan Kode Tujuan (SBY/MLG): ")
    tujuan = tujuan.upper()
    
    if tujuan == "SBY":
        harga = 300000
    elif tujuan == "MLG":
        harga = 400000
    else:
        print("Tujuan tidak tersedia untuk bus Rosalia!")
        exit()
        
elif kode_bus == "SJ":
    nama_bus = "Sinar Jaya"
    print("\nPilihan Tujuan Bus Sinar Jaya:")
    print("1. SLO - Rp 200.000")
    print("2. TGL - Rp 250.000")
    tujuan = input("Masukkan Kode Tujuan (SLO/TGL): ")
    tujuan = tujuan.upper()
    
    if tujuan == "SLO":
        harga = 200000
    elif tujuan == "TGL":
        harga = 250000
    else:
        print("Tujuan tidak tersedia untuk bus Sinar Jaya!")
        exit()
        
elif kode_bus == "HU":
    nama_bus = "Hiba Utama"
    print("\nPilihan Tujuan Bus Hiba Utama:")
    print("1. LMP - Rp 350.000")
    print("2. TGL - Rp 400.000")
    tujuan = input("Masukkan Kode Tujuan (LMP/TGL): ")
    tujuan = tujuan.upper()
    
    if tujuan == "LMP":
        harga = 350000
    elif tujuan == "TGL":
        harga = 400000
    else:
        print("Tujuan tidak tersedia untuk bus Hiba Utama!")
        exit()
else:
    print("Kode bus tidak valid!")
    exit()

# Input jumlah tiket
jumlah_beli = int(input("Masukkan Jumlah Tiket: "))

# Hitung total harga
total_harga = harga * jumlah_beli

# Output hasil
print("\n")
print("DETAIL PEMBELIAN TIKET")
print(f"Nama Penumpang  : {nama_penumpang}")
print(f"Nama Bus        : {nama_bus}")
print(f"Tujuan          : {tujuan}")
print(f"Harga Tiket     : Rp {harga:,}")
print(f"Jumlah Beli     : {jumlah_beli} tiket")
print(f"Total Harga     : Rp {total_harga:,}")
print("Terima kasih telah membeli tiket!")