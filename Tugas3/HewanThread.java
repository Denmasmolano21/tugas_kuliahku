/**
 * Runnable yang menjalankan suara hewan di thread terpisah
 * dengan delay tetap 500 ms untuk mengikuti aturan soal.
 */
public class HewanThread implements Runnable {

    private Hewan hewan;

    public HewanThread(Hewan hewan) {
        this.hewan = hewan;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            hewan.bersuara();

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
