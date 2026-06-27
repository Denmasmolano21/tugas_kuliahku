# studi_kasus_produksi.py

produksi = []

for jam in range(1, 8):
    jumlah = int(input(f"Jumlah produksi jam {jam}: "))
    produksi.append(jumlah)

total = sum(produksi)
rata = total / 7

print("Total produksi botol =", total)
print("Rata-rata produksi per jam =", rata)
