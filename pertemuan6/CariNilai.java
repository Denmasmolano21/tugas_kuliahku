import java.util.Scanner;

public class CariNilai {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] angka = new int[5];

        System.out.println("Masukkan 5 bilangan bulat:");
        for (int i = 0; i < angka.length; i++) {
            System.out.print("Bilangan ke-" + (i + 1) + ": ");
            angka[i] = input.nextInt();
        }

        System.out.print("Masukkan bilangan yang ingin dicari: ");
        int target = input.nextInt();

        boolean ditemukan = false;
        for (int i = 0; i < angka.length; i++) {
            if (angka[i] == target) {
                ditemukan = true;
                break;
            }
        }

        if (ditemukan) {
            System.out.println("Ditemukan");
        } else {
            System.out.println("Tidak ditemukan");
        }

        input.close();
    }
}
