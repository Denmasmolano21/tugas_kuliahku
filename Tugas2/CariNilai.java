import java.util.Scanner;

public class CariNilai {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] data = new int[5];

        System.out.println("Masukkan 5 bilangan bulat:");
        for (int i = 0; i < data.length; i++) {
            System.out.print("Bilangan ke-" + (i + 1) + ": ");
            data[i] = input.nextInt();
        }

        System.out.print("Masukkan bilangan yang ingin dicari: ");
        int cari = input.nextInt();

        boolean ditemukan = false;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == cari) {
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
