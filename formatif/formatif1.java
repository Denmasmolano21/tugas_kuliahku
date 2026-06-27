import java.util.Scanner;

public class formatif {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String ulangTransaksi;

        do {
            System.out.println("TOKO BUNGA 'MAWAR INDAH'");
            System.out.println("=======================");

            System.out.print("Masukkan jumlah data (max 3): ");
            int jumlahData = input.nextInt();

            String[] kodePaket = new String[jumlahData];
            int[] jumlahPesanan = new int[jumlahData];
            String[] namaBunga = new String[jumlahData];
            int[] harga = new int[jumlahData];
            int[] subtotal = new int[jumlahData];

            for (int i = 0; i < jumlahData; i++) {
                System.out.println("\nData ke-" + (i + 1));
                System.out.print("Kode Paket [A/B/C]: ");
                kodePaket[i] = input.next();

                System.out.print("Banyak Pesanan: ");
                jumlahPesanan[i] = input.nextInt();

                switch (kodePaket[i]) {
                    case "A":
                        namaBunga[i] = "Mawar Merah";
                        harga[i] = 200000;
                        break;
                    case "B":
                        namaBunga[i] = "Mawar Putih";
                        harga[i] = 250000;
                        break;
                    case "C":
                        namaBunga[i] = "Mawar Kuning";
                        harga[i] = 180000;
                        break;
                    default:
                        namaBunga[i] = "Tidak Ada";
                        harga[i] = 0;
                }

                subtotal[i] = harga[i] * jumlahPesanan[i];
            }

            int total = 0;
            for (int i = 0; i < jumlahData; i++) {
                total += subtotal[i];
            }
            double pajak = total * 0.10;
            double grandTotal = total + pajak;

            System.out.println("\n===== STRUK PEMBELIAN =====");
            System.out.println("No  Kode  Nama Bunga     Harga     Banyak   Subtotal");

            for (int i = 0; i < jumlahData; i++) {
                System.out.println((i + 1) + "   " + kodePaket[i] + "     " + namaBunga[i] + "    Rp." + harga[i] + "   " + jumlahPesanan[i] + "      Rp." + subtotal[i]);
            }

            System.out.println("------------------------------------------------------");
            System.out.println("Total       : Rp." + total);
            System.out.println("Bonus       : Rp." + "Kartu Ucapan (karena ada pesanan > 3)");
            System.out.println("Pajak 10%   : Rp." + pajak);
            System.out.println("Grand Total : Rp." + grandTotal);

            System.out.print("Uang Bayar  : Rp.");
            double bayar = input.nextDouble();

            double kembali = bayar - grandTotal;
            System.out.println("Uang Kembali: Rp." + kembali);

            input.nextLine();
            System.out.print("\nTransaksi lagi [Y/T]?: ");
            ulangTransaksi = input.nextLine();	

        } while (ulangTransaksi == "Y");

        System.out.println("Terima kasih!");
	input.close();
    }
}