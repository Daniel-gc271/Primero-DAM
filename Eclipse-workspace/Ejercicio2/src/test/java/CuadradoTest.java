
import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import java.util.Random;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CuadradoTest {

    private Cuadrado c1;
    private Cuadrado c2;

    @BeforeEach
    void setUp() {
        c1 = new Cuadrado(5, 5, 5, 5);
        c2 = new Cuadrado(3, 4, 3, 4);
    }
    @AfterEach
    void cleanUp() {
    	c1=null;
    	c2=null;
    	System.gc();
    }
    /**
     * Comprueba que el constructor genere un cuadrado con los parametros correctos
     * asignados a los correspondientes lados
     */
    @Test
    void testConstructorConParametros() {
    	
        Cuadrado c = new Cuadrado(1, 2, 3, 4);
        assertEquals(1, c.getL1());
        assertEquals(2, c.getL2());
        assertEquals(3, c.getL3());
        assertEquals(4, c.getL4());
    }

    /**
     *  Comprueba que el constructor genere un cuadrado con los parametros correctos
     * asignados a los correspondientes lados (todos los lados deben ser 0)
     */
    @Test
    void testConstructorVacio() {
        Cuadrado c = new Cuadrado();
        assertEquals(0, c.getL1());
        assertEquals(0, c.getL2());
        assertEquals(0, c.getL3());
        assertEquals(0, c.getL4());
    }

    /**
     * Garantiza el correcto funcionamiento de los getter y setter
     */
    @Test
    void testSettersYGetters() {
        Cuadrado c = new Cuadrado();
        c.setL1(10);
        c.setL2(20);
        c.setL3(30);
        c.setL4(40);

        assertEquals(10, c.getL1());
        assertEquals(20, c.getL2());
        assertEquals(30, c.getL3());
        assertEquals(40, c.getL4());
    }

    /**
     * Garantiza el funcionamiento correcto del calculo de superficie
     */
    @Test
    void testCalcularSuperficie() {
    	Random rd=new Random(System.currentTimeMillis());
        assertEquals(25, c1.calcularSuperficie(5, 5));
        assertEquals(12, c2.calcularSuperficie(3, 4));
        for (int i = 0; i < 1000; i++) {
			int rd1 = rd.nextInt(512),rd2 = rd.nextInt(512); 
			int resOp = c1.calcularSuperficie(rd1, rd2);
			int resEsp = rd1*rd2;
			assertEquals(resEsp, resOp);
		}
    }

    @Test
    void testPerimetro() {
        assertEquals(20, c1.perimetro()); // 4 * 5
        assertEquals(12, c2.perimetro()); // 4 * 3 (usa l1)
        Random rd=new Random(System.currentTimeMillis());
        for (int i = 0; i < 1000; i++) {
        	int rd1 = rd.nextInt(512); 
        	Cuadrado c = new Cuadrado(rd1,rd1,rd1,rd1);
        	 
			int resOp = c.perimetro();
			int resEsp = rd1*4;
			assertEquals(resEsp, resOp);
		}
        
    }

    @Test
    void testEsCuadradoVerdadero() {
        assertTrue(c1.esCuadrado());
    }

    @Test
    void testEsCuadradoFalso() {
        assertFalse(c2.esCuadrado());
    }

    @Test
    void testToString() {
        String expected = "Cuadrado [l1=5, l2=5, l3=5, l4=5]";
        assertEquals(expected, c1.toString());
    }
}

