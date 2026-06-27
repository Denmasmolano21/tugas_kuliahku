import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

// ============================================================
//  FORMATIF 2 - ALGORITMA DAN PEMROGRAMAN LANJUT
//  Komponen: Class & Object, Overloading, Exception Handling
// ============================================================

// ============================================================
// 1. CLASS ENTITAS  =>  Merepresentasikan data produk bunga
// ============================================================
class Bunga {

    // --- Atribut / Field ---
    private String kodeBunga;
    private String namaBunga;
    private int    harga;
    private int    jumlahPesan;

    // --- CONSTRUCTOR 1 : tanpa parameter (default) ---
    public Bunga() {
        this.kodeBunga   = "-";
        this.namaBunga   = "Tidak Diketahui";
        this.harga       = 0;
        this.jumlahPesan = 0;
    }

    // --- CONSTRUCTOR 2 : dengan kode & jumlah saja ---
    public Bunga(String kodeBunga, int jumlahPesan) {
        this.kodeBunga   = kodeBunga;
        this.jumlahPesan = jumlahPesan;
        // Harga & nama ditentukan dari kode
        setInfoDariKode(kodeBunga);
    }

    // --- CONSTRUCTOR 3 : dengan semua parameter lengkap ---
    public Bunga(String kodeBunga, String namaBunga, int harga, int jumlahPesan) {
        this.kodeBunga   = kodeBunga;
        this.namaBunga   = namaBunga;
        this.harga       = harga;
        this.jumlahPesan = jumlahPesan;
    }

    // --- Helper: set nama & harga berdasarkan kode ---
    private void setInfoDariKode(String kode) {
        switch (kode.toUpperCase()) {
            case "A":
                this.namaBunga = "Mawar Merah";
                this.harga     = 200000;
                break;
            case "B":
                this.namaBunga = "Mawar Putih";
                this.harga     = 250000;
                break;
            case "C":
                this.namaBunga = "Mawar Kuning";
                this.harga     = 180000;
                break;
            default:
                this.namaBunga = "Tidak Ada";
                this.harga     = 0;
        }
    }

    // --- METHOD OVERLOADING : hitungSubtotal ---

    // Overload 1 : subtotal normal (harga x jumlah)
    public int hitungSubtotal() {
        return harga * jumlahPesan;
    }

    // Overload 2 : subtotal dengan diskon persen (misal diskon 10%)
    public double hitungSubtotal(int diskonPersen) {
        double subtotal = harga * jumlahPesan;
        return subtotal - (subtotal * diskonPersen / 100.0);
    }

    // Overload 3 : subtotal dengan potongan nominal langsung
    public int hitungSubtotal(int jumlahUnit, int potonganNominal) {
        return (harga * jumlahUnit) - potonganNominal;
    }

    // --- Getter & Setter ---
    public String getKodeBunga()   { return kodeBunga; }
    public String getNamaBunga()   { return namaBunga; }
    public int    getHarga()       { return harga; }
    public int    getJumlahPesan() { return jumlahPesan; }

    public void setKodeBunga(String kodeBunga) {
        this.kodeBunga = kodeBunga;
        setInfoDariKode(kodeBunga);
    }
    public void setJumlahPesan(int jumlahPesan) { this.jumlahPesan = jumlahPesan; }

    // --- toString untuk tampilkan data ---
    @Override
    public String toString() {
        return String.format("%-5s %-15s Rp.%-10d %-6d Rp.%d",
                kodeBunga, namaBunga, harga, jumlahPesan, hitungSubtotal());
    }
}


// ============================================================
// 2. CLASS DATA MANAGER  =>  Mengelola penyimpanan & pembacaan
// ============================================================
class DataManager {

    private String namaFile;
    private ArrayList<Bunga> daftarBunga;

    // --- CONSTRUCTOR 1 : default nama file ---
    public DataManager() {
        this.namaFile    = "data_bunga.txt";
        this.daftarBunga = new ArrayList<>();
    }

    // --- CONSTRUCTOR 2 : nama file kustom ---
    public DataManager(String namaFile) {
        this.namaFile    = namaFile;
        this.daftarBunga = new ArrayList<>();
    }

    // --- Tambah data ke list ---
    public void tambahBunga(Bunga b) {
        daftarBunga.add(b);
    }

    public ArrayList<Bunga> getDaftarBunga() {
        return daftarBunga;
    }

    // --- SIMPAN ke file (Exception Handling: IOException) ---
    public void simpanKeFile() {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(namaFile);
            bw = new BufferedWriter(fw);
            for (Bunga b : daftarBunga) {
                // Format: KODE|NAMA|HARGA|JUMLAH
                bw.write(b.getKodeBunga() + "|" +
                         b.getNamaBunga() + "|" +
                         b.getHarga()     + "|" +
                         b.getJumlahPesan());
                bw.newLine();
            }
            System.out.println("[INFO] Data berhasil disimpan ke file: " + namaFile);
        } catch (IOException e) {
            System.out.println("[ERROR] Gagal menyimpan file: " + e.getMessage());
        } finally {
            // finally selalu dijalankan, pastikan stream ditutup
            try {
                if (bw != null) bw.close();
                if (fw != null) fw.close();
            } catch (IOException e) {
                System.out.println("[ERROR] Gagal menutup file writer.");
            }
            System.out.println("[INFO] Proses simpan selesai.");
        }
    }

    // --- BACA dari file (Exception Handling: file tidak ditemukan & format corrupt) ---
    public void bacaDariFile() {
        daftarBunga.clear();
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(namaFile);   // Lempar FileNotFoundException jika tidak ada
            br = new BufferedReader(fr);
            String baris;
            int noBaris = 0;
            while ((baris = br.readLine()) != null) {
                noBaris++;
                String[] bagian = baris.split("\\|");

                // Validasi format: harus ada 4 kolom
                if (bagian.length != 4) {
                    throw new Exception("Format baris ke-" + noBaris + " korup! Isi: " + baris);
                }

                String kode  = bagian[0];
                String nama  = bagian[1];
                int harga    = Integer.parseInt(bagian[2]); // bisa NumberFormatException
                int jumlah   = Integer.parseInt(bagian[3]);

                daftarBunga.add(new Bunga(kode, nama, harga, jumlah));
            }
            System.out.println("[INFO] Berhasil membaca " + daftarBunga.size() + " data dari file.");

        } catch (FileNotFoundException e) {
            // Spesifik: file tidak ditemukan
            System.out.println("[ERROR] File tidak ditemukan: " + namaFile);
        } catch (NumberFormatException e) {
            // Spesifik: format angka salah / corrupt
            System.out.println("[ERROR] Format data angka corrupt di file: " + e.getMessage());
        } catch (Exception e) {
            // Umum: format baris corrupt atau error lain
            System.out.println("[ERROR] " + e.getMessage());
        } finally {
            try {
                if (br != null) br.close();
                if (fr != null) fr.close();
            } catch (IOException e) {
                System.out.println("[ERROR] Gagal menutup file reader.");
            }
            System.out.println("[INFO] Proses baca selesai.");
        }
    }

    // --- Hitung total semua pemesanan ---
    public int hitungTotal() {
        int total = 0;
        for (Bunga b : daftarBunga) {
            total += b.hitungSubtotal();
        }
        return total;
    }
}


// ============================================================
// 3. CLASS MAIN MENU  =>  Antarmuka pengguna (UI/interaksi)
// ============================================================
class MainMenu {

    private Scanner    input;
    private DataManager dm;

    // --- CONSTRUCTOR 1 : inisialisasi default ---
    public MainMenu() {
        this.input = new Scanner(System.in);
        this.dm    = new DataManager("data_bunga.txt");
    }

    // --- CONSTRUCTOR 2 : dengan nama file kustom ---
    public MainMenu(String namaFile) {
        this.input = new Scanner(System.in);
        this.dm    = new DataManager(namaFile);
    }

    // --- Tampilkan menu utama ---
    public void tampilkanMenu() {
        System.out.println("\n========================================");
        System.out.println("     TOKO BUNGA 'MAWAR INDAH' v2.0     ");
        System.out.println("========================================");
        System.out.println(" 1. Input Data Pesanan");
        System.out.println(" 2. Tampilkan Semua Pesanan");
        System.out.println(" 3. Simpan Data ke File");
        System.out.println(" 4. Baca Data dari File");
        System.out.println(" 5. Hitung Total & Grand Total");
        System.out.println(" 0. Keluar");
        System.out.println("========================================");
        System.out.print("Pilih menu: ");
    }

    // --- Proses Input Pesanan (Exception Handling: input salah) ---
    public void inputPesanan() {
        try {
            System.out.print("Kode Bunga [A/B/C]: ");
            String kode = input.next().toUpperCase();

            if (!kode.equals("A") && !kode.equals("B") && !kode.equals("C")) {
                throw new IllegalArgumentException("Kode bunga tidak valid! Harus A, B, atau C.");
            }

            System.out.print("Jumlah Pesanan    : ");
            int jumlah = input.nextInt();

            if (jumlah <= 0) {
                throw new IllegalArgumentException("Jumlah pesanan harus lebih dari 0!");
            }

            // Gunakan Constructor 2 Bunga (kode + jumlah)
            Bunga pesanan = new Bunga(kode, jumlah);
            dm.tambahBunga(pesanan);

            System.out.println("[OK] Pesanan ditambahkan: " + pesanan.getNamaBunga()
                    + " x" + jumlah);

        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] Input salah: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("[ERROR] Terjadi kesalahan input: " + e.getMessage());
            input.nextLine(); // bersihkan buffer
        } finally {
            System.out.println("[INFO] Proses input selesai.");
        }
    }

    // --- Tampilkan semua pesanan ---
    public void tampilkanPesanan() {
        System.out.println("\n--- DAFTAR PESANAN ---");
        System.out.printf("%-5s %-15s %-12s %-6s %s%n",
                "Kode", "Nama", "Harga", "Jumlah", "Subtotal");
        System.out.println("------------------------------------------------------");

        ArrayList<Bunga> list = dm.getDaftarBunga();
        if (list.isEmpty()) {
            System.out.println("  (Belum ada data pesanan)");
        } else {
            for (Bunga b : list) {
                System.out.println(b.toString());
            }
        }
        System.out.println("------------------------------------------------------");
    }

    // --- Hitung & tampilkan total ---
    public void tampilkanTotal() {
        int total       = dm.hitungTotal();
        double pajak    = total * 0.10;
        double grandTotal = total + pajak;

        System.out.println("\n--- RINGKASAN PEMBAYARAN ---");
        System.out.println("Total       : Rp." + total);
        System.out.println("Pajak 10%   : Rp." + pajak);
        System.out.println("Grand Total : Rp." + grandTotal);

        // Demo overloading hitungSubtotal
        System.out.println("\n--- DEMO METHOD OVERLOADING ---");
        ArrayList<Bunga> list = dm.getDaftarBunga();
        if (!list.isEmpty()) {
            Bunga contoh = list.get(0);
            System.out.println("Subtotal normal          : Rp." + contoh.hitungSubtotal());
            System.out.println("Subtotal diskon 10%      : Rp." + contoh.hitungSubtotal(10));
            System.out.println("Subtotal potong Rp.5000  : Rp." + contoh.hitungSubtotal(contoh.getJumlahPesan(), 5000));
        }
    }

    // --- Jalankan aplikasi (loop utama) ---
    public void jalankan() {
        int pilihan;
        do {
            tampilkanMenu();
            try {
                pilihan = Integer.parseInt(input.next()); // bisa NumberFormatException
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] Pilihan harus berupa angka!");
                pilihan = -1;
                continue;
            }

            switch (pilihan) {
                case 1: inputPesanan();           break;
                case 2: tampilkanPesanan();        break;
                case 3: dm.simpanKeFile();         break;
                case 4: dm.bacaDariFile();         break;
                case 5: tampilkanTotal();          break;
                case 0: System.out.println("Terima kasih! Sampai jumpa."); break;
                default: System.out.println("[WARN] Pilihan tidak tersedia.");
            }

        } while (pilihan != 0);

        input.close();
    }
}


// ============================================================
// 4. CLASS UTAMA  =>  Entry point program
// ============================================================
public class formatif2 {
    public static void main(String[] args) {
        // Instansiasi MainMenu (bisa pakai constructor 1 atau 2)
        MainMenu menu = new MainMenu("pesanan_bunga.txt");
        menu.jalankan();
    }
}
