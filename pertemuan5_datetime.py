import datetime
hari_ini = datetime.date.today()
print("Tanggal hari ini:", hari_ini)

waktu_sekarang = datetime.datetime.now()
print("Waktu sekarang:", waktu_sekarang)

print("Format waktu:", waktu_sekarang.strftime("%d-%m-%Y %H:%M:%S"))
libur = datetime.date(2025, 12, 30)
selisih = libur - hari_ini
print("Hari menuju libur:", selisih.days)