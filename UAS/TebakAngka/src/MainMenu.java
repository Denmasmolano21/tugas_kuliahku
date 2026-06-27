import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class MainMenu {
    private DataManager dataManager;
    private BufferedReader reader;

    // Unicode & ANSI Colors
    public static final String RESET = "\u001B[0m";
    public static final String GREEN = "\u001B[32m";
    public static final String RED = "\u001B[31m";
    public static final String YELLOW = "\u001B[33m";
    public static final String CYAN = "\u001B[36m";

    public MainMenu() {
        this.dataManager = new DataManager();
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void tampilkanMenu() {
        while (true) {
            System.out.println(CYAN + "========================================" + RESET);
            System.out.println(YELLOW + "SELAMAT DATANG DI GAME TEBAK ANGKA" + RESET);
            System.out.println(CYAN + "========================================" + RESET);
            System.out.println("1. Mulai Bermain");
            System.out.println("2. Lihat Riwayat Skor");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu (1-3): ");

            try {
                String inputMenu = reader.readLine();
                int pilihan = Integer.parseInt(inputMenu);

                if (pilihan == 1) {
                    mulaiGame();
                } else if (pilihan == 2) {
                    dataManager.bacaRiwayat();
                } else if (pilihan == 3) {
                    System.out.println("[BYE] " + GREEN + "Terima kasih telah bermain!" + RESET);
                    break;
                } else {
                    System.out.println(RED + "[X] Pilihan menu tidak valid. Masukkan angka 1, 2, atau 3." + RESET);
                }
            } catch (NumberFormatException e) {
                System.out.println(RED + "[X] Pilihan tidak valid! Harus berupa angka." + RESET);
            } catch (Exception e) {
                System.out.println(RED + "[X] Terjadi kesalahan pada sistem input." + RESET);
            }
            System.out.println();
        }
    }

    private void mulaiGame() {
        System.out.print("Masukkan nama Anda (kosongkan untuk Anonim): ");
        String nama = "";
        try {
            nama = reader.readLine();
        } catch (Exception e) {
            System.out.println(RED + "[X] Gagal membaca nama." + RESET);
        }

        Player player;
        if (nama == null || nama.trim().isEmpty()) {
            player = new Player(); // Constructor 1
        } else {
            player = new Player(nama); // Constructor 2
        }

        Random random = new Random();
        boolean mainLagi = true;

        while (mainLagi) {
            int angkaRahasia = random.nextInt(100) + 1; // 1-100
            System.out.println("\n" + CYAN + "[*] Komputer telah memilih angka antara 1 - 100." + RESET);
            System.out.println("[TIME] Anda memiliki waktu 10 detik untuk setiap tebakan!\n");

            boolean ditebak = false;

            while (!ditebak) {
                System.out.println("\n" + CYAN + "[TIME] [Sisa waktu: 10 detik]" + RESET);
                System.out.print(CYAN + "Ketik tebakan Anda lalu tekan ENTER: " + RESET);
                
                TimerThread timer = new TimerThread(9);
                timer.setDaemon(true); 
                timer.start();
                
                String input = null;
                
                try {
                    while (!timer.isTimeOut()) {
                        if (reader.ready()) {
                            input = reader.readLine();
                            timer.interrupt(); // Berhasil menginput sebelum timeout
                            break;
                        }
                        Thread.sleep(50); // Mencegah CPU usage tinggi
                    }
                } catch (Exception e) {
                    System.out.println(RED + "[X] Kesalahan sistem saat membaca input." + RESET);
                }

                if (timer.isTimeOut()) {
                    System.out.println("\n" + RED + "[X] Waktu habis! Kesempatan menjawab hilang." + RESET);
                    System.out.println(YELLOW + "Tekan ENTER untuk mengonfirmasi dan melanjutkan..." + RESET);
                    try {
                        reader.readLine(); // Menangkap ENTER yang telat ditekan user agar tidak bocor ke menu berikutnya
                    } catch (Exception e) {}
                    break; // Keluar dari perulangan tebakan, lanjut ke pertanyaan main lagi
                }

                if (input != null && !input.trim().isEmpty()) {
                    try {
                        int tebakan = Integer.parseInt(input);

                        if (tebakan < 1 || tebakan > 100) {
                            System.out.println(YELLOW + "[!] Masukkan harus angka 1–100!" + RESET);
                        } else if (tebakan < angkaRahasia) {
                            System.out.println("[<] " + YELLOW + "Terlalu kecil!" + RESET);
                        } else if (tebakan > angkaRahasia) {
                            System.out.println("[>] " + YELLOW + "Terlalu besar!" + RESET);
                        } else {
                            System.out.println("[WIN] " + GREEN + "BENAR! Angka yang dicari adalah " + angkaRahasia + RESET);
                            player.tambahSkor(10);
                            player.tampilSkor("Selamat tebakan Anda tepat!"); // Method overloading 2
                            ditebak = true;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println(RED + "[X] Masukkan harus angka 1–100!" + RESET);
                    }
                }
            } // end while (!ditebak)

            System.out.print("\nApakah Anda ingin main ronde lagi? (y/n): ");
            try {
                String lanjut = reader.readLine();
                if (!lanjut.equalsIgnoreCase("y")) {
                    mainLagi = false;
                }
            } catch (Exception e) {
                mainLagi = false;
            }
        } // end while (mainLagi)

        System.out.println("\n" + CYAN + "=== HASIL AKHIR ===" + RESET);
        player.tampilSkor(); // Method overloading 1
        dataManager.simpanSkor(player);
    }
}
