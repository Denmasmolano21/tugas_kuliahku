import java.util.Scanner;

public class Kasir {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        try {
            System.out.print("Jumlah barang: ");
            int jumlah = s.nextInt();
            System.out.print("Harga barang: ");
            int harga = s.nextInt();
            int total = jumlah * harga;
            System.out.println("Total: " + total);
        } catch (Exception e) {
            System.out.println("Error: input harus angka!");
        }
    }
}
