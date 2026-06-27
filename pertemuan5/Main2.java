public class Main2 {
	public static void main(String[] args) {
		int Nilai = 60;
		System.out.println("\nData Nilai Mahasiswa");
		System.out.println("____________________");
		System.out.println("Nama  : Agus");
		System.out.println("Nilai : " + Nilai);
		
		if(Nilai >= 80) {
			System.out.println("Nilai Anda A!\n");	
		} else if(Nilai >= 75) {
			System.out.println("Nilai Anda B!\n");
		} else {
			System.out.println("Nilai Anda C!\n");
		}
						
	}
}