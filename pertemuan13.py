def rupiah(angka):
    return f"Rp {angka:,.0f}".replace(",", ".")

print("*************** AGEN BUS PERJALANAN ***************")
print()

# INPUT
nama = input("Masukkan Nama Penumpang : ")
kode_input = input("Masukkan Kode Bus [R01/S01/H01] : ").upper() # upper fungsi

# slicing ambil huruf pertama
kode_bus = kode_input[0:1]

# PILIH BUS & TUJUAN
if kode_bus == "R":
    nama_bus = "Rosalia"
    print("Pilihan Tujuan:")
    print("1. SBY (Rp 300.000)")
    print("2. MLG (Rp 400.000)")
    pilih = input("Pilih Tujuan [1/2] : ")

    if pilih == "1":
        tujuan = "SBY"
        harga = 300000
    elif pilih == "2":
        tujuan = "MLG"
        harga = 400000
    else:
        print("Pilihan tujuan tidak valid!")
        exit()

elif kode_bus == "S":
    nama_bus = "Sinar Jaya"
    print("Pilihan Tujuan:")
    print("1. SLO (Rp 200.000)")
    print("2. TGL (Rp 250.000)")
    pilih = input("Pilih Tujuan [1/2] : ")

    if pilih == "1":
        tujuan = "SLO"
        harga = 200000
    elif pilih == "2":
        tujuan = "TGL"
        harga = 250000
    else:
        print("Pilihan tujuan tidak valid!")
        exit()

elif kode_bus == "H":
    nama_bus = "Hiba Utama"
    print("Pilihan Tujuan:")
    print("1. LMP (Rp 350.000)")
    print("2. JGY (Rp 400.000)")
    pilih = input("Pilih Tujuan [1/2] : ")

    if pilih == "1":
        tujuan = "LMP"
        harga = 350000
    elif pilih == "2":
        tujuan = "JGY"
        harga = 400000
    else:
        print("Pilihan tujuan tidak valid!")
        exit()

else:
    print("Kode Bus Tidak Valid!")
    exit()

print()
print("**************************************************")
print(f"Nama Bus     : {nama_bus}")
print(f"Tujuan       : {tujuan}")
print(f"Harga Tiket  : {rupiah(harga)}")
print("**************************************************")

# JUMLAH
jumlah = int(input("Masukkan Jumlah Beli : "))

# PROSES
total_harga = harga * jumlah
ppn = total_harga * 0.05
total_bayar = total_harga + ppn
hadiah = "Jam Tangan" if jumlah >= 3 else "Tidak Ada"

# OUTPUT
print()
print("**************************************************")
print(f"Total Harga : {rupiah(total_harga)}")
print(f"Hadiah      : {hadiah}")
print(f"PPN (5%)    : {rupiah(ppn)}")
print(f"Total Bayar : {rupiah(total_bayar)}")
print("**************************************************")

bayar = int(input("Masukkan Pembayaran : "))
kembalian = bayar - total_bayar

print(f"Uang Kembaliannya : {rupiah(kembalian)}")
print("****************** Terima Kasih ******************")