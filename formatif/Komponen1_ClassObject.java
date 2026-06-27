// ================================================================
//  KOMPONEN 1 : CLASS & OBJECT
//  - Minimal 3 class: Entitas, DataManager, MainMenu
//  Tema : Data Mahasiswa
//  Cara compile : javac Komponen1_ClassObject.java
//  Cara run     : java Komponen1_ClassObject
// ================================================================

import java.util.Scanner;

// ----------------------------------------------------------------
// CLASS 1 : ENTITAS
// Class ini merepresentasikan satu data mahasiswa.
// Seperti "cetakan" — setiap objek Mahasiswa punya nim, nama, ipk sendiri.
// ----------------------------------------------------------------
class Mahasiswa {

    // ATRIBUT — data yang disimpan setiap objek
    String nim;
    String nama;
    String jurusan;
    double ipk;

    // CONSTRUCTOR — dijalankan otomatis saat "new Mahasiswa(...)"
    Mahasiswa(String nim, String nama, String jurusan, double ipk) {
        this.nim      = nim;      // "this" = atribut milik objek ini
        this.nama     = nama;
        this.jurusan  = jurusan;
        this.ipk      = ipk;
    }

    // METHOD — aksi yang bisa dilakukan objek ini
    String getStatus() {
        if (ipk >= 3.5) {
            return "Cumlaude";
        } else if (ipk >= 3.0) {
            return "Memuaskan";
        } else if (ipk >= 2.0) {
            return "Cukup";
        } else {
            return "Perlu Bimbingan";
        }
    }

    void tampilkan() {
        System.out.println("NIM     : " + nim);
        System.out.println("Nama    : " + nama);
        System.out.println("Jurusan : " + jurusan);
        System.out.println("IPK     : " + ipk);
        System.out.println("Status  : " + getStatus());
        System.out.println("----------------------------");
    }
}


// ----------------------------------------------------------------
// CLASS 2 : DATA MANAGER
// Class ini menyimpan dan mengelola banyak objek Mahasiswa.
// Pakai array biasa (bukan ArrayList) agar lebih mudah dipahami.
// ----------------------------------------------------------------
class DataMahasiswa {

    // Array untuk menyimpan objek Mahasiswa (maksimal 10)
    Mahasiswa[] daftar = new Mahasiswa[10];
    int jumlahData     = 0;

    // Method: tambah satu mahasiswa ke array
    void tambah(Mahasiswa mhs) {
        if (jumlahData < 10) {
            daftar[jumlahData] = mhs;
            jumlahData++;
            System.out.println("[OK] Data " + mhs.nama + " ditambahkan.");
        } else {
            System.out.println("[PENUH] Tidak bisa tambah lagi, maksimal 10 data.");
        }
    }

    // Method: tampilkan semua mahasiswa yang tersimpan
    void tampilkanSemua() {
        System.out.println("\n===== DAFTAR SEMUA MAHASISWA =====");
        if (jumlahData == 0) {
            System.out.println("Belum ada data.");
        } else {
            for (int i = 0; i < jumlahData; i++) {
                System.out.println("Data ke-" + (i + 1) + ":");
                daftar[i].tampilkan();
            }
        }
    }

    // Method: cari mahasiswa berdasarkan NIM
    void cariMahasiswa(String nimCari) {
        boolean ditemukan = false;
        for (int i = 0; i < jumlahData; i++) {
            if (daftar[i].nim.equals(nimCari)) {
                System.out.println("Ditemukan!");
                daftar[i].tampilkan();
                ditemukan = true;
                break;
            }
        }
        if (!ditemukan) {
            System.out.println("NIM " + nimCari + " tidak ditemukan.");
        }
    }
}


// ----------------------------------------------------------------
// CLASS 3 : MAIN MENU
// Class ini mengurus tampilan menu dan menerima input pengguna.
// ----------------------------------------------------------------
class MenuMahasiswa {

    Scanner       sc   = new Scanner(System.in);
    DataMahasiswa data = new DataMahasiswa();

    // Method: tampilkan menu pilihan
    void tampilkanMenu() {
        System.out.println("\n============================");
        System.out.println("   SISTEM DATA MAHASISWA   ");
        System.out.println("============================");
        System.out.println("1. Tambah Mahasiswa");
        System.out.println("2. Tampilkan Semua");
        System.out.println("3. Cari Berdasarkan NIM");
        System.out.println("0. Keluar");
        System.out.println("============================");
        System.out.print("Pilih: ");
    }

    // Method: proses input data mahasiswa baru
    void inputMahasiswa() {
        System.out.print("NIM      : ");
        String nim = sc.next();
        System.out.print("Nama     : ");
        String nama = sc.next();
        System.out.print("Jurusan  : ");
        String jurusan = sc.next();
        System.out.print("IPK      : ");
        double ipk = sc.nextDouble();

        // Buat OBJEK Mahasiswa baru dari input pengguna
        Mahasiswa mhs = new Mahasiswa(nim, nama, jurusan, ipk);

        // Simpan objek ke DataMahasiswa
        data.tambah(mhs);
    }

    // Method: jalankan program (loop menu)
    void jalankan() {
        int pilihan;
        do {
            tampilkanMenu();
            pilihan = sc.nextInt();

            if (pilihan == 1) {
                inputMahasiswa();
            } else if (pilihan == 2) {
                data.tampilkanSemua();
            } else if (pilihan == 3) {
                System.out.print("Masukkan NIM yang dicari: ");
                String nim = sc.next();
                data.cariMahasiswa(nim);
            } else if (pilihan == 0) {
                System.out.println("Keluar. Sampai jumpa!");
            } else {
                System.out.println("Pilihan tidak valid.");
            }

        } while (pilihan != 0);
    }
}


// ----------------------------------------------------------------
// MAIN CLASS — cukup buat objek MenuMahasiswa lalu jalankan
// ----------------------------------------------------------------
public class Komponen1_ClassObject {
    public static void main(String[] args) {

        // Contoh membuat objek langsung (tanpa menu)
        System.out.println("=== DEMO MEMBUAT OBJEK ===");
        Mahasiswa m1 = new Mahasiswa("22001", "Budi", "TI", 3.80);
        Mahasiswa m2 = new Mahasiswa("22002", "Siti", "SI", 2.50);

        m1.tampilkan(); // panggil method milik objek m1
        m2.tampilkan(); // panggil method milik objek m2

        // Jalankan menu interaktif
        MenuMahasiswa menu = new MenuMahasiswa();
        menu.jalankan();
    }
}
