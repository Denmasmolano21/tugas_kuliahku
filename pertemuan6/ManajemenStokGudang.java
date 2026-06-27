import java.util.Scanner;

public class ManajemenStokGudang {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan jumlah jenis barang: ");
        int jumlahBarang = input.nextInt();
        input.nextLine();

        String[] kodeBarang = new String[jumlahBarang];
        String[] namaBarang = new String[jumlahBarang];
        int[] stokSaatIni = new int[jumlahBarang];
        int[] stokMinimum = new int[jumlahBarang];
        String[] status = new String[jumlahBarang];
        int[] selisih = new int[jumlahBarang];

        System.out.println("=== INPUT DATA BARANG ===");
        for (int i = 0; i < jumlahBarang; i++) {
            System.out.println("Barang ke-" + (i + 1));
            System.out.print("Kode barang: ");
            kodeBarang[i] = input.nextLine();
            System.out.print("Nama barang: ");
            namaBarang[i] = input.nextLine();
            System.out.print("Stok saat ini: ");
            stokSaatIni[i] = input.nextInt();
            System.out.print("Stok minimum: ");
            stokMinimum[i] = input.nextInt();
            input.nextLine();

            if (stokSaatIni[i] <= stokMinimum[i]) {
                status[i] = "SEGERA RESTOCK";
                selisih[i] = stokMinimum[i] - stokSaatIni[i];
            } else if (stokSaatIni[i] > 2 * stokMinimum[i]) {
                status[i] = "STOK BERLEBIHAN";
                selisih[i] = stokSaatIni[i] - 2 * stokMinimum[i];
            } else {
                status[i] = "NORMAL";
                selisih[i] = 0;
            }
        }

        System.out.println("\n=== LAPORAN STOK GUDANG ===");
        System.out.printf("%-6s %-20s %-6s %-5s %s%n", "Kode", "Nama", "Stok", "Min", "Status");
        System.out.printf("%-6s %-20s %-6s %-5s %s%n", "----", "----", "----", "---", "------");

        int totalStok = 0;
        for (int i = 0; i < jumlahBarang; i++) {
            totalStok += stokSaatIni[i];
            String statusTampil = status[i];
            if (status[i].equals("SEGERA RESTOCK")) {
                statusTampil += " (kurang " + selisih[i] + ")";
            } else if (status[i].equals("STOK BERLEBIHAN")) {
                statusTampil += " (lebih " + selisih[i] + ")";
            }

            System.out.printf("%-6s %-20s %-6d %-5d %s%n",
                    kodeBarang[i], namaBarang[i], stokSaatIni[i], stokMinimum[i], statusTampil);
        }

        System.out.println("Total stok semua barang: " + totalStok);
        System.out.print("Apakah ingin menampilkan hanya barang yang perlu di-restock? (Y/T): ");
        String jawaban = input.nextLine().trim();

        if (jawaban.equalsIgnoreCase("Y")) {
            System.out.println("\n=== BARANG YANG PERLU SEGERA DI-RESTOCK ===");
            for (int i = 0; i < jumlahBarang; i++) {
                if (status[i].equals("SEGERA RESTOCK")) {
                    System.out.println(kodeBarang[i] + " - " + namaBarang[i]
                            + " : perlu tambahan " + selisih[i] + " unit");
                }
            }
        }

        input.close();
    }
}
