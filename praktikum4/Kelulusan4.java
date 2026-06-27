import java.util.Scanner;
public class Kelulusan4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan nilai akhir (0-100): ");
        double nilai = input.nextDouble();
        if (nilai < 0 || nilai > 100) {
            System.out.println("Nilai tidak valid!");
        } else {    
            char grade;
            if (nilai >= 85) {
                grade = 'A';
            } else if (nilai >= 70) {
                grade = 'B';
            } else if (nilai >= 55) {
                grade = 'C';
            } else if (nilai >= 40) {
                grade = 'D';
            } else {
                grade = 'E';
            }
            System.out.println("Grade: " + grade);
            switch (grade) {
                case 'A':
                    System.out.println("Pertahankan prestasi!");
                    break;
                case 'B':
                    System.out.println("Tingkatkan lagi!");
                    break;
                case 'C':
                    System.out.println("Belajar lebih giat.");
                    break;
                case 'D':
                    System.out.println("Harus remedial.");
                    break;
                case 'E':
                    System.out.println("Mengulang mata kuliah.");
                    break;
            }
        }
        input.close();
    }
}