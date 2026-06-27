import java.util.Scanner;

public class Kalkulator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan angka pertama: ");
        double a = input.nextDouble();

        System.out.print("Masukkan angka kedua: ");
        double b = input.nextDouble();

        System.out.print("Masukkan operator (+, -, *, /): ");
        char op = input.next().charAt(0);

        switch (op) {
            case '+':
                System.out.println("Hasil: " + (a + b));
                break;
            case '-':
                System.out.println("Hasil: " + (a - b));
                break;
            case '*':
                System.out.println("Hasil: " + (a * b));
                break;
            case '/':
                if (b == 0) {
                    System.out.println("Pembagian dengan nol tidak diperbolehkan");
                } else {
                    System.out.println("Hasil: " + (a / b));
                }
                break;
            default:
                System.out.println("Operator tidak valid");
        }

        input.close();
    }
}