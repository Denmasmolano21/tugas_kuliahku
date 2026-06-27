import java.util.Scanner;

public class Nilai {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        try {
            System.out.print("Jumlah nilai: ");
            int n = s.nextInt();
            int total = 0;
            for (int i = 0; i < n; i++) {
                System.out.print("Nilai ke-" + (i + 1) + ": ");
                total += s.nextInt();
            }
            System.out.println("Rata-rata: " + (total / n));
        } catch (Exception e) {
            System.out.println("Error: input harus angka!");
        }
    }
}
