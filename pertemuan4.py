anggota_lama = ["Rapi", "Atim", "Riski", "Rapa", "Rehan"]

nama = input("Masukkan nama Anda: ")
umur = int(input("Masukkan umur Anda: "))
hobi = input("Masukkan Hobi anda: ").split(",")

terdaftar = nama in anggota_lama

aktif = (umur < 18) and (len(hobi) > 1)

data_anggota = (nama, umur, tuple(hobi), terdaftar, aktif)

semua_hobi = tuple(set(hobi + ["Membaca", "Olahraga", "Coding"]))

print("Data Anggota: ",data_anggota)
print("Semua Hobi Anggota Klub: ", semua_hobi)