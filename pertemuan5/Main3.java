import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("\nData Mahasiswa");
        System.out.println("______________");

        System.out.print("Masukkan Nama Mahasiswa : ");
        String Nama = input.nextLine();

        System.out.print("Masukkan Nilai Mahasiswa : ");
        int Nilai = input.nextInt();

        System.out.println("\nHasil :");
        System.out.println("________");
        System.out.println("Nama Mahasiswa : " + Nama);
        System.out.println("Nilai Ujian : " + Nilai);

        if (Nilai >= 80) {
            System.out.println("Grade : A\n");
        } else if (Nilai >= 75) {
            System.out.println("Grade : B\n");
        } else {
            System.out.println("Grade : C\n");
        }
        
        input.close();
    }
}