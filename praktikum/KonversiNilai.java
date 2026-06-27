import java.util.Scanner;

public class KonversiNilai {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan nilai (0-100): ");
        int nilai = input.nextInt();

        if (nilai < 0 || nilai > 100) {
            System.out.println("Nilai tidak valid!");
        } else if (nilai >= 85) {
            System.out.println("Grade: A");
        } else if (nilai >= 70) {
            System.out.println("Grade: B");
        } else if (nilai >= 55) {
            System.out.println("Grade: C");
        } else if (nilai >= 40) {
            System.out.println("Grade: D");
        } else {
            System.out.println("Grade: E");
        }

        input.close();
    }
}