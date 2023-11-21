package ar.edu.unlp.info.oo1.parcialPoolCar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;


public class VehiculoTest {
	Vehiculo auto1, auto2, auto3;
	Conductor Andres, Lucas;
	
	@BeforeEach
	public void setup() throws Exception {
		Andres = new Conductor("Andres",10000,auto1);
		auto1 = new Vehiculo("aaa",5,LocalDate.of(2018, 11, 10),2000,Andres);
		Lucas = new Conductor("Lucas",5000, auto2);
		auto2 = new Vehiculo("bbb",5,LocalDate.of(2018, 11, 11),3000,Lucas);
	}
	
	@Test
	public void testEsViejo() {
		assertTrue(auto1.autoEsViejo());
		assertFalse(auto2.autoEsViejo());
	}
	
	@Test
	public void testHayLugar() {
		assertTrue(auto1.hayLugar(4));
		assertFalse(auto1.hayLugar(5));
	}
	
	@Test
	public void testCalcularBonus() {
		assertEquals(2, auto1.calcularBonus());
	}
}
