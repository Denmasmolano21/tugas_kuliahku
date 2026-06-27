import java.util.Scanner;

public class Tugas2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nama Pembeli : ");
        String nama = input.nextLine();
        System.out.print("Jumlah Buku : ");
        int jumlah = input.nextInt();
        int harga = 5000;
        int total = jumlah * harga;
        System.out.println("Total Harga = " + total);
    }
}