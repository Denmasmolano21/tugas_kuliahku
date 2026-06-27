import java.util.Scanner;

public class InputDataMahasiswa {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan Nama : ");
        String nama = input.nextLine();
        System.out.print("Masukkan NIM : ");
        String nim = input.nextLine();
        System.out.print("Masukkan Prodi : ");
        String prodi = input.nextLine();

        System.out.println("Data Mahasiswa");
        System.out.println("Nama : " + nama);
        System.out.println("NIM : " + nim);
        System.out.println("Prodi : " + prodi);
    }
}