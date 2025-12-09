# Fungsi untuk mengubah format angka menjadi format Rupiah dengan pemisah ribuan
def rupiah(x):
    return f"Rp {x:,}".replace(",", ".")

# Menampilkan header/judul program
print("=" * 60)
print("           SELAMAT DATANG")
print("=" * 60)
print()

# VARIABEL PENYIMPAN DATA
daftar_barang = []      # List untuk menyimpan nama-nama barang
daftar_harga = []       # List untuk menyimpan harga-harga barang
total_belanja = 0       # Variabel untuk menghitung total belanja

# Menampilkan judul input data
print(">>> MASUKKAN DATA BARANG YANG DIBELI <<<")
print()

# Variabel untuk penomoran barang yang diinput
nomor = 1

# Loop untuk input data barang (akan terus berulang sampai user ketik 'n')
while True:
    # Input nama barang
    nama_barang = input(f"Barang ke-{nomor} (nama): ")
    # Input harga barang
    harga_barang = int(input(f"Barang ke-{nomor} (harga Rp): "))
    
    # Menambahkan nama barang ke dalam list
    daftar_barang.append(nama_barang)
    # Menambahkan harga barang ke dalam list
    daftar_harga.append(harga_barang)
    
    print()
    
    # Setiap 2 barang, tanyakan apakah user ingin lanjut belanja
    if nomor % 2 == 0:
        pilihan = input(">> Lanjut belanja? (yak/gak): ").lower()
        print()
        # Jika jawab 'gak', keluar dari loop
        if pilihan == "gak":
            break
    
    # Increment nomor barang
    nomor += 1

# Menampilkan header struk pembelian
print()
print("=" * 60)
print("                    STRUK PEMBELIAN")
print("=" * 60)
print()

# Loop untuk menampilkan semua barang dan menghitung total
for i in range(len(daftar_barang)):
    harga_item = daftar_harga[i]
    # Menambahkan harga item ke total belanja
    total_belanja += harga_item
    
    # Menampilkan nama barang dan harganya dengan format rapi
    print(f"{daftar_barang[i]:30} {rupiah(harga_item)}")

print()
print("-" * 60)

# Variabel untuk menyimpan nilai diskon
diskon = 0

# Cek apakah total belanja >= 500000 untuk mendapat diskon 10%
if total_belanja >= 500000:
    # Hitung diskon 10%
    diskon = total_belanja * 0.1
    # Hitung total setelah diskon
    total_setelah_diskon = total_belanja - diskon
    
    # Tampilkan subtotal, diskon, dan total pembayaran
    print(f"Subtotal{' ' * 43}{rupiah(total_belanja)}")
    print(f"Diskon 10%{' ' * 42}{rupiah(int(diskon))}")
    print("-" * 60)
    print(f"TOTAL PEMBAYARAN{' ' * 36}{rupiah(int(total_setelah_diskon))}")
else:
    # Jika tidak ada diskon, tampilkan subtotal dan total tanpa diskon
    print(f"Subtotal{' ' * 43}{rupiah(total_belanja)}")
    print(f"Diskon{' ' * 48}Rp 0")
    print("-" * 60)
    print(f"TOTAL PEMBAYARAN{' ' * 36}{rupiah(total_belanja)}")

# Garis pemisah akhir
print("-" * 60)
print()
# Pesan terima kasih
print("   Terima kasih telah berbelanja di toko kami!")
print("=" * 60)