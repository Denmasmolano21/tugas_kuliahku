import java.util.Scanner;

public class CekNilai {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan nilai akhir (0-100): ");
        double nilai = input.nextDouble();

        if (nilai < 0 || nilai > 100) {
            System.out.println("Nilai tidak valid!");
        } else if (nilai >= 75) {
            System.out.println("LULUS");

            if (nilai >= 90) {
                System.out.println("Predikat: A (Sangat Baik)");
            } else if (nilai >= 80) {
                System.out.println("Predikat: B (Baik)");
            } else {
                System.out.println("Predikat: C (Cukup)");
            }

        } else {
            System.out.println("TIDAK LULUS");

            if (nilai >= 60) {
                System.out.println("Remedial");
            } else {
                System.out.println("Mengulang");
            }
        }

        input.close();
    }
}