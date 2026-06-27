import java.util.Scanner;

public class Error4 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        try {
            int a = s.nextInt();
            int b = s.nextInt();
            System.out.println(a / b);
        } catch (Exception e) {
            System.out.println("Error: input harus angka atau tidak boleh nol!");
        }
    }
}
