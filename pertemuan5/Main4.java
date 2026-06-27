import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String ulang;

        do {
            System.out.println("\nAbah Zuppa");
            System.out.println("______________");

            System.out.print("Masukkan nama pelanggan : ");
            String nama = input.nextLine();

            System.out.print("Masukkan jumlah total belanja : ");
            double totalBelanja = input.nextDouble();

            double diskon = 0;

            if (totalBelanja >= 100000) {
                diskon = totalBelanja * 0.1;
            }

            double totalBayar = totalBelanja - diskon;

            System.out.println("Pembeli : " + nama);
            System.out.println("Diskon : " + diskon);
            System.out.println("Total bayar : " + totalBayar);

            System.out.print("Ingin input lagi? (ya/tidak): ");
            ulang = input.next();
            input.nextLine();

        } while (ulang.equalsIgnoreCase("ya"));

        System.out.println("Program selesai!");

        input.close();
    }
}