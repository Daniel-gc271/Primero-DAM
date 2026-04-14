import controlador.Controlador;
import vista.InterfazGrafico;

public class Aplicacion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Controlador controlador = new Controlador();
		InterfazGrafico interfaz = new InterfazGrafico(controlador);
		controlador.setInterfaz(interfaz);
		
		
	}

}
