public class NilaiMahasiswa {
    public static void main(String[] args) {
        String nama = "Andi";
        int nilai = 85;
        char grade;

        if (nilai >= 85) {
            grade = 'A';
        } else if (nilai >= 70) {
            grade = 'B';
        } else if (nilai >= 55) {
            grade = 'C';
        } else if (nilai >= 40) {
            grade = 'D';
        } else {
            grade = 'E';
        }

        System.out.println("Nama : " + nama);
        System.out.println("Nilai : " + nilai);
        System.out.println("Grade : " + grade);
    }
}