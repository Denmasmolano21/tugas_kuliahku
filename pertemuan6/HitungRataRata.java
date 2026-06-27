import java.util.Scanner;

public class HitungRataRata {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] angka = new int[5];

        System.out.println("Masukkan 5 bilangan bulat:");
        for (int i = 0; i < angka.length; i++) {
            System.out.print("Bilangan ke-" + (i + 1) + ": ");
            angka[i] = input.nextInt();
        }

        int jumlah = 0;
        for (int i = 0; i < angka.length; i++) {
            jumlah += angka[i];
        }

        double rataRata = (double) jumlah / angka.length;

        System.out.println();
        System.out.println("Jumlah: " + jumlah);
        System.out.println("Rata-rata: " + rataRata);
        input.close();
    }
}
