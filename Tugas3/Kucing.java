/**
 * Subclass Kucing yang mewarisi Hewan dan mengoverride method bersuara().
 */
public class Kucing extends Hewan {

    /**
     * Konstruktor default Kucing dengan nama generik.
     */
    public Kucing() {
        super("Kucing");
    }

    /**
     * Konstruktor overload untuk memberi nama kucing secara spesifik.
     *
     * @param nama Nama kucing
     */
    public Kucing(String nama) {
        super(nama);
    }

    @Override
    public void bersuara() {
        System.out.println(nama + " : Meong!");
    }
}
