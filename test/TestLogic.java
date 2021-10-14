import junit.framework.TestCase;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TestLogic extends TestCase{
	Cat cat = new Cat();
	
	@Test
	public void testStartingCatAge() {
		assertTrue(cat.age >= 5);
		assertTrue(cat.age <= 10);
		
		//System.out.println("Starting cat age tested.");
	}
	
	@Test
	public void testStartingCatName() {
		assertEquals("", cat.name);
		
		//System.out.println("Starting cat name tested.");
	}

	@Test
	public void testCatSetName() {
		String name1 = "test name 1";
		String name2 = "test name 2";
		
		//"Correct" Tests
		assertEquals("test name 1", cat.setName(name1));
		assertEquals("test name 2", cat.setName(name2));
		//"Breaking" Tests
		assertNotEquals("test", cat.setName(name1));
		assertNotEquals("test", cat.setName(name2));
		
		//System.out.println("Set cat name tested.");
	}
	
	//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Find better test, this one sometimes gives a false negative
	@Test
	public void testCatSetRandName() {
		String name1 = cat.setRandName();
		String name2 = cat.setRandName();

		assertNotSame(name1, cat.setRandName());
		assertNotSame(name2, cat.setRandName());
		
		//System.out.println("Set cat random name tested.");
	}
	
	@Test
	public void testCatSpeak() {
		String meow1 = "miau";
		String meow2 = "nya";
		
		//"Correct" Tests
		cat.speak(null);
		assertEquals("meow", cat.speak);
		cat.speak(meow1);
		assertEquals("miau", cat.speak);
		cat.speak(meow2);
		assertEquals("nya", cat.speak);
		
		//System.out.println("Cat speak tested.");
	}
}
