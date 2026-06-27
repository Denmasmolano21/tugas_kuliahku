// ================================================================
//  TIPE D - Game Interaktif Berbasis Timer
//  D1 - Game Tebak Angka
//
//  Cara compile : javac TipeD_GameTebakAngka.java
//  Cara run     : java TipeD_GameTebakAngka
// ================================================================

// ----------------------------------------------------------------
// IMPORT: library yang dibutuhkan program ini
//   - Random    -> untuk pilih angka acak
//   - BufferedReader & InputStreamReader -> baca input dari keyboard
//     (dipilih karena punya method .ready() untuk cek apakah
//      sudah ada ketikan sebelum membaca, tanpa memblokir program)
//   - IOException -> exception saat baca/tulis I/O gagal
// ----------------------------------------------------------------
import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// ================================================================
//  CLASS Warna
//  Kumpulan kode ANSI untuk mewarnai teks di terminal.
//  Contoh pakai: System.out.println(Warna.HIJAU + "teks" + Warna.RESET);
// ================================================================
class Warna {
    static final String RESET  = "\u001B[0m";   // kembali ke warna normal
    static final String MERAH  = "\u001B[31m";
    static final String HIJAU  = "\u001B[32m";
    static final String KUNING = "\u001B[33m";
    static final String BIRU   = "\u001B[34m";
    static final String UNGU   = "\u001B[35m";
    static final String CYAN   = "\u001B[36m";
    static final String TEBAL  = "\u001B[1m";
}

// ================================================================
//  CLASS GameSession  (Entity / Model)
//  Bertugas menyimpan DATA satu sesi permainan.
//  Dipisah dari logika agar kode lebih rapi dan mudah diubah.
// ================================================================
class GameSession {
    // field private = hanya bisa diakses lewat getter/setter
    private int    targetAngka;   // angka rahasia komputer
    private int    totalRonde;    // sudah berapa ronde dimainkan
    private int    totalBenar;    // berapa kali tebak benar
    private int    totalTimeout;  // berapa kali waktu habis
    private String namaPemain;    // nama pemain

    // Constructor: dipanggil saat "new GameSession(nama)"
    public GameSession(String namaPemain) {
        this.namaPemain  = namaPemain;
        this.totalRonde  = 0;
        this.totalBenar  = 0;
        this.totalTimeout = 0;
    }

    // Getter dan Setter
    public int    getTargetAngka()        { return targetAngka; }
    public void   setTargetAngka(int n)   { this.targetAngka = n; }

    public int    getTotalRonde()         { return totalRonde; }
    public void   tambahRonde()           { this.totalRonde++; }

    public int    getTotalBenar()         { return totalBenar; }
    public void   tambahBenar()           { this.totalBenar++; }

    public int    getTotalTimeout()       { return totalTimeout; }
    public void   tambahTimeout()         { this.totalTimeout++; }

    public String getNamaPemain()         { return namaPemain; }

    // Hitung persentase keberhasilan
    public String getAkurasi() {
        if (totalRonde == 0) return "0%";
        int persen = (int) Math.round((double) totalBenar / totalRonde * 100);
        return persen + "%";
    }
}

// ================================================================
//  CLASS TimerThread  (Thread terpisah untuk hitung mundur)
//
//  KENAPA PAKAI THREAD?
//  Karena program butuh DUA hal yang berjalan BERSAMAAN:
//    1. Menampilkan sisa waktu (setiap detik)
//    2. Menunggu ketikan dari user
//  Kalau tidak pakai thread, salah satu harus menunggu yang lain.
//
//  TimerThread extends Thread -> artinya kelas ini ADALAH sebuah Thread.
//  Kita override method run() yang otomatis dipanggil saat thread.start().
// ================================================================
class TimerThread extends Thread {

    // volatile = pastikan nilai variabel ini selalu "fresh" dibaca
    // oleh thread lain. Tanpa volatile, ada risiko thread membaca
    // nilai lama dari cache CPU, bukan nilai terbaru.
    private volatile boolean timeOut    = false;
    private volatile boolean dihentikan = false;

    private int durasiDetik;

    public TimerThread(int durasiDetik) {
        this.durasiDetik = durasiDetik;

        // setDaemon(true) -> thread ini "ikut mati" saat program utama selesai.
        // Tanpa ini, kalau main thread selesai, timer thread masih jalan terus.
        setDaemon(true);
    }

    // Method run() adalah "isi pekerjaan" thread ini
    @Override
    public void run() {
        for (int sisa = durasiDetik; sisa >= 0; sisa--) {

            // Cek dulu: apakah sudah dihentikan manual? Kalau iya, keluar
            if (dihentikan) return;

            // \r (carriage return) = geser kursor ke awal baris TANPA ganti baris
            // Efek: teks timer tampak "bergerak" di tempat yang sama
            System.out.print("\r" + Warna.KUNING + "  [Timer: " + sisa
                    + " detik] " + Warna.RESET + "Masukkan tebakan Anda: ");
            System.out.flush(); // paksa langsung tampil (tanpa nunggu buffer penuh)

            if (sisa == 0) break; // sudah 0 detik, selesai

            try {
                Thread.sleep(1000); // tidur 1 detik sebelum loop berikutnya
            } catch (InterruptedException e) {
                // Thread dibangunkan paksa (oleh method hentikan() di bawah)
                return;
            }
        }

        // Kalau loop selesai dan belum dihentikan manual -> berarti waktu habis
        if (!dihentikan) {
            timeOut = true;
        }
    }

    // Dipanggil saat user sudah mengetik sebelum waktu habis
    public void hentikan() {
        this.dihentikan = true;
        this.interrupt(); // paksa thread bangun dari Thread.sleep()
    }

    // Dicek oleh main thread untuk tahu apakah waktu sudah habis
    public boolean isTimeOut() {
        return timeOut;
    }
}

// ================================================================
//  CLASS DataManager
//  Bertugas menampilkan statistik akhir permainan.
//  Dipisah agar mudah dikembangkan (misal: simpan ke file).
// ================================================================
class DataManager {

    public static void tampilkanStatistik(GameSession sesi) {
        System.out.println("\n" + Warna.UNGU
                + "+-----------------------------------------+");
        System.out.println(  "|         STATISTIK AKHIR SESI           |");
        System.out.println(  "+-----------------------------------------+" + Warna.RESET);
        System.out.println("  Pemain       : " + Warna.CYAN  + sesi.getNamaPemain()  + Warna.RESET);
        System.out.println("  Total Ronde  : " + sesi.getTotalRonde());
        System.out.println("  Berhasil     : " + Warna.HIJAU + sesi.getTotalBenar()  + Warna.RESET);
        System.out.println("  Timeout      : " + Warna.MERAH + sesi.getTotalTimeout() + Warna.RESET);
        System.out.println("  Akurasi      : " + Warna.KUNING + sesi.getAkurasi()    + Warna.RESET);
        System.out.println(Warna.UNGU
                + "  -----------------------------------------" + Warna.RESET);
    }
}

// ================================================================
//  CLASS GameEngine
//  Bertugas menjalankan LOGIKA inti satu ronde permainan.
//
//  Teknik utama: polling loop dengan BufferedReader.ready()
//    -> Loop terus mengecek apakah user sudah mengetik sesuatu
//    -> Kalau belum ada, tidur 50ms, lalu cek lagi
//    -> Kalau timer sudah timeout, keluar dari loop
//  Ini lebih aman daripada readLine() biasa yang akan "memblokir"
//  (nunggu terus) tanpa bisa dicek apakah waktu sudah habis.
// ================================================================
class GameEngine {

    private static final int BATAS_BAWAH  = 1;
    private static final int BATAS_ATAS   = 100;
    private static final int DURASI_TIMER = 10; // detik

    private static final Random random = new Random();

    // Jalankan satu ronde: return true jika tebak benar, false jika gagal/timeout
    public static boolean jalankanRonde(GameSession sesi, BufferedReader br) {

        // 1. Pilih angka rahasia baru
        int target = random.nextInt(BATAS_ATAS) + BATAS_BAWAH; // hasil: 1 s/d 100
        sesi.setTargetAngka(target);
        sesi.tambahRonde();

        System.out.println("\n" + Warna.UNGU
                + "  ---------------------------------" + Warna.RESET);
        System.out.println("  Ronde ke-" + sesi.getTotalRonde()
                + " | Angka rahasia sudah dipilih (1-100)!");
        System.out.println("  Kamu punya " + Warna.KUNING + DURASI_TIMER
                + " detik" + Warna.RESET + " untuk menebak!\n");

        // 2. Mulai timer di thread terpisah
        TimerThread timer = new TimerThread(DURASI_TIMER);
        timer.start(); // langsung jalan di background

        String inputUser = null;

        // 3. Loop polling: tunggu input user ATAU timer habis
        while (!timer.isTimeOut()) {
            try {
                if (br.ready()) {
                    // Ada karakter di buffer keyboard -> baca sekarang
                    inputUser = br.readLine();
                    timer.hentikan(); // stop timer karena sudah ada input
                    break;
                }
                Thread.sleep(50); // belum ada input, tunggu 50ms lalu cek lagi
            } catch (IOException e) {
                // Error baca keyboard (jarang terjadi, tapi harus ditangani)
                System.out.println(Warna.MERAH
                        + "\n  [ERROR] Gagal membaca input: " + e.getMessage() + Warna.RESET);
                timer.hentikan();
                return false;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }

        // 4a. Waktu habis sebelum user input -> ronde gagal
        if (timer.isTimeOut() && (inputUser == null || inputUser.trim().isEmpty())) {
            System.out.println("\n\n  " + Warna.MERAH + Warna.TEBAL
                    + "Waktu habis! Kesempatan menjawab hilang." + Warna.RESET);
            System.out.println("  Angka yang benar adalah: "
                    + Warna.KUNING + target + Warna.RESET);
            sesi.tambahTimeout();
            return false;
        }

        // 4b. Input kosong (edge case)
        if (inputUser == null || inputUser.trim().isEmpty()) {
            System.out.println("\n  " + Warna.MERAH
                    + "Tidak ada input. Ronde dilewati." + Warna.RESET);
            System.out.println("  Angka yang benar adalah: "
                    + Warna.KUNING + target + Warna.RESET);
            sesi.tambahTimeout();
            return false;
        }

        // 4c. Ada input -> proses tebakan
        System.out.println(); // baris baru (setelah efek \r timer)
        return prosesTebakan(inputUser.trim(), target, sesi);
    }

    // Validasi dan evaluasi tebakan user
    private static boolean prosesTebakan(String inputStr, int target, GameSession sesi) {
        int tebakan;

        // Coba ubah String ke int; gagal jika bukan angka
        try {
            tebakan = Integer.parseInt(inputStr);
        } catch (NumberFormatException e) {
            // Pesan yang ramah, bukan e.printStackTrace()
            System.out.println("  " + Warna.MERAH
                    + "Masukkan harus angka 1-100! \""
                    + inputStr + "\" bukan angka." + Warna.RESET);
            return false;
        }

        // Validasi rentang
        if (tebakan < BATAS_BAWAH || tebakan > BATAS_ATAS) {
            System.out.println("  " + Warna.KUNING
                    + "Angka harus antara " + BATAS_BAWAH
                    + " dan " + BATAS_ATAS + "!" + Warna.RESET);
            return false;
        }

        // Evaluasi: terlalu kecil, terlalu besar, atau benar?
        if (tebakan < target) {
            System.out.println("  " + Warna.BIRU
                    + "Terlalu kecil! Coba angka yang lebih besar." + Warna.RESET);
            return false;
        } else if (tebakan > target) {
            System.out.println("  " + Warna.KUNING
                    + "Terlalu besar! Coba angka yang lebih kecil." + Warna.RESET);
            return false;
        } else {
            System.out.println("  " + Warna.HIJAU + Warna.TEBAL
                    + "BENAR! Angka yang dicari adalah " + target + "!" + Warna.RESET);
            System.out.println("  " + Warna.HIJAU
                    + "Selamat, " + sesi.getNamaPemain() + "!" + Warna.RESET);
            sesi.tambahBenar();
            return true;
        }
    }
}

// ================================================================
//  CLASS TipeD_GameTebakAngka  (Main - titik masuk program)
//  Bertugas: tampil menu, baca pilihan, panggil GameEngine
// ================================================================
public class TipeD_GameTebakAngka {

    public static void main(String[] args) {

        // Pakai BufferedReader agar bisa pakai .ready() di GameEngine
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // --- Banner ---
        System.out.println("\n" + Warna.CYAN);
        System.out.println("  +======================================+");
        System.out.println("  |  Selamat datang di Game Tebak Angka  |");
        System.out.println("  +======================================+" + Warna.RESET);

        // --- Baca nama pemain ---
        System.out.print("\n  Masukkan nama kamu: ");
        String nama;
        try {
            nama = br.readLine().trim();
            if (nama.isEmpty()) nama = "Pemain";
        } catch (IOException e) {
            System.out.println(Warna.MERAH + "  [ERROR] Gagal membaca nama." + Warna.RESET);
            nama = "Pemain";
        }

        // Buat sesi permainan
        GameSession sesi = new GameSession(nama);
        System.out.println("  Halo, " + Warna.CYAN + sesi.getNamaPemain()
                + Warna.RESET + "! Siap menebak angka?");

        // --- Loop Menu Utama ---
        boolean programBerjalan = true;
        while (programBerjalan) {

            // Tampil menu
            System.out.println(Warna.BIRU + "\n  +-------------------------+");
            System.out.println(  "  |      MENU  UTAMA        |");
            System.out.println(  "  +-------------------------+");
            System.out.println(  "  |  1. Mulai Bermain       |");
            System.out.println(  "  |  2. Keluar              |");
            System.out.println(  "  +-------------------------+" + Warna.RESET);
            System.out.print("  Pilih menu (1/2): ");

            // Baca pilihan menu dengan exception handling
            int pilihan = 0;
            try {
                String inputMenu = br.readLine().trim();
                pilihan = Integer.parseInt(inputMenu);
                if (pilihan != 1 && pilihan != 2) {
                    System.out.println(Warna.MERAH
                            + "  Pilihan tidak valid! Masukkan 1 atau 2." + Warna.RESET);
                    continue; // ulangi loop menu
                }
            } catch (NumberFormatException e) {
                System.out.println(Warna.MERAH
                        + "  Masukkan harus angka 1 atau 2!" + Warna.RESET);
                continue;
            } catch (IOException e) {
                System.out.println(Warna.MERAH
                        + "  [ERROR] Gagal membaca pilihan." + Warna.RESET);
                break;
            }

            // --- Pilihan 1: Mulai Bermain ---
            if (pilihan == 1) {
                System.out.println("\n  " + Warna.HIJAU + Warna.TEBAL
                        + "=== PERMAINAN DIMULAI! ===" + Warna.RESET);
                System.out.println("  Komputer memilih angka 1-100. Tebak dalam 10 detik!");

                boolean lanjut = true;
                while (lanjut) {
                    GameEngine.jalankanRonde(sesi, br);

                    System.out.print("\n  Mau tebak angka baru? (y/n): ");
                    try {
                        String jawab = br.readLine().trim().toLowerCase();
                        lanjut = jawab.equals("y") || jawab.equals("ya");
                    } catch (IOException e) {
                        System.out.println(Warna.MERAH
                                + "  [ERROR] Gagal membaca jawaban." + Warna.RESET);
                        lanjut = false;
                    }
                }

                DataManager.tampilkanStatistik(sesi);
                System.out.println("  Kembali ke menu utama...");

            // --- Pilihan 2: Keluar ---
            } else if (pilihan == 2) {
                DataManager.tampilkanStatistik(sesi);
                System.out.println(Warna.CYAN
                        + "\n  Terima kasih sudah bermain, " + sesi.getNamaPemain() + "!");
                System.out.println("  Sampai jumpa lagi!" + Warna.RESET + "\n");
                programBerjalan = false;
            }
        }

        // Tutup BufferedReader
        try {
            br.close();
        } catch (IOException e) {
            // tidak kritis, tidak perlu ditampilkan
        }
    }
}