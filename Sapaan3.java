import java.util.Scanner;
public class Sapaan3 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.print("Massukan waktu (pagi/siang/sore/malam): ");
    String waktu = input.nextLine().toLowerCase();

    if (waktu.equalsIgnoreCase("pagi")) {
      System.out.println("Selamat Pagi");
    } else {
      System.out.println("Selamat " + waktu + "!");
    }
  }
}