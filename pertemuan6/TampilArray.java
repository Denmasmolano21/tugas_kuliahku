public class TampilArray {
    public static void main(String[] args) {
        int[] nilai = {10, 20, 30, 40, 50};

        System.out.println("Menampilkan nilai dengan indeks:");
        for (int i = 0; i < nilai.length; i++) {
            System.out.println("Indeks ke-" + i + " berisi " + nilai[i]);
        }
    }
}
