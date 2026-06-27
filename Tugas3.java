import java.util.Scanner;

public class Tugas3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nama : ");
        String nama = input.nextLine();
        System.out.print("Nilai Tugas : ");
        double tugas = input.nextDouble();
        System.out.print("Nilai UTS : ");
        double uts = input.nextDouble();
        System.out.print("Nilai UAS : ");
        double uas = input.nextDouble();
        double rata = (tugas + uts + uas) / 3;
        System.out.println("Nilai Rata-rata = " + rata);
    }
}