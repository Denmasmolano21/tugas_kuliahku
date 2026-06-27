import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DataManager {
    private static final String FILE_NAME = "history_skor.txt";

    public void simpanSkor(Player player) {
        File file = new File(FILE_NAME);
        java.util.Map<String, Integer> skorMap = new java.util.LinkedHashMap<>();

        // 1. Baca data lama terlebih dahulu jika filenya ada
        if (file.exists()) {
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    if (line.contains(" - Skor: ")) {
                        String[] parts = line.split(" - Skor: ");
                        if (parts.length == 2) {
                            try {
                                skorMap.put(parts[0], Integer.parseInt(parts[1]));
                            } catch (NumberFormatException e) {
                                // abaikan jika format angka rusak
                            }
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("[!] File riwayat sebelumnya tidak dapat dibaca dengan baik.");
            }
        }

        // 2. Akumulasi skor pemain saat ini
        int skorLama = skorMap.getOrDefault(player.getNama(), 0);
        skorMap.put(player.getNama(), skorLama + player.getSkor());

        // 3. Tulis ulang semua ke dalam file (Overwrite mode)
        FileWriter writer = null;
        try {
            writer = new FileWriter(file, false); // false = menimpa isi file lama (overwrite)
            for (java.util.Map.Entry<String, Integer> entry : skorMap.entrySet()) {
                writer.write(entry.getKey() + " - Skor: " + entry.getValue() + "\n");
            }
            System.out.println("[OK] Data permainan berhasil disimpan dan diakumulasi.");
        } catch (IOException e) {
            System.out.println("[X] Terjadi kesalahan saat menyimpan data: File tidak dapat diakses.");
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    System.out.println("[X] Gagal menutup file history.");
                }
            }
        }
    }

    public void bacaRiwayat() {
        Scanner fileScanner = null;
        try {
            File file = new File(FILE_NAME);
            fileScanner = new Scanner(file);
            System.out.println("\n[HISTORY] --- RIWAYAT SKOR ---");
            while (fileScanner.hasNextLine()) {
                System.out.println(fileScanner.nextLine());
            }
            System.out.println("-----------------------\n");
        } catch (Exception e) {
            System.out.println("[X] Belum ada riwayat permainan atau file tidak ditemukan.");
        } finally {
            if (fileScanner != null) {
                fileScanner.close();
            }
        }
    }
}
