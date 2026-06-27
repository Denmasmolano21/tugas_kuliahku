public class TampilArray {
    public static void main(String[] args) {
        // 1. Membuat array integer
        int[] nilai = {10, 20, 30, 40, 50};

        // 2. Menampilkan isi array
        for (int i = 0; i < nilai.length; i++) {
            System.out.println("Indeks ke-" + i + " berisi " + nilai[i]);
        }
    }
}
