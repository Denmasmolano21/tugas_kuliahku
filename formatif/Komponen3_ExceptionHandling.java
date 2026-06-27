// ================================================================
//  KOMPONEN 3 : EXCEPTION HANDLING
//  - try catch finally
//  - Skenario: input salah, file tidak ditemukan, format corrupt
//  Tema : Data Mahasiswa
//  Cara compile : javac Komponen3_ExceptionHandling.java
//  Cara run     : java Komponen3_ExceptionHandling
// ================================================================

// ----------------------------------------------------------------
// APA ITU EXCEPTION HANDLING?
//   Exception = error yang terjadi saat program berjalan.
//   Tanpa penanganan, program akan berhenti mendadak (crash).
//
//   try     → tulis kode yang mungkin error di sini
//   catch   → tangkap error dan tampilkan pesan yang jelas
//   finally → blok ini SELALU dijalankan, error atau tidak
//             → biasanya dipakai untuk menutup file / Scanner
//
//   Urutan catch: yang PALING SPESIFIK dulu, baru Exception biasa
// ----------------------------------------------------------------

import java.util.Scanner;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Komponen3_ExceptionHandling {

    // ----------------------------------------------------------
    // SKENARIO 1 : Input Salah dari Pengguna
    // Exception yang ditangkap: NumberFormatException
    //                           IllegalArgumentException
    // ----------------------------------------------------------
    static void skenario1_InputSalah() {
        System.out.println("\n==========================================");
        System.out.println(" SKENARIO 1 : Input Salah dari Pengguna  ");
        System.out.println("==========================================");

        Scanner sc = new Scanner(System.in);

        System.out.println("Masukkan IPK mahasiswa (harusnya 0.0 - 4.0)");
        System.out.println("Coba input teks seperti 'abc' atau angka > 4");
        System.out.print("IPK: ");

        try {
            // Baca input sebagai String dulu, baru di-parse
            String inputUser = sc.next();

            // Double.parseDouble akan error jika inputUser bukan angka
            double ipk = Double.parseDouble(inputUser);

            // Kita sendiri yang lempar error jika di luar 0.0 - 4.0
            if (ipk < 0.0 || ipk > 4.0) {
                throw new IllegalArgumentException("IPK harus antara 0.0 sampai 4.0!");
            }

            System.out.println("IPK valid: " + ipk);

        } catch (NumberFormatException e) {
            // Terjadi saat input bukan angka (misal: "abc", "xyz")
            System.out.println("[CATCH] Input bukan angka! " + e.getMessage());

        } catch (IllegalArgumentException e) {
            // Terjadi saat IPK di luar range (misal: 5.0, -1.0)
            System.out.println("[CATCH] Nilai tidak valid! " + e.getMessage());

        } finally {
            // Selalu dijalankan apapun yang terjadi
            System.out.println("[FINALLY] Selesai memproses input IPK.");
        }
    }


    // ----------------------------------------------------------
    // SKENARIO 2 : File Tidak Ditemukan
    // Exception yang ditangkap: FileNotFoundException
    // ----------------------------------------------------------
    static void skenario2_FileTidakAda() {
        System.out.println("\n==========================================");
        System.out.println(" SKENARIO 2 : File Tidak Ditemukan       ");
        System.out.println("==========================================");

        FileReader fr = null;

        try {
            System.out.println("Mencoba buka file: data_tidak_ada.txt");

            // File ini sengaja tidak dibuat → pasti FileNotFoundException
            fr = new FileReader("data_tidak_ada.txt");

            System.out.println("File berhasil dibuka!");  // baris ini tidak akan tercapai

        } catch (FileNotFoundException e) {
            // File tidak ditemukan di lokasi yang diminta
            System.out.println("[CATCH] File tidak ditemukan: " + e.getMessage());
            System.out.println("        Solusi: cek nama file dan lokasi penyimpanannya.");

        } finally {
            // Tutup FileReader jika sempat terbuka
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                System.out.println("[FINALLY] Gagal menutup file.");
            }
            System.out.println("[FINALLY] Selesai mencoba buka file.");
        }
    }


    // ----------------------------------------------------------
    // SKENARIO 3 : Format File Corrupt
    // Exception yang ditangkap: NumberFormatException, Exception
    // ----------------------------------------------------------
    static void skenario3_FormatCorrupt() {
        System.out.println("\n==========================================");
        System.out.println(" SKENARIO 3 : Format Data Corrupt        ");
        System.out.println("==========================================");

        // Langkah 1: buat file dengan satu baris yang sengaja rusak
        String namaFile = "mhs_test.txt";
        try {
            FileWriter fw = new FileWriter(namaFile);
            // Format seharusnya: NIM|NAMA|IPK
            // Baris berikut sengaja rusak: IPK diisi teks
            fw.write("22001|Budi|3.75\n");       // valid
            fw.write("22002|Siti|SALAH_FORMAT\n"); // corrupt: IPK bukan angka
            fw.close();
            System.out.println("File " + namaFile + " dibuat (dengan 1 baris corrupt).");
        } catch (IOException e) {
            System.out.println("Gagal membuat file: " + e.getMessage());
            return;
        }

        // Langkah 2: baca file baris per baris menggunakan Scanner
        FileReader fr = null;
        Scanner bacaFile = null;

        try {
            fr       = new FileReader(namaFile);
            bacaFile = new Scanner(fr);

            int noBaris = 0;
            while (bacaFile.hasNextLine()) {
                noBaris++;
                String baris = bacaFile.nextLine();
                System.out.println("Membaca baris " + noBaris + ": " + baris);

                String[] bagian = baris.split("\\|"); // pisah dengan tanda |

                // Validasi: harus ada tepat 3 kolom
                if (bagian.length != 3) {
                    throw new Exception("Baris " + noBaris + " rusak! Kolom tidak lengkap.");
                }

                String nim  = bagian[0];
                String nama = bagian[1];

                // Ini akan error jika bagian[2] bukan angka
                double ipk = Double.parseDouble(bagian[2]);

                System.out.println("  OK: " + nim + " - " + nama + " - IPK: " + ipk);
            }

        } catch (NumberFormatException e) {
            // IPK di file bukan angka
            System.out.println("[CATCH] Format angka salah! " + e.getMessage());

        } catch (FileNotFoundException e) {
            System.out.println("[CATCH] File tidak ditemukan: " + e.getMessage());

        } catch (Exception e) {
            // Error lain, termasuk kolom tidak lengkap
            System.out.println("[CATCH] Format data corrupt: " + e.getMessage());

        } finally {
            // Tutup semua yang terbuka
            try {
                if (bacaFile != null) bacaFile.close();
                if (fr != null) fr.close();
            } catch (IOException e) {
                System.out.println("[FINALLY] Gagal menutup file.");
            }

            // Hapus file test
            new java.io.File(namaFile).delete();
            System.out.println("[FINALLY] Selesai membaca file.");
        }
    }


    // ----------------------------------------------------------
    // MAIN — jalankan semua skenario satu per satu
    // ----------------------------------------------------------
    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("   DEMO EXCEPTION HANDLING — MAHASISWA   ");
        System.out.println("==========================================");
        System.out.println("try    = coba jalankan kode berisiko");
        System.out.println("catch  = tangkap error jika terjadi");
        System.out.println("finally = selalu jalan (error atau tidak)");

        skenario1_InputSalah();     // input dari keyboard
        skenario2_FileTidakAda();   // file tidak ada
        skenario3_FormatCorrupt();  // isi file rusak
    }
}
