package ar.edu.unlp.info.oo1.parcialRecaudacion;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class test {
	
	Agencia a;
	Contribuyente Andres, Lu, Manu;
	Automotor auto1, auto2;
	Embarcacion barco1, barco2, barco3;
	Inmueble mueble1;
	
	@BeforeEach
	void setup() throws Exception {
		a = new Agencia();
		
		Andres = new Contribuyente("Andres", 111, "asdf", "laplata");
		Lu = new Contribuyente("Lu", 222, "qwer", "laplata");
		Manu = new Contribuyente("Manu", 333, "zxcv", "bsas");
		
		LocalDate fecha1 = LocalDate.of(2005,1,1);
		LocalDate fecha2 = LocalDate.of(2015,1,1);
		LocalDate fecha3 = LocalDate.of(2020, 1, 1);
		
		auto1 = new Automotor("asd", fecha1, 200, "marca1", "a1");
		auto2 = new Automotor("qwe", fecha2, 500, "marca2", "a2");
		
		barco1 = new Embarcacion("aaa", fecha3, 2000000, "b1");
		barco2 = new Embarcacion("bbb", fecha3, 200000, "b2");
		barco3 = new Embarcacion("ccc", fecha1, 2000000, "b3");
		
		mueble1 = new Inmueble(1,150,300);
		
		Andres.agregarBien(auto1);
		Andres.agregarBien(auto2);
		Andres.agregarBien(barco1);
		Andres.agregarBien(barco2);
		Andres.agregarBien(barco3);
		Andres.agregarBien(mueble1);
		
		Lu.agregarBien(auto2);
		Lu.agregarBien(mueble1);
		Lu.agregarBien(barco2);
		
		a.agregarContribuyente(Andres);
		a.agregarContribuyente(Lu);
		a.agregarContribuyente(Manu);
	}
	
	@Test
	public void testInterfaz() {
		assertEquals(0, auto1.getImpuesto());
		assertEquals(25, auto2.getImpuesto());
		
		assertEquals(300000, barco1.getImpuesto());
		assertEquals(20000, barco2.getImpuesto());
		assertEquals(0, barco3.getImpuesto());
		
		assertEquals(4.5, mueble1.getImpuesto());
		
	}
	
	@Test
	public void testInterfaz2() {
		assertEquals(320029.5, Andres.calcularImpuesto());
		assertEquals(20029.5, Lu.calcularImpuesto());
		
		List<Contribuyente> top = a.topContribuyentes(1, "laplata");
		
		assertTrue(a.getContribuyentes().contains(Andres));
		assertTrue(top.contains(Andres));
		assertFalse(top.contains(Lu));
	}
		
		
}
	
	
