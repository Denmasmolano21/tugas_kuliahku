"""
Program Konversi Nilai Numerik ke Huruf
Lembaga Kursus - Sistem Penilaian

Kriteria Penilaian:
- A: 85-100 (Lulus)
- B: 70-84  (Lulus)
- C: 55-69  (Lulus)
- D: 40-54  (Tidak Lulus)
- E: <40    (Tidak Lulus)
"""

print("="*50)
print("     PROGRAM KONVERSI NILAI KE HURUF")
print("          LEMBAGA KURSUS")
print("="*50)
print()

# Input nilai dari pengguna
nilai = float(input("Masukkan nilai (0-100): "))

# Validasi rentang nilai
if nilai < 0 or nilai > 100:
    print("Error: Nilai harus berada dalam rentang 0-100!")
else:
    # Proses konversi nilai ke huruf
    nilai_huruf = ""
    status = ""
    
    if nilai >= 85 and nilai <= 100:
        nilai_huruf = "A"
        status = "LULUS"
    elif nilai >= 70 and nilai < 85:
        nilai_huruf = "B"
        status = "LULUS"
    elif nilai >= 55 and nilai < 70:
        nilai_huruf = "C"
        status = "LULUS"
    elif nilai >= 40 and nilai < 55:
        nilai_huruf = "D"
        status = "TIDAK LULUS"
    elif nilai >= 0 and nilai < 40:
        nilai_huruf = "E"
        status = "TIDAK LULUS"
    
    # Tampilkan hasil konversi
    print()
    print("="*50)
    print("           HASIL KONVERSI NILAI")
    print("="*50)
    print("Nilai Numerik    :", nilai)
    print("Nilai Huruf      :", nilai_huruf)
    print("Status Kelulusan :", status)
    print("="*50)
    
    # Pesan tambahan
    if status == "LULUS":
        print("Selamat! Anda dinyatakan LULUS!")
    else:
        print("Tetap semangat! Tingkatkan belajar Anda!")
    print()