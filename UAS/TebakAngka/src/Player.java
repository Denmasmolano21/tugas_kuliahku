public class Player {
    private String nama;
    private int skor;

    // Constructor Overloading 1
    public Player() {
        this.nama = "Anonim";
        this.skor = 0;
    }

    // Constructor Overloading 2
    public Player(String nama) {
        this.nama = nama;
        this.skor = 0;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getSkor() {
        return skor;
    }

    public void tambahSkor(int poin) {
        this.skor += poin;
    }

    // Method Overloading 1
    public void tampilSkor() {
        System.out.println("[*] Skor " + this.nama + " saat ini: " + this.skor);
    }

    // Method Overloading 2
    public void tampilSkor(String pesanTambahan) {
        System.out.println(pesanTambahan + " | [*] Skor " + this.nama + ": " + this.skor);
    }
}
