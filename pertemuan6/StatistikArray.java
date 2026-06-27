import java.util.Scanner;

public class StatistikArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] angka = new int[5];
        int jumlah = 0;

        System.out.println("Masukkan 5 bilangan bulat:");
        for (int i = 0; i < angka.length; i++) {
            System.out.print("Bilangan ke-" + (i + 1) + ": ");
            angka[i] = input.nextInt();
            jumlah += angka[i];
        }

        double rataRata = (double) jumlah / angka.length;
        System.out.println("\nJumlah: " + jumlah);
        System.out.println("Rata-rata: " + rataRata);
        input.close();
    }
}
