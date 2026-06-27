// ================================================================
//  KOMPONEN 2 : CONSTRUCTOR & METHOD OVERLOADING
//  - Minimal 2 constructor berbeda
//  - Method nama sama tapi parameter berbeda
//  Tema : Data Mahasiswa
//  Cara compile : javac Komponen2_Overloading.java
//  Cara run     : java Komponen2_Overloading
// ================================================================

// ----------------------------------------------------------------
// APA ITU OVERLOADING?
//   Overloading = satu nama dipakai berkali-kali, tapi PARAMETER berbeda.
//   Java akan pilih versi yang cocok berdasarkan argumen yang dikirim.
//
//   Contoh mudah:
//     hitung()          → tidak ada argumen
//     hitung(10)        → satu argumen int
//     hitung(10, 5)     → dua argumen int
//   Ketiga itu = OVERLOADING dari method "hitung"
// ----------------------------------------------------------------

class MahasiswaOL {

    String nim;
    String nama;
    String jurusan;
    int    sks;
    double ipk;


    // ============================================================
    // CONSTRUCTOR OVERLOADING
    // Sama-sama bernama "MahasiswaOL" tapi parameternya beda
    // ============================================================

    // Constructor 1 — hanya nim dan nama
    MahasiswaOL(String nim, String nama) {
        this.nim     = nim;
        this.nama    = nama;
        this.jurusan = "Belum diisi";
        this.sks     = 0;
        this.ipk     = 0.0;
    }

    // Constructor 2 — nim, nama, dan jurusan
    MahasiswaOL(String nim, String nama, String jurusan) {
        this.nim     = nim;
        this.nama    = nama;
        this.jurusan = jurusan;
        this.sks     = 0;
        this.ipk     = 0.0;
    }

    // Constructor 3 — semua data lengkap
    MahasiswaOL(String nim, String nama, String jurusan, int sks, double ipk) {
        this.nim     = nim;
        this.nama    = nama;
        this.jurusan = jurusan;
        this.sks     = sks;
        this.ipk     = ipk;
    }


    // ============================================================
    // METHOD OVERLOADING — tampilkanInfo()
    // Nama method sama, tapi parameter berbeda
    // ============================================================

    // Versi 1 — tanpa parameter: tampilkan info dasar saja
    void tampilkanInfo() {
        System.out.println("Nama: " + nama + " | NIM: " + nim);
    }

    // Versi 2 — parameter boolean: tampilkan IPK atau tidak
    void tampilkanInfo(boolean tampilIpk) {
        System.out.print("Nama: " + nama + " | NIM: " + nim + " | Jurusan: " + jurusan);
        if (tampilIpk) {
            System.out.print(" | IPK: " + ipk);
        }
        System.out.println();
    }

    // Versi 3 — parameter String: tampilkan dengan label/judul
    void tampilkanInfo(String label) {
        System.out.println("=== " + label + " ===");
        System.out.println("NIM     : " + nim);
        System.out.println("Nama    : " + nama);
        System.out.println("Jurusan : " + jurusan);
        System.out.println("SKS     : " + sks);
        System.out.println("IPK     : " + ipk);
    }


    // ============================================================
    // METHOD OVERLOADING — hitungSKS()
    // Menghitung total SKS dengan cara berbeda
    // ============================================================

    // Versi 1 — tanpa parameter: kembalikan SKS yang sudah ada
    int hitungSKS() {
        return sks;
    }

    // Versi 2 — tambah SKS semester ini, kembalikan totalnya
    int hitungSKS(int sksBaru) {
        return sks + sksBaru;
    }

    // Versi 3 — tambah SKS dan cek apakah melebihi batas
    String hitungSKS(int sksBaru, int batasMaks) {
        int total = sks + sksBaru;
        if (total > batasMaks) {
            return "MELEBIHI BATAS! Total: " + total + " (maks: " + batasMaks + ")";
        } else {
            return "Aman. Total: " + total + " dari " + batasMaks + " SKS";
        }
    }
}


public class Komponen2_Overloading {
    public static void main(String[] args) {

        System.out.println("==============================================");
        System.out.println("   DEMO CONSTRUCTOR & METHOD OVERLOADING     ");
        System.out.println("==============================================");


        // ----------------------------------------------------------
        // CONSTRUCTOR OVERLOADING — Java pilih yang sesuai argumen
        // ----------------------------------------------------------
        System.out.println("\n--- CONSTRUCTOR OVERLOADING ---");

        // Java pilih Constructor 1 karena ada 2 argumen String
        MahasiswaOL m1 = new MahasiswaOL("22001", "Budi");
        System.out.println("m1 dibuat dengan Constructor 1 (2 argumen)");

        // Java pilih Constructor 2 karena ada 3 argumen String
        MahasiswaOL m2 = new MahasiswaOL("22002", "Siti", "Teknik Informatika");
        System.out.println("m2 dibuat dengan Constructor 2 (3 argumen)");

        // Java pilih Constructor 3 karena ada 5 argumen (String,String,String,int,double)
        MahasiswaOL m3 = new MahasiswaOL("22003", "Andi", "Sistem Informasi", 100, 3.65);
        System.out.println("m3 dibuat dengan Constructor 3 (5 argumen)");


        // ----------------------------------------------------------
        // METHOD OVERLOADING — tampilkanInfo()
        // ----------------------------------------------------------
        System.out.println("\n--- METHOD OVERLOADING : tampilkanInfo() ---");

        System.out.print("Versi 1 (tanpa argumen)   : ");
        m3.tampilkanInfo();                   // → pilih versi tanpa parameter

        System.out.print("Versi 2 (argumen boolean) : ");
        m3.tampilkanInfo(true);               // → pilih versi boolean

        m3.tampilkanInfo("Data Lengkap Andi"); // → pilih versi String


        // ----------------------------------------------------------
        // METHOD OVERLOADING — hitungSKS()
        // ----------------------------------------------------------
        System.out.println("\n--- METHOD OVERLOADING : hitungSKS() ---");

        System.out.println("SKS sekarang            : " + m3.hitungSKS());
        System.out.println("SKS + 20 baru           : " + m3.hitungSKS(20));
        System.out.println("Cek batas 144           : " + m3.hitungSKS(20, 144));
        System.out.println("Cek batas 110           : " + m3.hitungSKS(20, 110));

        System.out.println("\n--- KESIMPULAN ---");
        System.out.println("Overloading = nama sama, PARAMETER beda");
        System.out.println("Java otomatis pilih versi yang cocok");
        System.out.println("  tampilkanInfo()        → versi tanpa param");
        System.out.println("  tampilkanInfo(true)    → versi boolean");
        System.out.println("  tampilkanInfo(\"teks\") → versi String");
    }
}
