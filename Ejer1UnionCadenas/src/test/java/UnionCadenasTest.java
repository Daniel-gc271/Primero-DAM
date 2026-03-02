import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UnionCadenasTest {

	@AfterEach 
	void contTest() {
		
		System.out.println("Ejecutando test #");
		
	}
	 @Test
	    @DisplayName("Unión básica de dos palabras")
	    void testUnirCadenasEstandar() {
	        assertEquals("HolaMundo", UnionCadenas.unir("Hola", "Mundo"));
	    }

	    @Test
	    @DisplayName("Unión con cadenas vacías")
	    void testUnirCadenasVacias() {
	        assertEquals("Java", UnionCadenas.unir("Java", ""));
	        assertEquals("Python", UnionCadenas.unir("", "Python"));
	        assertEquals("", UnionCadenas.unir("", ""));
	    }

	    @Test
	    @DisplayName("Unión con espacios en blanco")
	    void testUnirConEspacios() {
	        assertEquals("Hola Mundo", UnionCadenas.unir("Hola ", "Mundo"));
	    }

	    @Test
	    @DisplayName("Verificar manejo de nulos")
	    void testUnirConNulos() {
	        
	        assertThrows(NullPointerException.class, () -> {
	            UnionCadenas.unir("Hola", null);
	        });
	    }
	    @Test
	    void testNoEsNulo() {
	        String resultado = UnionCadenas.unir("A", "B");
	        assertNotNull(resultado, "El resultado no debería ser nulo");
	    }
	    @Test
	    void testPropiedadesResultado() {
	        String resultado = UnionCadenas.unir("Hola", "Mundo");
	        
	        
	        assertTrue(resultado.contains("Hola")); 
	        
	        
	        assertFalse(resultado.isEmpty());
	        assertEquals("HolaMundo".length(), resultado.length());
	    }
	
}
