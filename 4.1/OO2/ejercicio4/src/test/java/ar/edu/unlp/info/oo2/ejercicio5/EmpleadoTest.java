package ar.edu.unlp.info.oo2.ejercicio5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmpleadoTest {
	
	Temporario tomas;
	Pasante paula;
	Planta rosa;
	
	@BeforeEach
	void setUp() throws Exception{
		tomas = new Temporario(true, 3, 10);
		paula = new Pasante(false, 1, 5);
		rosa = new Planta(false, 0, 6);
	}
	@Test
	public void testSueldo1() {
		assertEquals(30460,tomas.sueldo1());
		assertEquals(26900,paula.sueldo1());
		assertEquals(54900,rosa.sueldo1());
	}
	@Test
	public void testSueldo2() {
		assertEquals(30460,tomas.sueldo2());
		assertEquals(26900,paula.sueldo2());
		assertEquals(54900,rosa.sueldo2());
	}
	

}
