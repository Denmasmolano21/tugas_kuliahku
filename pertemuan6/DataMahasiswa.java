import java.util.Scanner;

public class DataMahasiswa {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan jumlah mahasiswa: ");
        int jumlah = input.nextInt();
        input.nextLine();

        String[] namaMahasiswa = new String[jumlah];

        System.out.println();
        for (int i = 0; i < jumlah; i++) {
            System.out.print("Nama mahasiswa ke-" + (i + 1) + ": ");
            namaMahasiswa[i] = input.nextLine();
        }

        System.out.println("\nDaftar nama mahasiswa yang dimasukkan:");
        for (int i = 0; i < namaMahasiswa.length; i++) {
            System.out.println("Nama mahasiswa ke-" + (i + 1) + " = " + namaMahasiswa[i]);
        }

        input.close();
    }
}
