import java.util.Scanner;

public class Tugas1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan Nama : ");
        String nama = input.nextLine();
        System.out.print("Masukkan NIM : ");
        String nim = input.nextLine();
        System.out.print("Masukkan Program Studi : ");
        String prodi = input.nextLine();

        System.out.println("DATA MAHASISWA");
        System.out.println("Nama : " + nama);
        System.out.println("NIM : " + nim);
        System.out.println("Program Studi : " + prodi);
    }
}