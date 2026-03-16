import intefaz.InterfazGrafico;

public class Aplicacion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hola mundo");
		InterfazGrafico ig = new InterfazGrafico("Tit",180,160);
		Persona p1 = new Persona("Juan");
		System.out.println(p1.nombre());
	}

}
