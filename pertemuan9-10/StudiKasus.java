import java.util.InputMismatchException;
import java.util.Scanner;

public class StudiKasus {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        try {
            System.out.print("Masukkan angka pertama: ");
            int a = s.nextInt();
            System.out.print("Masukkan angka kedua: ");
            int b = s.nextInt();
            int hasil = a / b;
            System.out.println("Hasil pembagian: " + hasil);
        } catch (InputMismatchException e) {
            System.out.println("Error: input harus angka!");
        } catch (ArithmeticException e) {
            System.out.println("Error: pembagian dengan nol tidak boleh!");
        }
    }
}
