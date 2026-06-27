import java.util.Scanner;

public class KategoriUsia {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan umur: ");
        int umur = input.nextInt();

        if (umur >= 0 && umur <= 5) {
            System.out.println("Balita");
        } else if (umur <= 12) {
            System.out.println("Anak-anak");
        } else if (umur <= 17) {
            System.out.println("Remaja");
        } else if (umur <= 25) {
            System.out.println("Pemuda");
        } else if (umur <= 60) {
            System.out.println("Dewasa");
        } else if (umur > 60) {
            System.out.println("Lansia");
        } else {
            System.out.println("Input tidak valid");
        }

        input.close();
    }
}