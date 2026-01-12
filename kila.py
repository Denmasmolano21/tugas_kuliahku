# Program Kasir Mini - Versi Debug

# Fungsi sederhana untuk mengubah angka menjadi format rupiah
def format_rupiah(angka):
    return "Rp " + str(angka)

# List untuk menyimpan nama dan harga barang
list_nama = []
list_harga = []

# Variabel untuk melanjutkan belanja
lanjut_belanja = "y"

print("PROGRAM KASIR MINI PUNYA SAKILA (DEBUG MODE)")
print("--------------------------------------------\n")

# Input data barang
while lanjut_belanja == "y":
    nama_barang = input("Masukkan nama barang: ")
    harga_barang = int(input("Masukkan harga barang: "))

    list_nama.append(nama_barang)
    list_harga.append(harga_barang)

    # DEBUG: cek isi list setelah tambah barang
    print("[DEBUG] Barang saat ini:", list_nama)
    print("[DEBUG] Harga saat ini :", list_harga)

    lanjut_belanja = input("Tambah barang lagi? (y/n): ").lower()
    print()

# Menghitung total belanja
total_belanja = 0

for harga in list_harga:
    total_belanja += harga
    # DEBUG: cek proses penjumlahan
    print(f"[DEBUG] Menambahkan {harga}, subtotal sementara = {total_belanja}")

# Menghitung diskon jika total >= 500000
diskon = 0

if total_belanja >= 500000:
    diskon = total_belanja * 0.10
    print(f"[DEBUG] Diskon 10% diterapkan = {diskon}")
else:
    print("[DEBUG] Tidak ada diskon")

# Menghitung total akhir pembayaran
total_pembayaran = total_belanja - diskon
print(f"[DEBUG] Total bayar akhir = {total_pembayaran}")

# Menampilkan hasil
print("\nHASIL AKHIR:")
print("DAFTAR BARANG YANG DIBELI:")
for i in range(len(list_nama)):
    print("- ", list_nama[i], ":", format_rupiah(list_harga[i]))

print()
print("Subtotal       :", format_rupiah(total_belanja))
print("Diskon         :", format_rupiah(int(diskon)))
print("Total Bayar    :", format_rupiah(int(total_pembayaran)))

print("\nTerima kasih telah berbelanja!")
