import java.util.Scanner;

public class BalikArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] angka = new int[5];

        System.out.println("Masukkan 5 bilangan bulat:");
        for (int i = 0; i < angka.length; i++) {
            System.out.print("Bilangan ke-" + (i + 1) + ": ");
            angka[i] = input.nextInt();
        }

        System.out.println();
        System.out.print("Array dalam urutan asli: ");
        for (int i = 0; i < angka.length; i++) {
            System.out.print(angka[i] + " ");
        }
        System.out.println();

        System.out.print("Array dalam urutan terbalik: ");
        for (int i = angka.length - 1; i >= 0; i--) {
            System.out.print(angka[i] + " ");
        }
        System.out.println();

        input.close();
    }
}
