/**
 * Subclass Anjing yang mewarisi Hewan dan mengoverride method bersuara().
 */
public class Anjing extends Hewan {

    /**
     * Konstruktor default Anjing dengan nama generik.
     */
    public Anjing() {
        super("Anjing");
    }

    /**
     * Konstruktor overload untuk memberi nama anjing secara spesifik.
     *
     * @param nama Nama anjing
     */
    public Anjing(String nama) {
        super(nama);
    }

    @Override
    public void bersuara() {
        System.out.println(nama + " : Guk!");
    }
}
