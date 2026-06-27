import java.util.Scanner;

public class test {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    
    System.out.print("Masukkan angka: ");
    int angka = scanner.nextInt();
    
    if (angka >= 20) {
      System.out.println("Angka tersebut adalah positif");
    } else {
      System.out.println("Angka tersebut adalah negatip");
    }
  }
}