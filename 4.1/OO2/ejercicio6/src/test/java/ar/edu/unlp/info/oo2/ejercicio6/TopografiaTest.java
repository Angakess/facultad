package ar.edu.unlp.info.oo2.ejercicio6;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TopografiaTest {

	Agua agua = new Agua();
	Tierra tierra = new Tierra();
	Pantano pantano = new Pantano();
	
	Mixta mix1 = new Mixta();
	Mixta mix2 = new Mixta();
	Mixta mix3 = new Mixta();
	Mixta mix4 = new Mixta();
	Mixta mix5 = new Mixta();
	
	
	@BeforeEach
	void setUp() throws Exception {
		mix1.agregarTopografia(agua);
		mix1.agregarTopografia(tierra);
		mix1.agregarTopografia(pantano);
		mix1.agregarTopografia(agua);
		
		mix2.agregarTopografia(agua);
		mix2.agregarTopografia(tierra);
		mix2.agregarTopografia(pantano);
		mix2.agregarTopografia(agua);
		
		mix3.agregarTopografia(agua);
		mix3.agregarTopografia(tierra);
		mix3.agregarTopografia(tierra);
		mix3.agregarTopografia(mix1);
		
		mix4.agregarTopografia(agua);
		mix4.agregarTopografia(tierra);
		mix4.agregarTopografia(tierra);
		mix4.agregarTopografia(mix2);
		
		mix5.agregarTopografia(agua);
		mix5.agregarTopografia(tierra);
		mix5.agregarTopografia(agua);
		mix5.agregarTopografia(pantano);
	}
    @Test
    public void testIgualdadAgua() {
        assertEquals(1, agua.getProporcionAgua());
        assertEquals(agua.getProporcionAgua(), agua.getProporcionAgua());
        assertTrue(agua.isEquals(agua));
    }
    @Test
    public void testIgualdadTierra() {
    	assertEquals(0, tierra.getProporcionAgua());
        assertEquals(tierra.getProporcionAgua(), tierra.getProporcionAgua());
        assertTrue(tierra.isEquals(tierra));
    }
    @Test
    public void testIgualdadMixta() {
    	assertEquals(mix1.getProporcion(), mix5.getProporcion());
    	assertEquals(mix1.getTopografia(), mix2.getTopografia());
    	assertTrue(mix1.isEquals(mix2));
    	assertTrue(mix3.isEquals(mix4)); //?????
    	assertFalse(mix1.isEquals(mix5));
    }

}
