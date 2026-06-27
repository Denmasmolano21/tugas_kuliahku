import java.util.Scanner;

public class DataMahasiswa {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan jumlah mahasiswa: ");
        int n = input.nextInt();
        input.nextLine();

        String[] nama = new String[n];

        System.out.println("Masukkan nama mahasiswa:");
        for (int i = 0; i < n; i++) {
            System.out.print("Mahasiswa ke-" + (i + 1) + ": ");
            nama[i] = input.nextLine();
        }

        System.out.println("\nDaftar nama mahasiswa:");
        for (int i = 0; i < n; i++) {
            System.out.println((i + 1) + ". " + nama[i]);
        }

        input.close();
    }
}
