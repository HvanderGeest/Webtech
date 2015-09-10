package nl.saxion.junittesten;

import static org.junit.Assert.*;

import org.junit.Test;

import nl.saxion.model.Kamer;
import nl.saxion.model.Model;
import nl.saxion.model.Verhuurder;

public class ModelTest {

	@Test
	public void testMooiWeer() {
		Model model = new Model();
		Verhuurder v = new Verhuurder("piet", "wachtwoord");
		model.addUser(v);
		assertTrue(model.getUsers().contains(v));
		assertEquals(v, model.getUser("piet"));
		model.addRoom(12, 2, "nederland", v);
		assertEquals(model.getLandlord(model.searchRooms(1, 40, "nederland").get(0)), v );
		assertTrue(model.userNameExists("piet"));
		assertFalse(model.userNameExists("henk"));
		
	}
	
	//badweather tests
	@Test (expected = AssertionError.class)
	public void testNullpointerVerhuurder (){
		Model model = new Model();
		model.addRoom(2, 2, "nederland", null);
	}
	
	@Test (expected = AssertionError.class)
	public void TestNullpointerUser(){
		Model model = new Model();
		model.addUser(null);
	}
	
	@Test (expected = AssertionError.class)
	public void TestNullpointerKamer(){
		Model model = new Model();
		model.getLandlord(null);
	}
	
	@Test (expected = AssertionError.class)
	public void TestNullUserNameGetUser(){
		Model model = new Model();
		model.getUser(null);
	}
	
	@Test (expected = AssertionError.class)
	public void TestEmptyUserNameGetUser(){
		Model model = new Model();
		model.getUser("");
	}
	
	@Test (expected = AssertionError.class)
	public void TestNullUserNameExists(){
		Model model = new Model();
		model.userNameExists(null);
	}
	
	@Test (expected = AssertionError.class)
	public void TestEmptyUserNameExists(){
		Model model = new Model();
		model.userNameExists("");
	}
	
	@Test (expected = AssertionError.class)
	public void TestNullCountry(){
		Model model = new Model();
		model.searchRooms(3, 4, null);
	}
	
	@Test (expected = AssertionError.class)
	public void TestEmptyCountry(){
		Model model = new Model();
		model.searchRooms(3, 4, "");
	}
	
	
	

}
