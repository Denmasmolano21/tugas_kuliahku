import java.util.Scanner;

public class KalkulatorBMI {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan berat badan (kg): ");
        double berat = input.nextDouble();

        System.out.print("Masukkan tinggi badan (m): ");
        double tinggi = input.nextDouble();

        if (berat <= 0 || tinggi <= 0) {
            System.out.println("Input tidak valid!");
        } else {
            double bmi = berat / (tinggi * tinggi);

            System.out.printf("BMI Anda: %.2f\n", bmi);

            if (bmi < 18.5) {
                System.out.println("Kategori: Berat badan kurang");
            } else if (bmi < 25) {
                System.out.println("Kategori: Berat badan normal");
            } else if (bmi < 30) {
                System.out.println("Kategori: Berat badan berlebih (overweight)");
            } else {
                System.out.println("Kategori: Obesitas");
            }
        }

        input.close();
    }
}