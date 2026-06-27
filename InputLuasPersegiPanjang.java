import java.util.Scanner;

public class InputLuasPersegiPanjang {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan panjang : ");
        int panjang = input.nextInt();
        System.out.print("Masukkan lebar : ");
        int lebar = input.nextInt();
        int luas = panjang * lebar;
        System.out.println("Luas Persegi Panjang = " + luas);
    }
}