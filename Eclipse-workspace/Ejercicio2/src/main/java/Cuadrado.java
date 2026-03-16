
// TODO: Auto-generated Javadoc
/**
 * The Class Cuadrado.
 */
public class Cuadrado {

	/** The l 4. */
	private int l1,l2,l3,l4;
	
	
	/**
	 * Permite crear un nuevo cuadrado a partir de 4 tamaños asociados a cada lado.
	 *
	 * @param l1 Primer lado
	 * @param l2 Segundo lado
	 * @param l3 Tercer lado
	 * @param l4 Cuarto lado
	 */
	public Cuadrado(int l1, int l2, int l3, int l4) {
		super();
		this.l1 = l1;
		this.l2 = l2;
		this.l3 = l3;
		this.l4 = l4;
	}


	/**
	 * Instantiates a new cuadrado.
	 */
	public Cuadrado() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * Gets the l1.
	 *
	 * @return the l1
	 */
	public int getL1() {
		return l1;
	}


	/**
	 * Sets the l1.
	 *
	 * @param l1 the new l1
	 */
	public void setL1(int l1) {
		this.l1 = l1;
	}


	/**
	 * Gets the l2.
	 *
	 * @return the l2
	 */
	public int getL2() {
		return l2;
	}


	/**
	 * Sets the l2.
	 *
	 * @param l2 the new l2
	 */
	public void setL2(int l2) {
		this.l2 = l2;
	}


	/**
	 * Gets the l3.
	 *
	 * @return the l3
	 */
	public int getL3() {
		return l3;
	}


	/**
	 * Sets the l3.
	 *
	 * @param l3 the new l3
	 */
	public void setL3(int l3) {
		this.l3 = l3;
	}


	/**
	 * Gets the l4.
	 *
	 * @return the l4
	 */
	public int getL4() {
		return l4;
	}


	/**
	 * Sets the l4.
	 *
	 * @param l4 the new l4
	 */
	public void setL4(int l4) {
		this.l4 = l4;
	}


	/**
	 * Calcular superficie.
	 *
	 * @param lado1 the lado 1
	 * @param lado2 the lado 2
	 * @return the int
	 */
	public int calcularSuperficie(int lado1,int lado2)
	{
		return lado1*lado2;
	}

	/**
	 * Perimetro.
	 *
	 * @return the int
	 */
	public int perimetro()
	{
		return 4*l1;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Cuadrado [l1=" + l1 + ", l2=" + l2 + ", l3=" + l3 + ", l4="
				+ l4 + "]";
	}
	
	/**
	 * Es cuadrado.
	 *
	 * @return true, if successful
	 */
	public boolean esCuadrado() {
		if (l1 == l2 && l1 == l3 && l1 == l4)
			return true;
		else
			return false;
	}


}
