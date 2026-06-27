class Hewan {
	void bersuara() {
		System.out.println("suara hewan");
		}
}
class Kucing extends Hewan {
	@Override
	void bersuara() {
		System.out.println("Meong!");
	}
}
class Sapi extends Hewan {
	@Override
	void bersuara() {
		System.out.println("Moooo!");
	}
}
class Anjing extends Hewan {
	@Override
	void bersuara() {
		System.out.println("Guk Guk!");
	}
}
class Bebek extends Hewan {
	@Override
	void bersuara() {
		System.out.println("Kwek Kwek!");
	}
}

public class pertemuan14 {
	public static void main(String[] args) {
		Hewan hwn = new Hewan();
		Hewan hwn1 = new Kucing();
		Hewan hwn2 = new Sapi();
		Hewan hwn3 = new Anjing();
		Hewan hwn4 = new Bebek();
		hwn.bersuara();
		hwn1.bersuara();
		hwn2.bersuara();
		hwn3.bersuara();
		hwn4.bersuara();
	}
}