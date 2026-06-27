/**
 * Program utama untuk menunjukkan inheritance, polymorphism,
 * dan eksekusi multithreading dengan beberapa objek Hewan.
 */
public class Main {

    public static void main(String[] args) {

        // Demonstrasi polymorphism menggunakan array Hewan[]
        System.out.println("=== POLIMORFISME ===");

        Hewan[] daftarHewan = { new Kucing(), new Anjing() };

        for (Hewan h : daftarHewan) {
            h.bersuara();
        }

        // Demonstrasi multithreading dengan dua thread berjalan bersamaan
        System.out.println("\n=== MULTITHREADING ===");

        Hewan kucing = new Kucing();
        Hewan anjing = new Anjing();

        Thread thread1 = new Thread(new HewanThread(kucing));
        Thread thread2 = new Thread(new HewanThread(anjing));

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
