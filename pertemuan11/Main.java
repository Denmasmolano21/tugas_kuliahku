// ==================== CLASS PASIEN ====================
class Pasien {
  private String nama;
  private int usia;
  private String keluhan;
  private int nomorAntrian;

  // Constructor 1 (tanpa keluhan)
  public Pasien(String nama, int usia) {
    this.nama = nama;
    this.usia = usia;
    this.keluhan = "Umum"; // default
  }

  // Constructor 2 (dengan keluhan) -> OVERLOADING
  public Pasien(String nama, int usia, String keluhan) {
    this.nama = nama;
    this.usia = usia;
    this.keluhan = keluhan;
  }

  // Setter untuk nomor antrian (diberikan oleh klinik)
  public void setNomorAntrian(int no) {
    this.nomorAntrian = no;
  }

  // Getter
  public String getNama() { return nama; }
  public String getKeluhan() { return keluhan; }
  public int getNomorAntrian() { return nomorAntrian; }

  // Method menampilkan info pasien
  public void infoPasien() {
    System.out.println("No. Antrian : " + nomorAntrian);
    System.out.println("Nama : " + nama);
    System.out.println("Usia : " + usia + " tahun");
    System.out.println("Keluhan : " + keluhan);
    System.out.println("--------------------------");
  }
}

// ==================== CLASS KLINIK ====================
class Klinik {
  private Pasien[] daftarPasien;
  private int jumlahPasien;
  private int counterAntrian;

  // Constructor
  public Klinik(int maksPasien) {
    daftarPasien = new Pasien[maksPasien];
    jumlahPasien = 0;
    counterAntrian = 1; // nomor antrian mulai dari 1
  }

  // Method untuk mendaftarkan pasien
  public boolean daftar(Pasien p) {
    if (jumlahPasien >= daftarPasien.length) {
      System.out.println("Maaf, antrian penuh. Tidak bisa mendaftar.");
      return false;
    }
    // Beri nomor antrian
    p.setNomorAntrian(counterAntrian++);
    // Simpan ke array
    daftarPasien[jumlahPasien++] = p;
    System.out.println(p.getNama() + " berhasil mendaftar. Nomor antrian: " + p.getNomorAntrian());
    return true;
  }

  // Method memanggil pasien berikutnya (hapus dari antrian)
  public Pasien panggilBerikutnya() {
    if (jumlahPasien == 0) {
      System.out.println("Tidak ada pasien dalam antrian.");
      return null;
    }
    Pasien p = daftarPasien[0];
    // Geser ke kiri
    for (int i = 0; i < jumlahPasien - 1; i++) {
      daftarPasien[i] = daftarPasien[i + 1];
    }
    daftarPasien[jumlahPasien - 1] = null;
    jumlahPasien--;
    System.out.println("Memanggil pasien: " + p.getNama() + " (No. Antrian " + p.getNomorAntrian() + ")");
    return p;
  }

  // Menampilkan seluruh antrian
  public void tampilkanAntrian() {
    if (jumlahPasien == 0) {
      System.out.println("Antrian kosong.");
      return;
    }
    System.out.println("\n=== DAFTAR ANTRIAN PASIEN ===");
    for (int i = 0; i < jumlahPasien; i++) {
      System.out.println((i + 1) + ". " + daftarPasien[i].getNama()
          + " (No. " + daftarPasien[i].getNomorAntrian() + ") - "
          + daftarPasien[i].getKeluhan());
    }
    System.out.println("==============================\n");
  }
}

// ==================== CLASS MAIN (DEMO) ====================
public class Main {
  public static void main(String[] args) {
    // Buat klinik dengan kapasitas maksimal 5 pasien
    Klinik klinikSehat = new Klinik(5);

    // Buat beberapa pasien (demonstrasi constructor overloading)
    Pasien p1 = new Pasien("Ani", 25); // keluhan default "Umum"
    Pasien p2 = new Pasien("Budi", 30, "Batuk pilek");
    Pasien p3 = new Pasien("Cici", 40, "Sakit kepala");
    Pasien p4 = new Pasien("Dodi", 19, "Demam");
    Pasien p5 = new Pasien("Eka", 35, "Luka ringan");
    Pasien p6 = new Pasien("Fani", 28, "Alergi"); // untuk test penuh

    // Pendaftaran
    System.out.println("=== PENDAFTARAN PASIEN ===");
    klinikSehat.daftar(p1);
    klinikSehat.daftar(p2);
    klinikSehat.daftar(p3);
    klinikSehat.daftar(p4);
    klinikSehat.daftar(p5);
    klinikSehat.daftar(p6); // akan gagal karena antrian penuh

    // Tampilkan antrian
    klinikSehat.tampilkanAntrian();

    // Panggil pasien satu per satu
    System.out.println("=== PROSES PANGGILAN ===");
    Pasien pasienDipanggil = klinikSehat.panggilBerikutnya();
    if (pasienDipanggil != null) {
      System.out.println("Silakan masuk: " + pasienDipanggil.getNama());
      pasienDipanggil.infoPasien(); // tampilkan detail
    }
    klinikSehat.panggilBerikutnya();
    klinikSehat.tampilkanAntrian(); // lihat sisa antrian

    // Tambah pendaftaran setelah ada yang dipanggil (masih ada slot)
    Pasien p7 = new Pasien("Gina", 22, "Periksa mata");
    klinikSehat.daftar(p7);
    klinikSehat.tampilkanAntrian();
  }
}
