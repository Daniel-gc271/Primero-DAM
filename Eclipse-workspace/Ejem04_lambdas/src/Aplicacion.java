
public class Aplicacion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Persona p1 = new Persona("Juan", 25, "Madrid");
		CaminABLE c1 = new CaminABLE() {

			@Override
			public void caminar() {
				// TODO Auto-generated method stub

			}
		};

		CaminABLE c2 = () -> System.out.println();

		CaminABLE c3 = () -> {
				// TODO Auto-generated method stub
				
			
		};
		System.out.println(p1);
	}

}
