
public class Teste {

	public static void main(String[] args) {
		Triangle a = new Triangle();
		a.setCotes(10, 10, 8);
		Triangle b = new Triangle();
		b.setCotes(10, 10, 8);
		System.out.println(a.getPerimetre());
		System.out.println(a.getAire());
		System.out.println(b.getAire());
		System.out.println(a.getAngleA());
		System.out.println(a.getAngleB());
		System.out.println(a.getAngleC());
		
		System.out.println(a.estEgal(b));
		System.out.println(a.estSemblables(b));
		System.out.println(a.getCoteAB());
		System.out.println(b.getCoteAB());
		System.out.println(a.description());
		System.out.println(b.description());

	}
}
