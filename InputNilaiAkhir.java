import java.util.Scanner;

public class InputNilaiAkhir {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nilai Tugas : ");
        double tugas = input.nextDouble();
        System.out.print("Nilai UTS : ");
        double uts = input.nextDouble();
        System.out.print("Nilai UAS : ");
        double uas = input.nextDouble();
        double akhir = (tugas + uts + uas) / 3;
        System.out.println("Nilai Akhir = " + akhir);
    }
}