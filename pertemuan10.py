nomor_acak = 77
berjalan =  True

print("Tebak angka dari 1 - 100!")

while berjalan:
  tebakan = int(input("Masukkan tebakan Anda: "))
  if tebakan == nomor_acak:
    print("Selamat! Tebakan Anda benar.")
    berjalan = False
  elif tebakan < nomor_acak:
    print("Tebakan Anda terlalu kecil. Coba lagi!")
  else:
    print("Tebakan Anda terlalu besar. Coba lagi!")
else:
  print("Terima kasih telah bermain!")