def rupiah(angka):
    return f"Rp {angka:,.0f}".replace(",", ".")

print("="*50)
print("           AGEN BUS PERJALANAN")
print("="*50)

nama = input("Masukkan Nama Penumpang : ")
kode = input("Masukkan Kode Bus [R/S/H] : ").upper()

# Data Bus
if kode == "R":
    nama_bus = "Rosalia"
    tujuan = "SBY"
    harga = 300000
elif kode == "S":
    nama_bus = "Sinar Jaya"
    tujuan = "SLO"
    harga = 200000
elif kode == "H":
    nama_bus = "Hiba Utama"
    tujuan = "LMP"
    harga = 350000
else:
    print("Kode bus tidak valid!")
    exit()

print("\n" + "="*50)
print(f"Nama Bus    : {nama_bus}")
print(f"Tujuan      : {tujuan}")
print(f"Harga Tiket : {rupiah(harga)}")
print("="*50)

jumlah = int(input("Masukkan Jumlah Beli : "))

total = harga * jumlah
ppn = total * 0.05
total_bayar = total + ppn

# Hadiah
hadiah = "Jam Tangan" if jumlah >= 3 else "Tidak Ada"

print("\n" + "="*50)
print(f"Total Harga : {rupiah(total)}")
print(f"Hadiah      : {hadiah}")
print(f"PPN (5%)    : {rupiah(ppn)}")
print(f"Total Bayar : {rupiah(total_bayar)}")
print("="*50)

bayar = int(input("Masukkan Pembayaran : "))
kembalian = bayar - total_bayar

print(f"Uang Kembalian : {rupiah(kembalian)}")
print("="*50)
print("             Terima Kasih")
print("="*50)
