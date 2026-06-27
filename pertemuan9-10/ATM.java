import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int saldo = 1000000;
        try {
            System.out.print("Ambil uang: ");
            int ambil = s.nextInt();
            if (ambil > saldo) {
                System.out.println("Saldo tidak cukup!");
            } else {
                saldo -= ambil;
                System.out.println("Sisa saldo: " + saldo);
            }
        } catch (Exception e) {
            System.out.println("Error: input harus angka!");
        }
    }
}
