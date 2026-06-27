import java.util.Scanner;
public class Kelulusan2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan nilai (0-100): ");
        double nilai = input.nextDouble();
        if (nilai >= 75) {
            System.out.println("LULUS");
        } else {
            System.out.println("TIDAK LULUS");
        }
        input.close();
    }
}