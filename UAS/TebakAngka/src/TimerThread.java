public class TimerThread extends Thread {
    private final int durasiDetik;
    private volatile boolean isTimeOut = false;

    public TimerThread(int durasiDetik) {
        this.durasiDetik = durasiDetik;
    }

    @Override
    public void run() {
        try {
            for (int i = durasiDetik; i > 0; i--) {
                Thread.sleep(1000);
                // \033[s = simpan kursor, \033[1A = naik 1 baris, \r = awal baris, \033[K = hapus sisa teks, \033[u = kembalikan kursor
                System.out.print("\033[s\033[1A\r\033[K\033[36m[TIME] [Sisa waktu: " + i + " detik]\033[0m\033[u");
            }
            System.out.print("\033[s\033[1A\r\033[K\033[31m[X] [WAKTU HABIS!]\033[0m\033[u");
            isTimeOut = true; // Set flag timeout
        } catch (InterruptedException e) {
            // Thread diinterupsi karena user berhasil menjawab, tidak timeout
            isTimeOut = false;
        }
    }

    public boolean isTimeOut() {
        return isTimeOut;
    }
}
