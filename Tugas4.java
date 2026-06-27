import java.util.Scanner;

public class Tugas4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nama : ");
        String nama = input.nextLine();
        System.out.print("Jumlah Halaman : ");
        int pages = input.nextInt();
        int biayaPerLembar = 200;
        int total = pages * biayaPerLembar;
        System.out.println("Total Biaya Fotokopi = " + total);
    }
}