package nl.saxion.junittesten;

import static org.junit.Assert.*;

import org.junit.Test;

import nl.saxion.model.Kamer;
import nl.saxion.model.Verhuurder;

public class VerhuurderTest {

	@Test
	public void testMooiWeer() {
		Verhuurder verhuurder = new Verhuurder("pietje", "precies");
		assertEquals("pietje", verhuurder.getUsername());
		assertEquals("precies", verhuurder.getPassword());
		
		assertTrue(verhuurder.getKamers().isEmpty());
		Kamer k = new Kamer(12, 20, "duitsland");
		verhuurder.addRoom(k);
		assertTrue(verhuurder.getKamers().contains(k));
		
	}
	//badweather tests
	@Test (expected = AssertionError.class)
	public void nullUserName(){
		Verhuurder v = new Verhuurder(null, "piet");
	}
	
	@Test (expected = AssertionError.class)
	public void nullPassword(){
		Verhuurder v = new Verhuurder("hee", null);
	}
	
	@Test (expected = AssertionError.class)
	public void emptyUserName(){
		Verhuurder v = new Verhuurder("", "piet");
	}
	
	@Test (expected = AssertionError.class)
	public void emptyPassword(){
		Verhuurder v = new Verhuurder("hee", "");
	}
	
	@Test (expected = AssertionError.class)
	public void nullkamer(){
		Verhuurder v = new Verhuurder(null, "piet");
		v.hasRoom(null);
	}
	
	

	
}
