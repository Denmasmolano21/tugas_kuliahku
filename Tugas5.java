import java.util.Scanner;

public class Tugas5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nama Pengendara : ");
        String nama = input.nextLine();
        System.out.print("Lama Parkir (jam) : ");
        int jam = input.nextInt();
        int tarif = 2000;
        int total = jam * tarif;
        System.out.println("Total Biaya Parkir = " + total);
    }
}