/**
 * Kelas dasar Hewan dengan atribut nama, konstruktor overload,
 * dan method bersuara() yang dapat dioverride oleh subclass.
 */
public class Hewan {

    protected String nama;

    /**
     * Konstruktor default untuk Hewan umum.
     */
    public Hewan() {
        this.nama = "Hewan";
    }

    /**
     * Konstruktor overload yang menerima nama hewan.
     *
     * @param nama Nama hewan
     */
    public Hewan(String nama) {
        this.nama = nama;
    }

    /**
     * Method default untuk suara hewan.
     * Subclass dapat mengimplementasikan suara khusus.
     */
    public void bersuara() {
        System.out.println(nama + " : bersuara!");
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}
