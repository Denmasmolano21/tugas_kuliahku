import java.util.Scanner;

public class NamaHari {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan angka (1-7): ");
        int hari = input.nextInt();

        String nama;

        switch (hari) {
            case 1: nama = "Senin"; break;
            case 2: nama = "Selasa"; break;
            case 3: nama = "Rabu"; break;
            case 4: nama = "Kamis"; break;
            case 5: nama = "Jumat"; break;
            case 6: nama = "Sabtu"; break;
            case 7: nama = "Minggu"; break;
            default: nama = "Angka tidak valid"; break;
        }

        System.out.println("Hari: " + nama);

        input.close();
    }
}