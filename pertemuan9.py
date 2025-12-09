# # Latihan
# def hitung_total(data):
#   total = sum(data)
#   return total

# def hitung_rata(data):
#   total = hitung_total(data)
#   rata = total / len(data)
#   return rata

# nilai = [80, 75, 90, 85]

# print("Total nilai:", hitung_total(nilai))
# print("Rata-rata nilai:", hitung_rata(nilai))

# 1. Fungsi menghitung luas segitiga
def hitung_luas_segitiga(alas, tinggi):
    luas = 0.5 * alas * tinggi
    return luas

# Output 1: Menghitung luas segitiga
alas = float(input("Masukkan alas segitiga: "))
tinggi = float(input("Masukkan tinggi segitiga: "))

luas = hitung_luas_segitiga(alas, tinggi)
print(f"Luas segitiga dengan alas {alas} dan tinggi {tinggi} adalah: {luas}")

# 2. Fungsi mengembalikan nilai terbesar
def nilai_terbesar(angka1, angka2):
    if angka1 > angka2:
        return angka1
    else:
        return angka2
      
# Output 2: Mencari nilai terbesar
print("\nNILAI TERBESAR")
a = 12
b = 21
terbesar = nilai_terbesar(a, b)
print(f"Nilai terbesar antara {a} dan {b} adalah: {terbesar}")

# # 3. Fungsi menghitung diskon belanja
# def hitung_diskon(total_belanja, diskon_belanja):
#     diskon = total_belanja * (diskon_belanja / 100)
#     total_bayar = total_belanja - diskon
#     return total_bayar

# # Output 3: Menghitung diskon belanja
# print("\nHITUNG DISKON")
# belanja = 200000
# diskon = 20
# bayar = hitung_diskon(belanja, diskon)
# print(f"Total belanja: Rp {belanja}")
# print(f"Diskon: {diskon}%")
# print(f"Total yang harus dibayar: Rp {bayar}")