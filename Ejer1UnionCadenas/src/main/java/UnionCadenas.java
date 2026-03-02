
public class UnionCadenas {

	public static String unir(String cad1, String cad2) {
		if (cad1 == null || cad2 == null) {
			throw new NullPointerException();
		} else {
			String salida = cad1.concat(cad2);

			return salida;
		}
	}

}
