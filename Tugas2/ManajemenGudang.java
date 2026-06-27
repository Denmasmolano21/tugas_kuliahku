import java.util.Scanner;

public class ManajemenGudang {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan jumlah jenis barang: ");
        int n = input.nextInt();
        input.nextLine();

        String[] kode = new String[n];
        String[] nama = new String[n];
        int[] stokSaatIni = new int[n];
        int[] stokMinimum = new int[n];

        System.out.println("\n=== INPUT DATA BARANG ===");
        for (int i = 0; i < n; i++) {
            System.out.println("\nBarang ke-" + (i + 1));
            System.out.print("Kode barang: ");
            kode[i] = input.nextLine();
            System.out.print("Nama barang: ");
            nama[i] = input.nextLine();
            System.out.print("Stok saat ini: ");
            stokSaatIni[i] = input.nextInt();
            System.out.print("Stok minimum: ");
            stokMinimum[i] = input.nextInt();
            input.nextLine();
        }

        System.out.println("\n=== LAPORAN STOK GUDANG ===");
        System.out.println("Kode\tNama\t\tStok\tMin\tStatus");

        int totalStok = 0;

        for (int i = 0; i < n; i++) {
            totalStok += stokSaatIni[i];

            int kurang = stokMinimum[i] - stokSaatIni[i];
            int lebih = stokSaatIni[i] - (2 * stokMinimum[i]);

            String status;

            if (stokSaatIni[i] <= stokMinimum[i]) {
                status = "SEGERA RESTOCK (kurang " + kurang + ")";
            } else if (stokSaatIni[i] > 2 * stokMinimum[i]) {
                status = "STOK BERLEBIHAN (lebih " + lebih + ")";
            } else {
                status = "NORMAL";
            }

            System.out.printf("%s\t%-10s\t%d\t%d\t%s\n",
                    kode[i], nama[i], stokSaatIni[i], stokMinimum[i], status);
        }

        System.out.println("\nTotal stok semua barang: " + totalStok);

        System.out.print("\nApakah ingin menampilkan hanya barang yang perlu di-restock? (Y/T): ");
        char pilihan = input.next().charAt(0);

        if (pilihan == 'Y' || pilihan == 'y') {
            System.out.println("\n=== BARANG YANG PERLU SEGERA DI-RESTOCK ===");
            boolean ada = false;

            for (int i = 0; i < n; i++) {
                if (stokSaatIni[i] <= stokMinimum[i]) {
                    ada = true;
                    int kekurangan = stokMinimum[i] - stokSaatIni[i];
                    System.out.println(kode[i] + " - " + nama[i] +
                            " : perlu tambahan " + kekurangan + " unit");
                }
            }

            if (!ada) {
                System.out.println("Tidak ada barang yang perlu di-restock.");
            }
        }

        System.out.println("\nProgram selesai.");
        input.close();
    }
}
